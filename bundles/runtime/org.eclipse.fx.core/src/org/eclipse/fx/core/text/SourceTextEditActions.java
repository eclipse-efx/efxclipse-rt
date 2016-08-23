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
	PROPOSAL_REQUEST,

	/**
	 * Action to increase font zoom
	 */
	FONT_ZOOM_IN,
	/**
	 * Action to decrease font zoom
	 */
	FONT_ZOOM_OUT,
	/**
	 * Action to reset font zoom
	 */
	FONT_ZOOM_RESET
}
