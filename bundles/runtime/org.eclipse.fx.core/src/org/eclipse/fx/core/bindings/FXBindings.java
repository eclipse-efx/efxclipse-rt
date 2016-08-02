/*******************************************************************************
 * Copyright (c) 2016 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Christoph Caks<ccaks@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core.bindings;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.eclipse.fx.core.Status;
import org.eclipse.fx.core.Subscription;
import org.eclipse.fx.core.ThreadSynchronize;
import org.eclipse.fx.core.Tuple;
import org.eclipse.fx.core.bindings.internal.BidiPropertyBinding;
import org.eclipse.fx.core.bindings.internal.BindingStreamImpl;
import org.eclipse.fx.core.bindings.internal.ConcatListBinding;
import org.eclipse.fx.core.bindings.internal.FlatMapListBinding;
import org.eclipse.fx.core.bindings.internal.FlatMapValueListBinding;
import org.eclipse.fx.core.bindings.internal.MapListBinding;
import org.eclipse.fx.core.bindings.internal.MapObjectBinding;
import org.eclipse.fx.core.bindings.internal.MapSimpleObjectBinding;
import org.eclipse.fx.core.bindings.internal.SyncListBinding;
import org.eclipse.fx.core.bindings.internal.SyncObjectBinding;

import com.sun.javafx.binding.BidirectionalBinding;

import javafx.beans.binding.Binding;
import javafx.beans.binding.ListBinding;
import javafx.beans.binding.ObjectBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

/**
 * Collection of JavaFX bean bindings.
 *
 * @since 3.0.0
 */
public class FXBindings {

	/**
	 * allows to apply multiple functions before creating a Binding. useful for
	 * feature paths
	 *
	 * @param source
	 * @return an ObjectBinding
	 */
	public static <T> BindingStream<T> bindStream(ObservableValue<T> source) {
		return new BindingStreamImpl<>(source);
	}

	/**
	 * Concatenates multiple observable lists together.
	 *
	 * @param sources
	 * @return the concatenated list binding
	 */
	@SuppressWarnings("unchecked")
	public static <A> ListBinding<A> concat(ObservableList<A>... sources) {
		return new ConcatListBinding<>(sources);
	}

	/**
	 * Maps an observable value to another observable value
	 *
	 * @param source
	 * @param map
	 * @return the mapped value binding
	 */
	public static <A, B> ObjectBinding<B> flatMap(ObservableValue<A> source, Function<A, ObservableValue<B>> map) {
		return new MapObjectBinding<>(source, map);
	}

	/**
	 * Maps an observable value
	 *
	 * @param source
	 * @param map
	 * @return the mapped value binding
	 */
	public static <A, B> ObjectBinding<B> map(ObservableValue<A> source, Function<A, B> map) {
		return new MapSimpleObjectBinding<>(source, map);
	}

	/**
	 * Maps an observable list
	 *
	 * @param source
	 * @param map
	 * @return the mapped list binding
	 */
	public static <A, B> ListBinding<B> mapList(ObservableList<A> source, Function<A, B> map) {
		return new MapListBinding<A, B>(source, map);
	}

	/**
	 * Flat maps an observable list with observable lists
	 *
	 * @param source
	 * @param map
	 * @return the flat mapped list binding
	 */
	public static <A, B> ListBinding<B> flatMapList(ObservableList<A> source, Function<A, ObservableList<B>> map) {
		return new FlatMapListBinding<A, B>(source, map);
	}

	/**
	 * Flat maps an observable list with observable values
	 *
	 * @param source
	 * @param map
	 * @return the flat mapped list binding
	 */
	public static <A, B> ListBinding<B> flatMapListValue(ObservableList<A> source, Function<A, ObservableValue<B>> map) {
		return new FlatMapValueListBinding<>(source, map);
	}

	/**
	 * allows to sync between threads
	 *
	 * @param source
	 * @param thread
	 * @return the synced list binding
	 */
	public static <A> ListBinding<A> syncList(ObservableList<A> source, ThreadSynchronize thread) {
		return new SyncListBinding<>(source, thread);
	}

	/**
	 * allows to sync between threads
	 *
	 * @param source
	 * @param thread
	 * @return the synced object binding
	 */
	public static <A> ObjectBinding<A> sync(ObservableValue<A> source, ThreadSynchronize thread) {
		return new SyncObjectBinding<>(source, thread);
	}

	/**
	 * Bind the content to the source list to the target and apply the converter
	 * in between
	 *
	 * @param target
	 *            the target list
	 * @param sourceList
	 *            the source list
	 * @param converterFunction
	 *            the function used to convert
	 * @param <T>
	 *            the target type
	 * @param <E>
	 *            the source type
	 * @return the subscription to dispose the binding
	 */
	public static <T, E> Subscription bindContent(List<T> target, ObservableList<E> sourceList, Function<E, T> converterFunction) {
		return bindContent(null, target, sourceList, converterFunction);
	}

	/**
	 * Bind the content to the source list to the target and apply the converter
	 * in between
	 *
	 * @param threadSync
	 *            strategy to synchronize the target on a certain thread, might be <code>null</code>
	 * @param target
	 *            the target list
	 * @param sourceList
	 *            the source list
	 * @param converterFunction
	 *            the function used to convert
	 * @param <T>
	 *            the target type
	 * @param <E>
	 *            the source type
	 * @return the subscription to dispose the binding
	 */
	public static <T, E> Subscription bindContent(ThreadSynchronize threadSync, List<T> target, ObservableList<E> sourceList, Function<E, T> converterFunction) {
		List<T> list = sourceList.stream().map(converterFunction).collect(Collectors.toList());

		if( threadSync == null ) {
			if (target instanceof ObservableList<?>) {
				((ObservableList<T>) target).setAll(list);
			} else {
				target.clear();
				target.addAll(list);
			}
		} else {
			threadSync.asyncExec(() -> {
				if (target instanceof ObservableList<?>) {
					((ObservableList<T>) target).setAll(list);
				} else {
					target.clear();
					target.addAll(list);
				}
			});
		}
		ListChangeListener<E> fl;

		ListChangeListener<E> l = change -> {
			while (change.next()) {
				if (change.wasPermutated()) {
					target.subList(change.getFrom(), change.getTo()).clear();
					target.addAll(change.getFrom(), transformList(change.getList().subList(change.getFrom(), change.getTo()), converterFunction));
				} else {
					if (change.wasRemoved()) {
						target.subList(change.getFrom(), change.getFrom() + change.getRemovedSize()).clear();
					}
					if (change.wasAdded()) {
						target.addAll(change.getFrom(), transformList(change.getAddedSubList(), converterFunction));
					}
				}
			}
		};
		if( threadSync == null ) {
			fl = l;
			sourceList.addListener(l);
		} else {
			fl = change -> {
				threadSync.asyncExec( () -> l.onChanged(change) );
			};
			sourceList.addListener( fl );
		}

		return new Subscription() {

			@Override
			public void dispose() {
				if( threadSync == null ) {
					sourceList.removeListener(fl);
				} else {
					threadSync.asyncExec(fl, sourceList::removeListener);
				}
			}
		};
	}

	static class PaddedListBinding<T, E> implements Subscription {
		final ObservableList<E> sourceList;
		final IntegerProperty padding;
		final ListChangeListener<E> l;
		final IntFunction<T> paddingEntryFactory;
		final List<T> target;
		final ThreadSynchronize threadSync;

		PaddedListBinding(ThreadSynchronize threadSync, int padding, List<T> target, ObservableList<E> sourceList, Function<E, T> converterFunction, IntFunction<T> paddingEntryFactory) {
			this.threadSync = threadSync;
			this.padding = new SimpleIntegerProperty(this, "padding", padding); //$NON-NLS-1$
			this.target = target;
			this.sourceList = sourceList;
			ListChangeListener<E> l = change -> {
				while (change.next()) {
					if (change.wasPermutated()) {
						target.subList(change.getFrom() + getPadding(), change.getTo() + getPadding()).clear();
						target.addAll(change.getFrom() + getPadding(), transformList(change.getList().subList(change.getFrom(), change.getTo()), converterFunction));
					} else {
						if (change.wasRemoved()) {
							target.subList(change.getFrom() + getPadding(), change.getFrom() + getPadding() + change.getRemovedSize()).clear();
						}
						if (change.wasAdded()) {
							target.addAll(change.getFrom() + getPadding(), transformList(change.getAddedSubList(), converterFunction));
						}
					}
				}
			};

			if( threadSync == null ) {
				this.l = l;
			} else {
				ListChangeListener<E> ll = change -> {
					threadSync.asyncExec( () -> l.onChanged(change) );
				};
				this.l = ll;
			}

			this.sourceList.addListener(this.l);
			this.paddingEntryFactory = paddingEntryFactory;
			this.padding.addListener((o, ol, ne) -> {
				int iOl = ol == null ? 0 : ol.intValue();
				int iNe = ne == null ? 0 : ne.intValue();

				if (iOl > iNe) {
					target.subList(iNe, iOl).clear();
				} else if (iOl < iNe) {
					List<T> paddedObjects = IntStream.range(iOl, iNe).mapToObj(paddingEntryFactory).collect(Collectors.toList());
					target.addAll(iOl, paddedObjects);
				}
			});

			List<T> list = sourceList.stream().map(converterFunction).collect(Collectors.toList());

			if( threadSync == null ) {
				if (padding == 0) {
					if (target instanceof ObservableList<?>) {
						((ObservableList<T>) target).setAll(list);
					} else {
						target.clear();
						target.addAll(list);
					}
				} else {
					if (!target.isEmpty()) {
						target.subList(padding, target.size()).clear();
						target.addAll(padding, list);
					} else {
						List<T> t = IntStream.range(0, padding).mapToObj(paddingEntryFactory).collect(Collectors.toList());
						t.addAll(list);
						target.addAll(t);
					}
				}
			} else {
				threadSync.asyncExec(() -> {
					if (padding == 0) {
						if (target instanceof ObservableList<?>) {
							((ObservableList<T>) target).setAll(list);
						} else {
							target.clear();
							target.addAll(list);
						}
					} else {
						if (!target.isEmpty()) {
							target.subList(padding, target.size()).clear();
							target.addAll(padding, list);
						} else {
							List<T> t = IntStream.range(0, padding).mapToObj(paddingEntryFactory).collect(Collectors.toList());
							t.addAll(list);
							target.addAll(t);
						}
					}
				});
			}
		}

		/**
		 * @return padding for the target list
		 */
		public final IntegerProperty paddingProperty() {
			return this.padding;
		}

		/**
		 * @return the padding
		 */
		public final int getPadding() {
			return this.paddingProperty().get();
		}

		/**
		 * Set a new padding
		 *
		 * @param padding
		 *            a new padding
		 */
		public final void setPadding(final int padding) {
			this.paddingProperty().set(padding);
		}

		@Override
		public void dispose() {
			if( this.threadSync == null ) {
				this.sourceList.remove(this.l);
			} else {
				this.threadSync.asyncExec(this.l, this.sourceList::remove);
			}

		}
	}

	/**
	 * Bind the content to the source list to the target with an optional
	 * padding and apply the converter in between
	 *
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
	 */
	public static <T, E> Subscription bindContent(int padding, List<T> target, ObservableList<E> sourceList, Function<E, T> converterFunction, IntFunction<T> paddingEntryFactory) {
		return bindContent(null, padding, target, sourceList, converterFunction, paddingEntryFactory);
	}

	/**
	 * Bind the content to the source list to the target with an optional
	 * padding and apply the converter in between
	 *
	 * @param threadSync
	 *            strategy to synchronize the target on a certain thread, might be <code>null</code>
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
	 */
	public static <T, E>Subscription bindContent(ThreadSynchronize threadSync, int padding, List<T> target, ObservableList<E> sourceList, Function<E, T> converterFunction, IntFunction<T> paddingEntryFactory) {
		return new PaddedListBinding<>(threadSync, padding, target, sourceList, converterFunction, paddingEntryFactory);
	}

	static <T, E> List<T> transformList(List<? extends E> list, Function<E, T> converterFunction) {
		return list.stream().map(converterFunction).collect(Collectors.toList());
	}

	/**
	 * Registry to track and lookup globally available converters
	 *
	 */
	public static class ConverterRegistry {

		private static Map<Tuple<Class<?>, Class<?>>, Function<?, ?>> map = new HashMap<>();

		static {
			// TODO add some default mappings here
			registerConverter(Integer.class, String.class, i -> i.toString());
			registerConverter(String.class, Integer.class, s -> Integer.parseInt(s));
		}

		/**
		 * registers a converter
		 * @param sourceType
		 * @param targetType
		 * @param converter
		 */
		public static <S, T> void registerConverter(Class<S> sourceType, Class<T> targetType, Function<S, T> converter) {
			map.put(new Tuple<Class<?>, Class<?>>(sourceType, targetType), converter);
		}

		/**
		 * retrieves a converter
		 * @param sourceType
		 * @param targetType
		 * @return the converter or <code>null</code> if none was found
		 */
		@SuppressWarnings("unchecked")
		public static <S, T> Function<S, T> getConverter(Class<S> sourceType, Class<T> targetType) {
			return (Function<S, T>) map.get(new Tuple<Class<S>, Class<T>>(sourceType, targetType));
		}
	}

	/**
	 * Binding status.
	 *
	 */
	public static interface StatusBinding extends Binding<Status> {
		// empty
	}

	/**
	 * Bidirectional binding between two properties with conversion.
	 * The conversion is looked up in the {@link ConverterRegistry}
	 * if no converter is found a runtime exception is thrown
	 * @param target
	 * @param source
	 * @param targetType
	 * @param sourceType
	 * @return a StatusBinding which can be used to watch conversion failures and to dispose the whole bidi binding
	 */
	public static <S, T> StatusBinding bindBidirectional(Property<T> target, Property<S> source, Class<T> targetType, Class<S> sourceType) {
		// lookup in registry
		Function<T, S> targetToSource = ConverterRegistry.getConverter(targetType, sourceType);
		Function<S, T> sourceToTarget = ConverterRegistry.getConverter(sourceType, targetType);
		if (sourceToTarget == null) throw new RuntimeException("Cannot find converter from " + sourceType + " to " + targetType);  //$NON-NLS-1$//$NON-NLS-2$
		if (targetToSource == null) throw new RuntimeException("Cannot find converter from " + targetType + " to " + sourceType);  //$NON-NLS-1$//$NON-NLS-2$
		return bindBidirectional(target, source, targetToSource, sourceToTarget);
	}

	/**
	 * Bidirectional binding between two properties with conversion.
	 * @param target
	 * @param source
	 * @param targetToSource
	 * @param sourceToTarget
	 * @return a StatusBinding which can be used to watch conversion failures and to dispose the whole bidi binding
	 */
	public static <S, T> StatusBinding bindBidirectional(Property<T> target, Property<S> source, Function<T, S> targetToSource, Function<S, T> sourceToTarget) {
		return new BidiPropertyBinding<>(target, source, targetToSource, sourceToTarget);
	}

}

