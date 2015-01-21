/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.code.compensator.editor;

import javafx.collections.ObservableList;
import javafx.scene.Node;

public interface Outline {
	public ObservableList<OutlineItem> getRootItems();

	public interface OutlineItem {
		public CharSequence getLabel();
		public Node getGraphic();
		public OutlineItem getParent();
		public ObservableList<OutlineItem> getChildren();
	}
}
