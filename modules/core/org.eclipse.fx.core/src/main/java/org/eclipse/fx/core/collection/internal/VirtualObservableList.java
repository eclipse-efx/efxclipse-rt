/*******************************************************************************
 * Copyright (c) 2018 BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core.collection.internal;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalLong;

import org.eclipse.fx.core.collection.IndexRangeView;
import org.eclipse.fx.core.collection.IndexView;
import org.eclipse.fx.core.collection.VirtualList;
import org.eclipse.fx.core.observable.FXObservableUtil;
import org.eclipse.jdt.annotation.Nullable;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.LongBinding;
import javafx.beans.binding.ObjectBinding;
import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.beans.property.ReadOnlyLongWrapper;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableIntegerValue;
import javafx.beans.value.ObservableLongValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ListChangeListener.Change;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;

/**
 * Implementation based on an {@link ObservableList} - hence it is not so
 * virtual
 * 
 * @param <T> the element type
 */
public class VirtualObservableList<@Nullable T> implements VirtualList<T> {
	final ObservableList<T> list;
	private final ReadOnlyLongWrapper length = new ReadOnlyLongWrapper();

	/**
	 * Create a new virtual list
	 * 
	 * @param list the observable list backing it
	 */
	public VirtualObservableList(ObservableList<T> list) {
		this.list = list;
		this.length.bind(Bindings.size(list));
	}

	@Override
	public ObservableLongValue length() {
		return this.length.getReadOnlyProperty();
	}

	@Override
	public T get(long index) {
		return this.list.get((int) index);
	}

	@Override
	public IndexView<T> getView(long index) {
		return new ValueViewImpl((int) index);
	}

	@Override
	public IndexRangeView<T> getView(long startIndex, int length) {
		return new ListViewImpl(startIndex, length);
	}

	@Override
	public OptionalLong index(@Nullable T o) {
		int idx = this.list.indexOf(o);
		return idx == -1 ? OptionalLong.empty() : OptionalLong.of(idx);
	}

	class ValueViewImpl extends ReadOnlyObjectWrapper<T> implements IndexView<T> {
		private final ReadOnlyLongWrapper index;
		private ObjectBinding<T> indexValue;

		public ValueViewImpl(int index) {
			this.index = new ReadOnlyLongWrapper(index);
			this.indexValue = Bindings.valueAt(VirtualObservableList.this.list, this.index);
			bind(this.indexValue);
		}

		@Override
		public ObservableLongValue index() {
			return this.index.getReadOnlyProperty();
		}

		@Override
		public void moveBy(long delta) {
			// TODO need to handle long overflow
			this.index.set(Math.max(0, this.index.get() + delta));
		}
	}

	class ListViewImpl extends ObservableListBase<T> implements IndexRangeView<T> {
		private final ObservableList<T> data = FXCollections.observableArrayList();
		private final ListChangeListener<T> listener;
		final ReadOnlyLongWrapper startIndex;
		final ReadOnlyIntegerWrapper length;

		public ListViewImpl(long startIndex, int length) {
			this.startIndex = new ReadOnlyLongWrapper(startIndex);
			FXObservableUtil.onInvalidate(this.startIndex, v -> updateList());
			this.length = new ReadOnlyIntegerWrapper(length);
			FXObservableUtil.onInvalidate(this.length, v -> updateList());
			FXObservableUtil.onInvalidate(VirtualObservableList.this.list, o -> updateList());

			this.listener = (c) -> {
				fireChange(new SourceChangeEvent<T>(this, c));
			};
			this.data.addListener(this.listener);
			updateList();
		}

		private void updateList() {
			List<T> list = new ArrayList<>(size());

			if (this.startIndex.get() < VirtualObservableList.this.list.size()) {
				list.addAll(VirtualObservableList.this.list.subList((int) this.startIndex.get(),
						(int) Math.min(_endIndex() + 1, VirtualObservableList.this.list.size())));
			}

			// Fill up the reset of the list
			if (list.size() < size()) {
				for (int i = list.size(); i < size(); i++) {
					list.add(null);
				}
			}

			if (!list.equals(this.data)) {
				this.data.setAll(list);
			}
		}

		@Override
		public void moveBy(long delta) {
			// TODO need to handle long overflow
			this.startIndex.set(Math.max(0, this.startIndex.get() + delta));
		}

		@Override
		public void shrinkBy(int delta) {
			if (delta > 0) {
				this.length.set(Math.max(0, this.length.get() - delta));
			}
		}

		@Override
		public void growBy(int delta) {
			if (delta > 0) {
				this.length.set(Math.max(0, this.length.get() + delta));
			}
		}

		@Override
		public ObservableLongValue startIndex() {
			return this.startIndex.getReadOnlyProperty();
		}

		long _endIndex() {
			return ListViewImpl.this.startIndex.get() + ListViewImpl.this.length.get() - 1;
		}

		@Override
		public ObservableLongValue endIndex() {
			return new LongBinding() {
				{
					bind(ListViewImpl.this.startIndex, ListViewImpl.this.length);
				}

				@Override
				protected long computeValue() {
					return _endIndex();
				}
			};
		}

		@Override
		public ObservableIntegerValue length() {
			return this.length.getReadOnlyProperty();
		}

		@Override
		public T get(int index) {
			if (index < 0 || index >= size()) {
				throw new IndexOutOfBoundsException();
			}
			if (index < this.data.size()) {
				return this.data.get(index);
			}
			return null;
		}

		@Override
		public int size() {
			return this.length.get();
		}
	}

	static class SourceChangeEvent<T> extends ListChangeListener.Change<T> {
		private final Change<? extends T> change;
		private final Method getPermutation;

		public SourceChangeEvent(ObservableList<T> list, Change<? extends T> change) {
			super(list);
			this.change = change;
			try {
				// TODO We should use MethodHandles
				this.getPermutation = ListChangeListener.Change.class.getDeclaredMethod("getPermutation"); //$NON-NLS-1$
				this.getPermutation.setAccessible(true);
			} catch (NoSuchMethodException | SecurityException e) {
				throw new IllegalStateException(e);
			}
		}

		@Override
		public boolean next() {
			return this.change.next();
		}

		@Override
		public void reset() {
			this.change.reset();
		}

		@Override
		public int getFrom() {
			return this.change.getFrom();
		}

		@Override
		public int getTo() {
			return this.change.getTo();
		}

		@SuppressWarnings("unchecked")
		@Override
		public List<T> getRemoved() {
			return (List<T>) this.change.getRemoved();
		}

		@Override
		protected int[] getPermutation() {
			try {
				return (int[]) this.getPermutation.invoke(this.change);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				throw new IllegalStateException(e);
			}
		}

		@Override
		public boolean wasUpdated() {
			return this.change.wasUpdated();
		}
	}
}
