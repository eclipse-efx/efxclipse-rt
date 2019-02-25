/*******************************************************************************
 * Copyright (c) 2019 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.controls.effects;

import java.util.List;

import org.eclipse.fx.core.observable.FXObservableUtil;

import javafx.css.CssMetaData;
import javafx.css.SimpleStyleableBooleanProperty;
import javafx.css.SimpleStyleableDoubleProperty;
import javafx.css.SimpleStyleableObjectProperty;
import javafx.css.Styleable;
import javafx.css.StyleableBooleanProperty;
import javafx.css.StyleableDoubleProperty;
import javafx.css.StyleableObjectProperty;
import javafx.css.StyleablePropertyFactory;
import javafx.geometry.Insets;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;

/**
 * Emulates a HTML-Boxshadow
 */
public final class BoxShadow extends Region {
	private Region node;
	private Region shadowNode;

	private static StyleablePropertyFactory<BoxShadow> FACTORY = new StyleablePropertyFactory<>(Region.getClassCssMetaData());

	private static CssMetaData<BoxShadow, Boolean> META_VISIBLE = FACTORY.createBooleanCssMetaData("-box-shadow-visible", n -> n.shadowVisible, false); //$NON-NLS-1$
	private static CssMetaData<BoxShadow, Number> META_H_OFFSET = FACTORY.createSizeCssMetaData("-box-h-offset", n -> n.hOffset, Double.valueOf(0.0)); //$NON-NLS-1$
	private static CssMetaData<BoxShadow, Number> META_V_OFFSET = FACTORY.createSizeCssMetaData("-box-v-offset", n -> n.vOffset, Double.valueOf(0.0)); //$NON-NLS-1$
	private static CssMetaData<BoxShadow, Number> META_BLUR = FACTORY.createSizeCssMetaData("-box-blur", n -> n.blur, Double.valueOf(10.0)); //$NON-NLS-1$
	private static CssMetaData<BoxShadow, Number> META_SPREAD = FACTORY.createSizeCssMetaData("-box-spread", n -> n.spread, Double.valueOf(0)); //$NON-NLS-1$
	private static CssMetaData<BoxShadow, Color> META_COLOR = FACTORY.createColorCssMetaData("-box-color", n -> n.color, Color.BLACK); //$NON-NLS-1$
	
	private StyleableBooleanProperty shadowVisible = new SimpleStyleableBooleanProperty(META_VISIBLE, this, "shadowVisible", false); //$NON-NLS-1$
	private StyleableDoubleProperty hOffset = new SimpleStyleableDoubleProperty(META_H_OFFSET, this, "hOffset", Double.valueOf(0.0)); //$NON-NLS-1$
	private StyleableDoubleProperty vOffset = new SimpleStyleableDoubleProperty(META_V_OFFSET, this, "hOffset", Double.valueOf(0.0)); //$NON-NLS-1$
	private StyleableDoubleProperty blur = new SimpleStyleableDoubleProperty(META_BLUR, this, "blur", Double.valueOf(10.0)); //$NON-NLS-1$
	private StyleableDoubleProperty spread = new SimpleStyleableDoubleProperty(META_SPREAD, this, "spread", Double.valueOf(0.0)); //$NON-NLS-1$
	private StyleableObjectProperty<Color> color = new SimpleStyleableObjectProperty<>(META_COLOR, this, "color", Color.BLACK); //$NON-NLS-1$
	
	/**
	 * 
	 * @param node
	 */
	public BoxShadow(Region node) {
		getStyleClass().add("box-shadow"); //$NON-NLS-1$
		this.node = node;
		this.shadowNode = new Region();
		this.shadowNode.getStyleClass().add("shadow-node"); //$NON-NLS-1$
		

		DropShadow s = new DropShadow();
		s.setBlurType(BlurType.GAUSSIAN);
		s.colorProperty().bind(this.color);
		s.radiusProperty().bind(this.blur);
		this.shadowNode.setEffect(s);
		this.shadowNode.visibleProperty().bind(this.shadowVisible);
		this.shadowNode.translateXProperty().bind(this.hOffset);
		this.shadowNode.translateYProperty().bind(this.vOffset);
		getChildren().addAll(this.shadowNode, node);
		
		FXObservableUtil.onChange(this.node.backgroundProperty(), this::handleBackgroundChange);
		handleBackgroundChange(node.getBackground());
	}
	
	private void handleBackgroundChange(Background background) {
		Background newBackground = new Background(new BackgroundFill(new Color(1, 1, 1, 0.1), CornerRadii.EMPTY, Insets.EMPTY));
		if( background != null && ! background.getFills().isEmpty() ) {
			CornerRadii radii = background.getFills().get(0).getRadii();
			if( radii != null ) {
				newBackground = new Background(new BackgroundFill(new Color(1, 1, 1, 0.1), radii, Insets.EMPTY));
			}
		}
		
		this.shadowNode.setBackground(newBackground);
	}

	@Override
	public List<CssMetaData<? extends Styleable, ?>> getCssMetaData() {
		return FACTORY.getCssMetaData();
	}

	@Override
	protected double computeMinWidth(double height) {
		return this.node.minWidth(height);
	}

	@Override
	protected double computeMinHeight(double width) {
		return this.node.minHeight(width);
	}

	@Override
	protected double computePrefHeight(double width) {
		return this.node.prefHeight(width);
	}

	@Override
	protected double computePrefWidth(double height) {
		return this.node.prefWidth(height);
	}

	@Override
	protected double computeMaxHeight(double width) {
		return this.node.maxHeight(width);
	}

	@Override
	protected double computeMaxWidth(double height) {
		return this.node.maxWidth(height);
	}

	@Override
	protected void layoutChildren() {
		this.node.resizeRelocate(0, 0, getWidth(), getHeight());
		double d = this.spread.get() * -1;
		this.shadowNode.resizeRelocate(d, d, getWidth() - d * 2, getHeight() - d * 2);
	}

	@Override
	public String toString() {
		return "BoxShadow [hOffset=" + this.hOffset + ", vOffset=" + this.vOffset + ", blur=" + this.blur + ", spread=" + this.spread + ", color=" + this.color + "]"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$
	}
}
