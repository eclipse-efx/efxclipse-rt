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

import java.util.Comparator;

import javafx.beans.binding.Bindings;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.TreeItem;

/**
 * An extension of {@link TreeItem} with the possibility to sort its children. To enable sorting
 * it is necessary to set the {@link TreeItemComparator}. If no comparator is set, then
 * the tree item will attempt so bind itself to the comparator of its parent.
 *
 * @param <T> The type of the {@link #getValue() value} property within {@link TreeItem}.
 */
public class SortableTreeItem<T> extends FilterableTreeItem<T> {
	final private SortedList<TreeItem<T>> sortedList;

	private ObjectProperty<TreeItemComparator<T>> comparator = new SimpleObjectProperty<TreeItemComparator<T>>();

	/**
	 * Creates a new {@link TreeItem} with sorted children. To enable sorting it is
	 * necessary to set the {@link TreeItemComparator}. If no comparator is set, then
	 * the tree item will attempt so bind itself to the comparator of its parent.
	 *
	 * @param value the value of the {@link TreeItem}
	 */
	public SortableTreeItem(T value) {
		super(value);
		this.sortedList = new SortedList<>(super.getChildren());
		this.sortedList.comparatorProperty().bind(Bindings.createObjectBinding(() -> {
			if (this.comparator.get() == null)
				return null;
			// Regression in Mars.1 JDT-Core see https://bugs.eclipse.org/bugs/show_bug.cgi?id=482416
			Comparator<TreeItem<T>> cp = (o1, o2) -> this.comparator.get().compare(this, o1.getValue(), o2.getValue());
			return cp;
		}, this.comparator));
		parentProperty().addListener((o, oV, nV) -> {
			if (nV != null && nV instanceof SortableTreeItem && this.comparator.get() == null) {
				this.comparator.bind(((SortableTreeItem<T>) nV).comparatorProperty());
			}
		});
		setHiddenFieldChildren(this.sortedList);
	}

	/**
	 * @return the comparator property
	 */
	public final ObjectProperty<TreeItemComparator<T>> comparatorProperty() {
        return this.comparator;
    }

	/**
	 * @return the comparator
	 */
    public final TreeItemComparator<T> getComparator() {
        return this.comparator.get();
    }

    /**
     * Set the comparator
     * @param comparator the comparator
     */
    public final void setComparator(TreeItemComparator<T> comparator) {
    	this.comparator.set(comparator);
    }
}
