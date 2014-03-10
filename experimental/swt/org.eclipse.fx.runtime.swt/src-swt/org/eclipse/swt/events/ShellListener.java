package org.eclipse.swt.events;

import org.eclipse.swt.internal.SWTEventListener;

public interface ShellListener extends SWTEventListener {

	public void shellActivated(ShellEvent e);

	public void shellClosed(ShellEvent e);

	public void shellDeactivated(ShellEvent e);

	public void shellDeiconified(ShellEvent e);

	public void shellIconified(ShellEvent e);
}