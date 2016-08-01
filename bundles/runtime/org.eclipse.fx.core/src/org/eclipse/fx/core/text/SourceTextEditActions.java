package org.eclipse.fx.core.text;

import org.eclipse.fx.core.text.TextEditAction;

/**
 * {@link TextEditAction} constants for source editing
 *
 */
public enum SourceTextEditActions implements TextEditAction {

	/**
	 * Action triggered on autocomplete
	 */
	PROPOSAL_REQUEST(true);

	private boolean modification;

	private SourceTextEditActions(boolean modification) {
		this.modification = modification;
	}

	@Override
	public boolean isModification() {
		return this.modification;
	}
}
