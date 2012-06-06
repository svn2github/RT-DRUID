package com.eu.evidence.rtdruid.modules.oil.codewriter.common.xsltcodegeneration;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.w3c.dom.CDATASection;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Text;

import com.eu.evidence.rtdruid.desk.Messages;
import com.eu.evidence.rtdruid.internal.modules.oil.exceptions.OilCodeWriterException;
import com.eu.evidence.rtdruid.internal.modules.oil.reader.OilReader;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilObjectList;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilWriterBuffer;
import com.eu.evidence.rtdruid.modules.oil.abstractions.ISimpleGenRes;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.AbstractRtosWriter;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.OilWriterBuffer;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.SWCategoryManager;
import com.eu.evidence.rtdruid.modules.oil.implementation.IOilImplID;
import com.eu.evidence.rtdruid.modules.oil.interfaces.ISWCategory;
import com.eu.evidence.rtdruid.modules.oil.interfaces.ISectionWriter;
import com.eu.evidence.rtdruid.modules.oil.interfaces.ISectionWriterWithOptions;
import com.eu.evidence.rtdruid.modules.oil.transform.IOilTransform;
import com.eu.evidence.rtdruid.modules.oil.transform.OilTransformFactory;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.tools.Search;

/**
 * General purpose writer that converts an xml version 
 * of oil file, into another xml (that respect finalOutput.dtd),
 * through one or more xslt transformations.   
 * 
 *
 */
public abstract class XsltWriter implements ISectionWriter, ISectionWriterWithOptions {
	
	protected final boolean Stdo_debug = false;
	
	
	protected String writerId;
	protected String oilId;
	protected ISWCategory category;
	
	protected IVarTree vt;
	protected Map<String, IOilObjectList> rtosPrefix;
	protected HashMap<String, Object> opt;
	
	protected XsltComponent transformation;
	
	protected IXsltDebugger debugger;
	
	public XsltWriter(String writerId, ISWCategory category) {
		this.writerId = writerId;
		this.category = category == null ? SWCategoryManager.EMPTY_CATEGORY : category;
		debugger = Stdo_debug ? new StdoXsltDebugger() : new NullXsltDebugger();
		opt = new HashMap<String, Object>();
	}
	
	@Override
	public void initOptions(Map<String, Object> options) {
		opt.clear();
		if (options != null) {
			opt.putAll(options);
		}
	}

	public void setDebugger(IXsltDebugger debugger) {
		this.debugger = debugger;
	}
	
	public void setOilId(String oilId) {
		this.oilId = oilId;
	}
	
	public String getId() {
		return writerId;
	}
	
	public ISWCategory getCategory() {
		return category;
	}
	
	public IXsltDebugger getDebugger() {
		return debugger;
	}
	
	public IOilWriterBuffer[] write(IVarTree vt) throws OilCodeWriterException {
		this.vt = vt;
		if (transformation != null) {
			
			Document document;
			try {
				IOilImplID implID = OilTransformFactory.INSTANCE.getOilId(oilId);
				IOilTransform transformer =  OilTransformFactory.INSTANCE.getTransform(oilId);
				
				computeRtos();
				if (rtosPrefix == null || rtosPrefix.isEmpty()) {
					return null;
				}
				
				String txt = transformer.write(vt, implID, getPaths(rtosPrefix, 0).toArray(new String[0]));
//				System.out.println(txt);
				document = (new OilReader()).loadAsXml(new ByteArrayInputStream(txt.getBytes()), null, null);
				
			} catch (Exception e) {
//				e.printStackTrace();
				throw new OilCodeWriterException(e.getMessage(),e);
			}
			
			if (debugger != null) {
				debugger.log(transformation, null, document);
			}
			
			ArrayList<Document> intermediate = transformation.transform(document, debugger);
			return finalizeGeneration(intermediate);
		}
		return null;
	}

	private List<String> getPaths(Map<String, IOilObjectList> all, int index) {
		if (index >= all.size()) {
			throw new ArrayIndexOutOfBoundsException();
		}
		
		IOilObjectList ool = all.values().toArray(new IOilObjectList[all.size()])[index];
		ArrayList<String> answer = new ArrayList<String>();
		for (ISimpleGenRes sgros: ool.getList(IOilObjectList.OS)) {
			answer.add(sgros.getPath());
		}
		return answer;
	}

	public void setTransformation(XsltComponent transformation) {
		this.transformation = transformation;
	}
	
	protected void computeRtos() {
		if (rtosPrefix == null) {
			rtosPrefix = AbstractRtosWriter.extractDistinctOs(vt, Search.allRtos(vt.newTreeInterface()));
		}
	}
	
	/** @return a not null map used to connect a cpu to a buffer */
	protected HashMap<String, IOilWriterBuffer> getMap(IOilWriterBuffer[] buffers) {
		HashMap<String, IOilWriterBuffer> map = new HashMap<String, IOilWriterBuffer>();
		for (int i=0; i<buffers.length && i<rtosPrefix.size(); i++) {
			for (String s:getPaths(rtosPrefix, i)) {
				map.put(s, buffers[i]);
			}
		}
		return map;
	}

	/** @return the default buffer (in a multi cpu system, is the master cpu) */
	protected IOilWriterBuffer getDefaultBuffer(IOilWriterBuffer[] buffers) {
		return buffers[0];
	}

	protected IOilWriterBuffer[] finalizeGeneration(ArrayList<Document> documents) throws OilCodeWriterException {
		
		IXsltParameterProvider paramProvider = XsltWriterTransfFactory.getParameters();
		paramProvider.setOptions(opt);
		Map<String, IXsltParameter> parameters = paramProvider.getAllAsMap();
		
		
		
		// init buffers
		IOilWriterBuffer[] answer = new IOilWriterBuffer[rtosPrefix.size()];
		for (int i=0; i<answer.length; i++) {
			answer[i] = new OilWriterBuffer();
		}
		HashMap<String, IOilWriterBuffer> map = getMap(answer);
		IOilWriterBuffer defaultBuf = getDefaultBuffer(answer);
		
		for (Document doc: documents) {
			if (debugger != null) {
				debugger.log("\nFinalize :");
				debugger.log(null, null, doc);
			}
	
			Element root = doc.getDocumentElement();
			if (root != null) {
				for (Node child = root.getFirstChild(); child != null; child = child.getNextSibling()) {
					if (child instanceof Element && "OUTPUT_BUFFER".equalsIgnoreCase(child.getNodeName())) {
						Element echild = (Element) child;
						String cpuName = echild.hasAttribute("cpuId") ? echild.getAttribute("cpuId") : null;
						String buffName = echild.getAttribute("name");
						
						IOilWriterBuffer buf;
						if (cpuName == null) {
							buf = defaultBuf;
						} else {
							if (!map.containsKey(cpuName)) {
								throw new OilCodeWriterException("Xslt writer " + writerId + " : cannot find the buffer related to cpu " + cpuName );
							}
							buf = map.get(cpuName);
						}
						
						for(Node text = echild.getFirstChild(); text != null; text = text.getNextSibling()) {
							String data = null;
							if ( text instanceof CDATASection) {
								data = ((CDATASection) text).getWholeText();
							} else if (text != null && text instanceof Text) {
								data = ((Text) text).getWholeText();
							} else if (text instanceof Element && "PARAMETER".equalsIgnoreCase(text.getNodeName())) {
								String paramName = ((Element)text).getAttribute("name");
								if (parameters.containsKey(paramName)) {
									data = parameters.get(paramName).getValue();
									if (data == null || data.isEmpty()) {
										if (((Element)text).hasAttribute("default")) {
											data = ((Element)text).getAttribute("default");
										}
									}
								} else {
									Messages.sendWarningNl("Xslt writer " + writerId + " : cannot find required parameter (buff name=" + buffName + ", cpu name=" + cpuName +", parameter name=" + paramName );
								}
							} else {
								throw new OilCodeWriterException("Xslt writer " + writerId + " : expected some text inside OUTPUT_BUFFER (buff name=" + buffName + ", cpu name=" + cpuName );
							}
							
							if (data != null) {
								buf.append(buffName, data);
							}
						}
					}
				}
			}
		}
		
		return answer; 
	}
	
}
