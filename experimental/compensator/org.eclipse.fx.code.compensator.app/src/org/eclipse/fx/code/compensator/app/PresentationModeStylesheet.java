package org.eclipse.fx.code.compensator.app;

import java.net.URL;

import org.eclipse.fx.ui.services.theme.Stylesheet;
import org.eclipse.fx.ui.services.theme.Theme;
import org.eclipse.jdt.annotation.NonNull;

public class PresentationModeStylesheet implements Stylesheet {

	@Override
	public boolean appliesToTheme(Theme t) {
		return true;
	}

	@Override
	public @NonNull URL getURL(Theme t) {
		return getClass().getClassLoader().getResource("css/presentationMode.css");
	}

}
