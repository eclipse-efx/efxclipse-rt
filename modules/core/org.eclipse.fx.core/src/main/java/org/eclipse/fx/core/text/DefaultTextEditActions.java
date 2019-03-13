package org.eclipse.fx.core.text;

/**
 * basic {@link TextEditAction} constants
 *
 */
public enum DefaultTextEditActions implements TextEditAction {
	/**
	 * Action to delete previous word
	 */
	DELETE_WORD_PREVIOUS(true),
	/**
	 * Action to delete next word
	 */
	DELETE_WORD_NEXT(true),

	// NAVIGATION
	/**
	 * Action to go to the next word
	 */
	WORD_NEXT(false),
	/**
	 * Action to go to the previous word
	 */
	WORD_PREVIOUS(false),
	/**
	 * Action to go to the line start
	 */
	LINE_START(false),
	/**
	 * Action to go to the line end
	 */
	LINE_END(false),
	/**
	 * Action to go the start of the text
	 */
	TEXT_START(false),
	/**
	 * Action to go the end of the text
	 */
	TEXT_END(false),
	/**
	 * Action to go one page down
	 */
	TEXT_PAGE_DOWN(false),
	/**
	 * Action to go one page up
	 */
	TEXT_PAGE_UP(false),

	// SELECT
	/**
	 * Action to select the next word
	 */
	SELECT_WORD_NEXT(false),
	/**
	 * Action to select the previous word
	 */
	SELECT_WORD_PREVIOUS(false),
	/**
	 * Action to select the word at the current caret position
	 */
	SELECT_WORD(false),
	/**
	 * Action to select the line at the current caret position
	 */
	SELECT_LINE(false),
	/**
	 * Action to select until the start of the line
	 */
	SELECT_LINE_START(false),
	/**
	 * Action to select until the end of the line
	 */
	SELECT_LINE_END(false),
	/**
	 * Action to select to the start of the text
	 */
	SELECT_TEXT_START(false),
	/**
	 * Action to select to the end of the text
	 */
	SELECT_TEXT_END(false),
	/**
	 * Action to select a page down
	 */
	SELECT_TEXT_PAGE_DOWN(false),
	/**
	 * Action to select a page up
	 */
	SELECT_TEXT_PAGE_UP(false),

	// Editing
	/**
	 * Action to create a new line
	 */
	NEW_LINE(true),

	/**
	 * Action to indent current line
	 */
	INDENT(true),

	/**
	 * opposite operation of {@link #INDENT}
	 */
	OUTDENT(true),

	/**
	 * Action to select all
	 */
	SELECT_ALL(false),

	/**
	 * Action to move lines up
	 */
	MOVE_LINES_UP(true),
	/**
	 * Action to move lines down
	 */
	MOVE_LINES_DOWN(true),
	/**
	 * Action to cut
	 */
	CUT(true),
	/**
	 * Action to copy
	 */
	COPY(false),
	/**
	 * Action to paste
	 */
	PASTE(true),

	/**
	 * Action to delete
	 */
	DELETE(true),

	/**
	 * Action to delete previous
	 */
	DELETE_PREVIOUS(true),

	/**
	 * Action to delete line
	 */
	DELETE_LINE(true),

	/**
	 * scroll up while keeping the caret
	 */
	SCROLL_LINE_UP(false),
	/**
	 * scroll down while keeping the caret
	 */
	SCROLL_LINE_DOWN(false),

	/**
	 * navigate to line
	 */
	NAVIGATE_TO_LINE(false),

	/**
	 * move caret up
	 */
	MOVE_UP(false),

	/**
	 * move caret down
	 */
	MOVE_DOWN(false),

	/**
	 * move caret left
	 */
	MOVE_LEFT(false),

	/**
	 * move caret right
	 */
	MOVE_RIGHT(false),

	/**
	 * move caret up while selecting
	 */
	SELECT_UP(false),

	/**
	 * move caret down while selecting
	 */
	SELECT_DOWN(false),

	/**
	 * move caret left while selecting
	 */
	SELECT_LEFT(false),

	/**
	 * move caret right while selecting
	 */
	SELECT_RIGHT(false);

	private boolean modification;

	private DefaultTextEditActions(boolean modification) {
		this.modification = modification;
	}

	@Override
	public boolean isModification() {
		return this.modification;
	}
}
