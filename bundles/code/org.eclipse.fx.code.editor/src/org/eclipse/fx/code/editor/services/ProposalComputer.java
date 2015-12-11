package org.eclipse.fx.code.editor.services;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.eclipse.fx.code.editor.Input;
import org.eclipse.jface.text.IDocument;

public interface ProposalComputer {
	public class ProposalContext {
		public final Input<?> input;
		public final IDocument document;
		public final int location;

		public ProposalContext(Input<?> input, IDocument document, int location) {
			this.input = input;
			this.document = document;
			this.location = location;
		}
	}

	public CompletableFuture<List<CompletionProposal>> compute(ProposalContext context);
}
