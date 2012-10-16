/**
 * 15/ott/2012
 */
package com.eu.evidence.rtdruid.oil.xtext.ui.document;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.formatter.IContentFormatter;
import org.eclipse.jface.text.formatter.IFormattingStrategy;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.xtext.formatting.INodeModelFormatter;
import org.eclipse.xtext.formatting.INodeModelFormatter.IFormattedRegion;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.formatting.IContentFormatterFactory;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.reconciler.ReplaceRegion;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.eu.evidence.rtdruid.oil.xtext.parser.ILineConverterHelper;
import com.eu.evidence.rtdruid.oil.xtext.parser.ILineConverterHelper.IRange;
import com.eu.evidence.rtdruid.oil.xtext.parser.Utils;
import com.google.inject.Inject;

/**
 *
 * @author Nicola Serreli
 * @since 2.0
 *
 */
public class OilContentFormatterFactory implements IContentFormatterFactory {

	public class ContentFormatter implements IContentFormatter {
		public void format(IDocument document, IRegion region) {
			IXtextDocument doc = (IXtextDocument) document;
			ReplaceRegion r = doc.readOnly(new OilFormattingUnitOfWork(region));
			try {
				if (r != null)
					doc.replace(r.getOffset(), r.getLength(), r.getText());
			} catch (BadLocationException e) {
				throw new RuntimeException(e);
			}
		}

		public IFormattingStrategy getFormattingStrategy(String contentType) {
			return null;
		}
	}

	public class OilFormattingUnitOfWork implements
			IUnitOfWork<ReplaceRegion, XtextResource> {

		protected final IRegion region;

		public OilFormattingUnitOfWork(IRegion region) {
			super();
			this.region = region;
		}

		public ReplaceRegion exec(XtextResource state) throws Exception {
			IParseResult parseResult = state.getParseResult();
			if (parseResult == null)
				return null;
			
			
			ILineConverterHelper helper = Utils.getLineHelper(parseResult);
			if (helper != null) {
				final int editorStart = region.getOffset();
				final int editorStop = editorStart + region.getLength();

				StringBuilder builder = new StringBuilder();
				int replaceEditorOffset = -1;
				int replacingLength = 0;
				for (IRange range : helper.getMainSections()) {
					
					if (range.getStart()>editorStop ) {
						// this and following ranges does not contain required region
						break;
					}
					
					
					
					if (range.inMainRange(editorStart) || replaceEditorOffset >-1) {
						
						int rangeModelStart = range.computeOffset(replaceEditorOffset == -1 ? editorStart : range.getStart());
						int rangeModelSize = range.computeOffset(Math.min(editorStop, range.getEnd())) - rangeModelStart;
						
						if (rangeModelSize >0) {
							// do not handle empty regions
							IFormattedRegion r = formatter.format(parseResult.getRootNode(), rangeModelStart, rangeModelSize);
							builder.append(r.getFormattedText());
							replacingLength += r.getLength();
							
							if (replaceEditorOffset == -1) {
								replaceEditorOffset = helper.getMainIndex(r.getOffset()).getOffset();
							}
						}
					}
					
				}
				
				if (replaceEditorOffset != -1) {
					return new ReplaceRegion(replaceEditorOffset, replacingLength, builder.toString());
				} else {
					// it should be empty
					return new ReplaceRegion(region.getOffset(), replacingLength, builder.toString());
				}
				
			}
			

			IFormattedRegion r = formatter.format(parseResult.getRootNode(), region.getOffset(), region.getLength());
			return new ReplaceRegion(r.getOffset(), r.getLength(), r.getFormattedText());
			
		}
	}

	@Inject
	protected INodeModelFormatter formatter;

	public IContentFormatter createConfiguredFormatter(
			SourceViewerConfiguration configuration, ISourceViewer sourceViewer) {
		return new ContentFormatter();
	}

}