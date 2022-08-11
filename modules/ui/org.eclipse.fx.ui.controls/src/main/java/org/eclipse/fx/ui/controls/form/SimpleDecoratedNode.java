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

import org.eclipse.fx.core.Status;
import org.eclipse.fx.core.property.ValidationStatusPropertyOwner;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class SimpleDecoratedNode extends HBox implements DecoratedNode {
	private ObjectProperty<Status> statusProperty = new SimpleObjectProperty<Status>(this, "status", Status.ok()); //$NON-NLS-1$

	public SimpleDecoratedNode(Node node) {
		HBox.setHgrow(node, Priority.ALWAYS);
		getStyleClass().add("status-decoration-container"); //$NON-NLS-1$
		getChildren().addAll(new StatusNode(this.statusProperty),node);
	}

	@Override
	public ObjectProperty<Status> statusProperty() {
		return this.statusProperty;
	}

	@Override
	public void setStatus(Status status) {
		statusProperty().set(status);
	}

	@Override
	public Status getStatus() {
		return statusProperty().get();
	}

	public static SimpleDecoratedNode create(Node node, ValidationStatusPropertyOwner validationStatusOwner) {
		SimpleDecoratedNode c = new SimpleDecoratedNode(node);
		c.statusProperty().bind(validationStatusOwner.statusProperty());
		return c;
	}
}
