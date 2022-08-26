/*******************************************************************************
 * Copyright (c) 2018 BestSolution.at and others.
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
