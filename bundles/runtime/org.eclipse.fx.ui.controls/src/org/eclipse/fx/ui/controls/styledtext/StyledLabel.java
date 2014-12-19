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
import javafx.scene.control.Control;
import javafx.scene.control.Skin;

import org.eclipse.fx.ui.controls.styledtext.skin.StyledLabelSkin;
import org.eclipse.jdt.annotation.NonNull;

public class StyledLabel extends Control {
	private ObjectProperty<@NonNull StyledString> styledString = new SimpleObjectProperty<>(this,"styledString",new StyledString()); //$NON-NLS-1$

	public StyledLabel(StyledString s) {
		this.styledString.set(s);
		setMouseTransparent(true);
	}

	public void setStyledString(@NonNull StyledString s) {
		this.styledString.set(s);
	}

	public @NonNull StyledString getStyleString() {
		return this.styledString.get();
	}

	public ObjectProperty<@NonNull StyledString> styledStringProperty() {
		return this.styledString;
	}

	@Override
	protected Skin<?> createDefaultSkin() {
		return new StyledLabelSkin(this);
	}
}
