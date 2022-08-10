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
 * Menu example snippet: fill a menu dynamically (when menu shown)
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

public class Snippet97 implements SWTAppStart {

	@Override
	public BlockCondition createApp(Display display) {
		Shell shell = new Shell(display);
		final Tree tree = new Tree(shell, SWT.BORDER | SWT.MULTI);
		final Menu menu = new Menu(shell, SWT.POP_UP);
//		MenuItem it = new MenuItem(menu, SWT.PUSH);
//		it.setText("Dummy");
		tree.setMenu(menu);
		for (int i = 0; i < 12; i++) {
			TreeItem item = new TreeItem(tree, SWT.NONE);
			item.setText("Item " + i);
		}
		menu.addListener(SWT.Show, new Listener() {
			public void handleEvent(Event event) {
				MenuItem[] menuItems = menu.getItems();
				for (int i = 0; i < menuItems.length; i++) {
					menuItems[i].dispose();
				}
				TreeItem[] treeItems = tree.getSelection();
				for (int i = 0; i < treeItems.length; i++) {
					MenuItem menuItem = new MenuItem(menu, SWT.PUSH);
					menuItem.setText(treeItems[i].getText());
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
		SWTUtil.getInstance().bootstrap(new Snippet97());
	}
}
