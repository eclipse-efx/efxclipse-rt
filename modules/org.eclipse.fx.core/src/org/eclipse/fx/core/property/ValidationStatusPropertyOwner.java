/*******************************************************************************
 * Copyright (c) 2016 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core.property;

import org.eclipse.fx.core.Status;

import javafx.beans.property.ReadOnlyObjectProperty;

/**
 * Owner of status property
 */
public interface ValidationStatusPropertyOwner {
	/**
	 * @return the status of the property
	 */
	public ReadOnlyObjectProperty<Status> statusProperty();

	/**
	 * Run the validation
	 */
	public void validate();
}
