/*******************************************************************************
* Copyright (c) 2016 BestSolution.at and others.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
* 	Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
*******************************************************************************/
package org.eclipse.fx.code.editor.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import org.eclipse.fx.core.Subscription;
import org.eclipse.fx.core.text.TextEditAction;
import org.eclipse.jface.text.IRegion;

public class DelegatingEditingContext implements EditingContext {

	private EditingContext delegate;

	private class DelegateSubscription implements Subscription {
		private Runnable delegate;
		public void setDelegate(Runnable delegate) {
			this.delegate = delegate;
		}
		@Override
		public void dispose() {
			if (delegate != null) {
				delegate.run();
			}
		}

	}

	private List<Consumer<Integer>> todoCaretListeners = new ArrayList<>();
	private Map<Consumer<Integer>, DelegateSubscription> todoCaretSubscriptions = new HashMap<>();
	private List<Consumer<IRegion>> todoSelectionListeners = new ArrayList<>();
	private Map<Consumer<IRegion>, DelegateSubscription> todoSelectionSubscriptions = new HashMap<>();

	public void dispose() {
		this.delegate = null;
		for (Consumer<Integer> listener : todoCaretListeners) {
			Subscription s = todoCaretSubscriptions.remove(listener);
			if (s != null) {
				s.dispose();
			}
		}
		for (Consumer<IRegion> listener : todoSelectionListeners) {
			Subscription s = todoSelectionSubscriptions.remove(listener);
			if (s != null) {
				s.dispose();
			}
		}
	}

	public void setDelegate(EditingContext delegate) {
		this.delegate = delegate;
		// register early listeners
		if (this.delegate != null) {
			for (Consumer<Integer> listener : todoCaretListeners) {
				Subscription s = this.delegate.registerOnCaretOffsetChanged(listener);
				todoCaretSubscriptions.get(listener).setDelegate(()->s.dispose());
			}
			for (Consumer<IRegion> listener : todoSelectionListeners) {
				Subscription s = this.delegate.registerOnSelectionChanged(listener);
				todoSelectionSubscriptions.get(listener).setDelegate(()->s.dispose());
			}
		}
	}

	@Override
	public int getCaretOffset() {
		return delegate.getCaretOffset();
	}

	@Override
	public void setCaretOffset(int offset) {
		delegate.setCaretOffset(offset);
	}

	@Override
	public void setCaretOffset(int offset, boolean keepSelection) {
		delegate.setCaretOffset(offset, keepSelection);
	}

	@Override
	public IRegion getSelection() {
		return delegate.getSelection();
	}

	@Override
	public void setSelection(IRegion selection) {
		delegate.setSelection(selection);
	}

	@Override
	public void showContextInformation(ContextInformation info) {
		delegate.showContextInformation(info);
	}

	@Override
	public void triggerAction(TextEditAction action) {
		delegate.triggerAction(action);
	}

	@Override
	public Subscription registerOnCaretOffsetChanged(Consumer<Integer> listener) {
		if (delegate == null) {
			todoCaretListeners.add(listener);
			DelegateSubscription s = new DelegateSubscription();
			todoCaretSubscriptions.put(listener, s);
			return s;
		}
		return delegate.registerOnCaretOffsetChanged(listener);
	}

	@Override
	public Subscription registerOnSelectionChanged(Consumer<IRegion> listener) {
		if (delegate == null) {
			todoSelectionListeners.add(listener);
			DelegateSubscription s = new DelegateSubscription();
			todoSelectionSubscriptions.put(listener, s);
			return s;
		}
		return delegate.registerOnSelectionChanged(listener);
	}

}
