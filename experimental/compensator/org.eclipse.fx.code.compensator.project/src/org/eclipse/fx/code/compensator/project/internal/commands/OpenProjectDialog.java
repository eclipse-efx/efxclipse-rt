package org.eclipse.fx.code.compensator.project.internal.commands;

import java.util.Collections;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.fx.code.compensator.model.workbench.Project;
import org.eclipse.fx.code.compensator.model.workbench.Workbench;
import org.eclipse.fx.code.compensator.project.ProjectService;
import org.eclipse.fx.core.command.CommandService;
import org.eclipse.fx.core.di.Service;
import org.eclipse.fx.ui.controls.list.SimpleListCell;
import org.eclipse.fx.ui.controls.styledtext.StyledString;
import org.eclipse.fx.ui.controls.styledtext.StyledStringSegment;

public class OpenProjectDialog {
	@Execute
	public void open(Stage parent, Workbench workbench, CommandService cmdService, @Service List<ProjectService> projectServiceList) {
		Dialog<ButtonType> d = new Dialog<>();
		d.initOwner(parent);
		d.setHeaderText("Open project");
		d.getDialogPane().getStyleClass().add("open_project_dialog");
		d.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
		d.setTitle("Open Project");

		ListView<Project> list = new ListView<>();
		list.setMinWidth(600);
		list.setCellFactory(v -> new SimpleListCell<Project>( p -> labelExtractor(p, projectServiceList), p -> cssProvider(p,projectServiceList)));
		list.setItems(FXCollections.observableArrayList(workbench.getProjectList()));
		d.getDialogPane().setContent(list);
		d.showAndWait().ifPresent(e -> {
			if( e == ButtonType.OK ) {
				if( list.getSelectionModel().getSelectedItem() != null ) {
					cmdService.execute("org.eclipse.fx.code.compensator.app.command.openproject", Collections.singletonMap("projectId", list.getSelectionModel().getSelectedItem().getProjectId()));
				}
			}
		});
	}

	private static CharSequence labelExtractor(Project p, List<ProjectService> services) {
		StyledString s = new StyledString();
		s.getSegmentList().add(new StyledStringSegment(p.getName(), "cell-text-default"));
		s.getSegmentList().add(new StyledStringSegment(" - " + services.stream().filter( ps -> ps.applies(p)).findFirst().map(ps -> ps.getLabel()).get(), "cell-text-extra"));
		return s;
	}

	private static List<String> cssProvider(Project p, List<ProjectService> services) {
		return Collections.singletonList(services.stream().filter( ps -> ps.applies(p)).findFirst().map(ps -> ps.getProjectType()).get());
	}
}