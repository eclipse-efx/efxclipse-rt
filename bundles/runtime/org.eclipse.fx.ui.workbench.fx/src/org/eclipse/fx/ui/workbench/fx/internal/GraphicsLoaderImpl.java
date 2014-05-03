/*******************************************************************************
 * Copyright (c) 2013 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.workbench.fx.internal;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.inject.Inject;

import org.apache.commons.lang.text.StrSubstitutor;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.emf.common.util.URI;
import org.eclipse.fx.core.log.Log;
import org.eclipse.fx.core.log.Logger;
import org.eclipse.fx.ui.services.resources.GraphicNodeProvider;
import org.eclipse.fx.ui.services.resources.GraphicsLoader;
import org.eclipse.fx.ui.services.resources.ImageProvider;
import org.eclipse.fx.ui.services.theme.ThemeManager;

public class GraphicsLoaderImpl implements GraphicsLoader {

	private WeakHashMap<URI, WeakReference<Image>> imageCache = new WeakHashMap<>();

	@Inject
	private ProviderComponent providerComponent;

	@Inject
	@Optional
	private ThemeManager themeManager;

	@Inject
	@Log
	private Logger logger;

	public void setProviderComponent(ProviderComponent providerComponent) {
		this.providerComponent = providerComponent;
	}

	public void unsetProviderComponent(ProviderComponent providerComponent) {
		if (this.providerComponent == providerComponent) {
			this.providerComponent = null;
		}
	}

	@Override
	public Image getImage(URI uri) {
		Map<String, String> map = new HashMap<>();
		if (themeManager != null && themeManager.getCurrentTheme() != null) {
			map.put("themeId", themeManager.getCurrentTheme().getId());
		}

		uri = replaceDynamicValues(uri, map);

		WeakReference<Image> r = imageCache.get(uri);
		Image img = null;
		if (r != null) {
			img = r.get();
		}

		if (img == null) {
			ImageProvider pv = providerComponent.getImageProvider(uri);
			if (pv != null) {
				try {
					img = pv.getImage(uri);

					if (img != null) {
						imageCache.put(uri, new WeakReference<Image>(img));
					}
				} catch (IOException e) {
					logger.error("Unable to load image from '" + uri + "'", e);
				}
			}
		}

		return img;
	}

	@Override
	public Node getGraphicsNode(URI uri) {
		Map<String, String> map = new HashMap<>();
		if (themeManager != null && themeManager.getCurrentTheme() != null) {
			map.put("themeId", themeManager.getCurrentTheme().getId());
		}

		uri = replaceDynamicValues(uri, map);
		GraphicNodeProvider graphicNodeProvider = providerComponent.getGraphicNodeProvider(uri);

		if (graphicNodeProvider == null) {
			Image img = getImage(uri);
			if (img != null) {
				return new ImageView(img);
			}
		} else {
			try {
				return graphicNodeProvider.getGraphicNode(uri);
			} catch (IOException e) {
				logger.error("Unable to load graphic node from '" + uri + "'", e);
			}
		}

		return null;
	}

	private URI replaceDynamicValues(URI uri, Map<String, String> dynamicMap) {
		String s = uri.toString();
		s = StrSubstitutor.replace(s, dynamicMap);
		return URI.createURI(s);
	}
}
