/*******************************************************************************
 * Copyright (c) 2016 BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Christoph Caks<ccaks@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core.bindings.internal;

import java.lang.ref.WeakReference;
import java.util.Objects;

import org.eclipse.fx.core.ThreadSynchronize;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.Binding;

@SuppressWarnings("javadoc")
public class SyncedBindingHelperObserver implements InvalidationListener {

	private final ThreadSynchronize thread;
	private final WeakReference<Binding<?>> ref;

    public SyncedBindingHelperObserver(ThreadSynchronize thread, Binding<?> binding) {
    	Objects.requireNonNull(binding);
        this.ref = new WeakReference<Binding<?>>(binding);
        this.thread = thread;
    }

    @Override
    public void invalidated(Observable observable) {
        this.thread.syncExec(()->syncedInvalidated(observable));
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
