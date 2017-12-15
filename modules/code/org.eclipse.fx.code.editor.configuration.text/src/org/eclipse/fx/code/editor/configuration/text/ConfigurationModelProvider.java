package org.eclipse.fx.code.editor.configuration.text;

import org.eclipse.fx.code.editor.Input;
import org.eclipse.fx.code.editor.configuration.LanguageDef;

@SuppressWarnings("restriction")
public interface ConfigurationModelProvider  {
	public boolean applies(Input<?> input);
	public LanguageDef getModel(Input<?> input);
}
