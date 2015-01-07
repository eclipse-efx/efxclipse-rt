/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.controls.styledtext;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.Node;
import javafx.scene.control.Control;
import javafx.scene.control.Skin;

import org.eclipse.fx.ui.controls.styledtext.skin.StyledLabelSkin;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * A label which is able to display {@link StyledString}
 *
 * @since 1.2
 */
public class StyledLabel extends Control {
	@NonNull
	private final ObjectProperty<@NonNull StyledString> styledString = new SimpleObjectProperty<>(
			this, "styledString", new StyledString()); //$NON-NLS-1$
	@NonNull
	private final ObjectProperty<@Nullable Node> graphic = new SimpleObjectProperty<>(
			this, "graphic", null); //$NON-NLS-1$

	/**
	 * Create a new control
	 *
	 * @param s
	 *            the styled string
	 */
	public StyledLabel(@NonNull StyledString s) {
		this.styledString.set(s);
		getStyleClass().add("styled-label"); //$NON-NLS-1$
		setMouseTransparent(true);
	}

	/**
	 * Set a new styled string
	 *
	 * @param s
	 *            the new styled string
	 */
	public void setStyledString(@NonNull StyledString s) {
		this.styledString.set(s);
	}

	/**
	 * @return the current styled string
	 */
	public @NonNull StyledString getStyleString() {
		return this.styledString.get();
	}

	/**
	 * @return styled string property to observe
	 */
	public @NonNull ObjectProperty<@NonNull StyledString> styledStringProperty() {
		return this.styledString;
	}

	/**
	 * Set a new graphic node
	 *
	 * @param graphic
	 *            the graphic node
	 */
	public void setGraphic(@Nullable Node graphic) {
		this.graphic.set(graphic);
	}

	/**
	 * @return the new graphic node
	 */
	public @Nullable Node getGraphic() {
		return this.graphic.get();
	}

	/**
	 * @return graphic node property to observe
	 */
	public ObjectProperty<@Nullable Node> graphicProperty() {
		return this.graphic;
	}

	@Override
	protected Skin<?> createDefaultSkin() {
		return new StyledLabelSkin(this);
	}
}
