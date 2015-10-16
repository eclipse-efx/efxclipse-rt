/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.code.editor.fx.services;

import java.util.List;
import java.util.concurrent.Future;

import org.eclipse.fx.code.editor.Input;
import org.eclipse.jface.text.contentassist.ICompletionProposal;

@SuppressWarnings("restriction")
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
