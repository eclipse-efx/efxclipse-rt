/*******************************************************************************
 * Copyright (c) 2015 BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.controls.tabpane.skin;

import org.eclipse.fx.ui.controls.tabpane.GenericTab;
import org.eclipse.fx.ui.controls.tabpane.GenericTabPane;
import org.eclipse.jdt.annotation.NonNull;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

/**
 * Create a wrapper for the {@link Tab}
 */
public class FXTabWrapper implements GenericTab {
	private Tab t;

	private FXTabWrapper(Tab t) {
		this.t = t;
	}

	@Override
	public Object getUserData() {
		return this.t.getUserData();
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T getNativeInstance() {
		return (T) this.t;
	}

	@Override
	public GenericTabPane getOwner() {
		TabPane tabPane = this.t.getTabPane();
		if (tabPane == null) {
			return null;
		}
		return FXTabPaneWrapper.wrap(tabPane);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.t == null) ? 0 : this.t.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FXTabWrapper other = (FXTabWrapper) obj;
		if (this.t == null) {
			if (other.t != null)
				return false;
		} else if (!this.t.equals(other.t))
			return false;
		return true;
	}

	/**
	 * Wrap a tab
	 * 
	 * @param t
	 *            the tab
	 * @return the wrapped tab
	 */
	public static @NonNull GenericTab wrap(@NonNull Tab t) {
		return new FXTabWrapper(t);
	}
}
