/*******************************************************************************
 * Copyright (c) 2013 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core.di;

import org.eclipse.fx.core.Callback;
import org.eclipse.fx.core.Subscription;
import org.eclipse.fx.core.adapter.Adaptable;

/**
 * A value bound to the IEclipseContext
 * 
 * @param <T>
 *            the type
 */
public interface ContextBoundValue<T> extends Adaptable {
	/**
	 * @return the current value
	 */
	public T getValue();

	/**
	 * Publish the value back to the context
	 * 
	 * @param value
	 *            the value to publish
	 */
	public void publish(T value);

	/**
	 * Subscribe for value change events
	 * 
	 * @param callback
	 *            the callback to be invoked
	 * @return the subscription to revoke it
	 */
	public Subscription subscribeOnValueChange(Callback<T> callback);

	/**
	 * Get informed about disposal
	 * 
	 * @param callback
	 *            the callback
	 * @return the subscription to revoke it
	 */
	public Subscription subscribeOnDispose(Callback<Void> callback);

	/**
	 * Allows to adapt the type to the given type.
	 * 
	 * By default the following adapters are available:
	 * <ul>
	 * <li>Eclipse Databinding - {@link org.eclipse.core.databinding.observable.value.IObservableValue}</li>
	 * <li>JavaFX property - {@link javafx.beans.property.Property}</li>
	 * </ul>
	 * 
	 * @param adapt
	 *            the type to adapt to
	 * @return the adapted type
	 * @see Adaptable#adaptTo(Class)
	 */
	@Override
	public <A> A adaptTo(Class<A> adapt);

	/**
	 * Test if the instance can be adapted to the target
	 * 
	 * By default the following adapters are available:
	 * <ul>
	 * <li>Eclipse Databinding - {@link org.eclipse.core.databinding.observable.value.IObservableValue}</li>
	 * <li>JavaFX property - {@link javafx.beans.property.Property}</li>
	 * </ul>
	 * 
	 * @see Adaptable#canAdaptTo(Class)
	 */
	@Override
	public boolean canAdaptTo(Class<?> adapt);
}