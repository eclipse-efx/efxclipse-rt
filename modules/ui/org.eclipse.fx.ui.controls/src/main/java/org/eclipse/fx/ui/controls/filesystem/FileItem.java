/*******************************************************************************
 * Copyright (c) 2015 BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.controls.filesystem;

import javafx.beans.property.ReadOnlyObjectProperty;

/**
 * An observable file
 *
 * @since 1.2
 */
public interface FileItem extends ResourceItem {
	/**
	 * @return the file size as a property
	 */
	public ReadOnlyObjectProperty<Long> fileSizeProperty();
	/**
	 * @return the file size formatted for humans
	 */
	public String getFormattedSize();
}
