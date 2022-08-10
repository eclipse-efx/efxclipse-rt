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
 * Display example snippet: stop a repeating timer when a button is pressed
 *
 * For a list of all SWT example snippets see
 * http://www.eclipse.org/swt/snippets/
 */
import org.eclipse.fx.runtime.swtutil.SWTUtil;
import org.eclipse.fx.runtime.swtutil.SWTUtil.BlockCondition;
import org.eclipse.fx.runtime.swtutil.SWTUtil.SWTAppStart;
import org.eclipse.swt.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.layout.*;

public class Snippet68 implements SWTAppStart {

	@Override
	public BlockCondition createApp(final Display display) {
		final Color red = display.getSystemColor(SWT.COLOR_RED);
		final Color blue = display.getSystemColor(SWT.COLOR_BLUE);
		Shell shell = new Shell(display);
		shell.setLayout(new RowLayout());
		Button button = new Button(shell, SWT.PUSH);
		button.setText("Stop Timer");
		final Label label = new Label(shell, SWT.BORDER);
		label.setBackground(red);
		final int time = 500;
		final Runnable timer = new Runnable() {
			public void run() {
				if (label.isDisposed())
					return;
				Color color = label.getBackground().equals(red) ? blue : red;
				label.setBackground(color);
				display.timerExec(time, this);
			}
		};
		display.timerExec(time, timer);
		button.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				display.timerExec(-1, timer);
			}
		});
		button.pack();
		label.setLayoutData(new RowData(button.getSize()));
		shell.pack();
		SWTUtil.getInstance().openBlocking(shell);
		return null;
	}
	
	public static void main(String[] args) {
		SWTUtil.getInstance().bootstrap(new Snippet68());
	}
}
