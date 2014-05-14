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

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.scene.image.Image;

import javax.annotation.PreDestroy;
import javax.inject.Inject;

import org.eclipse.fx.osgi.util.LoggerCreator;
import org.eclipse.fx.ui.di.ResourceProviderService;
import org.eclipse.fx.ui.di.ResourceService;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;

/**
 * Resource service implementation
 */
public class ResourceServiceImpl implements ResourceService {
	static class PooledResource<@Nullable T> implements IPooledResource<T> {
		int count;
		@Nullable
		private T resource;
		@NonNull
		private String id;
		private ResourceServiceImpl resourceService;

		PooledResource(@NonNull ResourceServiceImpl resourceService, @NonNull String id,
				@Nullable T resource) {
			this.id = id;
			this.count = 1;
			this.resourceService = resourceService;
			this.resource = resource;
		}

		@Override
		public String getId() {
			return this.id;
		}

		@Override
		public T getResource() {
			return this.resource;
		}

		@Override
		public void dispose() {
			this.count--;
			if (this.count == 0) {
				this.resourceService.removePooledResource(this);
				this.resource = null;
				this.resourceService = null;
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

		@Override
		public Image getImage(String imageKey) throws IOException {
			IPooledResource<Image> image = null;

			for (IPooledResource<Image> img : this.pooledImages) {
				if (img.getId().equals(imageKey)) {
					image = img;
				}
			}
			if (image == null) {
				image = this.resourceService.getImage(imageKey);
				this.pooledImages.add(image);
			}

			Image r = image.getResource();
			if( r == null ) {
				throw new IOException("Image could not be loaded"); //$NON-NLS-1$
			}
			return r;
		}

		@Override
		public Image getImageUnchecked(String imageKey) {
			try {
				return getImage(imageKey);
			} catch (Throwable e) {
				// don't bother
			}
			return null;
		}

		@Override
		@PreDestroy
		public void dispose() {
			for (IPooledResource<Image> img : this.pooledImages) {
				img.dispose();
			}
			this.pooledImages = null;
		}
	}

	private Map<String, PooledResource<Image>> imagePool = new HashMap<String, PooledResource<Image>>();

	private BundleContext context;

	/**
	 * Create an instance
	 */
	public ResourceServiceImpl() {
		Bundle b = FrameworkUtil.getBundle(ResourceServiceImpl.class);
		this.context = b.getBundleContext();
	}

	@Override
	public IPooledResource<Image> getImage(@NonNull String key) throws IOException {
		return loadResource(key);
	}

	@SuppressWarnings("unchecked")
	@NonNull
	private <R> IPooledResource<@Nullable R> loadResource(@NonNull String key) throws IOException {
		PooledResource<R> resource = null;

		resource = (PooledResource<R>) this.imagePool.get(key);

		if (resource != null && resource.getResource() != null) {
			resource.count++;
		} else {
			resource = new PooledResource<R>(this, key, (R) lookupResource(key));
			this.imagePool.put(key, (PooledResource<Image>) resource);
		}

		return resource;
	}

	@SuppressWarnings("unchecked")
	private <R> R lookupResource(@NonNull String key) throws IOException {
		ResourceProviderService provider = lookupOSGI(key);
		if (provider != null) {
			return (R) provider.getImage(key);
		}

		throw new IOException("No provider known for '" + key + "'."); //$NON-NLS-1$ //$NON-NLS-2$
	}

	private ResourceProviderService lookupOSGI(String key) {
		try {
			Collection<ServiceReference<ResourceProviderService>> refs = this.context
					.getServiceReferences(ResourceProviderService.class, "(" //$NON-NLS-1$
							+ key + "=*)"); //$NON-NLS-1$
			if (!refs.isEmpty()) {
				ServiceReference<ResourceProviderService> ref = refs.iterator()
						.next();
				return this.context.getService(ref);
			}
		} catch (InvalidSyntaxException e) {
			LoggerCreator.createLogger(getClass()).error("Unable to query registry", e); //$NON-NLS-1$
		}
		return null;
	}

	@Override
	public IDiposeableResourcePool getResourcePool() {
		return new ResourcePool(this);
	}

	/**
	 * Remove a resource from the pool
	 * 
	 * @param resource
	 *            the resource to remove
	 */
	public void removePooledResource(PooledResource<?> resource) {
		this.imagePool.remove(resource.getId());
	}

}
