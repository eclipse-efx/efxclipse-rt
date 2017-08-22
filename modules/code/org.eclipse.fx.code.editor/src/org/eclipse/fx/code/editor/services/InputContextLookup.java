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

import org.eclipse.fx.code.editor.Input;
import org.eclipse.fx.code.editor.InputContext;

public interface InputContextLookup {
	public static final InputContext DEFAULT = new InputContext() {
		private final String ID = "__default_context";

		@Override
		public String getId() {
			return ID;
		}
	};
	public InputContext getContext(Input<?> input);
}
