/*******************************************************************************
 * Copyright (c) 2022 BestSolution.at and others.
 *  
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *  
 * SPDX-License-Identifier: EPL-2.0
 *  
 * Contributors:
 *     BestSolution.at - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.text.ui.contentassist;

import org.eclipse.jface.text.IDocument;

public class ContentAssistContextData {
	public final int offset;
	public final IDocument document;
//	public final String prefix;

	public ContentAssistContextData(int offset, IDocument document/*, String prefix*/) {
		this.offset = offset;
		this.document = document;
//		this.prefix = prefix;
	}
}
