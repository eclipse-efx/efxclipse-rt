/*******************************************************************************
 * Copyright (c) 2012 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.keybindings.generic;

import org.eclipse.fx.ui.keybindings.Trigger;

/**
 * A trigger implementation
 */
public abstract class TriggerImpl implements Trigger {
	/**
     * Tests whether this object is equal to another object. A handle object is
     * only equal to another trigger with the same properties.
     * 
     * @param object
     *            The object with which to compare; may be <code>null</code>.
     * @return <code>true</code> if the objects are equal; <code>false</code>
     *         otherwise.
     */
    @Override
	public abstract boolean equals(final Object object);

    /**
     * Computes the hash code for this object.
     * 
     * @return The hash code for this object.
     */
    @Override
	public abstract int hashCode();

}
