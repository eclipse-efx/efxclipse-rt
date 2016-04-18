package org.eclipse.fx.code.editor.fx.e4.internal;

import javax.inject.Inject;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IContextFunction;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.services.EMenuService;
import org.eclipse.fx.code.editor.e4.InputBasedContextFunction;
import org.eclipse.fx.code.editor.fx.services.EditorContextMenuProvider;
import org.eclipse.fx.code.editor.fx.services.EditorContextMenuProviderTypeProvider;
import org.osgi.service.component.annotations.Component;

import javafx.scene.control.Control;

@SuppressWarnings("restriction")
@Component(service=IContextFunction.class,property="service.context.key:String=org.eclipse.fx.code.editor.fx.services.EditorContextMenuProvider")
public class EditorContextMenuProviderTypeProviderContextFunction extends InputBasedContextFunction<EditorContextMenuProvider, EditorContextMenuProviderTypeProvider> {

	@Override
	protected EditorContextMenuProvider createDefault(IEclipseContext context) {
		return ContextInjectionFactory.make(ModelEditorContextMenuProvider.class, context);
	}

	static class ModelEditorContextMenuProvider implements EditorContextMenuProvider {
		private final EMenuService menuService;

		@Inject
		public ModelEditorContextMenuProvider(EMenuService menuService) {
			this.menuService = menuService;
		}

		@Override
		public void attacheMenu(Control styledText, Type type) {
			menuService.registerContextMenu(styledText, "editor.contextmenu."+type);
		}
	}
}
