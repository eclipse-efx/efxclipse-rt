package org.eclipse.fx.ui.preferences.page;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.eclipse.fx.core.Memento;
import org.eclipse.fx.core.command.Command;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public abstract class FieldEditorPreferencePage extends BasePreferencePage {
	
	/**
	 * CSS Class Name for the grid holding the field editors
	 */
	public static final String PAGE_GRID_STYLE = "field-editor-grid"; //$NON-NLS-1$
	
	/**
	 * CSS Class Name for the region in which the actions buttons are added
	 */
	public static final String PAGE_ACTIONS_STYLE = "field-editor-actions"; //$NON-NLS-1$
	private BorderPane parent;
	private GridPane grid = new GridPane();
	private HBox actions = new HBox();
	private List<FieldEditor<?>> editors = new ArrayList<>();
	
	public FieldEditorPreferencePage(Memento memento, BorderPane parent) {
		super(memento);
		this.parent = parent;
		this.parent.setCenter(grid);
		this.parent.setBottom(actions);
		actions.setAlignment(Pos.BASELINE_RIGHT);
		
		grid.getStyleClass().add(PAGE_GRID_STYLE);
		actions.getStyleClass().add(PAGE_ACTIONS_STYLE);
		
		getUserAgentStylesheet().map(URL::toExternalForm).ifPresent(parent.getStylesheets()::add);
	}

	@Override
	public Command<Void> persist() {
		return Command.createCommand(() -> editors.forEach(FieldEditor::persist));
	}
	
	@Override
	public Optional<Command<Void>> restoreDefault() {
		//XXX Should we rely on the Memento to get the default values,
		//or should the specific page instance be responsible for that?
		//Currently, we rely on the Memento
		//XXX In JFace, it seems that "restore defaults" simply pushes
		//new values to the FieldEditor, without actually persisting them.
		//Pressing Restore Default then Cancel doesn't change the persisted values
		//The user actually needs to press update to force the changes
		//Do we want the same behavior here?
		return Optional.of(Command.createCommand(() -> {
			for (FieldEditor<?> fieldEditor : editors) {
				FieldEditorPreferencePage.this.memento.remove(fieldEditor.getName());
			}
			doReset();
		}));
	}
	
	@PostConstruct
	void initFieldEditors() {
		createActionButtons();
		createFieldEditors();
		reset().execute();
	}
	
	abstract protected void createFieldEditors();
	
	protected void createActionButtons() {
		addButton("Restore Defaults", this.restoreDefault());
		addButton("Apply", Optional.of(this.persist()));
	}
	
	protected void addButton(String label, Optional<Command<Void>> restoreDefault) {
		Button action = new Button(label);
		actions.getChildren().add(action);
		if (restoreDefault.isPresent()) {
			Command<Void> command = restoreDefault.get();
			action.disableProperty().bind(command.enabledProperty().not());
			action.setOnAction(event -> {
				command.evaluate();
				if (command.isEnabled()) {
					command.execute();
				}
			});
		} else {
			action.setDisable(true);
		}
	}

	@Override
	public Command<Void> reset() {
		return Command.createCommand(this::doReset);
	}
	
	void doReset() {
		this.editors.forEach(FieldEditor::load);
	}
	
	public void addField(FieldEditor<?> editor) {
		Label l = new Label();
		l.textProperty().bind(editor.labelProperty());
		
		grid.add(l, 0, editors.size());
		grid.add(editor, 1, editors.size());
		
		editors.add(editor);
		editor.setMemento(this.memento);
	}
	
	protected Optional<URL> getUserAgentStylesheet(){
		return Optional.empty();
	}
}
