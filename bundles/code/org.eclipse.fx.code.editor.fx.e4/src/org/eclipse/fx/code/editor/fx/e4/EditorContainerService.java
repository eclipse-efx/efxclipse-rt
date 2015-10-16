package org.eclipse.fx.code.editor.fx.e4;

import org.eclipse.e4.ui.model.application.ui.MElementContainer;
import org.eclipse.e4.ui.model.application.ui.MUIElement;

public interface EditorContainerService {
	public MElementContainer<MUIElement> getContainer();
}
