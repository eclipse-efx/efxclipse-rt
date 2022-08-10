/*******************************************************************************
 * Copyright (c) 2000, 2011 IBM Corporation and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
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
			return new Token(new TextAttribute(IJavaScriptColorConstants.JAVA_STRING));
		case IJavaScriptColorConstants.JAVA_DEFAULT:
			return new Token(new TextAttribute(IJavaScriptColorConstants.JAVA_DEFAULT));
		case IJavaScriptColorConstants.ANNOTATION:
			return new Token(new TextAttribute(IJavaScriptColorConstants.ANNOTATION));
		case IJavaScriptColorConstants.JAVA_KEYWORD:
			return new Token(new TextAttribute(IJavaScriptColorConstants.JAVA_KEYWORD));
		case IJavaScriptColorConstants.JAVA_OPERATOR:
			return new Token(new TextAttribute(IJavaScriptColorConstants.JAVA_OPERATOR));
		case IJavaScriptColorConstants.JAVA_BRACKET:
			return new Token(new TextAttribute(IJavaScriptColorConstants.JAVA_BRACKET));
		case IJavaScriptColorConstants.JAVA_KEYWORD_RETURN:
			return new Token(new TextAttribute(IJavaScriptColorConstants.JAVA_KEYWORD_RETURN));
		case IJavaScriptColorConstants.TASK_TAG:
			return new Token(new TextAttribute(IJavaScriptColorConstants.TASK_TAG));
		case IJavaScriptColorConstants.JAVADOC_LINK:
			return new Token(new TextAttribute(IJavaScriptColorConstants.JAVADOC_LINK));
		case IJavaScriptColorConstants.JAVADOC_DEFAULT:
			return new Token(new TextAttribute(IJavaScriptColorConstants.JAVADOC_DEFAULT));
		case IJavaScriptColorConstants.JAVA_MULTI_LINE_COMMENT:
			return new Token(new TextAttribute(IJavaScriptColorConstants.JAVA_MULTI_LINE_COMMENT));
		case IJavaScriptColorConstants.JAVA_SINGLE_LINE_COMMENT:
			return new Token(new TextAttribute(IJavaScriptColorConstants.JAVA_SINGLE_LINE_COMMENT));
		case IJavaScriptColorConstants.JAVADOC_TAG:
			return new Token(new TextAttribute(IJavaScriptColorConstants.JAVADOC_TAG));
		default:
			throw new IllegalStateException("Unknown key '"+ key+"'");
		}
	}
}
