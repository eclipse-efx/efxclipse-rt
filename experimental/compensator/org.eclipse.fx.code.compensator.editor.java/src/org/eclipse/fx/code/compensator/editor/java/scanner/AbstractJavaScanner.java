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

import javafx.scene.paint.Color;

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
			return new Token(new TextAttribute(Color.rgb(42, 0, 255)));
		case IJavaColorConstants.JAVA_DEFAULT:
			return new Token(new TextAttribute(Color.rgb(0,0,0)));
		case IJavaColorConstants.ANNOTATION:
			return new Token(new TextAttribute(Color.rgb(200, 200, 200)));
		case IJavaColorConstants.JAVA_KEYWORD:
			return new Token(new TextAttribute(Color.rgb(127, 0, 85)));
		case IJavaColorConstants.JAVA_OPERATOR:
			return new Token(new TextAttribute(Color.rgb(0, 0, 0)));
		case IJavaColorConstants.JAVA_BRACKET:
			return new Token(new TextAttribute(Color.rgb(0, 0, 0)));
		case IJavaColorConstants.JAVA_KEYWORD_RETURN:
			return new Token(new TextAttribute(Color.rgb(127, 0, 85)));
		case IJavaColorConstants.TASK_TAG:
			return new Token(new TextAttribute(Color.rgb(127, 159, 191)));
		case IJavaColorConstants.JAVADOC_LINK:
			return new Token(new TextAttribute(Color.rgb(63, 63, 191)));
		case IJavaColorConstants.JAVADOC_DEFAULT:
			return new Token(new TextAttribute(Color.rgb(63, 95, 191)));
		case IJavaColorConstants.JAVA_MULTI_LINE_COMMENT:
			return new Token(new TextAttribute(Color.rgb(63, 127, 95)));
		case IJavaColorConstants.JAVA_SINGLE_LINE_COMMENT:
			return new Token(new TextAttribute(Color.rgb(63, 127, 95)));
		case IJavaColorConstants.JAVADOC_TAG:
			return new Token(new TextAttribute(Color.rgb(127, 127, 159)));
		default:
			throw new IllegalStateException("Unknown key '"+ key+"'");
		}
	}
}
