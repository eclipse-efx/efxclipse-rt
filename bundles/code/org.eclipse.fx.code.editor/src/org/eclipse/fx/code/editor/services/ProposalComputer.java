package org.eclipse.fx.code.editor.services;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.eclipse.fx.code.editor.Input;

public interface ProposalComputer {
	/**
	 * compute the proposals
	 * <p>you may want to inject one ore more of the following to compute your proposals</p>
	 * <li> {@link EditingContext}
	 * <li> {@link Input}
	 * <li> {@line IDocument}
	 *
	 * @return
	 */
	public CompletableFuture<List<CompletionProposal>> compute();
}
