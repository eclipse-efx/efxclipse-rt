package org.eclipse.fx.code.editor.services;

public interface EditorOpener {
	public boolean test(String uri);
	public boolean openEditor(String uri);
}
