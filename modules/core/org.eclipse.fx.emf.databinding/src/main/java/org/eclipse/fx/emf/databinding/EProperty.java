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
