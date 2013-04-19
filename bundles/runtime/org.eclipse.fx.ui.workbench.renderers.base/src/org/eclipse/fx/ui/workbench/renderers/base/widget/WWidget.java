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
package org.eclipse.fx.ui.workbench.renderers.base.widget;

import java.util.List;

import org.eclipse.e4.ui.model.application.ui.MUIElement;

@SuppressWarnings("restriction")
public interface WWidget<M extends MUIElement> {
	public enum WidgetState {
		IN_SETUP,
		CREATED,
		IN_TEAR_DOWN,
		DISPOSED
	}
	
	public void setWidgetState(WidgetState state);
	public WidgetState getWidgetState();
	public void setPropertyChangeHandler(WPropertyChangeHandler<? extends WWidget<M>> handler);
	public void setDomElement(M domElement);
	public M getDomElement();
	public void addStyleClasses(List<String> classnames);
	public void addStyleClasses(String... classnames);
	public void setStyleId(String id);
	public Object getWidget();
	public void deactivate();
	public void activate();
	public boolean isActive();
	public void registerActivationCallback(WCallback<Boolean, Void> callback);
}
