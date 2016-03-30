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

public interface ContextInformation {

	public CharSequence getText();
	public int getOffset();

	public static class BaseContextInformation implements ContextInformation {

		private final CharSequence label;

		private final int offset;

		public BaseContextInformation(int offset, CharSequence label) {
			this.offset = offset;
			this.label = label;
		}

		@Override
		public CharSequence getText() {
			return label;
		}

		@Override
		public int getOffset() {
			return offset;
		}

	}



}
