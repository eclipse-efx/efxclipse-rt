/*******************************************************************************
 * Copyright (c) 2017 BestSolution.at and others.
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
package org.eclipse.fx.core;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import javax.annotation.PreDestroy;

/**
 * Base class to implementation disposeable objects
 *
 * @param <T>
 *            the type to collect
 * @since 3.0
 */
public abstract class DisposeableCollector<T> {
	private Consumer<T> dispose;
	private List<T> objects = new ArrayList<>();

	/**
	 * Create a new instance
	 *
	 * @param dispose
	 *            method to call when disposing
	 */
	public DisposeableCollector(Consumer<T> dispose) {
		this.dispose = dispose;
	}

	/**
	 * Register the object
	 *
	 * @param o
	 *            the object
	 */
	protected void register(T o) {
		this.objects.add(o);
	}

	/**
	 * Unregister the object
	 *
	 * @param o
	 *            the object
	 */
	protected void unregister(T o) {
		this.objects.remove(o);
	}

	/**
	 * Dispose all collected objects
	 */
	@PreDestroy
	public void dispose() {
		StreamUtils.reverse(this.objects).forEach(o -> {
			try {
				this.dispose.accept(o);
			} catch (Throwable t) {
				// TODO
			}
		});
		this.objects.clear();
	}
}
