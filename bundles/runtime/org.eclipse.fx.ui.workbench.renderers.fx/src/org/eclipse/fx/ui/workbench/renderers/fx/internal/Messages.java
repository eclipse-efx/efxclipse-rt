/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.workbench.renderers.fx.internal;

import java.text.MessageFormat;

/**
 * Translations
 */
@SuppressWarnings("javadoc")
public class Messages {
	public String DefWindowRenderer_promptToSave_Title;
	public String DefWindowRenderer_promptToSave_Message;
	
	public String DefWindowRenderer_MultiMessageDialog_Title;
	public String DefWindowRenderer_MultiMessageDialog_Message;
	
	public String DefWindowRenderer_promptToSave_Message(String partName) {
		return MessageFormat.format(this.DefWindowRenderer_promptToSave_Message, partName);
	}
}
