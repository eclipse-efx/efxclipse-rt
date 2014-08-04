/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.viewer;


public interface TreeContentProvider<O,I> extends ContentProvider<O, I> {
	public O getChild(O parent, int index);
	public O getParent(O element);
	public int getChildSize(O parent);
	public boolean hasChildren(O element);
}
