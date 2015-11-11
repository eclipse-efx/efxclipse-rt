/*******************************************************************************
 * Copyright (c) 2015 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.workbench.renderers.base.services;

import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WDragTargetWidget.DropLocation;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * Service to constraint drag and drop operations
 */
public interface DnDService {
	/**
	 * Check if a split is allowed
	 *
	 * @param element
	 *            the element
	 * @param dropType
	 * @param sourceElement
	 * @return <code>true</code> if a split is allowed
	 */
	public boolean splitAllowed(@NonNull MUIElement element, @NonNull MUIElement sourceElement, @NonNull DropLocation dropType);

	/**
	 * Check if a detach is allowed
	 *
	 * @param element
	 *            the element to detach
	 * @return <code>true</code> if a detach is allowed
	 */
	public boolean detachAllowed(@NonNull MUIElement element);

	/**
	 * Check if reordering is allowed
	 *
	 * @param reference
	 *            the reference element (=sibling)
	 * @param sourceElement
	 *            the source element
	 * @param dropLocation
	 *            the drop location
	 * @return <code>true</code> if a drop is allowed there
	 */
	public boolean reorderAllowed(@Nullable MUIElement reference, @NonNull MUIElement sourceElement, DropLocation dropLocation);

	/**
	 * Check if a insert is allowed
	 *
	 * @param reference
	 *            the reference (=container)
	 * @param sourceElement
	 *            the source element
	 * @return <code>true</code> if a drop is allowed there
	 */
	public boolean insertAllowed(@Nullable MUIElement reference, @NonNull MUIElement sourceElement);

	/**
	 * Check if we can reparent the element
	 *
	 * @param element
	 *            the element
	 * @return <code>true</code> if a reparent is allowed
	 */
	public boolean repartentAllowed(@NonNull MUIElement element);

	/**
	 * Handle the detaching of an element
	 *
	 * @param x
	 *            the x coordinate the new window should show up relative to the
	 *            screen
	 * @param y
	 *            the y coordinate the new window should show up relative to the
	 *            screen
	 *
	 * @param sourceElement
	 *            the source element
	 * @return <code>true</code> if detaching is handled or <code>false</code>
	 *         if the default should be used
	 */
	public boolean handleDetach(double x, double y, @NonNull MUIElement sourceElement);

	/**
	 * Handle the reordering
	 *
	 * @param reference
	 *            the reference (=sibling)
	 * @param sourceElement
	 *            the source element
	 * @param dropLocation
	 *            the drop location
	 * @return <code>true</code> if handled or <code>false</code> if the default
	 *         should be used
	 */
	public boolean handleReorder(@NonNull MUIElement reference, @NonNull MUIElement sourceElement, @NonNull DropLocation dropLocation);

	/**
	 * Handle the insert
	 *
	 * @param reference
	 *            the reference (=container)
	 * @param sourceElement
	 *            the source element
	 * @return <code>true</code> if handled or <code>false</code> if the default
	 *         should be used
	 */
	public boolean handleInsert(@Nullable MUIElement reference, @NonNull MUIElement sourceElement);

	/**
	 * Handle the split
	 *
	 * @param reference
	 *            the reference
	 * @param sourceElement
	 *            the source element
	 * @param dropLocation
	 *            the location
	 * @return <code>true</code> if handled or <code>false</code> if the default
	 *         should be used
	 */
	public boolean handleSplit(@Nullable MUIElement reference, @NonNull MUIElement sourceElement, @NonNull DropLocation dropLocation);

	/**
	 * Check if the element can be dragged at all
	 *
	 * @param container
	 *            the container
	 * @param element
	 *            the element
	 * @return <code>true</code> if a drag can start
	 * @since 2.2.0
	 */
	public default boolean dragAllowed(MUIElement container, MUIElement element) {
		return true;
	}

}
