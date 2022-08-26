/*******************************************************************************
 * Copyright (c) 2022 BestSolution.at and others.
 *  
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *  
 * SPDX-License-Identifier: EPL-2.0
 *  
 * Contributors:
 *     BestSolution.at - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.code.editor.langs.contrib;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

import org.eclipse.fx.code.editor.Input;
import org.eclipse.fx.code.editor.configuration.EditorGModel;
import org.eclipse.fx.code.editor.configuration.LanguageDef;
import org.eclipse.fx.code.editor.configuration.text.ConfigurationModelProvider;
import org.eclipse.fx.code.editor.services.URIProvider;
import org.eclipse.fx.core.URLUtils;
import org.eclipse.fx.core.log.LoggerCreator;
import org.osgi.service.component.annotations.Component;

@SuppressWarnings("restriction")
@Component
public class LangsConfigurationModelProvider implements ConfigurationModelProvider {
	private final List<Function<Input<?>, URL>> urlList = new ArrayList<>();
	private final Map<URL,LanguageDef> definitionCache = new HashMap<>();

	static class SuffixFunction implements Function<Input<?>,URL> {
		private final String suffix;
		private final URL url;

		public SuffixFunction(String suffix, URL url) {
			this.suffix = suffix;
			this.url = url;
		}

		@Override
		public URL apply(Input<?> input) {
			if( input instanceof URIProvider ) {
				if( suffix.equals(suffix(input)) ) {
					return url;
				}
			}
			return null;
		}
	}

	public static String suffix(Input<?> input) {
		String uri = ((URIProvider) input).getURI();
		String[] parts = uri.split("/");
		String lastSegment = parts[parts.length-1];
		int idx = lastSegment.lastIndexOf('.');
		if( idx != -1) {
			return lastSegment.substring(idx+1);
		}
		return null;
	}

	public LangsConfigurationModelProvider() {


		prefix("adoc","platform:/plugin/org.eclipse.fx.code.editor.langs/org/eclipse/fx/code/editor/ldef/langs/adoc.json").ifPresent(urlList::add);
		prefix("ceylon","platform:/plugin/org.eclipse.fx.code.editor.langs/org/eclipse/fx/code/editor/ldef/langs/ceylon.json").ifPresent(urlList::add);
		prefix("dart","platform:/plugin/org.eclipse.fx.code.editor.langs/org/eclipse/fx/code/editor/ldef/langs/dart.json").ifPresent(urlList::add);
//			register(new URL("platform:/plugin/org.eclipse.fx.code.editor.langs/org/eclipse/fx/code/editor/ldef/langs/gls.json"),"gls");
		prefix("go","platform:/plugin/org.eclipse.fx.code.editor.langs/org/eclipse/fx/code/editor/ldef/langs/go.json").ifPresent(urlList::add);
		prefix("groovy","platform:/plugin/org.eclipse.fx.code.editor.langs/org/eclipse/fx/code/editor/ldef/langs/groovy.json").ifPresent(urlList::add);
		javaSupport().ifPresent(urlList::add);
		prefix("js","platform:/plugin/org.eclipse.fx.code.editor.langs/org/eclipse/fx/code/editor/ldef/langs/js.json").ifPresent(urlList::add);
		prefix("kotlin","platform:/plugin/org.eclipse.fx.code.editor.langs/org/eclipse/fx/code/editor/ldef/langs/kotlin.json").ifPresent(urlList::add);
		prefix("lua","platform:/plugin/org.eclipse.fx.code.editor.langs/org/eclipse/fx/code/editor/ldef/langs/lua.json").ifPresent(urlList::add);
		prefix("php","platform:/plugin/org.eclipse.fx.code.editor.langs/org/eclipse/fx/code/editor/ldef/langs/php.json").ifPresent(urlList::add);
		prefix("py","platform:/plugin/org.eclipse.fx.code.editor.langs/org/eclipse/fx/code/editor/ldef/langs/py.json").ifPresent(urlList::add);
		prefix("rust","platform:/plugin/org.eclipse.fx.code.editor.langs/org/eclipse/fx/code/editor/ldef/langs/rust.json").ifPresent(urlList::add);
		prefix("swift","platform:/plugin/org.eclipse.fx.code.editor.langs/org/eclipse/fx/code/editor/ldef/langs/swift.json").ifPresent(urlList::add);
		prefix("ts","platform:/plugin/org.eclipse.fx.code.editor.langs/org/eclipse/fx/code/editor/ldef/langs/ts.json").ifPresent(urlList::add);
		prefix("xml","platform:/plugin/org.eclipse.fx.code.editor.langs/org/eclipse/fx/code/editor/ldef/langs/xml.json").ifPresent(urlList::add);
		prefix("html","platform:/plugin/org.eclipse.fx.code.editor.langs/org/eclipse/fx/code/editor/ldef/langs/xml.json").ifPresent(urlList::add);
		prefix("sh","platform:/plugin/org.eclipse.fx.code.editor.langs/org/eclipse/fx/code/editor/ldef/langs/sh.json").ifPresent(urlList::add);
	}

	private static final Optional<Function<Input<?>, URL>> prefix(String prefix, String url) {
		return URLUtils.createUrl(url, true).map( u -> new SuffixFunction(prefix,u));
	}

	private static final Optional<Function<Input<?>, URL>> javaSupport() {
		Optional<URL> javaBase = URLUtils.createUrl("platform:/plugin/org.eclipse.fx.code.editor.langs/org/eclipse/fx/code/editor/ldef/langs/java.json", true);
		Optional<URL> moduleInfo = URLUtils.createUrl("platform:/plugin/org.eclipse.fx.code.editor.langs/org/eclipse/fx/code/editor/ldef/langs/jmod.json", true);
		if( ! javaBase.isPresent() || ! moduleInfo.isPresent() ) {
			return null;
		}
		return Optional.of(input -> {
			if( input instanceof URIProvider ) {
				if( "java".equals(suffix(input)) ) {
					String uri = ((URIProvider) input).getURI();
					String[] parts = uri.split("/");
					String lastSegment = parts[parts.length-1];
					if( "module-info.java".equals(lastSegment) ) {
						return moduleInfo.get();
					} else {
						return javaBase.get();
					}
				}
			}
			return null;
		});
	}

	@Override
	public boolean applies(Input<?> input) {
		return urlList.stream().map( e -> e.apply(input)).filter( e -> e != null).findFirst().isPresent();
	}

	@Override
	public LanguageDef getModel(Input<?> input) {
		return urlList.stream().map( e -> e.apply(input)).filter( e -> e != null).findFirst().map( this::getModelByExtension).orElse(null);
	}

	public LanguageDef getModelByExtension(URL url) {
		return definitionCache.computeIfAbsent(url, (e) -> {
			try( InputStream in = url.openStream();
					InputStreamReader r = new InputStreamReader(in) ) {
				return EditorGModel.create().createObject(r);
			} catch (Exception e1) {
				LoggerCreator.createLogger(LangsConfigurationModelProvider.class).error("Unable to load json file '"+url+"'", e1);
			}
			return null;
		});
	}
}
