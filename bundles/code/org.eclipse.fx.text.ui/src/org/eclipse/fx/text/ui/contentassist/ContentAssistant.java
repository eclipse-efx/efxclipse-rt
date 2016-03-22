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

import org.eclipse.fx.core.ThreadSynchronize;
import org.eclipse.fx.text.ui.ITextViewer;
import org.eclipse.fx.ui.controls.styledtext.StyledTextArea.LineLocation;
import org.eclipse.fx.ui.controls.styledtext.VerifyEvent;
import org.eclipse.jface.text.IDocument;

import javafx.application.Platform;
import javafx.geometry.Point2D;
import javafx.scene.input.KeyCode;

@SuppressWarnings("restriction")
public class ContentAssistant implements IContentAssistant {
	private final Function<ContentAssistContextData, List<ICompletionProposal>> proposalComputer;
	private ITextViewer fViewer;
	private ContentProposalPopup fProposalPopup;
	private ContextInformationPopup fContextInfoPopup;
	private final ThreadSynchronize threadSynchnronize;

	private String autoTriggers = null;
	public void setAutoTriggers(String autoTriggers) {
		this.autoTriggers = autoTriggers;
	}

	public ContentAssistant(ThreadSynchronize threadSynchnronize, Function<ContentAssistContextData, List<ICompletionProposal>> proposalComputer) {
		this.threadSynchnronize = threadSynchnronize;
		this.proposalComputer = proposalComputer;
	}

	@Override
	public void install(ITextViewer textViewer) {
		if( this.fViewer == null ) {
			this.fViewer = textViewer;
			this.fProposalPopup = new ContentProposalPopup(this.threadSynchnronize, this, textViewer, this.proposalComputer);

			textViewer.getTextWidget().addEventHandler(VerifyEvent.VERIFY, this::handleVerify);

			this.fContextInfoPopup = new ContextInformationPopup(this, textViewer);
		}
	}

	private void handleVerify(VerifyEvent event) {

		boolean autoTrigger = !event.getText().isEmpty() && this.autoTriggers != null && this.autoTriggers.contains(event.getText());
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

			List<ICompletionProposal> proposals = this.proposalComputer.apply(new ContentAssistContextData(offset, this.fViewer.getDocument()/*,""*/));



			if( proposals.size() == 1) {
				ICompletionProposal completionProposal = proposals.get(0);

				completionProposal.apply(this.fViewer.getDocument());

				showContextInformation(completionProposal.getContextInformation(), offset);

				//this.fViewer.getTextWidget().setSelection(proposals.get(0).getSelection(this.fViewer.getDocument()));
			} else if( ! proposals.isEmpty() ) {
				Point2D p = this.fViewer.getTextWidget().getLocationAtOffset(this.fViewer.getTextWidget().getCaretOffset(), LineLocation.BELOW);

				Point2D coords = this.fViewer.getTextWidget().localToScreen(p);

				Optional<ICompletionProposal> chosenProposal = this.fProposalPopup.displayProposals(proposals, this.fViewer.getTextWidget().getCaretOffset(), coords);

				chosenProposal.ifPresent(proposal->{
					IDocument document = this.fViewer.getDocument();
					// apply the proposal
					proposal.apply(document);
					this.setAutoTriggers(this.autoTriggers);
					this.fViewer.getTextWidget().setSelection(proposal.getSelection(document));

					if (proposal.getContextInformation() != null) {
						showContextInformation(proposal.getContextInformation(), this.fViewer.getTextWidget().getCaretOffset());
					}

				});
			}

			this.fViewer.getTextWidget().layout();
		});

	}

	void showContextInformation(IContextInformation contextInformation, int offset) {
		if (this.fContextInfoPopup != null) {
			this.fContextInfoPopup.showContextInformation(contextInformation, offset);
		}
	}
}
