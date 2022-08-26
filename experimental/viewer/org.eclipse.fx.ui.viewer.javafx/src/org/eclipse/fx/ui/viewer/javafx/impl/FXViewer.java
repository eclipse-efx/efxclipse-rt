/*******************************************************************************
 * Copyright (c) 2022 BestSolution.at and others.
 *  
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *  
 * SPDX-License-Identifier: EPL-2.0
 *  
 * Contributors:
 *     BestSolution.at - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.viewer.javafx.impl;

import java.util.function.Supplier;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.Node;

import org.eclipse.fx.ui.viewer.ContentProvider;
import org.eclipse.fx.ui.viewer.Viewer;
import org.eclipse.jdt.annotation.NonNull;

public abstract class FXViewer<I,O,C extends ContentProvider<I, O>> implements Viewer<I, O, C> {
	protected ObjectProperty<C> contentProvider = new SimpleObjectProperty<>();
	
	@Override
	public void setContentProvider(@NonNull Supplier<C> contentProvider) {
		this.contentProvider.set(contentProvider.get());
	}
	
	protected ObjectProperty<C> getContentProvider() {
		return contentProvider;
	}

	@Override
	public void setInput(Supplier<I> input) {
		this.contentProvider.get().setInput(input.get());
		
	}
	
	public abstract Node getNode();
}
