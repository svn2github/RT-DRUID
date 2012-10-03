/**
 * 17/lug/2012
 */
package com.eu.evidence.rtdruid.oil.xtext.parser;

import static org.junit.Assert.assertEquals;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.eclipse.emf.common.util.URI;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Nicola Serreli
 * @since 2.0
 *
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
	CharStreamWithIncludeTestSuite.EmptyTest.class,
	CharStreamWithIncludeTestSuite.EmptyStreamTest.class,
	CharStreamWithIncludeTestSuite.SingleLineStreamTest.class,
	CharStreamWithIncludeTestSuite.MultiLineStreamTest.class,
	CharStreamWithIncludeTest.class
	})
public class CharStreamWithIncludeTestSuite {
	
	protected enum ResultId {
		init, 
		// consume, no result expected 
		LA_LT, mark, index, rewindInt, rewind, releaseInt, seekInt, size, getSourceName, 
		substring, getLine, setLine, setCharPositionInLine, getCharPositionInLine;
	}
	
	
	public static abstract class AbstractCharStreamWithIncludeTest {
		
		public abstract CharStreamWithInclude getStream();
		public abstract URI getStreamName();
		
		protected abstract Object[] getExpectedResults(ResultId id);

		@Test
		public void testInit() {
			CharStreamWithInclude stream = getStream();
			
			Object[] results = getExpectedResults(ResultId.init);
			
			assertEquals(results[0], stream.getCurrentStreamUri());
			assertEquals(results[1], stream.getLine());
			assertEquals(results[2], stream.getCharPositionInLine());
			assertEquals(results[3], stream.index());
			assertEquals(results[4], stream.size());
			assertEquals(results[5], stream.LA(-1));
			assertEquals(results[6], stream.LA(0));
			assertEquals(results[7], stream.LA(1));
			
			// The same result as LA
			assertEquals(results[5], stream.LT(-1));
			assertEquals(results[6], stream.LT(0));
			assertEquals(results[7], stream.LT(1));
		}


		@Test
		public void testConsume() {
			CharStreamWithInclude stream = getStream();
			for (int i = 0; i<2; i++) {
				if (i == 1) {
					stream.seek(0);
				}
				
				while(stream.size()<stream.index()) {
					
					int currentIndex = stream.index();
					stream.consume();
					assertEquals(currentIndex +1, stream.index());
				}
			}
		}

		@Test
		public void testLA() {
			Object[] results = getExpectedResults(ResultId.LA_LT);
			String value = (String) results[0];
			
			CharStreamWithInclude stream = getStream();
			final int size = value.length();
			assertEquals(size, stream.size());
			
			for (int i = 0; i<2; i++) {
				if (i == 1) {
					stream.seek(0);
				}
				
				int pos = getStream().index();
				
				while(stream.index()<stream.size()) {
					
					for (int delta=-(size+1); delta<(size+2) ; delta++) {
						if (delta == 0) {
							// undefined value
							continue;
						}
						int la = stream.LA(delta);
						int lt = stream.LA(delta);
						assertEquals(la, lt);
						
						if ((pos+delta<0) || (pos+delta>size)) {
							assertEquals(CharStream.EOF, la);
						} else {
							int vdelta = delta <0 ? 0 : 1;
							assertEquals("" + (char) value.charAt(pos+delta-vdelta), "" + (char) la);
						}
					}
					
					int currentIndex = stream.index();
					stream.consume();
					assertEquals(currentIndex +1, stream.index());
					pos++;
				}
			}
		}

		@Test
		public void testmark() {
		}

		@Test
		public void testRewindInt() {
		}

		@Test
		public void testRewind() {
		}

		@Test
		public void testReleaseInt() {
		}

		@Test
		public void testSeekInt() {
		}

		@Test
		public void testSize() {
		}

		@Test
		public void testSubstring() {
			Object[] results = getExpectedResults(ResultId.LA_LT);
			String value = (String) results[0];
			
			CharStreamWithInclude stream = getStream();
			final int size = value.length();
			assertEquals(size, stream.size());
			
			for (int i = 0; i<2; i++) {
				if (i == 1) {
					stream.seek(0);
				}
				
				for(int pos = stream.index(); pos<stream.size(); pos++) {
				
					for(int end = pos; end<stream.size(); end++) {
						assertEquals("i="+i+", ["+pos+", "+end+"]=",value.substring(pos, end+1), stream.substring(pos, end));
					}
				}
			}
		}

		@Test
		public void testGetLine() {
		}

		@Test
		public void testSetLine() {
		}

		@Test
		public void testSetCharPositionInLine() {
		}

		@Test
		public void testGetCharPositionInLine() {
		}
	}

	
	public static class EmptyTest extends AbstractCharStreamWithIncludeTest {
		@Override
		protected Object[] getExpectedResults(ResultId id) {
			switch (id) {
			case init:
					return new Object[] {
							getStreamName(),
							1, // line
							0, // position in line
							0, // index
							0, // size
							CharStream.EOF, // LA(-1)
							0, // LA(0)
							CharStream.EOF, // LA(1)
					};
			case LA_LT:
				return new Object[] {""};
//			case consume:
//				break;
			case getCharPositionInLine:
				break;
			case getLine:
				break;
			case getSourceName:
				break;
			case index:
				break;
			case mark:
				break;
			case releaseInt:
				break;
			case rewind:
				break;
			case rewindInt:
				break;
			case seekInt:
				break;
			case setCharPositionInLine:
				break;
			case setLine:
				break;
			case size:
				break;
			case substring:
				break;
			default:
				break;
			}
			return null;
		}
		@Override
		public CharStreamWithInclude getStream() {
			return new CharStreamWithInclude();
		}
		
		@Override
		public URI getStreamName() {
			return null;
		}
	}
	
	public static class EmptyStreamTest extends AbstractCharStreamWithIncludeTest {
		
		@Override
		protected Object[] getExpectedResults(ResultId id) {
			switch (id) {
			case init:
					return new Object[] {
							getStreamName(),
							1, // line
							0, // position in line
							0, // index
							0, // size
							CharStream.EOF, // LA(-1)
							0, // LA(0)
							CharStream.EOF, // LA(1)
					};
			case LA_LT:
				return new Object[] {""};
//			case consume:
//				break;
			case getCharPositionInLine:
				break;
			case getLine:
				break;
			case getSourceName:
				break;
			case index:
				break;
			case mark:
				break;
			case releaseInt:
				break;
			case rewind:
				break;
			case rewindInt:
				break;
			case seekInt:
				break;
			case setCharPositionInLine:
				break;
			case setLine:
				break;
			case size:
				break;
			case substring:
				break;
			default:
				break;
			}
			return null;
		}
		
		@Override
		public CharStreamWithInclude getStream() {
			CharStreamWithInclude answer = new CharStreamWithInclude();
			answer.setStream(getStreamName(), new ANTLRStringStream(""));
			return answer;
		}
		
		@Override
		public URI getStreamName() {
			return URI.createFileURI("empty");
		}
	}

	public static class SingleLineStreamTest extends AbstractCharStreamWithIncludeTest {
		/**
		 * 
		 */
		private static final String TEXT = "Simple Test";

		@Override
		protected Object[] getExpectedResults(ResultId id) {
			switch (id) {
			case init:
					return new Object[] {
							getStreamName(),
							1, // line
							0, // position in line
							0, // index
							TEXT.length(), // size
							CharStream.EOF, // LA(-1)
							0, // LA(0)
							(int)'S', // LA(1)
					};
			case LA_LT:
				return new Object[] {TEXT};
//			case consume:
//				break;
			case getCharPositionInLine:
				break;
			case getLine:
				break;
			case getSourceName:
				break;
			case index:
				break;
			case mark:
				break;
			case releaseInt:
				break;
			case rewind:
				break;
			case rewindInt:
				break;
			case seekInt:
				break;
			case setCharPositionInLine:
				break;
			case setLine:
				break;
			case size:
				break;
			case substring:
				break;
			default:
				break;
			}
			return null;
		}
		
		@Override
		public CharStreamWithInclude getStream() {
			CharStreamWithInclude answer = new CharStreamWithInclude();
			answer.setStream(getStreamName(), new ANTLRStringStream(TEXT));
			return answer;
		}
		
		@Override
		public URI getStreamName() {
			return URI.createFileURI("singleLine");
		}
	}
	
	public static class MultiLineStreamTest extends AbstractCharStreamWithIncludeTest {
		/**
		 * 
		 */
		private static final String TEXT = "Multi\nline\n\t Test";

		@Override
		protected Object[] getExpectedResults(ResultId id) {
			switch (id) {
			case init:
					return new Object[] {
							getStreamName(),
							1, // line
							0, // position in line
							0, // index
							TEXT.length(), // size
							CharStream.EOF, // LA(-1)
							0, // LA(0)
							(int)'M', // LA(1)
					};
			case LA_LT:
				return new Object[] {TEXT};
//			case consume:
//				break;
			case getCharPositionInLine:
				break;
			case getLine:
				break;
			case getSourceName:
				break;
			case index:
				break;
			case mark:
				break;
			case releaseInt:
				break;
			case rewind:
				break;
			case rewindInt:
				break;
			case seekInt:
				break;
			case setCharPositionInLine:
				break;
			case setLine:
				break;
			case size:
				break;
			case substring:
				break;
			default:
				break;
			}
			return null;
		}
		
		@Override
		public CharStreamWithInclude getStream() {
			CharStreamWithInclude answer = new CharStreamWithInclude();
			answer.setStream(getStreamName(), new ANTLRStringStream(TEXT));
			return answer;
		}
		
		@Override
		public URI getStreamName() {
			return URI.createFileURI("multiLine");
		}
	}

}
