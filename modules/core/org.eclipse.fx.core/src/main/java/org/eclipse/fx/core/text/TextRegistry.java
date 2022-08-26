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

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

import org.eclipse.fx.core.Subscription;
import org.eclipse.fx.core.log.LoggerCreator;

/**
 * Base interface for text registries
 *
 * @since 2.0
 */
public interface TextRegistry {
	/**
	 * Register a consumer and supplier
	 *
	 * <pre>
	 * &#064;Inject
	 * private TextRegistry reg; // Subclass of AbstractMessageRegistry
	 *
	 * TitledPane tb = new TitledPane();
	 * reg.register(tb::setText, () -&gt; "Hello");
	 * </pre>
	 *
	 * @param consumer
	 *            the consumer the value is set on
	 * @param supplier
	 *            the supplier
	 * @return the subscription
	 */
	public Subscription register(Consumer<String> consumer, Supplier<String> supplier);

	/**
	 * Force an update of all bindings
	 */
	public void updateBindings();

	/**
	 * Get the supplier by the key
	 *
	 * @param key
	 *            the key
	 * @param values
	 *            the dynamic values
	 * @return the supplier or <code>null</code>
	 * @since 2.1
	 */
	default public java.util.function.Supplier<String> getSupplierByKey(String key, Object... values) {
		//FIXME Make none default in 3.0
		if( values.length == 0 ) {
			try {
				Method m = getClass().getMethod(key);
				return new Supplier<String>() {

					@Override
					public String get() {
						try {
							return (String) m.invoke(this);
						} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
							throw new RuntimeException(e);
						}
					}
				};
			} catch (NoSuchMethodException | SecurityException e) {
				LoggerCreator.createLogger(getClass()).error("No translation for '"+key+"' is found");  //$NON-NLS-1$//$NON-NLS-2$
			}
		} else {
			try {
				Optional<Supplier<String>> rv = Stream.of(getClass().getMethods())
					.filter(m -> (key + "_supplier").equals(m.getName())) //$NON-NLS-1$
					.findFirst().<Supplier<String>>map( m -> new Supplier<String>() {

					@Override
					public String get() {
						try {
							return (String) m.invoke(this, values);
						} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
							throw new RuntimeException(e);
						}
					}
				});
				if( rv.isPresent() ) {
					return rv.get();
				}
			} catch (SecurityException e) {
				LoggerCreator.createLogger(getClass()).error("No translation for '"+key+"' is found");  //$NON-NLS-1$//$NON-NLS-2$
			}
		}
		return null;
	}
}
