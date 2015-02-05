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

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ObjectPropertyBase;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.Control;
import javafx.scene.control.Skin;

import org.eclipse.fx.ui.controls.filesystem.skin.DirectoryViewSkin;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * Control to view the content of a directory
 *
 * @since 1.2
 */
public class DirectoryView extends Control {

	/**
	 * The display type
	 */
	public enum DisplayType {
		// GRID,
		/**
		 * Display the items are a list
		 */
		LIST
	}

	@NonNull
	private final ObjectProperty<@Nullable DirItem> dir = new SimpleObjectProperty<>(
			this, "dir"); //$NON-NLS-1$

	@NonNull
	private final ObjectProperty<@NonNull DisplayType> displayType = new SimpleObjectProperty<>(
			this, "displayType", DisplayType.LIST); //$NON-NLS-1$

	@SuppressWarnings("all")
	@NonNull
	private final ObjectProperty<@NonNull IconSize> iconSize = new SimpleObjectProperty<>(
			this, "iconSize", IconSize.SMALL); //$NON-NLS-1$

	@NonNull
	private final ObjectProperty<@Nullable EventHandler<@NonNull ResourceEvent<@NonNull ResourceItem>>> onOpenResource = new ObjectPropertyBase<@Nullable EventHandler<@NonNull ResourceEvent<@NonNull ResourceItem>>>() {
		@SuppressWarnings({ "synthetic-access", "null" })
		@Override
		protected void invalidated() {
			setEventHandler(ResourceEvent.openResourceEvent(), get());
		}

		@Override
		public Object getBean() {
			return DirectoryView.this;
		}

		@Override
		public String getName() {
			return "onOpenResource"; //$NON-NLS-1$
		}
	};

	@SuppressWarnings("null")
	@NonNull
	private ObservableList<@NonNull ResourceItem> selectedItems = FXCollections
			.observableArrayList();

	@SuppressWarnings("null")
	@NonNull
	private ObservableList<@NonNull ResourceItem> unmodifiableItemsPaths = FXCollections
			.unmodifiableObservableList(this.selectedItems);

	@Override
	public final String getUserAgentStylesheet() {
		return DirectoryView.class.getResource("skin/default.css") //$NON-NLS-1$
				.toExternalForm();
	}

	/**
	 * Directory to display
	 *
	 * @return the directory property
	 */
	public final @NonNull ObjectProperty<@Nullable DirItem> dirProperty() {
		return this.dir;
	}

	/**
	 * @return the current directory
	 */
	public final @Nullable DirItem getDir() {
		return this.dirProperty().get();
	}

	/**
	 * Set a new directory to display
	 *
	 * @param dir
	 *            the directory
	 */
	public final void setDir(@Nullable final DirItem dir) {
		this.dirProperty().set(dir);
	}

	/**
	 * The presentation type of the content
	 *
	 * @return the display type property
	 */
	public final @NonNull ObjectProperty<@NonNull DisplayType> displayTypeProperty() {
		return this.displayType;
	}

	/**
	 * @return the display type
	 */
	public final @NonNull DisplayType getDisplayType() {
		return this.displayTypeProperty().get();
	}

	/**
	 * Set a new display type
	 *
	 * @param displayType
	 *            the type
	 */
	public final void setDisplayType(@NonNull final DisplayType displayType) {
		this.displayTypeProperty().set(displayType);
	}

	/**
	 * Size of the icons
	 *
	 * @return the icon size property
	 */
	public final @NonNull ObjectProperty<@NonNull IconSize> iconSizeProperty() {
		return this.iconSize;
	}

	/**
	 * @return the icon size
	 */
	public final @NonNull IconSize getIconSize() {
		return this.iconSizeProperty().get();
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

	/**
	 * Event handler called when a resource is opened
	 *
	 * @return the property
	 */
	public final @NonNull ObjectProperty<@Nullable EventHandler<@NonNull ResourceEvent<@NonNull ResourceItem>>> onOpenResourceProperty() {
		return this.onOpenResource;
	}

	/**
	 * @return the current event handler
	 */
	public final @Nullable EventHandler<@NonNull ResourceEvent<@NonNull ResourceItem>> getOnOpenResource() {
		return this.onOpenResourceProperty().get();
	}

	/**
	 * Set a handler to invoke when a resource is opened
	 *
	 * @param onOpenResource
	 *            the event handler
	 */
	public final void setOnOpenResource(
			final @Nullable EventHandler<@NonNull ResourceEvent<@NonNull ResourceItem>> onOpenResource) {
		this.onOpenResourceProperty().set(onOpenResource);
	}

	@Override
	protected Skin<?> createDefaultSkin() {
		return new DirectoryViewSkin(this, this.selectedItems);
	}

	/**
	 * @return read only list of currently selected elements
	 */
	public @NonNull ObservableList<@NonNull ResourceItem> getSelectedItems() {
		return this.unmodifiableItemsPaths;
	}

}
