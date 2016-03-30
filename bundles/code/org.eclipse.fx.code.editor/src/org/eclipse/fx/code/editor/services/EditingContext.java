/*******************************************************************************
* Copyright (c) 2016 BestSolution.at and others.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
* 	Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
*******************************************************************************/
package org.eclipse.fx.code.editor.services;

import java.util.function.Consumer;

import org.eclipse.fx.core.Subscription;
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

	IRegion getSelection();
	void setSelection(IRegion selection);

	Subscription registerOnCaretOffsetChanged(Consumer<Integer> listener);
	Subscription registerOnSelectionChanged(Consumer<IRegion> listener);

}
