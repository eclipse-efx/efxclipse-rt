/*******************************************************************************
* Copyright (c) 2014 BestSolution.at and others.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
* 	Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
*******************************************************************************/
package org.eclipse.fx.code.compensator.editor;

public interface ContentTypeProvider {
	public static final String XML = "text/xml";
	public static final String JAVA = "text/java";
	public static final String JAVASCRIPT = "text/javascript";
	public static final String GROOVY = "text/groovy";
	public static final String HSL = "text/hsl";
	public static final String LEGO = "text/lego";
	public String getContentType();
}
