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
 * Tool Tips example snippet: create tool tips for a tab item, tool item, and shell
 *
 * For a list of all SWT example snippets see
 * http://www.eclipse.org/swt/snippets/
 */
import org.eclipse.fx.runtime.swtutil.SWTUtil;
import org.eclipse.fx.runtime.swtutil.SWTUtil.BlockCondition;
import org.eclipse.fx.runtime.swtutil.SWTUtil.SWTAppStart;
import org.eclipse.swt.*;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.*;

public class Snippet41 implements SWTAppStart {

	@Override
	public BlockCondition createApp(Display display) {
		String string = "This is a string\nwith a new line.";
		Shell shell = new Shell(display);
		TabFolder folder = new TabFolder(shell, SWT.BORDER);
		Rectangle clientArea = shell.getClientArea();
		folder.setBounds(clientArea.x, clientArea.y, 200, 200);
		TabItem item0 = new TabItem(folder, 0);
		item0.setText("tab item");
		item0.setToolTipText("TabItem toolTip: " + string);
		ToolBar bar = new ToolBar(shell, SWT.BORDER);
		bar.setBounds(clientArea.x, clientArea.y + 200, 200, 40);
		ToolItem item1 = new ToolItem(bar, SWT.PUSH);
		item1.setText("tool item");
		item1.setToolTipText("ToolItem toolTip: " + string);
		shell.setToolTipText("Shell toolTip: " + string);
		SWTUtil.getInstance().openBlocking(shell);
		return null;
	}
	
	public static void main(String[] args) {
		SWTUtil.getInstance().bootstrap(new Snippet41());
	}
}
