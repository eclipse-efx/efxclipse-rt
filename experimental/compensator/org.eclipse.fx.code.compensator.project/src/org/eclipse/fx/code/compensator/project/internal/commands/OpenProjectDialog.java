package org.eclipse.fx.code.compensator.project.internal.commands;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.fx.code.compensator.model.workbench.Project;
import org.eclipse.fx.code.compensator.model.workbench.Workbench;
import org.eclipse.fx.code.compensator.project.ProjectService;
import org.eclipse.fx.core.command.CommandService;
import org.eclipse.fx.core.di.Service;
import org.eclipse.fx.ui.controls.dialog.TitleAreaDialog;
import org.eclipse.fx.ui.controls.list.SimpleListCell;
import org.eclipse.fx.ui.controls.styledtext.StyledString;
import org.eclipse.fx.ui.controls.styledtext.StyledStringSegment;
//import org.eclipse.fx.ui.dialogs.TitleAreaDialog;
import org.eclipse.fx.ui.services.dialog.LightWeightDialogService;
import org.eclipse.fx.ui.services.dialog.LightWeightDialogService.ModalityScope;

import javafx.collections.FXCollections;
import javafx.scene.control.ListView;

public class OpenProjectDialog {
	@Execute
	public void open(LightWeightDialogService dialogService) {
		dialogService.openDialog(OpenProjectDialogImpl.class, ModalityScope.WINDOW);
	}

	static class OpenProjectDialogImpl extends TitleAreaDialog {
		private ListView<Project> list;
		private final CommandService cmdService;

		@Inject
		public OpenProjectDialogImpl(Workbench workbench, CommandService cmdService,
				@Service List<ProjectService> projectServiceList) {
			super("Open project", "Open project", "Open an existing project");
			this.cmdService = cmdService;
			addDefaultButtons();
			setMaxWidth(500);
			setMaxHeight(500);
			setId("open-project-dialog");

			list = new ListView<>();
			list.setMinWidth(600);
			list.setCellFactory(v -> new SimpleListCell<Project>(p -> labelExtractor(p, projectServiceList),
					p -> cssProvider(p, projectServiceList)));
			list.setItems(FXCollections.observableArrayList(workbench.getProjectList()));
			setClientArea(list);
		}

		@Override
		protected void handleOk() {
			if (list.getSelectionModel().getSelectedItem() != null) {
				cmdService.execute("org.eclipse.fx.code.compensator.app.command.openproject", Collections
						.singletonMap("projectId", list.getSelectionModel().getSelectedItem().getProjectId()));
				super.handleOk();
			}
		}
	}

	private static CharSequence labelExtractor(Project p, List<ProjectService> services) {
		StyledString s = new StyledString();
		s.getSegmentList().add(new StyledStringSegment(p.getName(), "cell-text-default"));
		s.getSegmentList()
				.add(new StyledStringSegment(" - "
						+ services.stream().filter(ps -> ps.applies(p)).findFirst().map(ps -> ps.getLabel()).get(),
						"cell-text-extra"));
		return s;
	}

	private static List<String> cssProvider(Project p, List<ProjectService> services) {
		return Collections.singletonList(
				services.stream().filter(ps -> ps.applies(p)).findFirst().map(ps -> ps.getProjectType()).get());
	}
}