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

import java.util.Collection;
import java.util.Iterator;

import javax.inject.Inject;

import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.di.UISynchronize;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.menu.MHandledMenuItem;
import org.eclipse.e4.ui.model.application.ui.menu.MMenuItem;
import org.eclipse.e4.ui.model.application.ui.menu.impl.MenuPackageImpl;
import org.eclipse.fx.ui.keybindings.KeySequence;
import org.eclipse.fx.ui.keybindings.TriggerSequence;
import org.eclipse.fx.ui.keybindings.e4.EBindingService;
import org.eclipse.fx.ui.services.Constants;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WMenuItem;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WWidget.WidgetState;

/**
 * Base renderer for {@link MMenuItem}
 * 
 * @param <N>
 *            the native widget
 */
@SuppressWarnings("restriction")
public abstract class BaseMenuItemRenderer<N> extends BaseItemRenderer<MMenuItem, WMenuItem<N>> {
	@Inject
	UISynchronize sync;

	@Override
	protected void initWidget(final MMenuItem element, WMenuItem<N> widget) {
		super.initWidget(element, widget);

		widget.setOnActionCallback(new Runnable() {

			@Override
			public void run() {
				executeAction(element, getModelContext(element));
			}
		});

		if (element instanceof MHandledMenuItem) {
			IEclipseContext lclContext = getModelContext(element);
			if( lclContext == null ) {
				getLogger().error("The model context should not be null at this point"); //$NON-NLS-1$
				return;
			}
			EBindingService service = lclContext.get(EBindingService.class);
			ParameterizedCommand command = generateParameterizedCommand((MHandledMenuItem) element, lclContext);
			if( command != null ) {
				Collection<TriggerSequence> sequences = service.getSequencesFor(command);
				if (!sequences.isEmpty()) {
					Iterator<TriggerSequence> it = sequences.iterator();
					while (it.hasNext()) {
						TriggerSequence s = it.next();
						if (s instanceof KeySequence) {
							widget.setAccelerator((KeySequence) s);
							break;
						}
					}
				}				
			}
		}
	}

	@Override
	protected void initRenderingContext(MMenuItem element, IEclipseContext context) {
		super.initRenderingContext(element, context);
		context.set(MenuPackageImpl.Literals.ITEM__TYPE.getName(), element.getType());
	}

	@Override
	public void doProcessContent(MMenuItem element) {
		// TODO Auto-generated method stub

	}

	@Override
	public void childRendered(MMenuItem parentElement, MUIElement element) {
		// nothing todo
	}

	@Override
	public void hideChild(MMenuItem container, MUIElement changedObj) {
		// nothing todo
	}

	@Override
	public void checkEnablement(final MMenuItem menuElement) {
		@SuppressWarnings("unchecked")
		final WMenuItem<N> widget = (WMenuItem<N>) menuElement.getWidget();

		// can we call canExecute in the none ui thread????
		this.sync.syncExec(new Runnable() {

			@Override
			public void run() {
				try {
					IEclipseContext context = getModelContext(menuElement);
					if (context != null && (widget.getWidgetState() == WidgetState.CREATED || widget.getWidgetState() == WidgetState.IN_SETUP)) {
						widget.setHandled(canExecute(menuElement, context));
						if( menuElement.getTags().contains(TAG_HIDE_ON_DISABLE) ) {
							BaseMenuItemRenderer.this.eventBroker.send(Constants.UPDATE_VISIBLE_WHEN_RESULT, menuElement);
						}
					}
				} catch (Throwable t) {
					// TODO Log it
					t.printStackTrace();
				}

			}
		});
	}
}
