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
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

import javax.annotation.PreDestroy;

import org.eclipse.fx.core.Subscription;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

/**
 * <p>
 * A registry for {@link Subscription} who is used to collect them and dispose
 * them all together.
 * </p>
 * <p>
 * Preferred useage is through a DI-Container:
 * </p>
 * <code><pre>
 * class Test {
 * 	{@literal @Inject}
 * 	SubscriptionRegistry registry;
 * }
 * </pre></code>
 */
public class SubscriptionRegistry {
	private List<Subscription> subscriptions = new ArrayList<>();

	/**
	 * Subscribe to invalidation events triggered by an {@link Observable}
	 *
	 * @param o
	 *            the observable
	 * @param l
	 *            the listener
	 * @return subscription used to unsubscribe
	 * @see FXObservableUtil#onInvalidate(Observable, InvalidationListener)
	 */
	public Subscription onInvalidate(Observable o, InvalidationListener l) {
		Subscription subscription = FXObservableUtil.onInvalidate(o, l);
		this.subscriptions.add(subscription);
		return () -> {
			subscription.dispose();
			this.subscriptions.remove(subscription);
		};
	}

	/**
	 * Subscribe to invalidation events triggered by an {@link Observable}
	 *
	 * @param o
	 *            the observable
	 * @param r
	 *            the runnable to execute
	 * @return subscription used to unsubscribe
	 * @see FXObservableUtil#onInvalidate(Observable, Runnable)
	 */
	public Subscription onInvalidate(Observable o, Runnable r) {
		Subscription subscription = FXObservableUtil.onInvalidate(o, r);
		this.subscriptions.add(subscription);
		return () -> {
			subscription.dispose();
			this.subscriptions.remove(subscription);
		};
	}

	/**
	 * Subscribe to a change event triggered by an {@link ObservableValue}
	 *
	 * @param o
	 *            the observable
	 * @param l
	 *            the listener
	 * @return subscription used to unsubscribe
	 * @see FXObservableUtil#onChange(ObservableValue, ChangeListener)
	 */
	public <T> Subscription onChange(ObservableValue<T> o, ChangeListener<? super T> l) {
		Subscription subscription = FXObservableUtil.onChange(o, l);
		this.subscriptions.add(subscription);
		return () -> {
			subscription.dispose();
			this.subscriptions.remove(subscription);
		};
	}

	/**
	 * Subscribe to a change event triggered by an {@link ObservableValue}
	 *
	 * @param o
	 *            the observable
	 * @param l
	 *            the listener
	 * @return subscription used to unsubscribe
	 * @see FXObservableUtil#onChange(ObservableValue, Consumer)
	 */
	public <T> Subscription onChange(ObservableValue<T> o, Consumer<? super T> l) {
		Subscription subscription = FXObservableUtil.onChange(o, l);
		this.subscriptions.add(subscription);
		return () -> {
			subscription.dispose();
			this.subscriptions.remove(subscription);
		};
	}

	/**
	 * Subscribe to a change event triggered by an {@link ObservableList}
	 *
	 * @param o
	 *            the observable
	 * @param l
	 *            the listener
	 * @return subscription used to unsubscribe
	 */
	public <E> Subscription onChange(ObservableList<E> o, ListChangeListener<? super E> l) {
		Subscription subscription = FXObservableUtil.onChange(o, l);
		this.subscriptions.add(subscription);
		return () -> {
			subscription.dispose();
			this.subscriptions.remove(subscription);
		};
	}

	/**
	 * Clean up the subscriptions
	 */
	@PreDestroy
	public void dispose() {
		List<Subscription> c = new ArrayList<>(this.subscriptions);
		this.subscriptions.clear();
		Collections.reverse(c);
		c.forEach( s -> {try {
			s.dispose();
		} catch (Throwable e) {
			// skip
		}} );
	}
}
