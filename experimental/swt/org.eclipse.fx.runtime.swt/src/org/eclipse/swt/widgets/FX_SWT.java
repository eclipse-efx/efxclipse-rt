/*******************************************************************************
 * Copyright (c) 2014 IBM Corporation, BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 * 	   IBM Corporation - initial API
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.swt.widgets;

import java.util.HashMap;
import java.util.Map;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;

public class FX_SWT {
	public static Composite new_Composite(AnchorPane pane) {
		Composite c = new FXSWTEmbed(Display.getCurrent(), SWT.NONE);
		c.setLayout(new FillLayout());
		
		Region n = c.internal_getNativeObject();
		AnchorPane.setBottomAnchor(n, 0.0);
		AnchorPane.setTopAnchor(n, 0.0);
		AnchorPane.setLeftAnchor(n, 0.0);
		AnchorPane.setRightAnchor(n, 0.0);
		pane.getChildren().add(n);
		return c;
	}
	
	public static Composite new_Composite(BorderPane pane) {
		Composite c = new FXSWTEmbed(Display.getCurrent(), SWT.NONE);
		c.setLayout(new FillLayout());
		pane.setCenter(c.internal_getNativeObject());
		return c;
	}
	
	public static Composite new_Composite(Group group) {
		Composite c = new FXSWTEmbed(Display.getCurrent(), SWT.NONE);
		c.setLayout(new FillLayout());
		group.getChildren().add(c.internal_getNativeObject());
		return c;
	}
	
	public static Composite new_Composite(HBox pane) {
		Composite c = new FXSWTEmbed(Display.getCurrent(), SWT.NONE);
		c.setLayout(new FillLayout());
		pane.getChildren().add(c.internal_getNativeObject());
		HBox.setHgrow(c.internal_getNativeObject(), Priority.ALWAYS);
		return c;
	}
	
	static class FXSWTEmbed extends Composite {
		private static Map<Stage, Shell> SHELL_MAP = new HashMap<>();
		FXSWTEmbed(Display display, int style) {
			super(display, style);
			internal_getNativeObject().getStylesheets().add(getClass().getClassLoader().getResource("org/eclipse/swt/internal/swt.css").toExternalForm());
		}
		
		@Override
		public Shell getShell() {
			Shell s = null;
			if( internal_getNativeObject().getScene() != null && internal_getNativeObject().getScene().getWindow() != null ) {
				final Stage w = (Stage) internal_getNativeObject().getScene().getWindow();
				s = SHELL_MAP.get(w);
				if( s == null ) {
					s = new Shell(w);
					w.setOnHidden(new EventHandler<WindowEvent>() {
						
						@Override
						public void handle(WindowEvent event) {
							SHELL_MAP.remove(w);
						}
					});	
				}
			}
			return s;
		}
	}

}
