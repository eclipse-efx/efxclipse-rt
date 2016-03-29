package org.eclipse.fx.code.editor.services;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.eclipse.fx.code.editor.Input;
import org.eclipse.jface.text.IDocument;

public interface ProposalComputer {
	public class ProposalContext extends EditingContext {
		public ProposalContext(Input<?> input, IDocument document, int location) {
			super(input, document, location, null);
		}
	}

	public CompletableFuture<List<CompletionProposal>> compute(ProposalContext context);
}
