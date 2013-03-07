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
public class StreamLineHelper implements ILineHelper {
	
	private static class Info implements LineData, Tree.CloneElement<Info>, Cloneable {
		final static int UNSET_VALUE = -1;
		
		URI uri;
		final CommonToken parentIncludeToken;
		final int parentPosition;

		final int startGlobalLine;
		final int startGlobalCharacterLine;

		final int startGlobalPosition;
		final int localSize;
		int childSize;
		
		int endGlobalLine;
		int endGlobalCharacterLine;
		
		int localPosition;
		int localLine;
		int localCharacterLine;
		
		/**
		 * 
		 */
		public Info(URI uri, int globalStart, int atParentPosition, int startGlobalLine, int startGlobalCharacterLine, int localSize, CommonToken parentIncludeToken) {
			this.startGlobalPosition = globalStart;
			this.parentPosition = atParentPosition;
			this.startGlobalLine = startGlobalLine;
			this.startGlobalCharacterLine = startGlobalCharacterLine;
			this.uri = uri;
			this.parentIncludeToken = parentIncludeToken;
			
			this.localSize = localSize;
			childSize = 0;
			
			endGlobalLine = UNSET_VALUE;
			endGlobalCharacterLine = UNSET_VALUE;

			localPosition = 0;
			localLine = 1;
			localCharacterLine = 0;			
		}
		
		/**
		 * @return the childSize
		 */
		int getGlobalEnd() {
			return startGlobalPosition + localSize + childSize;
		}
		
		
		@Override
		public void increasePosition() {
			localPosition++;
		}
		
		@Override
		public void increaseLine() {
			localLine++;
			localCharacterLine = 0;
		}
		
		@Override
		public void increaseCharacterInLine() {
			localCharacterLine++;
		}
		
		/**
		 * @return the localPosition
		 */
		@Override
		public int getLocalPosition() {
			return localPosition;
		}
		/**
		 * @return the localLine
		 */
		@Override
		public int getLocalLine() {
			return localLine;
		}
		/**
		 * @return the localCharacterLine
		 */
		@Override
		public int getLocalCharacterLine() {
			return localCharacterLine;
		}
		@Override
		/**
		 * @return the uri
		 */
		public URI getUri() {
			return uri;
		}
		
		/* (non-Javadoc)
		 * @see com.eu.evidence.rtdruid.oil.xtext.parser.ILineHelper.LineData#getToken()
		 */
		@Override
		public CommonToken getParentIncludeToken() {
			return parentIncludeToken;
		}
		
		/* (non-Javadoc)
		 * @see java.lang.Object#clone()
		 */
		@Override
		public Info clone() {
			Info answer = new Info(uri, startGlobalPosition, parentPosition, startGlobalLine, startGlobalCharacterLine, localSize, parentIncludeToken);
			answer.childSize = childSize;
				
			answer.endGlobalLine = endGlobalLine;
			answer.endGlobalCharacterLine = endGlobalCharacterLine;

			answer.localPosition = localPosition;
			answer.localLine = localLine;
			answer.localCharacterLine = localCharacterLine;

			return answer;
		}
	}
	
	protected Tree<Info> tree;
	

	//-----------------------------------------------
	
	/**
	 * 
	 */
	public StreamLineHelper() {
		tree = new Tree<StreamLineHelper.Info>();
	}
	
	public Info getData(int globalPosition) {
		if (tree.isEmpty()) {
			return null;
		} else {
			Tree<Info>.TreePointer pointer = getPointer(globalPosition);
			return pointer.get();
		}
	}

	protected Tree<Info>.TreePointer getPointer(int globalPosition) {
		
		if (globalPosition <0) {
			throw new IllegalArgumentException("Index out of boundaries " + globalPosition);
		}
		
		Tree<Info>.TreePointer pointer = tree.getPointer();
		if (!tree.isEmpty()) {

			Tree<Info>.TreePointer iter = pointer.clone();
			while (iter != null) {

				Info info = iter.get();
				if (info.startGlobalPosition<=globalPosition) {
					
					if (info.getGlobalEnd()>globalPosition) {
						// save current element and check children
						pointer.clone(iter);
						if (!iter.goFirstChildren()) {
							iter = null;  // --> end
						}
						
					} else {
						if (!iter.goNextSibling()) {
							iter = null;  // --> end
						}
					}
				} else {
					iter = null;  // --> end
				}
			}
		}
		
		
		return pointer;
	
	}
	
	//-----------------------------------------------
	

	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.oil.xtext.parser.ILineHelper#getSourceName(int)
	 */
	@Override
	public String getSourceName(int globalPosition) {
		Info info = getData(globalPosition);
		if (info != null && info.uri != null) {
			return info.uri.isFile() ?
					  info.uri.toFileString()
					: info.uri.toPlatformString(false);
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.oil.xtext.parser.ILineHelper#getStreamUri(int)
	 */
	@Override
	public URI getStreamUri(int globalPosition) {
		Info info = getData(globalPosition);
		return info != null ? info.uri : null ;
	}

	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.oil.xtext.parser.ILineHelper#setStreamUri(int, org.eclipse.emf.common.util.URI)
	 */
	@Override
	public void setStreamUri(int globalPosition, URI currentStreamName) {
		Info info = getData(globalPosition);
		if (info != null) {
			info.uri = currentStreamName ;
		}
	}

	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.oil.xtext.parser.ILineHelper#addStream(int, int, int, org.eclipse.emf.common.util.URI, int)
	 */
	@Override
	public LineData addStream(int globalPosition, int globalLine, int globalCharPositionInLine, URI newStreamName,
			int newStreamLength, CommonToken token) {
		Info element;
		if (tree.isEmpty()) {
			element = new Info(newStreamName, 0, 0, 0, 0, newStreamLength, token);
			tree.getPointer().addChild(element);
		} else {
		
			Tree<Info>.TreePointer pointer = getPointer(globalPosition);
			
			Info current = pointer.get();

			element = new Info(newStreamName, globalPosition, globalPosition-current.startGlobalPosition - current.childSize, globalLine, globalCharPositionInLine, newStreamLength, token);
			pointer.addChild(element);
			
			
			for (Tree<Info>.TreePointer iter = pointer.clone(); iter != null; iter = iter.goParent() ? iter : null) {
				iter.get().childSize += newStreamLength;
			}
		}
		
		return element;
	}
	
	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.oil.xtext.parser.ILineHelper#endStream(int, int, int)
	 */
	@Override
	public LineData endStream(int globalPosition, int globalLine, int globalCharPositionInLine) {
		Tree<Info>.TreePointer pointer = getPointer(globalPosition);
		pointer.get().endGlobalLine = globalLine;
		pointer.get().endGlobalCharacterLine = globalCharPositionInLine;
		if (pointer.goParent()) {
			return pointer.get();
		} else {
			return null;
		}
	}
	
	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.oil.xtext.parser.ILineHelper#computeNextEof(int)
	 */
	@Override
	public int computeNextEof(int globalPosition) {
		Tree<Info>.TreePointer pointer = getPointer(globalPosition);
		return pointer.get().getGlobalEnd();
	}
	
	// --------------------------------------------------
	

	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	public ILineHelper clone() {
		StreamLineHelper answer = new StreamLineHelper();
		answer.tree = tree.clone();
		return answer;
	}
}
