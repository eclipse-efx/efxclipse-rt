/*******************************************************************************
 * Copyright (c) 2016 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.text.rules;

import java.util.function.IntPredicate;

import org.eclipse.jface.text.rules.ICharacterScanner;
import org.eclipse.jface.text.rules.IPredicateRule;
import org.eclipse.jface.text.rules.IToken;

@SuppressWarnings("restriction")
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
