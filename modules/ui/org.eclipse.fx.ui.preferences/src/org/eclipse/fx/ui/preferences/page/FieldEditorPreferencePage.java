package org.eclipse.fx.ui.preferences.page;

import org.eclipse.fx.core.Memento;
import org.eclipse.fx.core.command.Command;

import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public abstract class FieldEditorPreferencePage extends BasePreferencePage {
	private BorderPane parent;
	
	public FieldEditorPreferencePage(Memento memento, BorderPane parent) {
		super(memento);
		this.parent = parent;
		this.parent.setCenter(new Button("hello"));
	}

	@Override
	public Command<Void> persist() {
		// TODO Auto-generated method stub
		return null;
	}

	public void addField(FieldEditor editor) {
		
	}
}
