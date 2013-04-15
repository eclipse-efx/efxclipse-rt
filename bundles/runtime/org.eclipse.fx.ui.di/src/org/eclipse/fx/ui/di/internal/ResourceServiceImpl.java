/*******************************************************************************
 * Copyright (c) 2012 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.di.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.scene.image.Image;

import javax.annotation.PreDestroy;
import javax.inject.Inject;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.fx.ui.di.ResourceProviderService;
import org.eclipse.fx.ui.di.ResourceService;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;


public class ResourceServiceImpl implements ResourceService {
	static class PooledResource<T> implements IPooledResource<T> {
		private int count;
		private T resource;
		private String id;
		private ResourceServiceImpl resourceService;

		PooledResource(ResourceServiceImpl resourceService, String id, T resource) {
			this.id = id;
			this.count = 1;
			this.resourceService = resourceService;
			this.resource = resource;
		}

		public String getId() {
			return id;
		}

		public T getResource() {
			return resource;
		}

		public void dispose() {
			this.count--;
			if (this.count == 0) {
				resourceService.removePooledResource(this);
				resource = null;
				id = null;
				resourceService = null;
			}
		}
	}

	static class ResourcePool implements IDiposeableResourcePool {
		private final ResourceServiceImpl resourceService;
		private List<IPooledResource<Image>> pooledImages = new ArrayList<IPooledResource<Image>>();

		@Inject
		public ResourcePool(ResourceService resourceService) {
			this.resourceService = (ResourceServiceImpl) resourceService;
		}

		public Image getImage(String imageKey) throws CoreException {
			IPooledResource<Image> image = null;

			for (IPooledResource<Image> img : pooledImages) {
				if (img.getId().equals(imageKey)) {
					image = img;
				}
			}
			if (image == null) {
				image = resourceService.getImage(imageKey);
				pooledImages.add(image);
			}

			return image.getResource();
		}

		public Image getImageUnchecked(String imageKey) {
			try {
				return getImage(imageKey);
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}

		@PreDestroy
		public void dispose() {
			for (IPooledResource<Image> img : pooledImages) {
				img.dispose();
			}
			pooledImages = null;
		}
	}
	
	private Map<String, PooledResource<Image>> imagePool = new HashMap<String, PooledResource<Image>>();

	private BundleContext context;

	public ResourceServiceImpl() {
		Bundle b = FrameworkUtil.getBundle(ResourceServiceImpl.class);
		context = b.getBundleContext();
	}
	
	public IPooledResource<Image> getImage(String key) {
		return loadResource(key);
	}

	@SuppressWarnings("unchecked")
	private <R> PooledResource<R> loadResource(String key) {
		PooledResource<R> resource = null;

		resource = (PooledResource<R>) imagePool.get(key);
		
		if (resource != null && resource.getResource() != null) {
			resource.count++;
		} else {
			resource = new PooledResource<R>(this, key,(R) lookupResource(key));

			imagePool.put(key, (PooledResource<Image>) resource);
		}

		return resource;
	}
	
	@SuppressWarnings("unchecked")
	private <R> R lookupResource(String key) {
		ResourceProviderService provider = lookupOSGI(key);
		if (provider != null) {
			return (R) provider.getImage(key);
		}
		
		throw new IllegalArgumentException("No provider known for '" + key
				+ "'.");
	}

	private ResourceProviderService lookupOSGI(String key) {
		try {
			Collection<ServiceReference<ResourceProviderService>> refs = context
					.getServiceReferences(ResourceProviderService.class, "("
							+ key + "=*)");
			if (!refs.isEmpty()) {
				ServiceReference<ResourceProviderService> ref = refs
						.iterator().next();
				return context.getService(ref);
			}
		} catch (InvalidSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public IDiposeableResourcePool getResourcePool() {
		return new ResourcePool(this);
	}
	
	public void removePooledResource(PooledResource<?> resource) {
		imagePool.remove(resource.getId());
	}
	
}
