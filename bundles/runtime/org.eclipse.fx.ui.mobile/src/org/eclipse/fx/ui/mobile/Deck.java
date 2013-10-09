/*******************************************************************************
 * Copyright (c) 2013 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.mobile;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;

public class Deck extends Region {
	private ObservableList<Card> cards = FXCollections.observableArrayList();
	
	private BorderPane contenArea;
	
	public Deck() {
		contenArea = new BorderPane();
		getChildren().add(contenArea);
	}
	
	public ObservableList<Card> getCards() {
		return cards;
	}
	
	public void moveTo(String name, TransitionType animation) {
		
	}
	
	public void moveTo(String name, TransitionDelegate delegate) {
		
	}
	
	interface TransitionDelegate {
		void transition(Card from, Card to, Runnable finished);
	}
}
