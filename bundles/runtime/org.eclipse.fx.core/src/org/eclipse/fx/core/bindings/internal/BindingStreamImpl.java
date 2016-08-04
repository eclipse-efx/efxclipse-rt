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
package org.eclipse.fx.core.bindings.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

import org.eclipse.fx.core.bindings.BindingStream;

import javafx.beans.Observable;
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
import javafx.beans.value.ObservableValue;

@SuppressWarnings("javadoc")
public class BindingStreamImpl<T> implements BindingStream<T> {

	private ObservableValue<?> base;
	private List<StreamStep<?, ?>> path;


	private interface StreamStep<T, S> {
		S apply(T cur, Set<Observable> toTrack);
	}

	private static class MapValue<T, S> implements StreamStep<T, S> {
		private final Function<T, ObservableValue<S>> map;
		public MapValue(Function<T, ObservableValue<S>> map) {
			this.map = map;
		}
		@Override
		public S apply(T cur, Set<Observable> toTrack) {
			if( cur == null ) {
				return (S)null;
			}
			ObservableValue<S> r = this.map.apply((T)cur);
			toTrack.add(r);
			return r.getValue();
		}
	}

	private static class MapNoObservable<T, S> implements StreamStep<T, S> {
		private final Function<T, S> map;
		public MapNoObservable(Function<T, S> map) {
			this.map = map;
		}
		@Override
		public S apply(T cur, Set<Observable> toTrack) {
			if( cur == null ) {
				return (S)null;
			}
			return this.map.apply((T)cur);
		}
	}

	private static class StreamBinding<T> extends ObjectBinding<T> {

		private ObservableValue<?> base;
		private List<StreamStep<?, ?>> path;

		private Set<Observable> curToTrack;

		public StreamBinding(ObservableValue<?> base, List<StreamStep<?, ?>> path) {
			this.base = base;
			this.path = new ArrayList<>(path);
			bind(base);
			curToTrack = Collections.singleton(this.base);
		}

		@Override
		public void dispose() {
			if (this.curToTrack != null) {
				unbind(this.curToTrack.toArray(new Observable[0]));
			}
			super.dispose();
		}

		@SuppressWarnings({"rawtypes", "unchecked"})
		@Override
		protected T computeValue() {
			Set<Observable> toTrack = new HashSet<>();
			toTrack.add(this.base);

			try {
				if( this.path.isEmpty() ) {
					return (T) this.base.getValue();
				} else {
					Object cur = this.base.getValue();

					for (StreamStep s : this.path) {
						cur = s.apply(cur, toTrack);
					}
					return (T) cur;
				}
			} finally {
				if (this.curToTrack != null) {
					unbind(this.curToTrack.toArray(new Observable[0]));
				}
				this.curToTrack = toTrack;
				bind(this.curToTrack.toArray(new Observable[0]));

			}
		}

	}


	public BindingStreamImpl(ObservableValue<?> base) {
		this.base = base;
		this.path = new ArrayList<>();
	}

	private BindingStreamImpl(ObservableValue<?> base, List<StreamStep<?, ?>> path) {
		this.base = base;
		this.path = path;
	}

	@Override
	public <S> BindingStream<S> map(Function<T, ObservableValue<S>> map) {
		MapValue<T, S> segment = new MapValue<>(map);
		this.path.add(segment);
		return new BindingStreamImpl<S>(this.base, this.path);
	}

	@Override
	public <S> BindingStream<S> mapNoObservable(Function<T, S> map) {
		MapNoObservable<T, S> segment = new MapNoObservable<>(map);
		this.path.add(segment);
		return new BindingStreamImpl<S>(this.base, this.path);
	}

	@Override
	public ObjectBinding<T> toBinding() {
		return new StreamBinding<>(this.base, this.path);
	}

	@Override
	public <S> Property<S> toProperty(Function<T, Property<S>> map) {
		// Remember the binding to prevent GC to clean it up
		ObjectBinding<Property<S>> binding = mapNoObservable(map).toBinding();
		ObjectProperty<S> rv = new SimpleObjectProperty<S>() {
			@SuppressWarnings("unused")
			private ObjectBinding<Property<S>> b = binding;
		};

		if( binding.get() != null ) {
			rv.bindBidirectional(binding.get());
		}

		binding.addListener( (o, ol, ne) -> {
			if( ol != null ) {
				rv.unbindBidirectional(ol);
			}

			if( ne != null ) {
				rv.bindBidirectional(ne);
			} else {
				rv.set((S)null);
			}
		});

		return rv;
	}

	@Override
	public BooleanProperty toBooleanProperty(Function<T, BooleanProperty> map) {
		ObjectBinding<BooleanProperty> binding = mapNoObservable(map).toBinding();
		BooleanProperty rv = new SimpleBooleanProperty() {
			@SuppressWarnings("unused")
			private ObjectBinding<BooleanProperty> b = binding;
		};

		if( binding.get() != null ) {
			rv.bindBidirectional(binding.get());
		}

		binding.addListener( (o, ol, ne) -> {
			if( ol != null ) {
				rv.unbindBidirectional(ol);
			}

			if( ne != null ) {
				rv.bindBidirectional(ne);
			} else {
				rv.set(false);
			}
		});

		return rv;
	}

	@Override
	public DoubleProperty toDoubleProperty(Function<T, DoubleProperty> map) {
		ObjectBinding<DoubleProperty> binding = mapNoObservable(map).toBinding();
		DoubleProperty rv = new SimpleDoubleProperty() {
			@SuppressWarnings("unused")
			private ObjectBinding<DoubleProperty> b = binding;
		};

		if( binding.get() != null ) {
			rv.bindBidirectional(binding.get());
		}

		binding.addListener( (o, ol, ne) -> {
			if( ol != null ) {
				rv.unbindBidirectional(ol);
			}

			if( ne != null ) {
				rv.bindBidirectional(ne);
			} else {
				rv.set(0.0);
			}
		});

		return rv;
	}

	@Override
	public FloatProperty toFloatProperty(Function<T, FloatProperty> map) {
		ObjectBinding<FloatProperty> binding = mapNoObservable(map).toBinding();
		FloatProperty rv = new SimpleFloatProperty() {
			@SuppressWarnings("unused")
			private ObjectBinding<FloatProperty> b = binding;
		};

		if( binding.get() != null ) {
			rv.bindBidirectional(binding.get());
		}

		binding.addListener( (o, ol, ne) -> {
			if( ol != null ) {
				rv.unbindBidirectional(ol);
			}

			if( ne != null ) {
				rv.bindBidirectional(ne);
			} else {
				rv.set(0.0f);
			}
		});

		return rv;
	}

	@Override
	public IntegerProperty toIntegerProperty(Function<T, IntegerProperty> map) {
		ObjectBinding<IntegerProperty> binding = mapNoObservable(map).toBinding();
		IntegerProperty rv = new SimpleIntegerProperty() {
			@SuppressWarnings("unused")
			private ObjectBinding<IntegerProperty> b = binding;
		};

		if( binding.get() != null ) {
			rv.bindBidirectional(binding.get());
		}

		binding.addListener( (o, ol, ne) -> {
			if( ol != null ) {
				rv.unbindBidirectional(ol);
			}

			if( ne != null ) {
				rv.bindBidirectional(ne);
			} else {
				rv.set(0);
			}
		});

		return rv;
	}

	@Override
	public LongProperty toLongProperty(Function<T, LongProperty> map) {
		ObjectBinding<LongProperty> binding = mapNoObservable(map).toBinding();
		LongProperty rv = new SimpleLongProperty() {
			@SuppressWarnings("unused")
			private ObjectBinding<LongProperty> b = binding;
		};

		if( binding.get() != null ) {
			rv.bindBidirectional(binding.get());
		}

		binding.addListener( (o, ol, ne) -> {
			if( ol != null ) {
				rv.unbindBidirectional(ol);
			}

			if( ne != null ) {
				rv.bindBidirectional(ne);
			} else {
				rv.set(0);
			}
		});

		return rv;
	}

	@Override
	public <S> ObjectProperty<S> toObjectProperty(Function<T, ObjectProperty<S>> map) {
		// Remember the binding to prevent GC to clean it up
		ObjectBinding<ObjectProperty<S>> binding = mapNoObservable(map).toBinding();
		ObjectProperty<S> rv = new SimpleObjectProperty<S>() {
			@SuppressWarnings("unused")
			private ObjectBinding<ObjectProperty<S>> b = binding;
		};

		if( binding.get() != null ) {
			rv.bindBidirectional(binding.get());
		}

		binding.addListener( (o, ol, ne) -> {
			if( ol != null ) {
				rv.unbindBidirectional(ol);
			}

			if( ne != null ) {
				rv.bindBidirectional(ne);
			} else {
				rv.set((S)null);
			}
		});

		return rv;
	}

	@Override
	public StringProperty toStringProperty(Function<T, StringProperty> map) {
		ObjectBinding<StringProperty> binding = mapNoObservable(map).toBinding();
		StringProperty rv = new SimpleStringProperty() {
			@SuppressWarnings("unused")
			private ObjectBinding<StringProperty> b = binding;
		};

		if( binding.get() != null ) {
			rv.bindBidirectional(binding.get());
		}

		binding.addListener( (o, ol, ne) -> {
			if( ol != null ) {
				rv.unbindBidirectional(ol);
			}

			if( ne != null ) {
				rv.bindBidirectional(ne);
			} else {
				rv.set(null);
			}
		});

		return rv;
	}
}
