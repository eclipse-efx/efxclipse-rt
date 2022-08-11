/*******************************************************************************
 * Copyright (c) 2022 BestSolution.at and others.
 *  
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *  
 * SPDX-License-Identifier: EPL-2.0
 *  
 * Contributors:
 *     BestSolution.at - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.code.compensator.nashorn;

import java.util.function.Supplier;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;

import org.eclipse.fx.code.compensator.editor.Outline.OutlineItem;

public class JSOutlineItem implements OutlineItem {
	private final CharSequence name;
	private final ObservableList<OutlineItem> list = FXCollections
			.observableArrayList();

	private final Supplier<Node> graphicSupplier;
	private final OutlineItem parent;

	public JSOutlineItem(OutlineItem parent, CharSequence name, Supplier<Node> graphicSupplier) {
		this.parent = parent;
		this.name = name;
		this.graphicSupplier = graphicSupplier;
	}

	@Override
	public OutlineItem getParent() {
		return parent;
	}

	@Override
	public CharSequence getLabel() {
		return name;
	}

	@Override
	public ObservableList<OutlineItem> getChildren() {
		return list;
	}

	@Override
	public Node getGraphic() {
		return graphicSupplier != null ? graphicSupplier.get() : null;
	}
}