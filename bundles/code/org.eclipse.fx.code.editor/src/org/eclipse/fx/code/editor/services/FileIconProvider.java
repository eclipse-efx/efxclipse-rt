package org.eclipse.fx.code.editor.services;

import java.util.function.Predicate;

public interface FileIconProvider extends Predicate<String> {
	public String getFileIconUri(String uri);
}
