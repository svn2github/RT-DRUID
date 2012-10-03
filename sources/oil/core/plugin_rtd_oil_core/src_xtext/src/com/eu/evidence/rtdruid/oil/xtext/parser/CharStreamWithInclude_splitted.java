/**
 * 17/lug/2012
 */
package com.eu.evidence.rtdruid.oil.xtext.parser;

import java.util.HashMap;
import java.util.Vector;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.eclipse.emf.common.util.URI;

/**
 * 
 * @author Nicola Serreli
 * @since 2.0
 * 
 */
public class CharStreamWithInclude_splitted implements CharStream {
	
	protected static final int UNSET_MARK = -1;
	
	protected static final StoredCharStream EMPTY = new StoredCharStream(new ANTLRStringStream(), null, 0, 0, 0);
	
	protected static class MarkCache {
		final int markId;
		final int streamIndex;
		
		public MarkCache(final int markId, final int streamIndex) {
			this.markId = markId;
			this.streamIndex = streamIndex;
		}
	}
	protected Vector<MarkCache> markers = new Vector<CharStreamWithInclude_splitted.MarkCache>();
	
	protected static class StoredCharStream {
		final CharStream stream;
		final URI name;
		int globalOffset;
		final int localOffset;
		int localSize;
		
		int endMark = UNSET_MARK;
		
		/**
		 * 
		 */
		public StoredCharStream(final CharStream stream,
					final URI name,
					final int globalOffset, 
					final int localOffset,
					final int localSize) {
			this.stream = stream;
			this.name = name;
			this.globalOffset = globalOffset;
			this.localOffset = localOffset;
			this.localSize = localSize;
		}
	}
		
	protected StoredCharStream[] allStream = new CharStreamWithInclude_splitted.StoredCharStream[] {EMPTY, EMPTY, EMPTY};
	protected StoredCharStream current = null;
	private int currentIndex = 0;
//	private int globalIndex = 0;
	
	
	protected StoredCharStream getStream(int offset) {
		int index = getStreamIndex(offset);
		if (index==-1) {
			return EMPTY;
		}
		return allStream[index];
	}
	protected int getStreamIndex(int offset) {
		final int size = allStream.length;
		
		for (int i=size-1; i>=0; i--) {
			if (allStream[i].globalOffset <=offset) {
				return i;
			}
		}
		return -1;
	}
	
	
	// ----------------------------------------
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.antlr.runtime .IntStream#consume()
	 */
	@Override
	public void consume() {
		int streamEnd = current.localOffset + current.localSize;
		if (current.stream.index()<streamEnd) {
			current.stream.consume();
			if (current.stream.index()==streamEnd) {
				if (current != EMPTY && currentIndex<allStream.length-1) {
					// mark the end of the current stream
					current.endMark = current.stream.mark();
					
					// move to the next stream
					currentIndex++;
					current = allStream[currentIndex];
				}
			}
//		} else if (current != EMPTY){
//			if (currentIndex<allStream.length-1) {
//				currentIndex++;
//			}
		}
	}

	/* (non-Javadoc)
	 * @see org.antlr.runtime.IntStream#LA(int)
	 */
	@Override
	public int LA(int i) {
//		// check if it inside the current stream
//		if (i>=0) {
//			if (current.stream.index() + i< (current.localOffset+current.localSize) ) {
//				current.stream.LA(i);
//			} else {
//				StoredCharStream iter = current;
//				StoredCharStream iter = current;
//				while 
//			}
//		} else {
//			
//		}
//		
//		// first -> we need to find the owner of the required character
//		final int reqGIndex = index() + i;
//		if ()
//				// TODO

//		
//		
		return 0;// currentStream.LA(i);
	}

	/* (non-Javadoc)
	 * @see org.antlr.runtime.IntStream#mark()
	 */
	@Override
	public int mark() {
		int size = markers.size();
		markers.add(new MarkCache(current.stream.mark(), currentIndex));
		return size;
	}

	/* (non-Javadoc)
	 * @see org.antlr.runtime.IntStream#index()
	 */
	@Override
	public int index() {
		return current.globalOffset + current.stream.index();
	}

	/* (non-Javadoc)
	 * @see org.antlr.runtime.IntStream#rewind(int)
	 */
	@Override
	public void rewind(int markerId) {
		// get marker
		MarkCache marker = markers.get(markerId);
		// remove invalid markers
		release(markerId);
		
		// update "current stream" pointer
		currentIndex = marker.streamIndex;
		current = allStream[currentIndex];
		
		// rewind current stream
		current.stream.rewind(marker.markId);
		
		{// remove all invalid streams
			HashMap<CharStream, StoredCharStream> validStreams = new HashMap<CharStream, StoredCharStream>();
			for (int i=0; i<= currentIndex; i++) {
				validStreams.put(allStream[i].stream, allStream[i]);
			}
			
			int nextGOffset = current.globalOffset + current.localSize;
			int lastValidIndex = currentIndex;
			for (int i=currentIndex+1; i<allStream.length && allStream[i] != EMPTY; i++) {
				CharStream key = allStream[i].stream;
				if (!(validStreams.containsKey(key))) {
					// remove the stream
				} else {
					// merge two elements?
					if (allStream[lastValidIndex].stream == key) {
						int tsize = allStream[i].localSize;
						nextGOffset += tsize;
						allStream[lastValidIndex].localSize += tsize;
					} else {
						// update values: offset
						allStream[lastValidIndex] = allStream[i];
						allStream[i] = EMPTY;
						allStream[lastValidIndex].globalOffset = nextGOffset;
						nextGOffset += allStream[lastValidIndex].localSize;
						
						// reset the stream state (notice that it can be not needed)
						StoredCharStream master = validStreams.get(key);
						if (master != null) {
							// consume the mark to reset the stream 
							key.rewind(master.endMark);
							// .. and store a new mark (equivalent to the previous one)
							master.endMark = key.mark(); 
							
							// remove the master, because it is already rewind
							validStreams.put(key, null);
						}
					}
				}
			}
		}
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
		/**
		 *  Please note that this function does not change the set of streams
		 */
		
		// slow way -> remove all markers from Streams before remove them from list
//		for ()
		
		// fast way -> markers are still there in CharStreams (but they are not usables)
		markers.setSize(markerId);
	}

	/* (non-Javadoc)
	 * @see org.antlr.runtime.IntStream#seek(int)
	 */
	@Override
	public void seek(int index) {
		final int gIndex = index();
		if (index>=gIndex) {
//			if (index == gIndex) // do nothing	
			for (int i=gIndex; i<index; i++) {
				consume();
			}
		} else {
			if (!(index>= current.globalOffset && index < (current.globalOffset + current.localSize))) {
				currentIndex = getStreamIndex(index);
				current = allStream[currentIndex];
			}
			current.stream.seek(index-current.globalOffset); 
		}
	}

	/* (non-Javadoc)
	 * @see org.antlr.runtime.IntStream#size()
	 */
	@Override
	public int size() {
		for (int i=allStream.length-1; i>=0; i--) {
			if (allStream[i] != EMPTY) {
				return allStream[i].globalOffset + allStream[i].localSize;
			}
		}
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.antlr.runtime.IntStream#getSourceName()
	 */
	@Override
	public String getSourceName() {
		return current.stream.getSourceName();
	}

	/* (non-Javadoc)
	 * @see org.antlr.runtime.CharStream#substring(int, int)
	 */
	@Override
	public String substring(int start, int stop) {
		// TODO
		return current.stream.substring(start, stop);
	}

	/* (non-Javadoc)
	 * @see org.antlr.runtime.CharStream#LT(int)
	 */
	@Override
	public int LT(int i) {
		return LA(i);
	}

	/* (non-Javadoc)
	 * @see org.antlr.runtime.CharStream#getLine()
	 */
	@Override
	public int getLine() {
		return current.stream.getLine();
	}

	/* (non-Javadoc)
	 * @see org.antlr.runtime.CharStream#setLine(int)
	 */
	@Override
	public void setLine(int line) {
		current.stream.setLine(line);
	}

	/* (non-Javadoc)
	 * @see org.antlr.runtime.CharStream#setCharPositionInLine(int)
	 */
	@Override
	public void setCharPositionInLine(int pos) {
		current.stream.setCharPositionInLine(pos);
	}

	/* (non-Javadoc)
	 * @see org.antlr.runtime.CharStream#getCharPositionInLine()
	 */
	@Override
	public int getCharPositionInLine() {
		return current.stream.getCharPositionInLine();
	}

	////////////////////////////////////////////////////////////////////////////
	
	/**
	 * @param antlrReaderStream
	 * @return
	 */
	public CharStream setStream(URI name, CharStream stream) {
//		
//		if (currentStream != null && currentStream != stream) {
//			
//			if (currentStream != EMPTY) {
//				
//				StoredCharStream scs = new StoredCharStream();
//				scs.name = currentStreamUri;
//				scs.stream = currentStream;
//				
//				previousStream.push(scs);
//			}
//		}
//
//		currentStream = stream;
//		currentStreamUri = name;
//		
		return this;
	}
	
	/**
	 * @return the currentStreamName
	 */
	public URI getCurrentStreamUri() {
		return null;
	}
	
//	/**
//	 * @param currentStreamName the currentStreamName to set
//	 */
//	public void setCurrentStreamUri(URI currentStreamName) {
//		this.currentStreamUri = currentStreamName;
//	}

}
