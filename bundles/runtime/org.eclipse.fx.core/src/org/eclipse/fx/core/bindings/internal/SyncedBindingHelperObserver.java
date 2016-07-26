package org.eclipse.fx.core.bindings.internal;

import java.lang.ref.WeakReference;

import org.eclipse.fx.core.ThreadSynchronize;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.Binding;

public class SyncedBindingHelperObserver implements InvalidationListener {

	private final ThreadSynchronize thread;
	private final WeakReference<Binding<?>> ref;

    public SyncedBindingHelperObserver(ThreadSynchronize thread, Binding<?> binding) {
        if (binding == null) {
            throw new NullPointerException("Binding has to be specified."); //$NON-NLS-1$
        }
        this.ref = new WeakReference<Binding<?>>(binding);
        this.thread = thread;
    }

    @Override
    public void invalidated(Observable observable) {
        this.thread.asyncExec(()->syncedInvalidated(observable));
    }

    private void syncedInvalidated(Observable observable) {
    	final Binding<?> binding = this.ref.get();
        if (binding == null) {
            observable.removeListener(this);
        } else {
            binding.invalidate();
        }
    }

}
