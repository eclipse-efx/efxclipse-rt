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
package org.eclipse.fx.ui.controls.image;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.fx.ui.controls.image.skin.FontIconViewSkin;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.css.CssMetaData;
import javafx.css.SimpleStyleableDoubleProperty;
import javafx.css.SimpleStyleableObjectProperty;
import javafx.css.StyleConverter;
import javafx.css.Styleable;
import javafx.css.StyleableObjectProperty;
import javafx.css.StyleableProperty;
import javafx.geometry.Insets;
import javafx.scene.control.Control;
import javafx.scene.control.Skin;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

/**
 * Font icon view
 */
public class FontIconView extends Control {

	/**
	 * Create a new font icon view
	 */
	public FontIconView() {
		getStyleClass().setAll("font-icon-view"); //$NON-NLS-1$
		setFocusTraversable(false);
		setMouseTransparent(true);
	}

	@Override
	protected Skin<?> createDefaultSkin() {
		return new FontIconViewSkin(this);
	}

	@Deprecated
	@Override
	protected/* do not make final */Boolean impl_cssGetFocusTraversableInitialValue() {
		return Boolean.FALSE;
	}

	private ObjectProperty<FontIcon> icon;

	/**
	 * @return the icon property
	 */
	public ObjectProperty<FontIcon> iconProperty() {
		if (this.icon == null) {
			this.icon = new SimpleStyleableObjectProperty<FontIcon>(StyleableProperties.ICON, FontIcon.UNKNOWN);
		}
		return this.icon;
	}

	/**
	 * Set a new font icon
	 *
	 * @param icon
	 *            the icon
	 */
	public void setIcon(FontIcon icon) {
		this.iconProperty().set(icon);
	}

	/**
	 * @return the current font icon
	 */
	public FontIcon getIcon() {
		return this.icon == null ? null : this.icon.get();
	}

	DoubleProperty iconFontSize;

	/**
	 * @return the font size to use
	 */
	public DoubleProperty iconFontSizeProperty() {
		if (this.iconFontSize == null) {
			return this.iconFontSize = new SimpleStyleableDoubleProperty(StyleableProperties.ICON_FONT_SIZE, Double.valueOf(Font.getDefault().getSize()));
		}
		return this.iconFontSize;
	}

	/**
	 * Set the font size
	 *
	 * @param iconFontSize
	 *            the font size
	 */
	public void setIconFontSize(double iconFontSize) {
		this.iconFontSizeProperty().set(iconFontSize);
	}

	/**
	 * Set the font size
	 * @return the font size
	 */
	public double getIconFontSize() {
		return this.iconFontSizeProperty().get();
	}

	/**
	 * @return padding for the icon
	 */
	public final ReadOnlyObjectProperty<Insets> iconPaddingProperty() {
		return iconPaddingPropertyImpl();
	}

	ObjectProperty<Insets> iconPaddingPropertyImpl() {
		if (this.iconPadding == null) {
			this.iconPadding = new StyleableObjectProperty<Insets>(Insets.EMPTY) {
				private Insets lastValidValue = Insets.EMPTY;

				@Override
				public void invalidated() {

					final Insets newValue = get();
					if (newValue == null) {
						set(this.lastValidValue);
						throw new NullPointerException("Null not allowed"); //$NON-NLS-1$
					}
					this.lastValidValue = newValue;
					requestLayout();
				}

				@Override
				public CssMetaData<FontIconView, Insets> getCssMetaData() {
					return StyleableProperties.ICON_PADDING;
				}

				@Override
				public Object getBean() {
					return FontIconView.this;
				}

				@Override
				public String getName() {
					return "iconPadding"; //$NON-NLS-1$
				}
			};
		}
		return this.iconPadding;
	}

	ObjectProperty<Insets> iconPadding;

	/**
	 * @return the current padding
	 */
	public final Insets getIconPadding() {
		return this.iconPadding == null ? Insets.EMPTY : this.iconPadding.get();
	}

	ObjectProperty<Paint> iconFill; // TODO for now change this

	/**
	 * @param value
	 *            set a new fill
	 */
	public final void setIconFill(Paint value) {
		iconFillProperty().set(value);
	}

	/**
	 * @return the current fill
	 */
	public final Paint getIconFill() {
		return this.iconFill == null ? Color.BLACK : this.iconFill.get();
	}

	/**
	 * @return the icon property
	 */
	public final ObjectProperty<Paint> iconFillProperty() {
		if (this.iconFill == null) {
			this.iconFill = new StyleableObjectProperty<Paint>(Color.BLACK) {

				@Override
				public CssMetaData<FontIconView, Paint> getCssMetaData() {
					return StyleableProperties.ICON_FILL;
				}

				@Override
				public Object getBean() {
					return FontIconView.this;
				}

				@Override
				public String getName() {
					return "iconFill"; //$NON-NLS-1$
				}
			};
		}
		return this.iconFill;
	}

	private static class StyleableProperties {

		static final CssMetaData<FontIconView, FontIcon> ICON = new CssMetaData<FontIconView, FontIcon>("-fx-icon", new FontIconStyleConverter()) { //$NON-NLS-1$
			@Override
			public boolean isSettable(FontIconView styleable) {
				return true;
			}

			@SuppressWarnings("unchecked")
			@Override
			public StyleableProperty<FontIcon> getStyleableProperty(FontIconView styleable) {
				return (StyleableProperty<FontIcon>) styleable.iconProperty();
			}
		};
		static final CssMetaData<FontIconView, Insets> ICON_PADDING = new CssMetaData<FontIconView, Insets>("-fx-icon-padding", StyleConverter.getInsetsConverter(), Insets.EMPTY) { //$NON-NLS-1$

			@Override
			public boolean isSettable(FontIconView n) {
				return n.iconPadding == null || !n.iconPadding.isBound();
			}

			@SuppressWarnings("unchecked")
			@Override
			public StyleableProperty<Insets> getStyleableProperty(FontIconView n) {
				return (StyleableProperty<Insets>) n.iconPaddingPropertyImpl();
			}
		};

		static final CssMetaData<FontIconView, Paint> ICON_FILL = new CssMetaData<FontIconView, Paint>("-fx-icon-fill", StyleConverter.getPaintConverter(), Color.BLACK) { //$NON-NLS-1$

			@Override
			public boolean isSettable(FontIconView n) {
				return n.iconFill == null || !n.iconFill.isBound();
			}

			@SuppressWarnings("unchecked")
			@Override
			public StyleableProperty<Paint> getStyleableProperty(FontIconView n) {
				return (StyleableProperty<Paint>) n.iconFillProperty();
			}
		};

		@SuppressWarnings("boxing")
		static final CssMetaData<FontIconView, Number> ICON_FONT_SIZE = new CssMetaData<FontIconView, Number>("-fx-icon-font-size", StyleConverter.getSizeConverter(), Font.getDefault().getSize()) { //$NON-NLS-1$

			@Override
			public boolean isSettable(FontIconView n) {
				return n.iconFontSize == null || !n.iconFontSize.isBound();
			}

			@SuppressWarnings("unchecked")
			@Override
			public StyleableProperty<Number> getStyleableProperty(FontIconView n) {
				return (StyleableProperty<Number>) n.iconFontSize;
			}
		};

		static final List<CssMetaData<? extends Styleable, ?>> STYLEABLES;

		static {
			final List<CssMetaData<? extends Styleable, ?>> styleables = new ArrayList<CssMetaData<? extends Styleable, ?>>(Control.getClassCssMetaData());
			Collections.addAll(styleables, ICON, ICON_FONT_SIZE, ICON_FILL, ICON_PADDING);
			STYLEABLES = Collections.unmodifiableList(styleables);
		}

	}

	/**
	 * @return The CssMetaData associated with this class, which may include the
	 *         CssMetaData of its super classes.
	 * @since JavaFX 8.0
	 */
	public static List<CssMetaData<? extends Styleable, ?>> getClassCssMetaData() {
		return StyleableProperties.STYLEABLES;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @since JavaFX 8.0
	 */
	@Override
	public List<CssMetaData<? extends Styleable, ?>> getControlCssMetaData() {
		return getClassCssMetaData();
	}

}
