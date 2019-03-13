package org.eclipse.fx.core.text;

/**
 * {@link TextEditAction} constants for source editing
 *
 */
public enum SourceTextEditActions implements TextEditAction {

	/**
	 * Action triggered on autocomplete
	 */
	PROPOSAL_REQUEST(true),

	/**
	 * Action to increase font zoom
	 */
	FONT_ZOOM_IN(false),
	/**
	 * Action to decrease font zoom
	 */
	FONT_ZOOM_OUT(false),
	/**
	 * Action to reset font zoom
	 */
	FONT_ZOOM_RESET(false);


	private boolean modification;

	private SourceTextEditActions(boolean modification) {
		this.modification = modification;
	}

	@Override
	public boolean isModification() {
		return this.modification;
	}
}