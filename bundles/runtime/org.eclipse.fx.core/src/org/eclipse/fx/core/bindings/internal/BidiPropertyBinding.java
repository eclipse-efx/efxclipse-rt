package org.eclipse.fx.core.bindings.internal;

import java.util.function.Function;

import org.eclipse.fx.core.Status;
import org.eclipse.fx.core.Status.State;
import org.eclipse.fx.core.bindings.FXBindings.StatusBinding;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.ObjectBinding;
import javafx.beans.property.Property;


@SuppressWarnings("javadoc")
public class BidiPropertyBinding<S, T> extends ObjectBinding<Status> implements StatusBinding {

	private final Property<T> target;
	private final Property<S> source;
	private final Function<T, S> targetToSource;
	private final Function<S, T> sourceToTarget;

	private Status curStatus;

	private boolean inUpdate = false;

	public BidiPropertyBinding(Property<T> target, Property<S> source, Function<T, S> targetToSource, Function<S, T> sourceToTarget) {
		this.target = target;
		this.source = source;
		this.targetToSource = targetToSource;
		this.sourceToTarget = sourceToTarget;

		source.addListener(this.onInvalidate);
		target.addListener(this.onInvalidate);

		doSourceToTarget();
	}

	private InvalidationListener onInvalidate = this::onInvalidate;
	private void onInvalidate(Observable o) {
		if (o == this.source) {
			doSourceToTarget();
		}
		else if (o == this.target) {
			doTargetToSource();
		}
	}

	private void doSourceToTarget() {
		if (this.inUpdate) return;
		this.inUpdate = true;
		try {
			this.target.setValue(this.sourceToTarget.apply(this.source.getValue()));
			setStatus(Status.ok());
		}
		catch (Throwable t) {
			setStatus(Status.status(State.ERROR, 0, "sourceToTarget failure", t)); //$NON-NLS-1$
		}
		finally {
			this.inUpdate = false;
		}
	}

	private void doTargetToSource() {
		if (this.inUpdate) return;
		this.inUpdate = true;
		try {
			this.source.setValue(this.targetToSource.apply(this.target.getValue()));
			setStatus(Status.ok());
		}
		catch (Throwable t) {
			setStatus(Status.status(State.ERROR, 0, "targetToSource failure", t)); //$NON-NLS-1$
		}
		finally {
			this.inUpdate = false;
		}
	}

	@Override
	public void dispose() {
		this.source.removeListener(this.onInvalidate);
		this.target.removeListener(this.onInvalidate);
		super.dispose();
	}


	private void setStatus(Status s) {
		this.curStatus = s;
		invalidate();
	}

	@Override
	protected Status computeValue() {
		return this.curStatus;
	}

}
