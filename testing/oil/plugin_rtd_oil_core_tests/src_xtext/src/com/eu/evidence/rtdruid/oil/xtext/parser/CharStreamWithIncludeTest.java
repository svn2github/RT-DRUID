/**
 * 17/lug/2012
 */
package com.eu.evidence.rtdruid.oil.xtext.parser;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import org.antlr.runtime.CommonToken;
import org.eclipse.emf.common.util.URI;
import org.junit.Test;

/**
 *
 * @author Nicola Serreli
 * @since 2.0
 *
 */
public class CharStreamWithIncludeTest {
	
	final static String[] textElem = {
			"main", // 0
				" include1\n<", // 1
					"includeA<>\nendA", // 2
				">end\n1", // 3
			"text_\n", // 4
				"include2<>end2", // 5
			"^abc" // 6
	};
	enum Section {
		main("main", null, 0,4,6), include1("1", new CommonToken(1), 1,3), include1_A("1A", new CommonToken(11), 2), include2("2", new CommonToken(2), 5);
		
		final protected String name;
		final protected int[] values;
		final protected CommonToken t;
		/**
		 * 
		 */
		private Section(String name, CommonToken t, int ... values) {
			this.name = name;
			this.values = values;
			this.t = t;
		}
		
		public String getText() {
			return composeText(values);
		}
		
		
		public static String composeText(List<Section> elements) {
			return composeText(compose(elements));
		}
			
		public static String composeText(int ... indexes) {
			StringBuilder builder = new StringBuilder();
			for (int i : indexes) {
				builder.append(textElem[i]);
			}
			return builder.toString();
		}

		public static int[] compose(List<Section> elements) {
			TreeSet<Integer> set = new TreeSet<Integer>();
			for (Section s : elements) {
				for (int i:s.values) {
					set.add(i);
				}
			}
			int[] answer = new int[set.size()];
			int index = 0;
			for (Integer i: set) {
				answer[index] = i;
				index++;
			}
			return answer;
		}

	};
	
	protected void addStream(CharStreamWithInclude stream, Section s, ArrayList<Section> elements) {
		stream.setStream(URI.createFileURI(s.name), s.getText().toCharArray(), s.t);
		elements.add(s);
		checkSize(stream, elements);
	}

	@Test
	public void testTripleIncludeError() throws IOException {

		CharStreamWithInclude stream = new CharStreamWithInclude();
		
		assertEquals(0, stream.size());
		
		ArrayList<Section> elements = new ArrayList<Section>();
		{
			addStream(stream, Section.main, elements);
			consumeMaster(stream, new int[] {0}, new int[]{}, new int[]{});
			{
				final int globalIndex = textElem[0].length();
				final int localIndex = textElem[0].length();
				final int mark = stream.mark();
				
				consumeMaster(stream, new int[] {4, 6}, new int[]{0}, new int[]{0});
				stream.rewind(mark);
				
				assertEquals(globalIndex, stream.index());
				assertEquals(localIndex, stream.getLocalIndex());
			}
		}
		
		{
			addStream(stream, Section.include1, elements);
			consumeInclude(stream, new int[] {1}, new int[]{0}, new int[]{0});
			{
				final int globalIndex = Section.composeText(0,1).length();
				final int localIndex = Section.composeText(0).length();
				final int mark = stream.mark();

				consumeInclude(stream, new int[] {3}, new int[]{0,1}, new int[]{0});
				consumeMaster(stream, new int[] {4, 6}, new int[]{0,1,3}, new int[]{0});
				
				stream.rewind(mark);
				assertEquals(globalIndex, stream.index());
				assertEquals(localIndex, stream.getLocalIndex());
			}
		}

		{
			addStream(stream, Section.include1_A, elements);
			consumeInclude(stream, new int[] {2}, new int[]{0,1}, new int[]{0});
			{
				final int globalIndex = Section.composeText(0,1,2).length();
				final int localIndex = Section.composeText(0).length();
				final int mark = stream.mark();

				consumeInclude(stream, new int[] {3}, new int[]{0,1,2}, new int[]{0});
				consumeMaster(stream, new int[] {4, 6}, new int[]{0,1,2,3}, new int[]{0});
				
				stream.rewind(mark);
				assertEquals(globalIndex, stream.index());
				assertEquals(localIndex, stream.getLocalIndex());
			}
		}

		{
			consumeInclude(stream, new int[] {3}, new int[]{0,1,2}, new int[]{0});
			{
				final int globalIndex = Section.composeText(0,1,2,3).length();
				final int localIndex = Section.composeText(0).length();
				final int mark = stream.mark();

				consumeMaster(stream, new int[] {4, 6}, new int[]{0,1,2,3}, new int[]{0});
				
				stream.rewind(mark);
				assertEquals(globalIndex, stream.index());
				assertEquals(localIndex, stream.getLocalIndex());
			}
		}
		
		{
			consumeMaster(stream, new int[] {4}, new int[]{0,1,2,3}, new int[]{0});
			{
				final int globalIndex = Section.composeText(0,1,2,3,4).length();
				final int localIndex = Section.composeText(0,4).length();
				final int mark = stream.mark();

				consumeMaster(stream, new int[] {6}, new int[]{0,1,2,3,4}, new int[]{0,4});
				
				stream.rewind(mark);
				assertEquals(globalIndex, stream.index());
				assertEquals(localIndex, stream.getLocalIndex());
			}
		}
		
		{
			addStream(stream, Section.include2, elements);
			consumeInclude(stream, new int[] {5}, new int[]{0,1,2,3,4}, new int[]{0,4});
			{
				final int globalIndex = Section.composeText(0,1,2,3,4,5).length();
				final int localIndex = Section.composeText(0,4).length();
				final int mark = stream.mark();

				consumeMaster(stream, new int[] {6}, new int[]{0,1,2,3,4,5}, new int[]{0,4});
				
				stream.rewind(mark);
				assertEquals(globalIndex, stream.index());
				assertEquals(localIndex, stream.getLocalIndex());
			}
		}
		
		{
			consumeMaster(stream, new int[] {6}, new int[]{0,1,2,3,4,5}, new int[]{0,4});
			{
				final int globalIndex = Section.composeText(0,1,2,3,4,5,6).length();
				final int localIndex = Section.composeText(0,4,6).length();
				assertEquals(globalIndex, stream.index());
				assertEquals(localIndex, stream.getLocalIndex());
			}
		}
		
	}

	private void checkSize(CharStreamWithInclude stream, List<Section> elements) {
		String txt = Section.composeText(elements);
		assertEquals(txt.length(), stream.size());
		assertEquals(txt, stream.substring(0, stream.size()-1));
	}

	private void consumeMaster(CharStreamWithInclude stream, int[] indexes, int[] global, int[] local) {
		final int globalIndex = Section.composeText(global).length();
		final int localIndex = Section.composeText(local).length();
		String txt = Section.composeText(indexes);
		
		for (int i=0; i<txt.length(); i++) {
			assertEquals(globalIndex+i, stream.index());
			assertEquals(localIndex+i, stream.getLocalIndex());
			
			stream.consume();
		}
	}
	
	private void consumeInclude(CharStreamWithInclude stream, int[] indexes, int[] global, int[] local) {
		final int globalIndex = Section.composeText(global).length();
		final int localIndex = Section.composeText(local).length();
		String txt = Section.composeText(indexes);
		
		for (int i=0; i<txt.length(); i++) {
			assertEquals(globalIndex+i, stream.index());
			assertEquals(localIndex, stream.getLocalIndex());
			
			stream.consume();
		}
	}
	
}
