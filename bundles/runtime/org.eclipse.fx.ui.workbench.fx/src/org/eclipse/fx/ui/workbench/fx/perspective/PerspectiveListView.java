/*******************************************************************************
 * Copyright (c) 2016 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.workbench.fx.perspective;

import java.util.List;
import java.util.function.Consumer;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.ui.model.application.ui.advanced.MPerspective;
import org.eclipse.e4.ui.model.application.ui.advanced.MPerspectiveStack;
import org.eclipse.e4.ui.model.application.ui.basic.MWindow;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.emf.common.util.URI;
import org.eclipse.fx.ui.services.resources.GraphicsLoader;
import org.eclipse.fx.ui.workbench.fx.EMFUri;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import javafx.collections.FXCollections;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

/**
 * Display a list of perspectives
 *
 * @since 2.4.0
 */
public class PerspectiveListView {
	private final MWindow window;
	private final EModelService modelService;
	final GraphicsLoader graphicsLoader;
	private Consumer<MPerspective> openConsumer;
	private Consumer<MPerspective> selectionConsumer;
	private final MPerspective currentPerspective;
	private ListView<MPerspective> listView;

	/**
	 * Create a perspective list view
	 *
	 * @param window
	 *            the window
	 * @param modelService
	 *            the model service
	 * @param graphicsLoader
	 *            the graphics loader
	 */
	@Inject
	public PerspectiveListView(MWindow window, EModelService modelService, GraphicsLoader graphicsLoader) {
		this.window = window;
		this.modelService = modelService;
		this.graphicsLoader = graphicsLoader;
		List<MPerspectiveStack> list = modelService.findElements(window, null, MPerspectiveStack.class, null);
		if (!list.isEmpty()) {
			if (list.get(0).getSelectedElement() != null) {
				this.currentPerspective = list.get(0).getSelectedElement();
			} else if (!list.get(0).getChildren().isEmpty()) {
				this.currentPerspective = list.get(0).getChildren().get(0);
			} else {
				this.currentPerspective = null;
			}
		} else {
			this.currentPerspective = null;
		}

	}

	/**
	 * Initialize the UI
	 *
	 * @param parent
	 *            the parent to place the UI on
	 */
	@PostConstruct
	public void init(BorderPane parent) {
		this.listView = new ListView<>();
		this.listView.getStyleClass().add("efx-perspective-list"); //$NON-NLS-1$
		this.listView.setCellFactory(PerspectiveCell::new);
		this.listView.setItems(FXCollections.observableArrayList(this.modelService.findElements(this.window, null, MPerspective.class, null)));
		this.listView.getSelectionModel().selectedItemProperty().addListener((o, ol, ne) -> {
			if (this.selectionConsumer != null) {
				this.selectionConsumer.accept(this.currentPerspective);
			}
		});
		this.listView.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
			if (e.getClickCount() > 1) {
				handleOpenRequest();
			}
		});
		this.listView.addEventHandler(KeyEvent.KEY_PRESSED, e -> {
			if (e.getCode() == KeyCode.ENTER) {
				handleOpenRequest();
			}
		});
		parent.setCenter(this.listView);
		this.listView.getSelectionModel().select(this.currentPerspective);
	}

	private void handleOpenRequest() {
		MPerspective selectedItem = this.listView.getSelectionModel().getSelectedItem();
		if (this.openConsumer != null && selectedItem != null ) {
			this.openConsumer.accept(selectedItem);
		}
	}

	/**
	 * Consumer to be invoked when the user executes an open request
	 *
	 * @param openConsumer
	 *            the consumer
	 */
	public void setOpenConsumer(@Nullable Consumer<@NonNull MPerspective> openConsumer) {
		this.openConsumer = openConsumer;
	}

	/**
	 * Consumer to be invoked when a perspective entry is selected
	 *
	 * @param selectionConsumer
	 *            the consumer
	 */
	public void setSelectionConsumer(@Nullable Consumer<@NonNull MPerspective> selectionConsumer) {
		this.selectionConsumer = selectionConsumer;
	}

	class PerspectiveCell extends ListCell<MPerspective> {
		public PerspectiveCell(ListView<MPerspective> list) {
			// nothing to be done
		}

		@Override
		protected void updateItem(MPerspective item, boolean empty) {
			super.updateItem(item, empty);
			if (item != null && !empty) {
				setText(item.getLocalizedLabel());
				String iconURI = item.getIconURI();
				if (iconURI != null) {
					@SuppressWarnings("null")
					EMFUri uri = new EMFUri(URI.createURI(iconURI));
					setGraphic(PerspectiveListView.this.graphicsLoader.getGraphicsNode(uri));
				} else {
					setGraphic(null);
				}
			} else {
				setText(""); //$NON-NLS-1$
				setGraphic(null);
			}
		}
	}
}
