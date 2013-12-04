package org.eclipse.fx.core;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * A return value definition
 * 
 * @param <V>
 *            the returned value type
 */
public interface ReturnValue<V> {
	/**
	 * @return the state
	 */
	@NonNull
	public State getState();

	/**
	 * @return the message in case of none OK or CANCEL
	 */
	@Nullable
	public String getMessage();

	/**
	 * @return the value in case of OK
	 */
	@Nullable
	public V getValue();

	/**
	 * @return the exception causing the failure if one
	 */
	@Nullable
	public Throwable getThrowable();
	
	/**
	 * State of the method a callback
	 */
	public enum State {
		/**
		 * Action ended in error
		 */
		ERROR,
		/**
		 * Action ended with a warning
		 */
		WARNING,
		/**
		 * Action was canceled
		 */
		CANCEL,
		/**
		 * Action succeeded
		 */
		OK
	}
	
	/**
	 * Basic return value hold information for the callback
	 * 
	 * @param <V>
	 *            the value type
	 */
	public static class ReturnValueImpl<V> implements ReturnValue<V> {
		/**
		 * The state
		 */
		@NonNull
		public final State state;
		/**
		 * A message in case of a state different than OK or CANCEL
		 */
		@Nullable
		public final String message;
		/**
		 * An exception in case one was the reason for the failure
		 */
		@Nullable
		public final Throwable throwable;
		/**
		 * The value in case of a OK state
		 */
		@Nullable
		public final V value;

		/**
		 * Create a new return value
		 * 
		 * @param state
		 *            the state
		 * @param message
		 *            the message
		 * @param value
		 *            the value
		 * @param throwable
		 *            the exception
		 */
		public ReturnValueImpl(@NonNull State state, @Nullable String message, @Nullable V value, @Nullable Throwable throwable) {
			this.state = state;
			this.message = message;
			this.throwable = throwable;
			this.value = value;
		}

		@Override
		public String getMessage() {
			return this.message;
		}

		@Override
		public Throwable getThrowable() {
			return this.throwable;
		}

		@Override
		public State getState() {
			return this.state;
		}

		@Override
		public V getValue() {
			return this.value;
		}
	}
}