package org.eclipse.fx.code.editor.ldef.langs.themes;

import java.net.MalformedURLException;
import java.net.URL;

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
		ObservableList<@NonNull URL> stylesheets = FXCollections.emptyObservableList();

		try {
			stylesheets = FXCollections.observableArrayList(
					  new URL("platform:/plugin/org.eclipse.fx.code.editor.langs/org/eclipse/fx/code/editor/ldef/langs/dart/highlight.css")
					, new URL("platform:/plugin/org.eclipse.fx.code.editor.langs/org/eclipse/fx/code/editor/ldef/langs/js/highlight.css")
					, new URL("platform:/plugin/org.eclipse.fx.code.editor.langs/org/eclipse/fx/code/editor/ldef/langs/java/highlight.css")
					, new URL("platform:/plugin/org.eclipse.fx.code.editor.langs/org/eclipse/fx/code/editor/ldef/langs/xml/highlight.css")
					, new URL("platform:/plugin/org.eclipse.fx.code.editor.langs/org/eclipse/fx/code/editor/ldef/langs/go/highlight.css")
					, new URL("platform:/plugin/org.eclipse.fx.code.editor.langs/org/eclipse/fx/code/editor/ldef/langs/rust/highlight.css")
					, new URL("platform:/plugin/org.eclipse.fx.code.editor.langs/org/eclipse/fx/code/editor/ldef/langs/swift/highlight.css")
					, new URL("platform:/plugin/org.eclipse.fx.code.editor.langs/org/eclipse/fx/code/editor/ldef/langs/groovy/highlight.css")
					, new URL("platform:/plugin/org.eclipse.fx.code.editor.langs/org/eclipse/fx/code/editor/ldef/langs/python/highlight.css")
					, new URL("platform:/plugin/org.eclipse.fx.code.editor.langs/org/eclipse/fx/code/editor/ldef/langs/ceylon/highlight.css")
					, new URL("platform:/plugin/org.eclipse.fx.code.editor.langs/org/eclipse/fx/code/editor/ldef/langs/kotlin/highlight.css")
					, new URL("platform:/plugin/org.eclipse.fx.code.editor.langs/org/eclipse/fx/code/editor/ldef/langs/php/highlight.css")
					, new URL("platform:/plugin/org.eclipse.fx.code.editor.langs/org/eclipse/fx/code/editor/ldef/langs/asciidoc/highlight.css")
					, new URL("platform:/plugin/org.eclipse.fx.code.editor.langs/org/eclipse/fx/code/editor/ldef/langs/lua/highlight.css")
			);
		} catch (MalformedURLException e) {
		}

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