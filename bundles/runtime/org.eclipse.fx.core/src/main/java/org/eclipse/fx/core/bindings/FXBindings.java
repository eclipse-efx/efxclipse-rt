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
import java.util.function.DoubleFunction;
import java.util.function.DoubleToIntFunction;
import java.util.function.DoubleToLongFunction;
import java.util.function.DoubleUnaryOperator;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.IntToDoubleFunction;
import java.util.function.IntToLongFunction;
import java.util.function.IntUnaryOperator;
import java.util.function.LongFunction;
import java.util.function.LongToDoubleFunction;
import java.util.function.LongToIntFunction;
import java.util.function.LongUnaryOperator;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.eclipse.fx.core.DisposeableCollector;
import org.eclipse.fx.core.Status;
import org.eclipse.fx.core.Subscription;
import org.eclipse.fx.core.ThreadSynchronize;
import org.eclipse.fx.core.Tuple;
import org.eclipse.fx.core.bindings.internal.BaseBidiPropertyBinding;
import org.eclipse.fx.core.bindings.internal.BindingStreamImpl;
import org.eclipse.fx.core.bindings.internal.ConcatListBinding;
import org.eclipse.fx.core.bindings.internal.ConcatStringBinding;
import org.eclipse.fx.core.bindings.internal.FixListBinding;
import org.eclipse.fx.core.bindings.internal.FlatMapListBinding;
import org.eclipse.fx.core.bindings.internal.FlatMapValueListBinding;
import org.eclipse.fx.core.bindings.internal.MapListBinding;
import org.eclipse.fx.core.bindings.internal.MapObjectBinding;
import org.eclipse.fx.core.bindings.internal.MapSimpleObjectBinding;
import org.eclipse.fx.core.bindings.internal.SyncListBinding;
import org.eclipse.fx.core.bindings.internal.SyncObjectBinding;
import org.eclipse.fx.core.bindings.internal.TenaryBinding;

import javafx.beans.binding.Binding;
import javafx.beans.binding.ListBinding;
import javafx.beans.binding.ObjectBinding;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableBooleanValue;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ListChangeListener.Change;
import javafx.collections.ObservableList;

/**
 * Collection of JavaFX bean bindings.
 *
 * @since 3.0.0
 */
public class FXBindings {

	private static class ConcatListHelper<T> {
		private final ObservableList<T> concatedList = FXCollections.observableArrayList();
		final ObservableList<T> roConcatedList = FXCollections.unmodifiableObservableList(this.concatedList);

		@SafeVarargs
		ConcatListHelper(ObservableList<? extends T>... list) {
			int[] index = new int[list.length];

			for (int i = 0; i < list.length; i++) {
				int j = i;
				index[i] = this.concatedList.size();
				this.concatedList.addAll(list[i]);
				list[i].addListener((Change<? extends T> c) -> {
					while (c.next()) {
						if (c.wasRemoved()) {
							this.concatedList.remove(index[j] + c.getFrom(),
									index[j] + c.getFrom() + c.getRemovedSize());
							for (int k = j + 1; k < index.length; k++) {
								index[k] -= c.getRemoved().size();
							}
						}

						if (c.wasAdded()) {
							this.concatedList.addAll(index[j] + c.getFrom(), c.getAddedSubList());
							for (int k = j + 1; k < index.length; k++) {
								index[k] += c.getAddedSubList().size();
							}
						}
					}
				});
			}
		}
	}

//	public static <E> ObservableList<ObservableList<E>> segmentedList(int segmentSize, ObservableList<E> list) {
//		ObservableList<ObservableList<E>> rv = FXCollections.observableArrayList();
//
//		ObservableList<E> v = null;
//		for( int i = 0; i < list.size(); i++ ) {
//			if( i % segmentSize == 0 ) {
//				rv.add(v = FXCollections.observableArrayList());
//			}
//			if( v != null ) {
//				v.add(list.get(i));
//			}
//		}
//
//		list.addListener( (Change<? extends E> c) -> {
//			while( c.next() ) {
//				if( c.wasReplaced() || c.wasRemoved() ) {
//					for( int i = 0; i < c.getAddedSize(); i++ ) {
//						int ii = i + c.getFrom();
//						int listIndex = ii / segmentSize;
//						ObservableList<E> target;
//						if( rv.size() == listIndex ) {
//							rv.add(target = FXCollections.observableArrayList());
//						} else {
//							target = rv.get(listIndex);
//						}
//
//						if( target.size() == ii % segmentSize ) {
//							target.add(c.getAddedSubList().get(i));
//						} else {
//							target.set(ii % segmentSize, c.getAddedSubList().get(i));
//						}
//					}
//
//					if( c.getAddedSize() < c.getRemovedSize() ) {
//						int removeIdx = -1;
//						for( int i = 0; i < c.getRemovedSize() - c.getAddedSize(); i++ ) {
//							int ii = i + c.getFrom() + c.getAddedSize();
//							int listIndex = ii / segmentSize;
//							if( removeIdx == -1 ) {
//								if( ii % segmentSize == 0 ) {
//									removeIdx = listIndex;
//								} else {
//									rv.get(listIndex).remove(ii % segmentSize);
//								}
//							}
//						}
//
//						if( removeIdx != -1 ) {
//							List<ObservableList<E>> subList = rv.subList(removeIdx, rv.size());
//							List<ObservableList<E>> tmp = new ArrayList<>(subList);
//							subList.clear();
//							tmp.forEach( List::clear );
//						}
//					}
//				} else if( c.wasAdded() ) {
//					for( int i = 0; i < c.getAddedSize(); i++ ) {
//						int ii = i + c.getFrom();
//						int listIndex = ii / segmentSize;
//						ObservableList<E> target;
//						if( rv.size() == listIndex ) {
//							rv.add(target = FXCollections.observableArrayList());
//						} else {
//							target = rv.get(listIndex);
//						}
//
//						if( target.size() == ii % segmentSize ) {
//							target.add(c.getAddedSubList().get(i));
//						}
//					}
//				}
//			}
//		});
//
//		return rv;
//	}

	/**
	 * Create a concatenated list similar to
	 * {@link FXCollections#concat(ObservableList...)}
	 *
	 * @param lists
	 *            the source lists
	 * @return an observable list who is synchronized with the source lists
	 */
	@SafeVarargs
	public static <T> ObservableList<T> concatenatedList(ObservableList<? extends T>... lists) {
		return new ConcatListHelper<>(lists).roConcatedList;
	}

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
	 * Creates a binding depending on the value of the condition
	 *
	 * @param condition
	 *            the condition
	 * @param then
	 *            the value held by the binding if the condition is
	 *            <code>true</code>
	 * @param _else
	 *            the value held by the binding if the condition is
	 *            <code>false</code>
	 * @return the binding
	 */
	public static <T> Binding<T> tenaryBinding(ObservableBooleanValue condition, ObservableValue<T> then,
			ObservableValue<T> _else) {
		return new TenaryBinding<>(condition, then, _else);
	}

	/**
	 * Creates a binding depending on the value of the condition
	 *
	 * @param condition
	 *            the condition
	 * @param then
	 *            the value held by the binding if the condition is
	 *            <code>true</code>
	 * @param _else
	 *            the value held by the binding if the condition is
	 *            <code>false</code>
	 * @return the binding
	 */
	public static <T> Binding<T> tenaryBinding(ObservableBooleanValue condition, T then, T _else) {
		return new TenaryBinding<>(condition, then, _else);
	}

	/**
	 * Concatenates multiple observable lists together.
	 *
	 * @param sources
	 * @return the concatenated list binding
	 */
	@SafeVarargs
	public static <A> ListBinding<A> concat(ObservableList<? extends A>... sources) {
		return new FixListBinding<>(new ConcatListBinding<>(sources));
	}

	/**
	 * Concat all non-null and non empty values with the given delimiter
	 *
	 * @param delimiter
	 *            the delimiter to use
	 * @param sources
	 *            list of observable
	 * @return binding with the source concated
	 */
	@SafeVarargs
	public static <T> StringBinding concat(String delimiter, ObservableValue<T>... sources) {
		return new ConcatStringBinding<>(delimiter, sources);
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
		return new FixListBinding<>(new MapListBinding<A, B>(source, map));
	}

	/**
	 * Flat maps an observable list with observable lists
	 *
	 * @param source
	 * @param map
	 * @return the flat mapped list binding
	 */
	public static <A, B> ListBinding<B> flatMapList(ObservableList<A> source, Function<A, ObservableList<B>> map) {
		return new FixListBinding<>(new FlatMapListBinding<A, B>(source, map));
	}

	/**
	 * Flat maps an observable list with observable values
	 *
	 * @param source
	 * @param map
	 * @return the flat mapped list binding
	 */
	public static <A, B> ListBinding<B> flatMapListValue(ObservableList<A> source,
			Function<A, ObservableValue<B>> map) {
		return new FixListBinding<>(new FlatMapValueListBinding<>(source, map));
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
	public static <T, E> Subscription bindContent(List<T> target, ObservableList<E> sourceList,
			Function<E, T> converterFunction) {
		return bindContent(null, target, sourceList, converterFunction);
	}

	/**
	 * Bind the content to the source list to the target and apply the converter
	 * in between
	 *
	 * @param threadSync
	 *            strategy to synchronize the target on a certain thread, might
	 *            be <code>null</code>
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
	public static <T, E> Subscription bindContent(ThreadSynchronize threadSync, List<T> target,
			ObservableList<E> sourceList, Function<E, T> converterFunction) {
		List<T> list = sourceList.stream().map(converterFunction).collect(Collectors.toList());

		if (threadSync == null) {
			if (target instanceof ObservableList<?>) {
				((ObservableList<T>) target).setAll(list);
			} else {
				target.clear();
				target.addAll(list);
			}
		} else {
			threadSync.syncExec(() -> {
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
					target.addAll(change.getFrom(), transformList(
							change.getList().subList(change.getFrom(), change.getTo()), converterFunction));
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
		if (threadSync == null) {
			fl = l;
			sourceList.addListener(l);
		} else {
			fl = change -> {
				threadSync.syncExec(() -> l.onChanged(change));
			};
			sourceList.addListener(fl);
		}

		return new Subscription() {

			@Override
			public void dispose() {
				if (threadSync == null) {
					sourceList.removeListener(fl);
				} else {
					threadSync.syncExec(() -> sourceList.removeListener(fl));
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

		PaddedListBinding(ThreadSynchronize threadSync, int padding, List<T> target, ObservableList<E> sourceList,
				Function<E, T> converterFunction, IntFunction<T> paddingEntryFactory) {
			this.threadSync = threadSync;
			this.padding = new SimpleIntegerProperty(this, "padding", padding); //$NON-NLS-1$
			this.target = target;
			this.sourceList = sourceList;
			ListChangeListener<E> l = change -> {
				while (change.next()) {
					if (change.wasPermutated()) {
						target.subList(change.getFrom() + getPadding(), change.getTo() + getPadding()).clear();
						target.addAll(change.getFrom() + getPadding(), transformList(
								change.getList().subList(change.getFrom(), change.getTo()), converterFunction));
					} else {
						if (change.wasRemoved()) {
							target.subList(change.getFrom() + getPadding(),
									change.getFrom() + getPadding() + change.getRemovedSize()).clear();
						}
						if (change.wasAdded()) {
							target.addAll(change.getFrom() + getPadding(),
									transformList(change.getAddedSubList(), converterFunction));
						}
					}
				}
			};

			if (threadSync == null) {
				this.l = l;
			} else {
				ListChangeListener<E> ll = change -> {
					threadSync.syncExec(() -> l.onChanged(change));
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
					List<T> paddedObjects = IntStream.range(iOl, iNe).mapToObj(paddingEntryFactory)
							.collect(Collectors.toList());
					target.addAll(iOl, paddedObjects);
				}
			});

			List<T> list = sourceList.stream().map(converterFunction).collect(Collectors.toList());

			if (threadSync == null) {
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
						List<T> t = IntStream.range(0, padding).mapToObj(paddingEntryFactory)
								.collect(Collectors.toList());
						t.addAll(list);
						target.addAll(t);
					}
				}
			} else {
				threadSync.syncExec(() -> {
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
							List<T> t = IntStream.range(0, padding).mapToObj(paddingEntryFactory)
									.collect(Collectors.toList());
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
			if (this.threadSync == null) {
				this.sourceList.remove(this.l);
			} else {
				this.threadSync.syncExec(() -> this.sourceList.removeListener(this.l));
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
	public static <T, E> Subscription bindContent(int padding, List<T> target, ObservableList<E> sourceList,
			Function<E, T> converterFunction, IntFunction<T> paddingEntryFactory) {
		return bindContent(null, padding, target, sourceList, converterFunction, paddingEntryFactory);
	}

	/**
	 * Bind the content to the source list to the target with an optional
	 * padding and apply the converter in between
	 *
	 * @param threadSync
	 *            strategy to synchronize the target on a certain thread, might
	 *            be <code>null</code>
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
	public static <T, E> Subscription bindContent(ThreadSynchronize threadSync, int padding, List<T> target,
			ObservableList<E> sourceList, Function<E, T> converterFunction, IntFunction<T> paddingEntryFactory) {
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
			registerConverter(String.class, Integer.class, s -> Integer.valueOf(Integer.parseInt(s)));
		}

		/**
		 * registers a converter
		 *
		 * @param sourceType
		 * @param targetType
		 * @param converter
		 */
		public static <S, T> void registerConverter(Class<S> sourceType, Class<T> targetType,
				Function<S, T> converter) {
			map.put(new Tuple<Class<?>, Class<?>>(sourceType, targetType), converter);
		}

		/**
		 * retrieves a converter
		 *
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
	 * Bidirectional binding between two properties with conversion. The
	 * conversion is looked up in the {@link ConverterRegistry} if no converter
	 * is found a runtime exception is thrown
	 *
	 * @param target
	 * @param source
	 * @param targetType
	 * @param sourceType
	 * @return a StatusBinding which can be used to watch conversion failures
	 *         and to dispose the whole bidi binding
	 */
	public static <S, T> StatusBinding bindBidirectional(Property<T> target, Property<S> source, Class<T> targetType,
			Class<S> sourceType) {
		// lookup in registry
		Function<T, S> targetToSource = ConverterRegistry.getConverter(targetType, sourceType);
		Function<S, T> sourceToTarget = ConverterRegistry.getConverter(sourceType, targetType);
		if (sourceToTarget == null)
			throw new RuntimeException("Cannot find converter from " + sourceType + " to " + targetType); //$NON-NLS-1$//$NON-NLS-2$
		if (targetToSource == null)
			throw new RuntimeException("Cannot find converter from " + targetType + " to " + sourceType); //$NON-NLS-1$//$NON-NLS-2$
		return bindBidirectional(target, source, targetToSource, sourceToTarget);
	}

	/**
	 * Bidirectional binding between two properties with conversion.
	 *
	 * @param target
	 * @param source
	 * @param targetToSource
	 * @param sourceToTarget
	 * @return a StatusBinding which can be used to watch conversion failures
	 *         and to dispose the whole bidi binding
	 */
	public static <S, T> StatusBinding bindBidirectional(Property<T> target, Property<S> source,
			Function<T, S> targetToSource, Function<S, T> sourceToTarget) {
		return new BaseBidiPropertyBinding(target, source) {

			@Override
			protected void syncTarget() {
				target.setValue(sourceToTarget.apply(source.getValue()));
			}

			@Override
			protected void syncSource() {
				source.setValue(targetToSource.apply(target.getValue()));
			}
		};
	}

	/**
	 * Specialized bindings for {@link IntegerProperty}, {@link FloatProperty},
	 * {@link DoubleProperty}, {@link LongProperty}, {@link BooleanProperty}
	 */
	public static class PrimitivesBindings {
		// ----------------------------------------------------------------------------------------------------------
		// StringProperty
		// ----------------------------------------------------------------------------------------------------------
		/*
		 * Self
		 */
		/**
		 * Bind a properties
		 *
		 * @param target
		 *            the target
		 * @param source
		 *            the source
		 * @param targetToSource
		 *            the conversion from target to source
		 * @param sourceToTarget
		 *            the conversion from source to target
		 * @return the binding
		 */
		public static StatusBinding bindBidirectional(StringProperty target, StringProperty source,
				Function<String, String> targetToSource, Function<String, String> sourceToTarget) {
			return new BaseBidiPropertyBinding(target, source) {

				@Override
				protected void syncTarget() {
					target.set(sourceToTarget.apply(source.get()));
				}

				@Override
				protected void syncSource() {
					source.set(targetToSource.apply(target.get()));
				}
			};
		}

		/*
		 * StringProperty as source
		 */
		/**
		 * Bind a properties
		 *
		 * @param target
		 *            the target
		 * @param source
		 *            the source
		 * @param targetToSource
		 *            the conversion from target to source
		 * @param sourceToTarget
		 *            the conversion from source to target
		 * @return the binding
		 */
		public static <T> StatusBinding bindBidirectional(Property<T> target, StringProperty source,
				Function<T, String> targetToSource, Function<String, T> sourceToTarget) {
			return new BaseBidiPropertyBinding(target, source) {

				@Override
				protected void syncTarget() {
					target.setValue(sourceToTarget.apply(source.get()));
				}

				@Override
				protected void syncSource() {
					source.set(targetToSource.apply(target.getValue()));
				}
			};
		}

		/**
		 * Bind a properties
		 *
		 * @param target
		 *            the target
		 * @param source
		 *            the source
		 * @param targetToSource
		 *            the conversion from target to source
		 * @param sourceToTarget
		 *            the conversion from source to target
		 * @return the binding
		 */
		public static StatusBinding bindBidirectional(IntegerProperty target, StringProperty source,
				IntFunction<String> targetToSource, ToIntFunction<String> sourceToTarget) {
			return new BaseBidiPropertyBinding(target, source) {

				@Override
				protected void syncTarget() {
					target.set(sourceToTarget.applyAsInt(source.get()));
				}

				@Override
				protected void syncSource() {
					source.set(targetToSource.apply(target.get()));
				}
			};
		}

		/**
		 * Bind a properties
		 *
		 * @param target
		 *            the target
		 * @param source
		 *            the source
		 * @param targetToSource
		 *            the conversion from target to source
		 * @param sourceToTarget
		 *            the conversion from source to target
		 * @return the binding
		 */
		public static StatusBinding bindBidirectional(DoubleProperty target, StringProperty source,
				DoubleFunction<String> targetToSource, ToDoubleFunction<String> sourceToTarget) {
			return new BaseBidiPropertyBinding(target, source) {

				@Override
				protected void syncTarget() {
					target.set(sourceToTarget.applyAsDouble(source.get()));
				}

				@Override
				protected void syncSource() {
					source.set(targetToSource.apply(target.get()));
				}
			};
		}

		/**
		 * Bind a properties
		 *
		 * @param target
		 *            the target
		 * @param source
		 *            the source
		 * @param targetToSource
		 *            the conversion from target to source
		 * @param sourceToTarget
		 *            the conversion from source to target
		 * @return the binding
		 */
		public static StatusBinding bindBidirectional(FloatProperty target, StringProperty source,
				DoubleFunction<String> targetToSource, ToDoubleFunction<String> sourceToTarget) {
			return new BaseBidiPropertyBinding(target, source) {

				@Override
				protected void syncTarget() {
					target.set((float) sourceToTarget.applyAsDouble(source.get()));
				}

				@Override
				protected void syncSource() {
					source.set(targetToSource.apply(target.get()));
				}
			};
		}

		/**
		 * Bind a properties
		 *
		 * @param target
		 *            the target
		 * @param source
		 *            the source
		 * @param targetToSource
		 *            the conversion from target to source
		 * @param sourceToTarget
		 *            the conversion from source to target
		 * @return the binding
		 */
		public static StatusBinding bindBidirectional(LongProperty target, StringProperty source,
				LongFunction<String> targetToSource, ToLongFunction<String> sourceToTarget) {
			return new BaseBidiPropertyBinding(target, source) {

				@Override
				protected void syncTarget() {
					target.set(sourceToTarget.applyAsLong(source.get()));
				}

				@Override
				protected void syncSource() {
					source.set(targetToSource.apply(target.get()));
				}
			};
		}

		/**
		 * Bind a properties
		 *
		 * @param target
		 *            the target
		 * @param source
		 *            the source
		 * @param targetToSource
		 *            the conversion from target to source
		 * @param sourceToTarget
		 *            the conversion from source to target
		 * @return the binding
		 */
		public static StatusBinding bindBidirectional(BooleanProperty target, StringProperty source,
				Function<Boolean, String> targetToSource, Predicate<String> sourceToTarget) {
			return new BaseBidiPropertyBinding(target, source) {

				@Override
				protected void syncTarget() {
					target.set(sourceToTarget.test(source.get()));
				}

				@Override
				protected void syncSource() {
					source.set(targetToSource.apply(Boolean.valueOf(target.get())));
				}
			};
		}

		/*
		 * StringProperty as target
		 */
		/**
		 * Bind a properties
		 *
		 * @param target
		 *            the target
		 * @param source
		 *            the source
		 * @param targetToSource
		 *            the conversion from target to source
		 * @param sourceToTarget
		 *            the conversion from source to target
		 * @return the binding
		 */
		public static <T> StatusBinding bindBidirectional(StringProperty target, Property<T> source,
				Function<String, T> targetToSource, Function<T, String> sourceToTarget) {
			return new BaseBidiPropertyBinding(target, source) {

				@Override
				protected void syncTarget() {
					target.setValue(sourceToTarget.apply(source.getValue()));
				}

				@Override
				protected void syncSource() {
					source.setValue(targetToSource.apply(target.get()));
				}
			};
		}

		/**
		 * Bind a properties
		 *
		 * @param target
		 *            the target
		 * @param source
		 *            the source
		 * @param targetToSource
		 *            the conversion from target to source
		 * @param sourceToTarget
		 *            the conversion from source to target
		 * @return the binding
		 */
		public static StatusBinding bindBidirectional(StringProperty target, IntegerProperty source,
				ToIntFunction<String> targetToSource, IntFunction<String> sourceToTarget) {
			return new BaseBidiPropertyBinding(target, source) {

				@Override
				protected void syncTarget() {
					target.setValue(sourceToTarget.apply(source.get()));
				}

				@Override
				protected void syncSource() {
					source.set(targetToSource.applyAsInt(target.get()));
				}
			};
		}

		/**
		 * Bind a properties
		 *
		 * @param target
		 *            the target
		 * @param source
		 *            the source
		 * @param targetToSource
		 *            the conversion from target to source
		 * @param sourceToTarget
		 *            the conversion from source to target
		 * @return the binding
		 */
		public static StatusBinding bindBidirectional(StringProperty target, DoubleProperty source,
				ToDoubleFunction<String> targetToSource, DoubleFunction<String> sourceToTarget) {
			return new BaseBidiPropertyBinding(target, source) {

				@Override
				protected void syncTarget() {
					target.setValue(sourceToTarget.apply(source.get()));
				}

				@Override
				protected void syncSource() {
					source.set(targetToSource.applyAsDouble(target.get()));
				}
			};
		}

		/**
		 * Bind a properties
		 *
		 * @param target
		 *            the target
		 * @param source
		 *            the source
		 * @param targetToSource
		 *            the conversion from target to source
		 * @param sourceToTarget
		 *            the conversion from source to target
		 * @return the binding
		 */
		public static StatusBinding bindBidirectional(StringProperty target, FloatProperty source,
				ToDoubleFunction<String> targetToSource, DoubleFunction<String> sourceToTarget) {
			return new BaseBidiPropertyBinding(target, source) {

				@Override
				protected void syncTarget() {
					target.setValue(sourceToTarget.apply(source.get()));
				}

				@Override
				protected void syncSource() {
					source.set((float) targetToSource.applyAsDouble(target.get()));
				}
			};
		}

		/**
		 * Bind a properties
		 *
		 * @param target
		 *            the target
		 * @param source
		 *            the source
		 * @param targetToSource
		 *            the conversion from target to source
		 * @param sourceToTarget
		 *            the conversion from source to target
		 * @return the binding
		 */
		public static StatusBinding bindBidirectional(StringProperty target, LongProperty source,
				ToLongFunction<String> targetToSource, LongFunction<String> sourceToTarget) {
			return new BaseBidiPropertyBinding(target, source) {

				@Override
				protected void syncTarget() {
					target.setValue(sourceToTarget.apply(source.get()));
				}

				@Override
				protected void syncSource() {
					source.set(targetToSource.applyAsLong(target.get()));
				}
			};
		}

		/**
		 * Bind a properties
		 *
		 * @param target
		 *            the target
		 * @param source
		 *            the source
		 * @param targetToSource
		 *            the conversion from target to source
		 * @param sourceToTarget
		 *            the conversion from source to target
		 * @return the binding
		 */
		public static StatusBinding bindBidirectional(StringProperty target, BooleanProperty source,
				Predicate<String> targetToSource, Function<Boolean, String> sourceToTarget) {
			return new BaseBidiPropertyBinding(target, source) {

				@Override
				protected void syncTarget() {
					target.setValue(sourceToTarget.apply(Boolean.valueOf(source.get())));
				}

				@Override
				protected void syncSource() {
					source.set(targetToSource.test(target.get()));
				}
			};
		}

		// ----------------------------------------------------------------------------------------------------------
		// BooleanProperty
		// ----------------------------------------------------------------------------------------------------------
		/**
		 * Bind a properties
		 *
		 * @param target
		 *            the target
		 * @param source
		 *            the source
		 * @param targetToSource
		 *            the conversion from target to source
		 * @param sourceToTarget
		 *            the conversion from source to target
		 * @return the binding
		 */
		public static <T> StatusBinding bindBidirectional(Property<T> target, BooleanProperty source,
				Predicate<T> targetToSource, Function<Boolean, T> sourceToTarget) {
			return new BaseBidiPropertyBinding(target, source) {
				@Override
				protected void syncTarget() {
					target.setValue(sourceToTarget.apply(Boolean.valueOf(source.get())));
				}

				@Override
				protected void syncSource() {
					source.set(targetToSource.test(target.getValue()));
				}
			};
		}

		/**
		 * Bind a properties
		 *
		 * @param target
		 *            the target
		 * @param source
		 *            the source
		 * @param targetToSource
		 *            the conversion from target to source
		 * @param sourceToTarget
		 *            the conversion from source to target
		 * @return the binding
		 */
		public static <T> StatusBinding bindBidirectional(BooleanProperty target, Property<T> source,
				Function<Boolean, T> targetToSource, Predicate<T> sourceToTarget) {
			return new BaseBidiPropertyBinding(target, source) {
				@Override
				protected void syncTarget() {
					target.set(sourceToTarget.test(source.getValue()));
				}

				@Override
				protected void syncSource() {
					source.setValue(targetToSource.apply(target.getValue()));
				}
			};
		}

		// ----------------------------------------------------------------------------------------------------------
		// IntegerProperty
		// ----------------------------------------------------------------------------------------------------------
		/*
		 * IntegerProperty as Source
		 */
		/**
		 * Bind a properties
		 *
		 * @param target
		 *            the target
		 * @param source
		 *            the source
		 * @param targetToSource
		 *            the conversion from target to source
		 * @param sourceToTarget
		 *            the conversion from source to target
		 * @return the binding
		 */
		public static <T> StatusBinding bindBidirectional(Property<T> target, IntegerProperty source,
				ToIntFunction<T> targetToSource, IntFunction<T> sourceToTarget) {
			return new BaseBidiPropertyBinding(target, source) {

				@Override
				protected void syncTarget() {
					target.setValue(sourceToTarget.apply(source.get()));
				}

				@Override
				protected void syncSource() {
					source.set(targetToSource.applyAsInt(target.getValue()));
				}
			};
		}

		/**
		 * Bind a properties
		 *
		 * @param target
		 *            the target
		 * @param source
		 *            the source
		 * @param targetToSource
		 *            the conversion from target to source
		 * @param sourceToTarget
		 *            the conversion from source to target
		 * @return the binding
		 */
		public static StatusBinding bindBidirectional(DoubleProperty target, IntegerProperty source,
				DoubleToIntFunction targetToSource, IntToDoubleFunction sourceToTarget) {
			return new BaseBidiPropertyBinding(target, source) {

				@Override
				protected void syncTarget() {
					target.set(sourceToTarget.applyAsDouble(source.get()));
				}

				@Override
				protected void syncSource() {
					source.set(targetToSource.applyAsInt(target.get()));
				}
			};
		}

		/**
		 * Bind a properties
		 *
		 * @param target
		 *            the target
		 * @param source
		 *            the source
		 * @param targetToSource
		 *            the conversion from target to source
		 * @param sourceToTarget
		 *            the conversion from source to target
		 * @return the binding
		 */
		public static StatusBinding bindBidirectional(FloatProperty target, IntegerProperty source,
				/* FloatToIntFunction */ DoubleToIntFunction targetToSource,
				/* IntToFloatFunction */IntToDoubleFunction sourceToTarget) {
			return new BaseBidiPropertyBinding(target, source) {

				@Override
				protected void syncTarget() {
					target.set((float) sourceToTarget.applyAsDouble(source.get()));
				}

				@Override
				protected void syncSource() {
					source.set(targetToSource.applyAsInt(target.get()));
				}
			};
		}

		/**
		 * Bind a properties
		 *
		 * @param target
		 *            the target
		 * @param source
		 *            the source
		 * @param targetToSource
		 *            the conversion from target to source
		 * @param sourceToTarget
		 *            the conversion from source to target
		 * @return the binding
		 */
		public static StatusBinding bindBidirectional(LongProperty target, IntegerProperty source,
				LongToIntFunction targetToSource, IntToLongFunction sourceToTarget) {
			return new BaseBidiPropertyBinding(target, source) {

				@Override
				protected void syncTarget() {
					target.set(sourceToTarget.applyAsLong(source.get()));
				}

				@Override
				protected void syncSource() {
					source.set(targetToSource.applyAsInt(target.get()));
				}
			};
		}

		/*
		 * Integer Property as Target
		 */
		/**
		 * Bind a properties
		 *
		 * @param target
		 *            the target
		 * @param source
		 *            the source
		 * @param targetToSource
		 *            the conversion from target to source
		 * @param sourceToTarget
		 *            the conversion from source to target
		 * @return the binding
		 */
		public static <T> StatusBinding bindBidirectional(IntegerProperty target, Property<T> source,
				IntFunction<T> targetToSource, ToIntFunction<T> sourceToTarget) {
			return new BaseBidiPropertyBinding(target, source) {

				@Override
				protected void syncTarget() {
					target.set(sourceToTarget.applyAsInt(source.getValue()));
				}

				@Override
				protected void syncSource() {
					source.setValue(targetToSource.apply(target.get()));
				}
			};
		}

		/**
		 * Bind a properties
		 *
		 * @param target
		 *            the target
		 * @param source
		 *            the source
		 * @param targetToSource
		 *            the conversion from target to source
		 * @param sourceToTarget
		 *            the conversion from source to target
		 * @return the binding
		 */
		public static StatusBinding bindBidirectional(IntegerProperty target, DoubleProperty source,
				IntToDoubleFunction targetToSource, DoubleToIntFunction sourceToTarget) {
			return new BaseBidiPropertyBinding(target, source) {

				@Override
				protected void syncTarget() {
					target.set(sourceToTarget.applyAsInt(source.get()));
				}

				@Override
				protected void syncSource() {
					source.set(targetToSource.applyAsDouble(target.get()));
				}
			};
		}

		/**
		 * Bind a properties
		 *
		 * @param target
		 *            the target
		 * @param source
		 *            the source
		 * @param targetToSource
		 *            the conversion from target to source
		 * @param sourceToTarget
		 *            the conversion from source to target
		 * @return the binding
		 */
		public static StatusBinding bindBidirectional(IntegerProperty target, FloatProperty source,
				/* IntToFloatFunction */IntToDoubleFunction targetToSource,
				/* FloatToIntFunction */ DoubleToIntFunction sourceToTarget) {
			return new BaseBidiPropertyBinding(target, source) {

				@Override
				protected void syncTarget() {
					target.set(sourceToTarget.applyAsInt(source.get()));
				}

				@Override
				protected void syncSource() {
					source.set((float) targetToSource.applyAsDouble(target.get()));
				}
			};
		}

		/**
		 * Bind a properties
		 *
		 * @param target
		 *            the target
		 * @param source
		 *            the source
		 * @param targetToSource
		 *            the conversion from target to source
		 * @param sourceToTarget
		 *            the conversion from source to target
		 * @return the binding
		 */
		public static StatusBinding bindBidirectional(IntegerProperty target, LongProperty source,
				IntToLongFunction targetToSource, LongToIntFunction sourceToTarget) {
			return new BaseBidiPropertyBinding(target, source) {

				@Override
				protected void syncTarget() {
					target.set(sourceToTarget.applyAsInt(source.get()));
				}

				@Override
				protected void syncSource() {
					source.set(targetToSource.applyAsLong(target.get()));
				}
			};
		}

		/*
		 * Self
		 */
		/**
		 * Bind a properties
		 *
		 * @param target
		 *            the target
		 * @param source
		 *            the source
		 * @param targetToSource
		 *            the conversion from target to source
		 * @param sourceToTarget
		 *            the conversion from source to target
		 * @return the binding
		 */
		public static <S> StatusBinding bindBidirectional(IntegerProperty target, IntegerProperty source,
				IntUnaryOperator targetToSource, IntUnaryOperator sourceToTarget) {
			return new BaseBidiPropertyBinding(target, source) {

				@Override
				protected void syncTarget() {
					target.set(sourceToTarget.applyAsInt(source.get()));
				}

				@Override
				protected void syncSource() {
					source.set(targetToSource.applyAsInt(target.get()));
				}
			};
		}

		// ----------------------------------------------------------------------------------------------------------
		// DoubleProperty
		// ----------------------------------------------------------------------------------------------------------
		/*
		 * Double as Source
		 */
		/**
		 * Bind a properties
		 *
		 * @param target
		 *            the target
		 * @param source
		 *            the source
		 * @param targetToSource
		 *            the conversion from target to source
		 * @param sourceToTarget
		 *            the conversion from source to target
		 * @return the binding
		 */
		public static <T> StatusBinding bindBidirectional(Property<T> target, DoubleProperty source,
				ToDoubleFunction<T> targetToSource, DoubleFunction<T> sourceToTarget) {
			return new BaseBidiPropertyBinding(target, source) {

				@Override
				protected void syncTarget() {
					target.setValue(sourceToTarget.apply(source.get()));
				}

				@Override
				protected void syncSource() {
					source.set(targetToSource.applyAsDouble(target.getValue()));
				}
			};
		}
		// Already defined above in the integer area
		// public static StatusBinding bindBidirectional(IntegerProperty target,
		// DoubleProperty source, IntToDoubleFunction targetToSource,
		// DoubleToIntFunction sourceToTarget) {
		// return null;
		// }

		/**
		 * Bind a properties
		 *
		 * @param target
		 *            the target
		 * @param source
		 *            the source
		 * @param targetToSource
		 *            the conversion from target to source
		 * @param sourceToTarget
		 *            the conversion from source to target
		 * @return the binding
		 */
		public static StatusBinding bindBidirectional(FloatProperty target, DoubleProperty source,
				/* FloatToDoubleFunction */ DoubleUnaryOperator targetToSource,
				/* DoubleToFloatFunction */DoubleUnaryOperator sourceToTarget) {
			return new BaseBidiPropertyBinding(target, source) {

				@Override
				protected void syncTarget() {
					target.set((float) sourceToTarget.applyAsDouble(source.get()));
				}

				@Override
				protected void syncSource() {
					source.set(targetToSource.applyAsDouble(target.get()));
				}
			};
		}

		/**
		 * Bind a properties
		 *
		 * @param target
		 *            the target
		 * @param source
		 *            the source
		 * @param targetToSource
		 *            the conversion from target to source
		 * @param sourceToTarget
		 *            the conversion from source to target
		 * @return the binding
		 */
		public static StatusBinding bindBidirectional(LongProperty target, DoubleProperty source,
				LongToDoubleFunction targetToSource, DoubleToLongFunction sourceToTarget) {
			return new BaseBidiPropertyBinding(target, source) {

				@Override
				protected void syncTarget() {
					target.set(sourceToTarget.applyAsLong(source.get()));
				}

				@Override
				protected void syncSource() {
					source.set(targetToSource.applyAsDouble(target.get()));
				}
			};
		}

		/*
		 * Double as Target
		 */
		/**
		 * Bind a properties
		 *
		 * @param target
		 *            the target
		 * @param source
		 *            the source
		 * @param targetToSource
		 *            the conversion from target to source
		 * @param sourceToTarget
		 *            the conversion from source to target
		 * @return the binding
		 */
		public static <T> StatusBinding bindBidirectional(DoubleProperty target, Property<T> source,
				DoubleFunction<T> targetToSource, ToDoubleFunction<T> sourceToTarget) {
			return new BaseBidiPropertyBinding(target, source) {

				@Override
				protected void syncTarget() {
					target.set(sourceToTarget.applyAsDouble(source.getValue()));
				}

				@Override
				protected void syncSource() {
					source.setValue(targetToSource.apply(target.get()));
				}
			};
		}

		// Already defined above integer area
		// public static StatusBinding bindBidirectional(DoubleProperty target,
		// IntegerProperty source, DoubleToIntFunction targetToSource,
		// IntToDoubleFunction sourceToTarget) {
		// return null;
		// }

		/**
		 * Bind a properties
		 *
		 * @param target
		 *            the target
		 * @param source
		 *            the source
		 * @param targetToSource
		 *            the conversion from target to source
		 * @param sourceToTarget
		 *            the conversion from source to target
		 * @return the binding
		 */
		public static StatusBinding bindBidirectional(DoubleProperty target, FloatProperty source,
				/* DoubleToFloatFunction */DoubleUnaryOperator targetToSource,
				/* FloatToDoubleFunction */ DoubleUnaryOperator sourceToTarget) {
			return new BaseBidiPropertyBinding(target, source) {

				@Override
				protected void syncTarget() {
					target.set(sourceToTarget.applyAsDouble(source.get()));
				}

				@Override
				protected void syncSource() {
					source.set((float) targetToSource.applyAsDouble(target.get()));
				}
			};
		}

		/**
		 * Bind a properties
		 *
		 * @param target
		 *            the target
		 * @param source
		 *            the source
		 * @param targetToSource
		 *            the conversion from target to source
		 * @param sourceToTarget
		 *            the conversion from source to target
		 * @return the binding
		 */
		public static StatusBinding bindBidirectional(DoubleProperty target, LongProperty source,
				DoubleToLongFunction targetToSource, LongToDoubleFunction sourceToTarget) {
			return new BaseBidiPropertyBinding(target, source) {

				@Override
				protected void syncTarget() {
					target.set(sourceToTarget.applyAsDouble(source.get()));
				}

				@Override
				protected void syncSource() {
					source.set(targetToSource.applyAsLong(target.get()));
				}
			};
		}

		/*
		 * Self
		 */
		/**
		 * Bind a properties
		 *
		 * @param target
		 *            the target
		 * @param source
		 *            the source
		 * @param targetToSource
		 *            the conversion from target to source
		 * @param sourceToTarget
		 *            the conversion from source to target
		 * @return the binding
		 */
		public static <S> StatusBinding bindBidirectional(DoubleProperty target, DoubleProperty source,
				DoubleUnaryOperator targetToSource, DoubleUnaryOperator sourceToTarget) {
			return new BaseBidiPropertyBinding(target, source) {

				@Override
				protected void syncTarget() {
					target.set(sourceToTarget.applyAsDouble(source.get()));
				}

				@Override
				protected void syncSource() {
					source.set(targetToSource.applyAsDouble(target.get()));
				}
			};
		}

		// ----------------------------------------------------------------------------------------------------------
		// FloatProperty
		// ----------------------------------------------------------------------------------------------------------
		/*
		 * Float as Source
		 */
		/**
		 * Bind a properties
		 *
		 * @param target
		 *            the target
		 * @param source
		 *            the source
		 * @param targetToSource
		 *            the conversion from target to source
		 * @param sourceToTarget
		 *            the conversion from source to target
		 * @return the binding
		 */
		public static <T> StatusBinding bindBidirectional(Property<T> target, FloatProperty source,
				ToDoubleFunction<T> targetToSource, DoubleFunction<T> sourceToTarget) {
			return new BaseBidiPropertyBinding(target, source) {

				@Override
				protected void syncTarget() {
					target.setValue(sourceToTarget.apply(source.get()));
				}

				@Override
				protected void syncSource() {
					source.set((float) targetToSource.applyAsDouble(target.getValue()));
				}
			};
		}
		// Already defined above in the integer area
		// public static StatusBinding bindBidirectional(IntegerProperty target,
		// FloatProperty source, IntToDoubleFunction targetToSource,
		// DoubleToIntFunction sourceToTarget) {
		// return null;
		// }
		// Already defined in double area
		// public static StatusBinding bindBidirectional(DoubleProperty target,
		// FloatProperty source, /* DoubleToDoubleFunction */
		// DoubleUnaryOperator targetToSource, /* FloatToDoubleFunction
		// */DoubleUnaryOperator sourceToTarget) {
		// return null;
		// }

		/**
		 * Bind a properties
		 *
		 * @param target
		 *            the target
		 * @param source
		 *            the source
		 * @param targetToSource
		 *            the conversion from target to source
		 * @param sourceToTarget
		 *            the conversion from source to target
		 * @return the binding
		 */
		public static StatusBinding bindBidirectional(LongProperty target, FloatProperty source,
				/* LongToFloatFunction */ LongToDoubleFunction targetToSource,
				/* FloatToLongFunction */ DoubleToLongFunction sourceToTarget) {
			return new BaseBidiPropertyBinding(target, source) {

				@Override
				protected void syncTarget() {
					target.set(sourceToTarget.applyAsLong(source.get()));
				}

				@Override
				protected void syncSource() {
					source.set((float) targetToSource.applyAsDouble(target.get()));
				}
			};
		}

		/*
		 * Float as Target
		 */
		/**
		 * Bind a properties
		 *
		 * @param target
		 *            the target
		 * @param source
		 *            the source
		 * @param targetToSource
		 *            the conversion from target to source
		 * @param sourceToTarget
		 *            the conversion from source to target
		 * @return the binding
		 */
		public static <T> StatusBinding bindBidirectional(FloatProperty target, Property<T> source,
				DoubleFunction<T> targetToSource, ToDoubleFunction<T> sourceToTarget) {
			return new BaseBidiPropertyBinding(target, source) {

				@Override
				protected void syncTarget() {
					target.set((float) sourceToTarget.applyAsDouble(source.getValue()));
				}

				@Override
				protected void syncSource() {
					source.setValue(targetToSource.apply(target.get()));
				}
			};
		}
		// Already defined above in the integer area
		// public static StatusBinding bindBidirectional(FloatProperty target,
		// source, IntegerProperty DoubleToIntFunction targetToSource,
		// IntToDoubleFunction sourceToTarget) {
		// return null;
		// }
		// Already defined in double area
		// public static StatusBinding bindBidirectional(FloatProperty target,
		// DoubleProperty source, /* FloatToDoubleFunction */DoubleUnaryOperator
		// targetToSource, /* DoubleToDoubleFunction */ DoubleUnaryOperator
		// sourceToTarget) {
		// return null;
		// }

		/**
		 * Bind a properties
		 *
		 * @param target
		 *            the target
		 * @param source
		 *            the source
		 * @param targetToSource
		 *            the conversion from target to source
		 * @param sourceToTarget
		 *            the conversion from source to target
		 * @return the binding
		 */
		public static StatusBinding bindBidirectional(FloatProperty target, LongProperty source,
				/* LongToFloatFunction */ DoubleToLongFunction targetToSource,
				/* FloatToLongFunction */ LongToDoubleFunction sourceToTarget) {
			return new BaseBidiPropertyBinding(target, source) {

				@Override
				protected void syncTarget() {
					target.set((float) sourceToTarget.applyAsDouble(source.get()));
				}

				@Override
				protected void syncSource() {
					source.set(targetToSource.applyAsLong(target.get()));
				}
			};
		}

		/*
		 * Self
		 */
		/**
		 * Bind a properties
		 *
		 * @param target
		 *            the target
		 * @param source
		 *            the source
		 * @param targetToSource
		 *            the conversion from target to source
		 * @param sourceToTarget
		 *            the conversion from source to target
		 * @return the binding
		 */
		public static <S> StatusBinding bindBidirectional(FloatProperty target, FloatProperty source,
				DoubleUnaryOperator targetToSource, DoubleUnaryOperator sourceToTarget) {
			return new BaseBidiPropertyBinding(target, source) {

				@Override
				protected void syncTarget() {
					target.set((float) sourceToTarget.applyAsDouble(source.get()));
				}

				@Override
				protected void syncSource() {
					source.set((float) targetToSource.applyAsDouble(target.get()));
				}
			};
		}

		// ----------------------------------------------------------------------------------------------------------
		// LongProperty
		// ----------------------------------------------------------------------------------------------------------
		/*
		 * Long as Source
		 */
		/**
		 * Bind a properties
		 *
		 * @param target
		 *            the target
		 * @param source
		 *            the source
		 * @param targetToSource
		 *            the conversion from target to source
		 * @param sourceToTarget
		 *            the conversion from source to target
		 * @return the binding
		 */
		public static <T> StatusBinding bindBidirectional(Property<T> target, LongProperty source,
				ToLongFunction<T> targetToSource, LongFunction<T> sourceToTarget) {
			return new BaseBidiPropertyBinding(target, source) {

				@Override
				protected void syncTarget() {
					target.setValue(sourceToTarget.apply(source.get()));
				}

				@Override
				protected void syncSource() {
					source.set(targetToSource.applyAsLong(target.getValue()));
				}
			};
		}
		// Already defined above in the integer area
		// public static StatusBinding bindBidirectional(IntegerProperty target,
		// LongProperty source, IntToDoubleFunction targetToSource,
		// DoubleToIntFunction sourceToTarget) {
		// return null;
		// }
		// Already defined in double area
		// public static StatusBinding bindBidirectional(DoubleProperty target,
		// LongProperty source, /* DoubleToDoubleFunction */ DoubleUnaryOperator
		// targetToSource, /* FloatToDoubleFunction */DoubleUnaryOperator
		// sourceToTarget) {
		// return null;
		// }
		//
		// public static StatusBinding bindBidirectional(FloatProperty target,
		// LongProperty source, /* LongToFloatFunction */ DoubleToLongFunction
		// targetToSource, /* FloatToLongFunction */ LongToDoubleFunction
		// sourceToTarget) {
		// return null;
		// }

		/*
		 * Self
		 */
		/**
		 * Bind a properties
		 *
		 * @param target
		 *            the target
		 * @param source
		 *            the source
		 * @param targetToSource
		 *            the conversion from target to source
		 * @param sourceToTarget
		 *            the conversion from source to target
		 * @return the binding
		 */
		public static <S> StatusBinding bindBidirectional(LongProperty target, LongProperty source,
				LongUnaryOperator targetToSource, LongUnaryOperator sourceToTarget) {
			return new BaseBidiPropertyBinding(target, source) {

				@Override
				protected void syncTarget() {
					target.set(sourceToTarget.applyAsLong(source.get()));
				}

				@Override
				protected void syncSource() {
					source.set(targetToSource.applyAsLong(target.get()));
				}
			};
		}

	}

	/**
	 * Instance version of {@link FXBindings} which tracks the created
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

		private Subscription wrap(Subscription subscription) {
			register(subscription);
			return () -> {
				unregister(subscription);
				subscription.dispose();
			};
		}

		private <B extends Binding<T>, T> B wrap(B binding) {
			if (binding != null) {
				register(() -> binding.dispose());
			}
			return binding;
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
		 * @see FXBindings#bindContent(int, List, ObservableList, Function,
		 *      IntFunction)
		 */
		public <T, E> Subscription onBindContent(int padding, List<T> target, ObservableList<E> sourceList,
				Function<E, T> converterFunction, IntFunction<T> paddingEntryFactory) {
			Subscription subscription = FXBindings.bindContent(padding, target, sourceList, converterFunction,
					paddingEntryFactory);
			return wrap(subscription);
		}

		/**
		 * Bind the content to the source list to the target and apply the
		 * converter in between
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
		 * @see FXBindings#bindContent(List, ObservableList, Function)
		 */
		public <T, E> Subscription onBindContent(List<T> target, ObservableList<E> sourceList,
				Function<E, T> converterFunction) {
			Subscription subscription = FXBindings.bindContent(target, sourceList, converterFunction);
			return wrap(subscription);
		}

		/**
		 * Bind the content to the source list to the target with an optional
		 * padding and apply the converter in between
		 *
		 * @param threadSync
		 *            strategy to synchronize the target on a certain thread,
		 *            might be <code>null</code>
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
		 * @see FXBindings#bindContent(ThreadSynchronize, int, List,
		 *      ObservableList, Function, IntFunction)
		 */
		public <T, E> Subscription onBindContent(ThreadSynchronize threadSync, int padding, List<T> target,
				ObservableList<E> sourceList, Function<E, T> converterFunction, IntFunction<T> paddingEntryFactory) {
			Subscription subscription = FXBindings.bindContent(threadSync, padding, target, sourceList,
					converterFunction, paddingEntryFactory);
			return wrap(subscription);
		}

		/**
		 * Bind the content to the source list to the target and apply the
		 * converter in between
		 *
		 * @param threadSync
		 *            strategy to synchronize the target on a certain thread,
		 *            might be <code>null</code>
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
		 * @see FXBindings#bindContent(ThreadSynchronize, List, ObservableList,
		 *      Function)
		 */
		public <T, E> Subscription onBindContent(ThreadSynchronize threadSync, List<T> target,
				ObservableList<E> sourceList, Function<E, T> converterFunction) {
			Subscription subscription = FXBindings.bindContent(threadSync, target, sourceList, converterFunction);
			return wrap(subscription);
		}

		/**
		 * Concatenates multiple observable lists together.
		 *
		 * @param sources
		 * @return the concatenated list binding
		 * @see FXBindings#concat(ObservableList...)
		 */
		public <A> ListBinding<A> onConcat(@SuppressWarnings("unchecked") ObservableList<? extends A>... sources) {
			ListBinding<A> binding = FXBindings.concat(sources);
			return wrap(binding);
		}

		/**
		 * Concat all non-null and non empty values with the given delimiter
		 *
		 * @param delimiter
		 *            the delimiter to use
		 * @param sources
		 *            list of observable
		 * @return binding with the source concated
		 * @see FXBindings#concat(String, ObservableValue...)
		 */
		public <T> StringBinding onConcat(String delimiter,
				@SuppressWarnings("unchecked") ObservableValue<T>... sources) {
			StringBinding binding = FXBindings.concat(delimiter, sources);
			return wrap(binding);
		}

		/**
		 * Maps an observable value to another observable value
		 *
		 * @param source
		 * @param map
		 * @return the mapped value binding
		 * @see FXBindings#flatMap(ObservableValue, Function)
		 */
		public <A, B> ObjectBinding<B> onFlatMap(ObservableValue<A> source, Function<A, ObservableValue<B>> map) {
			ObjectBinding<B> binding = FXBindings.flatMap(source, map);
			return wrap(binding);
		}

		/**
		 * Flat maps an observable list with observable lists
		 *
		 * @param source
		 * @param map
		 * @return the flat mapped list binding
		 * @see FXBindings#flatMapList(ObservableList, Function)
		 */
		public <A, B> ListBinding<B> onFlatMapList(ObservableList<A> source, Function<A, ObservableList<B>> map) {
			ListBinding<B> binding = FXBindings.flatMapList(source, map);
			return wrap(binding);
		}

		/**
		 * Flat maps an observable list with observable values
		 *
		 * @param source
		 * @param map
		 * @return the flat mapped list binding
		 * @see FXBindings#flatMapListValue(ObservableList, Function)
		 */
		public <A, B> ListBinding<B> onFlatMapListValue(ObservableList<A> source, Function<A, ObservableValue<B>> map) {
			ListBinding<B> binding = FXBindings.flatMapListValue(source, map);
			return wrap(binding);
		}

		/**
		 * allows to sync between threads
		 *
		 * @param source
		 * @param thread
		 * @return the synced list binding
		 * @see FXBindings#syncList(ObservableList, ThreadSynchronize)
		 */
		public <A> ListBinding<A> onSyncList(ObservableList<A> source, ThreadSynchronize thread) {
			ListBinding<A> binding = FXBindings.syncList(source, thread);
			return wrap(binding);
		}

		/**
		 * allows to sync between threads
		 *
		 * @param source
		 * @param thread
		 * @return the synced object binding
		 * @see FXBindings#sync(ObservableValue, ThreadSynchronize)
		 */
		public <A> ObjectBinding<A> onSync(ObservableValue<A> source, ThreadSynchronize thread) {
			ObjectBinding<A> binding = FXBindings.sync(source, thread);
			return wrap(binding);
		}

		/**
		 * Creates a binding depending on the value of the condition
		 *
		 * @param condition
		 *            the condition
		 * @param then
		 *            the value held by the binding if the condition is
		 *            <code>true</code>
		 * @param _else
		 *            the value held by the binding if the condition is
		 *            <code>false</code>
		 * @return the binding
		 * @see FXBindings#tenaryBinding(ObservableBooleanValue,
		 *      ObservableValue, ObservableValue)
		 */
		public <T> Binding<T> onTenaryBinding(ObservableBooleanValue condition, ObservableValue<T> then,
				ObservableValue<T> _else) {
			Binding<T> binding = FXBindings.tenaryBinding(condition, then, _else);
			return wrap(binding);
		}

		/**
		 * Creates a binding depending on the value of the condition
		 *
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
			return wrap(binding);
		}

		/**
		 * Maps an observable value
		 *
		 * @param source
		 *            source value
		 * @param map
		 *            map function
		 * @return the mapped value binding
		 * @see FXBindings#map(ObservableValue, Function)
		 */
		public <A, B> ObjectBinding<B> onMap(ObservableValue<A> source, Function<A, B> map) {
			ObjectBinding<B> binding = FXBindings.map(source, map);
			return wrap(binding);
		}

		/**
		 * Maps an observable list
		 *
		 * @param source
		 *            source list
		 * @param map
		 *            map function
		 * @return the mapped list binding
		 * @see FXBindings#mapList(ObservableList, Function)
		 */
		public <A, B> ListBinding<B> onMapList(ObservableList<A> source, Function<A, B> map) {
			ListBinding<B> binding = FXBindings.mapList(source, map);
			return wrap(binding);
		}

		/**
		 * Collect the stream
		 *
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
				register(() -> binding.dispose());
			}
			return binding;
		}
	}
}