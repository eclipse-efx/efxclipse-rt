/*******************************************************************************
 * Copyright (c) 2012 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.demo.media.addon;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javafx.scene.Node;
import javafx.scene.layout.BorderPane;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.di.extensions.Preference;
import org.eclipse.e4.ui.model.application.ui.advanced.MPerspective;
import org.eclipse.fx.ui.animation.pagetransition.CenterSwitchAnimation;
import org.eclipse.fx.ui.animation.pagetransition.animation.FadeAnimation;
import org.eclipse.fx.ui.animation.pagetransition.animation.PageChangeAnimation;
import org.eclipse.fx.ui.animation.pagetransition.animation.ZoomSlideAnimation;
import org.eclipse.fx.ui.workbench.renderers.base.services.PerspectiveTransitionService;

@SuppressWarnings("restriction")
public class PerspectiveAnimationAddon {
	
	@PostConstruct
	void init(IEclipseContext context) {
		TransitionImpl impl = ContextInjectionFactory.make(TransitionImpl.class, context);
		context.set(PerspectiveTransitionService.class, impl);
		context.set(TransitionImpl.class, impl);
	}
	
	public static class TransitionImpl implements PerspectiveTransitionService<BorderPane, Node> {
		private Map<String, CenterSwitchAnimation> animations = new HashMap<String, CenterSwitchAnimation>();
		
		@Inject
		@Preference("perspectiveTransition")
		@Optional
		private String transition;
		
		public TransitionImpl() {
			animations.put("FadeAnimation", new FadeAnimation());
			animations.put("PageChangeAnimation", new PageChangeAnimation());
			animations.put("ZoomSlideAnimation", new ZoomSlideAnimation());
		}

		public Map<String, CenterSwitchAnimation> getAnimations() {
			return Collections.unmodifiableMap(animations);
		}
		
		@Override
		public AnimationDelegate<BorderPane, Node> getDelegate(MPerspective fromPerspective, MPerspective toPerspective) {
			if( transition != null ) {
				final String animation;
				if(  "perspective.configuration".equals(toPerspective.getElementId()) ||  "perspective.configuration".equals(fromPerspective.getElementId())) {
					animation= "FadeAnimation";
				} else {
					animation = transition;
				}
				
				return new AnimationDelegate<BorderPane, Node>() {
					@Override
					public void animate(BorderPane container, Node control, Runnable r) {
						animations.get(animation).animate(container, control, r);
					}
				};
			}
			
			return null;
		}	
	}
}
