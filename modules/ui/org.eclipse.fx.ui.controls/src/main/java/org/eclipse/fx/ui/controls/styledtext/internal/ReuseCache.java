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
 * 	Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.controls.styledtext.internal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.function.Consumer;
import java.util.function.Supplier;

@SuppressWarnings("javadoc")
public class ReuseCache<T> {

	private Supplier<T> factory;

	public ReuseCache(Supplier<T> factory) {
		this.factory = factory;
	}

	private List<Consumer<T>> onActivate = new ArrayList<>();
	private List<Consumer<T>> onRelease = new ArrayList<>();
	private List<Consumer<T>> onClear = new ArrayList<>();

	private Stack<T> free = new Stack<>();
	private Set<T> active = new HashSet<>();

	public void addOnActivate(Consumer<T> onActivate) {
		this.onActivate.add(onActivate);
	}

	public void addOnRelease(Consumer<T> onRelease) {
		this.onRelease.add(onRelease);
	}

	public void addOnClear(Consumer<T> onClear) {
		this.onClear.add(onClear);
	}

	public T getElement() {
		T element;
		if (this.free.isEmpty()) {
			element = this.factory.get();
		}
		else {
			element = this.free.pop();
		}
		this.active.add(element);
		this.onActivate.forEach(a->a.accept(element));
		return element;
	}

	public void releaseElement(T element) {
		this.active.remove(element);
		this.onRelease.forEach(a->a.accept(element));
//		free.push(element); //FIXME Tom no caching as of NOW
	}

	public void clearFreeElements() {
		this.free.clear();
	}

	public boolean isActive(T element) {
		this.onClear.forEach(onClear->onClear.accept(element));
		return this.active.contains(element);
	}

}
