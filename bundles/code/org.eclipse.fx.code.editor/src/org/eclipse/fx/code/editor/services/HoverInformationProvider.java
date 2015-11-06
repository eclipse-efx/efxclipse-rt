package org.eclipse.fx.code.editor.services;

import org.eclipse.jface.text.IRegion;

public interface HoverInformationProvider {
	public CharSequence getHoverInformation(String partitionType, IRegion region);
	public IRegion getHoverRegion(String partitionType, int offset);
}
