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
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.Control;
import javafx.scene.control.Skin;

import org.eclipse.fx.ui.controls.filesystem.skin.ResourcePreviewSkin;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * Show a preview of {@link ResourceItem}
 */
public class ResourcePreview extends Control {
	@NonNull
	private final ObjectProperty<@Nullable ResourceItem> item = new SimpleObjectProperty<>(
			this, "item"); //$NON-NLS-1$

	/**
	 * The current item displayed
	 *
	 * @return the item property
	 */
	public final @NonNull ObjectProperty<@Nullable ResourceItem> itemProperty() {
		return this.item;
	}

	/**
	 * @return the currently previewed item
	 */
	public final @Nullable ResourceItem getItem() {
		return this.itemProperty().get();
	}

	/**
	 * Set a new item to preview
	 *
	 * @param item
	 *            the item to preview
	 */
	public final void setItem(@Nullable final ResourceItem item) {
		this.itemProperty().set(item);
	}

	// Requires 8u40 to compile
	// @Override
	public final String getUserAgentStylesheet() {
		return DirectoryView.class.getResource("skin/default.css") //$NON-NLS-1$
				.toExternalForm();
	}

	@Override
	protected Skin<?> createDefaultSkin() {
		return new ResourcePreviewSkin(this);
	}
}
