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

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.e4.ui.model.application.MApplicationElement;
import org.eclipse.e4.ui.model.application.commands.MHandler;
import org.eclipse.e4.ui.model.application.ui.basic.MWindow;
import org.eclipse.e4.ui.model.application.ui.basic.MWindowElement;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.fx.core.databinding.AdapterFactory;
import org.eclipse.fx.ui.modelviewer.EObjectTreeNode;
import org.eclipse.fx.ui.modelviewer.ElementDelegate;
import org.eclipse.fx.ui.modelviewer.TreeNode;
import org.eclipse.fx.ui.modelviewer.VirtualTreeNode;

import static org.eclipse.e4.ui.model.application.commands.impl.CommandsPackageImpl.Literals.*;
import static org.eclipse.e4.ui.model.application.ui.basic.impl.BasicPackageImpl.Literals.*;
import static org.eclipse.e4.ui.model.application.ui.impl.UiPackageImpl.Literals.*;

@SuppressWarnings("restriction")
public class MWindowDelegate implements ElementDelegate {
	
	public static EClass ECLASS = WINDOW;
			
	@Override
	public EClass getType() {
		return ECLASS;
	}

	@Override
	public TreeNode createTreeNode(MApplicationElement o) {
		return new EObjectTreeNode(o, "##styled##Window_#extra-info#_ - {0}", EMFProperties.value(FeaturePath.fromList(UI_LABEL__LABEL)));
	}
	
	@Override
	public IObservableList createChildren(MApplicationElement parent) {
		//TODO Main Window
		
		IObservableList handlers = AdapterFactory.<MHandler,TreeNode>convertObservableList(EMFProperties.list(HANDLER_CONTAINER__HANDLERS).observe(parent), this::createHandlerNode);
		IObservableList windows = AdapterFactory.<MWindow,TreeNode>convertObservableList(EMFProperties.list(WINDOW__WINDOWS).observe(parent), this::createWindowNode);
		IObservableList controls = AdapterFactory.<MWindowElement,TreeNode>convertObservableList(EMFProperties.list(ELEMENT_CONTAINER__CHILDREN).observe(parent), this::createWindowElementNode);
		
		WritableList l = new WritableList();
		l.add(new VirtualTreeNode("Handlers",handlers));
		l.add(new VirtualTreeNode("Windows",windows));
		l.add(new VirtualTreeNode("Controls",controls));
		
		return l;
	}

	EObjectTreeNode createHandlerNode(MHandler o) {
		return new EObjectTreeNode(o, "##styled##Handler_#extra-info#_ - {0}", EMFProperties.value(FeaturePath.fromList(HANDLER__COMMAND,COMMAND__COMMAND_NAME)));
	}

	EObjectTreeNode createWindowNode(MWindow o) {
		return new EObjectTreeNode(o, "##styled##Window_#extra-info#_ - {0}", EMFProperties.value(FeaturePath.fromList(UI_LABEL__LABEL)));
	}
	
	EObjectTreeNode createWindowElementNode(MWindowElement o) {
		return new EObjectTreeNode(o, "##styled##WindowElement_#extra-info#_ - {0}", EMFProperties.value(FeaturePath.fromList(UI_LABEL__LABEL)));
	}
}
