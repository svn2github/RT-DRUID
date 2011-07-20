package com.eu.evidence.rtdruid.modules.oil.ui.editor.text;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * A bundle for Oil Text Editor. Contains labels for Actions.
 */
public class OilTextEditorBundle {
	public final static String CONTENT_ASSIST_PROPOSAL_PREFIX = "ContentAssistProposal.";

	/** Resource bundle. */
	private static final ResourceBundle resourceBundle;

	/**
	 * This little Bundle contains labels for OilTextEditor's Actions
	 */
	private static class Bundle extends java.util.ListResourceBundle {
		protected Object[][] getContents() {
			return new Object[][] {
					{ CONTENT_ASSIST_PROPOSAL_PREFIX + "label",
							"Content &Assist@Ctrl+Space" },
					{ CONTENT_ASSIST_PROPOSAL_PREFIX + "tooltip",
							"Content Assist" },
					{ CONTENT_ASSIST_PROPOSAL_PREFIX + "image", "" },
					{ CONTENT_ASSIST_PROPOSAL_PREFIX + "description",
							"Content Assist" }, };
		};
	}

	/** Init */
	static {
		resourceBundle = new Bundle();
	}

	// ----------------------------------------------------

	/**
	 * Returns the string from the plugin's resource bundle, or 'key' if not
	 * found.
	 */
	public static String getResourceString(String key) {
		try {
			return (resourceBundle != null) ? resourceBundle.getString(key)
					: key;
		} catch (MissingResourceException e) {
			return key;
		}
	}

	/**
	 * Returns the resource bundle,
	 */
	public static ResourceBundle getResourceBundle() {
		return resourceBundle;
	}
}