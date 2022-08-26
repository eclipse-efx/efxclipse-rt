/*******************************************************************************
 * Copyright (c) 2012 BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.keybindings.generic;

import java.util.Arrays;
import java.util.List;

import org.eclipse.fx.ui.keybindings.Trigger;
import org.eclipse.fx.ui.keybindings.TriggerSequence;
import org.eclipse.jdt.annotation.NonNull;

/**
 * trigger sequence implementation
 */
public abstract class TriggerSequenceImpl implements TriggerSequence {
	private final List<Trigger> triggers;

	/**
	 * The value to see that hash code to if the hash code is not yet computed.
	 */
	private static final int HASH_CODE_NOT_COMPUTED = -1;

	/**
	 * A factor for computing the hash code for all trigger sequences.
	 */
	private static final int HASH_FACTOR = 89;

	/**
	 * An internal constant used only in this object's hash code algorithm.
	 */
	private static final int HASH_INITIAL = TriggerSequence.class.getName().hashCode();

	/**
	 * The hash code for this object. This value is computed lazily, and marked
	 * as invalid when one of the values on which it is based changes. This
	 * values is <code>HASH_CODE_NOT_COMPUTED</code> iff the hash code has not
	 * yet been computed.
	 */
	protected transient int hashCode = HASH_CODE_NOT_COMPUTED;

	/**
	 * Create a trigger sequence
	 * 
	 * @param triggers
	 *            the triggers
	 */
	public TriggerSequenceImpl(final Trigger[] triggers) {
		if (triggers == null) {
			throw new NullPointerException("The triggers cannot be null"); //$NON-NLS-1$
		}

		for (int i = 0; i < triggers.length; i++) {
			if (triggers[i] == null) {
				throw new IllegalArgumentException("All triggers in a trigger sequence must be an instance of Trigger"); //$NON-NLS-1$
			}
		}

		this.triggers = Arrays.asList(triggers);
	}

	@SuppressWarnings("null")
	@Override
	public @NonNull Trigger[] getTriggers() {
		return this.triggers.toArray(new Trigger[0]);
	}

	@Override
	public final boolean isEmpty() {
		return this.triggers.isEmpty();
	}

	@Override
	public final int hashCode() {
		if (this.hashCode == HASH_CODE_NOT_COMPUTED) {
			this.hashCode = HASH_INITIAL;
			this.hashCode = this.hashCode * HASH_FACTOR + Util.hashCode(this.triggers.toArray());
			if (this.hashCode == HASH_CODE_NOT_COMPUTED) {
				this.hashCode++;
			}
		}

		return this.hashCode;
	}

	@Override
	public final boolean equals(final Object object) {
		// Check if they're the same.
		if (object == this) {
			return true;
		}

		// Check if they're the same type.
		if (!(object instanceof TriggerSequence)) {
			return false;
		}

		final TriggerSequence triggerSequence = (TriggerSequence) object;
		return Util.equals(this.triggers.toArray(), triggerSequence.getTriggers());
	}
}
