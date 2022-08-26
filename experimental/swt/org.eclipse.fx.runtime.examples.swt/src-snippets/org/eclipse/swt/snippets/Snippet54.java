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
 * Sash example snippet: create a sash (allow it to be moved)
 *
 * For a list of all SWT example snippets see
 * http://www.eclipse.org/swt/snippets/
 */
import org.eclipse.fx.runtime.swtutil.SWTUtil;
import org.eclipse.fx.runtime.swtutil.SWTUtil.BlockCondition;
import org.eclipse.fx.runtime.swtutil.SWTUtil.SWTAppStart;
import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;

public class Snippet54 implements SWTAppStart {

	@Override
	public BlockCondition createApp(Display display) {
		Shell shell = new Shell(display);
		shell.setSize(400, 300);
		shell.open();
		final Sash sash = new Sash(shell, SWT.BORDER | SWT.VERTICAL);
//		Rectangle clientArea = shell.getClientArea();
		sash.setBounds(180, 0, 32, 300);
		sash.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				sash.setBounds(e.x, e.y, e.width, e.height);
			}
		});
		
		sash.setFocus();
		return SWTUtil.getInstance().createShellBlockCondition(shell);
	}
	
	public static void main(String[] args) {
		SWTUtil.getInstance().bootstrap(new Snippet54());
	}
}
