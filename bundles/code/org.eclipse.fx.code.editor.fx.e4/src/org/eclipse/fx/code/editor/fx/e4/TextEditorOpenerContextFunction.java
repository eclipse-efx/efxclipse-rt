package org.eclipse.fx.code.editor.fx.e4;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import org.eclipse.e4.core.contexts.ContextFunction;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IContextFunction;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.MElementContainer;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.model.application.ui.basic.MWindow;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.fx.code.editor.Constants;
import org.eclipse.fx.code.editor.services.FileIconProvider;
import org.eclipse.fx.code.editor.services.TextEditorOpener;
import org.eclipse.fx.core.URI;
import org.eclipse.fx.core.di.Service;
import org.osgi.service.component.annotations.Component;

@Component(service=IContextFunction.class,property={"service.context.key=org.eclipse.fx.code.editor.services.TextEditorOpener"})
public class TextEditorOpenerContextFunction extends ContextFunction {
	@Override
	public Object compute(IEclipseContext context) {
		return ContextInjectionFactory.make(TextEditorOpenHelper.class, context);
	}

	public static class TextEditorOpenHelper implements TextEditorOpener {
		@Inject
		MWindow window;

		@Inject
		MApplication application;

		@Inject
		EModelService modelService;

		@Inject
		@Service
		List<FileIconProvider> fileIconProvider;

		@SuppressWarnings({ "unchecked", "rawtypes" })
		@Override
		public void openEditor(String uri) {
			List<MPart> list = modelService.findElements(application, MPart.class, EModelService.ANYWHERE, (p) -> {
				return uri.equals(p.getPersistedState().get(Constants.DOCUMENT_URL));
			});

			MPart part = null;
			if( list.isEmpty() ) {
				List<MElementContainer> elements = modelService.findElements(window, null, MElementContainer.class, Collections.singletonList(Constants.EDITOR_CONTAINER_TAG));
				if( ! elements.isEmpty() ) {
					MElementContainer<MPart> container = elements.get(0);

					part = modelService.createModelElement(MPart.class);
					part.setCloseable(true);
					part.setLabel(URI.create(uri).lastSegment());
					part.setContributionURI("bundleclass://org.eclipse.fx.code.editor.fx/org.eclipse.fx.code.editor.fx.TextEditor");
					String iconUri = fileIconProvider
							.stream()
							.filter( f -> f.test(uri))
							.findFirst()
							.map( f -> f.getFileIconUri(uri))
							.orElse("platform:/plugin/org.eclipse.fx.code.editor.fx.e4/icons/file_16.png");
					part.setIconURI(iconUri);
					part.getPersistedState().put(Constants.DOCUMENT_URL, uri);
					part.getTags().add("removeOnHide");
					container.getChildren().add(part);
				}
			} else {
				part = list.get(0);
			}

			IEclipseContext context = modelService.getContainingContext(part);
			if( context != null ) {
				EPartService partService = context.get(EPartService.class);
				partService.activate(part);
			}
		}
	}
}
