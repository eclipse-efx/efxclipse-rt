/*******************************************************************************
 * Copyright (c) 2016 BestSolution.at and others.
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
package org.eclipse.fx.emf.databinding;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import javafx.beans.property.Property;

/**
 * EMF Property
 *
 * @param <O>
 *            the owner type
 * @param <T>
 *            the value type
 */
public interface EProperty<O extends EObject, T> extends Property<T> {
	@Override
	O getBean();

	/**
	 * @return the emf feature represented by the property
	 */
	EStructuralFeature getFeature();
}
