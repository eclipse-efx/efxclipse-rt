package org.eclipse.fx.ui.preferences.page;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.eclipse.fx.core.Memento;
import org.eclipse.fx.core.command.Command;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public abstract class FieldEditorPreferencePage extends BasePreferencePage {
	private BorderPane parent;
	private GridPane grid = new GridPane();
	private List<FieldEditor<?>> editors = new ArrayList<>();
	
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
	
	@Override
	public Optional<Command<Void>> restoreDefault() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Command<Void> reset() {
		// TODO Auto-generated method stub
		return null;
	}

	public void addField(FieldEditor<?> editor) {
		Label l = new Label();
		l.textProperty().bind(editor.labelProperty());
		
		grid.add(l, 0, editors.size());
		grid.add(editor, 1, editors.size());
		
		editors.add(editor);
		editor.setMemento(this.memento);
	}
}
