package org.eclipse.fx.code.compensator.project;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.fx.core.SimpleURI;
import org.eclipse.fx.ui.services.resources.GraphicsLoader;

public class EditorNavigation {
	private final GraphicsLoader provider;

	@Inject
	public EditorNavigation(GraphicsLoader provider) {
		this.provider = provider;
	}

	@PostConstruct
	public void init(BorderPane p) {
		HBox box = new HBox();
		box.getStyleClass().add("tool-bar");

		box.getChildren()
				.add(new Label(
						"Editors",
						provider.getGraphicsNode(new SimpleURI(
								"platform:/plugin/org.eclipse.fx.code.compensator.project/css/icons/16/main_tab.png"))));
		p.setTop(box);
	}
}
