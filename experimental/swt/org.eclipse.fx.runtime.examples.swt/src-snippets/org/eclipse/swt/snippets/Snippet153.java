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
 * ToolBar example snippet: update a status line when the mouse enters a tool item
 *
 * For a list of all SWT example snippets see
 * http://www.eclipse.org/swt/snippets/
 */
import org.eclipse.fx.runtime.swtutil.SWTUtil;
import org.eclipse.fx.runtime.swtutil.SWTUtil.BlockCondition;
import org.eclipse.fx.runtime.swtutil.SWTUtil.SWTAppStart;
import org.eclipse.swt.*;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.widgets.*;

public class Snippet153 implements SWTAppStart {

	static String statusText = "";

	@Override
	public BlockCondition createApp(Display display) {
		Shell shell = new Shell(display);
		shell.setBounds(10, 10, 200, 200);
		final ToolBar bar = new ToolBar(shell, SWT.BORDER);
		bar.setBounds(10, 10, 150, 50);
		final Label statusLine = new Label(shell, SWT.BORDER);
		statusLine.setBounds(10, 90, 150, 30);
		new ToolItem(bar, SWT.NONE).setText("item 1");
		new ToolItem(bar, SWT.NONE).setText("item 2");
		new ToolItem(bar, SWT.NONE).setText("item 3");
		bar.addMouseMoveListener(new MouseMoveListener() {
			public void mouseMove(MouseEvent e) {
				ToolItem item = bar.getItem(new Point(e.x, e.y));
				String name = "";
				if (item != null) {
					name = item.getText();
				}
				if (!statusText.equals(name)) {
					statusLine.setText(name);
					statusText = name;
				}
			}
		});
		SWTUtil.getInstance().openBlocking(shell);
		return null;
	}

	public static void main(String[] args) {
		SWTUtil.getInstance().bootstrap(new Snippet153());
	}
}
