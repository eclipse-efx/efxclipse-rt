package org.eclipse.fx.core.p2;

import java.util.function.Consumer;

import org.eclipse.fx.core.StatusException;
import org.eclipse.fx.core.operation.CancelableOperation;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

public class SimpleCancelableOperation<T> implements CancelableOperation<T> {
	private final Runnable cancelable;

	private int state = 0;
	private static final int COMPLETED_OK = 1;
	private static final int COMPLETED_EXCEPTION = 2;
	private static final int CANCLED = 3;

	@Nullable
	private T object;

	@Nullable
	private Consumer<@Nullable T> onCompleteConsumer;

	@Nullable
	private StatusException exception;
	@Nullable
	private Consumer<@NonNull StatusException> onCompleteExceptionallyConsumer;

	@Nullable
	private Runnable onCancelConsumer;


	public SimpleCancelableOperation(@NonNull Runnable cancelable) {
		this.cancelable = cancelable;
	}

	public synchronized void completed(@Nullable T object) {
		this.object = object;
		this.state = COMPLETED_OK;
		if( this.onCompleteConsumer != null ) {
			this.onCompleteConsumer.accept(object);
		}
	}

	public synchronized void completeExceptionally(@NonNull StatusException t) {
		this.exception = t;
		this.state = COMPLETED_EXCEPTION;
		if( this.onCompleteExceptionallyConsumer != null ) {
			this.onCompleteExceptionallyConsumer.accept(t);
		}
	}

	@Override
	public synchronized CancelableOperation<T> onComplete(@NonNull Consumer<@Nullable T> consumer) {
		if( this.state == COMPLETED_OK ) {
			consumer.accept(this.object);
		} else {
			this.onCompleteConsumer = consumer;
		}
		return this;
	}

	@Override
	public synchronized CancelableOperation<T> onException(@NonNull Consumer<@NonNull StatusException> consumer) {
		if( this.state == COMPLETED_EXCEPTION ) {
			if( this.exception != null ) {
				consumer.accept(this.exception);
			}
		} else {
			this.onCompleteExceptionallyConsumer = consumer;
		}
		return this;
	}

	@Override
	public synchronized CancelableOperation<T> onCancel(@NonNull Runnable consumer) {
		if( this.state == CANCLED ) {
			consumer.run();
		} else {
			this.onCancelConsumer = consumer;
		}
		return this;
	}

	@Override
	public synchronized void cancel() {
		this.cancelable.run();
		this.state = CANCLED;
		if( this.onCancelConsumer != null ) {
			this.onCancelConsumer.run();
		}
	}

}
