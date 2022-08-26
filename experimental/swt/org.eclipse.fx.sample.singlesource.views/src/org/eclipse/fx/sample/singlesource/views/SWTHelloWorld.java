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
package org.eclipse.fx.sample.singlesource.views;

import javax.annotation.PostConstruct;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;

public class SWTHelloWorld {
	
	private Label l;

	@PostConstruct
	public void initUI(Composite parent) {
		parent.setLayout(new GridLayout());

		l = new Label(parent, SWT.NONE);
		l.setAlignment(SWT.CENTER);
		l.setFont(new Font(Display.getCurrent(), new FontData(l.getFont().getFontData()[0].getName(), 30, SWT.NORMAL)));
		l.setLayoutData(new GridData(GridData.FILL,GridData.CENTER,true,false));
		
		Button b = new Button(parent, SWT.PUSH);
		b.setText("Hello World");
		b.addListener(SWT.Selection, this::showHelloWorld);
		b.setLayoutData(new GridData(GridData.CENTER,GridData.CENTER,true,true));
	}
	
	void showHelloWorld(Event event) {
		l.setText("SWT on JavaFX is the coolest technology on earth");
	}
}
