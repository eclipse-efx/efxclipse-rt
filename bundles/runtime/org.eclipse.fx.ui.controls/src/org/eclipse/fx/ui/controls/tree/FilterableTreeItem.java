/*******************************************************************************
 * Copyright (c) 2014 EM-SOFTWARE and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Christoph Keimel <c.keimel@emsw.de> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.controls.tree;

import javafx.beans.binding.Bindings;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.Event;
import javafx.scene.control.TreeItem;

/**
 * An extension of {@link TreeItem} with the possibility to filter its children. To enable filtering 
 * it is necessary to set the {@link TreeItemPredicate}. If a predicate is set, then the tree item
 * will also use this predicate to filter its children (if they are of the type FilterableTreeItem).
 * 
 * A tree item that has children will not be filtered. The predicate will only be evaluated, if the
 * tree item is a leaf. Since the predicate is also set for the child tree items, the tree item in question
 * can turn into a leaf if all its children are filtered.
 *
 * @param <T> The type of the {@link #getValue() value} property within {@link TreeItem}.
 */
public class FilterableTreeItem<T> extends TreeItem<T> {
	final private FilteredList<TreeItem<T>> filteredList;
	
	private ObjectProperty<TreeItemPredicate<T>> predicate = new SimpleObjectProperty<TreeItemPredicate<T>>() {
        @Override
		protected void invalidated() {
            fireChildrenModificationEvent();
        }
    };
	
	/**
	 * Creates a new {@link TreeItem} with sorted children. To enable sorting it is 
	 * necessary to set the {@link TreeItemComparator}. If no comparator is set, then
	 * the tree item will attempt so bind itself to the comparator of its parent.
	 * 
	 * @param value the value of the {@link TreeItem}
	 */
	public FilterableTreeItem(T value) {
		super(value);
		this.filteredList = new FilteredList<>(super.getChildren());
		this.filteredList.predicateProperty().bind(Bindings.createObjectBinding(() -> {
			return child -> {
				// Set the predicate of child items to force filtering
				if (child instanceof FilterableTreeItem) {
					FilterableTreeItem<T> filterableChild = (FilterableTreeItem<T>) child;
					filterableChild.setPredicate(this.predicate.get());
				}
				// If there is no predicate, keep this tree item
				if (this.predicate.get() == null)
					return true;
				// If there are children, keep this tree item
				if (child.getChildren().size() > 0)
					return true;
				// Otherwise ask the TreeItemPredicate
				return this.predicate.get().test(this, child.getValue());
			};
		}, this.predicate));
	}

	/**
	 * This method overrides {@link TreeItem#getChildren()} and returns an
	 * unmodifiable {@link FilteredList} as the children may only be changed
	 * via the underlying model.
	 * 
	 * @see #getInternalChildren()
	 */
	@Override
	public ObservableList<TreeItem<T>> getChildren() {
		return this.filteredList;
	}
	
	/**
	 * Returns the list of children that is backing the filtered list.
	 * @return underlying list of children
	 */
	public ObservableList<TreeItem<T>> getInternalChildren() {
		return super.getChildren();
	}
	
	/*
	 * Currently we need to fire this event to update the tree view on changes to the filter
	 * predicate, otherwise the displayed contents will not be updated: Tested with 8u45
	 */
	void fireChildrenModificationEvent() {
		TreeModificationEvent<T> event = new TreeModificationEvent<T>(TreeItem.childrenModificationEvent(), this);
		Event.fireEvent(this, event);
	}
	
	/*
	 * Workaround while we wait for RT-40790. We need to override this otherwise the TreeView will
	 * show collapse/expand controls for folders that are empty after filtering
	 * @see https://javafx-jira.kenai.com/browse/RT-40790
	 * @see javafx.scene.control.TreeItem#isLeaf()
	 */
	@Override
	public boolean isLeaf() {
		return getChildren().isEmpty();
	}

	/**
	 * @return the predicate property
	 */
	public final ObjectProperty<TreeItemPredicate<T>> predicateProperty() {
        return this.predicate;
    }

	/**
	 * @return the predicate
	 */
    public final TreeItemPredicate<T> getPredicate() {
        return this.predicate.get();
    }

    /**
     * Set the predicate
     * @param predicate the predicate
     */
    public final void setPredicate(TreeItemPredicate<T> predicate) {
    	this.predicate.set(predicate);
    }
}
