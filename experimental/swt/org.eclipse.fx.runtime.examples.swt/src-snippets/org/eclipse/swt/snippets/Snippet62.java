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
 * Control example snippet: print mouse state and button (down, move, up)
 *
 * For a list of all SWT example snippets see
 * http://www.eclipse.org/swt/snippets/
 * 
 * @since 3.1
 */
import org.eclipse.fx.runtime.swtutil.SWTUtil;
import org.eclipse.fx.runtime.swtutil.SWTUtil.BlockCondition;
import org.eclipse.fx.runtime.swtutil.SWTUtil.SWTAppStart;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

public class Snippet62 implements SWTAppStart {

	static String stateMask(int stateMask) {
		String string = "";
		if ((stateMask & SWT.CTRL) != 0)
			string += " CTRL";
		if ((stateMask & SWT.ALT) != 0)
			string += " ALT";
		if ((stateMask & SWT.SHIFT) != 0)
			string += " SHIFT";
		if ((stateMask & SWT.COMMAND) != 0)
			string += " COMMAND";
		return string;
	}

	@Override
	public BlockCondition createApp(Display display) {
		final Shell shell = new Shell(display);
		Listener listener = new Listener() {
			public void handleEvent(Event e) {
				String string = "Unknown";
				switch (e.type) {
				case SWT.MouseDown:
					string = "DOWN";
					break;
				case SWT.MouseMove:
					string = "MOVE";
					break;
				case SWT.MouseUp:
					string = "UP";
					break;
				}
				string += ": button: " + e.button + ", ";
				string += "stateMask=0x" + Integer.toHexString(e.stateMask)
						+ stateMask(e.stateMask) + ", x=" + e.x + ", y=" + e.y;
				if ((e.stateMask & SWT.BUTTON1) != 0)
					string += " BUTTON1";
				if ((e.stateMask & SWT.BUTTON2) != 0)
					string += " BUTTON2";
				if ((e.stateMask & SWT.BUTTON3) != 0)
					string += " BUTTON3";
				if ((e.stateMask & SWT.BUTTON4) != 0)
					string += " BUTTON4";
				if ((e.stateMask & SWT.BUTTON5) != 0)
					string += " BUTTON5";
				System.out.println(string);
			}
		};
		shell.addListener(SWT.MouseDown, listener);
		shell.addListener(SWT.MouseMove, listener);
		shell.addListener(SWT.MouseUp, listener);
		shell.pack();
		SWTUtil.getInstance().openBlocking(shell);
		return null;
	}
	
	public static void main(String[] args) {
		SWTUtil.getInstance().bootstrap(new Snippet62());
	}
}
