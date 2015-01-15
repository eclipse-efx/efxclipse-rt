package org.eclipse.fx.code.compensator.editor.spi;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.eclipse.fx.code.compensator.editor.Input;
import org.eclipse.fx.code.compensator.editor.ProposalComputer;
import org.eclipse.fx.code.compensator.editor.services.FileIconProvider;
import org.eclipse.fx.code.compensator.editor.services.PartitionerFactory;
import org.eclipse.fx.code.compensator.editor.services.ProposalComputerFactory;
import org.eclipse.fx.code.compensator.editor.services.SourceViewerConfigurationFactory;

public abstract class BaseLanguageComponent implements PartitionerFactory, SourceViewerConfigurationFactory, FileIconProvider {
	private List<ProposalComputerFactory> proposalComputerFactoryList = new ArrayList<ProposalComputerFactory>();

	public void registerProposalComputerFactory(ProposalComputerFactory factory) {
		synchronized (proposalComputerFactoryList) {
			proposalComputerFactoryList.add(factory);
		}
	}

	public void unregisterProposalComputerFactory(ProposalComputerFactory factory) {
		synchronized (proposalComputerFactoryList) {
			proposalComputerFactoryList.remove(factory);
		}
	}

	protected Optional<ProposalComputer> createProposalComputer(Input<?> input) {
		return proposalComputerFactoryList.stream().filter(c -> c.applies(input)).map(c -> c.createProposalComputer()).findFirst();
	}
}
