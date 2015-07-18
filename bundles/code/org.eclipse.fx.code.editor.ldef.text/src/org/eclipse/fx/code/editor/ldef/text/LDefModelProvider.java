package org.eclipse.fx.code.editor.ldef.text;

import org.eclipse.fx.code.editor.Input;
import org.eclipse.fx.code.editor.ldef.lDef.LanguageDef;

public interface LDefModelProvider {
	public boolean applies(Input<?> input);
	public LanguageDef getModel(Input<?> input);
}
