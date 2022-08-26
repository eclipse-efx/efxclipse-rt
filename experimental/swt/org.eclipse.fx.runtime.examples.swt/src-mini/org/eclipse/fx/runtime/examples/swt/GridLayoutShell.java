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
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class GridLayoutShell extends SWTApplication {

	@Override
	public void run() {
		Display d = new Display();
		final Shell s = new Shell(d);
		s.setBounds(50, 50, 300, 300);
		s.setLayout(new GridLayout(2,false));
		s.setText("Hello World");
		
		Label l = new Label(s, SWT.NONE);
		l.setText("Name");
		
		final Text t = new Text(s, SWT.BORDER);
		t.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		Button b = new Button(s, SWT.BORDER);
		b.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				Shell dialog = new Shell(s);
				dialog.setLayout(new FillLayout());
				
				Label l = new Label(dialog, SWT.NONE);
				l.setText("Hello '" + t.getText() + "'");
				
				dialog.open();
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				
			}
		});
		b.setText("Greet");
		b.setLayoutData(new GridData(GridData.END, GridData.CENTER, false, false,2,1));
		
		s.open();
		spinEventLoop();
	}
}
