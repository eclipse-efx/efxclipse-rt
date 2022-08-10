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

import org.eclipse.jface.text.IRegion;

public class SourceSelection {
	public final String uri;
	public final IRegion selection;

	public SourceSelection(String uri, IRegion selection) {
		this.uri = uri;
		this.selection = selection;
	}

}
