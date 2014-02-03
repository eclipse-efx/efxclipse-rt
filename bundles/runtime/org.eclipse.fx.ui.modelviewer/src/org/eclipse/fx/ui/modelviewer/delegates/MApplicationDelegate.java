/*******************************************************************************
 * Copyright (c) 2013 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.modelviewer.delegates;

import javax.inject.Inject;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.e4.ui.model.application.MAddon;
import org.eclipse.e4.ui.model.application.MApplicationElement;
import org.eclipse.e4.ui.model.application.commands.MBindingContext;
import org.eclipse.e4.ui.model.application.commands.MBindingTable;
import org.eclipse.e4.ui.model.application.commands.MCategory;
import org.eclipse.e4.ui.model.application.commands.MCommand;
import org.eclipse.e4.ui.model.application.commands.MHandler;
import org.eclipse.e4.ui.model.application.descriptor.basic.MPartDescriptor;
import org.eclipse.e4.ui.model.application.ui.basic.MTrimmedWindow;
import org.eclipse.e4.ui.model.application.ui.basic.MWindow;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.fx.core.databinding.AdapterFactory;
import org.eclipse.fx.core.log.Log;
import org.eclipse.fx.core.log.Logger;
import org.eclipse.fx.ui.modelviewer.EObjectTreeNode;
import org.eclipse.fx.ui.modelviewer.ElementDelegate;
import org.eclipse.fx.ui.modelviewer.TreeNode;
import org.eclipse.fx.ui.modelviewer.VirtualTreeNode;

import static org.eclipse.e4.ui.model.application.impl.ApplicationPackageImpl.Literals.*;
import static org.eclipse.e4.ui.model.application.commands.impl.CommandsPackageImpl.Literals.*;
import static org.eclipse.e4.ui.model.application.ui.impl.UiPackageImpl.Literals.*;
import static org.eclipse.e4.ui.model.application.descriptor.basic.impl.BasicPackageImpl.Literals.*;

@SuppressWarnings("restriction")
public class MApplicationDelegate implements ElementDelegate {
	@Inject
	@Log
	private Logger logger;
	
	public static EClass ECLASS = APPLICATION;
	
	@Override
	public EClass getType() {
		return ECLASS;
	}
	
	@Override
	public TreeNode createTreeNode(MApplicationElement o) {
		return null;
	}

	@Override
	public IObservableList createChildren(MApplicationElement parent) {
		WritableList l = new WritableList();
		
		IObservableList addons = AdapterFactory.<MAddon,TreeNode>convertObservableList(EMFProperties.list(APPLICATION__ADDONS).observe(parent), this::createAddonNode);
		IObservableList bindings = AdapterFactory.<MBindingContext,TreeNode>convertObservableList(EMFProperties.list(BINDINGS__BINDING_CONTEXTS).observe(parent), this::createBindingContextNode);
		IObservableList bindingTables = AdapterFactory.<MBindingTable,TreeNode>convertObservableList(EMFProperties.list(BINDING_TABLE_CONTAINER__BINDING_TABLES).observe(parent), this::createBindingTableNode);
		IObservableList handlers = AdapterFactory.<MHandler,TreeNode>convertObservableList(EMFProperties.list(HANDLER_CONTAINER__HANDLERS).observe(parent), this::createHandlerNode);
		IObservableList commands = AdapterFactory.<MCommand,TreeNode>convertObservableList(EMFProperties.list(APPLICATION__COMMANDS).observe(parent), this::createCommandNode);
		IObservableList commandCategories = AdapterFactory.<MCategory,TreeNode>convertObservableList(EMFProperties.list(APPLICATION__CATEGORIES).observe(parent), this::createCommandCategoryNode);
		IObservableList windows = AdapterFactory.<MWindow,TreeNode>convertObservableList(EMFProperties.list(ELEMENT_CONTAINER__CHILDREN).observe(parent), this::createWindowNode);
		IObservableList partDescriptors = AdapterFactory.<MPartDescriptor,TreeNode>convertObservableList(EMFProperties.list(PART_DESCRIPTOR_CONTAINER__DESCRIPTORS).observe(parent), this::createPartDescriptorNode);
		
		l.add(new VirtualTreeNode("Addons",addons));
		l.add(new VirtualTreeNode("Binding Contexts",bindings));
		l.add(new VirtualTreeNode("Binding Tables",bindingTables));
		l.add(new VirtualTreeNode("Handlers",handlers));
		l.add(new VirtualTreeNode("Commands",commands));
		l.add(new VirtualTreeNode("Command Categories",commandCategories));
		l.add(new VirtualTreeNode("Windows",windows));
		l.add(new VirtualTreeNode("Part Descriptors",partDescriptors));
		
		return l;
	}
	
	
	EObjectTreeNode createAddonNode(MAddon o) {
		return new EObjectTreeNode(o, "##styled##Addon_#extra-info#_ - {0}", EMFProperties.value(APPLICATION_ELEMENT__ELEMENT_ID));
	}
	
	EObjectTreeNode createBindingContextNode(MBindingContext o) {
		return new EObjectTreeNode(o, "##styled##Binding Contexts_#extra-info#_ - {0}", EMFProperties.value(BINDING_CONTEXT__NAME));
	}
	
	EObjectTreeNode createBindingTableNode(MBindingTable o) {
		return new EObjectTreeNode(o, "##styled##Binding Table_#extra-info#_ - {0}", EMFProperties.value(FeaturePath.fromList(BINDING_TABLE__BINDING_CONTEXT,BINDING_CONTEXT__NAME)));
	}
	
	EObjectTreeNode createHandlerNode(MHandler o) {
		return new EObjectTreeNode(o, "##styled##Handler_#extra-info#_ - {0}", EMFProperties.value(FeaturePath.fromList(HANDLER__COMMAND,COMMAND__COMMAND_NAME)));
	}
	
	EObjectTreeNode createCommandNode(MCommand o) {
		return new EObjectTreeNode(o, "##styled##Command_#extra-info#_ - {0}", EMFProperties.value(COMMAND__COMMAND_NAME));
	}
	
	EObjectTreeNode createCommandCategoryNode(MCategory o) {
		return new EObjectTreeNode(o, "##styled##Command Category_#extra-info#_ - {0}", EMFProperties.value(CATEGORY__NAME));
	}
	
	EObjectTreeNode createWindowNode(MWindow o) {
		String type = o instanceof MTrimmedWindow ? "Trimmed Window" : "Window";
		return new EObjectTreeNode(o, "##styled##"+type+"_#extra-info#_ - {0}", EMFProperties.value(UI_LABEL__LABEL));
	}
	
	EObjectTreeNode createPartDescriptorNode(MPartDescriptor o) {
		return new EObjectTreeNode(o, "##styled##Part Descriptor_#extra-info#_ - {0}", EMFProperties.value(UI_LABEL__LABEL));
	}
}