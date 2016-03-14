package org.eclipse.fx.code.editor.configuration.text;

import java.util.List;
import java.util.function.BiPredicate;

import org.eclipse.fx.code.editor.Input;
import org.eclipse.fx.code.editor.InputContext;
import org.eclipse.fx.core.NamedValue;

@SuppressWarnings("restriction")
public interface ConfigurationConditionDataProvider extends BiPredicate<InputContext, Input<?>> {
	public List<NamedValue<Object>> get(InputContext context, Input<?> input);
}
