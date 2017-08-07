/*******************************************************************************
 * Copyright (c) 2015 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.controls.filesystem;

import org.eclipse.fx.ui.controls.filesystem.skin.ResourceTreeViewSkin;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Control;
import javafx.scene.control.Skin;

/**
 * View {@link ResourceItem} as a tree
 */
public class ResourceTreeView extends Control {
	private @NonNull ListProperty<@NonNull DirItem> rootDirectories = new SimpleListProperty<>(this, "rootDirectories", FXCollections.observableArrayList()); //$NON-NLS-1$

	/**
	 * The list of root directories
	 *
	 * @return property with the root directories
	 */
	public final ListProperty<@NonNull DirItem> rootDirectoriesProperty() {
		return this.rootDirectories;
	}

	/**
	 * @return the root directories
	 */
	public final ObservableList<@NonNull DirItem> getRootDirectories() {
		return this.rootDirectoriesProperty().get();
	}

	/**
	 * Set new root directories
	 *
	 * @param rootDirectories
	 *            the root directories
	 */
	public final void setRootDirectories(@Nullable final ObservableList<@NonNull DirItem> rootDirectories) {
		this.rootDirectoriesProperty().set(rootDirectories);
	}

	@SuppressWarnings("all")
	private final ObjectProperty<@NonNull IconSize> iconSize = new SimpleObjectProperty<>(this, "iconSize", IconSize.SMALL); //$NON-NLS-1$

	/**
	 * Size of the icons
	 *
	 * @return the icon size property
	 */
	public final ObjectProperty<@NonNull IconSize> iconSizeProperty() {
		return this.iconSize;
	}

	/**
	 * @return the icon size
	 */
	public final @NonNull IconSize getIconSize() {
		return this.iconSizeProperty().get();
	}

	@Override
	protected Skin<?> createDefaultSkin() {
		return new ResourceTreeViewSkin(this, this.selectedItems);
	}

	@SuppressWarnings("null")
	@NonNull
	private ObservableList<@NonNull ResourceItem> selectedItems = FXCollections.observableArrayList();

	@SuppressWarnings("null")
	@NonNull
	private ObservableList<@NonNull ResourceItem> unmodifiableItemsPaths = FXCollections.unmodifiableObservableList(this.selectedItems);

	/**
	 * @return currently selected directories
	 */
	public ObservableList<@NonNull ResourceItem> getSelectedItems() {
		return this.unmodifiableItemsPaths;
	}

	/**
	 * Set a new icon size
	 *
	 * @param iconSize
	 *            the new icon size
	 */
	public final void setIconSize(@NonNull final IconSize iconSize) {
		this.iconSizeProperty().set(iconSize);
	}

	@Override
	public final String getUserAgentStylesheet() {
		return ResourceTreeView.class.getResource("skin/default.css") //$NON-NLS-1$
				.toExternalForm();
	}
}
