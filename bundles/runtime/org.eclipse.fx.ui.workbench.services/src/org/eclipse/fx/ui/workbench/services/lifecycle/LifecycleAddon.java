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
package org.eclipse.fx.ui.workbench.services.lifecycle;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.descriptor.basic.MPartDescriptor;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.workbench.UIEvents;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.fx.ui.workbench.services.ELifecycleService;
import org.osgi.service.event.Event;

//when we are ready to ditch the tag-based stuff we simply swap the addon
/**
 * Addon to add so that lifecycle stuff is initialized
 */
public class LifecycleAddon {

	/**
	 * Key used to store the lifecycle instances inside the transient map
	 */
	public static final String LIFECYCLE_TRANSIENT_KEY = "EFX_LIFECYCLE"; //$NON-NLS-1$

	/**
	 * Tag prefix to use
	 */
	public static final String LIFECYCLE_TAG_PREFIX = "EFX_LC:"; //$NON-NLS-1$

	private final ELifecycleService lifecycleService;

	/**
	 * Create the addon instance
	 * 
	 * @param lifecycleService
	 *            the lifecycle service
	 */
	@Inject
	public LifecycleAddon(ELifecycleService lifecycleService) {
		this.lifecycleService = lifecycleService;
	}

	@PostConstruct
	void postConstruct(MApplication app, IEventBroker eventBroker) {
		TreeIterator<EObject> it = EcoreUtil.getAllContents((EObject) app, true);
		while (it.hasNext()) {
			EObject e = it.next();
			if (e instanceof MUIElement) {
				processLifecycle((MUIElement) e);
			}
		}

		eventBroker.subscribe(UIEvents.ElementContainer.TOPIC_CHILDREN, this::handleEventTopic);
		eventBroker.subscribe(UIEvents.Window.TOPIC_WINDOWS, this::handleEventTopic);
		eventBroker.subscribe(UIEvents.Perspective.TOPIC_WINDOWS, this::handleEventTopic);
	}

	@SuppressWarnings("null")
	private void processLifecycle(MUIElement element) {
		// Skip PartDescriptors
		if (element instanceof MPartDescriptor) {
			return;
		}
		List<String> tags = element.getTags();
		for (String tag : tags) {
			if (tag.startsWith(LIFECYCLE_TAG_PREFIX)) {
				this.lifecycleService.registerLifecycleURI(element, tag.substring(LIFECYCLE_TAG_PREFIX.length()));
			}
		}
	}

	private void handleEventTopic(Event e) {
		if (UIEvents.isADD(e)) {
			@SuppressWarnings("unchecked")
			Iterable<MUIElement> asIterable = (Iterable<MUIElement>) UIEvents.asIterable(e, UIEvents.EventTags.NEW_VALUE);
			asIterable.forEach(this::processLifecycle);
		}
	}
}