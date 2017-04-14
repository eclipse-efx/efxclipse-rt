/*******************************************************************************
 * Copyright (c) 2017 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.services.sync.internal;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import org.eclipse.fx.core.Subscription;
import org.eclipse.fx.core.ThreadSynchronize;
import org.eclipse.fx.ui.services.sync.UISynchronize;
import org.eclipse.jdt.annotation.NonNull;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;

/**
 * Temporary implementation delegating to {@link ThreadSynchronize}
 */
@Component
@Deprecated
public class UISynchronizeImpl implements UISynchronize {
	private ThreadSynchronize threadSynchronize;

	/**
	 * Setting the thread synchronize
	 *
	 * @param threadSynchronize
	 *            the basic thread sync
	 */
	@Reference(policy = ReferencePolicy.DYNAMIC, policyOption = ReferencePolicyOption.GREEDY)
	public void setThreadSynchronize(ThreadSynchronize threadSynchronize) {
		this.threadSynchronize = threadSynchronize;
	}

	/**
	 * Unset the threadSynchronize
	 *
	 * @param threadSynchronize
	 *            the threadSynchronize going down
	 */
	public void unsetThreadSynchronize(ThreadSynchronize threadSynchronize) {
		if (this.threadSynchronize == threadSynchronize) {
			this.threadSynchronize = null;
		}
	}

	@Override
	public boolean isCurrent() {
		return this.threadSynchronize.isCurrent();
	}

	@Override
	public <V> V syncExec(Callable<V> callable, V defaultValue) {
		return this.threadSynchronize.syncExec(callable, defaultValue);
	}

	@Override
	public void syncExec(Runnable runnable) {
		this.threadSynchronize.syncExec(runnable);
	}

	@Override
	public <V> Future<V> asyncExec(Callable<V> callable) {
		return this.threadSynchronize.asyncExec(callable);
	}

	@Override
	public void asyncExec(Runnable runnable) {
		this.threadSynchronize.asyncExec(runnable);
	}

	@Override
	public Subscription scheduleExecution(long delay, Runnable runnable) {
		return this.threadSynchronize.scheduleExecution(delay, runnable);
	}

	@Override
	public <T> CompletableFuture<T> scheduleExecution(long delay, Callable<T> runnable) {
		return this.threadSynchronize.scheduleExecution(delay, runnable);
	}

	@Override
	public <T> T block(@NonNull BlockCondition<T> blockCondition) {
		return this.threadSynchronize.block(blockCondition);
	}

}
