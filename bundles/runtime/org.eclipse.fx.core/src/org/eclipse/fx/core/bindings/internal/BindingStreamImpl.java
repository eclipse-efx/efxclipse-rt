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
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

import org.eclipse.fx.core.bindings.BindingStream;

import javafx.beans.Observable;
import javafx.beans.binding.ObjectBinding;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
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
			this.path = path;
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

			Object cur = this.base.getValue();

			for (StreamStep s : this.path) {
				cur = s.apply(cur, toTrack);
			}

			if (this.curToTrack != null) {
				unbind(this.curToTrack.toArray(new Observable[0]));
			}
			this.curToTrack = toTrack;
			bind(this.curToTrack.toArray(new Observable[0]));
			return (T) cur;
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
	public <S> BindingStream<S> mapNoObservalbe(Function<T, S> map) {
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
		Property<S> rv = new SimpleObjectProperty<>();
		ObjectBinding<Property<S>> binding = mapNoObservalbe(map).toBinding();
		if( binding.get() != null ) {
			rv.bindBidirectional(binding.get());
		}

		binding.addListener( (o, ol, ne) -> {
			if( ol != null ) {
				rv.unbindBidirectional(ol);
			}

			if( ne != null ) {
				rv.bindBidirectional(ne);
			}
		});

		return rv;
	}
}
