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



import org.eclipse.fx.ui.mobile.animations.TransitionDelegate;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import javafx.scene.shape.Rectangle;

public class Deck extends Region {
	private ObservableList<Card> cards = FXCollections.observableArrayList();
	
	private BorderPane contenArea;
	
	public Deck() {
		contenArea = new BorderPane();
		getChildren().add(contenArea);
		cards.addListener(new InvalidationListener() {
			
			@Override
			public void invalidated(Observable observable) {
				contenArea.setCenter(cards.get(0));
				cards.removeListener(this);
			}
		});
	}
	
	@Override
	protected void layoutChildren() {
		super.layoutChildren();
		contenArea.resizeRelocate(getInsets().getLeft(), getInsets().getTop(),getWidth()-getInsets().getLeft(), getHeight()-getInsets().getTop());
		contenArea.setClip(new Rectangle(getWidth()-getInsets().getLeft(), getHeight()-getInsets().getTop()));
	}
	
	public ObservableList<Card> getCards() {
		return cards;
	}
	
	public void moveTo(String name, TransitionType animation) {
		moveTo(name, animation.getDelegate());
	}
	
	public void moveTo(String name, TransitionDelegate delegate) {
		for( Card c : cards ) {
			if( name.equals(c.getName()) ) {
				if( delegate != null ) {
					delegate.transitionTo(contenArea, (Card) contenArea.getCenter(), c);
				} else {
					contenArea.setCenter(c);	
				}
				
				break;
			}
		}
	}
	
}
