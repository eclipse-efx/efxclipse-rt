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
 * Exception thrown when parsing of a sequence failed
 */
public class ParseException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Create a new exception
	 * 
	 * @param string
	 *            the error information
	 */
	public ParseException(@NonNull String string) {
		super(string);
	}

}
