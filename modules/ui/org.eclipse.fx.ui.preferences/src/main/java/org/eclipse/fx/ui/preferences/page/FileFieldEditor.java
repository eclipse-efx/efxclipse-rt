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
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Window;

/**
 * <p>
 * A Field editor to select an existing file.
 * </p>
 */
public class FileFieldEditor extends StringFieldEditor {

	/**
	 * CSS Style Class for the Container HBox of this {@link FileFieldEditor}
	 */
	public static final String FILE_EDITOR_STYLE = "file-field-container";
	
	private Collection<ExtensionFilter> extensionFilters;

	public FileFieldEditor(String name, String label) {
		super(name, label);
		Button browse = new Button("...");
		getTextContainer().getChildren().add(browse);
		getTextContainer().getStyleClass().add(FILE_EDITOR_STYLE);
		browse.setOnAction(event -> browse(browse.getScene().getWindow()));
	}

	private void browse(Window parent) {
		FileChooser chooser = new FileChooser();
		chooser.setInitialDirectory(getCurrentFolder());
		chooser.setInitialFileName(getCurrentFileName());
		chooser.getExtensionFilters().setAll(getExtensionFilters());
		File result = chooser.showOpenDialog(parent);
		if (result != null) {
			setCurrentFolder(result);
		}
	}

	private Collection<ExtensionFilter> getExtensionFilters() {
		return extensionFilters == null ? Collections.emptyList() : extensionFilters;
	}

	/**
	 * Sets the file extension filters, in the form <code>*.&lt;extension&gt;</code>
	 * 
	 * @param filters
	 *            The file extension filters
	 */
	public void setExtensionFilters(String... filters) {
		this.extensionFilters = Arrays.stream(filters).map(f -> new ExtensionFilter(f, f)).collect(Collectors.toList());
	}

	/**
	 * <p>
	 * Sets the file extension filters for the File chooser dialog
	 * </p>
	 */
	public void setExtensionFilters(ExtensionFilter... filters) {
		this.extensionFilters = Arrays.asList(filters);
	}

	private String getCurrentFileName() {
		String textValue = getTextField().getText();
		if (textValue == null) {
			return null;
		}
		File file = new File(textValue);
		return file.getName();
	}

	private void setCurrentFolder(File result) {
		getTextField().setText(result.getPath());
	}

	private File getCurrentFolder() {
		String textValue = getTextField().getText();
		if (textValue == null) {
			return null;
		}
		File folder = new File(textValue);
		// Find the first existing folder in the current path hierarchy
		while (folder != null && !folder.isDirectory()) {
			folder = folder.getParentFile();
		}
		return folder;
	}

	public FileFieldEditor(String name) {
		this(name, null);
	}

}
