/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.code.compensator.editor;

import java.util.List;
import java.util.concurrent.Future;

import org.eclipse.jface.text.contentassist.ICompletionProposal;

public interface ProposalComputer {

	public class ProposalContext {
		public final Input<?> input;
		public final int location;

		public ProposalContext(Input<?> input, int location) {
			this.input = input;
			this.location = location;
		}
	}

	public Future<List<ICompletionProposal>> compute(ProposalContext context);
}
