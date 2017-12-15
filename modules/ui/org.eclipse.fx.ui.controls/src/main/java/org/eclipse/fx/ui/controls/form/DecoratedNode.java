package org.eclipse.fx.ui.controls.form;

import org.eclipse.fx.core.Status;

import javafx.beans.property.ObjectProperty;

public interface DecoratedNode {
	public ObjectProperty<Status> statusProperty();
	public void setStatus(Status status);
	public Status getStatus();
}
