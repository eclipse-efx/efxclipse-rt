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

import java.util.Collections;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;

import javafx.event.Event;
import javafx.event.EventTarget;
import javafx.event.EventType;

/**
 * A resource event
 *
 * @param <T>
 *            the resource type
 */
public class ResourceEvent<@NonNull T extends ResourceItem> extends Event {
	private static final EventType<?> OPEN_RESOURCE = new EventType<>(
			"EFX_CONTROL_OPEN_RESOURCE"); //$NON-NLS-1$

	/**
	 * @return the open resource type
	 */
	@SuppressWarnings("unchecked")
	public static <T extends ResourceItem> EventType<ResourceEvent<@NonNull T>> openResourceEvent() {
		return (EventType<ResourceEvent<@NonNull T>>) OPEN_RESOURCE;
	}

	private final List<ResourceItem> resourceItems;

	ResourceEvent(Object source, EventTarget target,
			EventType<ResourceEvent<T>> type, List<T> resourceItems) {
		super(source, target, type);
		this.resourceItems = Collections.unmodifiableList(resourceItems);
	}

	/**
	 * Create a new event for resource opening
	 *
	 * @param view
	 *            the view
	 * @param resourceItems
	 *            the items
	 * @return a new event
	 */
	public static <@NonNull T extends ResourceItem> ResourceEvent<T> createOpenResource(
			DirectoryView view, List<T> resourceItems) {
		return new ResourceEvent<>(view, view, openResourceEvent(),
				resourceItems);
	}

	/**
	 * Create a new event for resource opening
	 *
	 * @param view
	 *            the view
	 * @param resourceItems
	 *            the items
	 * @return a new event
	 */
	public static <@NonNull T extends ResourceItem> ResourceEvent<T> createOpenResource(
			DirectoryTreeView view, List<T> resourceItems) {
		return new ResourceEvent<>(view, view, openResourceEvent(),
				resourceItems);
	}

	/**
	 * @return unmodifiable list of items
	 */
	public List<ResourceItem> getResourceItems() {
		return this.resourceItems;
	}

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

}
