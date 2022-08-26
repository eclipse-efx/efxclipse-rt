/*******************************************************************************
* Copyright (c) 2014 BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
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
	public static final String DART = "text/dart";

	public String getContentType();
}
