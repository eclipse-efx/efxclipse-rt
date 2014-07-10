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

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

//when we are ready to ditch the tag-based stuff we simply swap the addon
/**
 * Addon to add so that lifecycle stuff is initialized
 */
public class LifecycleAddon {

	@Inject
	MApplication app;

	// @Inject
	// EModelService modelService;

	@Inject
	ELifecycleService lifecycleService;

	/**
	 * Key used to store the lifecycle instances inside the transient map
	 */
	public static final String LIFECYCLE_TRANSIENT_KEY = "EFX_LIFECYCLE"; //$NON-NLS-1$
	
	/**
	 * Tag prefix to use
	 */
	public static final String LIFECYCLE_TAG_PREFIX = "EFX_LC:"; //$NON-NLS-1$

	@SuppressWarnings("null")
	@PostConstruct
	void postConstruct() {
		TreeIterator<EObject> it = EcoreUtil.getAllContents((EObject) this.app, true);
		while (it.hasNext()) {
			EObject e = it.next();
			if (e instanceof MUIElement) {
				MUIElement element = (MUIElement) e;
				List<String> tags = element.getTags();
				for (String tag : tags) {
					if (tag.startsWith(LIFECYCLE_TAG_PREFIX)) {
						this.lifecycleService.registerLifecycleURI(element, tag.substring(LIFECYCLE_TAG_PREFIX.length()));
					}
				}
			}
		}
	}
}