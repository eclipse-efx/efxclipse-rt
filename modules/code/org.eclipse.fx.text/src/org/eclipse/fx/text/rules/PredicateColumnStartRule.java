/*******************************************************************************
 * Copyright (c) 2016 BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
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
