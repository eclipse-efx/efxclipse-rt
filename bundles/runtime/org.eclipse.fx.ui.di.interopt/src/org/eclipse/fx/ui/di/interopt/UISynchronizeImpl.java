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
package org.eclipse.fx.ui.di.interopt;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.atomic.AtomicBoolean;

import org.eclipse.fx.core.Subscription;
import org.eclipse.fx.core.ThreadSynchronize;
import org.eclipse.fx.core.log.Logger;
import org.eclipse.fx.core.log.LoggerFactory;
import org.eclipse.swt.widgets.Display;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;

/**
 * Implementation of the UISynchronize service for JavaFX
 */
// Make sure none interopt services win all time!
@Component(service = { ThreadSynchronize.class }, property = { "service.ranking:Integer=-1" })
public class UISynchronizeImpl implements ThreadSynchronize {
	private LoggerFactory factory;
	private Logger logger;

	/**
	 * Setting a new factory
	 *
	 * @param factory
	 *            the new factory
	 */
	@Reference(policy = ReferencePolicy.DYNAMIC, policyOption = ReferencePolicyOption.GREEDY)
	public void setLoggerFactory(LoggerFactory factory) {
		this.factory = factory;
		this.logger = null;
	}

	/**
	 * Unset the logger factory
	 *
	 * @param factory
	 *            the factory to remove
	 */
	public void unsetLoggerFactory(LoggerFactory factory) {
		if (this.factory == factory) {
			this.factory = null;
			this.logger = null;
		}
	}

	@SuppressWarnings("null")
	private Logger getLogger() {
		if (this.logger == null) {
			this.logger = this.factory.createLogger(getClass().getName());
		}
		return this.logger;
	}

	@Override
	public <V> V syncExec(final Callable<V> callable, V defaultValue) {
		if (Display.getDefault().getThread() == Thread.currentThread()) {
			try {
				return callable.call();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		} else {
			// We could also use Display.getDefault().syncExec(Runnable); but
			// to keep semantics the same as in JavaFX we use the same code
			// future task
			RunnableFuture<V> task = new FutureTask<V>(callable);
			Display.getDefault().asyncExec(task);
			try {
				return task.get();
			} catch (InterruptedException | ExecutionException e) {
				getLogger().error("Unable to wait until the task is completed", e); //$NON-NLS-1$
			} finally {
				task.cancel(true);
			}
		}
		return defaultValue;
	}

	@Override
	public void syncExec(final Runnable runnable) {
		if (Display.getDefault().getThread() == Thread.currentThread()) {
			runnable.run();
		} else {
			// We could also use Display.getDefault().syncExec(Runnable); but
			// to keep semantics the same as in JavaFX we use the same code
			// future task
			RunnableFuture<?> task = new FutureTask<Void>(runnable, null);
			Display.getDefault().asyncExec(task);
			try {
				task.get(); // wait for task to complete
			} catch (InterruptedException | ExecutionException e) {
				getLogger().error("Unable to wait until the task is completed", e); //$NON-NLS-1$
			} finally {
				task.cancel(true);
			}
		}
	}

	@Override
	public <V> Future<V> asyncExec(final Callable<V> callable) {
		RunnableFuture<V> task = new FutureTask<V>(callable);
		Display.getDefault().asyncExec(task);
		return task;
	}

	@Override
	public void asyncExec(Runnable runnable) {
		Display.getDefault().asyncExec(runnable);
	}

	@Override
	public Subscription scheduleExecution(long delay, Runnable runnable) {
		final AtomicBoolean b = new AtomicBoolean(true);
		Runnable wrapper = () -> {
			if (b.get()) {
				runnable.run();
			}
		};
		Display display = Display.getDefault();
		display.timerExec((int) delay, wrapper);

		return new Subscription() {

			@Override
			public void dispose() {
				b.set(false);
				display.timerExec(-1, runnable);
			}
		};
	}

	@Override
	public <T> CompletableFuture<T> scheduleExecution(long delay, Callable<T> runnable) {
		CompletableFuture<T> future = new CompletableFuture<T>();

		Display display = Display.getDefault();
		display.timerExec((int) delay, () -> {
			try {
				if (!future.isCancelled()) {
					future.complete(runnable.call());
				}
			} catch (Exception e) {
				future.completeExceptionally(e);
			}
		});

		return future;
	}

}
