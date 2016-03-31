package org.eclipse.fx.ui.controls.form;

import org.eclipse.fx.core.Status;

import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.scene.Node;

public interface Binding {
	public String id();
	public ReadOnlyObjectProperty<Status> validationStatusProperty();
	public Node nodeWithStatus();
	public void dispose();
}
