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
 * List example snippet: print selected items in a list
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

public class Snippet59 implements SWTAppStart {

	@Override
	public BlockCondition createApp(Display display) {
		Shell shell = new Shell(display);
		final List list = new List(shell, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL);
		for (int i = 0; i < 128; i++)
			list.add("Item " + i);
		Rectangle clientArea = shell.getClientArea();
		list.setBounds(clientArea.x, clientArea.y, 100, 100);
		list.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				String string = "";
				int[] selection = list.getSelectionIndices();
				for (int i = 0; i < selection.length; i++)
					string += selection[i] + " ";
				System.out.println("Selection={" + string + "}");
			}
		});
		list.addListener(SWT.DefaultSelection, new Listener() {
			public void handleEvent(Event e) {
				String string = "";
				int[] selection = list.getSelectionIndices();
				for (int i = 0; i < selection.length; i++)
					string += selection[i] + " ";
				System.out.println("DefaultSelection={" + string + "}");
			}
		});
		shell.pack();
		SWTUtil.getInstance().openBlocking(shell);
		return null;
	}
	
	public static void main(String[] args) {
		SWTUtil.getInstance().bootstrap(new Snippet59());
	}
}
