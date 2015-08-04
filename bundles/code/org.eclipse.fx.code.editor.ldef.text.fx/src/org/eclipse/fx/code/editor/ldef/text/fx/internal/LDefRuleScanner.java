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
package org.eclipse.fx.code.editor.ldef.text.fx.internal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import org.eclipse.fx.code.editor.ldef.lDef.Keyword;
import org.eclipse.fx.code.editor.ldef.lDef.LexicalPartitionHighlighting_Rule;
import org.eclipse.fx.code.editor.ldef.lDef.Scanner;
import org.eclipse.fx.code.editor.ldef.lDef.Scanner_CharacterRule;
import org.eclipse.fx.code.editor.ldef.lDef.Scanner_Keyword;
import org.eclipse.fx.code.editor.ldef.lDef.Scanner_MultiLineRule;
import org.eclipse.fx.code.editor.ldef.lDef.Scanner_PatternRule;
import org.eclipse.fx.code.editor.ldef.lDef.Scanner_SingleLineRule;
import org.eclipse.fx.text.RegexRule;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.CombinedWordRule;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IWhitespaceDetector;
import org.eclipse.jface.text.rules.MultiLineRule;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.SingleLineRule;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.rules.WhitespaceRule;
import org.eclipse.jface.text.source.CharacterRule;
import org.eclipse.jface.text.source.JavaLikeWordDetector;

public class LDefRuleScanner extends RuleBasedScanner {
	public LDefRuleScanner(LexicalPartitionHighlighting_Rule scanner) {
		Token defaultToken = null;
		IRule[] rules = new IRule[getRuleCount(scanner)];
		int i = 0;
		Map<Token,Scanner_Keyword> keyWordList = new HashMap<>();
		for( org.eclipse.fx.code.editor.ldef.lDef.Token st : scanner.getTokenList() ) {
			Token token = new Token(new TextAttribute("dart." + st.getName()));
			if( st.isDefault() ) {
				defaultToken = token;
				setDefaultReturnToken(token);
			}

			for (Scanner ru : st.getScannerList()) {
				if( ru instanceof Scanner_SingleLineRule ) {
					Scanner_SingleLineRule sru = (Scanner_SingleLineRule) ru;
					rules[i++] = new SingleLineRule(
							sru.getStartSeq(),
							sru.getEndSeq(),
							token,
							sru.getEscapeSeq() != null ? sru.getEscapeSeq().charAt(0) : 0,
							false);
				} else if( ru instanceof Scanner_MultiLineRule ) {
					Scanner_MultiLineRule sml = (Scanner_MultiLineRule) ru;
					rules[i++] = new MultiLineRule(
							sml.getStartSeq(),
							sml.getEndSeq(),
							token,
							sml.getEscapeSeq() != null ? sml.getEscapeSeq().charAt(0) : 0,
							false);
				} else if( ru instanceof Scanner_CharacterRule ) {
					Scanner_CharacterRule scr = (Scanner_CharacterRule) ru;
					char[] c = new char[scr.getCharacters().size()];
					for( int j = 0; j < c.length; j++ ) {
						c[j] = scr.getCharacters().get(0).charAt(0);
					}
					rules[i++] = new CharacterRule(token, c);
				} else if( ru instanceof Scanner_Keyword ) {
					keyWordList.put(token,(Scanner_Keyword) ru);
				} else if( ru instanceof Scanner_PatternRule ) {
					Scanner_PatternRule rr = (Scanner_PatternRule) ru;
					rules[i++] = new RegexRule(token, Pattern.compile(rr.getStartPattern()), Math.max(1,rr.getLength()),Pattern.compile(rr.getContentPattern()));
				}
			}
		}

		if( scanner.getWhitespace() != null ) {
			if( scanner.getWhitespace().isJavawhitespace() ) {
				rules[i++] = new WhitespaceRule(new IWhitespaceDetector() {

					@Override
					public boolean isWhitespace(char c) {
						return Character.isWhitespace(c);
					}
				});
			} else {
				rules[i++] = new WhitespaceRule(scanner.getWhitespace().getFileURI() != null ? new JSWSDectector() : new FixedCharacterWSDetector(scanner.getWhitespace().getCharacters()));
			}
		}


		if( ! keyWordList.isEmpty() ) {
			JavaLikeWordDetector wordDetector= new JavaLikeWordDetector();
			CombinedWordRule combinedWordRule= new CombinedWordRule(wordDetector, defaultToken);
			for( Entry<Token, Scanner_Keyword> kg : keyWordList.entrySet() ) {
				CombinedWordRule.WordMatcher wordRule= new CombinedWordRule.WordMatcher();
				for( Keyword k : kg.getValue().getKeywords() ) {
					wordRule.addWord(k.getName(), kg.getKey());
				}
				combinedWordRule.addWordMatcher(wordRule);
			}
			rules[rules.length-1] = combinedWordRule;
		}

		setRules(rules);
	}

	private static int getRuleCount(LexicalPartitionHighlighting_Rule scanner) {
		int rv = 0;
		boolean hasKeyGroup = false;
		for (org.eclipse.fx.code.editor.ldef.lDef.Token token : scanner.getTokenList()) {
			rv += token.getScannerList().stream().filter( s -> ! (s instanceof Scanner_Keyword)).count();
			if( token.getScannerList().stream().filter( s -> s instanceof Scanner_Keyword).count() > 0 ) {
				hasKeyGroup = true;
			}
		}

		if( hasKeyGroup ) {
			rv += 1;
		}

		if(scanner.getWhitespace() != null) {
			rv += 1;
		}

		return rv;
	}

	static class JSWSDectector implements IWhitespaceDetector {

		@Override
		public boolean isWhitespace(char c) {
			// TODO Auto-generated method stub
			return false;
		}

	}

	static class FixedCharacterWSDetector implements IWhitespaceDetector {
		private final char[] chars;

		public FixedCharacterWSDetector(List<String> list) {
			chars = new char[list.size()];
			int i = 0;
			for( String s : list ) {
				chars[i++] = s.charAt(0);
			}
		}

		@Override
		public boolean isWhitespace(char c) {
			for( char ch : chars ) {
				if( ch == c ) {
					return true;
				}
			}
			return false;
		}
	}
}
