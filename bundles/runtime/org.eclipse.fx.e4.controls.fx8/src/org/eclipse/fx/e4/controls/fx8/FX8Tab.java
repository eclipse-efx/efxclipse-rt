/*******************************************************************************
 * Copyright (c) 2013 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.e4.controls.fx8;

import org.eclipse.fx.e4.controls.FXTab;

import javafx.beans.DefaultProperty;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Tab;
import javafx.util.Callback;

@DefaultProperty("content")
public class FX8Tab extends Tab implements FXTab {
	private Callback<Tab, Boolean> closeVetoHandler;

	public FX8Tab() {
		setOnCloseRequest(new EventHandler<Event>() {
			
			@Override
			public void handle(Event event) {
				if( closeVetoHandler != null && closeVetoHandler.call(FX8Tab.this) ) {
					event.consume();
				}
			}
		});
	}
	
	public Callback<Tab, Boolean> getCloseVetoHandler() {
		return closeVetoHandler;
	}

	@Override
	public void setCloseVetoHandler(Callback<Tab, Boolean> closeVetoHandler) {
		this.closeVetoHandler = closeVetoHandler;
	}
}