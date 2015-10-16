package org.eclipse.fx.code.editor.fx.e4.internal;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import org.eclipse.e4.core.contexts.ContextFunction;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IContextFunction;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.MApplicationElement;
import org.eclipse.e4.ui.model.application.ui.MElementContainer;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.advanced.MPerspective;
import org.eclipse.e4.ui.model.application.ui.basic.MWindow;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.fx.code.editor.Constants;
import org.eclipse.fx.code.editor.fx.e4.EditorContainerService;
import org.osgi.service.component.annotations.Component;

@Component(service=IContextFunction.class,property="service.context.key:String=org.eclipse.fx.code.editor.fx.e4.EditorContainerService")
public class EditorContainerServiceContextFunction extends ContextFunction {

	@Override
	public Object compute(IEclipseContext context) {
		return ContextInjectionFactory.make(EditorContainerServiceImpl.class, context);
	}

	public static class EditorContainerServiceImpl implements EditorContainerService {
		@Inject
		MWindow window;

		@Inject
		MApplication application;

		@Inject
		@Optional
		MPerspective perspective;

		@Inject
		EModelService modelService;

		@Override
		public MElementContainer<MUIElement> getContainer() {
			MUIElement searchRoot = perspective == null ? window : perspective;
			List<MElementContainer> elements = modelService.findElements(searchRoot, null, MElementContainer.class, Collections.singletonList(Constants.EDITOR_CONTAINER_TAG));
			if( elements == null || elements.isEmpty() ) {
				return null;
			}
			return elements.get(0);
		}

	}
}
