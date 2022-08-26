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
package org.eclipse.fx.testcases.e4.parts;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

import org.eclipse.fx.core.fxml.FXMLDocument;

public class TestFXML extends FXMLDocument<HBox> {

	@Override
	public Object getController() {
		return null;
	}

	@Override
	public HBox load(org.eclipse.fx.core.fxml.FXMLDocument.LoadData<HBox> data) {
		HBox b = new HBox();
		b.getChildren().add(new Button("This is the Java class"));
		return b;
	}

}
