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
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.core.commands.contexts.Context;
import org.eclipse.fx.ui.keybindings.Binding;
import org.eclipse.fx.ui.keybindings.KeyStroke;
import org.eclipse.fx.ui.keybindings.Trigger;
import org.eclipse.fx.ui.keybindings.TriggerSequence;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * manage tables of bindings that can be used to look up commands from keys.
 */
public class BindingTable {
	static int compareSchemes(String[] activeSchemeIds, final String schemeId1,
			final String schemeId2) {
		if (activeSchemeIds == null || activeSchemeIds.length == 0) {
			return 0;
		}
		if (!schemeId2.equals(schemeId1)) {
			for (int i = 0; i < activeSchemeIds.length; i++) {
				final String schemePointer = activeSchemeIds[i];
				if (schemeId2.equals(schemePointer)) {
					return 1;
				} else if (schemeId1.equals(schemePointer)) {
					return -1;
				}
			}
		}
		return 0;
	}

	static class BindingComparator implements Comparator<Binding> {
		private String[] activeSchemeIds;

		public void setActiveSchemes(String[] activeSchemeIds) {
			this.activeSchemeIds = activeSchemeIds;
		}

		public String[] getActiveSchemes() {
			return this.activeSchemeIds;
		}

		@Override
		public int compare(Binding o1, Binding o2) {
			int rc = compareSchemes(this.activeSchemeIds, o1.getSchemeId(), o2.getSchemeId());
			if (rc != 0) {
				return rc;
			}

			/*
			 * Check to see which has the least number of triggers in the trigger sequence.
			 */
			final Trigger[] bestTriggers = o1.getTriggerSequence().getTriggers();
			final Trigger[] currentTriggers = o2.getTriggerSequence().getTriggers();
			int compareTo = bestTriggers.length - currentTriggers.length;
			if (compareTo != 0) {
				return compareTo;
			}

			/*
			 * Compare the number of keys pressed in each trigger sequence. Some types of keys count
			 * less than others (i.e., some types of modifiers keys are less likely to be chosen).
			 */
			compareTo = countStrokes(bestTriggers) - countStrokes(currentTriggers);
			if (compareTo != 0) {
				return compareTo;
			}

			// If this is still a tie, then just chose the shortest text.
			return o1.getTriggerSequence().format().length()
					- o2.getTriggerSequence().format().length();
		}

		private final static int countStrokes(final Trigger[] triggers) {
			int strokeCount = triggers.length;
			for (int i = 0; i < triggers.length; i++) {
				final Trigger trigger = triggers[i];
				if (trigger instanceof KeyStroke) {
					final KeyStroke keyStroke = (KeyStroke) trigger;
					if (keyStroke.hasAltModifier()) {
						strokeCount += 8;
					}
					if (keyStroke.hasCtrlModifier()) {
						strokeCount += 2;
					}
					if (keyStroke.hasShiftModifier()) {
						strokeCount += 4;
					}
					if (keyStroke.hasCommandModifier()) {
						strokeCount += 2;
					}

					// final int modifierKeys = keyStroke.getModifierKeys();
					// final IKeyLookup lookup = KeyLookupFactory.getDefault();
					// if ((modifierKeys & lookup.getAlt()) != 0) {
					// strokeCount += 8;
					// }
					// if ((modifierKeys & lookup.getCtrl()) != 0) {
					// strokeCount += 2;
					// }
					// if ((modifierKeys & lookup.getShift()) != 0) {
					// strokeCount += 4;
					// }
					// if ((modifierKeys & lookup.getCommand()) != 0) {
					// strokeCount += 2;
					// }
				} else {
					strokeCount += 99;
				}
			}

			return strokeCount;
		}
	}

	static final BindingComparator BEST_SEQUENCE = new BindingComparator();

	@NonNull
	private final Context tableId;
	@NonNull
	private final ArrayList<@NonNull Binding> bindings = new ArrayList<>();
	@NonNull
	private final Map<@NonNull TriggerSequence, @NonNull Binding> bindingsByTrigger = new HashMap<>();
	@NonNull
	private final Map<@NonNull ParameterizedCommand, @NonNull ArrayList<@NonNull Binding>> bindingsByCommand = new HashMap<>();
	@NonNull
	private final Map<@NonNull TriggerSequence, @NonNull ArrayList<@NonNull Binding>> bindingsByPrefix = new HashMap<>();
	@NonNull
	private final Map<@NonNull TriggerSequence, @NonNull ArrayList<@NonNull Binding>> conflicts = new HashMap<>();
	@NonNull
	private final Map<TriggerSequence, ArrayList<Binding>> orderedBindingsByTrigger = new HashMap<>();

	/**
	 * Create a table
	 *
	 * @param context
	 */
	public BindingTable(@NonNull Context context) {
		this.tableId = context;
	}

	/**
	 * @return the context
	 */
	public @NonNull Context getTableId() {
		return this.tableId;
	}

	/**
	 * @return the context id
	 */
	@SuppressWarnings("null")
	public @NonNull String getId() {
		return this.tableId.getId();
	}

	/**
	 * @return get all conflicts
	 */
	@SuppressWarnings("null")
	public @NonNull Collection<@NonNull Binding> getConflicts() {
		Collection<Binding> conflictsList = new ArrayList<Binding>();
		for (TriggerSequence key : this.conflicts.keySet()) {
			ArrayList<Binding> conflictsForTrigger = this.conflicts.get(key);
			if (conflictsForTrigger != null) {
				conflictsList.addAll(conflictsForTrigger);
			}
		}
		return conflictsList;
	}

	// checks both the active bindings and conflicts list
	/**
	 * Get all conflicts for the sequence
	 *
	 * @param triggerSequence
	 *            the sequence
	 * @return the conflicts
	 */
	public @Nullable Collection<@NonNull Binding> getConflictsFor(TriggerSequence triggerSequence) {
		return this.conflicts.get(triggerSequence);
	}

	/**
	 *
	 * @param binding
	 */
	@SuppressWarnings({ "null" })
	public void addBinding(@NonNull Binding binding) {
		if (!getId().equals(binding.getContextId())) {
			throw new IllegalArgumentException("Binding context " + binding.getContextId() //$NON-NLS-1$
					+ " does not match " + getId()); //$NON-NLS-1$
		}
		ArrayList<Binding> bindingList = this.orderedBindingsByTrigger.get(binding.getTriggerSequence());
		Binding possibleConflict = this.bindingsByTrigger.get(binding.getTriggerSequence());
		if (bindingList == null || bindingList.isEmpty()) {
			if (possibleConflict != null) {
				if (bindingList == null) {
					bindingList = new ArrayList<Binding>();
					this.orderedBindingsByTrigger.put(binding.getTriggerSequence(), bindingList);
				}
				bindingList.add(binding);
				bindingList.add(possibleConflict);
				Collections.sort(bindingList, BEST_SEQUENCE);
			}
		} else {
			bindingList.add(binding);
			Collections.sort(bindingList, BEST_SEQUENCE);
		}

		if (possibleConflict != null && bindingList != null && !bindingList.isEmpty()
				&& bindingList.get(0) != possibleConflict) {
			removeBindingSimple(possibleConflict);
			possibleConflict = null;
		}

		evaluateOrderedBindings(binding.getTriggerSequence(), binding);
	}

	@SuppressWarnings({ "unused", "null" })
	private void addBindingSimple(@NonNull Binding binding) {
		this.bindings.add(binding);
		this.bindingsByTrigger.put(binding.getTriggerSequence(), binding);

		ArrayList<Binding> sequences = this.bindingsByCommand.get(binding.getParameterizedCommand());
		if (sequences == null) {
			sequences = new ArrayList<Binding>();
			this.bindingsByCommand.put(binding.getParameterizedCommand(), sequences);
		}
		sequences.add(binding);
		Collections.sort(sequences, BEST_SEQUENCE);

		TriggerSequence[] prefs = binding.getTriggerSequence().getPrefixes();
		for (int i = 1; i < prefs.length; i++) {
			ArrayList<Binding> bindings = this.bindingsByPrefix.get(prefs[i]);
			if (bindings == null) {
				bindings = new ArrayList<Binding>();
				this.bindingsByPrefix.put(prefs[i], bindings);
			}
			bindings.add(binding);
		}
	}

	@SuppressWarnings("null")
	private void removeBindingSimple(Binding binding) {
		this.bindings.remove(binding);
		this.bindingsByTrigger.remove(binding.getTriggerSequence());
		ArrayList<Binding> sequences = this.bindingsByCommand.get(binding.getParameterizedCommand());

		if (sequences != null) {
			sequences.remove(binding);
		}
		TriggerSequence[] prefs = binding.getTriggerSequence().getPrefixes();
		for (int i = 1; i < prefs.length; i++) {
			ArrayList<Binding> bindings = this.bindingsByPrefix.get(prefs[i]);
			if (bindings != null) {
				bindings.remove(binding);
			}
		}
	}

	/**
	 * Remove a binding
	 *
	 * @param binding
	 *            the binding
	 */
	public void removeBinding(@NonNull Binding binding) {
		if (!getId().equals(binding.getContextId())) {
			throw new IllegalArgumentException("Binding context " + binding.getContextId() //$NON-NLS-1$
					+ " does not match " + getId()); //$NON-NLS-1$
		}
		ArrayList<Binding> bindingList = this.orderedBindingsByTrigger.get(binding.getTriggerSequence());
		Binding possibleConflict = this.bindingsByTrigger.get(binding.getTriggerSequence());
		if (possibleConflict == binding) {
			removeBindingSimple(binding);
			if (bindingList != null) {
				bindingList.remove(binding);
				if (bindingList.isEmpty()) {
					this.orderedBindingsByTrigger.remove(binding.getTriggerSequence());
				} else {
					evaluateOrderedBindings(binding.getTriggerSequence(), null);
				}
			}
		} else if (bindingList != null) {
			bindingList.remove(binding);
			if (bindingList.isEmpty()) {
				this.orderedBindingsByTrigger.remove(binding.getTriggerSequence());
			} else {
				evaluateOrderedBindings(binding.getTriggerSequence(), null);
			}
		}
	}

	@SuppressWarnings({ "null", "unused" })
	private void evaluateOrderedBindings(TriggerSequence sequence, Binding binding) {
		ArrayList<Binding> bindingList = this.orderedBindingsByTrigger.get(sequence);

		// calculate binding to be used or any conflicts
		if (bindingList != null) {
			if (bindingList.isEmpty()) {
				this.orderedBindingsByTrigger.remove(sequence);
			} else if (bindingList.size() > 1) {
				Binding msb = bindingList.get(0);
				Binding lsb = bindingList.get(1);
				int rc = compareSchemes(BEST_SEQUENCE.getActiveSchemes(), msb.getSchemeId(),
						lsb.getSchemeId());
				if (rc == 0) {
					ArrayList<@NonNull Binding> conflictList = this.conflicts.get(sequence);
					if (conflictList == null) {
						conflictList = new ArrayList<>();
						this.conflicts.put(sequence, conflictList);
					} else {
						conflictList.clear();
					}
					Iterator<Binding> i = bindingList.iterator();
					Binding prev = i.next();
					conflictList.add(prev);
					while (i.hasNext() && rc == 0) {
						Binding next = i.next();
						rc = compareSchemes(BEST_SEQUENCE.getActiveSchemes(), prev.getSchemeId(),
								next.getSchemeId());
						if (rc == 0) {
							conflictList.add(next);
						}
						prev = next;
					}
				} else {
					this.conflicts.remove(sequence);
					if (this.bindingsByTrigger.get(sequence) == null) {
						addBindingSimple(msb);
					}
				}
			} else {
				if (this.bindingsByTrigger.get(sequence) == null) {
					addBindingSimple(bindingList.get(0));
				}
				this.orderedBindingsByTrigger.remove(sequence);
			}
		} else if (binding != null) {
			this.conflicts.remove(sequence);
			if (this.bindingsByTrigger.get(sequence) == null) {
				addBindingSimple(binding);
			}
		}
	}

	/**
	 * The perfect match for a trigger
	 *
	 * @param trigger
	 *            the trigger
	 * @return the match
	 */
	public @Nullable Binding getPerfectMatch(@NonNull TriggerSequence trigger) {
		return this.bindingsByTrigger.get(trigger);
	}

	/**
	 * The best sequence for the command
	 *
	 * @param command
	 *            the command
	 * @return the binding
	 */
	@SuppressWarnings("null")
	public @Nullable Binding getBestSequenceFor(@NonNull ParameterizedCommand command) {
		ArrayList<Binding> sequences = this.bindingsByCommand.get(command);
		if (sequences != null && sequences.size() > 0) {
			return sequences.get(0);
		}
		return null;
	}

	/**
	 * Get all sequences for the command
	 *
	 * @param command
	 *            the command
	 * @return all bindings
	 */
	@SuppressWarnings("null")
	public @NonNull Collection<@NonNull Binding> getSequencesFor(@NonNull ParameterizedCommand command) {
		ArrayList<Binding> triggers = this.bindingsByCommand.get(command);
		return (Collection<@NonNull Binding>) (triggers == null ? Collections.<@NonNull Binding> emptyList() : new ArrayList<>(triggers));
	}

	/**
	 * Get partial matches
	 *
	 * @param sequence
	 *            the sequence
	 * @return the bindings
	 */
	public @Nullable Collection<@NonNull Binding> getPartialMatches(@NonNull TriggerSequence sequence) {
		return this.bindingsByPrefix.get(sequence);
	}

	/**
	 * Check if the sequence is partially matched
	 *
	 * @param seq
	 *            the sequence
	 * @return <code>true</code> if there's a partial match
	 */
	@SuppressWarnings("null")
	public boolean isPartialMatch(@NonNull TriggerSequence seq) {
		return this.bindingsByPrefix.get(seq) != null;
	}

	/**
	 * @return all bindings
	 */
	@SuppressWarnings("null")
	public @NonNull Collection<@NonNull Binding> getBindings() {
		return Collections.unmodifiableCollection(this.bindings);
	}

}
