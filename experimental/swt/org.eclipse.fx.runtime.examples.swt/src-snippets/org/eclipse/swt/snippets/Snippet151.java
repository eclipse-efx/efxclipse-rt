/*******************************************************************************
 * Copyright (c) 2000, 2005 IBM Corporation and others.
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
 * Create a virtual table and add 1000 entries to it every 500 ms.
 *
 * For a list of all SWT example snippets see
 * http://www.eclipse.org/swt/snippets/
 * 
 * @since 3.0
 */
import java.util.*;

import org.eclipse.fx.runtime.swtutil.SWTUtil;
import org.eclipse.fx.runtime.swtutil.SWTUtil.BlockCondition;
import org.eclipse.fx.runtime.swtutil.SWTUtil.SWTAppStart;
import org.eclipse.swt.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class Snippet151 implements SWTAppStart {

	static int[] data = new int[0];

	@Override
	public BlockCondition createApp(final Display display) {
		Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		final Table table = new Table(shell, SWT.BORDER | SWT.VIRTUAL);
		table.addListener(SWT.SetData, new Listener() {
			public void handleEvent(Event e) {
				TableItem item = (TableItem) e.item;
				int index = table.indexOf(item);
				item.setText("Item " + data[index]);
			}
		});
		Thread thread = new Thread() {
			public void run() {
				int count = 0;
				Random random = new Random();
				while (count++ < 500) {
					if (table.isDisposed())
						return;
					// add 10 random numbers to array and sort
					int grow = 10;
					int[] newData = new int[data.length + grow];
					System.arraycopy(data, 0, newData, 0, data.length);
					int index = data.length;
					data = newData;
					for (int j = 0; j < grow; j++) {
						data[index++] = random.nextInt();
					}
					Arrays.sort(data);
					display.syncExec(new Runnable() {
						public void run() {
							if (table.isDisposed())
								return;
							table.setItemCount(data.length);
							table.clearAll();
						}
					});
					try {
						Thread.sleep(500);
					} catch (Throwable t) {
					}
				}
			}
		};
		thread.start();
		SWTUtil.getInstance().openBlocking(shell);
		return null;
	}
	
	public static void main(String[] args) {
		SWTUtil.getInstance().bootstrap(new Snippet151());
	}
}
