package org.eclipse.swt.events;

import org.eclipse.swt.internal.SWTEventListener;

public interface VerifyListener extends SWTEventListener {

	public void verifyText(VerifyEvent e);
}