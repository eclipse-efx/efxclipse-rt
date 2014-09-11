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
package org.eclipse.fx.ui.databinding;

import java.util.Iterator;

import org.eclipse.core.databinding.observable.list.IListChangeListener;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.ListChangeEvent;
import org.eclipse.core.databinding.observable.list.ListDiffVisitor;
import org.eclipse.jdt.annotation.NonNull;

import javafx.beans.value.ChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;

/**
 * Utility to setup a tree
 */
public class TreeUtil {
	/**
	 * Create a tree model backed by the given {@link ObservableFactory}
	 * 
	 * @param root
	 *            the root of the model
	 * @param factory
	 *            the factory to create children
	 * @param <T>
	 *            the the item value type
	 * @return the tree item backed by the given root model instance
	 */
	@NonNull
	public static <T> TreeItem<T> createModel(@NonNull T root, @NonNull ObservableFactory<T> factory) {
		return new TreeItemImpl<T>(root, factory);
	}

	/**
	 * Factory to create child observables
	 * 
	 * @param <T>
	 *            the type
	 */
	public interface ObservableFactory<T> {
		/**
		 * Create an observable list for the parent element
		 * 
		 * @param parent
		 *            the parent
		 * @return the list
		 */
		public IObservableList createObservable(@NonNull T parent);
	}

	static class TreeItemImpl<T> extends TreeItem<T> {
		private IObservableList list;
		@NonNull
		ObservableFactory<T> factory;
		private boolean hasLoadedChildren = false;

		public TreeItemImpl(@NonNull T element, @NonNull ObservableFactory<T> factory) {
			setValue(element);
			this.factory = factory;
			this.list = factory.createObservable(element);
			getChildren().add(new TreeItem<>());
			
			expandedProperty().addListener((o) -> {
				if( isExpanded() ) {
					if( ! this.hasLoadedChildren ) {
						getChildren().clear();
						loadChildren();
					}
				}
			});
		}
		
//		@Override
//		public ObservableList<TreeItem<T>> getChildren() {
//			if (this.hasLoadedChildren == false) {
//				loadChildren();
//			}
//			return super.getChildren();
//		}
		
//		@Override
//		public boolean isLeaf() {
//			if( this.hasLoadedChildren ) {
//				loadChildren();
//			}
//			return super.isLeaf();
//		}

		// public boolean isLeaf() {
		// if (this.hasLoadedChildren == false) {
		// loadChildren();
		// }
		// return super.getChildren().isEmpty();
		// }

		@SuppressWarnings("null")
		private void loadChildren() {
			this.hasLoadedChildren = true;
			if (this.list != null) {
				final ObservableList<@NonNull TreeItem<@NonNull T>> itemList = getChildren();
				this.list.addListChangeListener(new IListChangeListener() {

					@Override
					public void handleListChange(ListChangeEvent event) {
						event.diff.accept(new ListDiffVisitor() {

							@Override
							public void handleRemove(int index, Object element) {
								if (itemList.size() < index) {
									TreeItem<T> t = itemList.get(index);
									if (t.getValue() == element) {
										itemList.remove(index);
									} else {
										Iterator<TreeItem<T>> it = itemList.iterator();
										while (it.hasNext()) {
											if (it.next().getValue() == element) {
												it.remove();
												break;
											}
										}
									}
								}
							}

							@SuppressWarnings({ "unchecked" })
							@Override
							public void handleAdd(int index, Object element) {
								if (itemList.size() > index) {
									itemList.add(index, new TreeItemImpl<@NonNull T>((T) element, TreeItemImpl.this.factory));
								} else {
									itemList.add(new TreeItemImpl<@NonNull T>((T) element, TreeItemImpl.this.factory));
								}
							}
						});
					}
				});
				for (Object o : this.list) {
					@SuppressWarnings("unchecked")
					T t = (T) o;
					itemList.add(new TreeItemImpl<@NonNull T>(t, this.factory));
				}
			}
		}

	}
}
