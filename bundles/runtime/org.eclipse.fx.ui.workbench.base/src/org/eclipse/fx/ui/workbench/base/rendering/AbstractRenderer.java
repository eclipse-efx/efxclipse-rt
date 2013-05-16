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
package org.eclipse.fx.ui.workbench.base.rendering;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.model.application.ui.MUIElement;

@SuppressWarnings("restriction")
public abstract class AbstractRenderer<M extends MUIElement, C> {
		public abstract C createWidget(M element);
		
		public abstract IEclipseContext setupRenderingContext(M element);
		
		public abstract void bindWidget(M element, C widget);
		
		public abstract void processContent(M element);
		
		public abstract void postProcess(M element);
		
		public abstract void childRendered(M parentElement, MUIElement element);
		
		public abstract void preDestroy(M element);
		
		public abstract void hideChild(M container, MUIElement changedObj);
		
		public abstract void destroyWidget(M element);
		
		public abstract IEclipseContext getModelContext(MUIElement part);
		
		@SuppressWarnings("unchecked")
		public C getWidget(M element) {
			return (C) element.getWidget();
		}		
		
}