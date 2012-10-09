/**
 * 17/lug/2012
 */
package com.eu.evidence.rtdruid.oil.xtext.parser;

import java.util.Vector;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonToken;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.util.ReplaceRegion;

import com.eu.evidence.rtdruid.oil.xtext.parser.ILineHelper.LineData;

/**
 * 
 * @author Nicola Serreli
 * @since 2.0
 * 
 */
public class CharStreamWithInclude extends ANTLRStringStream {
	
	protected static class MarkCache {
		final char[] stream;
		final ILineHelper names;
		final int nextEOF;
		final CommonToken lastCharParentIncludeToken;
		final LineData info;
		final LineData masterInfo;
		final int rangeStart;
		
		public MarkCache(final char[] stream , final ILineHelper names, final int nextEOF, final LineData info, final CommonToken lastCharParentIncludeToken, final int rangeStart) {
			this.stream = stream;
			this.names = names;
			this.nextEOF = nextEOF;
			this.lastCharParentIncludeToken = lastCharParentIncludeToken;
			this.info = info;
			this.masterInfo = names.getData(0);
			this.rangeStart = rangeStart;
		}
	}
	protected Vector<MarkCache> markers = new Vector<CharStreamWithInclude.MarkCache>();

	protected ILineHelper streamNames = new StreamLineHelper();
	
	protected int nextEOF;
	protected int rangeStart = 0;
	protected CommonToken lastCharParentIncludeToken;
	protected LineData info;
	protected LineData masterInfo;
	
	protected StreamLineConverter lineConverterHelper = new StreamLineConverter();
	
	protected char[] baseStream;
	
	// ----------------------------------------
	
	/* (non-Javadoc)
	 * @see org.antlr.runtime.IntStream#mark()
	 */
	@Override
	public int mark() {
		int markId = super.mark();
		ILineHelper helper = streamNames.clone();
		MarkCache cache = new MarkCache(data, helper, nextEOF, helper.getData(p), lastCharParentIncludeToken, rangeStart);
		
		if (markers.size()<=markId) {
			markers.setSize(markId+1);
		}
		markers.setElementAt(cache, markId);
		
		return markId;
	}

	/* (non-Javadoc)
	 * @see org.antlr.runtime.IntStream#rewind(int)
	 */
	@Override
	public void rewind(int markerId) {
		// get marker
		MarkCache marker = markers.get(markerId);
		
		// reset "stream", stream size and names
		data = marker.stream;
		n = data.length;
		streamNames = marker.names;
		nextEOF = marker.nextEOF;
		rangeStart = marker.rangeStart;
		lastCharParentIncludeToken = marker.lastCharParentIncludeToken;
		info = marker.info;
		masterInfo = marker.masterInfo;
		
		// remove invalid markers
//		release(markerId); --> called by super.rewind
		super.rewind(markerId);
		
//		lineConverterHelper.reset(p, masterInfo.getLocalPosition());
	}

	/* (non-Javadoc)
	 * @see org.antlr.runtime.IntStream#rewind()
	 */
	@Override
	public void rewind() {
		rewind(markers.size()-1);
	}

	/* (non-Javadoc)
	 * @see org.antlr.runtime.IntStream#release(int)
	 */
	@Override
	public void release(int markerId) {
		// remove invalid markers
		markers.setSize(markerId);
		
		// remove markers from superclass
		super.release(markerId);
	}

	/* (non-Javadoc)
	 * @see org.antlr.runtime.IntStream#getSourceName()
	 */
	@Override
	public String getSourceName() {
		return streamNames.getSourceName(p);
	}

	/* (non-Javadoc)
	 * @see org.antlr.runtime.ANTLRStringStream#consume()
	 */
	@Override
	public void consume() {
		//		super.consume();
		{ // derived from super
	        if ( p < n ) {
	        	lastCharParentIncludeToken = info.getParentIncludeToken();
				charPositionInLine++;
				info.increaseCharacterInLine();
				if ( data[p]=='\n' ) {
					/*
					System.out.println("newline char found on line: "+line+
									   "@ pos="+charPositionInLine);
					*/
					line++;
					charPositionInLine=0;
		            info.increaseLine();
				}
	            p++;
	            info.increasePosition();
				//System.out.println("p moves to "+p+" (c='"+(char)data[p]+"')");
	        }
		}

		if (p==nextEOF) {
			nextEOF = streamNames.computeNextEof(p);
			LineData tmp = streamNames.endStream(p-1, line, charPositionInLine);
			
			if (info == masterInfo && tmp != masterInfo) {
				// store range
				int rangeSize = masterInfo.getLocalPosition() - rangeStart;
				boolean isLastChar = nextEOF==p;
				lineConverterHelper.storeLocal(rangeStart, rangeSize + (isLastChar ? 1 : 0) , p-rangeSize);
				rangeStart = masterInfo.getLocalPosition();
			} else if (info != masterInfo && tmp == masterInfo) {
				// start new range
				rangeStart = masterInfo.getLocalPosition();
			}
			
			if (tmp != null) {
				info = tmp;
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see org.antlr.runtime.ANTLRStringStream#getLine()
	 */
	public int getLocalLine() {
		return masterInfo.getLocalLine(); //streamNames.getLine(p, line);
//		return super.getLine();
	}
	
	/* (non-Javadoc)
	 * @see org.antlr.runtime.ANTLRStringStream#getCharPositionInLine()
	 */
	public int getLocalCharPositionInLine() {
		return masterInfo.getLocalCharacterLine(); //streamNames.getCharPositionInLine(p, line, charPositionInLine);
//		return super.getCharPositionInLine();
	}
	
	/* (non-Javadoc)
	 * @see org.antlr.runtime.ANTLRStringStream#index()
	 */
	public int getLocalIndex() {
		return masterInfo.getLocalPosition();
	}
	
	////////////////////////////////////////////////////////////////////////////

	/**
	 * @param antlrReaderStream
	 * @return
	 */
	public CharStream setStream(URI name, CharStream stream) {
		return setStream(name, stream, null);
	}
	

	/**
	 * @param createPlatformResourceURI
	 * @param antlrInputStream
	 * @param token
	 */
	public CharStream setStream(URI name, CharStream stream, CommonToken token) {
		return setStream(name, stream.substring(0, stream.size()-1).toCharArray(), token);
	}
	
	/**
	 * @param antlrReaderStream
	 * @return
	 */
	public CharStream setStream(URI name, char[] stream, CommonToken token) {

		if (data==null && stream.length==0) {
			data = new char[0];
			n = data.length;
		} else if (stream.length>0) {
			
			if (data == null) {
				baseStream = new char[stream.length];
				System.arraycopy(stream, 0, baseStream, 0, stream.length);
			}
	
			final int oldSize = data == null ? 0 : data.length;
			
			char[] newData = new char[oldSize + stream.length];
			
			if (oldSize>0) {
				System.arraycopy(data, 0, newData, 0, p);
				System.arraycopy(data, p, newData, p+stream.length, oldSize-p);
			}
			
			System.arraycopy(stream, 0, newData, p, stream.length);
			data = newData;
			n = data.length;
		}
		
		if (info != null && info.getParentIncludeToken() != null) {
			token = info.getParentIncludeToken();
		}
		
		if (info == masterInfo && masterInfo != null) {
			// store range
			int rangeSize = masterInfo.getLocalPosition() - rangeStart;
			lineConverterHelper.storeLocal(rangeStart, rangeSize, p-rangeSize);
			rangeStart = masterInfo.getLocalPosition();
		}
		
		info = streamNames.addStream(p, line, charPositionInLine, name, stream.length, token);
		nextEOF = streamNames.computeNextEof(p);

		if (masterInfo == null) {
			masterInfo = info;
		}
		
//		System.out.println("New stream >>\n"+(new String(data)) + "\n<<\n");
		
		return this;
	}
	
	/**
	 * @return the currentStreamName
	 */
	public URI getCurrentStreamUri() {
		return streamNames.getStreamUri(p);
	}
	
	/**
	 * @param currentStreamName the currentStreamName to set
	 */
	public void setCurrentStreamUri(URI currentStreamName) {
		 streamNames.setStreamUri(p, currentStreamName);
	}

	/**
	 * @param replaceRegion
	 */
	public void resetAndReplace(ReplaceRegion replaceRegion) {
		super.reset();
		super.markers = null;
		this.markers.clear();
		
		if (baseStream != null) {
	
			StringBuilder builder = new StringBuilder(new String(baseStream));
			replaceRegion.applyTo(builder);
			data = builder.toString().toCharArray();
			baseStream = data;
			n = data.length;
			
//				char[] newText = replaceRegion.getText().toCharArray();
//				char[] newData = new char[baseStream.length + newText.length - replaceRegion.getLength()];
//				
//				System.arraycopy(baseStream, 0, newData, 0, replaceRegion.getOffset());
//				System.arraycopy(newText, 0, newData, replaceRegion.getOffset(), newText.length);
//				System.arraycopy(baseStream, replaceRegion.getEndOffset(), newData, replaceRegion.getOffset()+newText.length, baseStream.length - replaceRegion.getEndOffset());

			streamNames = new StreamLineHelper();
			info = streamNames.addStream(p, line, charPositionInLine, masterInfo.getUri(), data.length, null);
			nextEOF = streamNames.computeNextEof(p);
			rangeStart = 0;
	
			masterInfo = info;
			
			lineConverterHelper.reset();
		}
	}
	
	public CommonToken getLastCharParentIncludeToken() {
		return lastCharParentIncludeToken;
	}
	
	
	/**
	 * @return the streamNames
	 */
	public ILineHelper getLineHelper() {
		return streamNames;
	}
	
	/**
	 * @return the lineConverterHelper
	 */
	public ILineConverterHelper getLineConverterHelper() {
		return lineConverterHelper;
	}
	
	public void storePosition() {
		lineConverterHelper.storeGlobal(p, masterInfo.getLocalPosition(), masterInfo.getLocalLine(), masterInfo.getLocalCharacterLine());
	}
}
