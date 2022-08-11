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
 
package org.eclipse.fx.testcases.e4.handlers;

import org.eclipse.e4.core.di.annotations.Execute;

@SuppressWarnings("restriction")
public class FunctionHandler {
	@Execute
	public void execute() {
		System.err.println("============================> Executed function key");
	}
		
}