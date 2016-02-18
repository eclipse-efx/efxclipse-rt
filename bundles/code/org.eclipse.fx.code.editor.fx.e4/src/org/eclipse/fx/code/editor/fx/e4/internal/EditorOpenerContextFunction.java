/*******************************************************************************
* Copyright (c) 2015 BestSolution.at and others.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
* 	Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
*******************************************************************************/
package org.eclipse.fx.code.editor.fx.e4.internal;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IContextFunction;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.MElementContainer;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.fx.code.editor.Constants;
import org.eclipse.fx.code.editor.fx.e4.EditorClassURLProvider;
import org.eclipse.fx.code.editor.fx.e4.EditorContainerService;
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

@SuppressWarnings("restriction")
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
		public boolean openEditor(String uri) {
			EditorOpener opener = objectRegistry.getRankedElements()
				.stream()
				.filter( e -> e.test(uri))
				.map( e -> (EditorOpener)ContextInjectionFactory.make(e.getType(uri), context))
				.filter( e -> e.test(uri))
				.findFirst()
				.orElseGet( () -> (EditorOpener)ContextInjectionFactory.make(DefaultEditorOpener.class, context));
			boolean success = opener.openEditor(uri);

			if( ! success ) {
				success = ContextInjectionFactory.make(DefaultEditorOpener.class, context).openEditor(uri);
			}

			return success;
		}

		@Override
		public boolean test(String uri) {
			return true;
		}
	}

	public static class DefaultEditorOpener implements EditorOpener {

		@Inject
		MApplication application;

		@Inject
		EditorContainerService containerService;

		@Inject
		EModelService modelService;

		@Inject
		@Service
		List<FileIconProvider> fileIconProvider;

		@Inject
		@Service
		List<EditorClassURLProvider> editorUrlProvider;

		@Override
		public boolean openEditor(String uri) {
			List<MPart> list = modelService.findElements(application, MPart.class, EModelService.ANYWHERE, (p) -> {
				return uri.equals(p.getPersistedState().get(Constants.DOCUMENT_URL));
			});

			MPart part = null;
			if( list.isEmpty() ) {
				MElementContainer<MUIElement> container = containerService.getContainer();

				if( container != null ) {
					part = modelService.createModelElement(MPart.class);
					part.setCloseable(true);
					part.setLabel(URI.create(uri).lastSegment());
					String editorBundleURI = editorUrlProvider
						.stream()
						.filter( e -> e.test(uri)).findFirst()
						.map( e -> e.getBundleClassURI(uri))
						.orElse("bundleclass://org.eclipse.fx.code.editor.fx/org.eclipse.fx.code.editor.fx.TextEditor");
//						.orElse("bundleclass://at.bestsolution.set.fx/at.bestsolution.set.fx.editor.SetTextEditor");
					part.setContributionURI(editorBundleURI);
					part.setContributorURI("platform:/plugin/org.eclipse.fx.code.editor.fx.e4");
					String iconUri = fileIconProvider
							.stream()
							.filter( f -> f.test(uri))
							.findFirst()
							.map( f -> f.getFileIconUri(uri))
							.orElse("platform:/plugin/org.eclipse.fx.code.editor.fx.e4/icons/file_16.png");
					part.setIconURI(iconUri);
					part.getPersistedState().put(Constants.DOCUMENT_URL, uri);
					part.getTags().add(EPartService.REMOVE_ON_HIDE_TAG);
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

		@Override
		public boolean test(String uri) {
			return true;
		}
	}
}
