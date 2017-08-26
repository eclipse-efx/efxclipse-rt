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

	/**
	 * @return true if the action modifies the text
	 */
	public default boolean isModification() {
		return false;
	}
}
