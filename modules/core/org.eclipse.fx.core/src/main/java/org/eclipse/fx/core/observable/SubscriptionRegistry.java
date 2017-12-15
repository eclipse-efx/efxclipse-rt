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
import java.util.function.Function;
import java.util.function.IntFunction;

import javax.annotation.PreDestroy;

import org.eclipse.fx.core.Subscription;
import org.eclipse.fx.core.ThreadSynchronize;
import org.eclipse.fx.core.bindings.BindingStream;
import org.eclipse.fx.core.bindings.FXBindings;
import org.eclipse.fx.core.bindings.FXBindings.ConverterRegistry;
import org.eclipse.fx.core.bindings.FXBindings.StatusBinding;
import org.eclipse.fx.core.bindings.FXCollector;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.Binding;
import javafx.beans.binding.ListBinding;
import javafx.beans.binding.ObjectBinding;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.Property;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableBooleanValue;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.collections.MapChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.collections.ObservableSet;
import javafx.collections.SetChangeListener;

/**
 * <p>
 * A registry for {@link Subscription} who is used to collect them and dispose
 * them all together.
 * </p>
 * <p>
 * Preferred useage is through a DI-Container:
 * </p>
 * 
 * <pre>
 * <code>
 * class Test {
 * 	{@literal @Inject}
 * 	SubscriptionRegistry registry;
 * }
 * </code>
 * </pre>
 * 
 * @deprecated use {@link FXObservableUtil.Instance}
 */
@Deprecated
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
	 * @param <T>
	 *            the source type
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
	 * @param <T>
	 *            the source type
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
	 * @param <E>
	 *            the element type
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
	 * Subscribe to the list change of an {@link ObservableSet}
	 * 
	 * @param <E>
	 *            the element type
	 * @param o
	 *            the observable
	 * @param l
	 *            the listener
	 * @return subscription used to unsubscribe
	 * @see ObservableSet#addListener(SetChangeListener)
	 */
	public <E> Subscription onChange(ObservableSet<E> o, SetChangeListener<? super E> l) {
		Subscription subscription = FXObservableUtil.onChange(o, l);
		this.subscriptions.add(subscription);
		return () -> {
			subscription.dispose();
			this.subscriptions.remove(subscription);
		};
	}

	/**
	 * Subscribe to the list change of an {@link ObservableMap}
	 * 
	 * @param <K>
	 *            the key type
	 * @param <V>
	 *            the value type
	 * @param o
	 *            the observable
	 * @param l
	 *            the listener
	 * @return subscription used to unsubscribe
	 * @see ObservableMap#addListener(MapChangeListener)
	 */
	public <K, V> Subscription onChange(ObservableMap<K, V> o, MapChangeListener<K, V> l) {
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
		c.forEach(s -> {
			try {
				s.dispose();
			} catch (Throwable e) {
				// skip
			}
		});
	}

	/**
	 * add a custom subscription.
	 *
	 * @param subscription
	 *            subscription
	 */
	public void add(Subscription subscription) {
		this.subscriptions.add(subscription);
	}

	/**
	 * Bidirectional binding between two properties with conversion. The conversion
	 * is looked up in the {@link ConverterRegistry} if no converter is found a
	 * runtime exception is thrown
	 * 
	 * @param <T>
	 *            the target type
	 * @param <S>
	 *            the source type
	 * @param target
	 *            the target property
	 * @param source
	 *            the source property
	 * @param targetType
	 *            the target type
	 * @param sourceType
	 *            the source type
	 * @return a StatusBinding which can be used to watch conversion failures and to
	 *         dispose the whole bidi binding
	 * @see FXBindings#bindBidirectional(Property, Property, Class, Class)
	 */
	public <S, T> StatusBinding onBindBidirectional(Property<T> target, Property<S> source, Class<T> targetType,
			Class<S> sourceType) {
		StatusBinding binding = FXBindings.bindBidirectional(target, source, targetType, sourceType);
		this.subscriptions.add(() -> binding.dispose());
		return binding;
	}

	/**
	 * Bidirectional binding between two properties with conversion.
	 *
	 * @param <T>
	 *            the target type
	 * @param <S>
	 *            the source type
	 * @param target
	 *            the target property
	 * @param source
	 *            the source property
	 * @param targetToSource
	 *            map from target to source
	 * @param sourceToTarget
	 *            map from source to target
	 * @return a StatusBinding which can be used to watch conversion failures and to
	 *         dispose the whole bidi binding
	 * @see FXBindings#bindBidirectional(Property, Property, Function, Function)
	 */
	public <S, T> StatusBinding onBindBidirectional(Property<T> target, Property<S> source,
			Function<T, S> targetToSource, Function<S, T> sourceToTarget) {
		StatusBinding binding = FXBindings.bindBidirectional(target, source, targetToSource, sourceToTarget);
		this.subscriptions.add(() -> binding.dispose());
		return binding;
	}

	/**
	 * Bind the content to the source list to the target with an optional padding
	 * and apply the converter in between
	 * 
	 * @param <T>
	 *            the target type
	 * @param <E>
	 *            the source element type
	 * @param padding
	 *            the initial padding
	 * @param target
	 *            the target
	 * @param sourceList
	 *            the source list
	 * @param converterFunction
	 *            the converter function
	 * @param paddingEntryFactory
	 *            function to consult when filling padding slots
	 * @return the binding
	 * @see FXBindings#bindContent(int, List, ObservableList, Function, IntFunction)
	 */
	public <T, E> Subscription onBindContent(int padding, List<T> target, ObservableList<E> sourceList,
			Function<E, T> converterFunction, IntFunction<T> paddingEntryFactory) {
		Subscription subscription = FXBindings.bindContent(padding, target, sourceList, converterFunction,
				paddingEntryFactory);
		this.subscriptions.add(subscription);
		return () -> {
			subscription.dispose();
			this.subscriptions.remove(subscription);
		};
	}

	/**
	 * Bind the content to the source list to the target and apply the converter in
	 * between
	 * 
	 * @param <T>
	 *            the target type
	 * @param <E>
	 *            the source type
	 * @param target
	 *            the target list
	 * @param sourceList
	 *            the source list
	 * @param converterFunction
	 *            the function used to convert
	 * @return the subscription to dispose the binding
	 * @see FXBindings#bindContent(List, ObservableList, Function)
	 */
	public <T, E> Subscription onBindContent(List<T> target, ObservableList<E> sourceList,
			Function<E, T> converterFunction) {
		Subscription subscription = FXBindings.bindContent(target, sourceList, converterFunction);
		this.subscriptions.add(subscription);
		return () -> {
			subscription.dispose();
			this.subscriptions.remove(subscription);
		};
	}

	/**
	 * Bind the content to the source list to the target with an optional padding
	 * and apply the converter in between
	 * 
	 * @param <T>
	 *            the target type
	 * @param <E>
	 *            the source element type
	 * @param threadSync
	 *            strategy to synchronize the target on a certain thread, might be
	 *            <code>null</code>
	 * @param padding
	 *            the initial padding
	 * @param target
	 *            the target
	 * @param sourceList
	 *            the source list
	 * @param converterFunction
	 *            the converter function
	 * @param paddingEntryFactory
	 *            function to consult when filling padding slots
	 * @return the binding
	 * @see FXBindings#bindContent(ThreadSynchronize, int, List, ObservableList,
	 *      Function, IntFunction)
	 */
	public <T, E> Subscription onBindContent(ThreadSynchronize threadSync, int padding, List<T> target,
			ObservableList<E> sourceList, Function<E, T> converterFunction, IntFunction<T> paddingEntryFactory) {
		Subscription subscription = FXBindings.bindContent(threadSync, padding, target, sourceList, converterFunction,
				paddingEntryFactory);
		this.subscriptions.add(subscription);
		return () -> {
			subscription.dispose();
			this.subscriptions.remove(subscription);
		};
	}

	/**
	 * Bind the content to the source list to the target and apply the converter in
	 * between
	 * 
	 * @param <T>
	 *            the target type
	 * @param <E>
	 *            the source type
	 * @param threadSync
	 *            strategy to synchronize the target on a certain thread, might be
	 *            <code>null</code>
	 * @param target
	 *            the target list
	 * @param sourceList
	 *            the source list
	 * @param converterFunction
	 *            the function used to convert
	 * @return the subscription to dispose the binding
	 * @see FXBindings#bindContent(ThreadSynchronize, List, ObservableList,
	 *      Function)
	 */
	public <T, E> Subscription onBindContent(ThreadSynchronize threadSync, List<T> target, ObservableList<E> sourceList,
			Function<E, T> converterFunction) {
		Subscription subscription = FXBindings.bindContent(threadSync, target, sourceList, converterFunction);
		this.subscriptions.add(subscription);
		return () -> {
			subscription.dispose();
			this.subscriptions.remove(subscription);
		};
	}

	/**
	 * Concatenates multiple observable lists together.
	 * 
	 * @param <A>
	 *            the source type
	 * @param sources
	 *            the sources
	 * @return the concatenated list binding
	 * @see FXBindings#concat(ObservableList...)
	 */
	public <A> ListBinding<A> onConcat(@SuppressWarnings("unchecked") ObservableList<? extends A>... sources) {
		ListBinding<A> binding = FXBindings.concat(sources);
		this.subscriptions.add(() -> binding.dispose());
		return binding;
	}

	/**
	 * Concat all non-null and non empty values with the given delimiter
	 * 
	 * @param <T>
	 *            the source type
	 * @param delimiter
	 *            the delimiter to use
	 * @param sources
	 *            list of observable
	 * @return binding with the source concated
	 * @see FXBindings#concat(String, ObservableValue...)
	 */
	public <T> StringBinding onConcat(String delimiter, @SuppressWarnings("unchecked") ObservableValue<T>... sources) {
		StringBinding binding = FXBindings.concat(delimiter, sources);
		this.subscriptions.add(() -> binding.dispose());
		return binding;
	}

	/**
	 * Maps an observable value to another observable value
	 * 
	 * @param <A>
	 *            the source type
	 * @param <B>
	 *            the target type
	 * @param source
	 *            the source observable
	 * @param map
	 *            the mapping function
	 * @return the mapped value binding
	 * @see FXBindings#flatMap(ObservableValue, Function)
	 */
	public <A, B> ObjectBinding<B> onFlatMap(ObservableValue<A> source, Function<A, ObservableValue<B>> map) {
		ObjectBinding<B> binding = FXBindings.flatMap(source, map);
		this.subscriptions.add(() -> binding.dispose());
		return binding;
	}

	/**
	 * Flat maps an observable list with observable lists
	 * 
	 * @param <A>
	 *            the source type
	 * @param <B>
	 *            the target type
	 * @param source
	 *            the source observable
	 * @param map
	 *            the mapping function
	 * @return the flat mapped list binding
	 * @see FXBindings#flatMapList(ObservableList, Function)
	 */
	public <A, B> ListBinding<B> onFlatMapList(ObservableList<A> source, Function<A, ObservableList<B>> map) {
		ListBinding<B> binding = FXBindings.flatMapList(source, map);
		this.subscriptions.add(() -> binding.dispose());
		return binding;
	}

	/**
	 * Flat maps an observable list with observable values
	 * 
	 * @param <A>
	 *            the source type
	 * @param <B>
	 *            the target type
	 * @param source
	 *            the source observable
	 * @param map
	 *            the mapping function
	 * @return the flat mapped list binding
	 * @see FXBindings#flatMapListValue(ObservableList, Function)
	 */
	public <A, B> ListBinding<B> onFlatMapListValue(ObservableList<A> source, Function<A, ObservableValue<B>> map) {
		ListBinding<B> binding = FXBindings.flatMapListValue(source, map);
		this.subscriptions.add(() -> binding.dispose());
		return binding;
	}

	/**
	 * allows to sync between threads
	 * 
	 * @param <A>
	 *            the type
	 * @param source
	 *            the source observable
	 * @param thread
	 *            the thread synchronizer
	 * @return the synchronized list binding
	 * @see FXBindings#syncList(ObservableList, ThreadSynchronize)
	 */
	public <A> ListBinding<A> onSyncList(ObservableList<A> source, ThreadSynchronize thread) {
		ListBinding<A> binding = FXBindings.syncList(source, thread);
		this.subscriptions.add(() -> binding.dispose());
		return binding;
	}

	/**
	 * allows to sync between threads
	 * 
	 * @param <A>
	 *            the type
	 * @param source
	 *            the source observable
	 * @param thread
	 *            the thread synchronizer
	 * @return the synchronized object binding
	 * @see FXBindings#sync(ObservableValue, ThreadSynchronize)
	 */
	public <A> ObjectBinding<A> onSync(ObservableValue<A> source, ThreadSynchronize thread) {
		ObjectBinding<A> binding = FXBindings.sync(source, thread);
		this.subscriptions.add(() -> binding.dispose());
		return binding;
	}

	/**
	 * Creates a binding depending on the value of the condition
	 * 
	 * @param <T>
	 *            the type
	 * @param condition
	 *            the condition
	 * @param then
	 *            the value held by the binding if the condition is
	 *            <code>true</code>
	 * @param _else
	 *            the value held by the binding if the condition is
	 *            <code>false</code>
	 * @return the binding
	 * @see FXBindings#tenaryBinding(ObservableBooleanValue, ObservableValue,
	 *      ObservableValue)
	 */
	public <T> Binding<T> onTenaryBinding(ObservableBooleanValue condition, ObservableValue<T> then,
			ObservableValue<T> _else) {
		Binding<T> binding = FXBindings.tenaryBinding(condition, then, _else);
		this.subscriptions.add(() -> binding.dispose());
		return binding;
	}

	/**
	 * Creates a binding depending on the value of the condition
	 * 
	 * @param <T>
	 *            the type
	 * @param condition
	 *            the condition
	 * @param then
	 *            the value held by the binding if the condition is
	 *            <code>true</code>
	 * @param _else
	 *            the value held by the binding if the condition is
	 *            <code>false</code>
	 * @return the binding
	 * @see FXBindings#tenaryBinding(ObservableBooleanValue, Object, Object)
	 */
	public <T> Binding<T> onTenaryBinding(ObservableBooleanValue condition, T then, T _else) {
		Binding<T> binding = FXBindings.tenaryBinding(condition, then, _else);
		this.subscriptions.add(() -> binding.dispose());
		return binding;
	}

	/**
	 * Maps an observable value
	 * 
	 * @param <A>
	 *            the source type
	 * @param <B>
	 *            the target type
	 * @param source
	 *            source value
	 * @param map
	 *            map function
	 * @return the mapped value binding
	 * @see FXBindings#map(ObservableValue, Function)
	 */
	public <A, B> ObjectBinding<B> onMap(ObservableValue<A> source, Function<A, B> map) {
		ObjectBinding<B> binding = FXBindings.map(source, map);
		this.subscriptions.add(() -> binding.dispose());
		return binding;
	}

	/**
	 * Maps an observable list
	 * 
	 * @param <A>
	 *            the source type
	 * @param <B>
	 *            the target type
	 * @param source
	 *            source list
	 * @param map
	 *            map function
	 * @return the mapped list binding
	 * @see FXBindings#mapList(ObservableList, Function)
	 */
	public <A, B> ListBinding<B> onMapList(ObservableList<A> source, Function<A, B> map) {
		ListBinding<B> binding = FXBindings.mapList(source, map);
		this.subscriptions.add(() -> binding.dispose());
		return binding;
	}

	/**
	 * Collect the stream
	 * 
	 * @param <T>
	 *            the source type
	 * @param <R>
	 *            the target type
	 * @param stream
	 *            binding stream
	 * @param collector
	 *            collector
	 * @return the terminal binding
	 * @see BindingStream#collect(FXCollector)
	 */
	public <R extends Binding<?>, T> R onCollect(BindingStream<T> stream, FXCollector<T, R> collector) {
		R binding = stream.collect(collector);
		if (binding != null) {
			this.subscriptions.add(() -> binding.dispose());
		}
		return binding;
	}
}
