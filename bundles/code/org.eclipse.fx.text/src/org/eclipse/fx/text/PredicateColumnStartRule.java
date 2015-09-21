package org.eclipse.fx.text;

import java.util.function.IntPredicate;

import org.eclipse.jface.text.rules.ICharacterScanner;
import org.eclipse.jface.text.rules.IPredicateRule;
import org.eclipse.jface.text.rules.IToken;

public class PredicateColumnStartRule extends ColumnStartRule implements IPredicateRule {
	private final IPredicateRule rule;
	public PredicateColumnStartRule(IPredicateRule rule, IntPredicate columnCheck) {
		super(rule, columnCheck);
		this.rule = rule;
	}

	@Override
	public final IToken getSuccessToken() {
		return this.rule.getSuccessToken();
	}

	@Override
	public final IToken evaluate(ICharacterScanner scanner, boolean resume) {
		return this.rule.evaluate(scanner, resume);
	}

}
