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
package org.eclipse.fx.code.editor.configuration.text.internal;

import java.util.List;

import org.eclipse.fx.code.editor.configuration.Partition;
import org.eclipse.fx.code.editor.configuration.PartitionRule;
import org.eclipse.fx.code.editor.configuration.PartitionRule_MultiLine;
import org.eclipse.fx.code.editor.configuration.PartitionRule_SingleLine;
import org.eclipse.fx.code.editor.configuration.text.Util;
import org.eclipse.jface.text.rules.IPredicateRule;
import org.eclipse.jface.text.rules.MultiLineRule;
import org.eclipse.jface.text.rules.RuleBasedPartitionScanner;
import org.eclipse.jface.text.rules.SingleLineRule;
import org.eclipse.jface.text.rules.Token;

@SuppressWarnings("restriction")
public class ConfigurationRuleBasedPartitionScanner extends RuleBasedPartitionScanner {
	public ConfigurationRuleBasedPartitionScanner(List<Partition> paritioner) {
		IPredicateRule[] pr = new IPredicateRule[paritioner.stream().mapToInt( p -> p.getRuleList().size()).sum()];
		int i = 0;

		for( Partition p : paritioner ) {
			for( PartitionRule r : p.getRuleList() ) {
				if( r instanceof PartitionRule_SingleLine ) {
					PartitionRule_SingleLine sr = (PartitionRule_SingleLine) r;
					String endSeq = sr.getEndSeq();
					String escapeSeq = sr.getEscapedBy();
					pr[i] = new SingleLineRule(sr.getStartSeq(), endSeq, new Token(p.getName()), escapeSeq != null ? escapeSeq.charAt(0) : 0, endSeq == null || endSeq.isEmpty());
				} else if( r instanceof PartitionRule_MultiLine ) {
					PartitionRule_MultiLine mr = (PartitionRule_MultiLine) r;
					String endSeq = mr.getEndSeq();
					String escapeSeq = mr.getEscapedBy();
					pr[i] = new MultiLineRule(mr.getStartSeq(), endSeq, new Token(p.getName()), escapeSeq != null ? escapeSeq.charAt(0) : 0, endSeq == null || endSeq.isEmpty());
				}

				pr[i] = (IPredicateRule) Util.wrap(r.getCheck(),pr[i]);

				i++;
			}
		}
		setPredicateRules(pr);
	}
}
