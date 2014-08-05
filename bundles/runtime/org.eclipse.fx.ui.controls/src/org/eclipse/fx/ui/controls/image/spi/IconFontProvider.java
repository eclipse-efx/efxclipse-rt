/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Christoph Caks <ccaks@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.controls.image.spi;

import org.eclipse.jdt.annotation.NonNull;

/**
 * An icon provider which translate a symbolic name to a char-code
 */
public abstract class IconFontProvider {
	/**
	 * @return the provider name
	 */
	public abstract String getName();

	/**
	 * Method to map a symbolic name to a char
	 * 
	 * @param id
	 *            the id
	 * @return the char
	 */
	public abstract char map(@NonNull String id);
}
