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
 * Shell example snippet: create a dialog shell (prompt for a value)
 *
 * For a list of all SWT example snippets see
 * http://www.eclipse.org/swt/snippets/
 */
import org.eclipse.fx.runtime.swtutil.SWTUtil;
import org.eclipse.fx.runtime.swtutil.SWTUtil.BlockCondition;
import org.eclipse.fx.runtime.swtutil.SWTUtil.SWTAppStart;
import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.layout.*;

public class Snippet63 implements SWTAppStart {

	@Override
	public BlockCondition createApp(Display display) {
		Shell shell = new Shell(display);
		shell.pack();
		shell.open();
		final boolean[] result = new boolean[1];
		final Shell dialog = new Shell(shell, SWT.DIALOG_TRIM
				| SWT.APPLICATION_MODAL);
		dialog.setLayout(new RowLayout());
		final Button ok = new Button(dialog, SWT.PUSH);
		ok.setText("OK");
		Button cancel = new Button(dialog, SWT.PUSH);
		cancel.setText("Cancel");
		Listener listener = new Listener() {
			public void handleEvent(Event event) {
				result[0] = event.widget == ok;
				dialog.close();
			}
		};
		ok.addListener(SWT.Selection, listener);
		cancel.addListener(SWT.Selection, listener);
		dialog.pack();
		SWTUtil.getInstance().openBlocking(dialog);
		System.out.println("Result: " + result[0]);
		return SWTUtil.getInstance().createShellBlockCondition(shell);
	}
	
	public static void main(String[] args) {
		SWTUtil.getInstance().bootstrap(new Snippet63());
	}
}
