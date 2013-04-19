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
package org.eclipse.fx.ui.workbench3;

import javafx.embed.swt.FXCanvas;
import javafx.scene.Scene;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

public abstract class FXViewPart extends ViewPart {
	private FXCanvas canvas;
	
	@Override
	public void createPartControl(Composite parent) {
		canvas = new FXCanvas(parent, SWT.NONE);
		canvas.setScene(createFxScene());
	}
	
	protected abstract Scene createFxScene();
	
	@Override
	public void setFocus() {
		canvas.setFocus();
		setFxFocus();
	}
	
	protected abstract void setFxFocus();
}
