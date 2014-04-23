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

public abstract class ByteArrayTransfer extends Transfer {

	public TransferData[] getSupportedTypes() {
		int[] types = getTypeIds();
		TransferData[] data = new TransferData[types.length];
		for (int i = 0; i < types.length; i++) {
			data[i] = new TransferData();
			data[i].type = types[i];
		}
		return data;
	}

	@Override
	public boolean isSupportedType(TransferData transferData){
		if (transferData == null) return false;
		int[] types = getTypeIds();
		for (int i = 0; i < types.length; i++) {
			if (transferData.type == types[i]) return true;
		}
		return false;
	}

	@Override
	protected void javaToNative(Object object, TransferData transferData) {
		byte[] orig = (byte[])object;
		transferData.data = new String(orig);
	}

	@Override
	protected Object nativeToJava(TransferData transferData) {
		if( transferData.data != null && transferData.data instanceof String && ! transferData.toString().isEmpty() ) {
			return ((String)transferData.data).getBytes();	
		}
		return null;
	}
}