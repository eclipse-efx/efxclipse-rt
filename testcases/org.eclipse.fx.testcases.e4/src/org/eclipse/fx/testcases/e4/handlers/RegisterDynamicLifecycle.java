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
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.fx.ui.workbench.services.ELifecycleService;

public class RegisterDynamicLifecycle {
	
	@Execute
	public void execute(ELifecycleService service, MPart part){
		System.err.println(part.getLabel());
		service.registerLifecycleURI(part, "bundleclass://org.eclipse.fx.testcases.e4/"+
		"org.eclipse.fx.testcases.e4.lifecycle.SecondLifeCycle");
	}

}