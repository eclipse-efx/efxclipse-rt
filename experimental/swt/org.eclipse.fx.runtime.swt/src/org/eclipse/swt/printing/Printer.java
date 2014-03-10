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
