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

import javafx.beans.InvalidationListener;
import javafx.beans.binding.ListBinding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


@SuppressWarnings("javadoc")
public class ConcatListBinding<A> extends ListBinding<A> {

	private ObservableList<A>[] source;

	private InvalidationListener onInvalidate = obs -> this.invalidate();

	private void initListeners() {
		for (ObservableList<A> l : this.source) {
			l.addListener(this.onInvalidate);
		}
	}

	private void disposeListeners() {
		for (ObservableList<A> l : this.source) {
			l.removeListener(this.onInvalidate);
		}
	}

	@SuppressWarnings("unchecked")
	public ConcatListBinding(ObservableList<A>... source) {
		this.source = source;
		initListeners();
	}

	@Override
	protected ObservableList<A> computeValue() {
		return FXCollections.concat(this.source);
	}

	@Override
	public void dispose() {
		disposeListeners();
		super.dispose();
	}

}