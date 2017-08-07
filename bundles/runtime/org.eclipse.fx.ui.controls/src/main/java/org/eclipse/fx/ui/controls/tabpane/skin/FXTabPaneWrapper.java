/*******************************************************************************
 * Copyright (c) 2015 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.controls.tabpane.skin;

import org.eclipse.fx.ui.controls.tabpane.GenericTab;
import org.eclipse.fx.ui.controls.tabpane.GenericTabPane;
import org.eclipse.jdt.annotation.NonNull;

import javafx.scene.control.TabPane;

/**
 * Wrapper for {@link TabPane}
 */
public class FXTabPaneWrapper implements GenericTabPane {
	private TabPane pane;

	private FXTabPaneWrapper(TabPane pane) {
		this.pane = pane;
	}

	@Override
	public void add(GenericTab t) {
		this.pane.getTabs().add(t.getNativeInstance());
	}

	@Override
	public void add(int index, GenericTab t) {
		this.pane.getTabs().add(index, t.getNativeInstance());
	}

	@Override
	public int indexOf(GenericTab t) {
		return this.pane.getTabs().indexOf(t.getNativeInstance());
	}

	@Override
	public boolean remove(GenericTab t) {
		return this.pane.getTabs().remove(t.getNativeInstance());
	}

	@Override
	public int getTabNumber() {
		return this.pane.getTabs().size();
	}

	@Override
	public void select(GenericTab draggedTab) {
		this.pane.getSelectionModel().select(draggedTab.getNativeInstance());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.pane == null) ? 0 : this.pane.hashCode());
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
		FXTabPaneWrapper other = (FXTabPaneWrapper) obj;
		if (this.pane == null) {
			if (other.pane != null)
				return false;
		} else if (!this.pane.equals(other.pane))
			return false;
		return true;
	}

	/**
	 * Wrap the given pane
	 * 
	 * @param pane
	 *            the pane to wrap
	 * @return the wrapped pane
	 */
	public static @NonNull FXTabPaneWrapper wrap(@NonNull TabPane pane) {
		return new FXTabPaneWrapper(pane);
	}
}
