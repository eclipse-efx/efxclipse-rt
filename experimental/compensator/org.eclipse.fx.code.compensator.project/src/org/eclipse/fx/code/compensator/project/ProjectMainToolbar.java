package org.eclipse.fx.code.compensator.project;

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

import org.eclipse.fx.code.compensator.project.ProjectService.ToolbarElement;
import org.eclipse.fx.code.compensator.project.ProjectService.ToolbarGroup;

public class ProjectMainToolbar {

	@PostConstruct
	public void init(BorderPane parent, ProjectService service) {
		ToolBar tb = new ToolBar();
		tb.getStyleClass().add("project-toolbar");

		tb.setOrientation(Orientation.VERTICAL);

		Iterator<ToolbarGroup> iterator = service.getPrimaryToolbarGroups().iterator();
		while( iterator.hasNext() ) {
			ToolbarGroup tg = iterator.next();

			tb.getItems().addAll(tg.getElementList().stream().map(ProjectMainToolbar::createItem).collect(Collectors.toList()));

			if( iterator.hasNext() ) {
				tb.getItems().add(new Separator());
			}
		}

		parent.setCenter(tb);
	}

	static Node createItem(ToolbarElement e) {
		Button b = new Button();
		b.getStyleClass().add(e.id);
		b.setTooltip(new Tooltip(e.tooltip));
		return b;
	}
}
