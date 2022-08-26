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
package org.eclipse.fx.demo.e4.parts;

import java.io.IOException;

import javafx.scene.Node;
import javafx.scene.layout.BorderPane;

import javax.annotation.PostConstruct;

import org.eclipse.fx.ui.di.FXMLBuilder;
import org.eclipse.fx.ui.di.FXMLLoader;
import org.eclipse.fx.ui.di.FXMLLoaderFactory;

public class PersonDetailPart {

	@PostConstruct
	void init(BorderPane parent, @FXMLLoader FXMLLoaderFactory factory) {
		try {
			FXMLBuilder<Node> builder = factory.loadRequestorRelative("personform.fxml");
			parent.setCenter(builder.load());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
