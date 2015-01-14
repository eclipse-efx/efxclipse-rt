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
package org.eclipse.fx.code.compensator.editor;

import java.util.List;
import java.util.function.Consumer;


public interface ContentAssist {
	public class Proposal {
		public final CharSequence label;

		public Proposal(CharSequence label) {
			this.label = label;
		}
	}

	public class ProposalContext {
		public Input<?> input;
		public int location;

		public ProposalContext(Input<?> input, int location) {
			this.input = input;
			this.location = location;
		}
	}

	public void collectProposals(ProposalContext context, Consumer<List<Proposal>> proposals);
}
