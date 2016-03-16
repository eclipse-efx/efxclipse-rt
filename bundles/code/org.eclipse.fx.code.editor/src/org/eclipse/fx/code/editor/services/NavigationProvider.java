package org.eclipse.fx.code.editor.services;

import java.util.List;
import java.util.concurrent.Future;

import org.eclipse.fx.text.navigation.NavigationRegion;


public interface NavigationProvider {

	Future<List<NavigationRegion>> getNavigationRegions();
}
