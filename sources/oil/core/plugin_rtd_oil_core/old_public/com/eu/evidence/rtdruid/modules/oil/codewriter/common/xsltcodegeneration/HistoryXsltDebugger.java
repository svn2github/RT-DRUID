package com.eu.evidence.rtdruid.modules.oil.codewriter.common.xsltcodegeneration;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.w3c.dom.Document;

import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilWriterBuffer;
import com.eu.evidence.rtdruid.vartree.IVarTree;

public class HistoryXsltDebugger implements IXsltDebugger {

	

	public class IntermediateOutput {
		
		protected final String input;
		protected final String output;
		
		protected final XsltComponent element;
		
		public IntermediateOutput(XsltComponent element, Document input, Document output) {
			if (input != null) {
				ByteArrayOutputStream tmpInput = new ByteArrayOutputStream();
				XsltUtils.writeXml(input, tmpInput);
				this.input = tmpInput.toString();
			} else {
				this.input = null;
			}
			if (output != null) {
				ByteArrayOutputStream tmpOutput = new ByteArrayOutputStream();
				XsltUtils.writeXml(output, tmpOutput);
				this.output = tmpOutput.toString();
			} else {
				this.output = null;
			}
			this.element = element;
		}
		
		public IntermediateOutput(XsltComponent element, String input, String output) {
			this.input = input;
			this.output = output;
			this.element = element;
		}
		
		
		public XsltComponent getElement() {
			return element;
		}
		
		public String getInput() {
			return input;
		}
		
		public String getOutput() {
			return output;
		}
		
	}
	protected HashMap<XsltComponent, IntermediateOutput> intermediateOutputs = new HashMap<XsltComponent, IntermediateOutput>();
	
	ArrayList<String> warnings = new ArrayList<String>(); 
	ArrayList<String> errors = new ArrayList<String>();
	
	LinkedList<Object> sequence = new LinkedList<Object>();
	
	String varTree;
	IOilWriterBuffer[] outputs;
	
	
	public void log(String txt) {
		sequence.add(txt);
	}

	public void log(XsltComponent transformation, Document input,
			Document output) {
		
		IntermediateOutput step = new IntermediateOutput(transformation, input, output);
		sequence.add(step);
		
		if (transformation != null) {
			intermediateOutputs.put(transformation, step);
		}
	}

	public void logError(String txt) {
		sequence.add(txt);
		errors.add(txt);
	}

	public void logWarning(String txt) {
		sequence.add(txt);
		warnings.add(txt);
	}
	
	public void setVarTree(IVarTree vt) {
		//this.varTree = ;
	}
	public void setOutputs(IOilWriterBuffer[] outputs) {
		this.outputs = outputs;
	}
	public IOilWriterBuffer[] getOutputs() {
		return outputs;
	}
	
	
	// -----------------------
	
	public Map<XsltComponent, IntermediateOutput> getIntermediateOutputs() {
		return  Collections.unmodifiableMap(intermediateOutputs);
	}
	
	public List<Object> getSequence() {
		return Collections.unmodifiableList(sequence);
	}
	
	public List<String> getWarnings() {
		return Collections.unmodifiableList(warnings);
	}
	
	public List<String> getErrors() {
		return Collections.unmodifiableList(errors);
	}

}
