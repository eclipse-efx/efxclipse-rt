package org.eclipse.fx.ui.controls.image;

public interface FontIcon {
	
	char getIconCode();
	String getIconName();
	
	
	public static FontIcon create(final char iconCode) {
		return new FontIcon() {
			@Override
			public char getIconCode() {
				return iconCode;
			}
			
			@Override
			public String getIconName() {
				return null;
			}
		};
	}
	
	public static FontIcon create(final String iconName) {
		return new FontIcon() {
			@Override
			public char getIconCode() {
				return '0';
			}
			
			@Override
			public String getIconName() {
				return iconName;
			}
		};
	}
}
