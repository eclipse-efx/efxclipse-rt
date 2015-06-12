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
package org.eclipse.fx.ui.workbench.services.lifecycle.internal;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.services.contributions.IContributionFactory;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.MContribution;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.fx.ui.workbench.services.ELifecycleService;
import org.eclipse.fx.ui.workbench.services.lifecycle.LifecycleAddon;
import org.eclipse.jdt.annotation.NonNull;

/**
 * Implementation of a {@link ELifecycleService}
 */
@SuppressWarnings("restriction")
public class LifecycleServiceImpl implements ELifecycleService {

	@Inject
	private EModelService modelService;

	@Inject
	private MApplication app;

	@Inject
	private IContributionFactory factory;

	@Override
	public void registerLifecycleURI(MUIElement element, String lifecycleURI) {
		@SuppressWarnings("unchecked")
		Map<@NonNull String,@NonNull Object> contributions = (Map<@NonNull String,@NonNull Object>) element.getTransientData().get(LifecycleAddon.LIFECYCLE_TRANSIENT_KEY);
		if (contributions == null) {
			contributions = new HashMap<>();
			element.getTransientData().put(LifecycleAddon.LIFECYCLE_TRANSIENT_KEY, contributions);
		}

		if( ! contributions.containsKey(lifecycleURI) ) {
			Object object = this.factory.create(lifecycleURI, this.app.getContext());
			if (object != null) {
				contributions.put(lifecycleURI,object);
			}
		}
	}

	@Override
	public boolean validateAnnotation(Class<? extends Annotation> annotationClass, MUIElement element, IEclipseContext context) {
		return validateLifecycleAnnotation(annotationClass, getContextForParent(element), context, element);
	}

	private static boolean validateLifecycleAnnotation(Class<? extends Annotation> clazz, IEclipseContext parentContext, IEclipseContext partContext, MUIElement part) {
		// If the object itself is a contribution we can check the
		// lifecycle stuff as well on the contribution
		if( part instanceof MContribution ) {
			MContribution c = (MContribution) part;
			if( c.getObject() != null ) {
				Object invokeResult = ContextInjectionFactory.invoke(c.getObject(), clazz, parentContext, partContext, Boolean.TRUE);
				if (invokeResult != null && invokeResult instanceof Boolean) {// supports
					// void
					// methods
					boolean res = ((Boolean) invokeResult).booleanValue();
					if (!res) {
						return false;
					}
				}
			}
		}

		@SuppressWarnings("unchecked")
		Map<@NonNull String,@NonNull Object> contributions = (Map<@NonNull String,@NonNull Object>) part.getTransientData().get(LifecycleAddon.LIFECYCLE_TRANSIENT_KEY);
		if (contributions != null) {
			for (Object object : contributions.values()) {
				Object invokeResult = ContextInjectionFactory.invoke(object, clazz, parentContext, partContext, Boolean.TRUE);
				if (invokeResult != null && invokeResult instanceof Boolean) {// supports
																				// void
																				// methods
					boolean res = ((Boolean) invokeResult).booleanValue();
					if (!res) {
						return false;
					}
						
				}
			}
		}
		return true;
	}

	private IEclipseContext getContextForParent(MUIElement element) {
		return this.modelService.getContainingContext(element);
	}

	@Override
	public void unregisterLifecycleContribution(MUIElement element, Object contribution) {
		@SuppressWarnings("unchecked")
		Set<@NonNull Object> objects = (Set<@NonNull Object>) element.getTransientData().get(LifecycleAddon.LIFECYCLE_TRANSIENT_KEY);
		if (objects != null)
			objects.remove(contribution);
	}

}