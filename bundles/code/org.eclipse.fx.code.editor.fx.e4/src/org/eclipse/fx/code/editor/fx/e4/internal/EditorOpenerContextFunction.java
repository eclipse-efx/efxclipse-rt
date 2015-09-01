package org.eclipse.fx.code.editor.fx.e4.internal;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

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
import org.eclipse.fx.code.editor.services.EditorOpener;
import org.eclipse.fx.code.editor.services.EditorOpenerTypeProvider;
import org.eclipse.fx.code.editor.services.FileIconProvider;
import org.eclipse.fx.core.RankedObjectRegistry;
import org.eclipse.fx.core.URI;
import org.eclipse.fx.core.di.Service;
import org.eclipse.fx.core.di.context.ServiceContextFunction;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;

@Component(service=IContextFunction.class,property={"service.context.key=org.eclipse.fx.code.editor.services.EditorOpener"})
public class EditorOpenerContextFunction extends ServiceContextFunction<EditorOpenerTypeProvider> {

	@Reference(cardinality=ReferenceCardinality.MULTIPLE,policy=ReferencePolicy.DYNAMIC,policyOption=ReferencePolicyOption.GREEDY)
	@Override
	public void registerService(EditorOpenerTypeProvider service, Map<String, Object> properties) {
		super.registerService(service, properties);
	}

	@Override
	public void unregisterService(EditorOpenerTypeProvider service) {
		super.unregisterService(service);
	}

	@Override
	public Object compute(IEclipseContext context) {

		return new ProxyEditorOpener(context,registry);
	}

	public static class ProxyEditorOpener implements EditorOpener {
		private final IEclipseContext context;
		private final RankedObjectRegistry<EditorOpenerTypeProvider> objectRegistry;

		public ProxyEditorOpener(IEclipseContext context, RankedObjectRegistry<EditorOpenerTypeProvider> objectRegistry) {
			this.context = context;
			this.objectRegistry = objectRegistry;
		}

		@Override
		public void openEditor(String uri) {
			EditorOpener opener = objectRegistry.getRankedElements()
				.stream()
				.filter( e -> e.test(uri))
				.map( e -> (EditorOpener)ContextInjectionFactory.make(e.getType(uri), context))
				.findFirst()
				.orElseGet( () -> (EditorOpener)ContextInjectionFactory.make(DefaultEditorOpener.class, context));
			opener.openEditor(uri);
		}
	}

	public static class DefaultEditorOpener implements EditorOpener {
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
