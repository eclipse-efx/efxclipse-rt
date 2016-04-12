package org.eclipse.fx.ui.controls.form;

import org.eclipse.fx.core.Status;
import org.osgi.service.component.annotations.Component;

import javafx.beans.property.ReadOnlyProperty;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

@Component
public class SimpleStatusDecorator implements StatusDecorator {

	@Override
	public Node decorate(ReadOnlyProperty<Status> statusProperty, Node node) {
		HBox box = new HBox();
		box.getStyleClass().add("status-decoration-container"); //$NON-NLS-1$

		HBox.setHgrow(node, Priority.ALWAYS);
		box.getChildren().addAll(new StatusNode(statusProperty),node);

		return box;
	}
}
