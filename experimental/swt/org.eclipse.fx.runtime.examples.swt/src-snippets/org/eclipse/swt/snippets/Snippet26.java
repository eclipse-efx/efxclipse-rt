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
 * Combo example snippet: create a combo box (non-editable)
 *
 * For a list of all SWT example snippets see
 * http://www.eclipse.org/swt/snippets/
 */
import org.eclipse.fx.runtime.swtutil.SWTUtil;
import org.eclipse.fx.runtime.swtutil.SWTUtil.BlockCondition;
import org.eclipse.fx.runtime.swtutil.SWTUtil.SWTAppStart;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class Snippet26 implements SWTAppStart {

	@Override
	public BlockCondition createApp(Display display) {
		final Shell shell = new Shell(display);
		Combo combo = new Combo(shell, SWT.READ_ONLY);
		combo.setItems(new String[] { "Alpha", "Bravo", "Charlie" });
		combo.setSize(combo.computeSize(SWT.DEFAULT, SWT.DEFAULT));
//		Rectangle clientArea = shell.getClientArea();
//		combo.setBounds(clientArea.x, clientArea.y, 200, 200);

		shell.pack();
		shell.setSize(400, 400);
		shell.open();
		
		return SWTUtil.getInstance().createShellBlockCondition(shell);
	}

	public static void main(String[] args) {
		SWTUtil.getInstance().bootstrap(new Snippet26());
	}
}
