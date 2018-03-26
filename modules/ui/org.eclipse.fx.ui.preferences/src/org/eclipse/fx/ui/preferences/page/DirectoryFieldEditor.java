/*******************************************************************************
 * Copyright (c) 2018 BestSolution.at, EclipseSource and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API
 *     Camille Letavernier <cletavernier@eclipsesource.com> - initial implementation
 *******************************************************************************/
package org.eclipse.fx.ui.preferences.page;

import java.io.File;

import javafx.scene.control.Button;
import javafx.stage.DirectoryChooser;
import javafx.stage.Window;

/**
 * <p>A Field editor for directories.</p>
 */
public class DirectoryFieldEditor extends TextFieldEditor {

	public DirectoryFieldEditor(String name, String label) {
		super(name, label);
		Button browse = new Button("...");
		getTextContainer().getChildren().add(browse);
		browse.setOnAction(event -> browse(browse.getScene().getWindow()));
	}
	
	private void browse(Window parent) {
		DirectoryChooser chooser = new DirectoryChooser();
		chooser.setInitialDirectory(getCurrentFolder());
		File result = chooser.showDialog(parent);
		if (result != null) {
			setCurrentFolder(result);
		}
	}

	private void setCurrentFolder(File result) {
		getTextField().setText(result.getPath());
	}

	private File getCurrentFolder() {
		String textValue = getTextField().getText();
		File folder = new File(textValue);
		//Find the first existing folder in the current path hierarchy
		while (folder != null && ! folder.isDirectory()) {
			folder = folder.getParentFile();
		}
		return folder;
	}

	public DirectoryFieldEditor(String name) {
		this(name, null);
	}

}
