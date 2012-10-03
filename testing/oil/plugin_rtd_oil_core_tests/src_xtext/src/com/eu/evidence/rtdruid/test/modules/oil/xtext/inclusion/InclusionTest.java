/**
 * 16/lug/2012
 */
package com.eu.evidence.rtdruid.test.modules.oil.xtext.inclusion;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import junit.framework.Assert;
import junit.framework.AssertionFailedError;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipselabs.xtext.utils.unittesting.FluentIssueCollection;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.osgi.framework.Bundle;

import com.eu.evidence.rtdruid.modules.oil.Rtd_oil_corePlugin;
import com.eu.evidence.rtdruid.oil.xtext.model.OilFile;
import com.eu.evidence.rtdruid.oil.xtext.services.OilModelLoader;
import com.eu.evidence.rtdruid.tests.AbstractNamedTest;

/**
 *
 * @author Nicola Serreli
 * @since 2.0
 *
 */
public class InclusionTest extends AbstractNamedTest {
	
	public static class ErrorCollectorWithSize extends ErrorCollector {
		
		int counter = 0;
		
		/* (non-Javadoc)
		 * @see org.junit.rules.ErrorCollector#addError(java.lang.Throwable)
		 */
		@Override
		public void addError(Throwable error) {
			super.addError(error);
			counter ++;
		}
	}
	
	
	@Rule
	public ErrorCollectorWithSize collector= new ErrorCollectorWithSize();

	public final static String BASE_PATH = "/"+InclusionTest.class.getPackage().getName().replace('.', '/');
	
	public static URL getUrl(String filename) throws IOException {
		Bundle b = Rtd_oil_corePlugin.getDefault().getBundle();
		URL url = b.getResource(filename);
		assertNotNull(url);
		
		return FileLocator.toFileURL(url);
	}
	
	public static String getFile(String filename) throws IOException {
		URL loc = getUrl(filename);		
		return loc.getFile();
	}

	/**
	 * @param filePath
	 * @return
	 * @throws IOException
	 */
	private static FluentIssueCollection load(final String filePath) throws IOException {
		ValidationTestHelper tester = new ValidationTestHelper();
		URI file = URI.createFileURI(getFile(filePath));
		
		OilFile model;
		try {
			model = OilModelLoader.instance.load(file, getUrl(filePath).openStream(), null);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		FluentIssueCollection	issues = new FluentIssueCollection(model.eResource(), tester.validate(model), new ArrayList<String>());
		return issues;
	}

	@Test
	public void testSimpleInclude() throws IOException {
		final String filePath = BASE_PATH + "/simpleInclude.oil";

		FluentIssueCollection issues = load(filePath);

    	if (issues.errorsOnly().getIssues().size() != 0) {
    		Assert.fail("\n\nfound unasserted issues " + issues.getSummary() + "\n\n");
    	}
	}

	@Test
	public void testBadSimpleInclude() throws IOException {
		final String filePath = BASE_PATH + "/badSimpleInclude.oil";

		FluentIssueCollection issues = load(filePath);

    	collector.checkThat(issues.errorsOnly().getIssues().size(), equalTo(1));
    	
    	collector.checkThat(issues.errorsOnly().oneOfThemContains("CPU").evaluate(), equalTo(true));
    	
    	if (collector.counter > 0) {
			collector.addError(new AssertionFailedError(issues.getSummary()));
    	}
	}

	@Test
	public void testTripleIncludeError() throws IOException {
		final String filePath = BASE_PATH + "/tripleIncludeError.oil";

		FluentIssueCollection issues = load(filePath);

    	collector.checkThat(issues.errorsOnly().getIssues().size(), equalTo(3));
    	
    	collector.checkThat(issues.errorsOnly().oneOfThemContains("NOT_VALID").evaluate(), equalTo(true));
    	collector.checkThat(issues.errorsOnly().oneOfThemContains("TRUE").evaluate(), equalTo(true));
    	collector.checkThat(issues.errorsOnly().oneOfThemContains("STRING").evaluate(), equalTo(true));
    	
    	if (collector.counter > 0) {
			collector.addError(new AssertionFailedError(issues.getSummary()));
    	}
	}
	
	@Test
	public void testTripleIncludeError_with_line_check() throws IOException {
		final String filePath = BASE_PATH + "/tripleIncludeError.oil";

		FluentIssueCollection issues = load(filePath);

		collector.checkThat(issues.errorsOnly().getIssues().size(), equalTo(3));

    	collector.checkThat(issues.errorsOnly().inLine(2).oneOfThemContains("NOT_VALID").evaluate(), equalTo(true));
    	collector.checkThat(issues.errorsOnly().inLine(2).oneOfThemContains("TRUE").evaluate(), equalTo(true));
    	collector.checkThat(issues.errorsOnly().inLine(2).oneOfThemContains("STRING").evaluate(), equalTo(true));
    	
    	if (collector.counter > 0) {
			collector.addError(new AssertionFailedError(issues.getSummary()));
    	}
	}

	
}
