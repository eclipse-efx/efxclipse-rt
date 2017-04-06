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
package org.eclipse.fx.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.eclipse.fx.core.log.LoggerCreator;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import javafx.beans.property.Property;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 * Class to synchronize with a predefined thread e.g. the UI-Thread
 *
 * @since 2.0
 */
public interface ThreadSynchronize {
	/**
	 * @return <code>true</code> if the calling thread is synchronization thread
	 */
	boolean isCurrent();

	/**
	 * Sync with the sync thread and provide a result when done
	 * <p>
	 * <b>WARNING: Using synchronized execute can easily lead to deadlocks. You
	 * are better of using {@link #asyncExec(Callable)}</b>
	 * </p>
	 *
	 * @param callable
	 *            the callable to execute
	 * @param defaultValue
	 *            a default value to return
	 * @return the result of callable.call()
	 */
	<V> V syncExec(final Callable<V> callable, V defaultValue);

	/**
	 * Execute the function in the UI-Thread
	 *
	 * @param value
	 *            the value
	 * @param function
	 *            the function
	 * @param defaultValue
	 *            the default value
	 * @return the return value of the function
	 * @since 2.3.0
	 */
	default <T, R> R syncExec(final T value, final Function<T, R> function, R defaultValue) {
		Callable<R> c = () -> function.apply(value);
		return syncExec(c, defaultValue);
	}

	/**
	 * Executes the runnable on the sync thread and blocks until the runnable is
	 * finished
	 * <p>
	 * <b>WARNING: Using synchronized execute can easily lead to deadlocks. You
	 * are better of using {@link #asyncExec(Runnable)}</b>
	 * </p>
	 *
	 * @param runnable
	 *            the runnable to execute
	 */
	void syncExec(Runnable runnable);

	/**
	 * Schedules the runnable on the sync thread for execution and returns
	 * immediately
	 *
	 * @param callable
	 *            the callable to execute
	 * @return interface to the result of the callable
	 */
	<V> Future<V> asyncExec(final Callable<V> callable);

	/**
	 * Schedules the runnable on the sync thread for execution and returns
	 * immediately
	 *
	 * @param runnable
	 *            the runnable to execute
	 */
	void asyncExec(Runnable runnable);

	/**
	 * Executes the consumer in the ui thread
	 *
	 * @param value
	 *            the value
	 * @param consumer
	 *            the consumer
	 * @since 2.3.0
	 */
	default <@Nullable T> void asyncExec(T value, Consumer<T> consumer) {
		asyncExec(() -> consumer.accept(value));
	}

	/**
	 * Schedule the execution of the runnable
	 *
	 * @param delay
	 *            the delay
	 * @param runnable
	 *            the runnable to execute
	 * @return subscription to cancel the execution
	 */
	Subscription scheduleExecution(long delay, Runnable runnable);

	/**
	 * Schedule the execution of the callable
	 *
	 * @param delay
	 *            the delay
	 * @param runnable
	 *            the callable to execute
	 * @return future to get informed about the value
	 */
	<T> CompletableFuture<T> scheduleExecution(long delay, Callable<T> runnable);

	/**
	 * Schedule a delayed execution on the provided property.
	 * <p>
	 * The consumer is called whenever the value of the property changes with
	 * the provided delay. In case the value changes within the given delay the
	 * scheduled consumer execution is discarded.
	 * </p>
	 *
	 * @param delay
	 *            the delay
	 * @param property
	 *            the property
	 * @param consumer
	 *            the consumer (always called on the synchronize thread)
	 * @return the subscription
	 * @since 2.2.0
	 */
	default <T> Subscription delayedChangeExecution(long delay, Property<T> property, Consumer<T> consumer) {
		ChangeListener<T> l = new ChangeListener<T>() {
			private Subscription currentSubscription;

			@Override
			public void changed(ObservableValue<? extends T> observable, T oldValue, T newValue) {
				if (this.currentSubscription != null) {
					this.currentSubscription.dispose();
				}
				this.currentSubscription = scheduleExecution(delay, () -> {
					consumer.accept(newValue);
					this.currentSubscription = null;
				});
			}
		};
		property.addListener(l);
		return new Subscription() {

			@Override
			public void dispose() {
				property.removeListener(l);
			}
		};
	}

	/**
	 * Schedule a delayed execution on the provided list of properties.
	 *
	 * @param delay
	 *            the delay
	 * @param consumer
	 *            the consumer receiving the values of the properties
	 * @param properties
	 *            the list of properties
	 * @return the subscription
	 * @since 3.0
	 */
	default <T> Subscription delayedChangeExecution(long delay, Consumer<List<T>> consumer,
			@SuppressWarnings("unchecked") Property<T>... properties) {
		Runnable r = () -> {
			List<T> l = new ArrayList<>();
			for (Property<T> p : properties) {
				l.add(p.getValue());
			}
			consumer.accept(l);
		};

		ChangeListener<T> l = new ChangeListener<T>() {
			private Subscription currentSubscription;

			@Override
			public void changed(ObservableValue<? extends T> observable, T oldValue, T newValue) {
				if (this.currentSubscription != null) {
					this.currentSubscription.dispose();
				}
				this.currentSubscription = scheduleExecution(delay, () -> {
					r.run();
					this.currentSubscription = null;
				});
			}
		};
		for (Property<T> p : properties) {
			p.addListener(l);
		}

		return new Subscription() {

			@Override
			public void dispose() {
				for (Property<T> p : properties) {
					p.removeListener(l);
				}
			}
		};
	}

	/**
	 * Wraps a runnable so that it is called on the UI thread.
	 * <p>
	 * This is handy if you pass a {@link Runnable} as callback into some async
	 * API
	 * </p>
	 *
	 * @param r
	 *            the runnable to wrap
	 * @return a new runnable who invokes the real runnable on the UI thread
	 */
	default Runnable wrap(Runnable r) {
		return () -> asyncExec(r);
	}

	/**
	 * Wraps a consumer so that it is called on the sync thread.
	 * <p>
	 * This is handy if you pass a {@link Consumer} as callback into some async
	 * API
	 * </p>
	 *
	 * @param c
	 *            the consumer to wrap
	 * @return a new consumer who invokes the real consumer on the UI thread
	 */
	default <T> Consumer<T> wrap(Consumer<T> c) {
		return (t) -> asyncExec(() -> c.accept(t));
	}

	/**
	 * Wraps a bi-consumer so that it is called on the UI thread
	 * <p>
	 * This is handy if you pass a {@link BiConsumer} as callback into some
	 * async API
	 * </p>
	 *
	 * @param c
	 *            the consumer to wrap
	 * @return a new consumer who invokes the real consumer on the UI thread
	 */
	default <T, U> BiConsumer<T, U> wrap(BiConsumer<T, U> c) {
		return (t, u) -> asyncExec(() -> c.accept(t, u));
	}

	/**
	 * Wraps a supplier so that it is called on the UI thread
	 *
	 * @param s
	 *            the supplier
	 * @return a new supplier who invokes the real supplier on the UI thread
	 */
	default <@Nullable T> Supplier<T> wrap(Supplier<T> s) {
		return () -> syncExec(() -> s.get(), null);
	}

	// /**
	// * Returns the named queue
	// *
	// * @param name
	// * the name of the queue
	// * @return the queue
	// */
	// public SynchronizeQueue getQueue(String name);
	//
	// /**
	// * A synchronization queue allowing to prioritize ui updates and
	// optimizing
	// * the update by e.g. removing duplicate update requests
	// */
	// public interface SynchronizeQueue {
	// public void schedule(int priority);
	//
	// public <O> void schedule(int priority, O value, Consumer<O> consumer);
	// }

	/**
	 * Block the Thread in a way that events are still processed until the given
	 * condition is released
	 *
	 * @param blockCondition
	 *            the condition
	 * @return the value
	 * @since 3.0.0
	 */
	<T> @Nullable T block(@NonNull BlockCondition<T> blockCondition);

	/**
	 * A block condition
	 *
	 * @param <T>
	 *            the type
	 * @since 2.3.0
	 */
	public static class BlockCondition<T> {
		List<Consumer<T>> callbacks = new ArrayList<>();
		private volatile boolean isBlocked = true;

		/**
		 * Subscribe to unblocking
		 *
		 * @param r
		 *            the callback
		 * @return the subscription
		 */
		public Subscription subscribeUnblockedCallback(Consumer<T> r) {
			if (!this.isBlocked) {
				throw new IllegalStateException();
			}
			this.callbacks.add(r);
			return new Subscription() {

				@Override
				public void dispose() {
					BlockCondition.this.callbacks.remove(r);
				}
			};
		}

		/**
		 * @return check if still blocked
		 */
		public boolean isBlocked() {
			return this.isBlocked;
		}

		/**
		 * Release the lock and pass value
		 *
		 * @param value
		 *            the value to pass
		 */
		public void release(T value) {
			for (Consumer<T> r : this.callbacks) {
				r.accept(value);
			}
			this.callbacks.clear();
			this.isBlocked = false;
		}
	}

	/**
	 * <p>
	 * Create a basic thread synchronization object who forces all executions on
	 * the same arbitrary thread
	 * </p>
	 * <p>
	 * A {@link ThreadSynchronize} like this is eg useful in JUnit-Test cases
	 * </p>
	 *
	 * @param threadQueue
	 *            the thread queue to use
	 * @return an thread synchronizer
	 * @since 3.0.0
	 */
	public static ThreadSynchronize createBasicThreadSyncronize(ThreadQueue threadQueue) {
		class BasicThreadSynchronize implements ThreadSynchronize {
			private Timer timer = new Timer(true);

			@Override
			public boolean isCurrent() {
				return threadQueue.isCurrent();
			}

			@Override
			public <V> V syncExec(Callable<V> callable, V defaultValue) {
				if (isCurrent()) {
					try {
						return callable.call();
					} catch (Exception e) {
						throw new RuntimeException(e);
					}
				} else {
					RunnableFuture<V> task = new FutureTask<V>(callable);
					asyncExec(task);
					try {
						return task.get();
					} catch (InterruptedException | ExecutionException e) {
						LoggerCreator.createLogger(getClass()).error("Unable to wait until the task is completed", e); //$NON-NLS-1$
					} finally {
						task.cancel(true);
					}
				}
				return defaultValue;
			}

			@Override
			public void syncExec(Runnable runnable) {
				if (isCurrent()) {
					runnable.run();
				} else {
					RunnableFuture<?> task = new FutureTask<Void>(runnable, null);
					asyncExec(task);
					try {
						task.get(); // wait for task to complete
					} catch (InterruptedException | ExecutionException e) {
						LoggerCreator.createLogger(getClass()).error("Unable to wait until the task is completed", e); //$NON-NLS-1$
					} finally {
						task.cancel(true);
					}
				}
			}

			@Override
			public <V> Future<V> asyncExec(Callable<V> callable) {
				RunnableFuture<V> task = new FutureTask<V>(callable);
				asyncExec(task);
				return task;
			}

			@Override
			public void asyncExec(Runnable runnable) {
				threadQueue.push(runnable);
			}

			@Override
			public Subscription scheduleExecution(long delay, Runnable runnable) {
				TimerTask task = new TimerTask() {

					@Override
					public void run() {
						asyncExec(runnable);
					}
				};
				this.timer.schedule(task, delay);
				return () -> {
					task.cancel();
				};
			}

			@SuppressWarnings("null")
			@Override
			public <T> CompletableFuture<T> scheduleExecution(long delay, Callable<T> runnable) {
				return CompletableFuture.supplyAsync(() -> {
					try {
						Thread.sleep(delay);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return syncExec(runnable, null);
				});
			}

			@Override
			public <T> @Nullable T block(@NonNull BlockCondition<T> blockCondition) {
				AtomicReference<T> rv = new AtomicReference<>();
				threadQueue.spinWhile(blockCondition);
				return rv.get();
			}
		}
		return new BasicThreadSynchronize();
	}
}
