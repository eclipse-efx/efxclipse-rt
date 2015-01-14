package org.eclipse.fx.code.compensator.nashorn.internal;

import java.net.URL;

import org.eclipse.fx.ui.services.theme.Stylesheet;
import org.eclipse.fx.ui.services.theme.Theme;

public class JSStylesheet implements Stylesheet {

	@Override
	public boolean appliesToTheme(Theme t) {
		return true;
	}

	@Override
	public URL getURL(Theme t) {
		URL url = getClass().getClassLoader().getResource("css/"+t.getId()+".css");
		if( url == null ) {
			url = getClass().getClassLoader().getResource("css/default.css");
		}
		return url;
	}

}
