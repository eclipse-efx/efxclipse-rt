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
 * BusyIndicator example snippet: display busy cursor during long running task
 *
 * For a list of all SWT example snippets see
 * http://www.eclipse.org/swt/snippets/
 */
import org.eclipse.fx.runtime.swtutil.SWTUtil;
import org.eclipse.fx.runtime.swtutil.SWTUtil.BlockCondition;
import org.eclipse.fx.runtime.swtutil.SWTUtil.SWTAppStart;
import org.eclipse.swt.*;
import org.eclipse.swt.custom.*;
import org.eclipse.swt.events.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class Snippet130 implements SWTAppStart {

	@Override
	public BlockCondition createApp(final Display display) {
		final Shell shell = new Shell(display);
		shell.setLayout(new GridLayout());
		final Text text = new Text(shell, SWT.MULTI | SWT.BORDER | SWT.V_SCROLL);
		text.setLayoutData(new GridData(GridData.FILL_BOTH));
		final int[] nextId = new int[1];
		Button b = new Button(shell, SWT.PUSH);
		b.setText("invoke long running job");
		b.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				Runnable longJob = new Runnable() {
					BlockCondition c = SWTUtil.getInstance().createSimpleBlockCondition();
//					boolean done = false;
					int id;

					public void run() {
						Thread thread = new Thread(new Runnable() {
							public void run() {
								id = nextId[0]++;
								display.syncExec(new Runnable() {
									public void run() {
										if (text.isDisposed())
											return;
										text.append("\nStart long running task "
												+ id);
									}
								});
								for (int i = 0; i < 100000; i++) {
									if (display.isDisposed())
										return;
									System.out
											.println("do task that takes a long time in a separate thread "
													+ id);
								}
								if (display.isDisposed())
									return;
								display.syncExec(new Runnable() {
									public void run() {
										if (text.isDisposed())
											return;
										text.append("\nCompleted long running task "
												+ id);
									}
								});
								c.unblock();
								display.wake();
							}
						});
						thread.start();
						SWTUtil.getInstance().block(display, c);
//TODO NOT NEEDED but leads to exceptions!!!						
//						while (!done && !shell.isDisposed()) {
//							if (!display.readAndDispatch())
//								display.sleep();
//						}
					}
				};
				BusyIndicator.showWhile(display, longJob);
			}
		});
		shell.setSize(250, 150);
		SWTUtil.getInstance().openBlocking(shell);
		return null;
	}
	
	public static void main(String[] args) {
		SWTUtil.getInstance().bootstrap(new Snippet130());
	}
}
