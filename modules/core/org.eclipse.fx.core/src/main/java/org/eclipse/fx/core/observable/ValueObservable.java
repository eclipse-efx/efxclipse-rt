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
import org.eclipse.jdt.annotation.Nullable;

/**
 * An observable value
 *
 * @param <T>
 *            the type
 * @since 3.0.0
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
	 * Dispose the observable releasing all resources
	 */
	public void dispose();

	/**
	 * @return <code>true</code> if the observable is disposed
	 */
	public boolean isDisposed();

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
	 * @param <T>
	 *            the type
	 * @return an object observable
	 */
	public static <@Nullable T> ValueObservable<T> createObservableObject() {
		return new BaseValueObservable.NullBaseValueObservable<>();
	}

	/**
	 * Create an object observable
	 * 
	 * @param <T>
	 *            the type
	 * @param value
	 *            initial value
	 * @return an object observable
	 */
	public static <T> ValueObservable<T> createObservableObject(T value) {
		return new BaseValueObservable<>(value);
	}

	/**
	 * @return a string observable
	 */
	public static StringValueObservable createObservableString() {
		return new StringValueObservable();
	}

	/**
	 * Create a string observable
	 *
	 * @param value
	 *            initial value
	 * @return a string observable
	 */
	public static StringValueObservable createObservableString(String value) {
		return new StringValueObservable(value);
	}

	/**
	 * Observable for a {@link String} value
	 *
	 * @since 3.0.0
	 */
	public interface OString extends ValueObservable<String> {
		// empty by default
	}
}
