/*******************************************************************************
 * Copyright (c) 2000, 2004 IBM Corporation and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.swt.snippets;

/*
 * GC example snippet: draw a thick line
 *
 * For a list of all SWT example snippets see
 * http://www.eclipse.org/swt/snippets/
 */
import org.eclipse.fx.runtime.swtutil.SWTUtil;
import org.eclipse.fx.runtime.swtutil.SWTUtil.BlockCondition;
import org.eclipse.fx.runtime.swtutil.SWTUtil.SWTAppStart;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class Snippet13 implements SWTAppStart {

	public static void main(String[] args) {
		SWTUtil.getInstance().bootstrap(new Snippet13());
	}

	@Override
	public BlockCondition createApp(Display display) {
		Shell shell = new Shell(display);
		shell.open();
		GC gc = new GC(shell);
		gc.setLineWidth(4);
		gc.drawRectangle(20, 20, 100, 100);
		gc.dispose();
		
		return SWTUtil.getInstance().createShellBlockCondition(shell);
	}
}
