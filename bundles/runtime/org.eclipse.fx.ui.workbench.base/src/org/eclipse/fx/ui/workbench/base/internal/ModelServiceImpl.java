/*******************************************************************************
 * Copyright (c) 2015 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.workbench.base.internal;

import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.MApplicationElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.fx.ui.workbench.services.ModelService;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.osgi.service.component.annotations.Component;

/**
 * Default implementation of the {@link ModelService}
 */
@Component
public class ModelServiceImpl implements ModelService {

	@Override
	public @NonNull String getUniqueId(@NonNull MApplicationElement element) {
		EObject eo = (EObject) element;
		String id = ((XMIResource) eo.eResource()).getID(eo);
		if( id == null ) {
			throw new IllegalStateException("Unable to locate ID for '"+element+"'");  //$NON-NLS-1$//$NON-NLS-2$
		}
		return id;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <M extends MApplicationElement> @Nullable M getElementInstance(@NonNull MApplication m, @NonNull String uniqueId) {
		return (M) ((XMIResource) ((EObject)m).eResource()).getEObject(uniqueId);
	}
	
	@Override
	public MApplication getRoot(@NonNull MApplicationElement e) {
		Resource eResource = ((EObject)e).eResource();
		return eResource != null ? (MApplication) eResource.getContents().get(0) : null;
	}

}
