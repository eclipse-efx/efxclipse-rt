package org.eclipse.fx.core.observable;

class StringValueObservable extends BaseValueObservable<String> implements ValueObservable.StringObservable {
	public StringValueObservable() {
		super(null);
	}

	public StringValueObservable(String value) {
		super(value);
	}

}
