/*******************************************************************************
 * Copyright (c) 2000, 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.controls.styledtext;



public interface StyledTextContent {
	public String getLine(int index);
	
	public String getTextRange(int start, int length);
	
	public void setText (String text);
	
	public int getCharCount();
	
	public int getLineCount();
	
	public int getOffsetAtLine(int lineIndex);
	
	public int getLineAtOffset(int charPosition);
	
	public void replaceTextRange(int start, int replaceLength, String newText);
	
	public void addTextChangeListener(TextChangeListener listener);
	
	public void removeTextChangeListener(TextChangeListener listener);
	
	interface TextChangeListener {
		public void textChanged(TextChangedEvent event);

		public void textSet(TextChangedEvent event);

		public void textChanging(TextChangingEvent event);
	}
}
