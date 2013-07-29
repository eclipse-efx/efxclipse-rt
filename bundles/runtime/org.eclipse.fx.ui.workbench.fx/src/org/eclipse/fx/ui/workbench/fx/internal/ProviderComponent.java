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
import org.eclipse.fx.ui.services.resources.ImageProvider;
import org.eclipse.fx.ui.services.resources.GraphicsLoader.Util;

public class ProviderComponent {
	static class RankedEntry<E> implements Comparable<RankedEntry<E>> {
		public final int ranking;
		public final ImageProvider provider;
		
		public RankedEntry(int ranking, ImageProvider provider) {
			this.ranking = ranking;
			this.provider = provider;
		}
		
		@Override
		public int compareTo(RankedEntry<E> o) {
			int rv = Integer.compare(ranking, o.ranking);
			return rv == 0 ? 1 : rv;
		}
	}

	private Map<String, Set<RankedEntry<ImageProvider>>> imageProviderBySuffix = new HashMap<>();
	private Map<String, ImageProvider> imageProviderByName = new HashMap<>();
	private LoggerFactory loggerFactory;
	private Logger logger;
	
	public void addImageProvider(ImageProvider provider, Map<String, Object> parameters) {
		System.err.println("REGISTERING: " + provider);
		synchronized (imageProviderBySuffix) {
			for( String suffix : provider.getFileSuffix() ) {
				Set<RankedEntry<ImageProvider>> set = imageProviderBySuffix.get(suffix);
				if( set == null ) {
					set = new TreeSet<>();
					imageProviderBySuffix.put(suffix, set);
				}	
				
				Integer ranking = (Integer) parameters.get("service.ranking");
				if( ranking == null ) {
					ranking = Integer.valueOf(0);
				}
				set.add(new RankedEntry<ImageProvider>(ranking.intValue(), provider));
			}
		}
		
		synchronized (imageProviderByName) {
			ImageProvider p = imageProviderByName.put(provider.getName(), provider);
			if( p != null ) {
				getLogger().warning("Replaced existing provider '"+p+"' named '"+provider.getName()+"' through new provider '"+provider+"'");
			}
		}
	}
	
	public void removeImageProvider(ImageProvider provider) {
		synchronized (imageProviderBySuffix) {
			for( Set<RankedEntry<ImageProvider>> set : imageProviderBySuffix.values() ) {
				Iterator<RankedEntry<ImageProvider>> it = set.iterator();
				if( it.next().provider == provider ) {
					it.remove();
				}
			}
		}
		synchronized (imageProviderByName) {
			imageProviderByName.values().remove(provider);
		}
	}
	
	public void addGraphicNodeProvider(GraphicNodeProvider provider) {
		
	}
	
	public void removeGraphicNodeProvider(GraphicNodeProvider provider) {
		
	}
	
	public ImageProvider getProvider(URI uri) {
		if( uri.hasQuery() ) {
			String provider = Util.getQueryValue(uri, "providerName");
			if( provider != null ) {
				ImageProvider pv;
				synchronized (provider) {
					pv = imageProviderByName.get(provider);	
				}
				
				if( pv == null ) {
					getLogger().error("No provider named '"+provider+"' available. Falling back to suffix provider URI '"+uri.toString()+"'");
				} else {
					return pv;
				}
			}
		}
		String s = Util.suffix(uri);
		if( s == null ) {
			s = "*";
		}
		synchronized (imageProviderBySuffix) {
			System.err.println(s);
			Set<RankedEntry<ImageProvider>> set = imageProviderBySuffix.get(s);
			if( set != null && ! set.isEmpty() ) {
				return set.iterator().next().provider;
			} else {
				getLogger().warning("No image provider found for URI: '"+uri.toString()+"'");
				
				set = imageProviderBySuffix.get("*");
				if( ! set.isEmpty() ) {
					return set.iterator().next().provider;
				} else {
					getLogger().error("No default provider available");
				}
			}
		}
		
		return null;
	}
	
	private synchronized Logger getLogger() {
		if( logger == null && loggerFactory != null ) {
			logger = loggerFactory.createLogger(getClass().getName());
		}
		return logger;
	}
	
	public synchronized void setLoggerFactory(LoggerFactory factory) {
		this.loggerFactory = factory;
		if( logger != null ) {
			logger = null;
		}
	}
	
	public void unsetLoggerFactory(LoggerFactory factory) {
		if( this.loggerFactory == factory ) {
			this.loggerFactory = null;	
		}
	}
}