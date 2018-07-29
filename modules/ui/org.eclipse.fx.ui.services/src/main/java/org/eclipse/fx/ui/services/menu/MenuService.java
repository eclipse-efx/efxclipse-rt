/*******************************************************************************
 * Copyright (c) 2018 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Martin Blühweis <martin.bluehweis@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.services.menu;

import org.eclipse.jdt.annotation.NonNull;

/**
 * Provide for management of different menus.
 *
 * @noimplement This interface is not intended to be implemented by clients.
 * @since 3.3
 */
public interface MenuService {
	/**
	 * Create a menu for this control and hook it up with the MPopupMenu.
	 *
	 * @param parent
	 *            The parent for the context menu. A Node in JavaFX.
	 * @param menuId
	 *            the ID of the menu to use
	 * @return <code>true</code> if registration succeeded else <code>false</code>
	 */
	boolean registerContextMenu(@NonNull Object parent, @NonNull String menuId);
}
