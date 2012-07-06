package com.eu.evidence.rtdruid.test.modules.oil.xtext.parser;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipselabs.xtext.utils.unittesting.XtextTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.eu.evidence.rtdruid.oil.xtext.model.OilFile;
import com.eu.evidence.rtdruid.oil.xtext.services.OilModelLoader;

@RunWith(value = Parameterized.class)
public class ParsingNumberValuesTests extends XtextTest {
	
	private static ArrayList<Object[]> values;
	
	
	private static void initValues() {
		values = new ArrayList<Object[]>();
		values.add(new String[] {"IMPLEMENTATION a { OS {\n"+
						"INT32[-1,0..1] b1;\n"+
					"}; };"});
		values.add(new String[] {"IMPLEMENTATION a { OS {\n"+
						"INT32[] b1;\n"+
					"}; };"});
		values.add(new String[] {"IMPLEMENTATION a { OS {\n"+
						"INT32[\"abc\",2] b1;\n"+
					"}; };"});
		values.add(new String[] {"IMPLEMENTATION a { OS {\n"+
						"INT32[0,abc] b1;\n"+
					"}; };"});
		values.add(new String[] {"IMPLEMENTATION a { OS {\n"+
						"INT32[0,\"abc\"] b1;\n"+
					"}; };"});
		values.add(new String[] {"IMPLEMENTATION a { OS {\n"+
						"INT32[1,\"abc\"] b1;\n"+
					"}; };"});
		values.add(new String[] {"IMPLEMENTATION a { OS {\n"+
						"INT32[1,0..] b1;\n"+
					"}; };"});
		values.add(new String[] {"IMPLEMENTATION a { OS {\n"+
						"INT32[1,..] b1;\n"+
					"}; };"});
		values.add(new String[] {"IMPLEMENTATION a { OS {\n"+
						"INT32[..,1] b1;\n"+
					"}; };"});
					
		values.add(new String[] {"IMPLEMENTATION a { OS {\n"+
				"UINT32[-1,0..1] b1;\n"+
					"}; };"});
		values.add(new String[] {"IMPLEMENTATION a { OS {\n"+
						"UINT32[] b1;\n"+
					"}; };"});
		values.add(new String[] {"IMPLEMENTATION a { OS {\n"+
						"UINT32[\"abc\",2] b1;\n"+
					"}; };"});
		values.add(new String[] {"IMPLEMENTATION a { OS {\n"+
						"UINT32[0,abc] b1;\n"+
					"}; };"});
		values.add(new String[] {"IMPLEMENTATION a { OS {\n"+
						"UINT32[0,\"abc\"] b1;\n"+
					"}; };"});
		values.add(new String[] {"IMPLEMENTATION a { OS {\n"+
						"UINT32[1,\"abc\"] b1;\n"+
					"}; };"});
		values.add(new String[] {"IMPLEMENTATION a { OS {\n"+
						"UINT32[1,0..] b1;\n"+
					"}; };"});
		values.add(new String[] {"IMPLEMENTATION a { OS {\n"+
						"UINT32[1,..] b1;\n"+
					"}; };"});
		values.add(new String[] {"IMPLEMENTATION a { OS {\n"+
						"UINT32[..,1] b1;\n"+
					"}; };"});
		
		values.add(new String[] {"IMPLEMENTATION a { OS {\n"+
				"INT64[-1,0..1] b1;\n"+
			"}; };"});
		values.add(new String[] {"IMPLEMENTATION a { OS {\n"+
				"INT64[] b1;\n"+
			"}; };"});
		values.add(new String[] {"IMPLEMENTATION a { OS {\n"+
				"INT64[\"abc\",2] b1;\n"+
			"}; };"});
		values.add(new String[] {"IMPLEMENTATION a { OS {\n"+
				"INT64[0,abc] b1;\n"+
			"}; };"});
		values.add(new String[] {"IMPLEMENTATION a { OS {\n"+
				"INT64[0,\"abc\"] b1;\n"+
			"}; };"});
		values.add(new String[] {"IMPLEMENTATION a { OS {\n"+
				"INT64[1,\"abc\"] b1;\n"+
			"}; };"});
		values.add(new String[] {"IMPLEMENTATION a { OS {\n"+
				"INT64[1,0..] b1;\n"+
			"}; };"});
		values.add(new String[] {"IMPLEMENTATION a { OS {\n"+
				"INT64[1,..] b1;\n"+
			"}; };"});
		values.add(new String[] {"IMPLEMENTATION a { OS {\n"+
				"INT64[..,1] b1;\n"+
			"}; };"});
		
		values.add(new String[] {"IMPLEMENTATION a { OS {\n"+
				"UINT64[-1,0..1] b1;\n"+
			"}; };"});
		values.add(new String[] {"IMPLEMENTATION a { OS {\n"+
				"UINT64[] b1;\n"+
			"}; };"});
		values.add(new String[] {"IMPLEMENTATION a { OS {\n"+
				"UINT64[\"abc\",2] b1;\n"+
			"}; };"});
		values.add(new String[] {"IMPLEMENTATION a { OS {\n"+
				"UINT64[0,abc] b1;\n"+
			"}; };"});
		values.add(new String[] {"IMPLEMENTATION a { OS {\n"+
				"UINT64[0,\"abc\"] b1;\n"+
			"}; };"});
		values.add(new String[] {"IMPLEMENTATION a { OS {\n"+
				"UINT64[1,\"abc\"] b1;\n"+
			"}; };"});
		values.add(new String[] {"IMPLEMENTATION a { OS {\n"+
				"UINT64[1,0..] b1;\n"+
			"}; };"});
		values.add(new String[] {"IMPLEMENTATION a { OS {\n"+
				"UINT64[1,..] b1;\n"+
			"}; };"});
		values.add(new String[] {"IMPLEMENTATION a { OS {\n"+
				"UINT64[..,1] b1;\n"+
			"}; };"});
		
		values.add(new String[] {"IMPLEMENTATION a { OS {\n"+
				"FLOAT[-1,0..1] b1;\n"+
			"}; };"});
		values.add(new String[] {"IMPLEMENTATION a { OS {\n"+
				"FLOAT[] b1;\n"+
			"}; };"});
		values.add(new String[] {"IMPLEMENTATION a { OS {\n"+
				"FLOAT[\"abc\",2] b1;\n"+
			"}; };"});
		values.add(new String[] {"IMPLEMENTATION a { OS {\n"+
				"FLOAT[0,abc] b1;\n"+
			"}; };"});
		values.add(new String[] {"IMPLEMENTATION a { OS {\n"+
				"FLOAT[0,\"abc\"] b1;\n"+
			"}; };"});
		values.add(new String[] {"IMPLEMENTATION a { OS {\n"+
				"FLOAT[1,\"abc\"] b1;\n"+
			"}; };"});
		values.add(new String[] {"IMPLEMENTATION a { OS {\n"+
				"FLOAT[1,0..] b1;\n"+
			"}; };"});
		values.add(new String[] {"IMPLEMENTATION a { OS {\n"+
				"FLOAT[1,..] b1;\n"+
			"}; };"});
		values.add(new String[] {"IMPLEMENTATION a { OS {\n"+
				"FLOAT[..,1] b1;\n"+
			"}; };"});

	}
	
	@Parameters
	public static Collection<Object[]> data() {
		if (values == null) {
			initValues();
		}
		return values;
	 }
	
	private String text;
	
	/**
	 * 
	 */
	public ParsingNumberValuesTests(String txt) {
		text = txt;
	}

	
		@Test
	public void wrongRange() throws Exception {
			
		OilFile model = OilModelLoader.instance.load(text);
		
		Resource resource = model.eResource();
		assertEquals(text, 1, resource.getErrors().size());
		assertEquals(0, resource.getWarnings().size());
//		System.out.println(">>" + text + "\n\t" + resource.getErrors());
	}
		
}

