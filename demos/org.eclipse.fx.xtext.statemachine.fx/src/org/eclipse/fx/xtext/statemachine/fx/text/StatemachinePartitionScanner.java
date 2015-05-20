package org.eclipse.fx.xtext.statemachine.fx.text;

import org.eclipse.jface.text.rules.IPredicateRule;
import org.eclipse.jface.text.rules.MultiLineRule;
import org.eclipse.jface.text.rules.RuleBasedPartitionScanner;
import org.eclipse.jface.text.rules.Token;

public class StatemachinePartitionScanner extends RuleBasedPartitionScanner {
	public StatemachinePartitionScanner() {
		IPredicateRule[] pr = new IPredicateRule[1];
		pr[0] = new MultiLineRule("/*", "*/", new Token(IStatemachinePartitions.MULTI_LINE_COMMENT), (char)0, false);
		
		setPredicateRules(pr);
	}
}
