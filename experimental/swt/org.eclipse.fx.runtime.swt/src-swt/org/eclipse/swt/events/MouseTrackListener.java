package org.eclipse.swt.events;

import org.eclipse.swt.internal.SWTEventListener;

public interface MouseTrackListener extends SWTEventListener {

	public void mouseEnter(MouseEvent e);

	public void mouseExit(MouseEvent e);

	public void mouseHover(MouseEvent e);
}