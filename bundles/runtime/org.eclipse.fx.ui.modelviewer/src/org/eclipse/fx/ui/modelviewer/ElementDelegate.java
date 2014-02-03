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
package org.eclipse.fx.ui.modelviewer;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.e4.ui.model.application.MApplicationElement;
import org.eclipse.emf.ecore.EClass;

public interface ElementDelegate {
	public EClass getType();
	public IObservableList createChildren(MApplicationElement parent);
	public TreeNode createTreeNode(MApplicationElement o);
}
