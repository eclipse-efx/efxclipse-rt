/*******************************************************************************
 * Copyright (c) Carl Zeiss Meditec AG
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Thomas Fahrmeyer (lauritziu_ii@yahoo.de) - initial API and implementation
*/
package org.eclipse.fx.tool.context.spy.internal.element;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.e4.core.internal.contexts.EclipseContext;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

/**
 * Represents one element of the context outline view.
 */
public class ContextOutlineElement {

	/**
	 * Context outline element presented as a key or as a value.
	 */
	public class Wrap {
		private final ContextOutlineElement wrapped;

		private final String label;

		Wrap(ContextOutlineElement wrapped, String label) {
			this.wrapped = wrapped;
			this.label = label;
		}

		public ContextOutlineElement getWrapped() {
			return wrapped;
		}

		@Override
		public String toString() {
			return label;
		}

	}

	private final ContextOverviewElement parent;
	private final NodeType nodeType;
	private final String key;
	private final Object value;
	private final EntryTypes entryType;
	private final BooleanProperty markedAsSearchResultProperty = new SimpleBooleanProperty(false);
	private final List<ContextOutlineElement> children = new ArrayList<>();

	ContextOutlineElement(ContextOverviewElement parent, NodeType nodeType, String key, Object value,
			EntryTypes entryType, ContextOutlineElement directParent) {
		this.key = key;
		this.value = value;
		this.parent = parent;
		this.nodeType = nodeType;
		this.entryType = entryType;
		if (directParent != null) {
			directParent.addChild(this);
		}
	}

	private void addChild(ContextOutlineElement child) {
		children.add(child);
	}

	public List<ContextOutlineElement> getChildren() {
		return children;
	}

	public void filterOut() {
		if (parent.isShowAll()){
			return;
		}
		children.retainAll(
				children.stream().filter(child -> (child.markedAsSearchResultProperty().getValue() == Boolean.TRUE)
						|| child.hasMatchingChild())
						.collect(Collectors.toList()));
	}

	private boolean hasMatchingChild() {
		return children.stream().filter(child->child.markedAsSearchResultProperty.getValue()== Boolean.TRUE).count()>0;
	}

	public Wrap getKey() {
		return new Wrap(this, key);
	}

	public Wrap getValue() {
		return new Wrap(this, "" + value);
	}

	public String getImageURL() {
		return entryType.getImageURL();
	}

	public ContextOverviewElement getParent() {
		return parent;
	}

	public NodeType getNodeType() {
		return nodeType;
	}

	public BooleanProperty markedAsSearchResultProperty() {
		return markedAsSearchResultProperty;
	}

	public void setMaredAsSearchResult(boolean marked) {
		markedAsSearchResultProperty.setValue(marked);
	}

	public String getTooltipText() {
		return nodeType.getTooltipText((EclipseContext)parent.getIEclipseContext(), key);
	}


}
