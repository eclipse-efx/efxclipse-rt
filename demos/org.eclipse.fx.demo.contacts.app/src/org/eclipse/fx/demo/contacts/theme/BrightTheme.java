package org.eclipse.fx.demo.contacts.theme;

import org.eclipse.fx.ui.theme.AbstractTheme;

public class BrightTheme extends AbstractTheme {
	public BrightTheme() {
        super("bright", "Bright Theme", BrightTheme.class.getClassLoader().getResource("css/bright.css"));
    }
}
