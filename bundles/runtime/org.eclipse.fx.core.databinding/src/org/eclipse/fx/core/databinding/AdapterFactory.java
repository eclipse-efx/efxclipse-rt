/*******************************************************************************
 * Copyright (c) 2012 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core.databinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Spliterator;
import java.util.function.Consumer;

import javafx.beans.InvalidationListener;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.beans.value.WritableValue;
import javafx.collections.ListChangeListener;
import javafx.collections.ListChangeListener.Change;
import javafx.collections.ObservableList;
import javafx.util.Callback;

import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.DisposeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.IDisposeListener;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.list.IListChangeListener;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.ListChangeEvent;
import org.eclipse.core.databinding.observable.list.ListDiffEntry;
import org.eclipse.core.databinding.observable.list.ListDiffVisitor;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;

/**
 * Allows to adapt between Eclipse Databinding and JavaFX observables
 */
public class AdapterFactory {
	static class WrappedList<E> implements ObservableList<E> {

		List<InvalidationListener> fxInvalidationListeners;
		List<ListChangeListener<? super E>> fxChangeListeners;

		final IObservableList list;
		IChangeListener dbInvalidationListener;
		IListChangeListener dbChangeListener;

		public WrappedList(IObservableList list) {
			this.list = list;
			this.list.addDisposeListener(new IDisposeListener() {

				@Override
				public void handleDispose(DisposeEvent event) {
					if (WrappedList.this.fxInvalidationListeners != null) {
						WrappedList.this.fxInvalidationListeners.clear();
					}
					WrappedList.this.dbInvalidationListener = null;

					if (WrappedList.this.fxChangeListeners != null) {
						WrappedList.this.fxChangeListeners.clear();
					}
					WrappedList.this.dbChangeListener = null;
				}
			});
		}

		@Override
		public int size() {
			return this.list.size();
		}

		@Override
		public boolean isEmpty() {
			return this.list.isEmpty();
		}

		@Override
		public boolean contains(Object o) {
			return this.list.contains(o);
		}

		@SuppressWarnings("unchecked")
		@Override
		public Iterator<E> iterator() {
			return this.list.iterator();
		}

		@Override
		public Object[] toArray() {
			return this.list.toArray();
		}

		@SuppressWarnings("unchecked")
		@Override
		public <T> T[] toArray(T[] a) {
			return (T[]) this.list.toArray(a);
		}

		@Override
		public boolean add(E e) {
			return this.list.add(e);
		}

		@Override
		public boolean remove(Object o) {
			return this.list.remove(o);
		}

		@Override
		public boolean containsAll(Collection<?> c) {
			return this.list.containsAll(c);
		}

		@Override
		public boolean addAll(Collection<? extends E> c) {
			return this.list.addAll(c);
		}

		@Override
		public boolean addAll(int index, Collection<? extends E> c) {
			return this.list.addAll(index, c);
		}

		@Override
		public boolean removeAll(Collection<?> c) {
			return this.list.removeAll(c);
		}

		@Override
		public boolean retainAll(Collection<?> c) {
			return this.list.retainAll(c);
		}

		@Override
		public void clear() {
			this.list.clear();
		}

		@SuppressWarnings("unchecked")
		@Override
		public E get(int index) {
			return (E) this.list.get(index);
		}

		@SuppressWarnings("unchecked")
		@Override
		public E set(int index, E element) {
			return (E) this.list.set(index, element);
		}

		@SuppressWarnings("unchecked")
		@Override
		public void add(int index, E element) {
			this.list.add(index, element);
		}

		@SuppressWarnings("unchecked")
		@Override
		public E remove(int index) {
			return (E) this.list.remove(index);
		}

		@Override
		public int indexOf(Object o) {
			return this.list.indexOf(o);
		}

		@Override
		public int lastIndexOf(Object o) {
			return this.list.lastIndexOf(o);
		}

		@SuppressWarnings("unchecked")
		@Override
		public ListIterator<E> listIterator() {
			return this.list.listIterator();
		}

		@SuppressWarnings("unchecked")
		@Override
		public ListIterator<E> listIterator(int index) {
			return this.list.listIterator(index);
		}

		@SuppressWarnings("unchecked")
		@Override
		public List<E> subList(int fromIndex, int toIndex) {
			return this.list.subList(fromIndex, toIndex);
		}

		@Override
		public void addListener(InvalidationListener listener) {
			if (this.fxInvalidationListeners == null) {
				this.fxInvalidationListeners = new ArrayList<InvalidationListener>();
				this.dbInvalidationListener = new IChangeListener() {

					@Override
					public void handleChange(ChangeEvent event) {
						for (InvalidationListener l : WrappedList.this.fxInvalidationListeners.toArray(new InvalidationListener[0])) {
							l.invalidated(WrappedList.this);
						}
					}
				};
				this.list.addChangeListener(this.dbInvalidationListener);
			}

			this.fxInvalidationListeners.add(listener);
		}

		@Override
		public void removeListener(InvalidationListener listener) {
			if (this.fxInvalidationListeners != null) {
				this.fxInvalidationListeners.remove(listener);
				if (this.fxInvalidationListeners.isEmpty()) {
					this.list.removeChangeListener(this.dbInvalidationListener);
					this.dbInvalidationListener = null;
					this.fxInvalidationListeners = null;
				}
			}
		}

		@Override
		public boolean addAll(@SuppressWarnings("unchecked") E... elements) {
			return this.list.addAll(Arrays.asList(elements));
		}

		@Override
		public void addListener(ListChangeListener<? super E> listener) {
			if (this.fxChangeListeners == null) {
				this.fxChangeListeners = new ArrayList<ListChangeListener<? super E>>();
				this.dbChangeListener = new IListChangeListener() {

					@SuppressWarnings("unchecked")
					@Override
					public void handleListChange(ListChangeEvent event) {
						final ListDiffEntry[] differences = event.diff.getDifferences();

						if (differences.length == 0) {
							return;
						}

						// TODO We need to make this perform a lot better by calculating range changes
						for (ListChangeListener<? super E> l : WrappedList.this.fxChangeListeners.toArray(new ListChangeListener[0])) {
							Change<E> change = new Change<E>(WrappedList.this) {
								private int index = -1;
								private ListDiffEntry current;

								@Override
								public int getFrom() {
									return this.current.getPosition();
								}

								@Override
								protected int[] getPermutation() {
									return new int[0];
								}

								@Override
								public List<E> getRemoved() {
									if (!this.current.isAddition()) {
										return Collections.singletonList((E) this.current.getElement());
									}
									return Collections.emptyList();
								}

								@Override
								public int getTo() {
									if (this.current.isAddition()) {
										return this.current.getPosition() + 1;
									} else {
										return this.current.getPosition();
									}
								}

								@Override
								public boolean wasAdded() {
									return this.current.isAddition();
								}

								@Override
								public boolean wasRemoved() {
									return !this.current.isAddition();
								}

								@Override
								public boolean wasPermutated() {
									return false;
								}

								@Override
								public boolean wasReplaced() {
									return false;
								}

								@Override
								public boolean next() {
									this.index++;
									if (this.index < differences.length) {
										this.current = differences[this.index];
										return true;
									}
									return false;
								}

								@Override
								public void reset() {
									this.index = 0;
								}
							};
							l.onChanged(change);
						}
					}
				};
				this.list.addListChangeListener(this.dbChangeListener);
			}

			this.fxChangeListeners.add(listener);
		}

		@Override
		public void removeListener(ListChangeListener<? super E> listener) {
			if (this.fxChangeListeners != null) {
				this.fxChangeListeners.remove(listener);
				if (this.fxChangeListeners.isEmpty()) {
					this.list.removeListChangeListener(this.dbChangeListener);
					this.dbChangeListener = null;
					this.fxChangeListeners = null;
				}
			}
		}

		@Override
		public void remove(int from, int to) {
			// TODO Improve performance??
			for (int idx = to; idx >= from; idx--) {
				this.list.remove(idx);
			}
		}

		@Override
		public boolean removeAll(@SuppressWarnings("unchecked") E... elements) {
			return this.list.removeAll(Arrays.asList(elements));
		}

		@Override
		public boolean retainAll(@SuppressWarnings("unchecked") E... elements) {
			return this.list.retainAll(Arrays.asList(elements));
		}

		@Override
		public boolean setAll(@SuppressWarnings("unchecked") E... elements) {
			// TODO Improve performance
			this.list.clear();
			return this.list.addAll(Arrays.asList(elements));
		}

		@Override
		public boolean setAll(Collection<? extends E> col) {
			// TODO Improve performance
			this.list.clear();
			return this.list.addAll(col);
		}

//		// FIXME Java8
//		// Default methods NOT YET supported by JDT-Core
//		// @Override
//		@Override
//		public void forEach(Consumer<? super E> action) {
//			this.list.forEach(action);
//		}
//
//		// @Override
//		public Spliterator<E> spliterator() {
//			return this.list.spliterator();
//		}
	}

	static class WrappedValue<E> implements ObservableWritableValue<E> {

		List<InvalidationListener> fxInvalidationListeners;
		List<ChangeListener<? super E>> fxChangeListeners;

		final IObservableValue value;
		IChangeListener dbInvalidationListener;
		IValueChangeListener dbChangeListener;

		public WrappedValue(IObservableValue value) {
			this.value = value;
			this.value.addDisposeListener(new IDisposeListener() {

				@Override
				public void handleDispose(DisposeEvent event) {
					if (WrappedValue.this.fxInvalidationListeners != null) {
						WrappedValue.this.fxInvalidationListeners.clear();
					}

					WrappedValue.this.dbInvalidationListener = null;

					if (WrappedValue.this.fxChangeListeners != null) {
						WrappedValue.this.fxChangeListeners.clear();
					}

					WrappedValue.this.dbChangeListener = null;
				}
			});
		}

		@Override
		public void addListener(InvalidationListener listener) {
			if (this.fxInvalidationListeners == null) {
				this.fxInvalidationListeners = new ArrayList<InvalidationListener>();
				this.dbInvalidationListener = new IChangeListener() {

					@Override
					public void handleChange(ChangeEvent event) {
						for (InvalidationListener l : WrappedValue.this.fxInvalidationListeners.toArray(new InvalidationListener[0])) {
							l.invalidated(WrappedValue.this);
						}
					}
				};
				this.value.addChangeListener(this.dbInvalidationListener);
			}

			this.fxInvalidationListeners.add(listener);
		}

		@Override
		public void removeListener(InvalidationListener listener) {
			if (this.fxInvalidationListeners != null) {
				this.fxInvalidationListeners.remove(listener);
				if (this.fxInvalidationListeners.isEmpty()) {
					this.value.removeChangeListener(this.dbInvalidationListener);
					this.dbInvalidationListener = null;
					this.fxInvalidationListeners = null;
				}
			}
		}

		@Override
		public void addListener(ChangeListener<? super E> listener) {
			if (this.fxChangeListeners == null) {
				this.fxChangeListeners = new ArrayList<ChangeListener<? super E>>();
				this.dbChangeListener = new IValueChangeListener() {

					@SuppressWarnings("unchecked")
					@Override
					public void handleValueChange(ValueChangeEvent event) {
						for (ChangeListener<? super E> l : WrappedValue.this.fxChangeListeners.toArray(new ChangeListener[0])) {
							l.changed(WrappedValue.this, (E) event.diff.getOldValue(), (E) event.diff.getNewValue());
						}
					}
				};
				this.value.addValueChangeListener(this.dbChangeListener);
			}

			this.fxChangeListeners.add(listener);
		}

		@Override
		public void removeListener(ChangeListener<? super E> listener) {
			if (this.fxChangeListeners != null) {
				this.fxChangeListeners.remove(listener);
				if (this.fxChangeListeners.isEmpty()) {
					this.value.removeValueChangeListener(this.dbChangeListener);
					this.dbChangeListener = null;
					this.fxChangeListeners = null;
				}
			}
		}

		@SuppressWarnings("unchecked")
		@Override
		public E getValue() {
			return (E) this.value.getValue();
		}

		@Override
		public void setValue(E value) {
			this.value.setValue(value);
		}
	}

	/**
	 * Adapt an {@link IObservableValue} to an {@link ObservableWritableValue}
	 * 
	 * @param value
	 *            the eclipse db value
	 * @return the javafx observable
	 */
	public static <E> ObservableWritableValue<E> adapt(IObservableValue value) {
		return new WrappedValue<E>(value);
	}

	/**
	 * Adapt an {@link IObservableList} to an {@link ObservableList}
	 * 
	 * @param list
	 *            the eclipse db list
	 * @return the javafx observable list
	 */
	public static <E> ObservableList<E> adapt(IObservableList list) {
		return new WrappedList<E>(list);
	}

	enum InitialSync {
		FX_TO_DB, DB_TO_FX
	}

	/**
	 * Bind a JavaFX observable list to an Eclipse DB observable list
	 * 
	 * @param fxObs
	 *            the fx observable
	 * @param dbObs
	 *            the eclipse db observable
	 * @param initialSync
	 *            the initial sync direction
	 */
	public static <E> void bind(ObservableList<E> fxObs, IObservableList dbObs, InitialSync initialSync) {
		ObservableList<E> dbList = adapt(dbObs);
		if (initialSync == InitialSync.FX_TO_DB) {
			Bindings.bindContent(dbList, fxObs);
		} else {
			Bindings.bindContentBidirectional(fxObs, dbList);
		}

	}

	/**
	 * Bind an javafx observable value to a eclipse db observable
	 * 
	 * @param fxObs
	 *            the javafx observable
	 * @param dbObs
	 *            the eclipse db observable
	 * @param initialSync
	 *            the initial sync direction
	 */
	@SuppressWarnings("unchecked")
	public static <E, F extends ObservableValue<E> & WritableValue<E>> void bind(F fxObs, IObservableValue dbObs, InitialSync initialSync) {
		if (initialSync == InitialSync.FX_TO_DB) {
			dbObs.setValue(fxObs.getValue());
		} else {
			fxObs.setValue((E) dbObs.getValue());
		}
		ObservableWritableValue<E> wrapped = adapt(dbObs);
		do_bind(fxObs, wrapped);
	}

	/**
	 * Creates an <b>readonly</b> observable list which is backed by the source list but the values are converted using the
	 * converter
	 * 
	 * @param source
	 *            the source list
	 * @param converter
	 *            the converter
	 * @return observable list with converter value
	 */
	@SuppressWarnings("unchecked")
	public static <S, T> IObservableList convertObservableList(IObservableList source, final Callback<S, T> converter) {
		final ReadonlyWritableList target = new ReadonlyWritableList(source.getRealm());
		
		try {
			target.modifiable = true;
			for (Object o : source) {
				target.add(converter.call((S)o));
			}
		} finally {
			target.modifiable = false;
		}
		
		source.addListChangeListener(new IListChangeListener() {

			@Override
			public void handleListChange(ListChangeEvent event) {
				event.diff.accept(new ListDiffVisitor() {

					@Override
					public void handleRemove(int index, Object element) {
						try {
							target.modifiable = true;
							target.remove(index);
						} finally {
							target.modifiable = false;
						}
					}

					@Override
					public void handleAdd(int index, Object element) {
						try {
							target.modifiable = true;
							target.add(index, converter.call((S) element));
						} finally {
							target.modifiable = false;
						}
					}

					@Override
					public void handleReplace(int index, Object oldElement, Object newElement) {
						try {
							target.modifiable = true;
							target.set(index, converter.call((S) newElement));
						} finally {
							target.modifiable = false;
						}
					}
					
					@Override
					public void handleMove(int oldIndex, int newIndex, Object element) {
						try {
							target.modifiable = true;
							target.move(oldIndex, newIndex);
						} finally {
							target.modifiable = false;
						}
					}
				});
			}
		});

		return target;
	}
	
	static class ReadonlyWritableList extends WritableList {
		boolean modifiable;
		
		public ReadonlyWritableList(Realm r) {
			super(r);
		}

		@Override
		public Object set(int index, Object element) {
			if( ! this.modifiable ) {
				throw new UnsupportedOperationException("Unmodifiable list"); //$NON-NLS-1$
			}
			return super.set(index, element);
		}

		@Override
		public Object move(int oldIndex, int newIndex) {
			if( ! this.modifiable ) {
				throw new UnsupportedOperationException("Unmodifiable list"); //$NON-NLS-1$
			}
			return super.move(oldIndex, newIndex);
		}

		@Override
		public Object remove(int index) {
			if( ! this.modifiable ) {
				throw new UnsupportedOperationException("Unmodifiable list"); //$NON-NLS-1$
			}
			return super.remove(index);
		}

		@Override
		public boolean add(Object element) {
			if( ! this.modifiable ) {
				throw new UnsupportedOperationException("Unmodifiable list"); //$NON-NLS-1$
			}
			return super.add(element);
		}

		@Override
		public void add(int index, Object element) {
			if( ! this.modifiable ) {
				throw new UnsupportedOperationException("Unmodifiable list"); //$NON-NLS-1$
			}
			super.add(index, element);
		}

		@SuppressWarnings("rawtypes")
		@Override
		public boolean addAll(Collection c) {
			if( ! this.modifiable ) {
				throw new UnsupportedOperationException("Unmodifiable list"); //$NON-NLS-1$
			}
			return super.addAll(c);
		}

		@SuppressWarnings("rawtypes")
		@Override
		public boolean addAll(int index, Collection c) {
			if( ! this.modifiable ) {
				throw new UnsupportedOperationException("Unmodifiable list"); //$NON-NLS-1$
			}
			return super.addAll(index, c);
		}

		@Override
		public boolean remove(Object o) {
			if( ! this.modifiable ) {
				throw new UnsupportedOperationException("Unmodifiable list"); //$NON-NLS-1$
			}
			return super.remove(o);
		}

		@SuppressWarnings("rawtypes")
		@Override
		public boolean removeAll(Collection c) {
			if( ! this.modifiable ) {
				throw new UnsupportedOperationException("Unmodifiable list"); //$NON-NLS-1$
			}
			return super.removeAll(c);
		}

		@SuppressWarnings("rawtypes")
		@Override
		public boolean retainAll(Collection c) {
			if( ! this.modifiable ) {
				throw new UnsupportedOperationException("Unmodifiable list"); //$NON-NLS-1$
			}
			return super.retainAll(c);
		}

		@Override
		public void clear() {
			if( ! this.modifiable ) {
				throw new UnsupportedOperationException("Unmodifiable list"); //$NON-NLS-1$
			}
			super.clear();
		}
	}

	private static <E, F extends ObservableValue<E> & WritableValue<E>> void do_bind(final F fxObs, final F dbObs) {
		fxObs.addListener(new ChangeListener<E>() {
			boolean syncing;

			@Override
			public void changed(ObservableValue<? extends E> observable, E oldValue, E newValue) {
				if (this.syncing) {
					return;
				}

				try {
					this.syncing = true;
					if (observable == fxObs) {
						dbObs.setValue(newValue);
					} else {
						fxObs.setValue(newValue);
					}
				} finally {
					this.syncing = false;
				}
			}
		});
	}
}
