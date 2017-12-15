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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.layout.BorderPane;

/**
 * A main UI area
 */
public class Card extends BorderPane {
	@NonNull
	private final StringProperty name = new SimpleStringProperty(this, "name"); //$NON-NLS-1$

	/**
	 * set the name of the card
	 * 
	 * @param name
	 *            the name
	 */
	public void setName(@NonNull String name) {
		this.name.set(name);
	}

	/**
	 * @return the name of the card
	 */
	public @Nullable String getName() {
		return this.name.get();
	}

	/**
	 * @return the string property
	 */
	public @NonNull StringProperty nameProperty() {
		return this.name;
	}
}
