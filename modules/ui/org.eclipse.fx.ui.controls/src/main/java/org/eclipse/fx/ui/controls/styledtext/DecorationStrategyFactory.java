/*******************************************************************************
 * Copyright (c) 2015 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.controls.styledtext;

import org.eclipse.fx.core.RankedService;
import org.eclipse.fx.ui.controls.styledtext.model.DecorationStrategy;
import org.eclipse.jdt.annotation.NonNull;

/**
 * Factory to create decoration a decoration strategy which is used in
 * {@link StyledTextArea}
 */
public interface DecorationStrategyFactory extends RankedService {
	/**
	 * @return the name of the strategy
	 */
	public @NonNull String getDecorationStrategyName();

	/**
	 * Create a strategy
	 *
	 * @param definition
	 *            the definition as found in the css
	 * @return (shared) instance of a strategy
	 */
	public DecorationStrategy create(String definition);
}