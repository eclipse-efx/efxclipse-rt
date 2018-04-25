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
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.eclipse.fx.core.Memento;
import org.eclipse.fx.core.MultiStatus;
import org.eclipse.fx.core.Status;
import org.eclipse.fx.core.Status.State;
import org.eclipse.fx.core.command.Command;
import org.eclipse.fx.core.observable.FXObservableUtil;

import javafx.beans.binding.Bindings;
import javafx.beans.property.ReadOnlyBooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;
import javafx.css.PseudoClass;
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

	/**
	 * CSS {@link PseudoClass} applied on the error message label if the severity is
	 * {@link State#WARNING}
	 */
	public static final PseudoClass WARNING_STYLE = PseudoClass.getPseudoClass("warning");

	/**
	 * CSS {@link PseudoClass} applied on the error message label if the severity is
	 * {@link State#ERRO}
	 */
	public static final PseudoClass ERROR_STYLE = PseudoClass.getPseudoClass("error");

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
		ObservableValue<Status> pageStatus = getPageStatus();
		
		this.errorMessage.textProperty().bind(Bindings.createStringBinding(() -> pageStatus.getValue().getMessage(), pageStatus));
		this.errorMessage.managedProperty().bind(this.errorMessage.visibleProperty());
		this.errorMessage.visibleProperty().bind(this.errorMessage.textProperty().isNotEmpty());
		
		FXObservableUtil.onChange(pageStatus, status -> {
			boolean isWarning = status.getState() == State.WARNING;
			boolean isError = status.getState() == State.ERROR;
			
			this.errorMessage.pseudoClassStateChanged(WARNING_STYLE, isWarning);
			this.errorMessage.pseudoClassStateChanged(ERROR_STYLE, isError);
		});
	}

	private ObservableValue<Status> getPageStatus(){
		List<ObservableValue<Status>> allStatuses = getAllStatuses();
		
		Callable<Status> toMultistatus = () -> allStatuses.stream()
				.map(ObservableValue::getValue)
				.filter(Objects::nonNull).filter(Status::isNotOk)
				.collect(MultiStatus.toMultiStatus(getMessage(allStatuses), Status.UNKNOWN_RETURN_CODE));
		
		return Bindings.createObjectBinding(toMultistatus, allStatuses.toArray(new ObservableValue<?>[0]));
	}
	
	private List<ObservableValue<Status>> getAllStatuses() {
		return editors.stream()
				.map(FieldEditor::statusProperty)
				.collect(Collectors.toList());
	}

	private String getMessage(List<ObservableValue<Status>> allStatuses) {
		return allStatuses.stream()
			.map(ObservableValue::getValue)
			.filter(s -> s != null && !s.isOk()) 
			.map(Status::getMessage)
			.filter(m -> m != null && !m.isEmpty())
			.reduce((s1, s2) -> new StringBuilder(s1).append("\n").append(s2).toString())
			.orElse(null);
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
			// Warning & OK can be persisted; Error can't (And will block the entire page)
			return editors.stream().map(FieldEditor::statusProperty)
					.noneMatch(obs -> obs.getValue().getState() == State.ERROR);
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
