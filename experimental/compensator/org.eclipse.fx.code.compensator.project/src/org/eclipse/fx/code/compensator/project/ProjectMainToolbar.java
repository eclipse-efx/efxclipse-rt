package org.eclipse.fx.code.compensator.project;

import java.util.Collections;
import java.util.Iterator;
import java.util.stream.Collectors;


import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.control.ToolBar;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;


import javax.annotation.PostConstruct;
import javax.inject.Inject;


import org.eclipse.fx.code.compensator.project.ProjectService.ToolbarElement;
import org.eclipse.fx.code.compensator.project.ProjectService.ToolbarGroup;
import org.eclipse.fx.core.command.CommandService;

public class ProjectMainToolbar {
	private final CommandService commandService;
	
	@Inject
	public ProjectMainToolbar(CommandService commandService) {
		this.commandService = commandService;
	}
	
	@PostConstruct
	public void init(BorderPane parent, ProjectService service) {
		ToolBar tb = new ToolBar();
		tb.getStyleClass().add("project-toolbar");

		tb.setOrientation(Orientation.VERTICAL);

		Iterator<ToolbarGroup> iterator = service.getPrimaryToolbarGroups().iterator();
		while( iterator.hasNext() ) {
			ToolbarGroup tg = iterator.next();

			tb.getItems().addAll(tg.getElementList().stream().map(this::createItem).collect(Collectors.toList()));

			if( iterator.hasNext() ) {
				tb.getItems().add(new Separator());
			}
		}

		parent.setCenter(tb);
	}

	Node createItem(ToolbarElement e) {
		Button b = new Button();
		b.getStyleClass().add(e.id);
		b.setTooltip(new Tooltip(e.tooltip));
		b.setOnAction(a -> {
			commandService.execute(e.commandId, Collections.emptyMap());
		});
		return b;
	}
}
