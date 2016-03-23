/*******************************************************************************
 * Copyright (c) 2000, 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.text.ui.contentassist;

import org.eclipse.fx.ui.controls.styledtext.TextSelection;
import org.eclipse.jface.text.IDocument;

import javafx.scene.Node;

/**
 * Graphical representation of the proposal
 */
@SuppressWarnings("restriction")
public interface ICompletionProposal {
	/**
	 * @return the label to display
	 */
	public CharSequence getLabel();

	/**
	 * @return the hover information to show
	 */
	public CharSequence getHoverInfo();

	/**
	 * @return the graphic information to show
	 */
	public Node getGraphic();

	/**
	 * Inserts the proposed completion into the given document.
	 *
	 * @param document the document into which to insert the proposed completion
	 */
	public void apply(IDocument document);

	/**
	 * Returns the new selection after the proposal has been applied to
	 * the given document in absolute document coordinates. If it returns
	 * <code>null</code>, no new selection is set.
	 *
	 * A document change can trigger other document changes, which have
	 * to be taken into account when calculating the new selection. Typically,
	 * this would be done by installing a document listener or by using a
	 * document position during {@link #apply(IDocument)}.
	 *
	 * @param document the document into which the proposed completion has been inserted
	 * @return the new selection
	 */
	public TextSelection getSelection(IDocument document);

	/**
	 * Returns optional context information associated with this proposal.
	 * The context information will automatically be shown if the proposal
	 * has been applied.
	 *
	 * @return the context information for this proposal or <code>null</code>
	 */
	IContextInformation getContextInformation();
}
