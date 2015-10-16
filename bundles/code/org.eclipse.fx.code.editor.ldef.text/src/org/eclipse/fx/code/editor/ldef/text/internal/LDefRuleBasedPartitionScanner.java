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
import org.eclipse.fx.code.editor.ldef.text.Util;
import org.eclipse.jface.text.rules.IPredicateRule;
import org.eclipse.jface.text.rules.MultiLineRule;
import org.eclipse.jface.text.rules.RuleBasedPartitionScanner;
import org.eclipse.jface.text.rules.SingleLineRule;
import org.eclipse.jface.text.rules.Token;

@SuppressWarnings("restriction")
public class LDefRuleBasedPartitionScanner extends RuleBasedPartitionScanner {
	public LDefRuleBasedPartitionScanner(Partitioner_Rule paritioner) {
		IPredicateRule[] pr = new IPredicateRule[paritioner.getRuleList().size()];
		int i = 0;

		for( Partition_Rule r : paritioner.getRuleList() ) {
			if( r instanceof Partition_SingleLineRule ) {
				Partition_SingleLineRule sr = (Partition_SingleLineRule) r;
				String endSeq = sr.getEndSeq();
				String escapeSeq = sr.getEscapeSeq();
				pr[i] = new SingleLineRule(sr.getStartSeq(), endSeq, new Token(sr.getParition().getName()), escapeSeq != null ? escapeSeq.charAt(0) : 0, endSeq == null || endSeq.isEmpty());
			} else if( r instanceof Partition_MultiLineRule ) {
				Partition_MultiLineRule mr = (Partition_MultiLineRule) r;
				String endSeq = mr.getEndSeq();
				String escapeSeq = mr.getEscapeSeq();
				pr[i] = new MultiLineRule(mr.getStartSeq(), endSeq, new Token(mr.getParition().getName()), escapeSeq != null ? escapeSeq.charAt(0) : 0, endSeq == null || endSeq.isEmpty());
			}

			pr[i] = (IPredicateRule) Util.wrap(r.getCheck(),pr[i]);

			i++;
		}
		setPredicateRules(pr);
	}
}
