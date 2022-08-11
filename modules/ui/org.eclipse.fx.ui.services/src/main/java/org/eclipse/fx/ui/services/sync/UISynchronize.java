/*******************************************************************************
 * Copyright (c) 2014 EM-SOFTWARE and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Christoph Keimel <c.keimel@emsw.de> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.services.sync;

import org.eclipse.fx.core.ThreadSynchronize;
import org.eclipse.fx.ui.controls.Util;
import org.eclipse.jdt.annotation.NonNull;

/**
 * Extended UISynchronize Class
 *
 * @deprecated since 3.0 and to be removed in 4.0, use {@link ThreadSynchronize}
 */
@Deprecated
public interface UISynchronize extends ThreadSynchronize {
	/**
	 * Wait until the condition is satisfied without blocking the UI-Thread
	 *
	 * @param blockCondition
	 *            the condition
	 * @return the return value of the condition
	 * @since 2.3.0
	 * @deprecated use {@link ThreadSynchronize#block(org.eclipse.fx.core.ThreadSynchronize.BlockCondition)}
	 */
	@SuppressWarnings("null")
	@Deprecated
	public default <T> T waitUntil(@NonNull BlockCondition<T> blockCondition) {
		return Util.waitUntil(blockCondition);
	}
}