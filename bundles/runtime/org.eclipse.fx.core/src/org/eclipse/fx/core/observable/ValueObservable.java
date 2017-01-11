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
package org.eclipse.fx.core.observable;

import org.eclipse.fx.core.Subscription;

/**
 * An observable value
 *
 * @param <T>
 *            the type
 */
public interface ValueObservable<T> {
	/**
	 * Set a new value
	 *
	 * @param value
	 *            the new value
	 */
	public void setValue(T value);

	/**
	 * @return the current value
	 */
	public T getValue();

	/**
	 * Subscribe on value change
	 *
	 * @param c
	 *            the subscription callback
	 * @return subscription used to remove the subscription
	 */
	public Subscription onValueChange(ChangeSubscription<T> c);

	/**
	 * Subscription for value changes
	 *
	 * @param <T>
	 *            the type
	 */
	public interface ChangeSubscription<T> {
		/**
		 * Invoked if the value has changed
		 *
		 * @param owner
		 *            the owner
		 * @param oldValue
		 *            the oldValue
		 * @param newValue
		 *            the newValue
		 */
		public void handle(ValueObservable<T> owner, T oldValue, T newValue);
	}

	/**
	 * Observable for a {@link String} value
	 */
	public interface StringObservable extends ValueObservable<String> {
		// empty by default
	}
}
