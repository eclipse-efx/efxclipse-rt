package org.eclipse.fx.code.editor.fx.e4;

import java.util.function.Predicate;

public interface EditorClassURLProvider extends Predicate<String> {
	public String getBundleClassURI(String uri);
}
