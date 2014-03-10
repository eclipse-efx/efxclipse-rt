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
