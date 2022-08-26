/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.viewer;


public interface TreeContentProvider<I, O> extends ContentProvider<I, O> {
	public O getChild(O parent, int index);
	public O getParent(O element);
	public int getChildSize(O parent);
	public boolean hasChildren(O element);
}
