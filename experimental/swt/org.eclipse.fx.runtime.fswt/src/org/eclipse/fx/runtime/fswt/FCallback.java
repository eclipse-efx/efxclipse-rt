package org.eclipse.fx.runtime.fswt;

public interface FCallback<T,R> {
	public R invoke(T value);
}
