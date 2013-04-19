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
package org.eclipse.fx.ui.workbench.renderers.fx.widget;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WCallback;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WPropertyChangeHandler;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WPropertyChangeHandler.WPropertyChangeEvent;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WWidget;


@SuppressWarnings("restriction")
public abstract class WWidgetImpl<N,M extends MUIElement> implements WWidget<M> {
	private N nativeWidget;
	private M domElement;
	private List<WCallback<Boolean, Void>> activationCallbacks = new ArrayList<WCallback<Boolean,Void>>();
	private boolean active;
	protected WidgetState state = WidgetState.IN_SETUP;
	
	private WPropertyChangeHandler<? extends WWidget<M>> propertyChangeHandler;
	
	protected abstract N createWidget();
	
	public WWidgetImpl() {
		
	}
	
	@Override
	public void setWidgetState(WidgetState state) {
		this.state = state;
	}
	
	@Override
	public WidgetState getWidgetState() {
		return this.state;
	}
	
	@Override
	public void activate() {
		this.active = true;
		if( activationCallbacks != null ) {
			for( WCallback<Boolean, Void> c : activationCallbacks ) {
				c.call(Boolean.TRUE);
			}	
		}
	}
	
	@Override
	public void deactivate() {
		this.active = false;
		if( activationCallbacks != null ) {
			for( WCallback<Boolean, Void> c : activationCallbacks ) {
				c.call(Boolean.FALSE);
			}	
		}
	}
	
	@Override
	public boolean isActive() {
		return active;
	}
	
	public void registerActivationCallback(WCallback<Boolean, Void> callback) {
		// Could be that we are already disposed at this point
		if( activationCallbacks != null ) {
			activationCallbacks.add(callback);	
		}
	}
	
	@PostConstruct
	protected void init() {
		getWidget(); // ensure that the widget is created
	}
	
	@PreDestroy
	void destroy() {
		if( nativeWidget != null ) {
			setUserData(null);
		}
		propertyChangeHandler = null;
		domElement = null;
		activationCallbacks.clear();
		activationCallbacks = null;
		doCleanup();
	}
	
	protected void doCleanup() {
		
	}
	
	@Override
	public final void setDomElement(M domElement) {
		this.domElement = domElement;
	}
	
	@Override
	public M getDomElement() {
		return domElement;
	}
	
	
	public N getWidget() {
		if( nativeWidget == null ) {
			nativeWidget = createWidget();
			bindProperties(nativeWidget);
			setUserData(this);
		}
		return nativeWidget;
	}
	
	protected void bindProperties(N widget) {
		
	}
	
	protected void bindProperty(final String propertyName, ObservableValue<? extends Object> value) {
		value.addListener(new ChangeListener<Object>() {

			@Override
			public void changed(ObservableValue<? extends Object> observable, Object oldValue, Object newValue) {
				fireChange(propertyName, newValue);
			}
		});
	}
	
	protected abstract void setUserData(WWidgetImpl<N,M> widget);
	
	public void setPropertyChangeHandler(WPropertyChangeHandler<? extends WWidget<M>> propertyChangeHandler) {
		this.propertyChangeHandler = propertyChangeHandler;
	}
	
	protected void fireChange(String propertyName, Object newValue) {
		if( propertyChangeHandler != null ) {
			WPropertyChangeEvent<WWidget<M>> e = new WPropertyChangeEvent<WWidget<M>>(this, propertyName, newValue);
			propertyChangeHandler.propertyObjectChanged(e);
		}
	}
}
