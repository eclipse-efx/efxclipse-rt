package org.eclipse.fx.code.compensator.editor.services;

public interface FileIconProvider {
	public boolean applies(String uri);
	public String getIcon(String uri);
}
