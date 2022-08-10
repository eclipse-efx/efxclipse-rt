/*******************************************************************************
 * Copyright (c) 2017 BestSolution.at and others.
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
package org.eclipse.fx.core;

import org.eclipse.fx.core.ThreadSynchronize.BlockCondition;

/**
 * <p>
 * Queue where {@link Runnable} actions can be scheduled and are processed on a
 * specific thread (eg the Event-Dispatcher-Thread on UI-Toolkits).
 * </p>
 * <p>
 * A basic implementation not bound to an UI-Toolkit is {@link EventLoop} who eg
 * can be used in Junit-Tests
 * </p>
 *
 * @since 3.0
 */
public interface ThreadQueue {
	/**
	 * @return <code>true</code> if we are on the dispatcher thread
	 */
	public boolean isCurrent();

	/**
	 * Push the {@link Runnable} to be processed
	 *
	 * @param r
	 *            the runnable
	 * @return object used to remove the runnable before it is processed by the
	 *         queue
	 */
	public Subscription push(Runnable r);

	/**
	 * Spin the event loop while the condition is true
	 *
	 * @param condition
	 *            the condition
	 */
	public <T> void spinWhile(BlockCondition<T> condition);
}
