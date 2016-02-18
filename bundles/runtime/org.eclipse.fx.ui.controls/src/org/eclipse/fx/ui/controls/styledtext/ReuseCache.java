package org.eclipse.fx.ui.controls.styledtext;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.function.Consumer;
import java.util.function.Supplier;

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
		if (free.isEmpty()) {
			element = factory.get();
		}
		else {
			element = free.pop();
		}
		active.add(element);
		onActivate.forEach(a->a.accept(element));
		return element;
	}

	public void releaseElement(T element) {
		active.remove(element);
		onRelease.forEach(a->a.accept(element));
		free.push(element);
	}

	public void clearFreeElements() {
		free.clear();
	}

	public boolean isActive(T element) {
		onClear.forEach(onClear->onClear.accept(element));
		return active.contains(element);
	}

}
