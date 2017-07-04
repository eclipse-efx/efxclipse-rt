package org.eclipse.fx.code.editor.fx.e4.internal;

import java.util.Optional;

import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.model.application.ui.menu.MPopupMenu;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.fx.code.editor.fx.e4.EditorContextMenuService;
import org.eclipse.fx.code.editor.fx.services.EditorContextMenuProvider.Type;
import org.osgi.service.component.annotations.Component;

@Component(property="service.ranking:Integer=-1")
public class SnippetEditorContextMenuService implements EditorContextMenuService {

	@Override
	public MPopupMenu getContextMenu(EModelService modelService, MApplication application, MPart part, Type type) {
		Optional<MUIElement> menu = application.getSnippets().stream().filter(
				e -> e instanceof MPopupMenu && ("editor.contextmenu."+type).equals(e.getElementId()) ).findFirst();
		return (MPopupMenu) menu.map( e -> modelService.cloneElement(e, null)).orElse(null);
	}

}
