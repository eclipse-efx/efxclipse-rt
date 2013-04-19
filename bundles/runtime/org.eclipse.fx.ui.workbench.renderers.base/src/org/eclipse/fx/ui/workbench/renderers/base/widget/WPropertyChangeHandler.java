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

public interface WPropertyChangeHandler<W extends WWidget<?>> {
	public static class WPropertyChangeEvent<W extends WWidget<?>> {
		public final String propertyname;
		public final W widget;
		public final Object newValue;
		
		public WPropertyChangeEvent(W widget, String propertyname, Object newValue) {
			this.widget = widget;
			this.propertyname = propertyname;
			this.newValue = newValue;
		}
	}
	
	public void propertyObjectChanged(WPropertyChangeEvent<W> event);
}
