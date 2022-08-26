/*******************************************************************************
 * Copyright (c) 2012 BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core.databinding;

import java.beans.PropertyDescriptor;

import org.eclipse.core.databinding.property.IProperty;
import org.eclipse.jdt.annotation.Nullable;

/**
 * Root interface of all JavaFX properties
 */
public interface IJFXBeanProperty extends IProperty {
	/**
	 * @return the descriptor
	 */
	@Nullable
	public PropertyDescriptor getPropertyDescriptor();
}
