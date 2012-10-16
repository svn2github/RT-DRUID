/**
 * 23/lug/2012
 */
package com.eu.evidence.rtdruid.oil.xtext.parser;

import org.eclipse.emf.common.notify.Adapter;

/**
 * Converts indexes of a full document, i.e. with included regions, into indexes of the
 * main document, i.e. without considering included regions, and the opposite.
 * 
 * 
 * @author Nicola Serreli
 * @since 2.0
 * 
 */
public interface ILineConverterHelper extends Adapter {
	
	public interface ILineConvertData {
		public int getOffset();
		public int getLine();
		public int getCharacterPositionInLine();
	}

	/**
	 *
	 * @author Nicola Serreli
	 * @since 2.0
	 *
	 */
	public interface IRange {

		/**
		 * @param localPosition
		 * @return
		 */
		public int computeOffset(int localPosition);

		/**
		 * @return the start
		 */
		public int getStart();

		/**
		 * @return the end
		 */
		public int getEnd();

		/**
		 * @return the size
		 */
		public int getSize();

		/**
		 * @return the globalStart
		 */
		public int getGlobalStart();

		public boolean inMainRange(int mainOffset);
		public boolean inGlobalRange(int globalOffset);
	}
	
	/**
	 * 
	 * @param globalPosition
	 * @return
	 */
	public ILineConvertData getMainIndex(int globalPosition);

	/**
	 * 
	 * @param localPosition
	 * @return
	 */
	public int getFullIndex(int localPosition);

	/**
	 * 
	 * @param localPosition
	 * @return
	 */
	public IRange[] getMainSections();

}
