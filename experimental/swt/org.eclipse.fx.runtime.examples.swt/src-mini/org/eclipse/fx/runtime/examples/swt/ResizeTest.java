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
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Text;

public class ResizeTest {
	public ResizeTest(Shell s) {
		TabFolder tf = new TabFolder(s, SWT.NONE);
		
		{
			TabItem ti = new TabItem(tf, SWT.NONE);
			ti.setText("Item 1");
		}
		
		{
			TabItem ti = new TabItem(tf, SWT.NONE);
			ti.setText("Item 2");
			
			Composite comp = new Composite(tf, SWT.NONE);
			comp.setLayout(new GridLayout(2,false));
			
			{
				Group g = new Group(comp, SWT.NONE);
				g.setLayout(new GridLayout());
				g.setLayoutData(new GridData(GridData.FILL_BOTH));
				
				Text t = new Text(g, SWT.BORDER);
				t.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
				t.setText("Left");
			}
			
			{
				Group g = new Group(comp,SWT.NONE);
				g.setLayout(new GridLayout());
				Text t = new Text(g, SWT.BORDER);
				t.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
				t.setText("Right");
			}
			
			ti.setControl(comp);
		}
		
//		tabFolderPage.setLayout (new GridLayout (2, false));
	}
	
	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display, SWT.SHELL_TRIM);
		shell.setLayout(new FillLayout());
		ResizeTest instance = new ResizeTest(shell);
		shell.setText("Hello World");
		shell.setBounds(30, 30, 1024, 800);
//		setShellSize(instance, shell);
		shell.open();
	}
}
