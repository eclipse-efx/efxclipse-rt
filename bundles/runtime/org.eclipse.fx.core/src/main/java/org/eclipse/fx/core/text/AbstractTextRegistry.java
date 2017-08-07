/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
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
import java.util.function.Function;
import java.util.function.Supplier;

import javax.annotation.PreDestroy;

import org.eclipse.fx.core.Subscription;

/**
 * Allows to register translated elements
 *
 * @param <M>
 *            the message class type
 * @since 1.1
 */
public class AbstractTextRegistry<M> extends BasicTextRegistry implements TextRegistry {
	private M messages;

	/**
	 * @return the current message class
	 */
	public final M getMessages() {
		return this.messages;
	}

	/**
	 * Register a consumer and a function acting as the supplier of the
	 * translation value:
	 * <pre>
	 *   &#064;Inject
	 *   private MessageHandler handler; // Subclass of AbstractMessageRegistry
	 *
	 *   TitledPane tb = new TitledPane();
	 *   handler.register(tb::setText, (m) -&gt; m.PreferenceView_Title);
	 * </pre>
	 *
	 * @param consumer
	 *            the consumer
	 * @param valueFunction
	 *            the supplier function
	 * @return the subscription
	 */
	public Subscription register(Consumer<String> consumer, Function<M, String> valueFunction) {
		return register(consumer, () -> valueFunction.apply(getMessages()));
	}

	/**
	 * Register a consumer and supplier
	 * <pre>
	 *   &#064;Inject
	 *   private MessageHandler handler; // Subclass of AbstractMessageRegistry
	 *
	 *   TitledPane tb = new TitledPane();
	 *   handler.register(tb::setText, handler::PreferenceView_Title);
	 * </pre>
	 *
	 * @param consumer the consumer the value is set on
	 * @param supplier the supplier
	 * @return the subscription
	 */
	@Override
	public Subscription register(Consumer<String> consumer, Supplier<String> supplier) {
		return super.register(consumer, supplier);
	}

	/**
	 * Update the message object
	 *
	 * @param messages the messages
	 */
	public void updateMessages(M messages) {
		this.messages = messages;
		updateBindings();
	}
	
	@PreDestroy
	void unregister() {
		this.bindings.clear();
	}
}
