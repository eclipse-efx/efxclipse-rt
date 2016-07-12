/*******************************************************************************
 * Copyright (c) 2013 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.databinding;

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.property.value.IValueProperty;
import org.eclipse.jdt.annotation.NonNull;

/**
 * Base interface of control properties
 *
 * @param <S>
 *            type of the source object
 * @param <T>
 *            type of the value of the property
 */
public interface IJFXControlValueProperty<S, T> extends IValueProperty<S, T> {

	/**
	 * Create an observable on the default realm
	 *
	 * @param control
	 *            the control
	 * @return the observable
	 * @since 2.4.0
	 */
	@Override
	@NonNull
	public IJFXControlValueObservable<T> observe(S control);

	/**
	 * Create an observable on the given realm
	 *
	 * @param realm
	 *            the realm
	 * @param control
	 *            the control
	 * @return the observable
	 * @since 2.4.0
	 */
	@Override
	public IJFXControlValueObservable<T> observe(Realm realm, S control);

	/**
	 * Create an observable who waits for the given delay until informing about
	 * the change
	 *
	 * @param delay
	 *            the delay
	 * @param control
	 *            the control
	 * @return the observable
	 * @since 2.4.0
	 */
	public IJFXControlValueObservable<T> observeDelayed(int delay, S control);
}
