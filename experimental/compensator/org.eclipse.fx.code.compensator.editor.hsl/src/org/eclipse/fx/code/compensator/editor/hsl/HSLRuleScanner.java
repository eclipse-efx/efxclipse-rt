package org.eclipse.fx.code.compensator.editor.hsl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

import org.eclipse.fx.code.compensator.hsl.hSL.FontType;
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
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.IWhitespaceDetector;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.SingleLineRule;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.rules.WhitespaceRule;

public class HSLRuleScanner extends RuleBasedScanner {
	public HSLRuleScanner(RuleDamager scanner) {
		System.err.println("SCANNER");
		Map<String, IToken> tokenMap = new HashMap<String, IToken>();
		for( ScannerToken st : scanner.getTokens() ) {
			Token token = new Token(new TextAttribute(createColor(st.getFgColor()), createColor(st.getFgColor()), 0, createFont(st.getFont())));
			if( st.isDefault() ) {
				setDefaultReturnToken(token);
			}
			tokenMap.put(st.getName(), token);
		}
		
		IRule[] rules = new IRule[scanner.getRules().size()];
		
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
				throw new UnsupportedOperationException();
			} else if( ru instanceof ScannerWhitespaceRule ) {
				ScannerWhitespaceRule wru = (ScannerWhitespaceRule) ru;
				rules[i] = new WhitespaceRule(wru.getJsDetector() != null ? new JSWSDectector() : new FixedCharacterWSDetector(wru.getCharacters()));
			} else if( ru instanceof ScannerCharacterRule ) {
				throw new UnsupportedOperationException();
			} else if( ru instanceof ScannerJSRule ) {
				throw new UnsupportedOperationException();
			}
			i++;
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
