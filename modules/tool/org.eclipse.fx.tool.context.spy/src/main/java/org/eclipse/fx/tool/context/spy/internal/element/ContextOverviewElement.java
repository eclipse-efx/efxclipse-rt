/*******************************************************************************
 * Copyright (c) Carl Zeiss Meditec AG
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Thomas Fahrmeyer (lauritziu_ii@yahoo.de) - initial API and implementation
*/
package org.eclipse.fx.tool.context.spy.internal.element;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.internal.contexts.EclipseContext;
import org.eclipse.e4.ui.model.application.MApplicationElement;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ReadOnlyBooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

/**
 * Represents one element of the context overview view.
 */
public class ContextOverviewElement {

	private final IEclipseContext iEclipseContext;
	private final List<ContextOverviewElement> children;
	private final BooleanProperty expandedProperty = new SimpleBooleanProperty(true);
	private final BooleanProperty markedAsSearchResultProperty = new SimpleBooleanProperty(false);
	private final BooleanProperty showAllProperty = new SimpleBooleanProperty(true);

	public ContextOverviewElement(IEclipseContext iEclipseContext, List<ContextOverviewElement> children) {
		this.iEclipseContext = iEclipseContext;
		this.children = children;
	}

	public List<ContextOverviewElement> getChildren() {
		return children;
	}

	public BooleanProperty expandedProperty() {
		return expandedProperty;
	}

	public void setExpanded(boolean expanded) {
		expandedProperty.setValue(expanded);
	}

	public ReadOnlyBooleanProperty markedAsSearchResultProperty() {
		return markedAsSearchResultProperty;
	}

	public void setMaredAsSearchResult(boolean marked) {
		markedAsSearchResultProperty.setValue(marked);
	}

	public void showAll(boolean showAll) {
		showAllProperty.setValue(showAll);
	}
	
	public boolean isShowAll() {
		return showAllProperty.getValue();
	}
	
	public ReadOnlyBooleanProperty showAllProperty() {
		return showAllProperty;
	}
	
	/**
	 * This method search for an object and check if it contains the text or a
	 * pattern matching this text
	 */
	public boolean containsText(String searchText) {
		// It is useless to store the values in a map, because context
		// changes
		// everytime and it should be tracked.
		Collection<String> values = computeValues(searchText);

		// Search if string is just in one of the values... manage ignore
		// case
		// and contain...
		boolean found = false;
		for (String s : values) {
			if (matchText(s, searchText)) {
				found = true;
				break;
			}
		}
		return found;
	}

	public boolean matchText(String text, String searchText) {
		return ((text == null) || (searchText == null)) ? false : text.toLowerCase().contains(searchText);
	}

	/**
	 * Extract all string values in context
	 *
	 * @param ctx
	 * @return
	 */
	@SuppressWarnings("restriction")
	private Collection<String> computeValues(String searchText) {
		Collection<String> result = new ArrayList<String>();
		if (iEclipseContext instanceof EclipseContext) {
			// Search for all strings in this context (values and context
			// function)

			EclipseContext currentContext = (EclipseContext) iEclipseContext;
			extractStringsFromMap(currentContext.localData(), result);

			// Search also in context functions
			extractStringsFromMap(currentContext.localContextFunction(), result);

			// Search for the inherited values injected using this context
			// but
			// defined in
			// parent
			// Keep only the names that are not already displayed in local
			// values
			Collection<String> localKeys = currentContext.localData().keySet();
			Collection<String> localContextFunctionsKeys = currentContext.localContextFunction().keySet();

			if (currentContext.getRawListenerNames() != null) {
				for (String name : currentContext.getRawListenerNames()) {
					if (!localKeys.contains(name) && !localContextFunctionsKeys.contains(name))
						result.add(name);
				}
			}

		} else {
			// log.warn("Warning : the received EclipseContext has not the
			// expected type. It is a : "
			// + ctx.getClass().toString());
		}

		return result;
	}

	/**
	 *
	 * @param map
	 *            the map to extract the strings (keys and values)
	 * @param result
	 *            the result to fill with strings
	 */
	private void extractStringsFromMap(Map<String, Object> map, Collection<String> result) {
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			result.add(entry.getKey().toString());
			Object value = entry.getValue();
			if (value != null) {
				result.add(value.toString());
			}
		}
	}

	public List<ContextOutlineElement> getOutline() {
		return Arrays.asList(NodeType.INHERITED_INJECTED_VALUE_NODE.createElement(this),
				NodeType.LOCAL_VALUE_NODE.createElement(this));
	}

	IEclipseContext getIEclipseContext() {
		return iEclipseContext;
	}

	@Override
	public String toString() {
		Object domElement = iEclipseContext.get("fx.rendering.domElement");
        return iEclipseContext.toString() +
                (domElement==null?"":  "/"+ ((MApplicationElement)domElement).getElementId());
	}

	

	
}
