package org.eclipse.fx.testcases.e4.theme;

import org.eclipse.fx.ui.theme.AbstractTheme;

public class DefaultTheme extends AbstractTheme {

	public DefaultTheme() {
		super("default.theme", "Default Theme", DefaultTheme.class.getClassLoader().getResource("css/default.css"));
	}
}
