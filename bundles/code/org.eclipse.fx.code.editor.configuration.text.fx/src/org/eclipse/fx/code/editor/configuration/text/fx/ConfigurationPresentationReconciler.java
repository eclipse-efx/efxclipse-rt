package org.eclipse.fx.code.editor.configuration.text.fx;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.eclipse.fx.code.editor.Input;
import org.eclipse.fx.code.editor.InputContext;
import org.eclipse.fx.code.editor.configuration.LanguageDef;
import org.eclipse.fx.code.editor.configuration.Partition;
import org.eclipse.fx.code.editor.configuration.text.ConfigurationConditionDataProvider;
import org.eclipse.fx.code.editor.configuration.text.Util;
import org.eclipse.fx.code.editor.configuration.text.fx.internal.ConfigurationRuleScanner;
import org.eclipse.fx.core.NamedValue;
import org.eclipse.fx.core.di.Service;
import org.eclipse.fx.text.ui.presentation.PresentationReconciler;
import org.eclipse.fx.text.ui.rules.DefaultDamagerRepairer;

@SuppressWarnings("restriction")
public class ConfigurationPresentationReconciler extends PresentationReconciler {

	@Inject
	public ConfigurationPresentationReconciler(LanguageDef model, InputContext context, Input<?> input, @Service List<ConfigurationConditionDataProvider> providers) {
		Map<String, NamedValue<Object>> values = Util.createNamedValueList(context, input, providers);
		for (Partition sc : model.getPartitionList()) {
			ConfigurationRuleScanner s = new ConfigurationRuleScanner(model, sc, values);
			DefaultDamagerRepairer dr = new DefaultDamagerRepairer(s);
			setDamager(dr, sc.getName());
			setRepairer(dr, sc.getName());
		}
	}
}
