package org.eclipse.fx.text.navigation;

import java.util.List;

import org.eclipse.jface.text.IRegion;

public interface NavigationRegion {
	IRegion getRegion();
	List<NavigationTarget> getTargets();
}
