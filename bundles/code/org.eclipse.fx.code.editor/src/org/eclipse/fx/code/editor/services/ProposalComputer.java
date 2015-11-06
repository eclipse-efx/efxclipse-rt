package org.eclipse.fx.code.editor.services;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.eclipse.fx.code.editor.Input;

public interface ProposalComputer {
	public class ProposalContext {
		public final Input<?> input;
		public final int location;

		public ProposalContext(Input<?> input, int location) {
			this.input = input;
			this.location = location;
		}
	}

	public CompletableFuture<List<CompletionProposal>> compute(ProposalContext context);
}
