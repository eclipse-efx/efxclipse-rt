package org.eclipse.fx.code.compensator.editor.services;

import org.eclipse.fx.core.URI;

public interface FileIconProvider {
	public boolean applies(String uri);
	public URI getIcon(String uri);
}
