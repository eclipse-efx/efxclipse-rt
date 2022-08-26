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
package org.eclipse.fx.code.compensator.editor.java.scanner;

import java.util.List;

import org.eclipse.jface.text.rules.IRule;

public class SingleTokenJavaScanner extends AbstractJavaScanner{
	private String[] fProperty;

	public SingleTokenJavaScanner(String property) {
		super();
		fProperty= new String[] { property };
		initialize();
	}
	
	@Override
	protected List<IRule> createRules() {
		setDefaultReturnToken(getToken(fProperty[0]));
		return null;
	}

}
