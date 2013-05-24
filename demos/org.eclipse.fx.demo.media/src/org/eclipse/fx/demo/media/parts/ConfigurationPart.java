/*******************************************************************************
 * Copyright (c) 2012 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.demo.media.parts;

import java.io.IOException;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import javax.annotation.PostConstruct;

import org.eclipse.fx.ui.di.FXMLBuilder;
import org.eclipse.fx.ui.di.FXMLLoader;
import org.eclipse.fx.ui.di.FXMLLoaderFactory;

public class ConfigurationPart {
	
	@PostConstruct
	void init(BorderPane parent, @FXMLLoader FXMLLoaderFactory factory) {
		try {
			FXMLBuilder<GridPane> builder = factory.loadRequestorRelative("ConfigurationEditor.fxml");
			GridPane p = builder.load();
			parent.setTop(p);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
