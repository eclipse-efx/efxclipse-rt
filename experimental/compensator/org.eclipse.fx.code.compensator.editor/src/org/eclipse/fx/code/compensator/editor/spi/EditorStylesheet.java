package org.eclipse.fx.code.compensator.editor.spi;

import java.net.URL;

import org.eclipse.fx.ui.services.theme.Stylesheet;
import org.eclipse.fx.ui.services.theme.Theme;

public class EditorStylesheet implements Stylesheet {
	@Override
	public boolean appliesToTheme(Theme t) {
		return true;
	}

	@Override
	public URL getURL(Theme t) {
		if( "dark".equals(t.getId()) ) {
			return getClass().getClassLoader().getResource("css/dark-highlight.css");
		}
		return getClass().getClassLoader().getResource("css/highlight.css");
	}
}
