/*******************************************************************************
 * Copyright (c) 2022 BestSolution.at and others.
 *  
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *  
 * SPDX-License-Identifier: EPL-2.0
 *  
 * Contributors:
 *     BestSolution.at - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.code.compensator.editor.contrib;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.eclipse.e4.core.contexts.ContextFunction;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.fx.code.compensator.editor.Input;
import org.eclipse.fx.code.compensator.editor.ProposalComputer;
import org.eclipse.fx.code.compensator.editor.services.ProposalComputerFactory;

public class ProposalComputerContextFunction extends ContextFunction {
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

	@Override
	public Object compute(IEclipseContext context, String contextKey) {
		Input<?> input = context.get(Input.class);
		// need to split up because of bug in JDT
		Stream<Class<? extends ProposalComputer>> map = proposalComputerFactoryList.stream().filter(c -> c.applies(input)).map(c -> c.createProposalComputer());
		Optional<Class<? extends ProposalComputer>> findFirst = map.findFirst();
		if( findFirst.isPresent() ) {
			return ContextInjectionFactory.make(findFirst.get(), context);
		}
		return null;
	}
}
