package org.eclipse.fx.code.editor.services;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import org.eclipse.fx.text.navigation.NavigationRegion;


public interface NavigationProvider {

	CompletableFuture<List<NavigationRegion>> getNavigationRegions();
	CompletableFuture<Optional<NavigationRegion>> getNavigationRegion(int caretOffet);
}
