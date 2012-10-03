package com.eu.evidence.rtdruid.oil.xtext.parser;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.eclipse.xtext.linking.lazy.LazyLinkingResource;
import org.eclipse.xtext.parser.IParser;

public class MyResource extends LazyLinkingResource {
	
	/* (non-Javadoc)
	 * @see org.eclipse.xtext.linking.lazy.LazyLinkingResource#doLoad(java.io.InputStream, java.util.Map)
	 */
	@Override
	protected void doLoad(InputStream inputStream, Map<?, ?> options) throws IOException {
		if (uri != null) {
			IParser parser = getParser();
			if (parser != null && parser instanceof MainOilParser) {
				((MainOilParser)parser).setStreamName(uri);
			}
		}
		super.doLoad(inputStream, options);
	}
	
}