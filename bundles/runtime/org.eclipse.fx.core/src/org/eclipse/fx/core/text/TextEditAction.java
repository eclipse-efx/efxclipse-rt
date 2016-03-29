package org.eclipse.fx.core.text;

/**
 * marker interface for text edit actions
 */
public interface TextEditAction {

	/**
	 * no operation action for overriding defaults
	 */
	public final static TextEditAction NOOP = new TextEditAction() {
		// empty
	};
}
