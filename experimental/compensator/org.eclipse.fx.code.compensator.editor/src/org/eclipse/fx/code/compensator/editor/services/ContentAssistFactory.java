package org.eclipse.fx.code.compensator.editor.services;

import org.eclipse.fx.code.compensator.editor.ContentAssist;
import org.eclipse.fx.code.compensator.editor.Input;

public interface ContentAssistFactory {
	public boolean applies(Input<?> input);
	public ContentAssist getContentAssist();
}
