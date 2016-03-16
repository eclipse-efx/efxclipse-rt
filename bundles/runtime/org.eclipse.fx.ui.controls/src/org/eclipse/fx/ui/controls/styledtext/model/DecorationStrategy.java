package org.eclipse.fx.ui.controls.styledtext.model;

import org.eclipse.fx.ui.controls.styledtext.internal.TextNode;

import javafx.scene.layout.Pane;

/**
	 * A strategy to decorate the text
	 */
	public interface DecorationStrategy {
		/**
		 * Attach the decoration on the text
		 *
		 * @param node
		 *            the node the decoration is attached to
		 * @param textNode
		 *            the text node decorated
		 */
		public void attach(Pane node, TextNode textNode);

		/**
		 * Remove the decoration from the text
		 *
		 * @param node
		 *            the node the decoration is attached to
		 * @param textNode
		 *            the text node decorated
		 */
		public void unattach(Pane node, TextNode textNode);

		/**
		 * Layout the decoration
		 *
		 * @param node
		 *            the node the layout pass is done on
		 * @param textNode
		 *            the text node decorated
		 */
		public void layout(Pane node, TextNode textNode);
	}