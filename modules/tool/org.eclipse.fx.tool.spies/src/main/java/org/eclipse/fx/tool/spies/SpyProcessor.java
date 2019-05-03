/*******************************************************************************
 * Copyright (c) 2014 OPCoach.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Olivier Prouvost <olivier.prouvost@opcoach.com> - initial API and implementation
 *     Olivier Prouvost <olivier.prouvost@opcoach.com> - Bug 428903 - Having a common 'debug' window for all spies
 *     Olivier Prouvost <olivier.prouvost@opcoach.com> - Bug 482250 - Add a menu 'E4 Spies' to access to the spies
 *     Olivier Prouvost <olivier.prouvost@opcoach.com> - Bug 528877 - NPE when using the windows Spies menu with version 0.18
 *     Marco Descher <marco@descher.at> - Bug 519136
 *******************************************************************************/
package org.eclipse.fx.tool.spies;

import static org.eclipse.fx.tool.spies.Constants.E4_SPIES_BINDING_TABLE;
import static org.eclipse.fx.tool.spies.Constants.SPY_COMMAND_PARAM;
import static org.eclipse.fx.tool.spies.Constants.SPY_TAG;

import java.util.List;

import javax.inject.Inject;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.InvalidRegistryObjectException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.services.log.Logger;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.commands.MBindingContext;
import org.eclipse.e4.ui.model.application.commands.MBindingTable;
import org.eclipse.e4.ui.model.application.commands.MCommand;
import org.eclipse.e4.ui.model.application.commands.MKeyBinding;
import org.eclipse.e4.ui.model.application.commands.MParameter;
import org.eclipse.e4.ui.model.application.descriptor.basic.MPartDescriptor;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

/** A base class for all spies processors */
public class SpyProcessor {

    private final CommandCreator commandCreator;

    MApplication application;
    EModelService modelService;
    Logger log;

    @Inject
    public SpyProcessor(MApplication application, EModelService modelService, Logger log) {
        this.application = application;
        this.modelService = modelService;
        this.log = log;
        this.commandCreator = new CommandCreator(application, modelService);
    }

    @Execute
    public void process(IExtensionRegistry extRegistry) {
        // This processor will read all spy extensions and automatically create
        // the command, handler and binding
        // to open this spy in the dedicated spy window.

        // First of all, it creates the spyCommand having one parameter (Id of
        // the part to display) and default handler for this command.

        MCommand command = commandCreator.getOrCreateSpyCommand();

        for (IConfigurationElement e : extRegistry.getConfigurationElementsFor("org.eclipse.fx.tool.spies.spyPart")) {
            String partName = e.getAttribute("name");
            String shortCut = e.getAttribute("shortcut");
            String iconPath = e.getAttribute("icon");
            String desc = e.getAttribute("description");

            Bundle b = Platform.getBundle(e.getNamespaceIdentifier());
            String partID = e.getAttribute("part");
            try {
                Class<?> partClass = b.loadClass(partID);
                // Bind the command with the binding, and add the view ID as
                // parameter.
                // The part class name will be the ID of the part descriptor
                bindSpyKeyBinding(shortCut, command, partID);

                // Add the descriptor in application
                addSpyPartDescriptor(partID, partName, iconPath, partClass, desc);

            } catch (InvalidRegistryObjectException e1) {
                e1.printStackTrace();
            } catch (ClassNotFoundException e1) {
                log.error("The class '" + partID + "' can not be instantiated. Check name or launch config");
                e1.printStackTrace();
            }

        }

    }

    /**
     * Helper method to get or create the binding table for all spies (where spies will add their key binding). Bind this table with the
     * org.eclipse.ui.contexts.dialogAndWindow binding context which should be present (create it if not)
     *
     * This method will probably move to the common spy plugin providing common spy stuff (see bug #428903)
     *
     * @param keySequence
     * @param cmd
     * @param paramViewId
     */
    public void bindSpyKeyBinding(String keySequence, MCommand cmd, String paramViewId) {
        // This method must :
        // search for a binding table having the binding context 'dialog and
        // window'
        // If none found, create it and also the binding context
        // Then can add the KeyBinding if not already added

        MBindingTable spyBindingTable = null;
        for (MBindingTable bt : application.getBindingTables())
            if (E4_SPIES_BINDING_TABLE.equals(bt.getElementId())) {
                spyBindingTable = bt;
            }

        // Binding table has not been yet added... Create it and bind it to
        // org.eclipse.ui.contexts.dialogAndWindow binding context
        // If this context does not yet exist, create it also.
        if (spyBindingTable == null) {

            MBindingContext bc = null;
            final List<MBindingContext> bindingContexts = application.getBindingContexts();
            if (bindingContexts.size() == 0) {
                bc = modelService.createModelElement(MBindingContext.class);
                bc.setElementId("org.eclipse.ui.contexts.window");
            } else {
                // Prefer org.eclipse.ui.contexts.dialogAndWindow but randomly
                // select another one
                // if org.eclipse.ui.contexts.dialogAndWindow cannot be found
                for (MBindingContext aBindingContext : bindingContexts) {
                    bc = aBindingContext;
                    if ("org.eclipse.ui.contexts.dialogAndWindow".equals(aBindingContext.getElementId())) {
                        break;
                    }
                }
            }

            // Can now create the binding table and bind it to this
            // context...
            spyBindingTable = modelService.createModelElement(MBindingTable.class);
            spyBindingTable.setElementId(E4_SPIES_BINDING_TABLE);
            spyBindingTable.setBindingContext(bc);
            application.getBindingTables().add(spyBindingTable);

        }

        // Search for the key binding if already present
        for (MKeyBinding kb : spyBindingTable.getBindings())
            if (keySequence.equals(kb.getKeySequence())) {
                // A binding with this key sequence is already present. Check if
                // command is the same
                if (kb.getCommand().getElementId().equals(cmd.getElementId()))
                    return;
                else {
                    // Must log an error : key binding already exists in this
                    // table but with another command
                    System.out.println("WARNING : Cannot bind the command '" + cmd.getElementId() + "' to the keySequence : " + keySequence
                            + " because the command " + kb.getCommand().getElementId() + " is already bound !");
                    return;
                }
            }

        // Key binding is not yet in table... can add it now.
        MKeyBinding binding = modelService.createModelElement(MKeyBinding.class);
        binding.setElementId(cmd.getElementId() + ".binding");
        binding.setContributorURI(cmd.getContributorURI());
        binding.setKeySequence(keySequence);

        MParameter p = modelService.createModelElement(MParameter.class);
        p.setName(SPY_COMMAND_PARAM);
        p.setValue(paramViewId);
        binding.getParameters().add(p);

        spyBindingTable.getBindings().add(binding);
        binding.setCommand(cmd);

    }

    public void addSpyPartDescriptor(String partId, String partLabel, String iconPath, Class<?> spyPartClass, String desc) {
        for (MPartDescriptor mp : application.getDescriptors()) {
            if (partId.equals(mp.getElementId())) {
                // Already added, do nothing
                return;
            }
        }

        // If descriptor not yet in descriptor list, add it now
        MPartDescriptor descriptor = modelService.createModelElement(MPartDescriptor.class);
        descriptor.setCategory("Eclipse runtime spies");
        descriptor.setElementId(partId);
        descriptor.setDescription(desc);
        descriptor.getTags().add("View");
        descriptor.getTags().add(SPY_TAG);
        descriptor.getTags().add("categoryTag:Eclipse runtime spies");

        descriptor.setLabel(partLabel);
        descriptor.setCloseable(true);
        String bundleId = FrameworkUtil.getBundle(spyPartClass).getSymbolicName();
        descriptor.setContributionURI("bundleclass://" + bundleId + "/" + spyPartClass.getCanonicalName());
        String contributorURI = "platform:/plugin/" + bundleId;
        descriptor.setContributorURI(contributorURI);
        descriptor.setIconURI(contributorURI + "/" + iconPath);
        application.getDescriptors().add(descriptor);
    }

}
