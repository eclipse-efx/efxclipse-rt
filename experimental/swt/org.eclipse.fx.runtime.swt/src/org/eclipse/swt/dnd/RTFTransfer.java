/*******************************************************************************
 * Copyright (c) 2014 IBM Corporation, BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	   IBM Corporation - initial API
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.swt.dnd;

import org.eclipse.swt.internal.Util;

import javafx.scene.input.DataFormat;

public class RTFTransfer extends ByteArrayTransfer {
	static RTFTransfer INSTANCE = new RTFTransfer();
	static final String ID_NAME = DataFormat.RTF.getIdentifiers().iterator().next();
	static final int ID = registerType(ID_NAME);
	
	@Override
	protected int[] getTypeIds() {
		return new int[] { ID };
	}

	@Override
	protected String[] getTypeNames() {
		return new String[] { ID_NAME };
	}
	
	public static RTFTransfer getInstance () {
		return INSTANCE;
	}
	
	@Override
	public Object nativeToJava(TransferData transferData) {
		Util.logNotImplemented();
		return super.nativeToJava(transferData);
	}
	
	@Override
	public void javaToNative(Object object, TransferData transferData) {
		Util.logNotImplemented();
		super.javaToNative(object, transferData);
	}

}
