package org.eclipse.fx.demo.contacts.theme;

import org.eclipse.fx.ui.theme.AbstractTheme;

public class DarkTheme extends AbstractTheme {
	public DarkTheme() {
        super("dark", "Dark Theme", DarkTheme.class.getClassLoader().getResource("css/dark.css"));
    }
}
