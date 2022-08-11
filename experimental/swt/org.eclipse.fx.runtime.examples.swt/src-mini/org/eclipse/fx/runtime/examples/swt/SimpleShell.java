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
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class SimpleShell extends SWTApplication {

	public void run() {
		Display d = new Display();
		Shell s = new Shell(d);
		s.setBounds(50, 50, 300, 300);
		s.setText("Hello World");
		
		Button b1 = new Button(s, SWT.PUSH);
		b1.setText("Hello SWT");
		b1.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.err.println("SWT selected");
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				
			}
		});
		b1.setBounds(20, 20, 100, 80);
		
		Button b2 = new Button(s, SWT.PUSH);
		b2.setText("Hello JavaFX");
		b2.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.err.println("JavaFX selected");
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				
			}
		});
		b2.setBounds(130, 20, 100, 80);
		
		s.open();
		
		System.err.println(b2.getLocation());

		spinEventLoop();
	}
}
