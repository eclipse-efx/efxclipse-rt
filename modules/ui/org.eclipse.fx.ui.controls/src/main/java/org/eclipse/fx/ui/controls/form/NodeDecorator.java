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
package org.eclipse.fx.ui.controls.form;

import org.eclipse.fx.core.ServiceUtils;
import org.eclipse.fx.core.Status;
import org.eclipse.fx.core.property.ValidationStatusPropertyOwner;

import javafx.beans.value.ObservableValue;
import javafx.scene.Node;

public interface NodeDecorator {
	public DecoratedNode decorate(Node node);

	public static DecoratedNode apply(NodeDecorator decorator, Node control) {
		return decorator.decorate(control);
	}

	public static DecoratedNode apply(Node control) {
		return ServiceUtils.getService(NodeDecorator.class).orElse(new GraphicDecorator()).decorate(control);
	}

	public static void apply(Node control, ValidationStatusPropertyOwner statusOwner) {
		apply(control).statusProperty().bind(statusOwner.statusProperty());
	}

	public static void apply(NodeDecorator decorator, Node control, ValidationStatusPropertyOwner statusOwner) {
		apply(decorator, control).statusProperty().bind(statusOwner.statusProperty());
	}

	public static DecoratedNode apply(Node control, ObservableValue<Status> property) {
		DecoratedNode decoratedNode = apply(control);
		decoratedNode.statusProperty().bind(property);
		return decoratedNode;
	}
}
