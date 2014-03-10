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
 * GridLayout example snippet: insert widgets into a grid layout
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
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

public class Snippet6 implements SWTAppStart {

	public static void main(String[] args) {
		SWTUtil.getInstance().bootstrap(new Snippet6());
	}

	public BlockCondition createApp(Display display) {
		final Shell shell = new Shell(display);
		shell.setLayout(new GridLayout());
		final Composite c = new Composite(shell, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		c.setLayout(layout);
		for (int i = 0; i < 10; i++) {
			Button b = new Button(c, SWT.PUSH);
			b.setText("Button " + i);
		}

		Button b = new Button(shell, SWT.PUSH);
		b.setText("add a new button at row 2 column 1");
		final int[] index = new int[1];
		b.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				Button s = new Button(c, SWT.PUSH);
				s.setText("Special " + index[0]);
				index[0]++;
				Control[] children = c.getChildren();
				s.moveAbove(children[3]);
				shell.layout(new Control[] { s });
			}
		});

		SWTUtil.getInstance().openBlocking(shell);
		return null;
	}
}
