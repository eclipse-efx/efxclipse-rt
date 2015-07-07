package org.eclipse.fx.code.compensator.editor;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.fx.core.URI;
import org.eclipse.fx.ui.services.resources.GraphicsLoader;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;

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

		box.getChildren().add(
				new Label("Editors", provider.getGraphicsNode(URI
						.createPlatformPluginURI(
								"org.eclipse.fx.code.compensator.editor",
								"css/icons/16/main_tab.png"))));
		Pane spacer = new Pane();
		HBox.setHgrow(spacer, Priority.ALWAYS);
		box.getChildren().add(spacer);


		p.setTop(box);
	}
}