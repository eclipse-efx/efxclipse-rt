package org.eclipse.fx.core.text;

import org.eclipse.fx.core.text.TextEditAction;

/**
 * basic {@link TextEditAction} constants
 *
 */
public enum DefaultTextEditActions implements TextEditAction {
	/**
	 * Action to delete previous word
	 */
	DELETE_WORD_PREVIOUS,
	/**
	 * Action to delete next word
	 */
	DELETE_WORD_NEXT,

	// NAVIGATION
	/**
	 * Action to go to the next word
	 */
	WORD_NEXT,
	/**
	 * Action to go to the previous word
	 */
	WORD_PREVIOUS,
	/**
	 * Action to go to the line start
	 */
	LINE_START,
	/**
	 * Action to go to the line end
	 */
	LINE_END,
	/**
	 * Action to go the start of the text
	 */
	TEXT_START,
	/**
	 * Action to go the end of the text
	 */
	TEXT_END,
	/**
	 * Action to go one page down
	 */
	TEXT_PAGE_DOWN,
	/**
	 * Action to go one page up
	 */
	TEXT_PAGE_UP,

	// SELECT
	/**
	 * Action to select the next word
	 */
	SELECT_WORD_NEXT,
	/**
	 * Action to select the previous word
	 */
	SELECT_WORD_PREVIOUS,
	/**
	 * Action to select the word at the current caret position
	 */
	SELECT_WORD,
	/**
	 * Action to select the line at the current caret position
	 */
	SELECT_LINE,
	/**
	 * Action to select until the start of the line
	 */
	SELECT_LINE_START,
	/**
	 * Action to select until the end of the line
	 */
	SELECT_LINE_END,
	/**
	 * Action to select to the start of the text
	 */
	SELECT_TEXT_START,
	/**
	 * Action to select to the end of the text
	 */
	SELECT_TEXT_END,
	/**
	 * Action to select a page down
	 */
	SELECT_TEXT_PAGE_DOWN,
	/**
	 * Action to select a page up
	 */
	SELECT_TEXT_PAGE_UP,

	// Editing
	/**
	 * Action to create a new line
	 */
	NEW_LINE,

	/**
	 * Action to indent current line
	 */
	INDENT,

	/**
	 * opposite operation of {@link #INDENT}
	 */
	OUTDENT,

	/**
	 * Action to select all
	 */
	SELECT_ALL,

	/**
	 * Action to move lines up
	 */
	MOVE_LINES_UP,
	/**
	 * Action to move lines down
	 */
	MOVE_LINES_DOWN,
	/**
	 * Action to cut
	 */
	CUT,
	/**
	 * Action to copy
	 */
	COPY,
	/**
	 * Action to paste
	 */
	PASTE,

	/**
	 * Action to delete
	 */
	DELETE,

	/**
	 * Action to delete previous
	 */
	DELETE_PREVIOUS,

	/**
	 * Action to delete line
	 */
	DELETE_LINE,

	/**
	 * scroll up while keeping the caret
	 */
	SCROLL_LINE_UP,
	/**
	 * scroll down while keeping the caret
	 */
	SCROLL_LINE_DOWN,

	/**
	 * navigate to line
	 */
	NAVIGATE_TO_LINE,

	/**
	 * move caret up
	 */
	MOVE_UP,

	/**
	 * move caret down
	 */
	MOVE_DOWN,

	/**
	 * move caret left
	 */
	MOVE_LEFT,

	/**
	 * move caret right
	 */
	MOVE_RIGHT,

	/**
	 * move caret up while selecting
	 */
	SELECT_UP,

	/**
	 * move caret down while selecting
	 */
	SELECT_DOWN,

	/**
	 * move caret left while selecting
	 */
	SELECT_LEFT,

	/**
	 * move caret right while selecting
	 */
	SELECT_RIGHT

}
