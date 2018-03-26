package org.eclipse.fx.ui.preferences.page;

import org.eclipse.fx.core.Memento;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.layout.Region;

public abstract class FieldEditor<T> extends Region {
	private StringProperty label = new SimpleStringProperty(this, "label");
	private String name;
	private Memento memento;
	
	public FieldEditor(String name, String label) {
		this.name = name;
		this.setLabel(label);
	}
	
	public FieldEditor(String name) {
		this(name, null);
	}
	
	void setMemento(Memento memento) {
		this.memento = memento;
	}
	
	protected Memento getMemento() {
		return this.memento;
	}
	
	protected String getName() {
		return this.name;
	}
	
	abstract void load();
	
	abstract void persist();
	
	public final StringProperty labelProperty() {
		return this.label;
	}

	public final String getLabel() {
		return this.labelProperty().get();
	}

	public final void setLabel(final String label) {
		this.labelProperty().set(label);
	}
	
	
}
