/*******************************************************************************
 * Copyright (c) 2013 BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.mobile;

import org.eclipse.fx.ui.mobile.animations.TransitionDelegate;
import org.eclipse.jdt.annotation.NonNull;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import javafx.scene.shape.Rectangle;

/**
 * A stack of cards allowing switch from card to card
 */
public class Deck extends Region {
	@SuppressWarnings("null")
	@NonNull
	final ObservableList<@NonNull Card> cards = FXCollections.observableArrayList();

	BorderPane contenArea;

	/**
	 * Create a new instance
	 */
	public Deck() {
		this.contenArea = new BorderPane();
		getChildren().add(this.contenArea);
		this.cards.addListener(new InvalidationListener() {

			@Override
			public void invalidated(Observable observable) {
				Deck.this.contenArea.setCenter(Deck.this.cards.get(0));
				Deck.this.cards.removeListener(this);
			}
		});
	}

	@Override
	protected void layoutChildren() {
		super.layoutChildren();
		this.contenArea.resizeRelocate(getInsets().getLeft(), getInsets().getTop(), getWidth() - getInsets().getLeft(), getHeight() - getInsets().getTop());
		this.contenArea.setClip(new Rectangle(getWidth() - getInsets().getLeft(), getHeight() - getInsets().getTop()));
	}

	/**
	 * @return the cards
	 */
	public @NonNull ObservableList<@NonNull Card> getCards() {
		return this.cards;
	}

	/**
	 * Switch to another card
	 * 
	 * @param name
	 *            the name of the card
	 * @param animation
	 *            the predefined animation
	 */
	public void moveTo(@NonNull String name, @NonNull TransitionType animation) {
		moveTo(name, animation.getDelegate());
	}

	/**
	 * Switch to another card
	 * 
	 * @param name
	 *            the name of the card
	 * @param delegate
	 *            the delegate to do the switch
	 */
	public void moveTo(String name, TransitionDelegate delegate) {
		for (Card c : this.cards) {
			if (name.equals(c.getName())) {
				if (this.contenArea.getCenter() != c) {
					if (delegate != null) {
						delegate.transitionTo(this.contenArea, (Card) this.contenArea.getCenter(), c);
					} else {
						this.contenArea.setCenter(c);
					}
				}

				break;
			}
		}
	}

}
