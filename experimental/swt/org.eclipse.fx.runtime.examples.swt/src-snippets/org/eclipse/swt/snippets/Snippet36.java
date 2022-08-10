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
 * ToolBar example snippet: create a flat tool bar (images)
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

public class Snippet36 implements SWTAppStart {

	@Override
	public BlockCondition createApp(Display display) {
		Image image = new Image(display, 16, 16);
		Color color = display.getSystemColor(SWT.COLOR_RED);
		GC gc = new GC(image);
		gc.setBackground(color);
		gc.fillRectangle(image.getBounds());
		gc.dispose();
		Shell shell = new Shell(display);
		ToolBar toolBar = new ToolBar(shell, SWT.FLAT | SWT.BORDER);
		Rectangle clientArea = shell.getClientArea();
		toolBar.setLocation(clientArea.x, clientArea.y);
		for (int i = 0; i < 12; i++) {
			int style = i % 3 == 2 ? SWT.DROP_DOWN : SWT.PUSH;
			ToolItem item = new ToolItem(toolBar, style);
			item.setImage(image);
		}
		toolBar.pack();
		SWTUtil.getInstance().openBlocking(shell);
		image.dispose();
		return null;
	}

	public static void main(String[] args) {
		SWTUtil.getInstance().bootstrap(new Snippet36());
	}
}
