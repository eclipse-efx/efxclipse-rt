package org.eclipse.fx.code.editor.fx.services;

import org.eclipse.fx.code.editor.services.CompletionProposal;
import org.eclipse.fx.text.ui.contentassist.ICompletionProposal;

@SuppressWarnings("restriction")
public interface CompletionProposalPresenter {
	public ICompletionProposal createProposal(CompletionProposal proposal);
}
