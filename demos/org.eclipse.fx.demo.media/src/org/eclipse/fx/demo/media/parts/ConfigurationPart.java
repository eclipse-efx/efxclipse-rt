/*******************************************************************************
 * Copyright (c) 2012 BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
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
