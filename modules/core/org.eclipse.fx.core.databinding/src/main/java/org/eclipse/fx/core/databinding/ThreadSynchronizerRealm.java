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
package org.eclipse.fx.core.databinding;

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.fx.core.ThreadSynchronize;

/**
 * Realm who is backed by the thread synchronization object
 *
 * @since 3.0.0
 */
public class ThreadSynchronizerRealm extends Realm {

	private final ThreadSynchronize threadSync;

	private ThreadSynchronizerRealm(ThreadSynchronize threadSync) {
		this.threadSync = threadSync;
	}

	/**
	 * Create and set the default realm
	 *
	 * @param threadSync
	 *            the thread sync
	 * @return the realm
	 */
	public static Realm createDefault(ThreadSynchronize threadSync) {
		ThreadSynchronizerRealm t = new ThreadSynchronizerRealm(threadSync);
		setDefault(t);
		return t;
	}

	@Override
	protected void syncExec(Runnable runnable) {
		this.threadSync.syncExec(runnable);
	}

	@Override
	public void asyncExec(Runnable runnable) {
		this.threadSync.asyncExec(runnable);
	}

	@Override
	public void timerExec(int milliseconds, Runnable runnable) {
		this.threadSync.scheduleExecution(milliseconds, runnable);
	}

	@Override
	public boolean isCurrent() {
		return this.threadSync.isCurrent();
	}

}
