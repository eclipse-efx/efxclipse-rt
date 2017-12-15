/*******************************************************************************
 * Copyright (c) 2016 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.controls.image;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.fx.core.ServiceUtils;
import org.eclipse.fx.ui.controls.image.ImageCache.CachedImage;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.css.CssMetaData;
import javafx.css.ParsedValue;
import javafx.css.SimpleStyleableObjectProperty;
import javafx.css.StyleConverter;
import javafx.css.Styleable;
import javafx.css.StyleableProperty;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;

/**
 * A node who can display graphics and delegates to {@link GraphicNodeProvider}
 * to create the graphic
 *
 * @since 3.0
 */
public class GraphicNode extends StackPane {
	static class CustomProtocolConverter extends StyleConverter<Object, String> {
		@SuppressWarnings({ "unchecked", "rawtypes" })
		@Override
		public String convert(ParsedValue<Object, String> value, Font font) {
			if (value.getValue() instanceof String) {
				String valueString = value.getValue().toString();
				return valueString;
			} else {
				return StyleConverter.getUrlConverter().convert((ParsedValue<ParsedValue[], String>) (ParsedValue<?, String>) value, font);
			}
		}
	}

	private static CustomProtocolConverter CONVERTER = new CustomProtocolConverter();

	static final CssMetaData<GraphicNode, String> GRAPHIC = new CssMetaData<GraphicNode, String>("-fx-graphic", CONVERTER) { //$NON-NLS-1$

		@Override
		public boolean isSettable(GraphicNode n) {
			return n.graphic == null || !n.graphic.isBound();
		}

		@SuppressWarnings("unchecked")
		@Override
		public StyleableProperty<String> getStyleableProperty(GraphicNode n) {
			return (StyleableProperty<String>) n.graphicProperty();
		}
	};

	ObjectProperty<String> graphic;
	ObjectProperty<Node> graphicNode = new SimpleObjectProperty<>(this, "graphicNode"); //$NON-NLS-1$

	private static List<GraphicNodeProvider> NODE_PROVIDER_LIST = new ArrayList<>();

	static {
		NODE_PROVIDER_LIST = ServiceUtils.getServiceList(GraphicNode.class, GraphicNodeProvider.class);
	}

	/**
	 * Create a new graphic node
	 */
	public GraphicNode() {
		getStyleClass().add("graphic-node"); //$NON-NLS-1$

		if (this.graphicNode.get() != null) {
			getChildren().setAll(this.graphicNode.get());
		}
		this.graphicNode.addListener((o, ol, ne) -> {
			if (ne == null) {
				getChildren().clear();
			} else {
				getChildren().setAll(ne);
			}
		});
	}

	/**
	 * @return the graphic url property
	 */
	public final ObjectProperty<String> graphicProperty() {
		if (this.graphic == null) {
			this.graphic = new SimpleStyleableObjectProperty<String>(GRAPHIC, this, "graphic", null); //$NON-NLS-1$
			this.graphic.addListener((o, ol, ne) -> {
				if (ne != null) {
					CachedImage cachedImage = null;
					if (this.graphicNode.get() instanceof ImageView) {
						Image img = ((ImageView) this.graphicNode.get()).getImage();
						if (img instanceof CachedImage) {
							cachedImage = (CachedImage) img;
						}
					}
					this.graphicNode.set(NODE_PROVIDER_LIST.stream().filter(np -> np.handles(ne)).findFirst().map(np -> np.getGraphicNode(ne)).orElseGet(() -> new ImageView(ImageCache.getInstance().getImage(ne))));

					if (cachedImage != null) {
						cachedImage.releaseLazy();
					}
				} else {
					this.graphicNode.set(null);
				}
			});
		}
		return this.graphic;
	}

	/**
	 * @return the graphic url
	 */
	public final String getGraphic() {
		return this.graphicProperty().get();
	}

	/**
	 * Set the graphic url
	 *
	 * @param graphic
	 *            the graphic url
	 */
	public final void setGraphic(final String graphic) {
		this.graphicProperty().set(graphic);
	}

	static final List<CssMetaData<? extends Styleable, ?>> STYLEABLES;
	static {
		final List<CssMetaData<? extends Styleable, ?>> styleables = new ArrayList<CssMetaData<? extends Styleable, ?>>(Region.getClassCssMetaData());
		Collections.addAll(styleables, GRAPHIC);
		STYLEABLES = Collections.unmodifiableList(styleables);
	}

	public static List<CssMetaData<? extends Styleable, ?>> getClassCssMetaData() {
		return STYLEABLES;
	}

	@Override
	public List<CssMetaData<? extends Styleable, ?>> getCssMetaData() {
		return getClassCssMetaData();
	}

}