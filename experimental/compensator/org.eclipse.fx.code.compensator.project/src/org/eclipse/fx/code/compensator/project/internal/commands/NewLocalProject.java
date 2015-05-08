package org.eclipse.fx.code.compensator.project.internal.commands;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import javafx.collections.FXCollections;
import javafx.scene.Node;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.fx.code.compensator.model.workbench.BugTracker;
import org.eclipse.fx.code.compensator.model.workbench.LocalProject;
import org.eclipse.fx.code.compensator.model.workbench.VCSRepository;
import org.eclipse.fx.code.compensator.model.workbench.Workbench;
import org.eclipse.fx.code.compensator.model.workbench.WorkbenchFactory;
import org.eclipse.fx.code.compensator.project.ProjectService;
import org.eclipse.fx.code.compensator.project.vcs.VersionControlService;
import org.eclipse.fx.core.URI;
import org.eclipse.fx.core.command.CommandService;
import org.eclipse.fx.core.di.ScopedObjectFactory;
import org.eclipse.fx.core.di.Service;
import org.eclipse.fx.ui.controls.stage.DefaultTrimmedWindowPane;
import org.eclipse.fx.ui.dialogs.TitleAreaDialog;
import org.eclipse.fx.ui.panes.GridData;
import org.eclipse.fx.ui.panes.GridLayoutPane;
import org.eclipse.fx.ui.services.resources.GraphicsLoader;

public class NewLocalProject {
	TextField nameField;
	ComboBox<ProjectService> projectType;
	ComboBox<VersionControlService> repoType;
	TextField repoUrl;
	TextField repoLocalDir;
	TextField repoUser;
	TextField repoPassword;
	ComboBox<String> bugtrackerType;
	TextField bugTrackerUrl;
	TextField bugTrackerUser;
	TextField bugTrackerPassword;
	
	@Execute
	public void execute(Stage parent, Workbench workbench,
			@Service List<ProjectService> projectServices,
			@Service List<VersionControlService> versionControl,
			CommandService cmdService,
			GraphicsLoader loader,
			ScopedObjectFactory objFactory) {
		TitleAreaDialog dialog = new TitleAreaDialog(parent,"Create new local project","New local project","Provide in the fields below all informations to setup a local project","new_project_dialog") {
			
			@Override
			protected Node createDialogContent() {
				return NewLocalProject.this.createDialogContent(projectServices, versionControl, loader);
			}
			
			protected DefaultTrimmedWindowPane getCustomWindowPane() {
				return new DefaultTrimmedWindowPane(new StackPane());
			}
		};
		
		if( dialog.open() == TitleAreaDialog.OK_BUTTON ) {
			LocalProject lp = WorkbenchFactory.eINSTANCE.createLocalProject();
			lp.setProjectId(UUID.randomUUID().toString());
			lp.setName(nameField.getText());
			lp.setProjectType(projectType.getValue().getId());

			VCSRepository r = WorkbenchFactory.eINSTANCE.createVCSRepository();
			r.setRepoType(repoType.getValue().getId());
			r.setRepoURI(repoUrl.getText());
			r.setLocalURI(repoLocalDir.getText());
			r.setRepoUsername(repoUser.getText());
			r.setRepoPassword(repoPassword.getText());
			lp.getVcsRepositoryList().add(r);

			BugTracker t = WorkbenchFactory.eINSTANCE.createBugTracker();
			t.setBugtrackerType(bugtrackerType.getValue());
			t.setBugtrackerUrl(bugTrackerUrl.getText());
			t.setBugtrackerUsername(bugTrackerUser.getText());
			t.setBugtrackerPassword(bugTrackerPassword.getText());
			lp.getBugTrackerList().add(t);

			workbench.getProjectList().add(lp);

			cmdService.execute("org.eclipse.fx.code.compensator.app.command.openproject", Collections.singletonMap("projectId", lp.getProjectId()));
		}
		
	}
	
	private Node createDialogContent(List<ProjectService> projectServices, List<VersionControlService> versionControl, GraphicsLoader loader) {
		GridLayoutPane p = new GridLayoutPane();
		p.setMinWidth(600);


		{
			p.getChildren().add(new Label("Name"));
			nameField = new TextField();
			GridLayoutPane.setConstraint(nameField, new GridData(
					GridData.FILL_HORIZONTAL));
			p.getChildren().add(nameField);
		}

		{
			p.getChildren().add(new Label("Project Type"));
			projectType = new ComboBox<>();
			projectType.setItems(FXCollections.observableArrayList(projectServices));
			projectType.setCellFactory(param -> new ProjectTypeCell(loader));
			projectType.setButtonCell(new ProjectTypeCell(loader));
			projectType.getSelectionModel().select(0);
			GridLayoutPane.setConstraint(projectType, new GridData(
					GridData.FILL_HORIZONTAL));

			p.getChildren().add(projectType);

		}

		{
			TitledPane t = new TitledPane("Repository", null);
			t.setCollapsible(false);
			GridLayoutPane.setConstraint(t, new GridData(
					GridData.FILL_HORIZONTAL));
			p.getChildren().add(t);
			GridLayoutPane pp = new GridLayoutPane();

			{
				pp.getChildren().add(new Label("Type"));
				repoType = new ComboBox<>();
				repoType.setCellFactory(param -> new RepoTypeCell());
				repoType.setButtonCell(new RepoTypeCell());
				repoType.setItems(FXCollections.observableArrayList(versionControl));
				repoType.getSelectionModel().select(0);

				GridLayoutPane.setConstraint(repoType, new GridData(
						GridData.FILL_HORIZONTAL));
				pp.getChildren().add(repoType);
			}

			{
				pp.getChildren().add(new Label("Url"));
				repoUrl = new TextField();
				GridLayoutPane.setConstraint(repoUrl, new GridData(
						GridData.FILL_HORIZONTAL));
				pp.getChildren().add(repoUrl);
			}

			{
				pp.getChildren().add(new Label("Local directory"));
				repoLocalDir = new TextField();
				GridLayoutPane.setConstraint(repoLocalDir, new GridData(
						GridData.FILL_HORIZONTAL));
				pp.getChildren().add(repoLocalDir);
			}

			{
				pp.getChildren().add(new Label("User"));
				repoUser = new TextField();
				GridLayoutPane.setConstraint(repoUser, new GridData(
						GridData.FILL_HORIZONTAL));
				pp.getChildren().add(repoUser);
			}

			{
				pp.getChildren().add(new Label("Password"));
				repoPassword = new PasswordField();
				GridLayoutPane.setConstraint(repoPassword, new GridData(
						GridData.FILL_HORIZONTAL));
				pp.getChildren().add(repoPassword);
			}
			t.setContent(pp);
		}

		{
			TitledPane t = new TitledPane("Bugtracking", null);
			t.setCollapsible(false);
			GridLayoutPane.setConstraint(t, new GridData(
					GridData.FILL_HORIZONTAL));
			p.getChildren().add(t);
			GridLayoutPane pp = new GridLayoutPane();

			{
				pp.getChildren().add(new Label("Type"));
				bugtrackerType = new ComboBox<>();
				GridLayoutPane.setConstraint(bugtrackerType, new GridData(
						GridData.FILL_HORIZONTAL));
				pp.getChildren().add(bugtrackerType);
			}

			{
				pp.getChildren().add(new Label("Url"));
				bugTrackerUrl = new TextField();
				GridLayoutPane.setConstraint(bugTrackerUrl, new GridData(
						GridData.FILL_HORIZONTAL));
				pp.getChildren().add(bugTrackerUrl);
			}

			{
				pp.getChildren().add(new Label("User"));
				bugTrackerUser = new TextField();
				GridLayoutPane.setConstraint(bugTrackerUser, new GridData(
						GridData.FILL_HORIZONTAL));
				pp.getChildren().add(bugTrackerUser);
			}

			{
				pp.getChildren().add(new Label("Password"));
				bugTrackerPassword = new PasswordField();
				GridLayoutPane.setConstraint(bugTrackerPassword, new GridData(
						GridData.FILL_HORIZONTAL));
				pp.getChildren().add(bugTrackerPassword);
			}

			t.setContent(pp);
		}
		
		return p;
	}

	static class ProjectTypeCell extends ListCell<ProjectService> {
		private final GraphicsLoader loader;

		public ProjectTypeCell(GraphicsLoader loader) {
			this.loader = loader;
		}

		@Override
		protected void updateItem(ProjectService item, boolean empty) {
			super.updateItem(item, empty);
			if( item != null && ! empty ) {
				setText(item.getLabel());
				URI iconUri = item.getIconUri();
				if( iconUri != null ) {
					setGraphic(loader.getGraphicsNode(iconUri));
				}
			} else {
				setText(null);
				setGraphic(null);
			}
		}
	}

	static class RepoTypeCell extends ListCell<VersionControlService> {
		@Override
		protected void updateItem(VersionControlService item, boolean empty) {
			super.updateItem(item, empty);
			if( item != null && ! empty ) {
				setText(item.getLabel());
			}
		}
	}
}
