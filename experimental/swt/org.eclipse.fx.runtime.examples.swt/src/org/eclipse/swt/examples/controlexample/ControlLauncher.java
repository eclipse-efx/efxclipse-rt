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
package org.eclipse.swt.examples.controlexample;

import org.eclipse.fx.runtime.examples.swt.SWTApplication;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class ControlLauncher extends SWTApplication {

	@Override
	public void run() {
		Display display = new Display();
		Shell shell = new Shell(display, SWT.SHELL_TRIM);
		shell.setLayout(new FillLayout());
		ControlExample instance = new ControlExample(shell);
//		shell.setText(getResourceString("window.title"));
//		setShellSize(instance, shell);
		shell.open();
		
		spinEventLoop();
	}

}
