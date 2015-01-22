package org.eclipse.fx.code.compensator.editor.services;

import org.eclipse.fx.code.compensator.editor.Input;

public interface ContentTypeDetector {
	public String getContentType(Input<?> input);
}
