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

import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;

public class TreeUtil {
	public static <T> TreeItem<T> createModel(T root, ObservableFactory<T> factory) {
		return new TreeItemImpl<T>(root,factory);
	}

	public interface ObservableFactory<T> {
		public IObservableList createObservable(T parent);
	}

	static class TreeItemImpl<T> extends TreeItem<T> {
		private IObservableList list;
		private ObservableFactory<T> factory;
		private boolean hasLoadedChildren = false;

		public TreeItemImpl(T element, ObservableFactory<T> factory) {
			setValue(element);
			this.factory = factory;
			this.list = factory.createObservable(element);
		}

		@Override
		public ObservableList<TreeItem<T>> getChildren() {
			if (hasLoadedChildren == false) {
				loadChildren();
			}
			return super.getChildren();
		}

		public boolean isLeaf() {
			if (hasLoadedChildren == false) {
				loadChildren();
			}
			return super.getChildren().isEmpty();
		}
		
		private void loadChildren() {
			hasLoadedChildren = true;
			if( list != null ) {
				final ObservableList<TreeItem<T>> itemList = getChildren();
				list.addListChangeListener(new IListChangeListener() {
					
					@Override
					public void handleListChange(ListChangeEvent event) {
						event.diff.accept(new ListDiffVisitor() {
							
							@Override
							public void handleRemove(int index, Object element) {
								if( itemList.size() < index ) {
									TreeItem<T> t = itemList.get(index);
									if( t.getValue() == element ) {
										itemList.remove(index);
									} else {
										Iterator<TreeItem<T>> it = itemList.iterator();
										while(it.hasNext()) {
											if( it.next().getValue() == element ) {
												it.remove();
												break;
											}
										}
									}
								}
							}
							
							@Override
							public void handleAdd(int index, Object element) {
								if( itemList.size() > index ) {
									itemList.add(index, new TreeItemImpl<T>((T) element, factory));
								} else {
									itemList.add(new TreeItemImpl<T>((T) element, factory));
								}
							}
						});
					}
				});
				for( Object o : list ) {
					itemList.add(new TreeItemImpl<T>((T) o, factory));
				}
			}
		}

	}
}
