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

import org.eclipse.fx.runtime.swtutil.SWTUtil;
import org.eclipse.fx.runtime.swtutil.SWTUtil.BlockCondition;
import org.eclipse.fx.runtime.swtutil.SWTUtil.SWTAppStart;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class ControlExampleLauncher implements SWTAppStart {
	@Override
	public BlockCondition createApp(Display display) {
		Shell shell = new Shell(display, SWT.SHELL_TRIM);
		shell.setLayout(new FillLayout());
		ControlExample instance = new ControlExample(shell);
		shell.setText(ControlExample.getResourceString("window.title"));
		shell.setBounds(30, 30, 1024, 800);
//		setShellSize(instance, shell);
		SWTUtil.getInstance().openBlocking(shell);
		
		return null;
	}
	
	public static void main(String[] args) {
		SWTUtil.getInstance().bootstrap(new ControlExampleLauncher());
	}
}
