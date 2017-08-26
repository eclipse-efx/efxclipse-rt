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
package org.eclipse.fx.ui.workbench.services;

import java.lang.annotation.Annotation;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.model.application.MApplicationElement;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.fx.core.log.LoggerCreator;
import org.eclipse.fx.core.log.LoggerFactory;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * Service to register lifecycle handlers on model elements
 */
public interface ELifecycleService {
	/**
	 * Register a life-cycle handler
	 * 
	 * @param element
	 *            the model element
	 * @param lifecycleURI
	 *            the uri
	 */
	public void registerLifecycleURI(@NonNull MUIElement element, @NonNull String lifecycleURI);

	/**
	 * Unregister a life-cycle handler
	 * 
	 * @param element
	 *            the element
	 * @param contribution
	 *            the contribution instance
	 */
	public void unregisterLifecycleContribution(@NonNull MUIElement element, @NonNull Object contribution);

	/**
	 * Validate an annotation
	 * 
	 * @param annotationClass
	 *            the annotation class
	 * @param element
	 *            the element
	 * @param context
	 *            the context
	 * @return <code>true</code> if validation succeeded
	 * @deprecated use {@link #validateAnnotation(Class, MApplicationElement, IEclipseContext, IEclipseContext)}
	 */
	@Deprecated
	public boolean validateAnnotation(@NonNull Class<? extends Annotation> annotationClass, @NonNull MUIElement element, @NonNull IEclipseContext context);

	/**
	 * Validate an annotation
	 * 
	 * @param annotationClass
	 *            the annotation class
	 * @param element
	 *            the element
	 * @param context
	 *            the context
	 * @param localContext
	 *            the local context
	 * @return <code>true</code> if validation succeeded
	 * @since 3.1.0
	 */
	public default boolean validateAnnotation(@NonNull Class<? extends Annotation> annotationClass, @NonNull MApplicationElement element, @NonNull IEclipseContext context, @Nullable IEclipseContext localContext) {
		LoggerCreator.createLogger(getClass()).error("The service implementation should have implemented this method appropriately"); //$NON-NLS-1$
		return validateAnnotation(annotationClass, (MUIElement)element, context);
	}

}