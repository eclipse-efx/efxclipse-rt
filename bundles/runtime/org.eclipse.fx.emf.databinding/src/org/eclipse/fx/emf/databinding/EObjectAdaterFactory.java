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
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.fx.emf.databinding.internal.AdaptedEObject;
import org.eclipse.jdt.annotation.NonNull;

/**
 * Factory to create an adapter instance to create observables
 *
 * @since 3.0
 */
public class EObjectAdaterFactory {

	/**
	 * Adapt the object
	 *
	 * @param ed
	 *            the optional editing domain
	 * @param eObject
	 *            the emf object
	 * @return the adapted object
	 */
	public static <@NonNull O extends EObject> EFXObject<O> adapt(EditingDomain ed, O eObject) {
		return new AdaptedEObject<O>(ed, eObject);
	}
}
