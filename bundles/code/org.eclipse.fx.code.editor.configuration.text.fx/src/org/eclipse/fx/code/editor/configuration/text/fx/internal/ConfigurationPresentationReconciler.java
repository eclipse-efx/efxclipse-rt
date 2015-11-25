package org.eclipse.fx.code.editor.configuration.text.fx.internal;

import javax.inject.Inject;

import org.eclipse.fx.code.editor.configuration.LanguageDef;
import org.eclipse.fx.code.editor.configuration.Partition;
import org.eclipse.fx.text.ui.presentation.PresentationReconciler;
import org.eclipse.fx.text.ui.rules.DefaultDamagerRepairer;

@SuppressWarnings("restriction")
public class ConfigurationPresentationReconciler extends PresentationReconciler {

	@Inject
	public ConfigurationPresentationReconciler(LanguageDef model) {
		for (Partition sc : model.getPartitionList()) {
			ConfigurationRuleScanner s = new ConfigurationRuleScanner(model, sc);
			DefaultDamagerRepairer dr = new DefaultDamagerRepairer(s);
			setDamager(dr, sc.getName());
			setRepairer(dr, sc.getName());
		}
	}
}
