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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.fx.core.Subscription;
import org.eclipse.jdt.annotation.Nullable;

/**
 * Base implementation for a value observable
 *
 * @param <T>
 *            the value type
 */
public class BaseValueObservable<T> implements ValueObservable<T> {
	private List<ChangeSubscription<T>> subscriptions;
	private T value;
	private boolean disposed;

	static class NullBaseValueObservable<@Nullable T> extends BaseValueObservable<T> {

		public NullBaseValueObservable() {
			super(null);
		}
	}

	/**
	 * Instance with a provided initial value
	 *
	 * @param value
	 *            the initial value
	 */
	public BaseValueObservable(T value) {
		this.value = value;
	}

	@Override
	public void setValue(T value) {
		if (this.disposed) {
			throw new IllegalStateException("Observable is disposed"); //$NON-NLS-1$
		}
		notifyChange(this.value, this.value = value);

	}

	@Override
	public T getValue() {
		return this.value;
	}

	private void notifyChange(T oldValue, T newValue) {
		if (this.subscriptions != null) {
			new ArrayList<>(this.subscriptions).stream().forEach(s -> s.handle(this, oldValue, newValue));
		}
	}

	@Override
	public Subscription onValueChange(ChangeSubscription<T> c) {
		if (this.disposed) {
			throw new IllegalStateException("Observable is disposed"); //$NON-NLS-1$
		}

		if (this.subscriptions == null) {
			this.subscriptions = new ArrayList<>();
		}
		this.subscriptions.add(c);
		return () -> this.subscriptions.remove(c);
	}

	@Override
	public boolean isDisposed() {
		return this.disposed;
	}

	@Override
	public void dispose() {
		this.disposed = true;
		if (this.subscriptions != null) {
			this.subscriptions = null;
		}
	}

}
