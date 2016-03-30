/*******************************************************************************
* Copyright (c) 2016 BestSolution.at and others.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
* 	Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
*******************************************************************************/
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
