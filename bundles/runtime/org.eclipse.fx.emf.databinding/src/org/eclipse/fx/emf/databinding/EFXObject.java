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

/**
 * Base interface for an adapted eobject
 *
 * @param <O>
 *            the owner type
 */
public interface EFXObject<O extends EObject> {
	/**
	 * Get the property
	 *
	 * @param feature
	 *            the feature
	 * @return the property
	 */
	public <P extends EProperty<O, ?>> P getProperty(EStructuralFeature feature);
}
