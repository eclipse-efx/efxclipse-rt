/*******************************************************************************
 * Copyright (c) 2017 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
		for (int i = this.objects.size() - 1; i >= 0; i--) {
			try {
				this.dispose.accept(this.objects.get(i));
			} catch (Throwable t) {
				// TODO
			}
		}
	}
}
