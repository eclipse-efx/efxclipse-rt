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

import java.util.List;
import java.util.function.Function;

import javafx.geometry.Point2D;
import javafx.scene.input.KeyCode;

import org.eclipse.fx.text.ui.ITextViewer;
import org.eclipse.fx.ui.controls.styledtext.VerifyEvent;

public class ContentAssistant implements IContentAssistant {
	private final Function<ContentAssistContextData, List<ICompletionProposal>> proposalComputer;
	private ITextViewer fViewer;
	private ContentProposalPopup fProposalPopup;
	private ContextInformationPopup fContextInfoPopup;

	public ContentAssistant(Function<ContentAssistContextData, List<ICompletionProposal>> proposalComputer) {
		this.proposalComputer = proposalComputer;
	}

	@Override
	public void install(ITextViewer textViewer) {
		if( this.fViewer == null ) {
			this.fViewer = textViewer;
			this.fProposalPopup = new ContentProposalPopup(this, textViewer,proposalComputer);
			textViewer.getTextWidget().addEventHandler(VerifyEvent.VERIFY, this::handleVerify);

			fContextInfoPopup = new ContextInformationPopup(this, textViewer);
		}
	}

	private void handleVerify(VerifyEvent event) {
		if( !(event.isControlDown() && event.getCode() == KeyCode.SPACE) ) {
			return;
		}
		event.consume();

		final int offset = this.fViewer.getTextWidget().getCaretOffset();

		List<ICompletionProposal> proposals = proposalComputer.apply(new ContentAssistContextData(offset, this.fViewer.getDocument()/*,""*/));

		if( proposals.size() == 1) {
			ICompletionProposal completionProposal = proposals.get(0);

			completionProposal.apply(this.fViewer.getDocument());

			showContextInformation(completionProposal.getContextInformation(), offset);

			//this.fViewer.getTextWidget().setSelection(proposals.get(0).getSelection(this.fViewer.getDocument()));
		} else if( ! proposals.isEmpty() ) {
//			System.err.println(this.viewer.getTextWidget().getCaretLocation());
			System.err.println();

			Point2D p = this.fViewer.getTextWidget().getLocationAtOffset(this.fViewer.getTextWidget().getCaretOffset());
			System.err.println(p);
			this.fProposalPopup.displayProposals(proposals, this.fViewer.getTextWidget().getCaretOffset(), this.fViewer.getTextWidget().localToScreen(p));
		}

	}

	void showContextInformation(IContextInformation contextInformation, int offset) {
		if (this.fContextInfoPopup != null) {
			this.fContextInfoPopup.showContextInformation(contextInformation, offset);
		}
	}
}
