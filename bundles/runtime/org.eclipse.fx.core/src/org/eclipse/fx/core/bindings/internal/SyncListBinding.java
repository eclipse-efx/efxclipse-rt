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

import javafx.beans.InvalidationListener;
import javafx.beans.binding.ListBinding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

@SuppressWarnings("javadoc")
public class SyncListBinding<A> extends ListBinding<A> {

	private	ObservableList<A> source;
	private ThreadSynchronize thread;


	private InvalidationListener onInvalidate = x -> {
		this.thread.asyncExec(()-> {
			SyncListBinding.this.invalidate();
		});
	};

	public  SyncListBinding(ObservableList<A> source, ThreadSynchronize thread) {
		this.source = source;
		this.thread = thread;

		this.source.addListener(this.onInvalidate);

	}

	@Override
	public void dispose() {
		this.source.removeListener(this.onInvalidate);
		super.dispose();
	}

	@Override
	protected ObservableList<A> computeValue() {
		return FXCollections.observableArrayList(this.source);
	}

}
