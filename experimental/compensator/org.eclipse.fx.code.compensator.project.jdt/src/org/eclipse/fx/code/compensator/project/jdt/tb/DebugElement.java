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
package org.eclipse.fx.code.compensator.project.jdt.tb;

import org.eclipse.fx.code.compensator.project.ProjectService.ToolbarElement;

public class DebugElement extends ToolbarElement {

	public DebugElement() {
		super("debug-button", "Run Executable in Debugger","org.eclipse.fx.code.compensator.project.jdt.command.debug");
	}

}
