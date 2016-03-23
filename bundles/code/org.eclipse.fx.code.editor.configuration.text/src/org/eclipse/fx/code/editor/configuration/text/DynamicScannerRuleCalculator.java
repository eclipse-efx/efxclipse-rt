package org.eclipse.fx.code.editor.configuration.text;

import java.util.List;

import org.eclipse.jface.text.rules.IRule;

@SuppressWarnings("restriction")
public interface DynamicScannerRuleCalculator {
	public List<IRule> getRule(String partitionId);
}
