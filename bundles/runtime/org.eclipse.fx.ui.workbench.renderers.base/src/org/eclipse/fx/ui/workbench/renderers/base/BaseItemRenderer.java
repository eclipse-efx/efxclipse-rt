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

import javax.inject.Inject;

import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.e4.core.commands.ECommandService;
import org.eclipse.e4.core.commands.EHandlerService;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.services.contributions.IContributionFactory;
import org.eclipse.e4.ui.internal.workbench.ContributionsAnalyzer;
import org.eclipse.e4.ui.model.application.MContribution;
import org.eclipse.e4.ui.model.application.commands.MParameter;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.menu.MHandledItem;
import org.eclipse.e4.ui.model.application.ui.menu.MItem;
import org.eclipse.fx.core.log.Log;
import org.eclipse.fx.core.log.Logger;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WWidget;

@SuppressWarnings("restriction")
public abstract class BaseItemRenderer<M extends MUIElement, W extends WWidget<M>> extends BaseRenderer<M, W> {
	
	@Inject
	@Log
	Logger logger;
	
	private ParameterizedCommand generateParameterizedCommand(
			final MHandledItem item, final IEclipseContext lclContext) {
		if( item.getCommand() == null ) {
			logger.error("No command assigned to " + item);
			return null;
		}
		
		if( item.getCommand().getElementId() == null || item.getCommand().getElementId().trim().isEmpty() ) {
			logger.error("No command id assigned to " + item.getCommand().getElementId());
			return null;
		}
		
		ECommandService cmdService = (ECommandService) lclContext
				.get(ECommandService.class.getName());
		Map<String, Object> parameters = null;
		List<MParameter> modelParms = item.getParameters();
		if (modelParms != null && !modelParms.isEmpty()) {
			parameters = new HashMap<String, Object>();
			for (MParameter mParm : modelParms) {
				parameters.put(mParm.getName(), mParm.getValue());
			}
		}
		ParameterizedCommand cmd = cmdService.createCommand(item.getCommand()
				.getElementId(), parameters);
		return cmd;
	}
	
	protected boolean canExecute(M item, IEclipseContext context) {
		if( item instanceof MContribution ) {
			MContribution contribution = (MContribution) item;
			Object object = getContributionObject(context, contribution);
			if( object == null ) {
				return false;
			}
			
			IEclipseContext runContext = context.createChild("DI-ToolItem");
			try {
				ContributionsAnalyzer.populateModelInterfaces(item, runContext, item.getClass().getInterfaces());
				runContext.set(MItem.class.getName(), item);
				return Boolean.TRUE.equals(ContextInjectionFactory.invoke(object, CanExecute.class, context.getActiveLeaf(), runContext, Boolean.TRUE));
			} finally {
				runContext.dispose();
			}
		} else if( item instanceof MHandledItem ) {
			MHandledItem handledItem = (MHandledItem) item;
			EHandlerService service = (EHandlerService) context.get(EHandlerService.class.getName());
			if( service == null ) {
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
			
			final IEclipseContext runContext = context.createChild("HI-ToolItem");
			try {
				ContributionsAnalyzer.populateModelInterfaces(item,runContext, item.getClass().getInterfaces());
				return service.canExecute(cmd, runContext);
			} finally {
				runContext.dispose();				
			}
		}
		
		return false;
	}
	
	protected void executeAction(M item, IEclipseContext context) {
		if( item instanceof MContribution ) {
			MContribution contribution = (MContribution) item;
			Object object = getContributionObject(context, contribution);
			if( object == null ) {
				return;
			}
			
			IEclipseContext runContext = context.createChild("DI-ToolItem");
			try {
				ContributionsAnalyzer.populateModelInterfaces(item, runContext, item.getClass().getInterfaces());
				runContext.set(MItem.class.getName(), item);
				ContextInjectionFactory.invoke(object,Execute.class, context.getActiveLeaf(), runContext);
			} finally {
				runContext.dispose();	
			}
		} else if( item instanceof MHandledItem ) {
			MHandledItem handledItem = (MHandledItem) item;
			EHandlerService service = (EHandlerService) context.get(EHandlerService.class.getName());
			ParameterizedCommand cmd = handledItem.getWbCommand();
			if (cmd == null) {
				cmd = generateParameterizedCommand(handledItem, context);
				handledItem.setWbCommand(cmd);
			}
			if (cmd == null) {
				logger.error("Failed to execute: " + handledItem.getCommand());
				return;
			}
			final IEclipseContext runContext = context.createChild("HI-ToolItem");
			try {
				ContributionsAnalyzer.populateModelInterfaces(item,runContext, item.getClass().getInterfaces());
				service.executeHandler(cmd, runContext);
			} finally {
				runContext.dispose();				
			}
		}
	}
	
	private Object getContributionObject(IEclipseContext context, MContribution contribution) {
		Object rv = contribution.getObject();
		if( rv == null ) {
			if( contribution.getContributionURI() == null ) {
				logger.error("No contribution uri defined");
				return null;
			}
			
			IContributionFactory cf = (IContributionFactory) context.get(IContributionFactory.class.getName());
			rv = cf.create(contribution.getContributionURI(), context);
			contribution.setObject(rv);
		}
		return rv;
	}
	
	public abstract void checkEnablement(M element);
}
