package org.eclipse.fx.text.navigation;

import org.eclipse.jface.text.IRegion;

public interface NavigationTarget {
	String getFile();
	IRegion getRegion();
}
