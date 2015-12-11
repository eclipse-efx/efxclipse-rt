/*******************************************************************************
 * Copyright (c) 2015 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.services.theme;

import org.eclipse.jdt.annotation.NonNull;

/**
 * Provide a {@link MultiURLStylesheet} type who gets created by the framework and registered on
 * the behalf of it
 *
 * @since 2.2.0
 */
public interface MultiURLStylesheetTypeProvider {
	/**
	 * @return the type
	 */
	public @NonNull Class<? extends MultiURLStylesheet> getType();
}
