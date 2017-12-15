package org.eclipse.fx.core.bindings.internal;

import org.eclipse.fx.core.Status;
import org.eclipse.fx.core.Status.State;
import org.eclipse.fx.core.bindings.FXBindings.StatusBinding;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.ObjectBinding;

public abstract class BaseBidiPropertyBinding extends ObjectBinding<Status> implements StatusBinding {
	private Observable source;
	private Observable target;
	private Status curStatus;

	private boolean inUpdate = false;

	public BaseBidiPropertyBinding(Observable target, Observable source) {
		this.source = source;
		this.target = target;

		target.addListener(this.onInvalidate);
		source.addListener(this.onInvalidate);

		_doSourceToTarget();
	}

	private InvalidationListener onInvalidate = this::onInvalidate;
	private void onInvalidate(Observable o) {
		if (o == this.source) {
			_doSourceToTarget();
		}
		else if (o == this.target) {
			doTargetToSource();
		}
	}

	protected abstract void syncTarget();

	private void _doSourceToTarget() {
		if (this.inUpdate) return;
		this.inUpdate = true;
		try {
			syncTarget();
			setStatus(Status.ok());
		}
		catch (Throwable t) {
			setStatus(Status.status(State.ERROR, 0, "sourceToTarget failure", t)); //$NON-NLS-1$
		}
		finally {
			this.inUpdate = false;
		}
	}

	protected abstract void syncSource();

	private void doTargetToSource() {
		if (this.inUpdate) return;
		this.inUpdate = true;
		try {
			syncSource();
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
