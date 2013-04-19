package org.eclipse.fx.ui.workbench.renderers.base.services;

import org.eclipse.e4.ui.model.application.ui.basic.MWindow;


@SuppressWarnings("restriction")
public interface WindowTransitionService<C> {
	public interface AnimationDelegate<C> {
		public void animate(C window );
	}
	
	public AnimationDelegate<C> getShowDelegate(MWindow window);
	public AnimationDelegate<C> getHideDelegate(MWindow window);
}
