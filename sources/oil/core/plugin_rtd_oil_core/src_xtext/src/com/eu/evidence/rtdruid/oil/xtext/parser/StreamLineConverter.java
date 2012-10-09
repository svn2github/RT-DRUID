/**
 * 10/set/2012
 */
package com.eu.evidence.rtdruid.oil.xtext.parser;

import java.util.ArrayList;
import java.util.Collections;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;

/**
 *
 * @author Nicola Serreli
 * @since 2.0
 *
 */
public class StreamLineConverter implements ILineConverterHelper {
	
	final static private boolean debug = false;
	
	public static class Data implements ILineConvertData, Comparable<Integer> {
		final int key;
		
		final int offset;
		final int line;
		final int charPositionInLine;
		
		/**
		 * 
		 */
		public Data(
				final int key,
				final int offset,
				final int line,
				final int charPositionInLine
				) {
			this.key = key;
			this.offset = offset;
			this.line = line;
			this.charPositionInLine = charPositionInLine;
		}
		
		@Override
		public int getCharacterPositionInLine() {
			return charPositionInLine;
		}
		@Override
		public int getLine() {
			return line;
		};
		@Override
		public int getOffset() {
			return offset;
		};
		
		/* (non-Javadoc)
		 * @see java.lang.Comparable#compareTo(java.lang.Object)
		 */
		@Override
		public int compareTo(Integer value) {
			return key - value;
		}
		
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "{"+key+"->"+offset+", " + line + ", " +charPositionInLine +"}";
		}
	}
	
	public static class Range implements Comparable<Integer> {
		final int start;
		final int end;
		final int size;
		final int globalStart;
		
		
		/**
		 * 
		 */
		public Range(
				final int start,
				final int size,
				final int globalStart
				) {
			this.start = start;
			this.end = start+size;
			this.size = size;
			this.globalStart = globalStart;
		}
		
		/* (non-Javadoc)
		 * @see java.lang.Comparable#compareTo(java.lang.Object)
		 */
		@Override
		public int compareTo(Integer value) {
			if (start> value) {
				return 1;
			}
			if (end <= value) {
				return -1;
			}
			return 0;
		}

		/**
		 * @param localPosition
		 * @return
		 */
		public int computeOffset(int localPosition) {
			return 	globalStart + (localPosition - start);
		}
		
		
	}
	
	protected ArrayList<Data> fullToMain = new ArrayList<StreamLineConverter.Data>();
	protected ArrayList<Range> mainToFull = new ArrayList<StreamLineConverter.Range>();
	
	public void reset() {
		fullToMain.clear();
		mainToFull.clear();
	}
	
//	public void reset(int globalOffset, int mainOffset) {
//		resetData(fullToMain, globalOffset);
//		resetRange(mainToFull, mainOffset);
//	}
//	
//	protected void resetData(ArrayList<Data> data, int key) {
//		for (int i=data.size()-1; i>=0; i--) {
//			if (data.get(i).key < key) {
//				return; // end
//			}
//			
//			Data d = data.remove(i);
//			System.out.println("--- Removing " + d.key + " (reset to + " +key + ")");
//		}
//	}
//	
//	protected void resetRange(ArrayList<Range> data, int key) {
//		for (int i=data.size()-1; i>=0; i--) {
//			if (data.get(i).end < key) {
//				return; // end
//			}
//			
//			Data d = data.remove(i);
//			System.out.println("--- Removing " + d.key + " (reset to + " +key + ")");
//		}
//	}
	
	public void storeGlobal(int globalOffset, int localOffset, int localLine, int localCharPositionInLine) {
		int old = fullToMain.isEmpty() ? -1 : fullToMain.get(fullToMain.size()-1).key; 
		if (old<globalOffset) {
			if (debug) System.out.println("--- Adding " + globalOffset);
			fullToMain.add(new Data(globalOffset, localOffset, localLine, localCharPositionInLine));
		}
	}
	
	public void storeLocal(int localStartOffset, int localSize, int globalOffset) {
		int old = mainToFull.isEmpty() ? -1 : mainToFull.get(mainToFull.size()-1).start; 
		if (old<localStartOffset) {
			if (debug) System.out.println("--- range ["+localStartOffset + ".."+localSize+"] " + globalOffset);
			mainToFull.add(new Range(localStartOffset, localSize, globalOffset));
		}
	}

	
	
	//--------------------------------
	
	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.oil.xtext.parser.ILineConverterHelper#getMainIndex(int)
	 */
	@Override
	public ILineConvertData getMainIndex(int globalPosition) {
		int index = Collections.binarySearch(fullToMain, globalPosition);
		if (index > -1) {
			return fullToMain.get(index);
		}
		if (debug) System.out.println("--- Unknown global offset "+ globalPosition + " " +fullToMain);
		return new Data(globalPosition, computeMainIndex(globalPosition), 1, 0);
	}
	
	protected int computeMainIndex(int globalPosition) {
		if (mainToFull.size() <=1) {
			return globalPosition;
		}
		
		int proposal = globalPosition;
		for (Range range : mainToFull) {
			if (range.globalStart<=globalPosition && (range.globalStart + range.size)>globalPosition) {
				return globalPosition - range.globalStart + range.start;
			}
			proposal = range.end;
		}
		
		return proposal;
	}

	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.oil.xtext.parser.ILineConverterHelper#getFullIndex(int)
	 */
	@Override
	public int getFullIndex(int localPosition) {
		int index = Collections.binarySearch(mainToFull, localPosition);
		if (index > -1) {
			return mainToFull.get(index).computeOffset(localPosition);
		}
		if (mainToFull.isEmpty()) {
			return localPosition;
		}
		if (debug) System.out.println("--- Unknown local offset "+ localPosition + " " +fullToMain);
		return mainToFull.get(mainToFull.size()-1).computeOffset(localPosition);
	}

	
	
	// --------------------------------------------------
	
	
	protected EObject rootEObject;


	public org.eclipse.emf.common.notify.Notifier getTarget() {
		return rootEObject;
	};
	
	/* (non-Javadoc)
	 * @see org.eclipse.emf.common.notify.Adapter#isAdapterForType(java.lang.Object)
	 */
	@Override
	public boolean isAdapterForType(Object type) {
		return type instanceof Class<?> && ILineHelper.class.isAssignableFrom((Class<?>)type);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.emf.common.notify.Adapter#notifyChanged(org.eclipse.emf.common.notify.Notification)
	 */
	@Override
	public void notifyChanged(Notification notification) {
		// ignore
	}
	
	public void setTarget(org.eclipse.emf.common.notify.Notifier newTarget) {
		if (newTarget == null || newTarget instanceof EObject)
			rootEObject = (EObject) newTarget;
		else
			throw new IllegalArgumentException("Notifier must be an Eobject");
	}


}
