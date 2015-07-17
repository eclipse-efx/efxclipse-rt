/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.code.editor.ldef.text.internal;

import org.eclipse.fx.code.editor.ldef.lDef.Partition_MultiLineRule;
import org.eclipse.fx.code.editor.ldef.lDef.Partition_Rule;
import org.eclipse.fx.code.editor.ldef.lDef.Partition_SingleLineRule;
import org.eclipse.fx.code.editor.ldef.lDef.Partitioner_Rule;
import org.eclipse.jface.text.rules.IPredicateRule;
import org.eclipse.jface.text.rules.MultiLineRule;
import org.eclipse.jface.text.rules.RuleBasedPartitionScanner;
import org.eclipse.jface.text.rules.SingleLineRule;
import org.eclipse.jface.text.rules.Token;

public class LDefRuleBasedPartitionScanner extends RuleBasedPartitionScanner {
	public LDefRuleBasedPartitionScanner(Partitioner_Rule paritioner) {
		IPredicateRule[] pr = new IPredicateRule[paritioner.getRuleList().size()];
		int i = 0;

		for( Partition_Rule r : paritioner.getRuleList() ) {
			if( r instanceof Partition_SingleLineRule ) {
				Partition_SingleLineRule sr = (Partition_SingleLineRule) r;
				pr[i] = new SingleLineRule(sr.getStartSeq(), sr.getEndSeq(), new Token(sr.getParition().getName()), sr.getEscapeSeq() != null ? sr.getEndSeq().charAt(0) : 0, false);
			} else if( r instanceof Partition_MultiLineRule ) {
				Partition_MultiLineRule mr = (Partition_MultiLineRule) r;
				pr[i] = new MultiLineRule(mr.getStartSeq(), mr.getEndSeq(), new Token(mr.getParition().getName()), mr.getEscapeSeq() != null ? mr.getEscapeSeq().charAt(0) : 0, false);
			}
			i++;
		}
		setPredicateRules(pr);
	}
}
