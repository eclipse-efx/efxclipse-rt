/*******************************************************************************
 * Copyright (c) 2017 BestSolution.at and others.
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
package org.eclipse.fx.ui.workbench.base.internal;

import org.eclipse.e4.ui.internal.workbench.E4XMIResource;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;

public class EFX_E4XMIResource extends E4XMIResource {
	public EFX_E4XMIResource(URI uri) {
		super(uri);
	}
	
	@Override
	public String getID(EObject eObject) {
		String id = super.getID(eObject);
		setID(eObject, id);
		return id;
	}
}
