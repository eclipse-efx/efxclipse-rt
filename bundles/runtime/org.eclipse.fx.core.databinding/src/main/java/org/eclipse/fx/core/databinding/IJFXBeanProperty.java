/*******************************************************************************
 * Copyright (c) 2012 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
