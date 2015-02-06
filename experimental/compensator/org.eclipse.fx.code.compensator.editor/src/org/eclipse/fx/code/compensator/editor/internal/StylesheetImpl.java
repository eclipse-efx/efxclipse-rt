package org.eclipse.fx.code.compensator.editor.internal;

import java.net.URL;

import org.eclipse.fx.code.compensator.editor.spi.EditorStylesheet;
import org.eclipse.fx.ui.services.theme.Theme;

public class StylesheetImpl extends EditorStylesheet {
	@Override
	public URL getURL(Theme t) {
		URL url = super.getURL(t);
		return url;
	}
}
