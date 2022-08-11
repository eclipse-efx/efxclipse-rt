/*******************************************************************************
 * Copyright (c) 2022 BestSolution.at and others.
 *  
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *  
 * SPDX-License-Identifier: EPL-2.0
 *  
 * Contributors:
 *     BestSolution.at - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.code.compensator.project.vcs.git;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javafx.beans.binding.StringBinding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Side;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

import org.apache.commons.lang.text.StrSubstitutor;
import org.eclipse.fx.code.compensator.project.bt.BugTrackerInstance;
import org.eclipse.fx.code.compensator.project.bt.BugTrackerInstance.BugTrackerIssue;
import org.eclipse.fx.code.compensator.project.bt.BugTrackerInstance.CommitAction;
import org.eclipse.fx.code.compensator.project.vcs.git.GitVCSRepositoryInstance.CommitData;
import org.eclipse.fx.ui.controls.list.SimpleListCell;
import org.eclipse.fx.ui.panes.GridData;
import org.eclipse.fx.ui.panes.GridLayoutPane;

public class GitCommitDialog extends Dialog<CommitData> {
	public static final ButtonType push = new ButtonType("Push", ButtonData.APPLY);
	public static final ButtonType commit = new ButtonType("Commit", ButtonData.OK_DONE);
	public static final ButtonType cancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);
	private TextArea text;
	
	private Collection<Path> paths;
	private CheckBox gerritChange;
	private CheckBox ammendCommit;
	private List<BugData> bugData = new ArrayList<>();
	private TextArea commitMessage;
	
	private static class BugData {
		private final ComboBox<CommitAction> action;
		private final ComboBox<BugTrackerIssue> issue;
		
		public BugData(ComboBox<CommitAction> action, ComboBox<BugTrackerIssue> issue) {
			this.action = action;
			this.issue = issue;
		}
	}
	
	public GitCommitDialog(Collection<BugTrackerInstance> instance, Collection<Path> paths) {
		this.paths = paths;
		setHeaderText("Commit changes");
		getDialogPane().getStyleClass().add("commit-dialog");
		getDialogPane().getButtonTypes().addAll(push, commit, cancel);
		getDialogPane().getStylesheets().add(getClass().getResource("dialog.css").toExternalForm());
		setResultConverter(this::commitConverter);
		
		TabPane tabPane = new TabPane();
		tabPane.setSide(Side.RIGHT);
		tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		
		GridLayoutPane pane = new GridLayoutPane();
		
		{
			//FIXME need to deal with multi bug tracker per project
			//FIXME Support multiple issues
			Label l = new Label("Issue(s)");
			
			HBox box = new HBox(5);
			
			ObservableList<CommitAction> list = FXCollections.observableArrayList(BugTrackerInstance.NO_ACTION);
			list.addAll(instance.iterator().next().getCommitActions());
			ComboBox<CommitAction> action = new ComboBox<CommitAction>() {
				@Override
				protected double computeMinWidth(double height) {
					return computePrefWidth(height);
				}
			};
			action.setButtonCell(new SimpleListCell<CommitAction>( 
					o -> o.getLabel(), 
					o -> o.getGraphic(),
					o -> Collections.emptyList()));
			action.setCellFactory( e -> new SimpleListCell<CommitAction>( 
					o -> o.getLabel(), 
					o -> o.getGraphic(),
					o -> Collections.emptyList()) );
			action.setItems(list);
			action.getSelectionModel().select(BugTrackerInstance.NO_ACTION);
			
			ComboBox<BugTrackerIssue> bug = new ComboBox<>();
			bug.setButtonCell(new SimpleListCell<BugTrackerIssue>(
					o -> o.getId() + " - " + o.getTitle(),
					o -> Collections.emptyList()));
			bug.setCellFactory( v -> new SimpleListCell<BugTrackerIssue>(
					o -> o.getId() + " - " + o.getTitle(),
					o -> Collections.emptyList()));
			bug.setMaxWidth(Double.MAX_VALUE);
			bug.setItems(instance.iterator().next().getIssues());
			HBox.setHgrow(bug, Priority.ALWAYS);
			
			bugData.add(new BugData(action,bug));
			
			Button b = new Button("New Bug ...") {
				protected double computeMinWidth(double height) {
					return  computePrefWidth(height);
				}
			};
			box.getChildren().addAll(action, bug, b);
			
			GridLayoutPane.setConstraint(box, new GridData(GridData.FILL_HORIZONTAL));
			pane.getChildren().addAll(l, box);
		}
		
		{
			Label l = new Label("Message");
			
			text = new TextArea();
			
			GridLayoutPane.setConstraint(text, new GridData(GridData.FILL_HORIZONTAL));
			
			pane.getChildren().addAll(l, text);
		}
		
		{
			HBox box = new HBox(5);
			
			gerritChange = new CheckBox("Gerrit change id");
			ammendCommit = new CheckBox("Ammend");
			box.getChildren().addAll(gerritChange, ammendCommit);
			GridLayoutPane.setConstraint(box, new GridData(GridData.FILL_HORIZONTAL));
			
			pane.getChildren().addAll(box);
		}
		
		Tab commitData = new Tab("Data", pane);
		tabPane.getTabs().add(commitData);
		
		commitMessage = new TextArea();
		commitMessage.setEditable(false);
		
		commitMessage.textProperty().bind(new StringBinding() {
			
			{
				bind(text.textProperty(), gerritChange.selectedProperty(), bugData.get(0).action.getSelectionModel().selectedItemProperty(), bugData.get(0).issue.getSelectionModel().selectedItemProperty());
			}
			
			@Override
			protected String computeValue() {
				return calculateMessage();
			}
			
		});

		Tab finalCommit = new Tab("Summary",commitMessage);
		tabPane.getTabs().add(finalCommit);
		
		getDialogPane().setContent(tabPane);
	}
	
	private String calculateMessage() {
		String message = this.text.getText();
		
		List<String> data = new ArrayList<>();
		for( BugData b : bugData ) {
			CommitAction a = b.action.getSelectionModel().getSelectedItem();
			BugTrackerIssue issue = b.issue.getSelectionModel().getSelectedItem();
			if( issue != null && a != BugTrackerInstance.NO_ACTION ) {
				Map<String, String> map = new HashMap<>();
				map.put("id", issue.getId());
				map.put("title", issue.getTitle());
				data.add( StrSubstitutor.replace(a.getMessageTemplate(), map));
			}
		}
		
		
		if( ! data.isEmpty() ) {
			if( ! message.isEmpty() ) {
				message += "\n\n";
			}
			message += data.stream().collect(Collectors.joining(""));
		}
		
		if( gerritChange.isSelected() ) {
			message += "\nChange-Id: I0000000000000000000000000000000000000000";
		}
		
		return message;
	}
	
	private CommitData commitConverter(ButtonType type) {
		if( type == cancel ) {
			return CommitData.CANCEL;
		} else {
			return new CommitData(type, calculateMessage(), paths, ammendCommit.isSelected(), gerritChange.isSelected());
		}
	}
	
}
