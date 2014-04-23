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
package org.eclipse.swt.printing;

import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.internal.Util;

public class Printer extends Device {

	public Printer(PrinterData data) {
		Util.logNotImplemented();
	}

	@Override
	public Rectangle getBounds() {
		Util.logNotImplemented();
		return null;
	}

	public static Printer[] getPrinterList() {
		Util.logNotImplemented();
		return new Printer[0];
	}

	public Rectangle getClientArea() {
		Util.logNotImplemented();
		return new Rectangle(0, 0, 0, 0);
	}

	public void endPage() {
		Util.logNotImplemented();
	}

	public void startPage() {
		Util.logNotImplemented();
	}

	public void startJob(String string) {
		Util.logNotImplemented();
	}

	public void endJob() {
		Util.logNotImplemented();
	}
	
	
}
