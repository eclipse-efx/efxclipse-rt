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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import javafx.scene.image.Image;

/**
 * A cache for images
 */
public class ImageCache {
	private static final ImageCache INSTANCE = new ImageCache();

	Map<String, CachedImage> cache = new HashMap<>();
	List<CachedImage> lazyCleanup = new ArrayList<>();

	static long MIN_LZAY_TIME = 10_000;

	/**
	 * A cached image
	 */
	public static class CachedImage extends Image {
		private final ImageCache cache;
		final String url;
		int count;
		long releaseTime;

		CachedImage(ImageCache cache, String url) {
			super(url);
			this.url = url;
			this.cache = cache;
		}

		/**
		 * release the image immediately
		 */
		public void release() {
			synchronized (this.cache) {
				this.count -= 1;
				if (this.count <= 0) {
					this.cache.cache.remove(this.url);
					this.cache.lazyCleanup.remove(this);
				}
			}
		}

		/**
		 * Schedule the image for release
		 */
		public void releaseLazy() {
			synchronized (this.cache) {
				this.count -= 1;
				if (this.count <= 0) {
					this.releaseTime = System.currentTimeMillis();
					this.cache.lazyCleanup.add(this);
				}
			}
		}
	}

	/**
	 * Create a new cache instance
	 */
	public ImageCache() {
		TimerTask t = new TimerTask() {

			@Override
			public void run() {
				long time = System.currentTimeMillis();
				synchronized (ImageCache.this) {
					if (!ImageCache.this.lazyCleanup.isEmpty()) {
						ImageCache.this.lazyCleanup.removeIf(e -> e.count > 0);

						ImageCache.this.lazyCleanup.stream().filter(e -> e.releaseTime + MIN_LZAY_TIME < time).map(e -> e.url).forEach(e -> {
							ImageCache.this.cache.remove(e);
						});
						ImageCache.this.lazyCleanup.removeIf(e -> e.releaseTime + MIN_LZAY_TIME < time);
					}
				}
			}
		};
		Timer tt = new Timer(true);
		tt.scheduleAtFixedRate(t, 0, 5000);
	}

	/**
	 * @return get a single instance
	 */
	public static ImageCache getInstance() {
		return INSTANCE;
	}

	/**
	 * Get a cached image instance
	 *
	 * @param url
	 *            the url
	 * @return the image
	 */
	public synchronized CachedImage getImage(String url) {
		CachedImage img = this.cache.get(url);

		if (img == null) {
			img = new CachedImage(this, url);
			this.cache.put(url, img);
		}

		img.count++;
		return img;
	}
}
