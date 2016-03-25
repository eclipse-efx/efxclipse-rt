package org.eclipse.fx.code.editor.services;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import org.eclipse.fx.text.navigation.NavigationRegion;

/**
 * The navigation provider is responsible to provide informations about
 * sensitive regions in the current document
 *
 * @since 2.4.0
 */
public interface NavigationProvider {
	/**
	 * @return all navigation regions known
	 */
	CompletableFuture<List<NavigationRegion>> getNavigationRegions();

	/**
	 * Search for the navigation at the provided caret offset or return an empty
	 * optional of the current position is not a navigation sensitive region
	 *
	 * @param caretOffet
	 *            the caret offset
	 * @return optional containing the sensitive region
	 */
	CompletableFuture<Optional<NavigationRegion>> getNavigationRegion(int caretOffet);
}
