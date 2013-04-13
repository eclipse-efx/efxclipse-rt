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
package org.eclipse.fx.e4.controls.fx2;


import java.lang.reflect.Field;

import javafx.collections.ListChangeListener;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.TabPane;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

import com.sun.javafx.scene.control.skin.TabPaneSkin;

public class FX2TabPaneSkin extends TabPaneSkin {

	public FX2TabPaneSkin(TabPane arg0) {
		super(arg0);
		try {
			Field f = TabPaneSkin.class.getDeclaredField("tabHeaderArea");
			f.setAccessible(true);
			Object tabHeaderArea = f.get(this);
			f = tabHeaderArea.getClass().getDeclaredField("headersRegion");
			f.setAccessible(true);
			StackPane headersRegion = (StackPane) f.get(tabHeaderArea);
			headersRegion.getChildren().addListener(new ListChangeListener<Node>() {

				@Override
				public void onChanged(javafx.collections.ListChangeListener.Change<? extends Node> c) {
					while( c.next() ) {
						for( Node n : c.getAddedSubList() ) {
							try {
								Field tabField = n.getClass().getDeclaredField("tab");
								tabField.setAccessible(true);
								final FX2Tab tab = (FX2Tab) tabField.get(n);
								Field btnField = n.getClass().getDeclaredField("closeBtn");
								btnField.setAccessible(true);
								StackPane b = (StackPane) btnField.get(n);
								final EventHandler<? super MouseEvent> originalHandler = b.onMousePressedProperty().get();
								b.setOnMousePressed(new EventHandler<MouseEvent>() {

									@Override
									public void handle(MouseEvent event) {
										if( tab.getCloseVetoHandler() == null || ! tab.getCloseVetoHandler().call(tab) ) {
											originalHandler.handle(event);
										}
									}
								});
								
								final EventHandler<? super MouseEvent> originalHandler2 = n.onMousePressedProperty().get();
								n.setOnMousePressed(new EventHandler<MouseEvent>() {

									@Override
									public void handle(MouseEvent event) {
										if (event.getButton().equals(MouseButton.MIDDLE)) {
											if( tab.getCloseVetoHandler() == null || ! tab.getCloseVetoHandler().call(tab) ) {
												originalHandler2.handle(event);
											}
										} else {
											originalHandler2.handle(event);	
										}
									}
								});
							} catch(Exception e) {
								e.printStackTrace();
							}
						}
					}
				}
				
			});
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
