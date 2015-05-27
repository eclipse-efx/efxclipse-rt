/*******************************************************************************
 * Copyright (c) 2015 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core.text;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Consumer;
import java.util.function.Supplier;

import org.eclipse.fx.core.Subscription;

/**
 * A very basic registry
 */
public class BasicTextRegistry implements TextRegistry {
	final Map<Consumer<String>, Supplier<String>> bindings = new HashMap<>();
	
	@Override
	public Subscription register(Consumer<String> consumer, Supplier<String> supplier) {
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

}
