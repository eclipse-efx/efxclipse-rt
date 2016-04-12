package org.eclipse.fx.ui.controls.form;

import org.eclipse.fx.core.Status;

import javafx.beans.property.Property;
import javafx.beans.property.ReadOnlyProperty;
import javafx.scene.Node;

public interface StatusDecorator {
	public Node decorate(ReadOnlyProperty<Status> statusProperty, Node node);
}
