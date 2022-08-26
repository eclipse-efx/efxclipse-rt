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

import org.eclipse.swt.internal.Util;

import javafx.scene.input.DataFormat;

public class FileTransfer extends ByteArrayTransfer {
	static FileTransfer INSTANCE = new FileTransfer();
	static final String ID_NAME = DataFormat.FILES.getIdentifiers().iterator().next();
	static final int ID = registerType(ID_NAME);
	
	@Override
	protected int[] getTypeIds() {
		return new int[] { ID };
	}

	@Override
	protected String[] getTypeNames() {
		return new String[] { ID_NAME };
	}
	
	public static FileTransfer getInstance () {
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
