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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.e4.core.commands.ECommandService;
import org.eclipse.e4.core.commands.EHandlerService;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.services.contributions.IContributionFactory;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.internal.workbench.ContributionsAnalyzer;
import org.eclipse.e4.ui.model.application.MContribution;
import org.eclipse.e4.ui.model.application.commands.MParameter;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.menu.MHandledItem;
import org.eclipse.e4.ui.model.application.ui.menu.MItem;
import org.eclipse.e4.ui.workbench.UIEvents;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WWidget;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * Base renderer for item base elements
 * 
 * @param <M>
 *            the model type
 * @param <W>
 *            the native widget type
 */
@SuppressWarnings("restriction")
public abstract class BaseItemRenderer<M extends MUIElement, W extends WWidget<M>> extends BaseRenderer<M, W> {
	/**
	 * Key used to store the visible when result
	 */
	public static final String VISIBLE_WHEN_RESULT = "VISIBLE_WHEN_RESULT"; //$NON-NLS-1$
	
	@SuppressWarnings("null")
	@PostConstruct
	final void init(@NonNull IEventBroker broker) {
		registerEventListener(broker, UIEvents.UILabel.TOPIC_ICONURI);
		
		registerEventListener(broker, UIEvents.UILabel.TOPIC_LABEL);
		registerEventListener(broker, UIEvents.UILabel.TOPIC_LOCALIZED_LABEL);
		
		registerEventListener(broker, UIEvents.UILabel.TOPIC_TOOLTIP);
		registerEventListener(broker, UIEvents.UILabel.TOPIC_LOCALIZED_TOOLTIP);
		
		registerEventListener(broker, UIEvents.Item.TOPIC_SELECTED);
		registerEventListener(broker, UIEvents.Item.TOPIC_ENABLED);
		
		do_init(broker);
	}

	/**
	 * Initialize handler
	 * @param broker the event broker
	 */
	protected void do_init(@NonNull IEventBroker broker) {
		// nothing by default
	}
	
	/**
	 * Generate a parameterized command for the given {@link MHandledItem}
	 * 
	 * @param item
	 *            the item
	 * @param lclContext
	 *            the local context
	 * @return the command or <code>null</code>
	 */
	@Nullable
	protected ParameterizedCommand generateParameterizedCommand(final MHandledItem item, final IEclipseContext lclContext) {
		if (item.getCommand() == null) {
			getLogger().error("No command assigned to " + item); //$NON-NLS-1$
			return null;
		}

		if (item.getCommand().getElementId() == null || item.getCommand().getElementId().trim().isEmpty()) {
			getLogger().error("No command id assigned to " //$NON-NLS-1$
					+ item.getCommand().getElementId());
			return null;
		}

		ECommandService cmdService = (ECommandService) lclContext.get(ECommandService.class.getName());
		Map<String, Object> parameters = null;
		List<MParameter> modelParms = item.getParameters();
		if (modelParms != null && !modelParms.isEmpty()) {
			parameters = new HashMap<String, Object>();
			for (MParameter mParm : modelParms) {
				parameters.put(mParm.getName(), mParm.getValue());
			}
		}
		ParameterizedCommand cmd = cmdService.createCommand(item.getCommand().getElementId(), parameters);
		return cmd;
	}

	/**
	 * Check if the associated can be executed
	 * 
	 * @param item
	 *            the item
	 * @param context
	 *            the context
	 * @return <code>true</code> if can be executed
	 */
	protected boolean canExecute(M item, IEclipseContext context) {
		if (item instanceof MContribution) {
			MContribution contribution = (MContribution) item;
			Object object = getContributionObject(context, contribution);
			if (object == null) {
				return false;
			}

			IEclipseContext runContext = context.createChild("DI-ToolItem"); //$NON-NLS-1$
			try {
				ContributionsAnalyzer.populateModelInterfaces(item, runContext, item.getClass().getInterfaces());
				runContext.set(MItem.class.getName(), item);
				return Boolean.TRUE.equals(ContextInjectionFactory.invoke(object, CanExecute.class, context.getActiveLeaf(), runContext, Boolean.TRUE));
			} finally {
				runContext.dispose();
			}
		} else if (item instanceof MHandledItem) {
			MHandledItem handledItem = (MHandledItem) item;
			EHandlerService service = (EHandlerService) context.get(EHandlerService.class.getName());
			if (service == null) {
				return false;
			}

			ParameterizedCommand cmd = handledItem.getWbCommand();
			if (cmd == null) {
				cmd = generateParameterizedCommand(handledItem, context);
				handledItem.setWbCommand(cmd);
			}
			if (cmd == null) {
				return false;
			}

			final IEclipseContext runContext = context.createChild("HI-ToolItem"); //$NON-NLS-1$
			try {
				ContributionsAnalyzer.populateModelInterfaces(item, runContext, item.getClass().getInterfaces());
				return service.canExecute(cmd, runContext);
			} finally {
				runContext.dispose();
			}
		}

		return false;
	}

	/**
	 * Execute the associated code
	 * 
	 * @param item
	 *            the item
	 * @param context
	 *            the execution context
	 */
	protected void executeAction(M item, IEclipseContext context) {
		if (item instanceof MContribution) {
			MContribution contribution = (MContribution) item;
			Object object = getContributionObject(context, contribution);
			if (object == null) {
				return;
			}

			IEclipseContext runContext = context.createChild("DI-ToolItem"); //$NON-NLS-1$
			try {
				ContributionsAnalyzer.populateModelInterfaces(item, runContext, item.getClass().getInterfaces());
				runContext.set(MItem.class.getName(), item);
				ContextInjectionFactory.invoke(object, Execute.class, context.getActiveLeaf(), runContext, new Object());
			} finally {
				runContext.dispose();
			}
		} else if (item instanceof MHandledItem) {
			MHandledItem handledItem = (MHandledItem) item;
			EHandlerService service = (EHandlerService) context.get(EHandlerService.class.getName());
			ParameterizedCommand cmd = handledItem.getWbCommand();
			if (cmd == null) {
				cmd = generateParameterizedCommand(handledItem, context);
				handledItem.setWbCommand(cmd);
			}
			if (cmd == null) {
				getLogger().error("Failed to execute: " + handledItem.getCommand()); //$NON-NLS-1$
				return;
			}
			final IEclipseContext runContext = context.createChild("HI-ToolItem"); //$NON-NLS-1$
			try {
				ContributionsAnalyzer.populateModelInterfaces(item, runContext, item.getClass().getInterfaces());
				runContext.set(MItem.class.getName(), item);
				service.executeHandler(cmd, runContext);
			} finally {
				runContext.dispose();
			}
		}
	}

	private Object getContributionObject(IEclipseContext context, MContribution contribution) {
		Object rv = contribution.getObject();
		if (rv == null) {
			if (contribution.getContributionURI() == null) {
				getLogger().error("No contribution uri defined for " + contribution); //$NON-NLS-1$
				return null;
			}

			IContributionFactory cf = (IContributionFactory) context.get(IContributionFactory.class.getName());
			rv = cf.create(contribution.getContributionURI(), context);
			contribution.setObject(rv);
		}
		return rv;
	}

	/**
	 * Check if the element is enabled
	 * 
	 * <p>
	 * <b>Might be called on ANY-Thread</b>
	 * </p>
	 * 
	 * @param element
	 *            the model element
	 */
	public abstract void checkEnablement(M element);	
}
