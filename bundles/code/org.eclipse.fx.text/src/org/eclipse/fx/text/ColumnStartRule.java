package org.eclipse.fx.text;

import java.util.function.IntPredicate;

import org.eclipse.jface.text.rules.ICharacterScanner;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;

public class ColumnStartRule implements IRule {
	private final IRule rule;
	private final IntPredicate columnCheck;

	public ColumnStartRule(IRule rule, IntPredicate columnCheck) {
		this.rule = rule;
		this.columnCheck = columnCheck;
	}

	@Override
	public IToken evaluate(ICharacterScanner scanner) {
		if( columnCheck.test(scanner.getColumn()) ) {
			return rule.evaluate(scanner);
		}
		return null;
	}

}
