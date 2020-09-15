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

/**
 * Support to add a shadow effect to an arbitrary Node, with better performances
 * than the javafx one.
 *
 */
public class BoxShadow2 extends Region {

    private static final StyleablePropertyFactory<BoxShadow2> FACTORY = new StyleablePropertyFactory<>(Region.getClassCssMetaData());

    private static final CssMetaData<BoxShadow2, Boolean> META_VISIBLE = FACTORY.createBooleanCssMetaData("-box-shadow-visible", bsn -> bsn.shadowVisible, true); //$NON-NLS-1$
    private static final CssMetaData<BoxShadow2, Number> META_BLUR = FACTORY.createSizeCssMetaData("-box-shadow-blur", bsn -> bsn.blur, Double.valueOf(10.0)); //$NON-NLS-1$
    private static final CssMetaData<BoxShadow2, Number> META_SPREAD = FACTORY.createSizeCssMetaData("-box-shadow-spread", bsn -> bsn.spread, Double.valueOf(0.0)); //$NON-NLS-1$
    private static final CssMetaData<BoxShadow2, Number> META_OFFSET_X = FACTORY.createSizeCssMetaData("-box-shadow-offset-x", bsn -> bsn.offsetX, Double.valueOf(0.0)); //$NON-NLS-1$
    private static final CssMetaData<BoxShadow2, Number> META_OFFSET_Y = FACTORY.createSizeCssMetaData("-box-shadow-offset-y", bsn -> bsn.offsetY, Double.valueOf(0.0)); //$NON-NLS-1$
    private static final CssMetaData<BoxShadow2, Paint> META_FILL = FACTORY.createPaintCssMetaData("-box-shadow-fill", bsn -> bsn.fill, new Color(0, 0, 0, 0.75)); //$NON-NLS-1$

    private final StyleableBooleanProperty shadowVisible = new SimpleStyleableBooleanProperty(META_VISIBLE, this, "shadowVisible", true); //$NON-NLS-1$
    private final StyleableDoubleProperty offsetX = new SimpleStyleableDoubleProperty(META_OFFSET_X, this, "offsetX", Double.valueOf(0.0)); //$NON-NLS-1$
    private final StyleableDoubleProperty offsetY = new SimpleStyleableDoubleProperty(META_OFFSET_Y, this, "offsetY", Double.valueOf(0.0)); //$NON-NLS-1$
    private final StyleableDoubleProperty blur = new SimpleStyleableDoubleProperty(META_BLUR, this, "blur", Double.valueOf(10.0)); //$NON-NLS-1$
    private final StyleableDoubleProperty spread = new SimpleStyleableDoubleProperty(META_SPREAD, this, "spread", Double.valueOf(0.0)); //$NON-NLS-1$
    private final StyleableObjectProperty<Paint> fill = new SimpleStyleableObjectProperty<>(META_FILL, this, "fill", new Color(0, 0, 0, 0.75)); //$NON-NLS-1$

    private final ObjectProperty<Node> content = new SimpleObjectProperty<>(this, "content", null); //$NON-NLS-1$

    private Region shadow = new Region();
    private final SimpleObjectProperty<Node> shadowProperty = new SimpleObjectProperty<>(shadow);

    private final ListBinding<Node> shadowListBinding = FXBindings.toList(this.shadowProperty);
    private final ListBinding<Node> contentListBinding = FXBindings.toList(this.content);
    private final ListBinding<Node> childrenListBinding = FXBindings.concat(shadowListBinding, contentListBinding);
    
    private ShadowTemplate shadowTemplate;

    private static class ShadowTemplate {    // NOSONAR 
        static final int BLUR_MULTIPLIER = 2;
        private static final int CENTER_SIZE = 5;

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
            double left = BLUR_MULTIPLIER * Math.ceil(blur);
            double top = BLUR_MULTIPLIER * Math.ceil(blur);
            double right = BLUR_MULTIPLIER * Math.ceil(blur);
            double bottom = BLUR_MULTIPLIER * Math.ceil(blur);
            double center = CENTER_SIZE;
            Canvas canvas = new Canvas(left + center + right, top + center + bottom);

            GraphicsContext gc = canvas.getGraphicsContext2D();
            gc.clearRect(0, 0, left + center + right, top + center + bottom);
            gc.setFill(fill);
            gc.fillRect(Math.ceil(blur), Math.ceil(blur), center + BLUR_MULTIPLIER * Math.ceil(blur), center + BLUR_MULTIPLIER * Math.ceil(blur));
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
            double left = BLUR_MULTIPLIER * Math.ceil(this.blur);
            double top = BLUR_MULTIPLIER * Math.ceil(this.blur);
            double right = BLUR_MULTIPLIER * Math.ceil(this.blur);
            double bottom = BLUR_MULTIPLIER * Math.ceil(this.blur);

            BackgroundPosition posTopLeft = new BackgroundPosition(Side.LEFT, 0, false, Side.TOP, 0, false);

            final double backgroundWidth = Math.max(width - left - right, 0);
            final double backgroundHeight = Math.max(height - top - bottom, 0);

            BackgroundSize sizeTop = new BackgroundSize(backgroundWidth, top, false, false, false, false);
            BackgroundPosition posTop = new BackgroundPosition(Side.LEFT, left, false, Side.TOP, 0, false);

            BackgroundPosition posTopRight = new BackgroundPosition(Side.RIGHT, 0, false, Side.TOP, 0, false);

            BackgroundSize sizeLeft = new BackgroundSize(left, backgroundHeight, false, false, false, false);
            BackgroundPosition posLeft = new BackgroundPosition(Side.LEFT, 0, false, Side.TOP, top, false);

            BackgroundSize sizeRight = new BackgroundSize(right, backgroundHeight, false, false, false, false);
            BackgroundPosition posRight = new BackgroundPosition(Side.RIGHT, 0, false, Side.TOP, top, false);

            BackgroundPosition posBottomLeft = new BackgroundPosition(Side.LEFT, 0, false, Side.BOTTOM, 0, false);

            BackgroundSize sizeBottom = new BackgroundSize(backgroundWidth, bottom, false, false, false, false);
            BackgroundPosition posBottom = new BackgroundPosition(Side.LEFT, left, false, Side.BOTTOM, 0, false);

            BackgroundPosition posBottomRight = new BackgroundPosition(Side.RIGHT, 0, false, Side.BOTTOM, 0, false);

            BackgroundSize sizeCenter = new BackgroundSize(backgroundWidth, backgroundHeight, false, false, false, false);
            BackgroundPosition posCenter = new BackgroundPosition(Side.LEFT, left, false, Side.TOP, top, false);

            return new Background(new BackgroundImage(this.imageTopLeft, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, posTopLeft, BackgroundSize.DEFAULT),
                    new BackgroundImage(this.imageTop, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, posTop, sizeTop),
                    new BackgroundImage(this.imageTopRight, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, posTopRight, BackgroundSize.DEFAULT),
                    new BackgroundImage(this.imageLeft, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, posLeft, sizeLeft),
                    new BackgroundImage(this.imageRight, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, posRight, sizeRight),
                    new BackgroundImage(this.imageBottomLeft, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, posBottomLeft, BackgroundSize.DEFAULT),
                    new BackgroundImage(this.imageBottom, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, posBottom, sizeBottom),
                    new BackgroundImage(this.imageBottomRight, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, posBottomRight, BackgroundSize.DEFAULT),
                    new BackgroundImage(this.imageCenter, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, posCenter, sizeCenter));
        }

        private static SnapshotParameters createParams(double minX, double minY, double width, double height) {
            SnapshotParameters params = new SnapshotParameters();
            params.setFill(Color.TRANSPARENT);
            params.setViewport(new Rectangle2D(minX, minY, width, height));
            return params;
        }
    }

    /**
     * Constructor without a content node (clients intends to injected content later)
     */
    public BoxShadow2() {
        this(null);
    }

    /**
     * Constructor with content to inject
     * @param content the content node around which the shadow will be drawn
     */
    public BoxShadow2(Node content) {
        Bindings.bindContent(getChildren(), childrenListBinding); //NOSONAR

//        getChildren().add(shadow); //NOSONAR

        this.shadow.translateXProperty().bind(this.offsetX);
        this.shadow.translateYProperty().bind(this.offsetY);

        this.shadow.visibleProperty().bind(this.shadowVisible);

        this.offsetX.addListener((obs, ol, ne) -> requestLayout());
        this.offsetY.addListener((obs, ol, ne) -> requestLayout());
        this.spread.addListener((obs, ol, ne) -> requestLayout());
        this.blur.addListener((obs, ol, ne) -> updateShadowTemplate());
        this.fill.addListener((obs, ol, ne) -> updateShadowTemplate());

        updateShadowTemplate();

        setContent(content);
    }

    @Override
    protected double computeMinWidth(double height) {
        Node node = this.content.get();
        if (node != null) {
            return getInsets().getLeft() + node.minWidth(height) + getInsets().getRight();
        }
        return super.computeMinWidth(height);
    }

    @Override
    protected double computeMinHeight(double width) {
        Node node = this.content.get();
        if (node != null) {
            return getInsets().getTop() + node.minHeight(width) + getInsets().getBottom();
        }
        return super.computeMinHeight(width);
    }

    @Override
    protected double computePrefWidth(double height) {
        Node node = this.content.get();
        if (node != null) {
            return getInsets().getLeft() + node.prefWidth(height) + getInsets().getRight();
        }
        return super.computePrefWidth(height);
    }

    @Override
    protected double computePrefHeight(double width) {
        Node node = this.content.get();
        if (node != null) {
            return getInsets().getTop() + node.prefHeight(width) + getInsets().getBottom();
        }
        return super.computePrefHeight(width);
    }

    @Override
    protected double computeMaxWidth(double height) {
        Node node = this.content.get();
        if (node != null) {
            return getInsets().getLeft() + node.maxWidth(height) + getInsets().getRight();
        }
        return super.computeMaxWidth(height);
    }

    @Override
    protected double computeMaxHeight(double width) {
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
        double shadowWidth = getWidth() + internal_getBlur() * ShadowTemplate.BLUR_MULTIPLIER;
        double shadowHeight = getHeight() + internal_getBlur() * ShadowTemplate.BLUR_MULTIPLIER;
        this.shadow.resizeRelocate(-internal_getBlur() - this.spread.get() / ShadowTemplate.BLUR_MULTIPLIER, -internal_getBlur() - this.spread.get() / ShadowTemplate.BLUR_MULTIPLIER, shadowWidth + this.spread.get(), shadowHeight + this.spread.get());
        this.shadow.setBackground(this.shadowTemplate.createBackground(shadowWidth + this.spread.get(), shadowHeight + this.spread.get()));
    }

    /**
     * 
     * @return the content node property
     */
    public final ObjectProperty<Node> contentProperty() {
        return this.content;
    }

    /**
     * 
     * @return the node around which the shadow will be drawn
     */
    public final Node getContent() {
        return this.contentProperty().get();
    }

    /**
     * Sets the node that should receive the shadow
     * @param content the node that should be decorated with the shadow effect
     */
    public final void setContent(final Node content) {
        this.content.set(content);
    }

    /**
     * 
     * @return a property holding the x offset of the shadow
     */
    public final DoubleProperty offsetXProperty() {
        return this.offsetX;
    }

    /**
     * 
     * @return the x offset of the shadow
     */
    public final double getOffsetX() {
        return this.offsetXProperty().get();
    }

    /**
     * 
     * @param offsetX the x offset to apply to the shadow
     */
    public final void setOffsetX(final double offsetX) {
        this.offsetXProperty().set(offsetX);
    }

    /**
     * 
     * @return a property holding the y offset of the shadow
     */
    public final DoubleProperty offsetYProperty() {
        return this.offsetY;
    }

    /**
     * 
     * @return the y offset of the shadow
     */
    public final double getOffsetY() {
        return this.offsetYProperty().get();
    }

    /**
     * 
     * @param offsetY the y offset to apply to the shadow
     */
    public final void setOffsetY(final double offsetY) {
        this.offsetYProperty().set(offsetY);
    }

    /**
     * 
     * @return a property holding the spread of the shadow
     */
    public final DoubleProperty spreadProperty() {
        return this.spread;
    }

    /**
     * 
     * @return the spread of the shadow
     */
    public final double getSpread() {
        return this.spreadProperty().get();
    }

    /**
     * 
     * @param spread the spread to apply to the shadow
     */
    public final void setSpread(final double spread) {
        this.spreadProperty().set(spread);
    }

    /**
     * 
     * @return a property holding the blur of the shadow
     */
    public final DoubleProperty blurProperty() {
        return this.blur;
    }

    /**
     * 
     * @return the blur of the shadow
     */
    public final double getBlur() {
        return this.blurProperty().get();
    }

    /**
     * 
     * @param blur the blur to apply to the shadow
     */
    public final void setBlur(final double blur) {
        this.blurProperty().set(blur);
    }

    /**
     * 
     * @return a property holding the fill of the shadow
     */
    public final ObjectProperty<Paint> fillProperty() {
        return this.fill;
    }

    /**
     * 
     * @return the fill of the shadow
     */
    public final Paint getFill() {
        return this.fillProperty().get();
    }

    /**
     * 
     * @param fill the fill to apply to the shadow
     */
    public final void setFill(final Paint fill) {
        this.fillProperty().set(fill);
    }

    /**
     * 
     * @return a property holding the visible status of the shadow
     */
    public final StyleableBooleanProperty shadowVisibleProperty() {
        return this.shadowVisible;
    }

    /**
     * 
     * @return whether the shadow is visible or not
     */
    public final boolean isShadowVisible() {
        return this.shadowVisibleProperty().get();
    }

    /**
     * 
     * @param shadowVisible the visibility status to apply to the shadow
     */
    public final void setShadowVisible(final boolean shadowVisible) {
        this.shadowVisibleProperty().set(shadowVisible);
    }

}
