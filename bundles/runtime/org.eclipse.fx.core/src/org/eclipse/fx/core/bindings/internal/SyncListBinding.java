/*******************************************************************************
 * Copyright (c) 2016 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Christoph Caks<ccaks@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core.bindings.internal;

import org.eclipse.fx.core.ThreadSynchronize;

import javafx.beans.Observable;
import javafx.beans.binding.ListBinding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

@SuppressWarnings("javadoc")
public class SyncListBinding<A> extends ListBinding<A> {

	private SyncedBindingHelperObserver observer;

	private ObservableList<A> source;
	private ThreadSynchronize thread;

	public  SyncListBinding(ObservableList<A> source, ThreadSynchronize thread) {
		this.source = source;
		this.thread = thread;

		syncedBind(this.source);
	}

	@Override
	public void dispose() {
		syncedUnbind(this.source);
		super.dispose();
	}

	@Override
	protected ObservableList<A> computeValue() {
		return FXCollections.observableArrayList(this.source);
	}

	/**
	 * Start observing the dependencies for changes. If the value of one of the
	 * dependencies changes, the binding is marked as invalid.
	 *
	 * @param dependencies
	 *            the dependencies to observe
	 */
	protected final void syncedBind(Observable... dependencies) {
		if ((dependencies != null) && (dependencies.length > 0)) {
			if (this.observer == null) {
				this.observer = new SyncedBindingHelperObserver(this.thread, this);
			}
			for (final Observable dep : dependencies) {
				if (dep != null) {
					dep.addListener(this.observer);
				}
			}
		}
	}

	/**
	 * Stop observing the dependencies for changes.
	 *
	 * @param dependencies
	 *            the dependencies to stop observing
	 */
	protected final void syncedUnbind(Observable... dependencies) {
		if (this.observer != null) {
			for (final Observable dep : dependencies) {
				if (dep != null) {
					dep.removeListener(this.observer);
				}
			}
			this.observer = null;
		}
	}

}
