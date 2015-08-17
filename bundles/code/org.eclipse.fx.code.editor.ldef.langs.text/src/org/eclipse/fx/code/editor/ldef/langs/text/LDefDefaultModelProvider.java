package org.eclipse.fx.code.editor.ldef.langs.text;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.fx.code.editor.Input;
import org.eclipse.fx.code.editor.ldef.LDefStandaloneSetup;
import org.eclipse.fx.code.editor.ldef.lDef.LanguageDef;
import org.eclipse.fx.code.editor.ldef.lDef.Root;
import org.eclipse.fx.code.editor.ldef.text.LDefModelProvider;
import org.eclipse.fx.code.editor.services.URIProvider;
import org.osgi.service.component.annotations.Component;

@Component(service={LDefModelProvider.class,LDefDefaultModelProvider.class})
public class LDefDefaultModelProvider implements LDefModelProvider {
	private final Map<String,LanguageDef> definitionList = new HashMap<>();
	private ResourceSetImpl rs;

	public LDefDefaultModelProvider() {
		LDefStandaloneSetup.doSetup();
		rs = new ResourceSetImpl();

		register(URI.createURI("platform:/plugin/org.eclipse.fx.code.editor.ldef.langs/org/eclipse/fx/code/editor/ldef/langs/dart/dart.ldef"),"dart");
		register(URI.createURI("platform:/plugin/org.eclipse.fx.code.editor.ldef.langs/org/eclipse/fx/code/editor/ldef/langs/js/js.ldef"),"js");
		register(URI.createURI("platform:/plugin/org.eclipse.fx.code.editor.ldef.langs/org/eclipse/fx/code/editor/ldef/langs/java/java.ldef"),"java");
		register(URI.createURI("platform:/plugin/org.eclipse.fx.code.editor.ldef.langs/org/eclipse/fx/code/editor/ldef/langs/xml/xml.ldef"),"xml");
		register(URI.createURI("platform:/plugin/org.eclipse.fx.code.editor.ldef.langs/org/eclipse/fx/code/editor/ldef/langs/go/go.ldef"),"go");
		register(URI.createURI("platform:/plugin/org.eclipse.fx.code.editor.ldef.langs/org/eclipse/fx/code/editor/ldef/langs/rust/rust.ldef"),"rust");
		register(URI.createURI("platform:/plugin/org.eclipse.fx.code.editor.ldef.langs/org/eclipse/fx/code/editor/ldef/langs/swift/swift.ldef"),"swift");
		register(URI.createURI("platform:/plugin/org.eclipse.fx.code.editor.ldef.langs/org/eclipse/fx/code/editor/ldef/langs/groovy/groovy.ldef"),"groovy");
		register(URI.createURI("platform:/plugin/org.eclipse.fx.code.editor.ldef.langs/org/eclipse/fx/code/editor/ldef/langs/python/python.ldef"),"python");
	}

	private void register(URI uri, String fileSuffix) {
		Resource resource = rs.getResource(uri, true);
		definitionList.put(fileSuffix, ((Root) resource.getContents().get(0)).getLanguageDefinition());
	}

	@Override
	public boolean applies(Input<?> input) {
		if( input instanceof URIProvider ) {
			org.eclipse.fx.core.URI uri = ((URIProvider)input).getURI();
			String lastSegment = uri.lastSegment();
			int idx = lastSegment.lastIndexOf('.');
			if( idx != -1 ) {
				return definitionList.containsKey(lastSegment.substring(idx+1));
			}
		}
		return false;
	}

	@Override
	public LanguageDef getModel(Input<?> input) {
		if( input instanceof URIProvider ) {
			org.eclipse.fx.core.URI uri = ((URIProvider)input).getURI();
			String lastSegment = uri.lastSegment();
			int idx = lastSegment.lastIndexOf('.');
			if( idx != -1 ) {
				return getModelByExtension(lastSegment.substring(idx+1));
			}
		}
		return null;
	}

	public LanguageDef getModelByExtension(String extension) {
		return definitionList.get(extension);
	}
}
