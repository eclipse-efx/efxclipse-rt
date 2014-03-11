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
package org.eclipse.fx.ui.controls.styledtext;


public class TextChangedEvent {

	public final StyledTextContent source;
	
	public final int offset;
	public final int replaceCharCount;
	public final int replaceLineCount;
	public final String newText;
	public final int newCharCount;
	public final int newLineCount;
	
	private TextChangedEvent(StyledTextContent source,int offset, int replaceCharCount, int replaceLineCount, String newText, int newCharCount, int newLineCount) {
		this.source = source;
		this.offset = offset;
		this.replaceCharCount = replaceCharCount;
		this.replaceLineCount = replaceLineCount;
		this.newText = newText;
		this.newCharCount = newCharCount;
		this.newLineCount = newLineCount;
	}
	
	public static TextChangedEvent textChanged(StyledTextContent source) {
		return new TextChangedEvent(source, 0, 0, 0, null, 0, 0);
	}
	
	public static TextChangedEvent textSet(StyledTextContent source) {
		return new TextChangedEvent(source, 0, 0, 0, null, 0, 0);
	}
	
}
