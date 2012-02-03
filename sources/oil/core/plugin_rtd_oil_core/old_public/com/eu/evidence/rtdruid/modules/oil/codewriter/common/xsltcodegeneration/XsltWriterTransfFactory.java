package com.eu.evidence.rtdruid.modules.oil.codewriter.common.xsltcodegeneration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamSource;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;
import org.w3c.dom.Document;

import com.eu.evidence.rtdruid.desk.RtdruidLog;

/**
 * This class is a factory that collect all available xslt trasformations used
 * by xslt writers
 * 
 */
public class XsltWriterTransfFactory {

	public static class PluginXsltWriterTransgormation extends AXsltWriterTransgormation {
		protected final Bundle parent;
		protected final String file;
		protected File osFile = null;
		
		public PluginXsltWriterTransgormation(String id, Bundle parent, String file) {
			super(id);
			this.parent = parent;
			this.file = file;
		}

		protected File getTransformationFile() {
			if (osFile == null) {
				try {
					File f = FileLocator.getBundleFile(parent);
					String bundlePath = null;
					if (f != null) {
						bundlePath = f.getAbsolutePath();
					}
	//buffer.append("_____Bundle path = "+bundlePath +"\n");
					File base = new File(bundlePath + File.separatorChar + file);
					if (base.exists() && base.canRead()) {
						osFile = base;
	//buffer.append("_____base path = "+base.getAbsolutePath() +"\n");
					}
				} catch (IOException e) {
					RtdruidLog.log(e);
					return null;
				}
			}
			return osFile;
		}

		public InputStream getTransformation() {
			try {
				return FileLocator.openStream(parent, new Path(file), false);
			} catch (IOException e) {
				RtdruidLog.log(e);
				return null;
			}
		}
	}

	public static class FileXsltWriterTransgormation extends AXsltWriterTransgormation {
		protected final String file;

		public FileXsltWriterTransgormation(String id, String file) {
			super(id);
			this.file = file;
		}
		
		protected File getTransformationFile() {
			return new File(file);
		}

		public InputStream getTransformation() {
			File f = new File(file);
			try {
				return new FileInputStream(f);
			} catch (Exception e) {
				RtdruidLog.log(e);
			}
			return null;
		}
	}

	public static abstract class AXsltWriterTransgormation implements IXsltWriterTransformation {
		
		protected final String id;
		
		public AXsltWriterTransgormation(String id) {
			this.id = id;
		}
		
		abstract public InputStream getTransformation();
		
		abstract protected File getTransformationFile();

		public String getId() {
			return id;
		}
		
		public Document transform(Document doc) {
			
			Document output = null;
			
			DocumentBuilderFactory docFactory = DocumentBuilderFactory
					.newInstance();

			try {
				output = docFactory.newDocumentBuilder().newDocument();
			} catch (ParserConfigurationException e) {
				throw new IllegalStateException(
						"OilParser: exception during creation of a new Document:\n\t"
								+ e.getMessage());
			}


			InputStream transformation = getTransformation();
			if (transformation != null) {
				try {
					// Create a transform factory instance.
					TransformerFactory tfactory = TransformerFactory
							.newInstance();
	
					// Create a transformer for the stylesheet.
					StreamSource xsltSource = new StreamSource(transformation);
					File f = getTransformationFile();
					if (f != null) {
						xsltSource.setSystemId(f);
					}
					Transformer transformer = tfactory
							.newTransformer(xsltSource);
	
					// Transform the source XML
					transformer.transform(new DOMSource(doc),
							new DOMResult(output));
				} catch (TransformerConfigurationException e) {
					RtdruidLog.showDebug(e);
	
				} catch (TransformerException e) {
					RtdruidLog.showDebug(e);
	
				}
			}
			return output;
		}

	}


	
	//-------------------------------------------
	
	
	protected ComposedXsltParameterProvider parameters = new  ComposedXsltParameterProvider();
	
	protected static final XsltWriterTransfFactory defaultInstance = new XsltWriterTransfFactory();
	
	protected HashMap<String, IXsltWriterTransformation> steps = new HashMap<String, IXsltWriterTransformation>();
	
	public static IXsltParameterProvider getParameters() {
		return defaultInstance.parameters;
	}
	
	public static String[] getAllId() {
		Set<String> keys = defaultInstance.steps.keySet();
 		return keys.toArray(new String[keys.size()]);
	}
	
	public static IXsltWriterTransformation[] getAll() {
		Collection<IXsltWriterTransformation> values = defaultInstance.steps.values();
 		return values.toArray(new IXsltWriterTransformation[values.size()]);
	}
	
	public static IXsltWriterTransformation get(String localTransformationId) {
//		defaultInstance.steps.clear();
//		defaultInstance.loadSteps();
		return defaultInstance.steps.get(localTransformationId);
	}

	public static XsltWriterTransfFactory getDefaultInstance() {
		return defaultInstance;
	}
	
	
	
	//-------------------------------------------
	
	
	
	protected XsltWriterTransfFactory() {
		loadSteps();
		loadParameters();
	}
	
	
	
	protected void loadSteps() {
		IConfigurationElement[] config = Platform.getExtensionRegistry()
				.getConfigurationElementsFor(
						"com.eu.evidence.rtdruid.oil.core.xsltWriterStep");
		assert (config != null);
		int l = config.length;
		
//buffer.append("Config.length = " + config.length + "\n");
		for (int i = 0; i < l; i++) {
//buffer.append("\n__" + i + " = " + config[i].getName() + "  " + config[i] +"\n");
			if ("Step".equalsIgnoreCase(config[i].getName())) {
				String bundleName = "";
				String xsltId = "";
				String xsltFile = "";
				try {
					xsltId = config[i].getAttribute("stepId");
					xsltFile = config[i].getAttribute("xsltFile");
					
//buffer.append("_____Base" + " = " + fileName +"\n");
					if (xsltFile == null || xsltId == null) {
						continue;
					}

					bundleName = config[i].getContributor().getName();
					Bundle bundle = Platform.getBundle(bundleName);
					assert (bundle != null);
					
					if (FileLocator.find(bundle, new Path(xsltFile),
							new HashMap()) == null) {
//buffer.append("_____Bundle not found" +"\n");
						continue;
					}
//					File f = FileLocator.getBundleFile(bundle);
//					String bundlePath = null;
//					if (f != null) {
//						bundlePath = f.getAbsolutePath();
//					}
////buffer.append("_____Bundle path = "+bundlePath +"\n");
//					File base = new File(bundlePath + File.separatorChar + fileName);
//					if (base.exists() && base.canRead()) {
//						answer.add(base.getAbsolutePath());
////buffer.append("_____base path = "+base.getAbsolutePath() +"\n");
//					}
					
					steps.put(xsltId, new PluginXsltWriterTransgormation(xsltId,bundle, xsltFile));
					
				} catch (Exception e) {
					RtdruidLog.log("Unable to get the specified xsl transformation file:\n bundle= " + 
							bundleName + "\n id= " + xsltId + " file="+xsltFile,
							e);
				}
			}
		}
//buffer.append("\n Res = "+answer +"\n");
//RtdruidLog.log(buffer.toString());
//System.out.println(buffer.toString());
		
	}

	protected void loadParameters() {
		IConfigurationElement[] config = Platform.getExtensionRegistry()
				.getConfigurationElementsFor(
						"com.eu.evidence.rtdruid.oil.core.xsltWriterStep");
		assert (config != null);
		int l = config.length;
		
		for (int i = 0; i < l; i++) {
			final IConfigurationElement ce = config[i];
			if ("ParameterProvider".equalsIgnoreCase(ce.getName())) {
				String bundleName = "";
				String provider = "";
				try {
					provider = ce.getAttribute("provider");
					
					if (provider == null) {
						continue;
					}

					bundleName = ce.getContributor().getName();
					Bundle bundle = Platform.getBundle(bundleName);
					assert (bundle != null);
					
					Object o = ((IConfigurationElement)ce).createExecutableExtension("provider");
					if ( (o != null) && (o instanceof IXsltParameterProvider) ) {
						parameters.add((IXsltParameterProvider)o);
					}
					
				} catch (Exception e) {
					RtdruidLog.log("Unable to get the specified xsl parameter provider:\n bundle= " + 
							bundleName + "\n provider="+provider,
							e);
				}
			}		}
//buffer.append("\n Res = "+answer +"\n");
//RtdruidLog.log(buffer.toString());
//System.out.println(buffer.toString());
		
	}

	
	//--------------------------

	private ArrayList<IModelListener> modelListeners = new ArrayList<IModelListener>();

	public void addModelListener(IModelListener listener) {
		if (!modelListeners.contains(listener))
			modelListeners.add(listener);
	}
	public void removeModelListener(IModelListener listener) {
		modelListeners.remove(listener);
	}
	public void fireModelChanged(IXsltWriterTransformation[] objects, String type, String property) {
		for (int i = 0; i < modelListeners.size(); i++) {
			((IModelListener) modelListeners.get(i)).modelChanged(objects,
					type, property);
		}
	}

	public static void add(
			IXsltWriterTransformation tranfosrmation) {
		if (tranfosrmation == null) {
			return;
		}
		
		if (defaultInstance.steps.containsKey(tranfosrmation.getId())) {
			throw new RuntimeException("Double transformation ID: "+tranfosrmation.getId());
		}
		defaultInstance.steps.put(tranfosrmation.getId(), tranfosrmation);
		defaultInstance.fireModelChanged(new IXsltWriterTransformation[]{tranfosrmation},
				IModelListener.ADDED, "");
	}

}
