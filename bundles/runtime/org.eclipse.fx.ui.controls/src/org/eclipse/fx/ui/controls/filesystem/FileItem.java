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
