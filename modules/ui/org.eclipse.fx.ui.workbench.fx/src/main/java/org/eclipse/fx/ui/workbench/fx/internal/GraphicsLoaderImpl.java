/*******************************************************************************
 * Copyright (c) 2013 BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
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
import org.eclipse.fx.core.URI;
import org.eclipse.fx.core.log.Log;
import org.eclipse.fx.core.log.Logger;
import org.eclipse.fx.ui.services.resources.GraphicNodeProvider;
import org.eclipse.fx.ui.services.resources.GraphicsLoader;
import org.eclipse.fx.ui.services.resources.ImageProvider;
import org.eclipse.fx.ui.services.theme.Theme;
import org.eclipse.fx.ui.services.theme.ThemeManager;
import org.eclipse.jdt.annotation.NonNull;

/**
 * Graphics loader implementation
 */
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

	/**
	 * Set a provider
	 * 
	 * @param providerComponent
	 *            the provider
	 */
	public void setProviderComponent(ProviderComponent providerComponent) {
		this.providerComponent = providerComponent;
	}

	/**
	 * Unset the provider
	 * 
	 * @param providerComponent
	 *            the provider
	 */
	public void unsetProviderComponent(ProviderComponent providerComponent) {
		if (this.providerComponent == providerComponent) {
			this.providerComponent = null;
		}
	}

	@Override
	public Image getImage(URI _uri) {
		Map<@NonNull String, @NonNull String> map = new HashMap<>();
		if (this.themeManager != null && this.themeManager.getCurrentTheme() != null) {
			Theme currentTheme = this.themeManager.getCurrentTheme();
			if (currentTheme != null) {
				map.put("themeId", currentTheme.getId()); //$NON-NLS-1$
			}
		}

		URI uri = replaceDynamicValues(_uri, map);

		WeakReference<Image> r = this.imageCache.get(uri);
		Image img = null;
		if (r != null) {
			img = r.get();
		}

		if (img == null) {
			ImageProvider pv = this.providerComponent.getImageProvider(uri);
			if (pv != null) {
				try {
					img = pv.getImage(uri);
					this.imageCache.put(uri, new WeakReference<Image>(img));
				} catch (IOException e) {
					this.logger.error("Unable to load image from '" + uri + "'", e); //$NON-NLS-1$ //$NON-NLS-2$
				}
			}
		}

		return img;
	}

	@Override
	public Node getGraphicsNode(URI _uri) {
		Map<@NonNull String, @NonNull String> map = new HashMap<>();
		if (this.themeManager != null && this.themeManager.getCurrentTheme() != null) {
			Theme currentTheme = this.themeManager.getCurrentTheme();
			if (currentTheme != null) {
				map.put("themeId", currentTheme.getId()); //$NON-NLS-1$
			}
		}

		URI uri = replaceDynamicValues(_uri, map);
		GraphicNodeProvider graphicNodeProvider = this.providerComponent.getGraphicNodeProvider(uri);

		if (graphicNodeProvider == null) {
			Image img = getImage(uri);
			if (img != null) {
				return new ImageView(img);
			}
		} else {
			try {
				return graphicNodeProvider.getGraphicNode(uri);
			} catch (IOException e) {
				this.logger.error("Unable to load graphic node from '" + uri + "'", e); //$NON-NLS-1$ //$NON-NLS-2$
			}
		}

		return null;
	}

	@SuppressWarnings("null")
	@NonNull
	private static URI replaceDynamicValues(@NonNull URI uri, @NonNull Map<@NonNull String, @NonNull String> dynamicMap) {
		String s = uri.toString();
		s = StrSubstitutor.replace(s, dynamicMap);
		return URI.create(s);
	}
}
