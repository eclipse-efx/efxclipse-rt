/*******************************************************************************
 * Copyright (c) 2000, 2004 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.swt.snippets;

/*
 * Control example snippet: detect mouse enter, exit and hover events
 *
 * For a list of all SWT example snippets see
 * http://www.eclipse.org/swt/snippets/
 */
import org.eclipse.fx.runtime.swtutil.SWTUtil;
import org.eclipse.fx.runtime.swtutil.SWTUtil.BlockCondition;
import org.eclipse.fx.runtime.swtutil.SWTUtil.SWTAppStart;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

public class Snippet14 implements SWTAppStart {

	public static void main(String[] args) {
		SWTUtil.getInstance().bootstrap(new Snippet14());
	}

	public BlockCondition createApp(Display display) {
		Shell shell = new Shell(display);
		shell.setSize(100, 100);
		shell.addListener(SWT.MouseEnter, new Listener() {
			public void handleEvent(Event e) {
				System.out.println("Shell ENTER");
			}
		});
		shell.addListener(SWT.MouseExit, new Listener() {
			public void handleEvent(Event e) {
				System.out.println("Shell EXIT");
			}
		});
		shell.addListener(SWT.MouseHover, new Listener() {
			public void handleEvent(Event e) {
				System.out.println("Shell HOVER");
			}
		});
		
		SWTUtil.getInstance().openBlocking(shell);
		return null;
	}
}
