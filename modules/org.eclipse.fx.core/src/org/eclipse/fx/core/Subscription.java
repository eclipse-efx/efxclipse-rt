/*******************************************************************************
 * Copyright (c) 2013 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core;

import org.eclipse.jdt.annotation.Nullable;

/**
 * Interface representing the subscription of a callback / handler
 */
public interface Subscription {
	/**
	 * Destroy the subscription
	 */
	public void dispose();

	/**
	 * This is a helper method so that user code is not cluttered with null
	 * checks before disposing a {@link Subscription}
	 *
	 * @param s
	 *            the possible subscription instance, might be <code>null</code>
	 */
	public static void disposeIfExists(@Nullable Subscription s) {
		if (s != null) {
			s.dispose();
		}
	}
}
