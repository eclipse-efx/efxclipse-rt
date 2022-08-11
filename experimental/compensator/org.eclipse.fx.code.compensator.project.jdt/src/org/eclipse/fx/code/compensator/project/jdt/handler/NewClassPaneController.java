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
package org.eclipse.fx.code.compensator.project.jdt.handler;

import java.net.URL;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.fx.code.compensator.project.ProjectNavigatorItem;
import org.eclipse.fx.code.compensator.project.jdt.internal.JDTPackageItem;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.CheckBox;

public class NewClassPaneController implements Initializable {

	@FXML TextField packageField;
	@FXML TextField className;
	@FXML RadioButton publicModifier;
	@FXML RadioButton packageModifier;
	@FXML RadioButton protectedModifier;
	@FXML CheckBox abstractModifier;
	@FXML CheckBox finalModifier;
	
	private final ProjectNavigatorItem navigationItem;
	
	@Inject
	public NewClassPaneController(@Named("navigatorSelection") ProjectNavigatorItem navigationItem) {
		this.navigationItem = navigationItem;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		if( navigationItem instanceof JDTPackageItem ) {
			StringBuilder b = new StringBuilder();
			JDTPackageItem i = (JDTPackageItem) navigationItem;
			b.append(i.getLabel());
			
			while( i.getParent() instanceof JDTPackageItem ) {
				i = (JDTPackageItem) i.getParent();
				b.insert(0, i.getLabel() + ".");
			}
			
			packageField.setText(b.toString());
		}
	}
	
	public String getPackageName() {
		return packageField.getText();
	}
	
	public String getClassName() {
		return className.getText();
	}
}
