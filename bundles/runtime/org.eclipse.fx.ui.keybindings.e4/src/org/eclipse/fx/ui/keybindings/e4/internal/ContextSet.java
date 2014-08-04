/*******************************************************************************
 * Copyright (c) 2010 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 ******************************************************************************/

package org.eclipse.fx.ui.keybindings.e4.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.core.commands.common.NotDefinedException;
import org.eclipse.core.commands.contexts.Context;
import org.eclipse.core.commands.contexts.ContextManager;
import org.eclipse.jdt.annotation.NonNull;

/**
 * A collection of contexts
 */
public class ContextSet {
	/**
	 * An empty set
	 */
	@SuppressWarnings("null")
	@NonNull
	public static ContextSet EMPTY = new ContextSet(Collections.emptyList());

	/**
	 * A context comparator
	 */
	public static class CComp implements Comparator<Context> {
		private ContextManager manager;

		/**
		 * Create a comparator
		 * 
		 * @param manager
		 *            the context manager to use
		 */
		public CComp(ContextManager manager) {
			this.manager = manager;
		}

		@Override
		public int compare(Context o1, Context o2) {
			if (o1.equals(o2)) {
				return 0;
			}
			int l1 = getLevel(o1);
			int l2 = getLevel(o2);
			if (l1 != l2) {
				return l1 - l2;
			}
			return o1.getId().compareTo(o2.getId());
		}

		private int getLevel(Context c) {
			int l = 0;
			try {
				String parentId = c.getParentId();
				while (parentId != null) {
					l++;
					Context context = this.manager.getContext(parentId);
					parentId = context.getParentId();
				}
			} catch (NotDefinedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return l;
		}
	}

	private static Comparator<Context> CONTEXT_COMP = null;

	/**
	 * Set a default comparator
	 * 
	 * @param comp
	 *            the compartor
	 */
	public static void setComparator(Comparator<Context> comp) {
		CONTEXT_COMP = comp;
	}

	/**
	 * @return the current comparator
	 */
	public static Comparator<Context> getComparator() {
		return CONTEXT_COMP;
	}

	@NonNull
	private List<@NonNull Context> contexts;

	/**
	 * Create a new context set
	 * 
	 * @param c
	 *            the context set
	 */
	public ContextSet(@NonNull Collection<@NonNull Context> c) {
		this.contexts = new ArrayList<>(c);
		Collections.sort(this.contexts, CONTEXT_COMP);
	}
	
	/**
	 * @return the contexts
	 */
	public List<@NonNull Context> getContexts() {
		return this.contexts;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof ContextSet)) {
			return false;
		}
		return this.contexts.equals(((ContextSet) o).contexts);
	}

	@Override
	public int hashCode() {
		return this.contexts.hashCode();
	}
}
