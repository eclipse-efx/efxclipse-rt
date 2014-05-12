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
package org.eclipse.fx.ui.workbench.renderers.base.widget;

import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.jdt.annotation.NonNull;

public interface WDragTargetWidget {
	
	public void setDragDroppedCallback(@NonNull WCallback<DropData, Boolean> callback);
	
	public enum DropType {
		BEFORE,
		AFTER,
		
		SPLIT_LEFT,
		SPLIT_RIGHT,
		SPLIT_TOP,
		SPLIT_BOTTOM
	}
	
	public static class DropData {
		public final MUIElement reference;
		public final MUIElement sourceElement;
		public final DropType dropType;
		
		public DropData(MUIElement reference, MUIElement sourceElement, DropType dropType) {
			this.reference = reference;
			this.sourceElement = sourceElement;
			this.dropType = dropType;
		}
	}
}
