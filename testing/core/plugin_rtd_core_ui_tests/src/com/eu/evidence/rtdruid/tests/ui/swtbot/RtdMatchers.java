/**
 * 05/giu/2012
 */
package com.eu.evidence.rtdruid.tests.ui.swtbot;

import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.allOf;
import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.anyOf;
import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.widgetOfType;
import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.withText;
import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.withTextIgnoringCase;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.swt.widgets.Shell;
import org.hamcrest.Matcher;

/**
 * Contains common matchers
 *
 * @author Nicola Serreli
 * @since 2.0
 *
 */
public class RtdMatchers {

	@SuppressWarnings("unchecked")
	public static Matcher<Shell> getShell(String ... titles) {
		
		Matcher<Shell> matcher;
		{
			Matcher<Shell> type = widgetOfType(Shell.class);
			
			Collection<Matcher<Shell>> titleMatch = new ArrayList<Matcher<Shell>>();
			for (String title: titles) {
				Matcher<Shell> n = withTextIgnoringCase(title);
				titleMatch.add(n);
			}
			matcher = allOf(
					type,
					anyOf((Matcher[]) titleMatch.toArray(new Matcher[titleMatch.size()]))
				  );
		}
		
		return matcher;
	}
	
}
