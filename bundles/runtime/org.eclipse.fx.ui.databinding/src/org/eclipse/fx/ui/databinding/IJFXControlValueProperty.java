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

import javafx.scene.Node;
import javafx.scene.control.Control;

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.property.value.IValueProperty;
import org.eclipse.jdt.annotation.NonNull;

/**
 * Base interface of control properties
 */
public interface IJFXControlValueProperty extends IValueProperty {
	/**
	 * Create an observable on the default realm
	 *
	 * @param control
	 *            the control
	 * @return the observable
	 */
	@NonNull
	public IJFXControlValueObservable observe(@NonNull Control control);

	/**
	 * Create an observable on the default realm
	 *
	 * @param control
	 *            the control
	 * @return the observable
	 * @since 2.4.0
	 */
	@NonNull
	public IJFXControlValueObservable observe(@NonNull Node control);

	/**
	 * Create an observable on the given realm
	 *
	 * @param realm
	 *            the realm
	 * @param control
	 *            the control
	 * @return the observable
	 */
	public IJFXControlValueObservable observe(@NonNull Realm realm, @NonNull Control control);

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
	public IJFXControlValueObservable observe(@NonNull Realm realm, @NonNull Node control);

	/**
	 * Create an observable who waits for the given delay until informing about
	 * the change
	 *
	 * @param delay
	 *            the delay
	 * @param control
	 *            the control
	 * @return the observable
	 */
	public IJFXControlValueObservable observeDelayed(int delay, @NonNull Control control);

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
	public IJFXControlValueObservable observeDelayed(int delay, @NonNull Node control);
}
