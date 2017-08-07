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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WCallback;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WPropertyChangeHandler;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WPropertyChangeHandler.WPropertyChangeEvent;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WWidget;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * Base class for all widgets
 *
 * @param <N>
 *            the native type
 * @param <M>
 *            the model type
 */
public abstract class WWidgetImpl<N, M extends MUIElement> implements WWidget<M> {
	private N nativeWidget;

	@Nullable
	private M domElement;
	private List<WCallback<Boolean, Void>> activationCallbacks = new ArrayList<WCallback<Boolean, Void>>();
	private boolean active;
	/**
	 * The current widget state
	 */
	@SuppressWarnings("all")
	@NonNull
	protected WidgetState state = WidgetState.IN_SETUP;

	private WPropertyChangeHandler<? extends WWidget<M>> propertyChangeHandler;

	private Set<WPropertyChangeEvent<@NonNull WWidget<M>>> currentPropertyChanges = new HashSet<>();

	/**
	 * @return the widget
	 */
	@NonNull
	protected abstract N createWidget();

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
		if (this.activationCallbacks != null) {
			for (WCallback<Boolean, Void> c : this.activationCallbacks) {
				c.call(Boolean.TRUE);
			}
		}
	}

	@Override
	public void deactivate() {
		this.active = false;
		if (this.activationCallbacks != null) {
			for (WCallback<Boolean, Void> c : this.activationCallbacks) {
				c.call(Boolean.FALSE);
			}
		}
	}

	@Override
	public boolean isActive() {
		return this.active;
	}

	@Override
	public void registerActivationCallback(WCallback<Boolean, Void> callback) {
		// Could be that we are already disposed at this point
		if (this.activationCallbacks != null) {
			this.activationCallbacks.add(callback);
		}
	}

	/**
	 * Initialize the widget (called by DI)
	 */
	@PostConstruct
	protected void init() {
		getWidget(); // ensure that the widget is created
	}

	@PreDestroy
	void destroy() {
		doCleanup();
		if (this.nativeWidget != null) {
			setUserData(null);
		}
		this.propertyChangeHandler = null;
		this.domElement = null;
		this.activationCallbacks.clear();
		this.activationCallbacks = null;
	}

	/**
	 * Cleanup code to run
	 */
	protected void doCleanup() {
		// empty by default
	}

	@Override
	public final void setDomElement(M domElement) {
		this.domElement = domElement;
	}

	@Override
	public M getDomElement() {
		return this.domElement;
	}

	@Override
	public N getWidget() {
		N widget = this.nativeWidget;
		if (widget == null) {
			widget = this.nativeWidget = createWidget();
			bindProperties(this.nativeWidget);
			setUserData(this);
		}
		return widget;
	}

	/**
	 * Setup property bindings
	 *
	 * @param widget
	 *            the widget
	 */
	protected void bindProperties(N widget) {
		// empty by default
	}

	/**
	 * Bind a property and fire change events
	 *
	 * @param propertyName
	 *            the property to bound to
	 * @param value
	 *            the property to attach a listener
	 */
	protected void bindProperty(@NonNull final String propertyName, @NonNull ObservableValue<? extends Object> value) {
		value.addListener(new ChangeListener<Object>() {

			@Override
			public void changed(ObservableValue<? extends Object> observable, Object oldValue, Object newValue) {
				fireChange(propertyName, newValue);
			}
		});
	}

	/**
	 * Associate user data with the widget
	 *
	 * @param widget
	 *            the widget
	 */
	protected abstract void setUserData(WWidgetImpl<N, M> widget);

	@Override
	public void setPropertyChangeHandler(WPropertyChangeHandler<? extends WWidget<M>> propertyChangeHandler) {
		this.propertyChangeHandler = propertyChangeHandler;
	}

	/**
	 * Check if there already property change in progress for the given property
	 *
	 * @param propertyName
	 *            the property name
	 * @return <code>true</code> if property is currently changeing
	 */
	protected boolean isPropertyChangeInProgress(@NonNull String propertyName) {
		for( WPropertyChangeEvent<@NonNull WWidget<M>> e : this.currentPropertyChanges ) {
			if( propertyName.equals(e.propertyname) ) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Fire a change event
	 *
	 * @param propertyName
	 *            the property modified
	 * @param newValue
	 *            the new value
	 */
	protected final void fireChange(@NonNull String propertyName, @Nullable Object newValue) {
		if (this.propertyChangeHandler != null) {
			WPropertyChangeEvent<@NonNull WWidget<M>> e = new WPropertyChangeEvent<@NonNull WWidget<M>>(this, propertyName, newValue);
			try {
				this.currentPropertyChanges.add(e);
				this.propertyChangeHandler.propertyObjectChanged(e);
			} finally {
				this.currentPropertyChanges.remove(e);
			}
		}
	}
}
