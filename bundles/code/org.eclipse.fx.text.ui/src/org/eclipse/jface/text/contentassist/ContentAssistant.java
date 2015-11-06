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
package org.eclipse.jface.text.contentassist;

import java.util.List;
import java.util.function.Function;

import javafx.geometry.Point2D;
import javafx.scene.input.KeyCode;

import org.eclipse.fx.ui.controls.styledtext.VerifyEvent;
import org.eclipse.jface.text.ITextViewer;

public class ContentAssistant implements IContentAssistant {
	private final Function<Integer, List<ICompletionProposal>> proposalComputer;
	private ITextViewer viewer;
	private ContentProposalPopup popuop;

	public ContentAssistant(Function<Integer, List<ICompletionProposal>> proposalComputer) {
		this.proposalComputer = proposalComputer;
	}

	@Override
	public void install(ITextViewer textViewer) {
		if( this.viewer == null ) {
			this.viewer = textViewer;
			this.popuop = new ContentProposalPopup(textViewer,proposalComputer);
			textViewer.getTextWidget().addEventHandler(VerifyEvent.VERIFY, this::handleVerify);
		}
	}

	private void handleVerify(VerifyEvent event) {
		if( !(event.isControlDown() && event.getCode() == KeyCode.SPACE) ) {
			return;
		}
		event.consume();

		List<ICompletionProposal> proposals = proposalComputer.apply(this.viewer.getTextWidget().getCaretOffset());

		if( proposals.size() == 1) {
			proposals.get(0).apply(this.viewer.getDocument());
			this.viewer.getTextWidget().setSelection(proposals.get(0).getSelection(this.viewer.getDocument()));
		} else if( ! proposals.isEmpty() ) {
//			System.err.println(this.viewer.getTextWidget().getCaretLocation());
			System.err.println();

			Point2D p = this.viewer.getTextWidget().getLocationAtOffset(this.viewer.getTextWidget().getCaretOffset());
			System.err.println(p);
			this.popuop.displayProposals(proposals, this.viewer.getTextWidget().getCaretOffset(), this.viewer.getTextWidget().localToScreen(p));
		}
	}
}
