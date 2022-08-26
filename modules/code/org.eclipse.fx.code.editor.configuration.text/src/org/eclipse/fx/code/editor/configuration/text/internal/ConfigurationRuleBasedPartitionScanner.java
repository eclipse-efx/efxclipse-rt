/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
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
package org.eclipse.fx.code.editor.configuration.text.internal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.eclipse.fx.code.editor.configuration.Partition;
import org.eclipse.fx.code.editor.configuration.PartitionRule;
import org.eclipse.fx.code.editor.configuration.PartitionRule_DynamicEnd;
import org.eclipse.fx.code.editor.configuration.PartitionRule_JavaScript;
import org.eclipse.fx.code.editor.configuration.PartitionRule_MultiLine;
import org.eclipse.fx.code.editor.configuration.PartitionRule_SingleLine;
import org.eclipse.fx.code.editor.configuration.text.Util;
import org.eclipse.fx.core.NamedValue;
import org.eclipse.fx.text.rules.DynamicEndRule;
import org.eclipse.jface.text.rules.IPredicateRule;
import org.eclipse.jface.text.rules.MultiLineRule;
import org.eclipse.jface.text.rules.RuleBasedPartitionScanner;
import org.eclipse.jface.text.rules.SingleLineRule;
import org.eclipse.jface.text.rules.Token;

@SuppressWarnings("restriction")
public class ConfigurationRuleBasedPartitionScanner extends RuleBasedPartitionScanner {
	public ConfigurationRuleBasedPartitionScanner(List<Partition> paritioner, Map<String,NamedValue<Object>> values) {
		List<IPredicateRule> pr = new ArrayList<>();

		for( Partition p : paritioner ) {
			for( PartitionRule r : p.getRuleList() ) {
				if( Util.checkCondition(r.getCondition(), values) ) {
					if( r instanceof PartitionRule_SingleLine ) {
						PartitionRule_SingleLine sr = (PartitionRule_SingleLine) r;
						String endSeq = sr.getEndSeq();
						String escapeSeq = sr.getEscapedBy();
						pr.add( (IPredicateRule) Util.wrap(r.getCheck(),new SingleLineRule(sr.getStartSeq(), endSeq, new Token(p.getName()), escapeSeq != null ? escapeSeq.charAt(0) : 0, true)));
					} else if( r instanceof PartitionRule_MultiLine ) {
						PartitionRule_MultiLine mr = (PartitionRule_MultiLine) r;
						String endSeq = mr.getEndSeq();
						String escapeSeq = mr.getEscapedBy();
						pr.add( (IPredicateRule) Util.wrap(r.getCheck(), new MultiLineRule(mr.getStartSeq(), endSeq, new Token(p.getName()), escapeSeq != null ? escapeSeq.charAt(0) : 0, true)));
					} else if( r instanceof PartitionRule_JavaScript ) {
						PartitionRule_JavaScript jr = (PartitionRule_JavaScript) r;

						try {
							ScriptEngineManager engineManager = new ScriptEngineManager();
							ScriptEngine engine = engineManager.getEngineByName("nashorn");
							pr.add( (IPredicateRule)Util.wrap(jr.getCheck(),(IPredicateRule) engine.eval(jr.getScript())));
						} catch (ScriptException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} else if( r instanceof PartitionRule_DynamicEnd ) {
						PartitionRule_DynamicEnd pde = (PartitionRule_DynamicEnd) r;
						pr.add((IPredicateRule)Util.wrap(r.getCheck(), new DynamicEndRule(new Token(p.getName()), pde.getBeginPrefix(), Pattern.compile(pde.getBeginMatch()), pde.getBeginSuffix(), pde.getEndTemplate())));
					}
				}
			}
		}
		setPredicateRules(pr.toArray(new IPredicateRule[0]));
	}
}