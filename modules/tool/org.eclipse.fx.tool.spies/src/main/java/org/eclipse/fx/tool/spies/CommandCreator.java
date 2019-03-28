/*******************************************************************************
 * Copyright (c) Carl Zeiss Meditec AG
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Thomas Fahrmeyer (lauritziu_ii@yahoo.de) - Refactoring 
*/
package org.eclipse.fx.tool.spies;

import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.commands.MCommand;
import org.eclipse.e4.ui.model.application.commands.MCommandParameter;
import org.eclipse.e4.ui.model.application.commands.MHandler;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.osgi.framework.FrameworkUtil;

import static org.eclipse.fx.tool.spies.Constants.*;

public class CommandCreator {
    
    private final MApplication application;
    private final EModelService modelService;
        
    
    /**
     * @param application
     * @param modelService
     */
    public CommandCreator(MApplication application, EModelService modelService) {
        this.application = application;
        this.modelService = modelService;
    }



    public MCommand getOrCreateSpyCommand() {
        // DO NOT USE findElement on ModelService (it searches only in
        // MUIElements)
        for (MCommand cmd : application.getCommands()) {
            if (SPY_COMMAND.equals(cmd.getElementId())) {
                // Do nothing if command exists
                return cmd;
            }
        }

        MCommand command = modelService.createModelElement(MCommand.class);
        command.setElementId(SPY_COMMAND);
        command.setCommandName("Open a spy");
        String contributorURI = "platform:/plugin/" + FrameworkUtil.getBundle(getClass()).getSymbolicName();
        command.setContributorURI(contributorURI);
        command.setDescription("Open a spy in the E4 spy window");

        // Parameter (will be the ID of the part descriptor (ie, the full
        // qualified class name))
        // It will be received in the Handler and send by keybinding
        MCommandParameter cp = modelService.createModelElement(MCommandParameter.class);
        cp.setElementId(SPY_COMMAND_PARAM);
        cp.setName("viewPart");
        cp.setContributorURI(contributorURI);
        command.getParameters().add(cp);

        application.getCommands().add(command);

        // Create the default handler for this command
        // (will receive the parameter)
        for (MHandler hdl : application.getHandlers()) {
            if (SPY_HANDLER.equals(hdl.getElementId())) {
                // Do nothing if handler exists, return the command
                return command;
            }
        }

        // Create the handler for this command.
        MHandler handler = modelService.createModelElement(MHandler.class);
        handler.setElementId(SPY_HANDLER);
        handler.setContributionURI("bundleclass://org.eclipse.fx.tool.spies/org.eclipse.fx.tool.spies.SpyHandler");
        handler.setContributorURI("platform:/plugin/org.eclipse.fx.tool.spies");
        application.getHandlers().add(handler);

        handler.setCommand(command);

        return command;

    }
}
