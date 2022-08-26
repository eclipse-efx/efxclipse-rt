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

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

import org.eclipse.fx.core.ThreadSynchronize.BlockCondition;
import org.eclipse.fx.core.log.Logger;
import org.eclipse.fx.core.log.LoggerCreator;

/**
 * Basic implementation of an event loop who mimics behavior of
 * UI-Toolkits-Event-Processing
 *
 * @since 3.0
 */
public class EventLoop implements ThreadQueue {
	AtomicReference<Runnable> runnableRef = new AtomicReference<>();

	private volatile AtomicInteger spinningEventLoop = new AtomicInteger();
	
	private final Thread thread = new Thread() {
		@Override
		public void run() {
			EventLoop.this.runnableRef.get().run();
		}
	};
	private ExecutorService service = Executors.newSingleThreadExecutor(r -> {
		this.runnableRef.set(r);
		this.thread.setDaemon(true);
		return this.thread;
	});

	List<Runnable> tasks = new ArrayList<>();

	private static Logger LOGGER;

	private static Logger getLogger() {
		if (LOGGER == null) {
			LOGGER = LoggerCreator.createLogger(EventLoop.class);
		}
		return LOGGER;
	}

	@Override
	public boolean isCurrent() {
		return Thread.currentThread() == this.thread;
	}

	@Override
	public Subscription push(Runnable r) {
		if( isCurrent() ) {
			r.run();
			return () -> {
				// Nothing to do
			};
		}

		synchronized (this.tasks) {
			this.tasks.add(r);
		}
		return () -> {
			synchronized (this.tasks) {
				this.tasks.remove(r);
			}
		};
	}

	/**
	 * Stop the caller thread
	 */
	@SuppressWarnings("static-method")
	public void sleep() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// not important
		}
	}

	/**
	 * Dispatch all queued runnable
	 *
	 * @return <code>true</code> if there are still {@link Runnable} actions to
	 *         dispatch
	 */
	@SuppressWarnings("null")
	public boolean dispatch() {
		if( this.spinningEventLoop.get() > 0 && ! isCurrent() ) {
			return false;
		}
		ArrayList<Runnable> list;
		synchronized (this.tasks) {
			list = new ArrayList<>(this.tasks);
			this.tasks.clear();
		}
		Runnable executable = () -> {
			for (Runnable r : list) {
				try {
					r.run();
				} catch (Throwable t) {
					getLogger().error(t.getMessage(), t);
				}
			}
		};
		
		if( isCurrent() ) {
			executable.run();
		} else {
			this.service.submit(executable);	
		}
		

		synchronized (this.tasks) {
			return !this.tasks.isEmpty();
		}
	}

	/**
	 * Dispose the event queue
	 */
	public void dispose() {
		this.service.shutdown();
	}

	@Override
	public <T> void spinWhile(BlockCondition<T> condition) {
		this.spinningEventLoop.incrementAndGet();
		while( condition.isBlocked() ) {
			if( ! dispatch() ) {
				sleep();
			}
		}
		this.spinningEventLoop.decrementAndGet();
	}
//
//	public static void main(String[] args) {
//		EventLoop evt = new EventLoop();
//		Thread t = new Thread() {
//			@Override
//			public void run() {
//				for (int i = 0; i < 20; i++) {
//					evt.push(() -> {
//						System.err.println("A new event " + System.currentTimeMillis());
//					});
//					try {
//						Thread.sleep(20);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//			}
//		};
//		t.start();
//
//		for (int i = 0; i < 1000; i++) {
//			if (!evt.dispatch()) {
//				System.err.println("Sleeping");
//				evt.sleep();
//			}
//		}
//		evt.dispose();
//	}
}
