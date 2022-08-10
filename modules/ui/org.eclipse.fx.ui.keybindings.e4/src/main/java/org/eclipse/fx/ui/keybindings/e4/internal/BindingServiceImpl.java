/*******************************************************************************
 * Copyright (c) 2009, 2010 IBM Corporation and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 ******************************************************************************/

package org.eclipse.fx.ui.keybindings.e4.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.core.commands.contexts.Context;
import org.eclipse.core.commands.contexts.ContextManager;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.fx.core.log.Log;
import org.eclipse.fx.core.log.Logger;
import org.eclipse.fx.ui.keybindings.Binding;
import org.eclipse.fx.ui.keybindings.KeyLookup;
import org.eclipse.fx.ui.keybindings.ParseException;
import org.eclipse.fx.ui.keybindings.TriggerSequence;
import org.eclipse.fx.ui.keybindings.e4.EBindingService;
import org.eclipse.fx.ui.keybindings.service.BindingFactory;
import org.eclipse.jdt.annotation.NonNull;

/**
 *
 */
public class BindingServiceImpl implements EBindingService {

	final static String ACTIVE_CONTEXTS = "activeContexts"; //$NON-NLS-1$
	final static String USER_TYPE = "user"; //$NON-NLS-1$

	@Inject
	private IEclipseContext context;

	@Inject
	private BindingTableManager manager;

	@Inject
	private ContextManager contextManager;

	@Inject
	private KeyLookup keylookup;

	@Inject
	private BindingFactory factory;

	@NonNull
	private ContextSet contextSet = ContextSet.EMPTY;
	
	@Inject
	@Log
	Logger logger;

	@Override
	public Binding createBinding(TriggerSequence sequence,
			ParameterizedCommand command, String contextId,
			Map<String, String> attributes) {
		String schemeId = DEFAULT_SCHEME_ID;
		// String locale = null;
		// String platform = null;
		// int bindingType = Binding.SYSTEM;

		if (!sequence.isEmpty()) {
			String tmp = attributes.get(SCHEME_ID_ATTR_TAG);
			if (tmp != null && tmp.length() > 0) {
				schemeId = tmp;
			}
			// locale = attributes.get(LOCALE_ATTR_TAG);
			// platform = attributes.get(PLATFORM_ATTR_TAG);
			// if (USER_TYPE.equals(attributes.get(TYPE_ATTR_TAG))) {
			// bindingType = Binding.USER;
			// }
			if( schemeId == null ) {
				return null;
			}
			return this.factory.createKeyBinding(sequence, command, schemeId,
					contextId);
			// return factory.createKeyBinding((EKeySequence) sequence, command,
			// schemeId, contextId, locale,
			// platform, null, bindingType);
		}
		return null;
	}

	@Override
	public void activateBinding(Binding binding) {
		String contextId = binding.getContextId();
		BindingTable table = this.manager.getTable(contextId);
		if (table == null) {
			return;
		}
		table.addBinding(binding);
	}

	@Override
	public void deactivateBinding(Binding binding) {
		String contextId = binding.getContextId();
		BindingTable table = this.manager.getTable(contextId);
		if (table == null) {
			return;
		}
		table.removeBinding(binding);
	}

	@Override
	public TriggerSequence createSequence(String sequence) {
		try {
			KeyLookup keylookup = this.keylookup;
			if( keylookup != null ) {
				return this.factory.getKeySequenceInstance(keylookup, sequence);	
			}
		} catch (ParseException e) {
			this.logger.error("Unable to parse key sequence '"+sequence+"'", e);  //$NON-NLS-1$//$NON-NLS-2$
		}
		return null;
	}

	@Override
	public Collection<Binding> getConflictsFor(TriggerSequence sequence) {
		return this.manager.getConflictsFor(this.contextSet, sequence);
	}

	@Override
	public Collection<Binding> getAllConflicts() {
		return this.manager.getAllConflicts();
	}

	@Override
	public Binding getPerfectMatch(TriggerSequence trigger) {
		return this.manager.getPerfectMatch(this.contextSet, trigger);
	}

	@Override
	public boolean isPartialMatch(TriggerSequence keySequence) {
		return this.manager.isPartialMatch(this.contextSet, keySequence);
	}

	@Override
	public TriggerSequence getBestSequenceFor(ParameterizedCommand command) {
		Binding binding = this.manager.getBestSequenceFor(this.contextSet, command);
		return binding == null ? null : binding.getTriggerSequence();
	}

	@Override
	public Collection<TriggerSequence> getSequencesFor(
			ParameterizedCommand command) {
		Collection<Binding> bindings = this.manager.getSequencesFor(this.contextSet,
				command);
		ArrayList<TriggerSequence> sequences = new ArrayList<TriggerSequence>(
				bindings.size());
		for (Binding binding : bindings) {
			sequences.add(binding.getTriggerSequence());
		}
		return sequences;
	}

	@Override
	public Collection<Binding> getBindingsFor(ParameterizedCommand command) {
		return this.manager.getBindingsFor(this.contextSet, command);
	}

	@Override
	public boolean isPerfectMatch(TriggerSequence sequence) {
		return getPerfectMatch(sequence) != null;
	}

	@Override
	public Collection<Binding> getPartialMatches(TriggerSequence sequence) {
		return this.manager.getPartialMatches(this.contextSet, sequence);
	}

	/**
	 * @return the context for this service.
	 */
	public IEclipseContext getContext() {
		return this.context;
	}

	@Inject
	void setContextIds(@Named(ACTIVE_CONTEXTS) @Optional Set<String> set) {
		if (set == null || set.isEmpty() || this.contextManager == null) {
			this.contextSet = ContextSet.EMPTY;
			if (this.contextManager != null) {
				this.contextManager.setActiveContextIds(Collections.EMPTY_SET);
			}
			return;
		}
		ArrayList<@NonNull Context> contexts = new ArrayList<>();
		for (String id : set) {
			Context ctx = this.contextManager.getContext(id);
			if( ctx != null ) {
				contexts.add(ctx);	
			}
		}
		this.contextSet = BindingTableManager.createContextSet(contexts);
		this.contextManager.setActiveContextIds(set);
	}

	@Override
	public Collection<Binding> getActiveBindings() {
		return this.manager.getActiveBindings();
	}

}
