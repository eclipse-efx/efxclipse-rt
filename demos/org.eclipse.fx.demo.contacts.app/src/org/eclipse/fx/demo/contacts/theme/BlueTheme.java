package org.eclipse.fx.demo.contacts.theme;

import org.eclipse.fx.ui.theme.AbstractTheme;

public class BlueTheme extends AbstractTheme {
	public BlueTheme() {
        super("blue", "Blue Theme", BlueTheme.class.getClassLoader().getResource("css/blue.css"));
    }
}
