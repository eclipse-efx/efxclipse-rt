/*******************************************************************************
 * Copyright (c) 2022 BestSolution.at and others.
 *  
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *  
 * SPDX-License-Identifier: EPL-2.0
 *  
 * Contributors:
 *     BestSolution.at - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.runtime.examples.swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

public class TableExample extends SWTApplication {

	@Override
	public void run() {
		Display d = new Display();
		Shell s = new Shell(d);
		s.setBounds(50, 50, 300, 300);
		s.setLayout(new GridLayout());
		s.setText("Table Example");
		
		Table list = new Table(s, SWT.BORDER);
		
		TableColumn column = new TableColumn(list,SWT.NONE);
		column.setText("Col 1");
		
		column = new TableColumn(list,SWT.NONE);
		column.setText("Col 2");
		
		for( int i = 0; i < 30; i++ ) {
			TableItem item = new TableItem(list, SWT.NONE);
			item.setText(0, "Cell " + i + "/0");
			item.setText(1, "Cell " + i + "/1");
		}
		
		list.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		s.open();
		
		spinEventLoop();
	}
}
