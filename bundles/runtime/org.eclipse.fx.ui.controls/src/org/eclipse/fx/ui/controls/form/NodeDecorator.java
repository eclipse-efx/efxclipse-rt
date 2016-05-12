package org.eclipse.fx.ui.controls.form;

import org.eclipse.fx.core.Status;
import org.eclipse.fx.core.Util;
import org.eclipse.fx.core.property.ValidationStatusPropertyOwner;

import javafx.beans.value.ObservableValue;
import javafx.scene.Node;

public interface NodeDecorator {
	public DecoratedNode decorate(Node node);

	public static DecoratedNode apply(NodeDecorator decorator, Node control) {
		return decorator.decorate(control);
	}

	public static DecoratedNode apply(Node control) {
		return Util.getService(NodeDecorator.class).orElseGet(() -> new GraphicDecorator()).decorate(control);
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
