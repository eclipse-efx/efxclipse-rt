/*******************************************************************************
 * Copyright (c) 2014 EM-SOFTWARE and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Christoph Keimel <c.keimel@emsw.de> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.services.sync;

import org.eclipse.fx.core.ThreadSynchronize;
import org.eclipse.fx.ui.controls.Util;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * Extended UISynchronize Class
 *
 * @deprecated use {@link ThreadSynchronize}
 */
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
	public default <T> @Nullable T waitUntil(@NonNull BlockCondition<T> blockCondition) {
		return Util.waitUntil(blockCondition);
	}
}
