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
package org.eclipse.fx.code.compensator.editor.java.scanner;

import java.util.List;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.BufferedRuleBasedScanner;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.Token;

public abstract class AbstractJavaScanner extends BufferedRuleBasedScanner {
	
	public AbstractJavaScanner() {
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
		case IJavaColorConstants.JAVA_STRING:
			return new Token(new TextAttribute(IJavaColorConstants.JAVA_STRING));
		case IJavaColorConstants.JAVA_DEFAULT:
			return new Token(new TextAttribute(IJavaColorConstants.JAVA_DEFAULT));
		case IJavaColorConstants.ANNOTATION:
			return new Token(new TextAttribute(IJavaColorConstants.ANNOTATION));
		case IJavaColorConstants.JAVA_KEYWORD:
			return new Token(new TextAttribute(IJavaColorConstants.JAVA_KEYWORD));
		case IJavaColorConstants.JAVA_OPERATOR:
			return new Token(new TextAttribute(IJavaColorConstants.JAVA_OPERATOR));
		case IJavaColorConstants.JAVA_BRACKET:
			return new Token(new TextAttribute(IJavaColorConstants.JAVA_BRACKET));
		case IJavaColorConstants.JAVA_KEYWORD_RETURN:
			return new Token(new TextAttribute(IJavaColorConstants.JAVA_KEYWORD_RETURN));
		case IJavaColorConstants.TASK_TAG:
			return new Token(new TextAttribute(IJavaColorConstants.TASK_TAG));
		case IJavaColorConstants.JAVADOC_LINK:
			return new Token(new TextAttribute(IJavaColorConstants.JAVADOC_LINK));
		case IJavaColorConstants.JAVADOC_DEFAULT:
			return new Token(new TextAttribute(IJavaColorConstants.JAVADOC_DEFAULT));
		case IJavaColorConstants.JAVA_MULTI_LINE_COMMENT:
			return new Token(new TextAttribute(IJavaColorConstants.JAVA_MULTI_LINE_COMMENT));
		case IJavaColorConstants.JAVA_SINGLE_LINE_COMMENT:
			return new Token(new TextAttribute(IJavaColorConstants.JAVA_SINGLE_LINE_COMMENT));
		case IJavaColorConstants.JAVADOC_TAG:
			return new Token(new TextAttribute(IJavaColorConstants.JAVADOC_TAG));
		default:
			throw new IllegalStateException("Unknown key '"+ key+"'");
		}
	}
}
