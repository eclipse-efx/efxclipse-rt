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
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.e4.core.internal.contexts.Computation;
import org.eclipse.e4.core.internal.contexts.EclipseContext;

/**
 * Enumeration of every node type in the context outline view.
 */
enum NodeType {

	LOCAL_VALUE_NODE {

		private static final String NO_VALUE_COULD_BE_COMPUTED = "No value could be yet computed";

		private static final String LOCAL_VALUE_NODE = "Local values managed  by this context";

		private static final String LOCAL_NODE_TOOLTIP_TEXT = "This part contains  values set in this context and then injected here or in children\n\n"
				+ "If the value is injected using this context, you can expand the node to see where\n\n"
				+ "If the value is injected using a child context you can find it in the second part for this child ";

		@Override
		protected ContextOutlineElement createElement(ContextOverviewElement parent, ContextOutlineElement directParent,
				Object content) {
			return new ContextOutlineElement(parent, NodeType.LOCAL_VALUE_NODE, LOCAL_VALUE_NODE, "",
					EntryTypes.LOCAL_VARIABLE, directParent);
		}

		@Override
		protected List<ContextOutlineElement> getChildren(ContextOutlineElement contextOutlineElement) {

			EclipseContext context = (EclipseContext) contextOutlineElement.getParent().getIEclipseContext();

			List<ContextOutlineElement> result = new ArrayList<>();

			result.addAll(context.localData().entrySet().stream().map(entry -> {
				return NodeType.MAP_ENTRY.createElement(contextOutlineElement.getParent(), contextOutlineElement,
						entry);
			}).collect(Collectors.toList()));

			// For context function, we have to compute the value (if possible),
			// and display it as a standard value
			Map<String, Object> cfValues = new HashMap<String, Object>();
			for (String key : context.localContextFunction().keySet())
				try {
					cfValues.put(key, context.get(key));
				} catch (Exception e) {
					cfValues.put(key, NO_VALUE_COULD_BE_COMPUTED + " (Exception : " + e.getClass().getName() + ")");
				}
			result.addAll(cfValues.entrySet().stream().map(entry -> {
				return NodeType.MAP_ENTRY.createElement(contextOutlineElement.getParent(), contextOutlineElement,
						entry);
			}).collect(Collectors.toList()));
			return result;
		}

		@Override
		public String getTooltipText(EclipseContext context, String key) {
			return LOCAL_NODE_TOOLTIP_TEXT;
		}
	},

	INHERITED_INJECTED_VALUE_NODE {

		private static final String INHERITED_NODE_TOOLTIP_TEXT = "This part contains the values injected or updated using this context, but initialized in a parent context\n\n"
				+ "Expand nodes to see where values are injected or updated";

		private static final String INHERITED_INJECTED_VALUE_NODE = "Inherited values injected or updated using this context";

		@Override
		protected ContextOutlineElement createElement(ContextOverviewElement parent, ContextOutlineElement directParent,
				Object content) {
			return new ContextOutlineElement(parent, NodeType.INHERITED_INJECTED_VALUE_NODE,
					INHERITED_INJECTED_VALUE_NODE, "", EntryTypes.INHERITED_VARIABLE, directParent);
		}

		@Override
		protected List<ContextOutlineElement> getChildren(ContextOutlineElement contextOutlineElement) {

			EclipseContext context = (EclipseContext) contextOutlineElement.getParent().getIEclipseContext();

			// Search for all values injected using this context but defined in
			// parent
			List<ContextOutlineElement> result = new ArrayList<>();

			// Keep only the names that are not already displayed in local
			// values
			Collection<String> localKeys = context.localData().keySet();
			Collection<String> localContextFunctionsKeys = context.localContextFunction().keySet();

			if (context.getRawListenerNames() != null) {
				for (String name : context.getRawListenerNames()) {
					if (!localKeys.contains(name) && !localContextFunctionsKeys.contains(name))
						result.add(
								STRING.createElement(contextOutlineElement.getParent(), contextOutlineElement, name));
				}
			}
			return result;

		}

		@Override
		public String getTooltipText(EclipseContext context, String key) {
			return INHERITED_NODE_TOOLTIP_TEXT;
		}

	},

	MAP_ENTRY {

		private static final String MAP_ENTRY_NODE_NO_INJECTION_TOOLTIP_TEXT = "This value is set here but not injected using this context (look in children context)";

		private static final String MAP_ENTRY_NODE_WITH_CHLDREN_TOOLTIP_TEXT = "Expand this node to see where this value is injected or updated";

		private static final String MAP_ENTRY_NODE_IS_A_CONTEXT_FUNTION_TOOLTIP_TEXT = "This value is created by the Context Function : ";

		@Override
		protected ContextOutlineElement createElement(ContextOverviewElement parent, ContextOutlineElement directParent,
				Object content) {
			Map.Entry<String, ?> entry = (Map.Entry<String, ?>) content;
			return new ContextOutlineElement(parent, MAP_ENTRY, entry.getKey(), "" + entry.getValue(),
					geEntryTypes((EclipseContext) parent.getIEclipseContext(), entry), directParent);
		}

		private EntryTypes geEntryTypes(EclipseContext context, Map.Entry<String, ?> mapEntry) {
			if (isAContextKeyFunction(context, mapEntry.getKey())) {
				return EntryTypes.CONTEXT_FUNCTION;
			} else {
				// It is a value. If it is injected somewhere, display the
				// inject image
				return hasChildren((EclipseContext) context, mapEntry.getKey()) ? EntryTypes.INJECT
						: EntryTypes.VALUE_IN_CONTEXT;
			}
		}

		@Override
		public String getTooltipText(EclipseContext context, String key) {

			if (isAContextKeyFunction(context, key)) {
				return MAP_ENTRY_NODE_IS_A_CONTEXT_FUNTION_TOOLTIP_TEXT
						+ context.localContextFunction().get(key).getClass().getCanonicalName();
			} else if (hasChildren(context, key)) {
				return MAP_ENTRY_NODE_WITH_CHLDREN_TOOLTIP_TEXT;
			} else {
				return MAP_ENTRY_NODE_NO_INJECTION_TOOLTIP_TEXT;
			}

		}

		private boolean hasChildren(EclipseContext context, String key) {

			Set<Computation> listeners = context.getListeners(key);
			return listeners != null && listeners.size() > 0;
		}

		/**
		 * Compute it the current entry in context is a context function
		 *
		 * @param element
		 * @return true if element is a context function
		 */
		boolean isAContextKeyFunction(EclipseContext context, String key) {
			// Just check if key in element is a key in the map of context
			// functions.
			return (context.localContextFunction().containsKey(key));
		}

		@Override
		protected List<ContextOutlineElement> getChildren(ContextOutlineElement contextOutlineElement) {

			EclipseContext context = (EclipseContext) contextOutlineElement.getParent().getIEclipseContext();

			Set<Computation> listeners = getListeners(context, contextOutlineElement.getKey().toString());
			return (listeners == null) ? Collections.emptyList() : listeners.stream().map(compu -> {
				return COMPUTATION.createElement(contextOutlineElement.getParent(), contextOutlineElement, compu);
			}).collect(Collectors.toList());

		}

		private Set<Computation> getListeners(EclipseContext context, String key) {
			// Ask the context to know if there are listeners for this value
			return context.getListeners(key);
		}
	},

	STRING {

		private static final String STRING_NODE_WITH_CHLDREN_TOOLTIP_TEXT = "Expand this node to see where this value is injected or updated";

		@Override
		protected ContextOutlineElement createElement(ContextOverviewElement parent, ContextOutlineElement directParent,
				Object content) {
			String name = (String) content;
			return new ContextOutlineElement(parent, STRING, name, "", EntryTypes.INJECT, directParent);
		}

		@Override
		protected List<ContextOutlineElement> getChildren(ContextOutlineElement contextOutlineElement) {

			EclipseContext context = (EclipseContext) contextOutlineElement.getParent().getIEclipseContext();

			return context.getListeners(contextOutlineElement.getKey().toString()).stream().map(compu -> {

				return NodeType.COMPUTATION.createElement(contextOutlineElement.getParent(), contextOutlineElement,
						compu);
			}).collect(Collectors.toList());

		}

		@Override
		public String getTooltipText(EclipseContext context, String key) {
			String name = (String) key;
			Set<Computation> listeners = context.getListeners(name);
			if (listeners != null && listeners.size() > 0) {
				return STRING_NODE_WITH_CHLDREN_TOOLTIP_TEXT;
			}
			return "";
		}

	},

	COMPUTATION {

		private static final String UPDATED_IN_CLASS = "Updated in class :";
		private static final String INJECTED_IN_FIELD = "Injected in field :";
		private static final String INJECTED_IN_METHOD = "Injected in method :";

		@Override
		protected ContextOutlineElement createElement(ContextOverviewElement parent, ContextOutlineElement directParent,
				Object content) {
			Computation compu = (Computation) content;
			return new ContextOutlineElement(parent, COMPUTATION, getValue(compu), content.toString(),
					getEntryType(compu), directParent);
		}

		private EntryTypes getEntryType(Computation compu) {

			// For a computation : display field, method or class in key column
			// and
			// value in value column
			String txt = compu.toString();

			if (txt.contains("#")) {
				return EntryTypes.PUBLIC_METHOD;
			} else if (txt.contains("@")) {
				return EntryTypes.CONTEXT_FUNCTION;
			} else {
				return EntryTypes.PUBLIC_FIELD;
			}
		}

		private String getValue(Computation compu) {
			// For a computation : display field or method in key column and the
			// value in value
			String txt = compu.toString();
			if (txt.contains("#")) {
				return INJECTED_IN_METHOD;
			} else if (txt.contains("@")) {
				return UPDATED_IN_CLASS;
			} else {
				return INJECTED_IN_FIELD;
			}
		}

		@Override
		protected List<ContextOutlineElement> getChildren(ContextOutlineElement contextOutlineElement) {
			return Collections.emptyList();
		}

		@Override
		public String getTooltipText(EclipseContext context, String key) {
			return "";
		}
	};

	public abstract String getTooltipText(EclipseContext context, String key);

	protected abstract List<ContextOutlineElement> getChildren(ContextOutlineElement contextOutlineElement);

	protected abstract ContextOutlineElement createElement(ContextOverviewElement parent,
			ContextOutlineElement directParent, Object content);

	private void createChildren(ContextOutlineElement element) {
		element.getNodeType().getChildren(element).forEach(this::createChildren);
	}

	ContextOutlineElement createElement(ContextOverviewElement parent) {
		ContextOutlineElement element = createElement(parent, null, null);
		createChildren(element);
		return element;
	}
}
