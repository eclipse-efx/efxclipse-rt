/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Christoph Caks <ccaks@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.controls.image.skin;

import org.eclipse.fx.ui.controls.image.FontIcon;
import org.eclipse.fx.ui.controls.image.FontIconView;
import org.eclipse.jdt.annotation.NonNull;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.SkinBase;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * Skin for the {@link FontIconView}
 */
public class FontIconViewSkin extends SkinBase<FontIconView> {

	private Text text;

	/**
	 * Create a new skin
	 *
	 * @param control
	 *            the control
	 */
	public FontIconViewSkin(@NonNull FontIconView control) {
		super(control);

		this.text = new Text();
		this.text.setMouseTransparent(true);

		getChildren().add(this.text);

		this.text.fillProperty().bind(getSkinnable().iconFillProperty());

		getSkinnable().iconFontSizeProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				updateIcon(getSkinnable().getIcon(), newValue.doubleValue());
			}
		});
		getSkinnable().iconProperty().addListener(new ChangeListener<FontIcon>() {

			@Override
			public void changed(ObservableValue<? extends FontIcon> observable, FontIcon oldValue, FontIcon newValue) {
				updateIcon(newValue, getSkinnable().getIconFontSize());
			}
		});

		updateIcon(getSkinnable().getIcon(),getSkinnable().getIconFontSize());
	}

	void updateIcon(FontIcon icon, double size) {
		this.text.setFont(Font.font(icon.getFont().getFamily(), size));
		this.text.setText(Character.toString(icon.getIconCode()));
	}
}
