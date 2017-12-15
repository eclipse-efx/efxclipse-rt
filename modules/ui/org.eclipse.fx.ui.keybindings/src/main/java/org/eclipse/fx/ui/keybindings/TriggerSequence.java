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
