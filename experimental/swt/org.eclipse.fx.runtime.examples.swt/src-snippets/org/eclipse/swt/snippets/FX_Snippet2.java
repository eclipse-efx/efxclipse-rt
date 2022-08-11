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
package org.eclipse.swt.snippets;

import org.eclipse.fx.runtime.swtutil.SWTUtil;
import org.eclipse.fx.runtime.swtutil.SWTUtil.BlockCondition;
import org.eclipse.fx.runtime.swtutil.SWTUtil.SWTAppStart;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;

public class FX_Snippet2 implements SWTAppStart {

	@Override
	public BlockCondition createApp(Display display) {
		Shell s = new Shell(display);
		s.setLayout(new FillLayout());
		TabFolder tb = new TabFolder(s, SWT.NONE);
		
		TabItem i = new TabItem(tb, SWT.NONE);
		i.setText("Bla");
		
		i = new TabItem(tb, SWT.NONE);
		i.setText("Blo");
		s.setSize(400, 400);
		
		SWTUtil.getInstance().openBlocking(s);
		
		return null;
	}

	public static void main(String[] args) {
		SWTUtil.getInstance().bootstrap(new FX_Snippet2());
	}
}
