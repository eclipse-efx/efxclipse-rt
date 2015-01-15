package org.eclipse.fx.code.compensator.editor.spi;

import java.util.Optional;

import org.eclipse.fx.code.compensator.editor.ProposalComputer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;

public abstract class BaseSourceViewerConfiguration extends SourceViewerConfiguration {
	private final Optional<ProposalComputer> proposalComputer;

	public BaseSourceViewerConfiguration(Optional<ProposalComputer> proposalComputer) {
		this.proposalComputer = proposalComputer;
	}
}
