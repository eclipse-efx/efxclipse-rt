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

import java.util.function.Consumer;

import org.eclipse.fx.core.Subscription;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

/**
 * Set of utility methods to deal efficiently with JavaFX {@link Observable}
 *
 * @since 3.0
 */
public class FXObservableUtil {
	/**
	 * Subscribe to invalidation events triggered by an {@link Observable}
	 *
	 * @param o
	 *            the observable
	 * @param l
	 *            the listener
	 * @return subscription used to unsubscribe
	 * @see Observable#addListener(InvalidationListener)
	 */
	public static Subscription onInvalidate(Observable o, InvalidationListener l) {
		o.addListener(l);
		return () -> o.removeListener(l);
	}

	/**
	 * Subscribe to invalidation events triggered by an {@link Observable} and
	 * run the {@link Runnable}
	 *
	 * @param o
	 *            the observable
	 * @param r
	 *            the runnable to execute
	 * @return subscription used to unsubscribe
	 * @see Observable#addListener(InvalidationListener)
	 * @see #onInvalidate(Observable, InvalidationListener)
	 */
	public static Subscription onInvalidate(Observable o, Runnable r) {
		InvalidationListener listener = (l) -> r.run();
		o.addListener(listener);
		return () -> o.removeListener(listener);
	}

	/**
	 * Subscribe to the value change of an {@link ObservableValue}
	 *
	 * @param o
	 *            the observable
	 * @param l
	 *            the listener
	 * @return subscription used to unsubscribe
	 */
	public static <T> Subscription onChange(ObservableValue<T> o, ChangeListener<T> l) {
		o.addListener(l);
		return () -> o.removeListener(l);
	}

	/**
	 * Subscribe to the value change of an {@link ObservableValue}
	 *
	 * @param o
	 *            the observable
	 * @param l
	 *            the listener
	 * @return subscription used to unsubscribe
	 */
	public static <T> Subscription onChange(ObservableValue<T> o, Consumer<T> l) {
		ChangeListener<? super T> listener = (ob, ol, ne) -> l.accept(ne);
		o.addListener(listener);
		return () -> o.removeListener(listener);
	}

	/**
	 * Subscribe to the list change of an {@link ObservableList}
	 *
	 * @param o
	 *            the observable
	 * @param l
	 *            the listener
	 * @return subscription used to unsubscribe
	 * @see ObservableList#addListener(ListChangeListener)
	 */
	public static <E> Subscription onChange(ObservableList<E> o, ListChangeListener<E> l) {
		o.addListener(l);
		return () -> o.removeListener(l);
	}
}
