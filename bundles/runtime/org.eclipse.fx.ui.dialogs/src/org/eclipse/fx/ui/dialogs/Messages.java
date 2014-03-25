package org.eclipse.fx.ui.dialogs;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * Message loading
 */
public class Messages {
	private static final String BUNDLE_NAME = "org.eclipse.fx.ui.dialogs.messages"; //$NON-NLS-1$

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle
			.getBundle(BUNDLE_NAME);

	private Messages() {
	}

	/**
	 * Translate the given key
	 * 
	 * @param key
	 *            the key
	 * @return the value
	 */
	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
}
