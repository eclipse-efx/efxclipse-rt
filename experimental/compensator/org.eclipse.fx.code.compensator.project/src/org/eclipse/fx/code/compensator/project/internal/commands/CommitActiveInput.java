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
package org.eclipse.fx.code.compensator.project.internal.commands;

import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.fx.code.compensator.editor.VCSInput;

public class CommitActiveInput {
	public static final String COMMAND_ID = "org.eclipse.fx.code.compensator.project.commit.activeInput";
	@Execute
	public void commit(@Named("activeInput") VCSInput<?> input) {
		input.commit();
	}
}
