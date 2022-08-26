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
 * FormLayout example snippet: create a simple OK/CANCEL dialog using form layout
 *
 * For a list of all SWT example snippets see
 * http://www.eclipse.org/swt/snippets/
 */
import org.eclipse.fx.runtime.swtutil.SWTUtil;
import org.eclipse.fx.runtime.swtutil.SWTUtil.BlockCondition;
import org.eclipse.fx.runtime.swtutil.SWTUtil.SWTAppStart;
import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.layout.*;

public class Snippet71 implements SWTAppStart {

	@Override
	public BlockCondition createApp(Display display) {
		Shell shell = new Shell(display);
		shell.pack();
		shell.open();
		Shell dialog = new Shell(shell, SWT.DIALOG_TRIM);
		Label label = new Label(dialog, SWT.NONE);
		label.setText("Exit the application?");
		Button okButton = new Button(dialog, SWT.PUSH);
		okButton.setText("&OK");
		Button cancelButton = new Button(dialog, SWT.PUSH);
		cancelButton.setText("&Cancel");

		FormLayout form = new FormLayout();
		form.marginWidth = form.marginHeight = 8;
		dialog.setLayout(form);
		FormData okData = new FormData();
		okData.top = new FormAttachment(label, 8);
		okButton.setLayoutData(okData);
		FormData cancelData = new FormData();
		cancelData.left = new FormAttachment(okButton, 8);
		cancelData.top = new FormAttachment(okButton, 0, SWT.TOP);
		cancelButton.setLayoutData(cancelData);

		dialog.setDefaultButton(okButton);
		dialog.pack();
		dialog.open();

		return SWTUtil.getInstance().createShellBlockCondition(shell);
	}
	
	public static void main(String[] args) {
		SWTUtil.getInstance().bootstrap(new Snippet71());
	}
}
