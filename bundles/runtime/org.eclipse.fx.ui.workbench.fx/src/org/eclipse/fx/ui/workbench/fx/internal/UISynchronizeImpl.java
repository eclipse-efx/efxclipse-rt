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
package org.eclipse.fx.ui.workbench.fx.internal;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

import javax.inject.Inject;

import org.eclipse.fx.core.Callback;
import org.eclipse.fx.core.Subscription;
import org.eclipse.fx.core.log.Log;
import org.eclipse.fx.core.log.Logger;
import org.eclipse.fx.ui.services.sync.UISynchronize;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import com.sun.javafx.tk.Toolkit;

/**
 * Implementation of the UISynchronize service for JavaFX
 */
@SuppressWarnings("restriction")
public class UISynchronizeImpl extends org.eclipse.e4.ui.di.UISynchronize implements UISynchronize {
	
	@Inject
	@Log
	Logger logger;
	
	@Override
	public <V> V syncExec(final Callable<V> callable, V defaultValue) {
		if (javafx.application.Platform.isFxApplicationThread()) {
			try {
				return callable.call();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		} else {
			RunnableFuture<V> task = new FutureTask<V>(callable);
			javafx.application.Platform.runLater(task);
			try {
				return task.get();
			} catch (InterruptedException | ExecutionException e) {
				this.logger.error("Unable to wait until the task is completed", e); //$NON-NLS-1$
			} finally {
				task.cancel(true);
			}
		}
		return defaultValue;
	}

	@Override
	public void syncExec(final Runnable runnable) {
		if (javafx.application.Platform.isFxApplicationThread()) {
			runnable.run();
		} else {
			RunnableFuture<?> task = new FutureTask<Void>(runnable, null);
			javafx.application.Platform.runLater(task);
			try {
				task.get(); // wait for task to complete
			} catch (InterruptedException | ExecutionException e) {
				this.logger.error("Unable to wait until the task is completed", e); //$NON-NLS-1$
			} finally {
				task.cancel(true);
			}
		}
	}
	
	@Override
	public <V> Future<V> asyncExec(final Callable<V> callable) {
		RunnableFuture<V> task = new FutureTask<V>(callable);
		javafx.application.Platform.runLater(task);
		return task;
	}
	
	@Override
	public void asyncExec(Runnable runnable) {
		javafx.application.Platform.runLater(runnable);
	}
	
	@Override
	public Subscription scheduleExecution(long delay, Runnable runnable) {
		final AtomicBoolean b = new AtomicBoolean(true);
		Timeline t = new Timeline(new KeyFrame(Duration.millis(delay), (a) -> {
			if( b.get() ) {
				runnable.run();	
			}
		} ));
		t.play();
		return new Subscription() {
			
			@Override
			public void dispose() {
				b.set(false);
				t.stop();
			}
		};
	}
	
	@Override
	public <T> CompletableFuture<T> scheduleExecution(long delay, Callable<T> runnable) {
		CompletableFuture<T> future = new CompletableFuture<T>();
		
		Timeline t = new Timeline(new KeyFrame(Duration.millis(delay), (a) -> {
			try {
				if( ! future.isCancelled() ) {
					future.complete(runnable.call());	
				}
			} catch (Exception e) {
				future.completeExceptionally(e);
			}	
		} ));
		t.play();
		
		return future;
	}
	
	@Override
	public <T> @Nullable T block(@NonNull BlockCondition<T> blockCondition) {
		AtomicReference<@Nullable T> rv = new AtomicReference<>();
		blockCondition.subscribeUnblockedCallback(new Callback<T>() {

			@Override
			public void call(@Nullable T value) {
				rv.set(value);
				Toolkit.getToolkit().exitNestedEventLoop(blockCondition, null);
			}
		});
		Toolkit.getToolkit().enterNestedEventLoop(blockCondition);
		return rv.get();
	}
}

