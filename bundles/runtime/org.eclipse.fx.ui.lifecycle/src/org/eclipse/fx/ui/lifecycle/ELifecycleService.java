/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.lifecycle;

import java.lang.annotation.Annotation;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.model.application.ui.MUIElement;

public interface ELifecycleService {
	
	public void registerLifecycleURI(MUIElement element, String lifecycleURI);

	public void unregisterLifecycleContribution(MUIElement element, Object contribution);
	
	public boolean validateAnnotation(Class<? extends Annotation> annotationClass, MUIElement element, IEclipseContext context);

}