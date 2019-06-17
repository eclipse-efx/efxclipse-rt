/*******************************************************************************
 * Copyright (c) 2009, 2010 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.keybindings.e4;

import java.util.Collection;
import java.util.Map;

import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.fx.ui.keybindings.Binding;
import org.eclipse.fx.ui.keybindings.TriggerSequence;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * Service to interact with key bindings
 */
public interface EBindingService {

	/**
	 * The id used in the context
	 */
	public static final String DIALOG_CONTEXT_ID = "org.eclipse.ui.contexts.dialog"; //$NON-NLS-1$
	/**
	 * Name of the default scheme
	 */
	public static final String DEFAULT_SCHEME_ID = "org.eclipse.ui.defaultAcceleratorConfiguration"; //$NON-NLS-1$
	/**
	 * Key used to store the binding in the transient map
	 */
	public static final String MODEL_TO_BINDING_KEY = "binding"; //$NON-NLS-1$
	/**
	 * Tag used for the active scheme
	 */
	public static final String ACTIVE_SCHEME_TAG = "activeSchemeId"; //$NON-NLS-1$
	/**
	 * Tag prefix for the scheme
	 */
	public static final String SCHEME_ID_ATTR_TAG = "schemeId"; //$NON-NLS-1$
	/**
	 * Tag prefix for the locale
	 */
	public static final String LOCALE_ATTR_TAG = "locale"; //$NON-NLS-1$
	/**
	 * Tag prefix for the platform
	 */
	public static final String PLATFORM_ATTR_TAG = "platform"; //$NON-NLS-1$
	/**
	 * Tag prefix for the type
	 */
	public static final String TYPE_ATTR_TAG = "type"; //$NON-NLS-1$
	/**
	 * Tag prefix for the deleted
	 */
	public static final String DELETED_BINDING_TAG = "deleted"; //$NON-NLS-1$
	
	/**
	 * Tag prefix used by (platform- or locale-specific) KeyBindings 
	 * to indicate which (generic) binding they override
	 * @since 3.6
	 */
	public static final String OVERRIDE = "override"; //$NON-NLS-1$

	/**
	 * Create a binding between a sequence and a command
	 * 
	 * @param sequence
	 *            the sequence
	 * @param command
	 *            the command
	 * @param contextId
	 *            the context id
	 * @param attributes
	 *            the attributes
	 * @return the binding
	 */
	Binding createBinding(@NonNull TriggerSequence sequence, @NonNull ParameterizedCommand command, @NonNull String contextId, @NonNull Map<@NonNull String, @NonNull String> attributes);

	/**
	 * Activate the binding
	 * 
	 * @param binding
	 *            the binding to activate
	 */
	void activateBinding(@NonNull Binding binding);

	/**
	 * Deactivate the binding
	 * 
	 * @param binding
	 *            the binding to deactivate
	 */
	void deactivateBinding(@NonNull Binding binding);

	/**
	 * Create a trigger sequence from a string definition
	 * 
	 * @param sequence
	 *            a string definition
	 * @return a trigger sequence
	 */
	@Nullable
	TriggerSequence createSequence(@NonNull String sequence);

	/**
	 * Get the conflicts for a sequence
	 * 
	 * @param sequence
	 *            the sequence
	 * @return the bindings
	 */
	@Nullable
	Collection<@NonNull Binding> getConflictsFor(@NonNull TriggerSequence sequence);

	/**
	 * @return all conflicts
	 */
	@NonNull
	Collection<@NonNull Binding> getAllConflicts();

	/**
	 * Get the perfect match for the trigger
	 * 
	 * @param trigger
	 *            the trigger
	 * @return the binding
	 */
	@Nullable
	Binding getPerfectMatch(@NonNull TriggerSequence trigger);

	/**
	 * Check if the sequence is partially matched
	 * 
	 * @param keySequence
	 *            the sequence
	 * @return <code>true</code> if a partial match
	 */
	boolean isPartialMatch(@NonNull TriggerSequence keySequence);

	/**
	 * Check if there is a perfect match
	 * 
	 * @param sequence
	 *            the sequence
	 * @return <code>true</code> if a perfect match
	 */
	boolean isPerfectMatch(@NonNull TriggerSequence sequence);

	/**
	 * Find the best sequence for the command
	 * 
	 * @param command
	 *            the command
	 * @return the sequence
	 */
	@Nullable
	TriggerSequence getBestSequenceFor(@NonNull ParameterizedCommand command);

	/**
	 * Find all sequences for the give command
	 * 
	 * @param command
	 *            the command
	 * @return all sequences
	 */
	@NonNull
	Collection<@NonNull TriggerSequence> getSequencesFor(@NonNull ParameterizedCommand command);

	/**
	 * Find all partial matches
	 * 
	 * @param sequence
	 *            the sequence
	 * @return the matches
	 */
	@NonNull
	Collection<@NonNull Binding> getPartialMatches(@NonNull TriggerSequence sequence);

	/**
	 * @return all active bindings
	 */
	@NonNull
	Collection<@NonNull Binding> getActiveBindings();

	/**
	 * Find all bindings for the command
	 * 
	 * @param cmd
	 *            the command
	 * @return the bindings
	 */
	@NonNull
	Collection<@NonNull Binding> getBindingsFor(@NonNull ParameterizedCommand cmd);
}
