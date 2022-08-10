/*******************************************************************************
 * Copyright (c) 2017 BestSolution.at and others.
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
package org.eclipse.fx.core.observable;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import org.eclipse.fx.core.DisposeableCollector;
import org.eclipse.fx.core.Subscription;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.collections.MapChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.collections.ObservableSet;
import javafx.collections.SetChangeListener;

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
	 * Subscribe to invalidation events triggered by an {@link Observable} and
	 * run the {@link Runnable}
	 *
	 * @param o
	 *            the observable
	 * @param r
	 *            the runnable to execute
	 * @param runImmediately
	 *            run the Runnable immediately, if true
	 * @return subscription used to unsubscribe
	 * @see Observable#addListener(InvalidationListener)
	 * @see #onInvalidate(Observable, InvalidationListener)
	 */
	public static Subscription onInvalidate(Observable o, Runnable r, boolean runImmediately) {
		try {
			return onInvalidate(o, r);
		} finally {
			if (runImmediately) {
				r.run();
			}
		}
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
	public static <T> Subscription onChange(ObservableValue<T> o, ChangeListener<? super T> l) {
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
	public static <T> Subscription onChange(ObservableValue<T> o, Consumer<? super T> l) {
		ChangeListener<? super T> listener = (ob, ol, ne) -> l.accept(ne);
		o.addListener(listener);
		return () -> o.removeListener(listener);
	}

	/**
	 * Subscribe to the value change of an {@link ObservableValue}
	 *
	 * @param o
	 *            the observable
	 * @param c
	 *            the Consumer to be executed on value change
	 * @param consumeImmediately
	 *            run the Consumer immediately with the property's current value, if true
	 * @return subscription used to unsubscribe
	 */
	public static <T> Subscription onChange(ObservableValue<T> o, Consumer<T> c, boolean consumeImmediately) {
		try {
			return onChange(o, c);
		} finally {
			if (consumeImmediately) {
				c.accept(o.getValue());
			}
		}
	}

	/**
	 * Subscribe to the value change of an {@link ObservableValue}
	 *
	 * @param o
	 *            the observable
	 * @param l
	 *            the listener
	 * @return subscription used to unsubscribe
	 * @param <T> value type
	 * @since 3.5.0
	 */
	public static <T> Subscription onChange(ObservableValue<T> o, BiConsumer<? super T,? super T> l) {
		ChangeListener<? super T> listener = (ob, ol, ne) -> l.accept(ol,ne);
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
	public static <E> Subscription onChange(ObservableList<E> o, ListChangeListener<? super E> l) {
		o.addListener(l);
		return () -> o.removeListener(l);
	}

	/**
	 * Subscribe to the list change of an {@link ObservableSet}
	 *
	 * @param o
	 *            the observable
	 * @param l
	 *            the listener
	 * @return subscription used to unsubscribe
	 * @see ObservableSet#addListener(SetChangeListener)
	 */
	public static <E> Subscription onChange(ObservableSet<E> o, SetChangeListener<? super E> l) {
		o.addListener(l);
		return () -> o.removeListener(l);
	}

	/**
	 * Subscribe to the list change of an {@link ObservableMap}
	 *
	 * @param o
	 *            the observable
	 * @param l
	 *            the listener
	 * @return subscription used to unsubscribe
	 * @see ObservableMap#addListener(MapChangeListener)
	 */
	public static <K, V> Subscription onChange(ObservableMap<K, V> o, MapChangeListener<K, V> l) {
		o.addListener(l);
		return () -> o.removeListener(l);
	}

	/**
	 * Instance version of {@link FXObservableUtil} who tracks the created
	 * {@link Subscription} objects
	 *
	 * @since 3.0
	 */
	public static class Instance extends DisposeableCollector<Subscription> {
		/**
		 * Create a new instance
		 */
		public Instance() {
			super(Subscription::dispose);
		}

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
		public Subscription onInvalidate(Observable o, InvalidationListener l) {
			o.addListener(l);
			return wrap(() -> o.removeListener(l));
		}

		private Subscription wrap(Subscription subscription) {
			register(subscription);
			return () -> {
				unregister(subscription);
				subscription.dispose();
			};
		}

		/**
		 * Subscribe to invalidation events triggered by an {@link Observable}
		 * and run the {@link Runnable}
		 *
		 * @param o
		 *            the observable
		 * @param r
		 *            the runnable to execute
		 * @return subscription used to unsubscribe
		 * @see Observable#addListener(InvalidationListener)
		 * @see #onInvalidate(Observable, InvalidationListener)
		 */
		public Subscription onInvalidate(Observable o, Runnable r) {
			return onInvalidate(o, (l) -> r.run());
		}

		/**
		 * Subscribe to invalidation events triggered by an {@link Observable} and
		 * run the {@link Runnable}
		 *
		 * @param o
		 *            the observable
		 * @param r
		 *            the runnable to execute
		 * @param runImmediately
		 *            run the Runnable immediately, if true
		 * @return subscription used to unsubscribe
		 * @see Observable#addListener(InvalidationListener)
		 * @see #onInvalidate(Observable, InvalidationListener)
		 */
		public Subscription onInvalidate(Observable o, Runnable r, boolean runImmediately) {
			try {
				return onInvalidate(o, r);
			} finally {
				if (runImmediately) {
					r.run();
				}
			}
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
		public <T> Subscription onChange(ObservableValue<T> o, ChangeListener<? super T> l) {
			o.addListener(l);
			return wrap(() -> o.removeListener(l));
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
		public <T> Subscription onChange(ObservableValue<T> o, Consumer<? super T> l) {
			return onChange(o, (ob, ol, ne) -> l.accept(ne));
		}

		/**
		 * Subscribe to the value change of an {@link ObservableValue}
		 *
		 * @param o
		 *            the observable
		 * @param c
		 *            the Consumer to be executed on value change
		 * @param consumeImmediately
		 *            run the Consumer immediately with the property's current value, if true
		 * @return subscription used to unsubscribe
		 */
		public <T> Subscription onChange(ObservableValue<T> o, Consumer<T> c, boolean consumeImmediately) {
			try {
				return onChange(o, c);
			} finally {
				if (consumeImmediately) {
					c.accept(o.getValue());
				}
			}
		}

		/**
		 * Subscribe to the value change of an {@link ObservableValue}
		 *
		 * @param o
		 *            the observable
		 * @param l
		 *            the listener
		 * @return subscription used to unsubscribe
		 * @param <T> the value type
		 * @since 3.5.0
		 */
		public <T> Subscription onChange(ObservableValue<T> o, BiConsumer<? super T,? super T> l) {
			return onChange(o, (ob, ol, ne) -> l.accept(ol,ne));
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
		public <E> Subscription onChange(ObservableList<E> o, ListChangeListener<? super E> l) {
			o.addListener(l);
			return wrap(() -> o.removeListener(l));
		}

		/**
		 * Subscribe to the list change of an {@link ObservableSet}
		 *
		 * @param o
		 *            the observable
		 * @param l
		 *            the listener
		 * @return subscription used to unsubscribe
		 * @see ObservableSet#addListener(SetChangeListener)
		 */
		public <E> Subscription onChange(ObservableSet<E> o, SetChangeListener<? super E> l) {
			o.addListener(l);
			return wrap(() -> o.removeListener(l));
		}

		/**
		 * Subscribe to the list change of an {@link ObservableMap}
		 *
		 * @param o
		 *            the observable
		 * @param l
		 *            the listener
		 * @return subscription used to unsubscribe
		 * @see ObservableMap#addListener(MapChangeListener)
		 */
		public <K, V> Subscription onChange(ObservableMap<K, V> o, MapChangeListener<K, V> l) {
			o.addListener(l);
			return wrap(() -> o.removeListener(l));
		}
	}

	// static class NodeSubscription implements Subscription {
	// private final Subscription subscription;
	// private final Object property;
	// private final Object listener;
	// private final byte type;
	// private final String key = UUID.randomUUID().toString();
	//
	// @SuppressWarnings({ "rawtypes", "unchecked" })
	// NodeSubscription(Function<Subscription, Subscription> subscriptionStore,
	// Object property, Object listener, byte type) {
	// this.property = property;
	// this.listener = listener;
	// this.subscription = subscriptionStore.apply(this);
	// this.type = type;
	//
	// if (type == 1) {
	// ((ObservableList) property).addListener((ListChangeListener) listener);
	// } else if (type == 2) {
	// ((ObservableSet) property).addListener((SetChangeListener) listener);
	// } else if (type == 3) {
	// ((ObservableMap) property).addListener((MapChangeListener) listener);
	// }
	//
	// this.n.getProperties().put(this.key, listener);
	// }
	//
	// @SuppressWarnings({ "unchecked", "rawtypes" })
	// @Override
	// public void dispose() {
	// if (this.type == 1) {
	// ((ObservableList) this.property).removeListener((ListChangeListener)
	// this.listener);
	// } else if (this.type == 2) {
	// ((ObservableSet) this.property).removeListener((SetChangeListener)
	// this.listener);
	// } else if (this.type == 3) {
	// ((ObservableMap) this.property).removeListener((MapChangeListener)
	// this.listener);
	// }
	// this.n.getProperties().remove(this.key, this.listener);
	// }
	// }
}
