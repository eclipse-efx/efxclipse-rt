/*******************************************************************************
 * Copyright (c) 2015 BestSolution.at and others.
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
package org.eclipse.fx.core.text;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Supplier;

import org.eclipse.fx.core.Subscription;

/**
 * A very basic registry
 */
public class BasicTextRegistry implements TextRegistry {
	final Map<Consumer<String>, Supplier<String>> bindings = new HashMap<>();
	Set<Consumer<String>> trackedConsumers;

	@Override
	public Subscription register(Consumer<String> consumer, Supplier<String> supplier) {
		if (this.trackedConsumers != null) {
			this.trackedConsumers.add(consumer);
		}
		this.bindings.put(consumer, supplier);
		consumer.accept(supplier.get());
		return new Subscription() {

			@Override
			public void dispose() {
				BasicTextRegistry.this.bindings.remove(consumer);
			}
		};
	}

	@Override
	public void updateBindings() {
		Iterator<Entry<Consumer<String>, Supplier<String>>> it = this.bindings.entrySet().iterator();
		while (it.hasNext()) {
			Entry<Consumer<String>, Supplier<String>> next = it.next();
			next.getKey().accept(next.getValue().get());
		}
	}

	/**
	 * Run and collect all produced bindings
	 *
	 * @param r
	 *            the code to track creations
	 * @return the subscription
	 * @since 2.4.0
	 */
	public Subscription runAndCollect(Runnable r) {
		this.trackedConsumers = new HashSet<>();
		try {
			r.run();
			Set<Consumer<String>> trackedConsumers = this.trackedConsumers;
			return () -> {
				trackedConsumers.forEach(this.bindings::remove);
			};
		} finally {
			this.trackedConsumers = null;
		}
	}
}
