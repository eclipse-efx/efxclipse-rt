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
 * GC example snippet: capture a widget image with a GC
 *
 * For a list of all SWT example snippets see
 * http://www.eclipse.org/swt/snippets/
 */
import org.eclipse.fx.runtime.swtutil.SWTUtil;
import org.eclipse.fx.runtime.swtutil.SWTUtil.BlockCondition;
import org.eclipse.fx.runtime.swtutil.SWTUtil.SWTAppStart;
import org.eclipse.swt.*;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.widgets.*;

public class Snippet95 implements SWTAppStart {

	@Override
	public BlockCondition createApp(final Display display) {
		final Shell shell = new Shell(display);
		shell.setText("Widget");

		final Table table = new Table(shell, SWT.MULTI);
		table.setLinesVisible(true);
		table.setBounds(10, 10, 100, 100);
		for (int i = 0; i < 9; i++) {
			new TableItem(table, SWT.NONE).setText("item" + i);
		}

		Button button = new Button(shell, SWT.PUSH);
		button.setText("Capture");
		button.pack();
		button.setLocation(10, 140);
		button.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				Point tableSize = table.getSize();
				GC gc = new GC(table);
				final Image image = new Image(display, tableSize.x, tableSize.y);
				gc.copyArea(image, 0, 0);
				gc.dispose();

				Shell popup = new Shell(shell);
				popup.setText("Image");
				popup.addListener(SWT.Close, new Listener() {
					public void handleEvent(Event e) {
						image.dispose();
					}
				});

				Canvas canvas = new Canvas(popup, SWT.NONE);
				canvas.setBounds(10, 10, tableSize.x + 10, tableSize.y + 10);
				canvas.addPaintListener(new PaintListener() {
					public void paintControl(PaintEvent e) {
						e.gc.drawImage(image, 0, 0);
					}
				});
				popup.pack();
				popup.open();
			}
		});
		shell.pack();
		SWTUtil.getInstance().openBlocking(shell);
		return null;
	}
	
	public static void main(String[] args) {
		SWTUtil.getInstance().bootstrap(new Snippet95());
	}
}
