/**
 * 07/set/2012
 */
package com.eu.evidence.rtdruid.oil.xtext.parser;

import java.util.List;
import java.util.WeakHashMap;

import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.DefaultLocationInFileProvider;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.TextRegionWithLineInformation;

import com.eu.evidence.rtdruid.oil.xtext.parser.ILineConverterHelper.ILineConvertData;

/**
 *
 * @author Nicola Serreli
 * @since 2.0
 *
 */
public class IncldeLocationInFileProvider extends DefaultLocationInFileProvider {
	
	protected class IndexCache {
		final int offset;
		final int startLine;
		final int endLine;
		final int length;
		
		/**
		 * 
		 */
		public IndexCache(INode node, ILineConverterHelper helper) {
			ILineConvertData dataStart = helper.getMainIndex(node.getOffset());
			ILineConvertData dataStop = helper.getMainIndex(node.getLength() + node.getOffset());
			this.offset = dataStart.getOffset();
			this.length = dataStop.getOffset() - dataStart.getOffset();
			this.startLine = dataStart.getLine() - 1;
			this.endLine = dataStop.getLine() - 1;
		}
	}
	
	WeakHashMap<INode, IndexCache> indexes = new WeakHashMap<INode, IncldeLocationInFileProvider.IndexCache>();

	protected ITextRegion createRegion(final List<INode> nodes) {
		ITextRegion result = ITextRegion.EMPTY_REGION;
		if (nodes.size()>0) {
			ILineConverterHelper helper = Utils.getLineHelper(nodes.get(0));
		
			if (helper != null) {
			
				for (INode node : nodes) {
					if (!isHidden(node)) {
						
						IndexCache values = getIndex(node, helper);
						if (values.length != 0)
							result = result.merge(new TextRegionWithLineInformation(
									values.offset,
									values.length,
									values.startLine,
									values.endLine));
					}
				}
			} else {
				result = super.createRegion(nodes);
			}
		}
		return result;
	}
	
	/**
	 * @since 2.3
	 */
	protected ITextRegion createRegion(List<INode> nodes, RegionDescription query) {
		ITextRegion result = ITextRegion.EMPTY_REGION;
		if (nodes.size()>0) {
			ILineConverterHelper helper = Utils.getLineHelper(nodes.get(0));
		
			if (helper != null) {
			
				if (query == RegionDescription.FULL || query == RegionDescription.SIGNIFICANT)
					return createRegion(nodes);
				for (INode node : nodes) {
					for(INode leafNode: node.getLeafNodes()) {
						if (!isHidden(leafNode, query)) {
							IndexCache values = getIndex(leafNode, helper);
							if (values.length != 0)
								result = result.merge(new TextRegionWithLineInformation(
										values.offset,
										values.length,
										values.startLine,
										values.endLine));
						}
					}
				}
			} else {
				result = super.createRegion(nodes);
			}
		}
		return result;

		
	}

	
	protected IndexCache getIndex(INode node, ILineConverterHelper helper) {
		IndexCache answer = indexes.get(node);
		if (answer == null) {
			answer = new IndexCache(node, helper);
			indexes.put(node, answer);
		}
		return answer;
	}
	
}
