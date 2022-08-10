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
