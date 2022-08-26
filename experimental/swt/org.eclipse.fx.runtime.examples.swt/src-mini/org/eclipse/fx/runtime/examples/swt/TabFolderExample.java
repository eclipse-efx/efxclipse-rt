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
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Text;

public class TabFolderExample extends SWTApplication {

	@Override
	public void run() {
		Display d = new Display();
		Shell s = new Shell(d);
		s.setBounds(50, 50, 300, 300);
		s.setLayout(new FillLayout());
		s.setText("Tab Folder");
		
		TabFolder folder = new TabFolder(s, SWT.NONE);
		
		{
			TabItem item = new TabItem(folder, SWT.NONE);
			item.setText("Item 1");
			
			Composite content = new Composite(folder, SWT.NONE);
			content.setLayout(new GridLayout(2, false));
			
			Label l = new Label(content, SWT.NONE);
			l.setText("Tab 1");
			
			Text t = new Text(content, SWT.BORDER);
			t.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			
			item.setControl(content);
		}
		
		{
			TabItem item = new TabItem(folder, SWT.NONE);
			item.setText("Item 2");	
			
			Group content = new Group(folder, SWT.NONE);
			content.setText("Tab2");
			content.setLayout(new GridLayout(2, false));
			
			Label l = new Label(content, SWT.NONE);
			l.setText("Tab 2");
			
			Text t = new Text(content, SWT.BORDER);
			t.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			
			item.setControl(content);
		}
		
		s.open();
		
		spinEventLoop();
	}
}
