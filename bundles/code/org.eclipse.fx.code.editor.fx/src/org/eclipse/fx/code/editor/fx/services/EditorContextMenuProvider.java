package org.eclipse.fx.code.editor.fx.services;

import javafx.scene.control.Control;

public interface EditorContextMenuProvider  {
	public enum Type {
		CONTENT
	}
	public void attacheMenu( Control styledText, Type type );
}
