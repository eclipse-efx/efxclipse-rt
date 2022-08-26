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
package org.eclipse.fx.ui.keybindings;

import org.eclipse.jdt.annotation.NonNull;

/**
 * A trigger sequence
 */
public interface TriggerSequence {

	/**
	 * @return the triggers
	 */
	@NonNull
	Trigger[] getTriggers();

	/**
	 * @return prefix sequence
	 */
	@NonNull
	TriggerSequence[] getPrefixes();

	/**
	 * @return formated value
	 */
	String format();

	/**
	 * @return check if empty
	 */
	boolean isEmpty();

}
