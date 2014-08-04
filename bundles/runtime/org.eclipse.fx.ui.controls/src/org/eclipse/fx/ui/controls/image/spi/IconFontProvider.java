package org.eclipse.fx.ui.controls.image.spi;

public abstract class IconFontProvider {
	public abstract String getName();
	public abstract char map(String id);
}
