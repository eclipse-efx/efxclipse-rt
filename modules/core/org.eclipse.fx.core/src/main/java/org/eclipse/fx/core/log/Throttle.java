/*******************************************************************************
 * Copyright (c) 2018 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core.log;

import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

import org.eclipse.fx.core.log.FluentLogContext.MutableState;

/**
 * Throttle condition
 * 
 * @since 3.3.0
 */
public class Throttle extends Condition {

	/**
	 * Create a throttle condition API
	 * 
	 * @param context
	 *            the context
	 */
	public Throttle(FluentLogContext context) {
		super(context);
	}

	/**
	 * Log at most using the provided time interval
	 * 
	 * @param interval
	 *            the interval
	 * @param unit
	 *            the unit of the interval
	 * @return the log context
	 */
	public FluentLogContext interval(long interval, TimeUnit unit) {
		this.context.when(new TimePredicate(unit.toNanos(interval)));
		return this.context;
	}

	/**
	 * Log at most every n-th time
	 * 
	 * @param nTime
	 *            the number of log statements to miss
	 * @return the log context
	 */
	public FluentLogContext every(long nTime) {
		this.context.when(new CountPredicate(nTime));
		return this.context;
	}

	static class CountPredicate implements Predicate<MutableState> {
		private final long nTimes;

		public CountPredicate(long nTimes) {
			this.nTimes = nTimes;
		}

		@Override
		public boolean test(MutableState t) {
			return (t.lastLogCount() + this.nTimes) - t.currentCallCount() < 0;
		}
	}

	static class TimePredicate implements Predicate<MutableState> {
		private final long interval;

		public TimePredicate(long interval) {
			this.interval = interval;
		}

		@Override
		public boolean test(MutableState t) {
			return (t.lastLogTime() + this.interval) - System.nanoTime() > 0;
		}
	}
}
