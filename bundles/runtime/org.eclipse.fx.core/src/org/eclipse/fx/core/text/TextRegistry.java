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

import java.util.function.Consumer;
import java.util.function.Supplier;

import org.eclipse.fx.core.Subscription;

/**
 * Base interface for text registries
 * 
 * @since 2.0
 */
public interface TextRegistry {
	/**
	 * Register a consumer and supplier
	 * <pre>
	 *   &#064;Inject
	 *   private TextRegistry reg; // Subclass of AbstractMessageRegistry
	 *
	 *   TitledPane tb = new TitledPane();
	 *   reg.register(tb::setText, () -> "Hello");
	 * </pre>
	 *
	 * @param consumer the consumer the value is set on
	 * @param supplier the supplier
	 * @return the subscription
	 */
	public Subscription register(Consumer<String> consumer, Supplier<String> supplier);
	
	/**
	 * Force an update of all bindings
	 */
	public void updateBindings();
}
