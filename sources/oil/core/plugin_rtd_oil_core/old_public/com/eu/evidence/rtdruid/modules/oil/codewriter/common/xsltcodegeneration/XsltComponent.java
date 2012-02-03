package com.eu.evidence.rtdruid.modules.oil.codewriter.common.xsltcodegeneration;

import java.util.ArrayList;

import org.w3c.dom.Document;

import com.eu.evidence.rtdruid.desk.Messages;

/**
 * This is a step of the xslt code generation, i.e. corresponds to one xslt
 * transformation. It can point to further steps, and each further step listed
 * here is to be considered to be executed on the same value, that is the result
 * of the transformation done here.
 * 
 * 
 */
public class XsltComponent {

	protected final String localTransformationId;
	protected ArrayList<XsltComponent> furtherTransformations = new ArrayList<XsltComponent>();

	public XsltComponent(String id) {
		this.localTransformationId = id;
	}

	/**
	 * Adds a new step that is executed after the transformation done here. Note
	 * that, even if not recommended, the same element can be added more than one time, and then is
	 * executed twice. 
	 * 
	 * 
	 * @param nextStep
	 */
	public void addTransformation(XsltComponent nextStep) {
		furtherTransformations.add(nextStep);
	}
	/**
	 * Remove a step. If it is present twice, it removed once.
	 * 
	 * @param nextStep
	 */
	public void removeTransformation(XsltComponent step) {
		furtherTransformations.remove(step);
	}
	
	public String getLocalTransformationId() {
		return localTransformationId;
	}
	
	public ArrayList<XsltComponent> getFurtherTransformations() {
		return furtherTransformations;
	}
	
	
//	public ArrayList<Document> transform(Document input) {
//		return transform(input, null);
//	}
	public ArrayList<Document> transform(Document input, IXsltDebugger debugger) {

		ArrayList<Document> answer = new ArrayList<Document>();
		
		Document output;
		if (localTransformationId != null) {
			try {
				IXsltWriterTransformation lTranf = XsltWriterTransfFactory.get(localTransformationId);
				output = lTranf == null ? null : lTranf.transform(input);
			} catch (Exception e) {
				Messages.sendError(e.getMessage(), null, "xsltComponent1", null);
				return answer;
			}
			if (debugger != null) {
				debugger.log(this, input, output);
			}
		} else {
			output = input;
		}
		
		if (output == null) {
			return answer;
		}
		
		if (furtherTransformations.size() == 0) {
			answer.add(output);
		} else {
			for (XsltComponent step: furtherTransformations) {
				try { 
					ArrayList<Document> tmp = step.transform(output, debugger);
					if (tmp != null) {
						answer.addAll(tmp);
					}
				} catch (Exception e) {
					Messages.sendError(e.getMessage(), null, "xsltComponent2", null);
					continue;
				}
			}
		}
		return answer;
	}

}
