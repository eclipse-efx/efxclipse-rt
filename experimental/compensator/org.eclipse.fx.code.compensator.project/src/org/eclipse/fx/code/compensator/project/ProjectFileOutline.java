package org.eclipse.fx.code.compensator.project;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

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
import org.eclipse.fx.core.URI;
import org.eclipse.fx.ui.controls.tree.SimpleTreeCell;
import org.eclipse.fx.ui.services.resources.GraphicsLoader;

public class ProjectFileOutline {
	private final GraphicsLoader nodeProvider;
	private final MPart appModelElement;
	private Outline outline;
	private Map<Outline, TreeView<OutlineItem>> treeCache = new WeakHashMap<>();

	private final BorderPane container;

	@Inject
	public ProjectFileOutline(BorderPane container, GraphicsLoader nodeProvider, MPart appModelElement) {
		this.container = container;
		this.nodeProvider = nodeProvider;
		this.appModelElement = appModelElement;
	}

	@PostConstruct
	public void initUI() {
		HBox b = new HBox();
		b.getStyleClass().add("tool-bar");
		if( (MUIElement)appModelElement.getParent() instanceof MPartSashContainer ) {
			b.getChildren().add(new Label("Outline", nodeProvider.getGraphicsNode(URI.createPlatformPluginURI("org.eclipse.fx.code.compensator.project","css/icons/16/outline_co.png"))));
		}
		container.setTop(b);
	}

	private TreeView<OutlineItem> createView() {
		TreeView<OutlineItem> outlineView = new TreeView<>();
		outlineView.setShowRoot(false);
		outlineView.setCellFactory(this::createCell);
		return outlineView;
	}

	TreeCell<OutlineItem> createCell(TreeView<OutlineItem> param) {
		return new SimpleTreeCell<OutlineItem>(i -> i.getLabel(), i -> i.getGraphic(), i -> Collections.emptyList());
	}

	@Inject
	void updateInput(@Optional @Named("activeOutline") Outline outline) {
		this.outline = outline;

		if( outline != null ) {
			TreeView<OutlineItem> view = treeCache.get(outline);

			if( view == null ) {
				view = createView();
				TreeItem<OutlineItem> root = new TreeItem<>();
				for( OutlineItem l : outline.getRootItems() ) {
					root.getChildren().add(createRec(l));
				}
				view.setRoot(root);
				treeCache.put(outline, view);
			}

			container.setCenter(view);
		} else {
			container.setCenter(null);
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
