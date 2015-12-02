package org.eclipse.fx.code.editor.langs.contrib;

import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.fx.code.editor.Input;
import org.eclipse.fx.code.editor.configuration.EditorGModel;
import org.eclipse.fx.code.editor.configuration.LanguageDef;
import org.eclipse.fx.code.editor.configuration.text.ConfigurationModelProvider;
import org.eclipse.fx.code.editor.services.URIProvider;
import org.eclipse.fx.core.log.LoggerCreator;
import org.osgi.service.component.annotations.Component;

@SuppressWarnings("restriction")
@Component
public class LangsConfigurationModelProvider implements ConfigurationModelProvider {
	private final Map<String,URL> definitionURI = new HashMap<>();
	private final Map<String,LanguageDef> definitionCache = new HashMap<>();

	public LangsConfigurationModelProvider() {
		try {
			register(new URL("platform:/plugin/org.eclipse.fx.code.editor.langs/org/eclipse/fx/code/editor/ldef/langs/adoc.json"),"adoc");
			register(new URL("platform:/plugin/org.eclipse.fx.code.editor.langs/org/eclipse/fx/code/editor/ldef/langs/ceylon.json"),"ceylon");
			register(new URL("platform:/plugin/org.eclipse.fx.code.editor.langs/org/eclipse/fx/code/editor/ldef/langs/dart.json"),"dart");
//			register(new URL("platform:/plugin/org.eclipse.fx.code.editor.langs/org/eclipse/fx/code/editor/ldef/langs/gls.json"),"gls");
			register(new URL("platform:/plugin/org.eclipse.fx.code.editor.langs/org/eclipse/fx/code/editor/ldef/langs/go.json"),"go");
			register(new URL("platform:/plugin/org.eclipse.fx.code.editor.langs/org/eclipse/fx/code/editor/ldef/langs/groovy.json"),"groovy");
			register(new URL("platform:/plugin/org.eclipse.fx.code.editor.langs/org/eclipse/fx/code/editor/ldef/langs/java.json"),"java");
			register(new URL("platform:/plugin/org.eclipse.fx.code.editor.langs/org/eclipse/fx/code/editor/ldef/langs/js.json"),"js");
			register(new URL("platform:/plugin/org.eclipse.fx.code.editor.langs/org/eclipse/fx/code/editor/ldef/langs/kotlin.json"),"kotlin");
			register(new URL("platform:/plugin/org.eclipse.fx.code.editor.langs/org/eclipse/fx/code/editor/ldef/langs/lua.json"),"lua");
			register(new URL("platform:/plugin/org.eclipse.fx.code.editor.langs/org/eclipse/fx/code/editor/ldef/langs/php.json"),"php");
			register(new URL("platform:/plugin/org.eclipse.fx.code.editor.langs/org/eclipse/fx/code/editor/ldef/langs/py.json"),"py");
			register(new URL("platform:/plugin/org.eclipse.fx.code.editor.langs/org/eclipse/fx/code/editor/ldef/langs/rust.json"),"rust");
			register(new URL("platform:/plugin/org.eclipse.fx.code.editor.langs/org/eclipse/fx/code/editor/ldef/langs/swift.json"),"swift");
			register(new URL("platform:/plugin/org.eclipse.fx.code.editor.langs/org/eclipse/fx/code/editor/ldef/langs/xml.json"),"xml");
		} catch(Throwable t) {
			LoggerCreator.createLogger(LangsConfigurationModelProvider.class).error("Invalid URL", t);
		}
	}

	private void register(URL uri, String fileSuffix) {
		definitionURI.put(fileSuffix, uri);
	}

	@Override
	public boolean applies(Input<?> input) {
		if( input instanceof URIProvider ) {
			String uri = ((URIProvider) input).getURI();
			String[] parts = uri.split("/");
			String lastSegment = parts[parts.length-1];
			int idx = lastSegment.lastIndexOf('.');
			if( idx != -1 ) {
				boolean rv = definitionURI.containsKey(lastSegment.substring(idx+1));
				return rv;
			}
		}
		return false;
	}

	@Override
	public LanguageDef getModel(Input<?> input) {
		if( input instanceof URIProvider ) {
			String uri = ((URIProvider) input).getURI();
			String[] parts = uri.split("/");
			String lastSegment = parts[parts.length-1];
			int idx = lastSegment.lastIndexOf('.');
			if( idx != -1 ) {
				return getModelByExtension(lastSegment.substring(idx+1));
			}
		}
		return null;
	}

	public LanguageDef getModelByExtension(String extension) {
		return definitionCache.computeIfAbsent(extension, (e) -> {
			try {
				return EditorGModel.create().createObject(new InputStreamReader(definitionURI.get(e).openStream()));
			} catch (Exception e1) {
				LoggerCreator.createLogger(LangsConfigurationModelProvider.class).error("Unable to load json file '"+definitionURI.get(e)+"'", e1);
			}
			return null;
		});
	}
}
