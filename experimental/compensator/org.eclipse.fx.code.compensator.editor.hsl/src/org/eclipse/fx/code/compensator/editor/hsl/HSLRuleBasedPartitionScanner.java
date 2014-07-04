package org.eclipse.fx.code.compensator.editor.hsl;

import java.io.IOException;
import java.io.InputStreamReader;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.eclipse.fx.code.compensator.hsl.hSL.ParitionRule;
import org.eclipse.fx.code.compensator.hsl.hSL.PartitionJSRule;
import org.eclipse.fx.code.compensator.hsl.hSL.PartitionMultiLineRule;
import org.eclipse.fx.code.compensator.hsl.hSL.PartitionSingleLineRule;
import org.eclipse.fx.code.compensator.hsl.hSL.RulePartitioner;
import org.eclipse.jface.text.rules.IPredicateRule;
import org.eclipse.jface.text.rules.MultiLineRule;
import org.eclipse.jface.text.rules.RuleBasedPartitionScanner;
import org.eclipse.jface.text.rules.SingleLineRule;
import org.eclipse.jface.text.rules.Token;

public class HSLRuleBasedPartitionScanner extends RuleBasedPartitionScanner {
	public HSLRuleBasedPartitionScanner(ClassLoader cl, RulePartitioner paritioner) {
		IPredicateRule[] pr = new IPredicateRule[paritioner.getRules().size()];
		int i = 0;
		
		for( ParitionRule r : paritioner.getRules() ) {
			if( r instanceof PartitionSingleLineRule ) {
				PartitionSingleLineRule sr = (PartitionSingleLineRule) r;
				pr[i] = new SingleLineRule(sr.getStartSeq(), sr.getEndSeq(), new Token(sr.getParition().getName()), sr.getEscapeSeq() != null ? sr.getEndSeq().charAt(0) : 0, false);
			} else if( r instanceof PartitionMultiLineRule ) {
				PartitionMultiLineRule mr = (PartitionMultiLineRule) r;
				pr[i] = new MultiLineRule(mr.getStartSeq(), mr.getEndSeq(), new Token(mr.getParition().getName()), mr.getEscapeSeq() != null ? mr.getEscapeSeq().charAt(0) : 0, false);
			} else if( r instanceof PartitionJSRule ) {
				PartitionJSRule js = (PartitionJSRule) r;
				ScriptEngineManager mgr = new ScriptEngineManager(cl);
				ScriptEngine engine = mgr.getEngineByName("nashorn");
				try( InputStreamReader reader = new InputStreamReader(cl.getResourceAsStream(js.getFileURI())) ) {
					pr[i] = (IPredicateRule) engine.eval(reader);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ScriptException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			i++;
		}
		setPredicateRules(pr);
	}
}
