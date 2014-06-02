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

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.eclipse.emf.common.util.URI;
import org.eclipse.fx.core.log.Logger;
import org.eclipse.fx.core.log.LoggerFactory;
import org.eclipse.fx.ui.services.resources.GraphicNodeProvider;
import org.eclipse.fx.ui.services.resources.GraphicsLoader.Util;
import org.eclipse.fx.ui.services.resources.ImageProvider;
import org.eclipse.jdt.annotation.Nullable;

/**
 * Collect providers
 */
public class ProviderComponent {
	static class RankedEntry<E> implements Comparable<RankedEntry<E>> {
		public final int ranking;
		public final E provider;

		public RankedEntry(int ranking, E provider) {
			this.ranking = ranking;
			this.provider = provider;
		}

		@Override
		public int compareTo(RankedEntry<E> o) {
			int rv = Integer.compare(this.ranking, o.ranking);
			return rv == 0 ? 1 : rv;
		}
	}

	private Map<String, Set<RankedEntry<ImageProvider>>> imageProviderBySuffix = new HashMap<>();
	private Map<String, ImageProvider> imageProviderByName = new HashMap<>();

	private Map<String, Set<RankedEntry<GraphicNodeProvider>>> graphicProviderBySuffix = new HashMap<>();
	private Map<String, GraphicNodeProvider> graphicProviderByName = new HashMap<>();

	private LoggerFactory loggerFactory;
	private Logger logger;

	/**
	 * Register a new image provider
	 * 
	 * @param provider
	 *            the provider
	 * @param parameters
	 *            the service parameters
	 */
	public void addImageProvider(ImageProvider provider, Map<String, Object> parameters) {
		synchronized (this.imageProviderBySuffix) {
			for (String suffix : provider.getFileSuffix()) {
				Set<RankedEntry<ImageProvider>> set = this.imageProviderBySuffix.get(suffix);
				if (set == null) {
					set = new TreeSet<>();
					this.imageProviderBySuffix.put(suffix, set);
				}

				Integer ranking = (Integer) parameters.get("service.ranking"); //$NON-NLS-1$
				if (ranking == null) {
					ranking = Integer.valueOf(0);
				}
				set.add(new RankedEntry<ImageProvider>(ranking.intValue(), provider));
			}
		}

		synchronized (this.imageProviderByName) {
			ImageProvider p = this.imageProviderByName.put(provider.getName(), provider);
			if (p != null) {
				getLogger().warning("Replaced existing provider '" + p + "' named '" + provider.getName() + "' through new provider '" + provider + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
			}
		}
	}

	/**
	 * Remove a image provider
	 * 
	 * @param provider
	 *            the provider
	 */
	public void removeImageProvider(ImageProvider provider) {
		synchronized (this.imageProviderBySuffix) {
			for (Set<RankedEntry<ImageProvider>> set : this.imageProviderBySuffix.values()) {
				Iterator<RankedEntry<ImageProvider>> it = set.iterator();
				if (it.next().provider == provider) {
					it.remove();
				}
			}
		}
		synchronized (this.imageProviderByName) {
			this.imageProviderByName.values().remove(provider);
		}
	}

	/**
	 * Add a graphic provider
	 * 
	 * @param provider
	 *            the provider
	 * @param parameters
	 *            the service parameters
	 */
	public void addGraphicNodeProvider(GraphicNodeProvider provider, Map<String, Object> parameters) {
		synchronized (this.graphicProviderBySuffix) {
			for (String suffix : provider.getFileSuffix()) {
				Set<RankedEntry<GraphicNodeProvider>> set = this.graphicProviderBySuffix.get(suffix);
				if (set == null) {
					set = new TreeSet<>();
					this.graphicProviderBySuffix.put(suffix, set);
				}

				Integer ranking = (Integer) parameters.get("service.ranking"); //$NON-NLS-1$
				if (ranking == null) {
					ranking = Integer.valueOf(0);
				}
				set.add(new RankedEntry<GraphicNodeProvider>(ranking.intValue(), provider));
			}
		}

		synchronized (this.graphicProviderByName) {
			GraphicNodeProvider p = this.graphicProviderByName.put(provider.getName(), provider);
			if (p != null) {
				getLogger().warning("Replaced existing provider '" + p + "' named '" + provider.getName() + "' through new provider '" + provider + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
			}
		}
	}

	/**
	 * Remove a graphic node provider
	 * 
	 * @param provider
	 *            the provider
	 */
	public void removeGraphicNodeProvider(GraphicNodeProvider provider) {
		synchronized (this.graphicProviderBySuffix) {
			for (Set<RankedEntry<GraphicNodeProvider>> set : this.graphicProviderBySuffix.values()) {
				Iterator<RankedEntry<GraphicNodeProvider>> it = set.iterator();
				if (it.next().provider == provider) {
					it.remove();
				}
			}
		}
		synchronized (this.graphicProviderByName) {
			this.graphicProviderByName.values().remove(provider);
		}
	}

	/**
	 * Resolve the graphic node for an uri
	 * 
	 * @param uri
	 *            the uri
	 * @return the node
	 */
	@Nullable
	public GraphicNodeProvider getGraphicNodeProvider(URI uri) {
		if (uri.hasQuery()) {
			String provider = Util.getQueryValue(uri, "providerName"); //$NON-NLS-1$
			if (provider != null) {
				GraphicNodeProvider pv;
				synchronized (this.graphicProviderByName) {
					pv = this.graphicProviderByName.get(provider);
				}

				if (pv != null) {
					return pv;
				}
			}
		}

		String s = Util.suffix(uri);
		if (s != null) {
			synchronized (this.graphicProviderBySuffix) {
				Set<RankedEntry<GraphicNodeProvider>> set = this.graphicProviderBySuffix.get(s);
				if (set != null && !set.isEmpty()) {
					return set.iterator().next().provider;
				}
			}
		}
		return null;
	}

	/**
	 * Get image provider for an uri
	 * 
	 * @param uri
	 *            the uri
	 * @return the image provider
	 */
	@Nullable
	public ImageProvider getImageProvider(URI uri) {
		if (uri.hasQuery()) {
			String provider = Util.getQueryValue(uri, "providerName"); //$NON-NLS-1$
			if (provider != null) {
				ImageProvider pv;
				synchronized (this.imageProviderByName) {
					pv = this.imageProviderByName.get(provider);
				}

				if (pv == null) {
					getLogger().error("No provider named '" + provider + "' available. Falling back to suffix provider URI '" + uri.toString() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				} else {
					return pv;
				}
			}
		}
		String s = Util.suffix(uri);
		if (s == null) {
			s = "*"; //$NON-NLS-1$
		}
		synchronized (this.imageProviderBySuffix) {
			Set<RankedEntry<ImageProvider>> set = this.imageProviderBySuffix.get(s);
			if (set != null && !set.isEmpty()) {
				return set.iterator().next().provider;
			} else {
				getLogger().warning("No image provider found for URI: '" + uri.toString() + "'"); //$NON-NLS-1$ //$NON-NLS-2$

				set = this.imageProviderBySuffix.get("*"); //$NON-NLS-1$
				if (!set.isEmpty()) {
					return set.iterator().next().provider;
				} else {
					getLogger().error("No default provider available"); //$NON-NLS-1$
				}
			}
		}

		return null;
	}

	@SuppressWarnings("null")
	private synchronized Logger getLogger() {
		if (this.logger == null && this.loggerFactory != null) {
			this.logger = this.loggerFactory.createLogger(getClass().getName());
		}
		return this.logger;
	}

	/**
	 * Set a logger factory
	 * 
	 * @param factory
	 *            the factory
	 */
	public synchronized void setLoggerFactory(LoggerFactory factory) {
		this.loggerFactory = factory;
		if (this.logger != null) {
			this.logger = null;
		}
	}

	/**
	 * Remove a logger factory
	 * 
	 * @param factory
	 *            the factory
	 */
	public void unsetLoggerFactory(LoggerFactory factory) {
		if (this.loggerFactory == factory) {
			this.loggerFactory = null;
		}
	}
}