/*******************************************************************************
 * Copyright (c) 2022 BestSolution.at and others.
 *  
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *  
 * SPDX-License-Identifier: EPL-2.0
 *  
 * Contributors:
 *     BestSolution.at - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.text.ui.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;

import javafx.beans.property.StringProperty;
import javafx.css.CssMetaData;
import javafx.css.SimpleStyleableStringProperty;
import javafx.css.StyleConverter;
import javafx.css.Styleable;
import javafx.css.StyleableProperty;
import javafx.css.StyleableStringProperty;
import javafx.scene.layout.Region;
import javafx.scene.text.Text;

public class InvisibleCharNode extends Text {

	@SuppressWarnings("null")
	@NonNull
	private static final CssMetaData<InvisibleCharNode, @NonNull String> CONTENT = new CssMetaData<InvisibleCharNode, @NonNull String>("-fx-content", StyleConverter.getStringConverter(), "") { //$NON-NLS-1$ //$NON-NLS-2$
		@Override
		public boolean isSettable(InvisibleCharNode styleable) {
			return !styleable.content.isBound();
		}
		@SuppressWarnings("unchecked")
		@Override
		public StyleableProperty<@NonNull String> getStyleableProperty(InvisibleCharNode styleable) {
			return styleable.content;
		}
	};

	private static final List<CssMetaData<? extends Styleable, ?>> STYLEABLES;

	static {
		final List<CssMetaData<? extends Styleable, ?>> styleables = new ArrayList<CssMetaData<? extends Styleable, ?>>(Text.getClassCssMetaData());
		styleables.add(CONTENT);
		STYLEABLES = Collections.unmodifiableList(styleables);
	}

	public static List<CssMetaData<? extends Styleable, ?>> getClassCssMetaData() {
		return STYLEABLES;
	}

	@Override
	public List<CssMetaData<? extends Styleable, ?>> getCssMetaData() {
		return getClassCssMetaData();
	}

	private StyleableStringProperty content = new SimpleStyleableStringProperty(CONTENT, this, "content", ""); //$NON-NLS-1$ //$NON-NLS-2$

	public StringProperty contentProperty() {
		return this.content;
	}

	public void setContent(String content) {
		this.content.set(content);
	}
	public String getContent() {
		return this.content.get();
	}

	public InvisibleCharNode() {
		textProperty().bind(content);
	}
}
