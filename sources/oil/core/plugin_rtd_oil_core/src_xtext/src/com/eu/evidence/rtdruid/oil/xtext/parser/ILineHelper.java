/**
 * 23/lug/2012
 */
package com.eu.evidence.rtdruid.oil.xtext.parser;

import org.antlr.runtime.CommonToken;
import org.eclipse.emf.common.util.URI;

/**
 *
 * @author Nicola Serreli
 * @since 2.0
 *
 */
public interface ILineHelper extends Cloneable {

	public interface LineData {
		
		public void increasePosition();
		
		public void increaseLine();
		
		public void increaseCharacterInLine();
		
		/**
		 * @return the localPosition
		 */
		public int getLocalPosition();
		/**
		 * @return the localLine
		 */
		public int getLocalLine();
		/**
		 * @return the localCharacterLine
		 */
		public int getLocalCharacterLine();

		/**
		 * @return the uri
		 */
		public URI getUri();
		
		public CommonToken getParentIncludeToken();
	}

	
	
	public ILineHelper clone();

	/**
	 * @param position
	 * @return
	 */
	public String getSourceName(int position);

	/**
	 * @param position
	 * @return
	 */
	public URI getStreamUri(int position);

	/**
	 * @param p
	 * @param currentStreamName
	 */
	public void setStreamUri(int position, URI currentStreamName);

	/**
	 * 
	 * @param globalPosition
	 * @param globalLine
	 * @param globalCharPositionInLine
	 * @param newStreamName
	 * @param newStreamLength
	 */
	public LineData addStream(int globalPosition, int globalLine, int globalCharPositionInLine, URI newStreamName, int newStreamLength, CommonToken parentIncludeToken);
	
	/**
	 * 
	 * @param globalPosition
	 * @param globalLine
	 * @param globalCharPositionInLine
	 * @return 
	 */
	public LineData endStream(int globalPosition, int globalLine, int globalCharPositionInLine);

	/**
	 * 
	 * @param globalPosition
	 */
	public int computeNextEof(int globalPosition);

	/**
	 * 
	 * @param globalPosition
	 * @return
	 */
	public LineData getData(int globalPosition);

}
