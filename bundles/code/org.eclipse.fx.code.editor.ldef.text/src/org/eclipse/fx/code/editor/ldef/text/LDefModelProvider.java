package org.eclipse.fx.code.editor.ldef.text;

import org.eclipse.fx.code.editor.Input;
import org.eclipse.fx.code.editor.ldef.lDef.LDef;

public interface LDefModelProvider {
	public boolean applies(Input<?> input);
	public LDef getModel(Input<?> input);
}
