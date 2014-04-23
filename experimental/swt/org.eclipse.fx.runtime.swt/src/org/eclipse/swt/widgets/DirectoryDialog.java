/*******************************************************************************
 * Copyright (c) 2014 IBM Corporation, BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	   IBM Corporation - initial API
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.swt.widgets;

import java.io.File;

import javafx.stage.DirectoryChooser;

public class DirectoryDialog extends Dialog {
	private String filterPath;
	private String message;
	
	public DirectoryDialog(Shell parent) {
		super(parent);
	}

	public DirectoryDialog (Shell parent, int style) {
		super(parent,style);
	}
	
	public String getFilterPath () {
		return filterPath;
	}
	
	public String getMessage () {
		return message;
	}
	
	public String open () {
		DirectoryChooser chooser = new DirectoryChooser();
		chooser.setInitialDirectory(new File(filterPath));
		File f = chooser.showDialog(getParent().internal_getWindow());
		return f == null ? null : f.getAbsolutePath();
	}
	
	public void setMessage (String string) {
		this.message = string;
	}
	
	public void setFilterPath (String string) {
		filterPath = string;
	}
}
