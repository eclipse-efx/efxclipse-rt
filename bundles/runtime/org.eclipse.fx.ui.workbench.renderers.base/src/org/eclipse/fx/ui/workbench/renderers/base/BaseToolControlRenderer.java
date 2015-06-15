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
package org.eclipse.fx.ui.workbench.renderers.base;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.services.contributions.IContributionFactory;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.menu.MToolControl;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WToolControl;

/**
 * Base renderer for {@link MToolControl}
 * 
 * @param <N>
 *            the native widget type
 */
@SuppressWarnings("restriction")
public abstract class BaseToolControlRenderer<N> extends BaseRenderer<MToolControl, WToolControl<N>> {
	private static final String LOCAL_CONTEXT = "efx_toolcontrol_context"; //$NON-NLS-1$

	@Override
	protected void doProcessContent(MToolControl element) {
		WToolControl<N> widget = getWidget(element);
		if( widget == null ) {
			getLogger().error("Could not find widget for '"+element+"'"); //$NON-NLS-1$ //$NON-NLS-2$
			return;
		}

		Class<?> cl = widget.getWidget().getClass();
		IEclipseContext modelContext = getModelContext(element);
		if( modelContext == null ) {
			getLogger().error("The model context is null - impossible to proceed"); //$NON-NLS-1$
			return;
		}
		IEclipseContext context = modelContext.createChild("ToolControl"); //$NON-NLS-1$
		do {
			context.set(cl.getName(), widget.getWidget());
			cl = cl.getSuperclass();
		} while (!cl.getName().equals("java.lang.Object")); //$NON-NLS-1$
		
		context.set(MToolControl.class.getName(), element);

		IContributionFactory contributionFactory = (IContributionFactory) context.get(IContributionFactory.class.getName());
		Object newPart = contributionFactory.create(element.getContributionURI(), context);
		element.setObject(newPart);
		element.getTransientData().put(LOCAL_CONTEXT, context);
	}

	@Override
	public void childRendered(MToolControl parentElement, MUIElement element) {
		// no child
	}

	@Override
	public void hideChild(MToolControl container, MUIElement changedObj) {
		// no child
	}

	@Override
	public void destroyWidget(MToolControl element) {
		super.destroyWidget(element);
		IEclipseContext local = (IEclipseContext) element.getTransientData().get(LOCAL_CONTEXT);
		if (local != null) {
			local.dispose();
			element.getTransientData().remove(LOCAL_CONTEXT);
		}
	}
}