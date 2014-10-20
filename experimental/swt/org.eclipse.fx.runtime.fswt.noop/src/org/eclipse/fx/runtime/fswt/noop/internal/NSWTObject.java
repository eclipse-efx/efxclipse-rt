package org.eclipse.fx.runtime.fswt.noop.internal;

import org.eclipse.fx.runtime.fswt.FSWTObject;

public class NSWTObject<T> implements FSWTObject<T> {
	private final T instance;

	public NSWTObject(T instance) {
		this.instance = instance;
	}

	@Override
	public T getNativeInstance() {
		return instance;
	}

}
