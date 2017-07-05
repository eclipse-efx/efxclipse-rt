package org.eclipse.fx.code.editor.fx.themes;

import java.net.URL;

import org.eclipse.fx.ui.services.theme.Stylesheet;
import org.eclipse.fx.ui.services.theme.Theme;


public abstract class EditorStylesheet implements Stylesheet {
	@Override
	public boolean appliesToTheme(Theme t) {
		return true;
	}

	@Override
	public URL getURL(Theme t) {
		URL url = null;
		if( "dark".equals(t.getId()) || "theme.dark".equals(t.getId()) ) {
			url = getClass().getClassLoader().getResource("css/dark-highlight.css");
		} else {
			url = getClass().getClassLoader().getResource("css/highlight.css");
		}
		return url;
	}
}
