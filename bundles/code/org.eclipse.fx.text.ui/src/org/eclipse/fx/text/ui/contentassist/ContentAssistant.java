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
import java.util.Optional;
import java.util.function.Function;

import org.eclipse.fx.text.ui.ITextViewer;
import org.eclipse.fx.ui.controls.styledtext.StyledTextArea.LineLocation;
import org.eclipse.fx.ui.controls.styledtext.VerifyEvent;
import org.eclipse.jface.text.IDocument;

import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.geometry.Point2D;
import javafx.scene.input.KeyCode;
import javafx.util.Duration;

public class ContentAssistant implements IContentAssistant {
	private final Function<ContentAssistContextData, List<ICompletionProposal>> proposalComputer;
	private ITextViewer fViewer;
	private ContentProposalPopup fProposalPopup;
	private ContextInformationPopup fContextInfoPopup;

	private String autoTriggers = null;
	public void setAutoTriggers(String autoTriggers) {
		this.autoTriggers = autoTriggers;
	}

	public ContentAssistant(Function<ContentAssistContextData, List<ICompletionProposal>> proposalComputer) {
		this.proposalComputer = proposalComputer;
	}

	@Override
	public void install(ITextViewer textViewer) {
		if( this.fViewer == null ) {
			this.fViewer = textViewer;
			this.fProposalPopup = new ContentProposalPopup(this, textViewer, proposalComputer);

			textViewer.getTextWidget().addEventHandler(VerifyEvent.VERIFY, this::handleVerify);

			fContextInfoPopup = new ContextInformationPopup(this, textViewer);
		}
	}

	private void handleVerify(VerifyEvent event) {

		boolean autoTrigger = !event.getText().isEmpty() && autoTriggers != null && autoTriggers.contains(event.getText());
		boolean defaultTrigger = event.isControlDown() && event.getCode() == KeyCode.SPACE;

		if( !(autoTrigger || defaultTrigger) ) {
			return;
		}

		if (defaultTrigger) {
			// we cannot consume auto triggers, since they need to be inserted into the document
			event.consume();
		}

		// the proposal needs to be delayed until the char was typed
		Platform.runLater(()-> {

			final int offset = this.fViewer.getTextWidget().getCaretOffset();

			System.err.println("caret offset = " + offset);

			List<ICompletionProposal> proposals = proposalComputer.apply(new ContentAssistContextData(offset, this.fViewer.getDocument()/*,""*/));



			if( proposals.size() == 1) {
				ICompletionProposal completionProposal = proposals.get(0);

				completionProposal.apply(this.fViewer.getDocument());

				showContextInformation(completionProposal.getContextInformation(), offset);

				//this.fViewer.getTextWidget().setSelection(proposals.get(0).getSelection(this.fViewer.getDocument()));
			} else if( ! proposals.isEmpty() ) {
	//			System.err.println(this.viewer.getTextWidget().getCaretLocation());
				System.err.println();

				Point2D p = this.fViewer.getTextWidget().getLocationAtOffset(this.fViewer.getTextWidget().getCaretOffset(), LineLocation.BELOW);
				System.err.println(p);

				Point2D coords = this.fViewer.getTextWidget().localToScreen(p);
				System.err.println(coords);

				Optional<ICompletionProposal> chosenProposal = this.fProposalPopup.displayProposals(proposals, this.fViewer.getTextWidget().getCaretOffset(), coords);
				System.err.println("Chosen: " + chosenProposal.map(c->c.getLabel()));

				chosenProposal.ifPresent(proposal->{
					IDocument document = this.fViewer.getDocument();
					// apply the proposal
					proposal.apply(document);
					this.setAutoTriggers(autoTriggers);
					this.fViewer.getTextWidget().setSelection(proposal.getSelection(document));

					if (proposal.getContextInformation() != null) {
						showContextInformation(proposal.getContextInformation(), fViewer.getTextWidget().getCaretOffset());
					}

				});
			}

			fViewer.getTextWidget().layout();
		});

	}

	void showContextInformation(IContextInformation contextInformation, int offset) {
		if (this.fContextInfoPopup != null) {
			this.fContextInfoPopup.showContextInformation(contextInformation, offset);
		}
	}
}
