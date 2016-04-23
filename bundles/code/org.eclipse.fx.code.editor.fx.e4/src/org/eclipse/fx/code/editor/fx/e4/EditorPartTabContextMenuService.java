package org.eclipse.fx.code.editor.fx.e4;

import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.model.application.ui.menu.MPopupMenu;
import org.eclipse.e4.ui.workbench.modeling.EModelService;

public interface EditorPartTabContextMenuService {
	public MPopupMenu getContextMenu(EModelService modelService, MApplication application, MPart part);
}
