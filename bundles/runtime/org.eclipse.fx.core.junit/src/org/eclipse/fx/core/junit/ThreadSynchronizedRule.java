/*******************************************************************************
 * Copyright (c) 2017 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core.junit;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;

import org.eclipse.fx.core.EventLoop;
import org.eclipse.fx.core.ThreadSynchronize;
import org.eclipse.fx.core.ThreadSynchronize.BlockCondition;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * JUnit-Rule to execute tests on a dedicated thread
 *
 * @since 3.0.0
 */
public class ThreadSynchronizedRule implements TestRule {
	private final ThreadSynchronize threadSync;
	private final Consumer<BlockCondition<Void>> waitConditionAcceptor;

	private Thread eventProcessor = new Thread(this::spin);
	private AtomicBoolean spinning = new AtomicBoolean();
	private EventLoop queue;

	/**
	 * Create a new rule who executes the tests on the provided
	 * {@link ThreadSynchronize} utility. In addition it waits for an
	 * initialization phase to get completed.
	 *
	 * @param waitConditionAcceptor
	 *            acceptor who gets a {@link BlockCondition} and executes after
	 *            this until the condition object is released to execute the
	 *            tests. <strong>Important: The consumer method is called on the
	 *            dedicated thread as well</strong>
	 */
	public ThreadSynchronizedRule(Consumer<BlockCondition<Void>> waitConditionAcceptor) {
		this.queue = new EventLoop();
		this.threadSync = ThreadSynchronize.createBasicThreadSyncronize(queue);
		this.waitConditionAcceptor = waitConditionAcceptor;
		this.spinning.set(true);
		this.eventProcessor.start();
	}

	private void spin() {
		while( spinning.get() ) {
			if( ! queue.dispatch() ) {
				queue.sleep();
			}
		}
	}

	/**
	 * Stop the processing of the event queue
	 */
	public void stopEventQueue() {
		spinning.set(false);
	}

	/**
	 * Create a new rule who calls the test methods using the provided
	 * {@link ThreadSynchronize} utility
	 *
	 * @param threadSync
	 *            the thread synchronization utility
	 */
	public ThreadSynchronizedRule(ThreadSynchronize threadSync) {
		this.threadSync = threadSync;
		this.waitConditionAcceptor = null;
	}

	@Override
	public Statement apply(Statement base, Description description) {
		Statement result = base;
		RunInSyncThread annotation = description.getAnnotation(RunInSyncThread.class);
		if (annotation != null) {
			result = new RunInThreadStmt(base, threadSync, waitConditionAcceptor);
		}
		return result;
	}

	static class RunInThreadStmt extends Statement {
		private Statement base;
		private ThreadSynchronize threadSync;
		private Consumer<BlockCondition<Void>> waitConditionAcceptor;

		public RunInThreadStmt(Statement base, ThreadSynchronize threadSync,
				Consumer<BlockCondition<Void>> waitConditionAcceptor) {
			this.base = base;
			this.threadSync = threadSync;
			this.waitConditionAcceptor = waitConditionAcceptor;
		}

		@Override
		public void evaluate() throws Throwable {
			CompletableFuture<Void> f = new CompletableFuture<>();

			Runnable execute = () -> {
				try {
					base.evaluate();
					f.complete(null);
				} catch (Throwable t) {
					f.completeExceptionally(t);
				}
			};
			if (waitConditionAcceptor != null) {
				threadSync.asyncExec(() -> {

					BlockCondition<Void> c = new BlockCondition<>();
					c.subscribeUnblockedCallback((v) -> {
						execute.run();
					});
					waitConditionAcceptor.accept(c);
				});
			} else {
				execute.run();
			}

			try {
				f.get();
			} catch (ExecutionException ex) {
				if (ex.getCause() instanceof AssertionError) {
					throw ex.getCause();
				} else {
					throw ex;
				}
			}
		}
	}

	/**
	 * @return a thread synchronizer
	 */
	public ThreadSynchronize getThreadSynchronize() {
		return threadSync;
	}
}
