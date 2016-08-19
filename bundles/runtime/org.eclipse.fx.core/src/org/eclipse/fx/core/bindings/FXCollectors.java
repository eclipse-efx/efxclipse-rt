/*******************************************************************************
 * Copyright (c) 2016 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Christoph Caks<ccaks@bestsolution.at> - initial API and implementation
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core.bindings;

import java.util.function.Function;
import java.util.stream.Stream;

import org.eclipse.fx.core.bindings.internal.BindingStreamImpl;
import org.eclipse.fx.core.bindings.internal.BindingStreamImpl.StreamBinding;

import javafx.beans.binding.ObjectBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Standard collectors for {@link BindingStream#collect(FXCollector)}
 *
 * @since 3.0
 */
public class FXCollectors {
	/**
	 * Construct a property
	 *
	 * @param map
	 *            map the source to the property
	 * @return the property
	 */
	@SuppressWarnings("null")
	public static <T, S> FXCollector<T, Property<S>> toProperty(Function<T, Property<S>> map) {
		return stream -> {
			// Remember the binding to prevent GC to clean it up
			ObjectBinding<Property<S>> binding = stream.mapNoObservable(map).collect(toBinding());
			ObjectProperty<S> rv = new SimpleObjectProperty<S>() {
				@SuppressWarnings("unused")
				private ObjectBinding<Property<S>> b = binding;
			};

			if (binding.get() != null) {
				rv.bindBidirectional(binding.get());
			}

			binding.addListener((o, ol, ne) -> {
				if (ol != null) {
					rv.unbindBidirectional(ol);
				}

				if (ne != null) {
					rv.bindBidirectional(ne);
				} else {
					rv.set((S) null);
				}
			});

			return rv;
		};
	}

	/**
	 * Construct a property
	 *
	 * @param map
	 *            map the source to the property
	 * @return the property
	 */
	@SuppressWarnings("null")
	public static <T, S> FXCollector<T, ObjectProperty<S>> toObjectProperty(Function<T, ObjectProperty<S>> map) {
		return stream -> {
			// Remember the binding to prevent GC to clean it up
			ObjectBinding<ObjectProperty<S>> binding = stream.mapNoObservable(map).collect(toBinding());
			ObjectProperty<S> rv = new SimpleObjectProperty<S>() {
				@SuppressWarnings("unused")
				private ObjectBinding<ObjectProperty<S>> b = binding;
			};

			if (binding.get() != null) {
				rv.bindBidirectional(binding.get());
			}

			binding.addListener((o, ol, ne) -> {
				if (ol != null) {
					rv.unbindBidirectional(ol);
				}

				if (ne != null) {
					rv.bindBidirectional(ne);
				} else {
					rv.set((S) null);
				}
			});

			return rv;
		};
	}

	/**
	 * Construct a property
	 *
	 * @param map
	 *            map the source to the property
	 * @return the property
	 */
	public static <T> FXCollector<T, StringProperty> toStringProperty(Function<T, StringProperty> map) {
		return stream -> {
			ObjectBinding<StringProperty> binding = stream.mapNoObservable(map).collect(toBinding());
			StringProperty rv = new SimpleStringProperty() {
				@SuppressWarnings("unused")
				private ObjectBinding<StringProperty> b = binding;
			};

			if (binding.get() != null) {
				rv.bindBidirectional(binding.get());
			}

			binding.addListener((o, ol, ne) -> {
				if (ol != null) {
					rv.unbindBidirectional(ol);
				}

				if (ne != null) {
					rv.bindBidirectional(ne);
				} else {
					rv.set(null);
				}
			});

			return rv;
		};
	}

	/**
	 * Construct a property
	 *
	 * @param map
	 *            map the source to the property
	 * @return the property
	 */
	public static <T> FXCollector<T, DoubleProperty> toDoubleProperty(Function<T, DoubleProperty> map) {
		return stream -> {
			ObjectBinding<DoubleProperty> binding = stream.mapNoObservable(map).collect(toBinding());
			DoubleProperty rv = new SimpleDoubleProperty() {
				@SuppressWarnings("unused")
				private ObjectBinding<DoubleProperty> b = binding;
			};

			if (binding.get() != null) {
				rv.bindBidirectional(binding.get());
			}

			binding.addListener((o, ol, ne) -> {
				if (ol != null) {
					rv.unbindBidirectional(ol);
				}

				if (ne != null) {
					rv.bindBidirectional(ne);
				} else {
					rv.set(0.0);
				}
			});

			return rv;
		};
	}

	/**
	 * Construct a property
	 *
	 * @param map
	 *            map the source to the property
	 * @return the property
	 */
	public static <T> FXCollector<T, BooleanProperty> toBooleanProperty(Function<T, BooleanProperty> map) {
		return stream -> {
			ObjectBinding<BooleanProperty> binding = stream.mapNoObservable(map).collect(toBinding());
			BooleanProperty rv = new SimpleBooleanProperty() {
				@SuppressWarnings("unused")
				private ObjectBinding<BooleanProperty> b = binding;
			};

			if (binding.get() != null) {
				rv.bindBidirectional(binding.get());
			}

			binding.addListener((o, ol, ne) -> {
				if (ol != null) {
					rv.unbindBidirectional(ol);
				}

				if (ne != null) {
					rv.bindBidirectional(ne);
				} else {
					rv.set(false);
				}
			});

			return rv;
		};
	}

	/**
	 * Construct a property
	 *
	 * @param map
	 *            map the source to the property
	 * @return the property
	 */
	public static <T> FXCollector<T, FloatProperty> toFloatProperty(Function<T, FloatProperty> map) {
		return stream -> {
			ObjectBinding<FloatProperty> binding = stream.mapNoObservable(map).collect(toBinding());
			FloatProperty rv = new SimpleFloatProperty() {
				@SuppressWarnings("unused")
				private ObjectBinding<FloatProperty> b = binding;
			};

			if (binding.get() != null) {
				rv.bindBidirectional(binding.get());
			}

			binding.addListener((o, ol, ne) -> {
				if (ol != null) {
					rv.unbindBidirectional(ol);
				}

				if (ne != null) {
					rv.bindBidirectional(ne);
				} else {
					rv.set(0.0f);
				}
			});

			return rv;
		};
	}

	/**
	 * Construct a property
	 *
	 * @param map
	 *            map the source to the property
	 * @return the property
	 */
	public static <T> FXCollector<T, LongProperty> toLongProperty(Function<T, LongProperty> map) {
		return stream -> {
			ObjectBinding<LongProperty> binding = stream.mapNoObservable(map).collect(toBinding());
			LongProperty rv = new SimpleLongProperty() {
				@SuppressWarnings("unused")
				private ObjectBinding<LongProperty> b = binding;
			};

			if (binding.get() != null) {
				rv.bindBidirectional(binding.get());
			}

			binding.addListener((o, ol, ne) -> {
				if (ol != null) {
					rv.unbindBidirectional(ol);
				}

				if (ne != null) {
					rv.bindBidirectional(ne);
				} else {
					rv.set(0);
				}
			});

			return rv;
		};
	}

	/**
	 * Construct a property
	 *
	 * @param map
	 *            map the source to the property
	 * @return the property
	 */
	public static <T> FXCollector<T, IntegerProperty> toIntegerProperty(Function<T, IntegerProperty> map) {
		return stream -> {
			ObjectBinding<IntegerProperty> binding = stream.mapNoObservable(map).collect(toBinding());
			IntegerProperty rv = new SimpleIntegerProperty() {
				@SuppressWarnings("unused")
				private ObjectBinding<IntegerProperty> b = binding;
			};

			if (binding.get() != null) {
				rv.bindBidirectional(binding.get());
			}

			binding.addListener((o, ol, ne) -> {
				if (ol != null) {
					rv.unbindBidirectional(ol);
				}

				if (ne != null) {
					rv.bindBidirectional(ne);
				} else {
					rv.set(0);
				}
			});

			return rv;
		};
	}

	/**
	 * creates the {@link ObjectBinding}
	 * @return the collector
	 */
	public static <T> FXCollector<T, ObjectBinding<T>> toBinding() {
		return stream -> {
			return new StreamBinding<>(((BindingStreamImpl<T>) stream).base, ((BindingStreamImpl<T>) stream).path);
		};
	}

	/**
	 * create the {@link ObjectBinding} but replaces the null value with the provided value
	 * @param nullReplacement the replacement for a null value
	 * @return the collector
	 */
	public static <T> FXCollector<T, ObjectBinding<T>> toBinding(T nullReplacement) {
		return stream -> {
			ObjectBinding<T> b = stream.collect(FXCollectors.toBinding());

			ObjectBinding<T> rv = new ObjectBinding<T>() {
				{
					bind(b);
				}
				@Override
				protected T computeValue() {
					return b.get() == null ? nullReplacement : b.get();
				}
			};

			return rv;
		};
	}
}
