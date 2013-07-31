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

import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.DisposeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.IDisposeListener;
import org.eclipse.core.databinding.observable.list.IListChangeListener;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.ListChangeEvent;
import org.eclipse.core.databinding.observable.list.ListDiffEntry;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;

public class AdapterFactory {
	static class WrappedList<E> implements ObservableList<E> {
		
		private List<InvalidationListener> fxInvalidationListeners;
		private List<ListChangeListener<? super E>> fxChangeListeners;

		private final IObservableList list;
		private IChangeListener dbInvalidationListener;
		private IListChangeListener dbChangeListener;
		
		public WrappedList(IObservableList list) {
			this.list = list;
			this.list.addDisposeListener(new IDisposeListener() {
				
				@Override
				public void handleDispose(DisposeEvent event) {
					fxInvalidationListeners.clear();
					dbInvalidationListener = null;
					
					fxChangeListeners.clear();
					dbChangeListener = null;
				}
			});
		}
		
		@Override
		public int size() {
			return list.size();
		}

		@Override
		public boolean isEmpty() {
			return list.isEmpty();
		}

		@Override
		public boolean contains(Object o) {
			return list.contains(o);
		}

		@SuppressWarnings("unchecked")
		@Override
		public Iterator<E> iterator() {
			return list.iterator();
		}

		@Override
		public Object[] toArray() {
			return list.toArray();
		}

		@SuppressWarnings("unchecked")
		@Override
		public <T> T[] toArray(T[] a) {
			return (T[]) list.toArray(a);
		}

		@Override
		public boolean add(E e) {
			return list.add(e);
		}

		@Override
		public boolean remove(Object o) {
			return list.remove(o);
		}

		@Override
		public boolean containsAll(Collection<?> c) {
			return list.containsAll(c);
		}

		@Override
		public boolean addAll(Collection<? extends E> c) {
			return list.addAll(c);
		}

		@Override
		public boolean addAll(int index, Collection<? extends E> c) {
			return list.addAll(index, c);
		}

		@Override
		public boolean removeAll(Collection<?> c) {
			return list.removeAll(c);
		}

		@Override
		public boolean retainAll(Collection<?> c) {
			return list.retainAll(c);
		}

		@Override
		public void clear() {
			list.clear();
		}

		@SuppressWarnings("unchecked")
		@Override
		public E get(int index) {
			return (E) list.get(index);
		}

		@SuppressWarnings("unchecked")
		@Override
		public E set(int index, E element) {
			return (E) list.set(index, element);
		}

		@SuppressWarnings("unchecked")
		@Override
		public void add(int index, E element) {
			list.add(index, element);
		}

		@SuppressWarnings("unchecked")
		@Override
		public E remove(int index) {
			return (E) list.remove(index);
		}

		@Override
		public int indexOf(Object o) {
			return list.indexOf(o);
		}

		@Override
		public int lastIndexOf(Object o) {
			return list.lastIndexOf(o);
		}

		@SuppressWarnings("unchecked")
		@Override
		public ListIterator<E> listIterator() {
			return list.listIterator();
		}

		@SuppressWarnings("unchecked")
		@Override
		public ListIterator<E> listIterator(int index) {
			return list.listIterator(index);
		}

		@SuppressWarnings("unchecked")
		@Override
		public List<E> subList(int fromIndex, int toIndex) {
			return list.subList(fromIndex, toIndex);
		}

		@Override
		public void addListener(InvalidationListener listener) {
			if( fxInvalidationListeners == null ) {
				fxInvalidationListeners = new ArrayList<InvalidationListener>();
				dbInvalidationListener = new IChangeListener() {
					
					@Override
					public void handleChange(ChangeEvent event) {
						for( InvalidationListener l : fxInvalidationListeners.toArray(new InvalidationListener[0]) ) {
							l.invalidated(WrappedList.this);
						}
					}
				};
				list.addChangeListener(dbInvalidationListener);
			}
			
			fxInvalidationListeners.add(listener);
		}

		@Override
		public void removeListener(InvalidationListener listener) {
			if( fxInvalidationListeners != null ) {
				fxInvalidationListeners.remove(listener);
				if( fxInvalidationListeners.isEmpty() ) {
					list.removeChangeListener(dbInvalidationListener);
					dbInvalidationListener = null;
					fxInvalidationListeners = null;
				}
			}
		}

		@Override
		public boolean addAll(E... elements) {
			return list.addAll(Arrays.asList(elements));
		}

		@Override
		public void addListener(ListChangeListener<? super E> listener) {
			if( fxChangeListeners == null ) {
				fxChangeListeners = new ArrayList<ListChangeListener<? super E>>();
				dbChangeListener = new IListChangeListener() {
					
					@SuppressWarnings("unchecked")
					@Override
					public void handleListChange(ListChangeEvent event) {
						final ListDiffEntry[] differences = event.diff.getDifferences();
						
						if( differences.length == 0 ) {
							return;
						}
						
						//TODO We need to make this perform a lot better by calculating range changes
						for( ListChangeListener<? super E> l : fxChangeListeners.toArray(new ListChangeListener[0]) ) {
							Change<E> change = new Change<E>(WrappedList.this) {
								private int index = -1;
								private ListDiffEntry current;
								
								@Override
								public int getFrom() {
									return current.getPosition();
								}

								@Override
								protected int[] getPermutation() {
									return new int[0];
								}

								@Override
								public List<E> getRemoved() {
									if( ! current.isAddition() ) {
										return Collections.singletonList((E)current.getElement());
									}
									return Collections.emptyList();
								}

								@Override
								public int getTo() {
									if( current.isAddition() ) {
										return current.getPosition() + 1;
									} else {
										return current.getPosition();
									}
								}

								public boolean wasAdded() {
									return current.isAddition();
								}
								
								public boolean wasRemoved() {
									return ! current.isAddition();
								}
								
								public boolean wasPermutated() {
									return false;
								}
								
								public boolean wasReplaced() {
									return false;
								}
								
								@Override
								public boolean next() {
									index++;
									if( index < differences.length ) {
										current = differences[index];
										return true;
									}
									return false;
								}

								@Override
								public void reset() {
									index = 0;
								}
							};
							l.onChanged(change);
						}
					}
				};
				list.addListChangeListener(dbChangeListener);
			}
			
			fxChangeListeners.add(listener);
		}

		@Override
		public void removeListener(ListChangeListener<? super E> listener) {
			if( fxChangeListeners != null ) {
				fxChangeListeners.remove(listener);
				if( fxChangeListeners.isEmpty() ) {
					list.removeListChangeListener(dbChangeListener);
					dbChangeListener = null;
					fxChangeListeners = null;
				}
			}
		}
		
		@Override
		public void remove(int from, int to) {
			//TODO Improve performance??
			for( int idx = to; idx >= from; idx-- ) {
				list.remove(idx);
			}
		}

		@Override
		public boolean removeAll(E... elements) {
			return list.removeAll(Arrays.asList(elements));
		}
		

		@Override
		public boolean retainAll(E... elements) {
			return list.retainAll(Arrays.asList(elements));
		}

		@Override
		public boolean setAll(E... elements) {
			//TODO Improve performance
			list.clear();
			return list.addAll(Arrays.asList(elements));
		}

		@Override
		public boolean setAll(Collection<? extends E> col) {
			//TODO Improve performance
			list.clear();
			return list.addAll(col);
		}
		
//FIXME Java8	
// Default methods NOT YET supported by JDT-Core
//		@Override
		public void forEach(Consumer<? super E> action) {
			list.forEach(action);
		}
			
//		@Override
		public Spliterator<E> spliterator() {
			return list.spliterator();
		}
	}
	
	static class WrappedValue<E> implements ObservableWritableValue<E> {
		
		private List<InvalidationListener> fxInvalidationListeners;
		private List<ChangeListener<? super E>> fxChangeListeners;
		
		private final IObservableValue value;
		private IChangeListener dbInvalidationListener;
		private IValueChangeListener dbChangeListener;

		
		public WrappedValue(IObservableValue value) {
			this.value = value;
			this.value.addDisposeListener(new IDisposeListener() {
				
				@Override
				public void handleDispose(DisposeEvent event) {
					if( fxInvalidationListeners != null ) {
						fxInvalidationListeners.clear();
					}
					
					dbInvalidationListener = null;
					
					if( fxChangeListeners != null ) {
						fxChangeListeners.clear();	
					}
					
					dbChangeListener = null;
				}
			});
		}

		@Override
		public void addListener(InvalidationListener listener) {
			if( fxInvalidationListeners == null ) {
				fxInvalidationListeners = new ArrayList<InvalidationListener>();
				dbInvalidationListener = new IChangeListener() {
					
					@Override
					public void handleChange(ChangeEvent event) {
						for( InvalidationListener l : fxInvalidationListeners.toArray(new InvalidationListener[0]) ) {
							l.invalidated(WrappedValue.this);
						}
					}
				};
				value.addChangeListener(dbInvalidationListener);
			}
			
			fxInvalidationListeners.add(listener);
		}

		@Override
		public void removeListener(InvalidationListener listener) {
			if( fxInvalidationListeners != null ) {
				fxInvalidationListeners.remove(listener);
				if( fxInvalidationListeners.isEmpty() ) {
					value.removeChangeListener(dbInvalidationListener);
					dbInvalidationListener = null;
					fxInvalidationListeners = null;
				}
			}
		}

		@Override
		public void addListener(ChangeListener<? super E> listener) {
			if( fxChangeListeners == null ) {
				fxChangeListeners = new ArrayList<ChangeListener<? super E>>();
				dbChangeListener = new IValueChangeListener() {
					
					@SuppressWarnings("unchecked")
					@Override
					public void handleValueChange(ValueChangeEvent event) {
						for( ChangeListener<? super E> l : fxChangeListeners.toArray(new ChangeListener[0]) ) {
							l.changed(WrappedValue.this, (E)event.diff.getOldValue(), (E)event.diff.getNewValue());
						}
					}
				};
				value.addValueChangeListener(dbChangeListener);
			}
			
			fxChangeListeners.add(listener);
		}
		
		@Override
		public void removeListener(ChangeListener<? super E> listener) {
			if( fxChangeListeners != null ) {
				fxChangeListeners.remove(listener);
				if( fxChangeListeners.isEmpty() ) {
					value.removeValueChangeListener(dbChangeListener);
					dbChangeListener = null;
					fxChangeListeners = null;
				}
			}
		}

		@SuppressWarnings("unchecked")
		@Override
		public E getValue() {
			return (E) value.getValue();
		}

		@Override
		public void setValue(E value) {
			this.value.setValue(value);
		}		
	}
	
	public static <E> ObservableWritableValue<E> adapt(IObservableValue value) {
		return new WrappedValue<E>(value);
	}
	
	public static <E> ObservableList<E> adapt(IObservableList list) {
		return new WrappedList<E>(list);
	}
	
	enum InitialSync {
		FX_TO_DB,
		DB_TO_FX
	}
		
	public static <E> void bind(ObservableList<E> fxObs, IObservableList dbObs, InitialSync initialSync) {
		ObservableList<E> dbList = adapt(dbObs);
		if( initialSync == InitialSync.FX_TO_DB ) {
			Bindings.bindContent(dbList, fxObs);
		} else {
			Bindings.bindContentBidirectional(fxObs, dbList);	
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public static <E, F extends ObservableValue<E> & WritableValue<E>> void bind(F fxObs, IObservableValue dbObs, InitialSync initialSync) {
		if( initialSync == InitialSync.FX_TO_DB ) {
			dbObs.setValue(fxObs.getValue());
		} else {
			fxObs.setValue((E) dbObs.getValue());
		}
		ObservableWritableValue<E> wrapped = adapt(dbObs);
		do_bind(fxObs, wrapped);
	}
	
	private static <E, F extends ObservableValue<E> & WritableValue<E>> void do_bind(final F fxObs, final F dbObs) {
		fxObs.addListener(new ChangeListener<E>() {
			boolean syncing;
			@Override
			public void changed(ObservableValue<? extends E> observable, E oldValue, E newValue) {
				if( syncing ) {
					return;
				}
				
				try {
					syncing = true;
					if( observable == fxObs ) {
						dbObs.setValue(newValue);
					} else {
						fxObs.setValue(newValue);
					}
				} finally {
					syncing = false;
				}
			}
		});
	}
}
