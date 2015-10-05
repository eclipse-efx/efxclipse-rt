package org.eclipse.fx.code.editor.asciidoc.fx.e4;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.MElementContainer;
import org.eclipse.e4.ui.model.application.ui.basic.MCompositePart;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.model.application.ui.basic.MWindow;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.fx.code.editor.Constants;
import org.eclipse.fx.code.editor.asciidoc.HTMLConverter;
import org.eclipse.fx.code.editor.services.EditorOpener;
import org.eclipse.fx.code.editor.services.EditorOpenerTypeProvider;
import org.eclipse.fx.code.editor.services.FileIconProvider;
import org.eclipse.fx.core.URI;
import org.eclipse.fx.core.di.Service;
import org.osgi.service.component.annotations.Component;

@Component(property="service.ranking:Integer=1")
public class AsciiDoctorEditorOpenerTypeProvider implements EditorOpenerTypeProvider {

	@Override
	public Class<? extends EditorOpener> getType(String s) {
		return AsciiDocEditorOpener.class;
	}

	@Override
	public boolean test(String t) {
		return t.endsWith(".adoc");
	}

	static class AsciiDocEditorOpener implements EditorOpener {
		@Inject
		MWindow window;

		@Inject
		MApplication application;

		@Inject
		EModelService modelService;

		@Inject
		@Service
		List<FileIconProvider> fileIconProvider;

		@Inject
		@Optional
		HTMLConverter converter;

		@Override
		public boolean test(String uri) {
			return converter != null;
		}

		@Override
		public boolean openEditor(String uri) {
			if( converter == null ) {
				return false;
			}

			List<MCompositePart> list = modelService.findElements(application, MCompositePart.class, EModelService.ANYWHERE, (p) -> {
				return uri.equals(p.getPersistedState().get(Constants.DOCUMENT_URL));
			});

			MCompositePart part = null;
			if( list.isEmpty() ) {
				List<MElementContainer> elements = modelService.findElements(window, null, MElementContainer.class, Collections.singletonList(Constants.EDITOR_CONTAINER_TAG));
				if( ! elements.isEmpty() ) {
					MElementContainer<MPart> container = elements.get(0);

					part = modelService.createModelElement(MCompositePart.class);
					part.setHorizontal(true);
					part.getPersistedState().put(Constants.DOCUMENT_URL, uri);
					part.getTags().add("removeOnHide");
					part.setCloseable(true);
					String iconUri = fileIconProvider
							.stream()
							.filter( f -> f.test(uri))
							.findFirst()
							.map( f -> f.getFileIconUri(uri))
							.orElse("platform:/plugin/org.eclipse.fx.code.editor.fx.e4/icons/file_16.png");
					part.setIconURI(iconUri);
					part.setContributionURI("bundleclass://org.eclipse.fx.code.editor.asciidoc.fx.e4/org.eclipse.fx.code.editor.asciidoc.fx.e4.EditorDelegate");
					part.setLabel(URI.create(uri).lastSegment());


					MPart textEditor = modelService.createModelElement(MPart.class);
					textEditor.setContributionURI("bundleclass://org.eclipse.fx.code.editor.fx/org.eclipse.fx.code.editor.fx.TextEditor");
					part.getChildren().add(textEditor);

					MPart preview = modelService.createModelElement(MPart.class);
					preview.setContributionURI("bundleclass://org.eclipse.fx.code.editor.asciidoc.fx/org.eclipse.fx.code.editor.asciidoc.fx.AsciiDoctorPreviewer");
					part.getChildren().add(preview);

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

			return true;
		}

	}
}
