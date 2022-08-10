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
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.text.rules;

import org.eclipse.jface.text.rules.ICharacterScanner;

@SuppressWarnings("restriction")
public class CheckPointScanner implements ICharacterScanner {
	private final ICharacterScanner realScanner;
	int charCount;

	public CheckPointScanner(ICharacterScanner realScanner) {
		this.realScanner = realScanner;
	}

	@Override
	public char[][] getLegalLineDelimiters() {
		return this.realScanner.getLegalLineDelimiters();
	}

	@Override
	public int getColumn() {
		return this.getColumn();
	}

	@Override
	public int read() {
		this.charCount++;
		int read = this.realScanner.read();
		return read;
	}

	@Override
	public void unread() {
		this.charCount--;
		this.realScanner.unread();
	}

	public void setCheckpoint() {
		this.charCount = 0;
	}

	public void rollbackToCheckPoint() {
		while( charCount > 0 ) {
			// Important we are not calling ourselves!!!
			realScanner.unread();
			charCount--;
		}
	}
}
