package org.eclipse.swt.dnd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.scene.input.DataFormat;

import org.eclipse.swt.widgets.Display;

public class Clipboard {
	private Display display;
	private javafx.scene.input.Clipboard nativeObject;
	private static Map<String, DataFormat> NAME_TYPE_MAP = new HashMap<String, DataFormat>();
	private static List<DataFormat> CONTENT_TYPES;
	private static List<String> TYPENAMES = new ArrayList<>();
	
	public Clipboard(Display display) {
		this.display = display;
		nativeObject = javafx.scene.input.Clipboard.getSystemClipboard();
		if( CONTENT_TYPES == null ) {
			CONTENT_TYPES = new ArrayList<>(nativeObject.getContentTypes());
			for( DataFormat f : CONTENT_TYPES ) {
				String name = f.getIdentifiers().iterator().next();
				TYPENAMES.add(name);
				NAME_TYPE_MAP.put(name, f);
			}
		}
	}
	
	public void clearContents() {
		clearContents(DND.CLIPBOARD);
	}
	
	public void clearContents(int clipboards) {
		if ((clipboards & DND.CLIPBOARD) == 0) return;
		nativeObject.clear();
	}
	
	public void dispose () {
		this.display = null;
	}
	
	public Object getContents(Transfer transfer) {
		return getContents(transfer, DND.CLIPBOARD);
	}
	
	public Object getContents(Transfer transfer, int clipboards) {
		if ((clipboards & DND.CLIPBOARD) == 0) return null;
		
		String[] typeNames = transfer.getTypeNames();
		for( String typeName : typeNames ) {
			if( nativeObject.hasContent(NAME_TYPE_MAP.get(typeName))) {
				TransferData tdata = new TransferData();
				tdata.type = Transfer.registerType(typeName);
				Object content = nativeObject.getContent(NAME_TYPE_MAP.get(typeName));
				tdata.data = content;
				return transfer.nativeToJava(tdata);
			}
		}
		return null;
	}
	
	public boolean isDisposed () {
		return display == null;
	}
	
	public void setContents(Object[] data, Transfer[] dataTypes) {
		setContents(data, dataTypes, DND.CLIPBOARD);
	}
	
	public void setContents(Object[] data, Transfer[] dataTypes, int clipboards) {
		if ((clipboards & DND.CLIPBOARD) == 0) return;
		
		Map<DataFormat, Object> content = new HashMap<>();
		for (int i=0; i<dataTypes.length; i++) {
			for( String t : dataTypes[i].getTypeNames() ) {
				TransferData transferData = new TransferData();
				transferData.type = Transfer.registerType(t);
				dataTypes[i].javaToNative(data[i], transferData);
				Object tdata = transferData.data;
				content.put(NAME_TYPE_MAP.get(t), tdata);
			}
		}
		nativeObject.setContent(content);
	}
	
	public TransferData[] getAvailableTypes() {
		return getAvailableTypes(DND.CLIPBOARD);
	}
	
	public TransferData[] getAvailableTypes(int clipboards) {
		if ((clipboards & DND.CLIPBOARD) == 0) return new TransferData[0];
		
		
		TransferData[] result = new TransferData[CONTENT_TYPES.size()];
		for( int i = 0; i < CONTENT_TYPES.size(); i++ ) {
			result[i] = new TransferData();
			result[i].type = Transfer.registerType(CONTENT_TYPES.get(i).getIdentifiers().iterator().next());
		}
		return result;
	}
	
	public String[] getAvailableTypeNames() {
		return TYPENAMES.toArray(new String[0]);
	}
}
