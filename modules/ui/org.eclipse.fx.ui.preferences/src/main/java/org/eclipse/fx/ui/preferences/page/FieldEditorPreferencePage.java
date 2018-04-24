/*******************************************************************************
 * Copyright (c) 2018 BestSolution.at, EclipseSource and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *     Camille Letavernier <cletavernier@eclipsesource.com>
 *******************************************************************************/
package org.eclipse.fx.ui.preferences.page;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.eclipse.fx.core.Memento;
import org.eclipse.fx.core.Status;
import org.eclipse.fx.core.bindings.FXBindings;
import org.eclipse.fx.core.command.Command;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringExpression;
import javafx.beans.property.ReadOnlyBooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;

public abstract class FieldEditorPreferencePage extends BasePreferencePage {

	/**
	 * CSS Class Name for the grid holding the field editors
	 */
	public static final String PAGE_GRID_STYLE = "field-editor-grid"; //$NON-NLS-1$

	/**
	 * CSS Class Name for the region in which the actions buttons are added
	 */
	public static final String PAGE_ACTIONS_STYLE = "field-editor-actions"; //$NON-NLS-1$

	/**
	 * CSS Class Name for the error message label
	 */
	public static final String ERROR_MESSAGE_STYLE = "field-editor-error"; //$NON-NLS-1$

	private BorderPane parent;
	private GridPane grid;
	private HBox actions = new HBox();
	private List<FieldEditor<?>> editors = new ArrayList<>();
	private Label errorMessage = new Label();
	private Command<Void> persistCommand = new PersistCommand();

	public FieldEditorPreferencePage(Memento memento, BorderPane parent) {
		super(memento);

		this.grid = new GridPane() {
			@Override
			public String getUserAgentStylesheet() {
				return FieldEditorPreferencePage.this.getUserAgentStylesheet();
			}
		};

		errorMessage.getStyleClass().add(ERROR_MESSAGE_STYLE);

		this.parent = parent;
		this.parent.setTop(errorMessage);
		this.parent.setCenter(grid);
		this.parent.setBottom(actions);
		actions.setAlignment(Pos.BASELINE_RIGHT);

		grid.getStyleClass().add(PAGE_GRID_STYLE);
		actions.getStyleClass().add(PAGE_ACTIONS_STYLE);
		actions.setMinWidth(Region.USE_PREF_SIZE);
		grid.setMinWidth(Region.USE_PREF_SIZE);
		grid.setMinHeight(Region.USE_PREF_SIZE);
	}

	protected String getUserAgentStylesheet() {
		return null;
	}

	@Override
	public Command<Void> persist() {
		return persistCommand;
	}

	@Override
	public Optional<Command<Void>> restoreDefault() {
		return Optional.of(Command.createCommand(() -> {
			editors.forEach(FieldEditor::restoreDefaults);
		}));
	}

	@PostConstruct
	void initFieldEditors() {
		createFieldEditors();
		createActionButtons();
		bindErrorMessages();
		reset().execute();
	}

	private void bindErrorMessages() {
		List<StringExpression> errorMessages = editors.stream().map(FieldEditor::errorMessage)
				.collect(Collectors.toList());
		StringExpression concat = FXBindings.concat("\n",
				errorMessages.toArray(new ObservableValue<?>[errorMessages.size()]));
		this.errorMessage.textProperty().bind(concat);
		this.errorMessage.managedProperty().bind(this.errorMessage.visibleProperty());
		this.errorMessage.visibleProperty().bind(this.errorMessage.textProperty().isNotEmpty());
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
		int editorColumn = 0;
		int editorSpan = 2;
		if (editor.displayLabel()) {
			Label l = new Label();
			GridPane.setValignment(l, VPos.TOP);
			l.textProperty().bind(editor.labelProperty());
			l.setMinWidth(Region.USE_PREF_SIZE);
			grid.add(l, 0, editors.size());
			editorColumn = 1;
			editorSpan = 1;
		}

		grid.add(editor, editorColumn, editors.size(), editorSpan, 1);
		GridPane.setHgrow(editor, Priority.ALWAYS);

		editors.add(editor);
		editor.setMemento(this.memento);
	}
	
	private class PersistCommand implements Command<Void> {

		ObservableMap<String, String> parameters = FXCollections.observableHashMap();

		@Override
		public ReadOnlyBooleanProperty enabledProperty() {
			List<ObservableValue<Status>> allStatuses = editors.stream().map(FieldEditor::statusProperty)
					.collect(Collectors.toList());
			SimpleBooleanProperty enabled = new SimpleBooleanProperty();
			enabled.bind(
					Bindings.createBooleanBinding(this::isEnabled, allStatuses.toArray(new ObservableValue<?>[0])));
			return enabled;
		}

		@Override
		public boolean isEnabled() {
			return editors.stream().map(FieldEditor::statusProperty).allMatch(obs -> obs.getValue().isOk());
		}

		@Override
		public Optional<Void> execute() {
			if (isEnabled()) {
				editors.forEach(FieldEditor::persist);
			}
			return null;
		}

		@Override
		public ObservableMap<String, String> parameters() {
			return parameters;
		}

		@Override
		public void evaluate() {
			// Nothing
		}

	}
}
