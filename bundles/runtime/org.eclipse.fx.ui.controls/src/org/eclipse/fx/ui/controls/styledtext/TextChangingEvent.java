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


public class TextChangingEvent {

	public final StyledTextContent source;
	
	public int offset;
	public int replaceCharCount;
	public final int replaceLineCount;
	public final String newText;
	public final int newCharCount;
	public final int newLineCount;
	
	private TextChangingEvent(StyledTextContent source,int offset, int replaceCharCount, int replaceLineCount, String newText, int newCharCount, int newLineCount) {
		this.source = source;
		this.offset = offset;
		this.replaceCharCount = replaceCharCount;
		this.replaceLineCount = replaceLineCount;
		this.newText = newText;
		this.newCharCount = newCharCount;
		this.newLineCount = newLineCount;
	}
	
	public static TextChangingEvent textChanging(StyledTextContent source, int offset, int replaceCharCount, int replaceLineCount, String newText, int newCharCount, int newLineCount) {
		return new TextChangingEvent(source, offset, replaceCharCount, replaceLineCount, newText, newCharCount, newLineCount);
	}
}
