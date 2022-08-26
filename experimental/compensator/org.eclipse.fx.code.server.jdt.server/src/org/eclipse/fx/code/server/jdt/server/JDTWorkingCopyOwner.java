/*******************************************************************************
 * Copyright (c) 2012 BestSolution.at and others.
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
package org.eclipse.fx.code.server.jdt.server;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IProblemRequestor;
import org.eclipse.jdt.core.WorkingCopyOwner;

public class JDTWorkingCopyOwner extends WorkingCopyOwner {
	private final IProblemRequestor problemRequestor;

	public JDTWorkingCopyOwner(IProblemRequestor problemRequestor) {
		this.problemRequestor = problemRequestor;
	}

	@Override
		public IProblemRequestor getProblemRequestor(ICompilationUnit workingCopy) {
			return problemRequestor;
		}
}
