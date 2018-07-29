/*******************************************************************************
 * Copyright (c) 2018 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core.text;

import java.util.function.Predicate;

/**
 * Interface implemented for text matchers
 * 
 * @noimplement
 * @see TextUtil#createTextMatcher(String, boolean, boolean)
 * @since 3.3.0
 */
public interface TextMatcher extends Predicate<String> {
	@Override
	default boolean test(String t) {
		return match(t);
	}

	public boolean match(String t);
}
