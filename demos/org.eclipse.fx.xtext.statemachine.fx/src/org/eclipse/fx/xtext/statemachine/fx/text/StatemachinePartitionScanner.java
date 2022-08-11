/*******************************************************************************
 * Copyright (c) 2022 BestSolution.at and others.
 *  
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *  
 * SPDX-License-Identifier: EPL-2.0
 *  
 * Contributors:
 *     BestSolution.at - initial API and implementation
 *******************************************************************************/
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
