package org.eclipse.fx.text.hover;

public enum DefaultHoverInfoType implements HoverInfoType {
	DOCUMENTATION,
	ERROR,
	WARNING,
	INFO;

	@Override
	public String getType() {
		return name();
	}

}
