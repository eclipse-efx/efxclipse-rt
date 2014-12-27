package org.eclipse.fx.code.compensator.app;

import org.eclipse.fx.ui.theme.AbstractTheme;

public class DarkTheme extends AbstractTheme {

	public DarkTheme() {
		super("dark", "Dark theme", DarkTheme.class.getClassLoader().getResource("css/dark-default.css"));
	}

}
