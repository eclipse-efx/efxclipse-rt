/*******************************************************************************
 * Copyright (c) 2015 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.controls.filesystem;

import javafx.collections.ObservableList;

import org.eclipse.jdt.annotation.NonNull;

/**
 * An observable directory
 *
 * @since 1.2
 */
public interface DirItem extends ResourceItem {
	/**
	 * @return list of children
	 */
	public @NonNull ObservableList<@NonNull ResourceItem> getChildren();
}
