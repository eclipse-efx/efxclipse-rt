/*******************************************************************************
 * Copyright (c) 2014 IBM Corporation, BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 * 	   IBM Corporation - initial API
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.swt.dnd;

import javafx.scene.input.DataFormat;

public class TextTransfer extends ByteArrayTransfer {
	static TextTransfer INSTANCE = new TextTransfer();
	static final String ID_NAME = DataFormat.PLAIN_TEXT.getIdentifiers().iterator().next();
	static final int ID = registerType(ID_NAME);
	@Override
	protected int[] getTypeIds() {
		return new int[] { ID };
	}

	@Override
	protected String[] getTypeNames() {
		return new String[] { ID_NAME };
	}

	public static TextTransfer getInstance () {
		return INSTANCE;
	}
	
	public void javaToNative (Object object, TransferData transferData) {
		transferData.data = object;
	}
	
	public Object nativeToJava(TransferData transferData) {
		return transferData.data;
	}
}
