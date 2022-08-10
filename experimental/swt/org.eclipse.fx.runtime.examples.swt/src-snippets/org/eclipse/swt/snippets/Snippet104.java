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
 * Shell example snippet: create a splash screen
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
import org.eclipse.swt.layout.*;

public class Snippet104 implements SWTAppStart {

	@Override
	public BlockCondition createApp(final Display display) {
		final int[] count = new int[] { 4 };
		final Image image = new Image(display, 300, 300);
		GC gc = new GC(image);
		gc.setBackground(display.getSystemColor(SWT.COLOR_CYAN));
		gc.fillRectangle(image.getBounds());
		gc.drawText("Splash Screen", 10, 10);
		gc.dispose();
		final Shell splash = new Shell(SWT.ON_TOP);
		Label label = new Label(splash, SWT.NONE);
		label.setImage(image);
		final ProgressBar bar = new ProgressBar(splash, SWT.NONE);
		bar.setMaximum(count[0]);
		FormLayout layout = new FormLayout();
		splash.setLayout(layout);
		FormData labelData = new FormData();
		labelData.right = new FormAttachment(100, 0);
		labelData.bottom = new FormAttachment(100, 0);
		label.setLayoutData(labelData);
		FormData progressData = new FormData();
		progressData.left = new FormAttachment(0, 5);
		progressData.right = new FormAttachment(100, -5);
		progressData.bottom = new FormAttachment(100, -5);
		bar.setLayoutData(progressData);
		splash.pack();
		splash.setSize(300, 320); 
		Rectangle splashRect = splash.getBounds();
		Rectangle displayRect = display.getBounds();
		int x = (displayRect.width - splashRect.width) / 2;
		int y = (displayRect.height - splashRect.height) / 2;
		splash.setLocation(x, y);
		splash.open();
		new Thread() {
			public void run() {
				final Shell[] shells = new Shell[count[0]];
				for (int i = 0; i < count[0]; i++) {
					final int j = i;
					display.syncExec(new Runnable() {
						
						@Override
						public void run() {
							shells[j] = new Shell(display);
							shells[j].setSize(300, 300);
							shells[j].addListener(SWT.Close, new Listener() {
								public void handleEvent(Event e) {
									--count[0];
								}
							});
							bar.setSelection(j + 1);
						}
					});
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}				
				}
				display.syncExec(new Runnable() {
					
					@Override
					public void run() {
						splash.close();
						image.dispose();
						for (int i = 0; i < count[0]; i++) {
							shells[i].open();
						}
					}
				});
				
			}
		}.start();
//		display.asyncExec(new Runnable() {
//			public void run() {
//				Shell[] shells = new Shell[count[0]];
//				for (int i = 0; i < count[0]; i++) {
//					shells[i] = new Shell(display);
//					shells[i].setSize(300, 300);
//					shells[i].addListener(SWT.Close, new Listener() {
//						public void handleEvent(Event e) {
//							--count[0];
//						}
//					});
//					bar.setSelection(i + 1);
//					try {
//						Thread.sleep(1000);
//					} catch (Throwable e) {
//					}
//				}
//				splash.close();
//				image.dispose();
//				for (int i = 0; i < count[0]; i++) {
//					shells[i].open();
//				}
//			}
//		});
		return SWTUtil.getInstance().createShellBlockCondition(splash);
	}
	
	public static void main(String[] args) {
		SWTUtil.getInstance().bootstrap(new Snippet104());
	}

}
