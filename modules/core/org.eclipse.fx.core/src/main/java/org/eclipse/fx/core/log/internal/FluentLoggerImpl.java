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
package org.eclipse.fx.core.log.internal;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.eclipse.fx.core.log.FluentLogContext;
import org.eclipse.fx.core.log.FluentLogContext.MutableState;
import org.eclipse.fx.core.log.FluentLogger;
import org.eclipse.fx.core.log.Logger;
import org.eclipse.fx.core.log.Logger.Level;
import org.eclipse.jdt.annotation.NonNull;

@SuppressWarnings("javadoc")
public class FluentLoggerImpl implements FluentLogger {
	@NonNull
	private final Logger logger;

	private static final FluentLogContext NO_LOG = new NoOpLogContextImpl();

	static class NoOpLogContextImpl implements FluentLogContext {
		
		@Override
		public <T> void log(@NonNull Function<T, @NonNull CharSequence> messageSupplier, T type) {
			// empty
		}

		@Override
		public void log(@NonNull Supplier<@NonNull CharSequence> messageSupplier) {
			// empty
		}

		@Override
		public void log(CharSequence message) {
			// empty
		}

		@Override
		public void log(String message, Object... arguments) {
			// empty
		}

		@Override
		public FluentLogContext withException(Throwable t) {
			return this;
		}
		
		@Override
		public FluentLogContext when(Predicate<MutableState> t) {
			return this;
		}
//		
//		@Override
//		public FluentLogContext until(Predicate<MutableState> t) {
//			return this;
//		}
//		
//		@Override
//		public FluentLogContext throttle(Predicate<MutableState> predicate) {
//			return this;
//		}
	}

	static class FluentLogContextImpl implements FluentLogContext {
		@NonNull
		private final Logger logger;
		@NonNull
		private final Level level;

		private Throwable t;
		
		private List<Predicate<MutableState>> whenList;
//		
//		private List<Predicate<MutableState>> throttleList;

		private final MutableStateImpl state;
		
		@SuppressWarnings("null")
		@NonNull
		private static final String FQN = FluentLogContextImpl.class.getCanonicalName();

		public FluentLogContextImpl(@NonNull Level level, @NonNull Logger logger) {
			this.level = level;
			this.logger = logger;
			this.state = new MutableStateImpl();
		}
		
		@Override
		public FluentLogContext when(Predicate<MutableState> t) {
			if( this.whenList == null ) {
				this.whenList = new CopyOnWriteArrayList<>();
			}
			this.whenList.add(t);
			return this;
		}
		
		private boolean shouldLog() {
			this.state.incrementCallCount();
			if( this.whenList == null ) {
				return true;
			}
			boolean rv = this.whenList.stream().allMatch(w -> w.test(this.state));
			return rv;
		}

		@Override
		public void log(CharSequence message) {
			if( shouldLog() ) {
				Throwable t = this.t;
				if (t == null) {
					this.logger.log(FQN, this.level, message);
				} else {
					this.logger.log(FQN, this.level, message, t);
				}
			}
		}

		@Override
		public void log(@NonNull String message, Object... arguments) {
			if( shouldLog() ) {
				Throwable t = this.t;
				if (t == null) {
					this.logger.logf(FQN,this.level, message, arguments);
				} else {
					this.logger.logf(FQN,this.level, message, t, arguments);
				}				
			}
		}

		@Override
		public void log(@NonNull Supplier<@NonNull CharSequence> messageSupplier) {
			log(messageSupplier.get());
		}

		@Override
		public <T> void log(@NonNull Function<T, @NonNull CharSequence> messageSupplier, T type) {
			log(messageSupplier.apply(type));
		}

		@Override
		public FluentLogContext withException(Throwable t) {
			this.t = t;
			return this;
		}
	}
	
	/**
	 * Mutable state of the long context
	 */
	public static class MutableStateImpl implements MutableState {
		private AtomicLong callCount = new AtomicLong();
		
		/**
		 * Create new state
		 */
		public MutableStateImpl() {
		}
		
		public long incrementCallCount() {
			return this.callCount.incrementAndGet();
		}
		
		@Override
		public long callCount() {
			return this.callCount.get();
		}
	}

	public FluentLoggerImpl(@NonNull Logger logger) {
		this.logger = logger;
	}

	@Override
	public FluentLogContext at(@NonNull Level level) {
		if (this.logger.isEnabled(level)) {
			return new FluentLogContextImpl(level, this.logger); 
		}
		return NO_LOG;
	}
}
