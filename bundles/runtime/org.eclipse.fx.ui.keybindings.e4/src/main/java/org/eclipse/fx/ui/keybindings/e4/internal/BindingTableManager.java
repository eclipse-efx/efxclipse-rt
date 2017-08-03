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
import java.util.List;
import java.util.ListIterator;

import javax.inject.Inject;

import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.core.commands.contexts.Context;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.fx.ui.keybindings.Binding;
import org.eclipse.fx.ui.keybindings.TriggerSequence;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * manage tables of bindings that can be used to look up commands from keys.
 */
public class BindingTableManager {
	private static final String BINDING_TABLE_PREFIX = "bindingTable:"; //$NON-NLS-1$

	@Inject
	private IEclipseContext eclipseContext;

	private ContextSet definedTables = ContextSet.EMPTY;

	private String[] activeSchemeIds;

	/**
	 * Add a binding table
	 * 
	 * @param table
	 *            the table
	 */
	public void addTable(@NonNull BindingTable table) {
		String contextId = getTableId(table.getId());
		if (this.eclipseContext.containsKey(contextId)) {
			return; // it's already there
			//			throw new IllegalArgumentException("Already contains table " + contextId); //$NON-NLS-1$
		}
		this.eclipseContext.set(contextId, table);
		final List<@NonNull Context> contexts = this.definedTables.getContexts();
		if (!contexts.contains(table.getTableId())) {
			// this is only valid because I'm throwing away the old
			// definedTables contextSet
			contexts.add(table.getTableId());
			this.definedTables = createContextSet(contexts);
		}
	}

	private static String getTableId(String id) {
		return BINDING_TABLE_PREFIX + id;
	}

	/**
	 * remove a table
	 * 
	 * @param table
	 *            the table
	 */
	public void removeTable(@NonNull BindingTable table) {
		String contextId = getTableId(table.getId());
		if (!this.eclipseContext.containsKey(contextId)) {
			throw new IllegalArgumentException("Does not contains table " + contextId); //$NON-NLS-1$
		}
		this.eclipseContext.remove(contextId);
		final List<@NonNull Context> contexts = this.definedTables.getContexts();
		if (contexts.contains(table.getTableId())) {
			// this is only valid because I'm throwing away the old
			// definedTables contextSet
			contexts.remove(table.getTableId());
			this.definedTables = createContextSet(contexts);
		}
	}

	/**
	 * Get the table for the give id
	 * 
	 * @param id
	 *            the id
	 * @return the table
	 */
	public @Nullable BindingTable getTable(String id) {
		return (BindingTable) this.eclipseContext.get(getTableId(id));
	}

	/**
	 * @return the current bindings
	 */
	public @NonNull Collection<@NonNull Binding> getActiveBindings() {
		// we're just going through each binding table, and returning a
		// flat list of bindings here
		ArrayList<@NonNull Binding> bindings = new ArrayList<>();
		for (Context ctx : this.definedTables.getContexts()) {
			BindingTable table = getTable(ctx.getId());
			if (table != null) {
				bindings.addAll(table.getBindings());
			}
		}
		return bindings;
	}

	static @NonNull ContextSet createContextSet(@NonNull Collection<@NonNull Context> contexts) {
		return new ContextSet(contexts);
	}

	@Nullable
	Collection<@NonNull Binding> getConflictsFor(@NonNull ContextSet contextSet, @NonNull TriggerSequence triggerSequence) {
		Collection<@NonNull Binding> matches = new ArrayList<>();
		for (Context ctx : contextSet.getContexts()) {
			BindingTable table = getTable(ctx.getId());
			if (table != null) {
				final Collection<@NonNull Binding> matchesFor = table.getConflictsFor(triggerSequence);
				if (matchesFor != null) {
					matches.addAll(matchesFor);
				}
			}
		}
		return matches.size() == 0 ? null : matches;
	}

	@NonNull
	Collection<@NonNull Binding> getAllConflicts() {
		Collection<@NonNull Binding> conflictsList = new ArrayList<>();
		for (Context ctx : this.definedTables.getContexts()) {
			BindingTable table = getTable(ctx.getId());
			if (table != null) {
				Collection<@NonNull Binding> conflictsInTable = table.getConflicts();
				conflictsList.addAll(conflictsInTable);
			}
		}
		return conflictsList;
	}

	@Nullable
	Binding getPerfectMatch(@NonNull ContextSet contextSet, @NonNull TriggerSequence triggerSequence) {
		Binding result = null;
		Binding currentResult = null;
		List<Context> contexts = contextSet.getContexts();
		ListIterator<Context> it = contexts.listIterator(contexts.size());
		while (it.hasPrevious()) {
			Context c = it.previous();
			BindingTable table = getTable(c.getId());
			if (table != null) {
				currentResult = table.getPerfectMatch(triggerSequence);
			}
			if (currentResult != null) {
				if (isMostActiveScheme(currentResult)) {
					return currentResult;
				}
				if (result == null) {
					result = currentResult;
				} else {
					int rc = compareSchemes(result.getSchemeId(), currentResult.getSchemeId());
					if (rc < 0) {
						result = currentResult;
					}
				}
			}
		}
		return result;
	}

	private boolean isMostActiveScheme(Binding currentResult) {
		if (this.activeSchemeIds == null || this.activeSchemeIds.length < 2) {
			return true;
		}
		final String mostActive = this.activeSchemeIds[0];
		return mostActive == null ? false : mostActive.equals(currentResult.getSchemeId());
	}

	@Nullable Binding getBestSequenceFor(@NonNull ContextSet contextSet, @NonNull ParameterizedCommand parameterizedCommand) {
		List<@NonNull Binding> bindings = getSequencesFor(contextSet, parameterizedCommand);
		if (bindings.size() == 0) {
			return null;
		}
		return bindings.get(0);
	}

	@NonNull List<@NonNull Binding> getSequencesFor(@NonNull ContextSet contextSet, @NonNull ParameterizedCommand parameterizedCommand) {
		ArrayList<@NonNull Binding> bindings = new ArrayList<>();
		List<Context> contexts = contextSet.getContexts();
		ListIterator<Context> it = contexts.listIterator(contexts.size());
		while (it.hasPrevious()) {
			Context c = it.previous();
			BindingTable table = getTable(c.getId());
			if (table != null) {
				Collection<@NonNull Binding> sequences = table.getSequencesFor(parameterizedCommand);
				bindings.addAll(sequences);
			}
		}
		Collections.sort(bindings, BindingTable.BEST_SEQUENCE);
		return bindings;
	}

	@NonNull Collection<@NonNull Binding> getBindingsFor(@NonNull ContextSet contextSet, @NonNull  ParameterizedCommand cmd) {
		Collection<@NonNull Binding> bindings = new ArrayList<>();
		for (Context ctx : contextSet.getContexts()) {
			BindingTable table = getTable(ctx.getId());
			if (table != null) {
				Collection<@NonNull Binding> matches = table.getSequencesFor(cmd);
				bindings.addAll(matches);
			}
		}
		return bindings;
	}

	boolean isPartialMatch(@NonNull ContextSet contextSet, @NonNull TriggerSequence sequence) {
		List<Context> contexts = contextSet.getContexts();
		ListIterator<Context> it = contexts.listIterator(contexts.size());
		while (it.hasPrevious()) {
			Context c = it.previous();
			BindingTable table = getTable(c.getId());
			if (table != null) {
				if (table.isPartialMatch(sequence)) {
					return true;
				}
			}
		}
		return false;
	}

	@NonNull Collection<@NonNull Binding> getPartialMatches(@NonNull ContextSet contextSet, @NonNull TriggerSequence sequence) {
		ArrayList<@NonNull Binding> bindings = new ArrayList<>();
		List<Context> contexts = contextSet.getContexts();
		ListIterator<Context> it = contexts.listIterator(contexts.size());
		while (it.hasPrevious()) {
			Context c = it.previous();
			BindingTable table = getTable(c.getId());
			if (table != null) {
				Collection<@NonNull Binding> partialMatches = table.getPartialMatches(sequence);
				if (partialMatches != null) {
					bindings.addAll(partialMatches);
				}
			}
		}
		return bindings;
	}

	/**
	 * @param activeSchemeIds
	 */
	public void setActiveSchemes(String[] activeSchemeIds) {
		this.activeSchemeIds = activeSchemeIds;
		BindingTable.BEST_SEQUENCE.setActiveSchemes(activeSchemeIds);
	}

	/*
	 * Copied from
	 * org.eclipse.jface.bindings.BindingManager.compareSchemes(String, String)
	 * 
	 * Returns an in based on scheme 1 < scheme 2
	 */
	private final int compareSchemes(final String schemeId1, final String schemeId2) {
		if (this.activeSchemeIds == null) {
			return 0;
		}
		if (!schemeId2.equals(schemeId1)) {
			for (int i = 0; i < this.activeSchemeIds.length; i++) {
				final String schemePointer = this.activeSchemeIds[i];
				if (schemeId2.equals(schemePointer)) {
					return 1;
				} else if (schemeId1.equals(schemePointer)) {
					return -1;
				}
			}
		}
		return 0;
	}
}
