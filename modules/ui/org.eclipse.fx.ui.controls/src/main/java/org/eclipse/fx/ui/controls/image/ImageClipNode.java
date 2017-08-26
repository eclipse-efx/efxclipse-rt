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

import java.util.List;

import org.eclipse.fx.ui.controls.image.ImageCache.CachedImage;

import javafx.beans.value.ObservableValue;
import javafx.css.CssMetaData;
import javafx.css.Styleable;
import javafx.css.StyleableProperty;
import javafx.css.StyleablePropertyFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

/**
 * Node who is clipped by the provided image
 *
 * @since 3.0
 */
public class ImageClipNode extends StackPane {
	private static StyleablePropertyFactory<ImageClipNode> FACTORY = new StyleablePropertyFactory<>(StackPane.getClassCssMetaData());

	private final StyleableProperty<String> clipIconUrl = FACTORY.createStyleableUrlProperty(this, "clipIconUrl", "-clip-icon-url", s -> s.clipIconUrl); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * Create a new clip node
	 */
	public ImageClipNode() {
		getStyleClass().add("image-clip-node"); //$NON-NLS-1$
		ImageView view = new ImageView();
		clipIconUrlProperty().addListener((o, ol, ne) -> {
			CachedImage cachedImage = null;
			Image img = view.getImage();
			if (img instanceof CachedImage) {
				cachedImage = (CachedImage) img;
			}

			if (ne != null) {
//				ImageView view_ = new ImageView();
				CachedImage image = ImageCache.getInstance().getImage(ne);
				view.setImage(image);
				setPrefSize(image.getWidth(), image.getHeight());
				setMinSize(image.getWidth(), image.getHeight());
				setMaxSize(image.getWidth(), image.getHeight());
//				setClip(view_);
			}

			if (cachedImage != null) {
				cachedImage.releaseLazy();
			}
		});
		setClip(view);
	}

	/**
	 * @return the url for clip icon property
	 */
	@SuppressWarnings("unchecked")
	public ObservableValue<String> clipIconUrlProperty() {
		return (ObservableValue<String>) this.clipIconUrl;
	}

	/**
	 * @return the clip icon url
	 */
	public final String getClipIconUrl() {
		return this.clipIconUrl.getValue();
	}

	/**
	 * Set the clip icon url
	 *
	 * @param clipIconUrl
	 *            the url
	 */
	public final void setClipIconUrl(String clipIconUrl) {
		this.clipIconUrl.setValue(clipIconUrl);
	}

	@Override
	public List<CssMetaData<? extends Styleable, ?>> getCssMetaData() {
		return FACTORY.getCssMetaData();
	}
}
