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
 * Shell example snippet: prevent escape from closing a dialog
 *
 * For a list of all SWT example snippets see
 * http://www.eclipse.org/swt/snippets/
 */
import org.eclipse.fx.runtime.swtutil.SWTUtil;
import org.eclipse.fx.runtime.swtutil.SWTUtil.BlockCondition;
import org.eclipse.fx.runtime.swtutil.SWTUtil.SWTAppStart;
import org.eclipse.swt.*;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.*;

public class Snippet4 implements SWTAppStart {
	
	public static void main(String[] args) {
		SWTUtil.getInstance().bootstrap(new Snippet4());
	}
	
	public BlockCondition createApp(Display display) {
		final Shell shell = new Shell(display);
		Button b = new Button(shell, SWT.PUSH);
		b.setText("Open Dialog ...");
		b.pack();
		Rectangle clientArea = shell.getClientArea();
		b.setLocation(clientArea.x + 10, clientArea.y + 10);
		b.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent se) {
				Shell dialog = new Shell(shell, SWT.DIALOG_TRIM);
				dialog.addListener(SWT.Traverse, new Listener() {
					public void handleEvent(Event e) {
						if (e.detail == SWT.TRAVERSE_ESCAPE) {
							e.doit = false;
						}
					}
				});
				dialog.open();
			}
		});
		SWTUtil.getInstance().openBlocking(shell);
		return null;
	}

}
