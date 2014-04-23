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
