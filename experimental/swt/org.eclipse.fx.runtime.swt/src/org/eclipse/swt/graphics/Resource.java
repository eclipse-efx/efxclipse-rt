package org.eclipse.swt.graphics;

import org.eclipse.swt.SWT;

public abstract class Resource {
	private Device device;
	
	protected Resource(Device device) {
		this.device = device;
	}
	
	public Device getDevice() {
		Device device = this.device;
		if (device == null || isDisposed ()) SWT.error (SWT.ERROR_GRAPHIC_DISPOSED);
		return device;
	}
	
	public abstract void dispose();
	
	public abstract boolean isDisposed();
}
