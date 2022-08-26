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
package org.eclipse.swt.printing;

import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.internal.Util;

public class Printer extends Device {

	public Printer() {
		Util.logNotImplemented();
	}
	
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

	public boolean startJob(String string) {
		Util.logNotImplemented();
		return false;
	}

	public void endJob() {
		Util.logNotImplemented();
	}

	public Point getDPI() {
		Util.logNotImplemented();
		return null;
	}

	public Rectangle computeTrim(int i, int j, int k, int l) {
		Util.logNotImplemented();
		return null;
	}

	public PrinterData getPrinterData() {
		Util.logNotImplemented();
		return null;
	}
	
	
}
