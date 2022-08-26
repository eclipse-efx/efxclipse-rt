/*******************************************************************************
* Copyright (c) 2016 BestSolution.at and others.
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
package org.eclipse.fx.code.editor;

public class SourceFileChange {
	public final SourceFileInput input;
	public final int offset;
	public final int length;
	public final String replacement;

	public SourceFileChange(SourceFileInput input, int offset, int length, String replacement) {
		this.input = input;
		this.offset = offset;
		this.length = length;
		this.replacement = replacement;
	}
}
