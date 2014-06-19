/*******************************************************************************
 * Copyright (c) 2000, 2011 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.code.compensator.editor.js.scanner;

import java.util.List;

import javafx.scene.paint.Color;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.BufferedRuleBasedScanner;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.Token;

public abstract class AbstractJavaScriptScanner extends BufferedRuleBasedScanner {
	
	public AbstractJavaScriptScanner() {
	}
	
	public final void initialize() {
		initializeRules();
	}
	
	abstract protected List<IRule> createRules();
	
	private void initializeRules() {
		List<IRule> rules= createRules();
		if (rules != null) {
			IRule[] result= new IRule[rules.size()];
			rules.toArray(result);
			setRules(result);
		}
	}
	
	protected Token getToken(String key) {
		switch (key) {
		case IJavaScriptColorConstants.JAVA_STRING:
			return new Token(new TextAttribute(Color.rgb(42, 0, 255)));
		case IJavaScriptColorConstants.JAVA_DEFAULT:
			return new Token(new TextAttribute(Color.rgb(0,0,0)));
		case IJavaScriptColorConstants.ANNOTATION:
			return new Token(new TextAttribute(Color.rgb(200, 200, 200)));
		case IJavaScriptColorConstants.JAVA_KEYWORD:
			return new Token(new TextAttribute(Color.rgb(127, 0, 85)));
		case IJavaScriptColorConstants.JAVA_OPERATOR:
			return new Token(new TextAttribute(Color.rgb(0, 0, 0)));
		case IJavaScriptColorConstants.JAVA_BRACKET:
			return new Token(new TextAttribute(Color.rgb(0, 0, 0)));
		case IJavaScriptColorConstants.JAVA_KEYWORD_RETURN:
			return new Token(new TextAttribute(Color.rgb(127, 0, 85)));
		case IJavaScriptColorConstants.TASK_TAG:
			return new Token(new TextAttribute(Color.rgb(127, 159, 191)));
		case IJavaScriptColorConstants.JAVADOC_LINK:
			return new Token(new TextAttribute(Color.rgb(63, 63, 191)));
		case IJavaScriptColorConstants.JAVADOC_DEFAULT:
			return new Token(new TextAttribute(Color.rgb(63, 95, 191)));
		case IJavaScriptColorConstants.JAVA_MULTI_LINE_COMMENT:
			return new Token(new TextAttribute(Color.rgb(63, 127, 95)));
		case IJavaScriptColorConstants.JAVA_SINGLE_LINE_COMMENT:
			return new Token(new TextAttribute(Color.rgb(63, 127, 95)));
		case IJavaScriptColorConstants.JAVADOC_TAG:
			return new Token(new TextAttribute(Color.rgb(127, 127, 159)));
		default:
			throw new IllegalStateException("Unknown key '"+ key+"'");
		}
	}
}
