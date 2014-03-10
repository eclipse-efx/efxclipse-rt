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
