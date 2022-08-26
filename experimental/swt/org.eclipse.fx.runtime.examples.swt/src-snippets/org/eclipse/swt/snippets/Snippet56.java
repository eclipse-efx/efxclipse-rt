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
 * ProgressBar example snippet: update a progress bar (from another thread)
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

public class Snippet56 implements SWTAppStart {

	@Override
	public BlockCondition createApp(final Display display) {
		Shell shell = new Shell(display);
		final ProgressBar bar = new ProgressBar(shell, SWT.SMOOTH);
		Rectangle clientArea = shell.getClientArea();
		bar.setBounds(clientArea.x, clientArea.y, 200, 32);
		shell.open();
		final int maximum = bar.getMaximum();
		new Thread() {
			public void run() {
				for (final int[] i = new int[1]; i[0] <= maximum; i[0]++) {
					try {
						Thread.sleep(100);
					} catch (Throwable th) {
					}

					if (display.isDisposed()) {
						return;
					}
					
					display.asyncExec(new Runnable() {
						public void run() {
							if (bar.isDisposed()) {
								return;
							}
							bar.setSelection(i[0]);
						}
					});
				}
			}
		}.start();
		return SWTUtil.getInstance().createShellBlockCondition(shell);
	}

	public static void main(String[] args) {
		SWTUtil.getInstance().bootstrap(new Snippet56());
	}
}