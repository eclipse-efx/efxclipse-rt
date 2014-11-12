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

import java.util.List;

import javafx.collections.ObservableList;

public interface Outline {
	public ObservableList<OutlineItem> getRootItems();

	public interface OutlineItem {
		public String getLabel();
		public List<String> getStyle();
		public ObservableList<OutlineItem> getChildren();
	}
}
