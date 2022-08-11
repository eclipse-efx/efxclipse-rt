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
package org.eclipse.fx.code.editor.langs.themes;

import java.net.URL;

import org.eclipse.fx.core.URLUtils;
import org.eclipse.fx.ui.services.theme.MultiURLStylesheet;
import org.eclipse.fx.ui.services.theme.Theme;
import org.eclipse.jdt.annotation.NonNull;
import org.osgi.service.component.annotations.Component;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

@Component
public class DefaultEditorStylesheets implements MultiURLStylesheet {
	private ObservableList<@NonNull URL> stylesheets;

	public DefaultEditorStylesheets() {
		ObservableList<@NonNull URL> stylesheets = FXCollections.observableArrayList();

		URLUtils.createUrl("platform:/plugin/org.eclipse.fx.code.editor.langs/org/eclipse/fx/code/editor/ldef/langs/adoc.css", true).ifPresent(stylesheets::add);
		URLUtils.createUrl("platform:/plugin/org.eclipse.fx.code.editor.langs/org/eclipse/fx/code/editor/ldef/langs/ceylon.css", true).ifPresent(stylesheets::add);
		URLUtils.createUrl("platform:/plugin/org.eclipse.fx.code.editor.langs/org/eclipse/fx/code/editor/ldef/langs/dart.css", true).ifPresent(stylesheets::add);
		URLUtils.createUrl("platform:/plugin/org.eclipse.fx.code.editor.langs/org/eclipse/fx/code/editor/ldef/langs/go.css", true).ifPresent(stylesheets::add);
		URLUtils.createUrl("platform:/plugin/org.eclipse.fx.code.editor.langs/org/eclipse/fx/code/editor/ldef/langs/groovy.css", true).ifPresent(stylesheets::add);
		URLUtils.createUrl("platform:/plugin/org.eclipse.fx.code.editor.langs/org/eclipse/fx/code/editor/ldef/langs/java.css", true).ifPresent(stylesheets::add);
		URLUtils.createUrl("platform:/plugin/org.eclipse.fx.code.editor.langs/org/eclipse/fx/code/editor/ldef/langs/jmod.css", true).ifPresent(stylesheets::add);
		URLUtils.createUrl("platform:/plugin/org.eclipse.fx.code.editor.langs/org/eclipse/fx/code/editor/ldef/langs/js.css", true).ifPresent(stylesheets::add);
		URLUtils.createUrl("platform:/plugin/org.eclipse.fx.code.editor.langs/org/eclipse/fx/code/editor/ldef/langs/kotlin.css", true).ifPresent(stylesheets::add);
		URLUtils.createUrl("platform:/plugin/org.eclipse.fx.code.editor.langs/org/eclipse/fx/code/editor/ldef/langs/lua.css", true).ifPresent(stylesheets::add);
		URLUtils.createUrl("platform:/plugin/org.eclipse.fx.code.editor.langs/org/eclipse/fx/code/editor/ldef/langs/php.css", true).ifPresent(stylesheets::add);
		URLUtils.createUrl("platform:/plugin/org.eclipse.fx.code.editor.langs/org/eclipse/fx/code/editor/ldef/langs/py.css", true).ifPresent(stylesheets::add);
		URLUtils.createUrl("platform:/plugin/org.eclipse.fx.code.editor.langs/org/eclipse/fx/code/editor/ldef/langs/rust.css", true).ifPresent(stylesheets::add);
		URLUtils.createUrl("platform:/plugin/org.eclipse.fx.code.editor.langs/org/eclipse/fx/code/editor/ldef/langs/swift.css", true).ifPresent(stylesheets::add);
		URLUtils.createUrl("platform:/plugin/org.eclipse.fx.code.editor.langs/org/eclipse/fx/code/editor/ldef/langs/ts.css", true).ifPresent(stylesheets::add);
		URLUtils.createUrl("platform:/plugin/org.eclipse.fx.code.editor.langs/org/eclipse/fx/code/editor/ldef/langs/xml.css", true).ifPresent(stylesheets::add);
		URLUtils.createUrl("platform:/plugin/org.eclipse.fx.code.editor.langs/org/eclipse/fx/code/editor/ldef/langs/sh.css", true).ifPresent(stylesheets::add);
		this.stylesheets = stylesheets;
	}

	@Override
	public boolean appliesToTheme(Theme t) {
		return true;
	}

	@Override
	public ObservableList<@NonNull URL> getURL(Theme t) {
		return stylesheets;
	}
}