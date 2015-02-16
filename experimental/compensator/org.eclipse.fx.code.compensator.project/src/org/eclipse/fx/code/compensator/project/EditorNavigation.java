package org.eclipse.fx.code.compensator.project;

import java.util.Collections;

import javafx.geometry.Orientation;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.fx.code.compensator.project.internal.commands.CommitActiveInput;
import org.eclipse.fx.core.URI;
import org.eclipse.fx.core.command.CommandService;
import org.eclipse.fx.ui.services.resources.GraphicsLoader;

public class EditorNavigation {
	private final GraphicsLoader provider;
	
	private final CommandService commandService;
	
	@Inject
	public EditorNavigation(GraphicsLoader provider, CommandService commandService) {
		this.provider = provider;
		this.commandService = commandService;
	}

	@PostConstruct
	public void init(BorderPane p) {
		HBox box = new HBox();
		box.getStyleClass().add("tool-bar");

		box.getChildren().add(
				new Label("Editors", provider.getGraphicsNode(URI
						.createPlatformPluginURI(
								"org.eclipse.fx.code.compensator.project",
								"css/icons/16/main_tab.png"))));
		Pane spacer = new Pane();
		HBox.setHgrow(spacer, Priority.ALWAYS);
		box.getChildren().add(spacer);

//		{
//			Label e = new Label("1", provider.getGraphicsNode(URI.createPlatformPluginURI(
//					"org.eclipse.fx.code.compensator.project", "css/icons/16/window-close.png")));
//			box.getChildren().add(
//					e);
//		}
//		
//		{
//			Label e = new Label("1", provider.getGraphicsNode(URI.createPlatformPluginURI(
//					"org.eclipse.fx.code.compensator.project", "css/icons/16/message_warning.png")));
//			box.getChildren().add(
//					e);
//		}
		
		box.getChildren().add(new Separator(Orientation.VERTICAL));
		
		{
			Label label = new Label(null, provider.getGraphicsNode(URI
					.createPlatformPluginURI(
							"org.eclipse.fx.code.compensator.project",
							"css/icons/16/commit.png")));
			label.setTooltip(new Tooltip("Commit"));
			box.getChildren().add(label);
			label.setOnMouseClicked(e -> {
				commandService.execute(CommitActiveInput.COMMAND_ID, Collections.emptyMap());
			});
		}

		p.setTop(box);
	}
}
