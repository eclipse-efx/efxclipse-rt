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
 * Tree example snippet: detect mouse down in a tree item
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

public class Snippet90 implements SWTAppStart {

	@Override
	public BlockCondition createApp(Display display) {
		Shell shell = new Shell(display);
		final Tree tree = new Tree(shell, SWT.BORDER | SWT.MULTI);
		for (int i = 0; i < 12; i++) {
			TreeItem treeItem = new TreeItem(tree, SWT.NONE);
			treeItem.setText("Item " + i);
		}
		tree.addListener(SWT.MouseDown, new Listener() {
			public void handleEvent(Event event) {
				Point point = new Point(event.x, event.y);
				System.err.println(point);
				 TreeItem item = tree.getItem (point);
				 if (item != null) {
					 System.out.println ("Mouse down: " + item);
				 }
			}
		});
		Rectangle clientArea = shell.getClientArea();
		tree.setBounds(clientArea.x, clientArea.y, 200, 200);
		shell.setSize(300, 300);
		SWTUtil.getInstance().openBlocking(shell);
		return null;
	}

	public static void main(String[] args) {
		SWTUtil.getInstance().bootstrap(new Snippet90());
	}
}
