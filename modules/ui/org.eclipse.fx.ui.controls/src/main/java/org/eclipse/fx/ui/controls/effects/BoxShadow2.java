/*******************************************************************************
 * Copyright (c) 2020 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Christoph Caks <ccaks@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.controls.effects;

import java.util.List;

import org.eclipse.fx.core.bindings.FXBindings;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.ListBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
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
import javafx.geometry.Rectangle2D;
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class BoxShadow2 extends Region {

    private static final StyleablePropertyFactory<BoxShadow2> FACTORY = new StyleablePropertyFactory<>(Region.getClassCssMetaData());

    private static final CssMetaData<BoxShadow2, Boolean> META_VISIBLE = FACTORY.createBooleanCssMetaData("-box-shadow-visible", n -> n.shadowVisible, true); //$NON-NLS-1$
    private static final CssMetaData<BoxShadow2, Number> META_BLUR = FACTORY.createSizeCssMetaData("-box-shadow-blur", n -> n.blur, Double.valueOf(10.0)); //$NON-NLS-1$
    private static final CssMetaData<BoxShadow2, Number> META_SPREAD = FACTORY.createSizeCssMetaData("-box-shadow-spread", n -> n.spread, Double.valueOf(0.0)); //$NON-NLS-1$
    private static final CssMetaData<BoxShadow2, Number> META_OFFSET_X = FACTORY.createSizeCssMetaData("-box-shadow-offset-x", n -> n.offsetX, Double.valueOf(0.0)); //$NON-NLS-1$
    private static final CssMetaData<BoxShadow2, Number> META_OFFSET_Y = FACTORY.createSizeCssMetaData("-box-shadow-offset-y", n -> n.offsetY, Double.valueOf(0.0)); //$NON-NLS-1$
    private static final CssMetaData<BoxShadow2, Paint> META_FILL = FACTORY.createPaintCssMetaData("-box-shadow-fill", n -> n.fill, new Color(0, 0, 0, 0.75)); //$NON-NLS-1$

    private final StyleableBooleanProperty shadowVisible = new SimpleStyleableBooleanProperty(META_VISIBLE, this, "shadowVisible", true); //$NON-NLS-1$
    private final StyleableDoubleProperty offsetX = new SimpleStyleableDoubleProperty(META_OFFSET_X, this, "offsetX", Double.valueOf(0.0)); //$NON-NLS-1$
    private final StyleableDoubleProperty offsetY = new SimpleStyleableDoubleProperty(META_OFFSET_Y, this, "offsetY", Double.valueOf(0.0)); //$NON-NLS-1$
    private final StyleableDoubleProperty blur = new SimpleStyleableDoubleProperty(META_BLUR, this, "blur", Double.valueOf(10.0)); //$NON-NLS-1$
    private final StyleableDoubleProperty spread = new SimpleStyleableDoubleProperty(META_SPREAD, this, "spread", Double.valueOf(0.0)); //$NON-NLS-1$
    private final StyleableObjectProperty<Paint> fill = new SimpleStyleableObjectProperty<>(META_FILL, this, "fill", new Color(0, 0, 0, 0.75)); //$NON-NLS-1$

    private final ObjectProperty<Node> content = new SimpleObjectProperty<>(this, "content", null); //$NON-NLS-1$
    
    private Region shadow = new Region();

    private ObjectProperty<Node> shadowHolder = new SimpleObjectProperty<>(this.shadow);

    private ShadowTemplate shadowTemplate = null;
    
    private static class ShadowTemplate {
        private double blur;
        
        private Image imageTopLeft;
        private Image imageTop;
        private Image imageTopRight;
        private Image imageLeft;
        private Image imageRight;
        private Image imageBottomLeft;
        private Image imageBottom;
        private Image imageBottomRight;
        private Image imageCenter;
        
        public ShadowTemplate(double blur, Paint fill) {
            this.blur = blur;
            double left = 2*Math.ceil(blur);
            double top = 2*Math.ceil(blur);
            double right = 2*Math.ceil(blur);
            double bottom = 2*Math.ceil(blur);
            double center = 5;
            Canvas canvas = new Canvas(left + center + right, top + center + bottom);
            
            GraphicsContext gc = canvas.getGraphicsContext2D();
            gc.clearRect(0, 0, left + center + right, top + center + bottom);
            gc.setFill(fill);
            gc.fillRect(Math.ceil(blur), Math.ceil(blur), center + 2*Math.ceil(blur), center + 2*Math.ceil(blur));
            gc.applyEffect(new GaussianBlur(blur));
            
            this.imageTopLeft = canvas.snapshot(createParams(0, 0, top, left), null);
            this.imageTop = canvas.snapshot(createParams(left, 0, center, left), null);
            this.imageTopRight = canvas.snapshot(createParams(left + center, 0, right, left), null);
            this.imageLeft = canvas.snapshot(createParams(0, top, left, center), null);
            this.imageRight = canvas.snapshot(createParams(left + center, top, right, center), null);
            this.imageBottomLeft = canvas.snapshot(createParams(0, top + center, left, bottom), null);
            this.imageBottom = canvas.snapshot(createParams(left, top + center, center, bottom), null);
            this.imageBottomRight = canvas.snapshot(createParams(left + center, top + center, right, bottom), null);
            this.imageCenter = canvas.snapshot(createParams(left, top, center, center), null);
        }
        
        public Background createBackground(double width, double height) {
            double left = 2*Math.ceil(this.blur);
            double top = 2*Math.ceil(this.blur);
            double right = 2*Math.ceil(this.blur);
            double bottom = 2*Math.ceil(this.blur);
            
            BackgroundPosition posTopLeft = new BackgroundPosition(Side.LEFT, 0, false, Side.TOP, 0, false);
            
            BackgroundSize sizeTop = new BackgroundSize(width - left - right, top, false, false, false, false);
            BackgroundPosition posTop = new BackgroundPosition(Side.LEFT, left, false, Side.TOP, 0, false);
            
            BackgroundPosition posTopRight = new BackgroundPosition(Side.RIGHT, 0, false, Side.TOP, 0 , false);
            
            BackgroundSize sizeLeft = new BackgroundSize(left, height - top - bottom, false, false, false, false);
            BackgroundPosition posLeft = new BackgroundPosition(Side.LEFT, 0, false, Side.TOP, top, false);
            
            
            BackgroundSize sizeRight = new BackgroundSize(right, height - top - bottom, false, false, false, false);
            BackgroundPosition posRight = new BackgroundPosition(Side.RIGHT, 0, false, Side.TOP, top, false);
            
            BackgroundPosition posBottomLeft = new BackgroundPosition(Side.LEFT, 0, false, Side.BOTTOM, 0, false);
            
            BackgroundSize sizeBottom = new BackgroundSize(width - left - right, bottom, false, false, false, false);
            BackgroundPosition posBottom = new BackgroundPosition(Side.LEFT, left, false, Side.BOTTOM, 0, false);
            
            BackgroundPosition posBottomRight = new BackgroundPosition(Side.RIGHT, 0, false, Side.BOTTOM, 0, false);
            
            BackgroundSize sizeCenter = new BackgroundSize(width - left - right, height - top - bottom, false, false, false, false);
            BackgroundPosition posCenter = new BackgroundPosition(Side.LEFT, left, false, Side.TOP, top, false);
           
            return new Background(
                    new BackgroundImage(this.imageTopLeft, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, posTopLeft, BackgroundSize.DEFAULT),
                    new BackgroundImage(this.imageTop, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, posTop, sizeTop),
                    new BackgroundImage(this.imageTopRight, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, posTopRight, BackgroundSize.DEFAULT),
                    new BackgroundImage(this.imageLeft, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, posLeft, sizeLeft),
                    new BackgroundImage(this.imageRight, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, posRight, sizeRight),
                    new BackgroundImage(this.imageBottomLeft, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, posBottomLeft, BackgroundSize.DEFAULT),
                    new BackgroundImage(this.imageBottom, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, posBottom, sizeBottom),
                    new BackgroundImage(this.imageBottomRight, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, posBottomRight, BackgroundSize.DEFAULT)
                    ,new BackgroundImage(this.imageCenter, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, posCenter, sizeCenter)
                    );
        }
        
        private static SnapshotParameters createParams(double minX, double minY, double width, double height) {
            SnapshotParameters params = new SnapshotParameters();
            params.setFill(Color.TRANSPARENT);
            params.setViewport(new Rectangle2D(minX, minY, width, height));
            return params;
        }
    }
    
    public BoxShadow2() {
        this(null);
    }
    
    public BoxShadow2(Node content) {
        ListBinding<Node> children0 = FXBindings.toList(this.shadowHolder);
        ListBinding<Node> children1 = FXBindings.toList(this.content);
        ListBinding<Node> children = FXBindings.concat(children0, children1);
        Bindings.bindContent(getChildren(), children);

        this.shadow.translateXProperty().bind(this.offsetX);
        this.shadow.translateYProperty().bind(this.offsetY);
        
        this.shadow.visibleProperty().bind(this.shadowVisible);
        
        this.offsetX.addListener((x, o, n) -> requestLayout());
        this.offsetY.addListener((x, o, n) -> requestLayout());
        this.spread.addListener((x, o, n) -> requestLayout());
        this. blur.addListener((x, o, n) -> updateShadowTemplate());
        this.fill.addListener((x, o, n) -> updateShadowTemplate());
        
        updateShadowTemplate();
        
        setContent(content);
    }
    
    @Override protected double computeMinWidth(double height) {
        Node node = this.content.get();
        if (node != null) {
            return getInsets().getLeft() + node.minWidth(height) + getInsets().getRight();
        }
        return super.computeMinWidth(height);
    }

    @Override protected double computeMinHeight(double width) {
        Node node = this.content.get();
        if (node != null) {
            return getInsets().getTop() + node.minHeight(width) + getInsets().getBottom();
        }
        return super.computeMinHeight(width);
    }

    @Override protected double computePrefWidth(double height) {
        Node node = this.content.get();
        if (node != null) {
            return getInsets().getLeft() + node.prefWidth(height) + getInsets().getRight();
        }
        return super.computePrefWidth(height);
    }

    @Override protected double computePrefHeight(double width) {
        Node node = this.content.get();
        if (node != null) {
            return getInsets().getTop() + node.prefHeight(width) + getInsets().getBottom();
        }
        return super.computePrefHeight(width);
    }
   
    @Override protected double computeMaxWidth(double height) {
        Node node = this.content.get();
        if (node != null) {
            return getInsets().getLeft() + node.maxWidth(height) + getInsets().getRight();
        }
        return super.computeMaxWidth(height);
    }

    @Override protected double computeMaxHeight(double width) {
        Node node = this.content.get();
        if (node != null) {
            return getInsets().getTop() + node.maxHeight(width) + getInsets().getBottom();
        }
        return super.computeMaxHeight(width);
    }
    
    @Override
    public List<CssMetaData<? extends Styleable, ?>> getCssMetaData() {
        return FACTORY.getCssMetaData();
    }
    
    
    private double internal_getBlur() {
        return Math.max(0, this.blur.get());
    }
    
    private void updateShadowTemplate() {
        this.shadowTemplate = new ShadowTemplate(internal_getBlur(), fill.get());
        requestLayout();
    }

    @Override
    protected void layoutChildren() {
        Node node = this.content.get();
        if (node != null) {
            Insets insets = getInsets();
            node.resizeRelocate(insets.getLeft(), insets.getTop(), getWidth() - insets.getLeft() - insets.getRight(), getHeight() - insets.getTop() - insets.getBottom());
        }
        
        // resize shadow
        double shadowWidth = getWidth() + internal_getBlur() * 2;
        double shadowHeight = getHeight() + internal_getBlur() * 2;
        this.shadow.resizeRelocate(-internal_getBlur() - this.spread.get()/2, -internal_getBlur() - this.spread.get()/2, shadowWidth + this.spread.get(), shadowHeight + this.spread.get());
        this.shadow.setBackground(this.shadowTemplate.createBackground(shadowWidth + this.spread.get(), shadowHeight + this.spread.get()));
    }

    public final ObjectProperty<Node> contentProperty() {
        return this.content;
    }

    public final Node getContent() {
        return this.contentProperty().get();
    }

    public final void setContent(final Node content) {
        this.contentProperty().set(content);
    }

    public final DoubleProperty offsetXProperty() {
        return this.offsetX;
    }
    

    public final double getOffsetX() {
        return this.offsetXProperty().get();
    }
    

    public final void setOffsetX(final double offsetX) {
        this.offsetXProperty().set(offsetX);
    }
    

    public final DoubleProperty offsetYProperty() {
        return this.offsetY;
    }
    

    public final double getOffsetY() {
        return this.offsetYProperty().get();
    }
    

    public final void setOffsetY(final double offsetY) {
        this.offsetYProperty().set(offsetY);
    }
    

    public final DoubleProperty spreadProperty() {
        return this.spread;
    }
    

    public final double getSpread() {
        return this.spreadProperty().get();
    }
    

    public final void setSpread(final double spread) {
        this.spreadProperty().set(spread);
    }
    

    public final DoubleProperty blurProperty() {
        return this.blur;
    }
    

    public final double getBlur() {
        return this.blurProperty().get();
    }
    

    public final void setBlur(final double blur) {
        this.blurProperty().set(blur);
    }
    

    public final ObjectProperty<Paint> fillProperty() {
        return this.fill;
    }
    

    public final Paint getFill() {
        return this.fillProperty().get();
    }
    

    public final void setFill(final Paint fill) {
        this.fillProperty().set(fill);
    }

    public final StyleableBooleanProperty shadowVisibleProperty() {
        return this.shadowVisible;
    }
    

    public final boolean isShadowVisible() {
        return this.shadowVisibleProperty().get();
    }
    

    public final void setShadowVisible(final boolean shadowVisible) {
        this.shadowVisibleProperty().set(shadowVisible);
    }
    
    

}

