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
package org.eclipse.fx.code.compensator.editor.hsl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

import org.eclipse.fx.code.compensator.editor.hsl.internal.JavaScriptHelper;
import org.eclipse.fx.code.compensator.hsl.hSL.FontType;
import org.eclipse.fx.code.compensator.hsl.hSL.Keyword;
import org.eclipse.fx.code.compensator.hsl.hSL.KeywordGroup;
import org.eclipse.fx.code.compensator.hsl.hSL.RGBColor;
import org.eclipse.fx.code.compensator.hsl.hSL.RuleDamager;
import org.eclipse.fx.code.compensator.hsl.hSL.ScannerCharacterRule;
import org.eclipse.fx.code.compensator.hsl.hSL.ScannerJSRule;
import org.eclipse.fx.code.compensator.hsl.hSL.ScannerMultiLineRule;
import org.eclipse.fx.code.compensator.hsl.hSL.ScannerRule;
import org.eclipse.fx.code.compensator.hsl.hSL.ScannerSingleLineRule;
import org.eclipse.fx.code.compensator.hsl.hSL.ScannerToken;
import org.eclipse.fx.code.compensator.hsl.hSL.ScannerWhitespaceRule;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.CombinedWordRule;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.IWhitespaceDetector;
import org.eclipse.jface.text.rules.MultiLineRule;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.SingleLineRule;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.rules.WhitespaceRule;
import org.eclipse.jface.text.source.CharacterRule;
import org.eclipse.jface.text.source.JavaLikeWordDetector;

public class HSLRuleScanner extends RuleBasedScanner {
	public HSLRuleScanner(RuleDamager scanner) {
		Token defaultToken = null;
		Map<String, IToken> tokenMap = new HashMap<String, IToken>();
		for( ScannerToken st : scanner.getTokens() ) {
			Token token = new Token(new TextAttribute(st.getName()));
//			if( "default_tagtoken".equals(st.getName()) ) {
//				token = new Token(new TextAttribute(st.getName(),Color.rgb(255, 0, 0)));
//			} else if( "xml_string".equals(st.getName()) ) {
//				token = new Token(new TextAttribute(st.getName(),Color.rgb(0, 255, 0)));
//			}
			if( st.isDefault() ) {
				defaultToken = token;
				setDefaultReturnToken(token);
			}
			tokenMap.put(st.getName(), token);
		}
		
		IRule[] rules = new IRule[scanner.getRules().size()+(!scanner.getKeywordGroups().isEmpty() ? 1 : 0)];
		
		int i = 0;
		for( ScannerRule ru : scanner.getRules() ) {
			if( ru instanceof ScannerSingleLineRule ) {
				ScannerSingleLineRule sru = (ScannerSingleLineRule) ru;
					rules[i] = new SingleLineRule(
							sru.getStartSeq(), 
							sru.getEndSeq(), 
							tokenMap.get(sru.getToken().getName()), 
							sru.getEscapeSeq() != null ? sru.getEscapeSeq().charAt(0) : 0, 
							false);					
			} else if( ru instanceof ScannerMultiLineRule ) {
				ScannerMultiLineRule sml = (ScannerMultiLineRule) ru;
				rules[i] = new MultiLineRule(
						sml.getStartSeq(), 
						sml.getEndSeq(), 
						tokenMap.get(sml.getToken().getName()), 
						sml.getEscapeSeq() != null ? sml.getEscapeSeq().charAt(0) : 0,
						false);
			} else if( ru instanceof ScannerWhitespaceRule ) {
				ScannerWhitespaceRule wru = (ScannerWhitespaceRule) ru;
				if( wru.isJavawhitespace() ) {
					rules[i] = new WhitespaceRule(new IWhitespaceDetector() {
						
						@Override
						public boolean isWhitespace(char c) {
							return Character.isWhitespace(c);
						}
					});
				} else {
					rules[i] = new WhitespaceRule(wru.getFileURI() != null ? new JSWSDectector() : new FixedCharacterWSDetector(wru.getCharacters()));	
				}
			} else if( ru instanceof ScannerCharacterRule ) {
				ScannerCharacterRule scr = (ScannerCharacterRule) ru;
				char[] c = new char[scr.getCharacters().size()];
				for( int j = 0; j < c.length; j++ ) {
					c[j] = scr.getCharacters().get(0).charAt(0);
				}
				rules[i] = new CharacterRule(tokenMap.get(scr.getToken().getName()), c);
			} else if( ru instanceof ScannerJSRule ) {
				ScannerJSRule sjr = (ScannerJSRule) ru;
				Function<IToken, IRule> f = JavaScriptHelper.loadScript(getClass().getClassLoader(), ru, sjr.getFileURI());
				rules[i] = f.apply(tokenMap.get(sjr.getToken().getName()));
			}
			i++;
		}
		
		if( ! scanner.getKeywordGroups().isEmpty() ) {
			JavaLikeWordDetector wordDetector= new JavaLikeWordDetector();
			CombinedWordRule combinedWordRule= new CombinedWordRule(wordDetector, defaultToken);
			for( KeywordGroup kg : scanner.getKeywordGroups() ) {
				CombinedWordRule.WordMatcher wordRule= new CombinedWordRule.WordMatcher();
				for( Keyword k : kg.getKeywords() ) {
					wordRule.addWord(k.getName(), tokenMap.get(kg.getToken().getName()));
				}
				combinedWordRule.addWordMatcher(wordRule);
			}			
			rules[i] = combinedWordRule;
		}
		
		setRules(rules);
	}
	
	private static Font createFont(org.eclipse.fx.code.compensator.hsl.hSL.Font font) {
		if( font == null ) {
			return null;
		}
		
		return Font.font(font.getName(), font.getAttributes().contains(FontType.BOLD) ? FontWeight.BOLD : FontWeight.NORMAL, font.getAttributes().contains(FontType.ITALIC) ? FontPosture.ITALIC : FontPosture.ITALIC, font.getSize());
	}

	private static Color createColor(org.eclipse.fx.code.compensator.hsl.hSL.Color color) {
		if( color instanceof RGBColor ) {
			RGBColor rcolor = (RGBColor) color;
			return Color.rgb(rcolor.getR(), rcolor.getG(), rcolor.getB());
		}
		return null;
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
