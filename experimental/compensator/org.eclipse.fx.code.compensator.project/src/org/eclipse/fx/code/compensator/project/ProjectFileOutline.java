package org.eclipse.fx.code.compensator.project;

import java.util.Collections;

import javafx.scene.control.Label;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.model.application.ui.basic.MPartSashContainer;
import org.eclipse.fx.code.compensator.editor.Outline;
import org.eclipse.fx.code.compensator.editor.Outline.OutlineItem;
import org.eclipse.fx.core.SimpleURI;
import org.eclipse.fx.ui.controls.tree.SimpleTreeCell;
import org.eclipse.fx.ui.services.resources.GraphicsLoader;

public class ProjectFileOutline {
	private TreeView<OutlineItem> outlineView;
	private final GraphicsLoader nodeProvider;
	private final MPart appModelElement;
	private Outline outline;

	@Inject
	public ProjectFileOutline(GraphicsLoader nodeProvider, MPart appModelElement) {
		this.nodeProvider = nodeProvider;
		this.appModelElement = appModelElement;
	}

	@PostConstruct
	public void initUI(BorderPane parent) {
		HBox b = new HBox();
		b.getStyleClass().add("tool-bar");
		if( (MUIElement)appModelElement.getParent() instanceof MPartSashContainer ) {
			b.getChildren().add(new Label("Outline", nodeProvider.getGraphicsNode(new SimpleURI("platform:/plugin/org.eclipse.fx.code.compensator.project/css/icons/16/outline_co.png"))));
		}
		parent.setTop(b);

		outlineView = new TreeView<>();
		outlineView.setShowRoot(false);
		outlineView.setCellFactory(this::createCell);
		parent.setCenter(outlineView);
		updateInput(outline);
	}

	TreeCell<OutlineItem> createCell(TreeView<OutlineItem> param) {
		return new SimpleTreeCell<OutlineItem>(i -> i.getLabel(), i -> i.getGraphic(), i -> Collections.emptyList());
	}

	@Inject
	void updateInput(@Optional @Named("activeOutline") Outline outline) {
		this.outline = outline;
		if( outlineView == null ) {
			return;
		}

		if( outline != null ) {
			TreeItem<OutlineItem> root = new TreeItem<Outline.OutlineItem>();
			for( OutlineItem l : outline.getRootItems() ) {
				root.getChildren().add(createRec(l));
			}
			outlineView.setRoot(root);
		} else {
			outlineView.setRoot(new TreeItem<>());
		}
	}

	TreeItem<OutlineItem> createRec(OutlineItem i) {
		TreeItem<OutlineItem> l = new TreeItem<Outline.OutlineItem>(i);
		for( OutlineItem c : i.getChildren() ) {
			l.getChildren().add(createRec(c));
		}

		return l;
	}
}
