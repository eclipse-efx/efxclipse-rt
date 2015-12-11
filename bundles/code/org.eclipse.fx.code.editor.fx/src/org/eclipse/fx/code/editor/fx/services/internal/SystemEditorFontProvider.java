package org.eclipse.fx.code.editor.fx.services.internal;

import org.eclipse.fx.code.editor.fx.services.EditorFontProvider;
import org.osgi.service.component.annotations.Component;

@Component
public class SystemEditorFontProvider implements EditorFontProvider {

	@Override
	public String getLabel() {
		return "Default";
	}

	@Override
	public String getName() {
		return "Courier";
	}
}
