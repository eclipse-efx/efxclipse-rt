package org.eclipse.fx.ui.controls.form;

import java.util.Optional;

import org.eclipse.fx.core.Status;

import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.scene.Node;

public interface Binding {
	public String id();
	public ReadOnlyObjectProperty<Status> validationStatusProperty();
	public Optional<Node> decoratedNode();
	public void dispose();
}
