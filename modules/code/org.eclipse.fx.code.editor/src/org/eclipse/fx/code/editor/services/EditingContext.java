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
package org.eclipse.fx.code.editor.services;

import java.util.function.Consumer;

import org.eclipse.fx.core.Subscription;
import org.eclipse.fx.core.text.TextEditAction;
import org.eclipse.jface.text.IRegion;

/**
 * represents the actual editor instance
 * <p>allows client code to interact with the editor caret and selection</p>
 *
 */
public interface EditingContext {

	int getCaretOffset();
	void setCaretOffset(int offset);

	void setCaretOffset(int offset, boolean keepSelection);
	void revealCaret();

	IRegion getSelection();
	void setSelection(IRegion selection);

	void showContextInformation(ContextInformation info);
	void triggerAction(TextEditAction action);

	Subscription registerOnCaretOffsetChanged(Consumer<Integer> listener);
	Subscription registerOnSelectionChanged(Consumer<IRegion> listener);


}
