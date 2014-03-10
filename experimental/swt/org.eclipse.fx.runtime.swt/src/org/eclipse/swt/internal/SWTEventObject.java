package org.eclipse.swt.internal;

import java.util.EventObject;

public class SWTEventObject extends EventObject {
	static final long serialVersionUID = 3258125873411470903L;
	
	public SWTEventObject(Object source) {
		super(source);
	}
}
