/*******************************************************************************
 * Copyright (c) 2012 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.workbench.renderers.fx;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;

import javax.inject.Inject;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.fx.ui.workbench.renderers.base.BasePartRenderer;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WMenu;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WPart;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WToolBar;
import org.eclipse.fx.ui.workbench.renderers.fx.internal.CustomContainerSupport;
import org.eclipse.fx.ui.workbench.renderers.fx.widget.WLayoutedWidgetImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * default renderer for {@link MPart}
 */
public class DefPartRenderer extends BasePartRenderer<Pane, Node, Node> {
	private static final String TOOLBAR_MENU_FLOAT_TAG = "Part-ToolBarMenu-Floating"; //$NON-NLS-1$
	// private static final String TOOLBAR_MENU_COLLAPSIBLE_TAG =
	// "Part-ToolBarMenu-Collapsible";
	private static final String TOOLBAR_MENU_BOTTOM_TAG = "Part-ToolBarMenu-Bottom"; //$NON-NLS-1$

	private static final String TOOL_BAR_FULL_SPAN_TAG = "Part-Toolbar-FullSpan"; //$NON-NLS-1$

	private static final String CSS_CLASS_PART_CONTENT = "part-content"; //$NON-NLS-1$
	private static final String CSS_CLASS_VIEW_TOOLBAR_CONTAINER = "view-toolbar-container"; //$NON-NLS-1$
	private static final String CSS_CLASS_VIEW_TOOLBAR = "view-toolbar"; //$NON-NLS-1$
	private static final String CSS_CLASS_PART_EXPAND_GROUNP = "part-expand-group"; //$NON-NLS-1$

	@Override
	protected Class<? extends WPart<Pane, Node, Node>> getWidgetClass(MPart part) {
		return PartImpl.class;
	}

	@Override
	protected boolean requiresFocus(WPart<Pane, Node, Node> widget) {
		// Node n = (Node) widget.getWidget();
		//
		// do {
		// if (n.getUserData() == widget) {
		// return false;
		// }
		// } while ((n = n.getParent()) != null);

		// By default return true see bug 431391
		return true;
	}

	@Override
	public void focus(MUIElement element) {
		super.focus(element);
		if (element.getWidget() instanceof WPart) {
			@SuppressWarnings("unchecked")
			WPart<BorderPane, Node, Node> part = ((WPart<BorderPane, Node, Node>) element.getWidget());
			if (part == null)
				return;
			if (!checkFocusControl((Node) part.getWidget())) {
				Node node = (Node) part.getWidget();
				node.requestFocus();
			}
		}

	}

	static boolean checkFocusControl(Node check) {
		if (check.getScene() == null) {
			return false;
		}

		Node n = check.getScene().getFocusOwner();

		if (n == null) {
			return false;
		}

		while (n.getParent() != null) {
			if (n.getParent() == check) {
				return true;
			}
			n = n.getParent();

		}
		return false;
	}

	static class PartImpl extends WLayoutedWidgetImpl<Pane, AnchorPane, MPart> implements WPart<Pane, Node, Node> {
		@Inject
		EPartService service;

		@Inject
		@NonNull
		IEclipseContext context;

		AnchorPane contentArea;
		private BorderPane dataArea;

		private StackPane expandGroup;
		StackPane toolbarGroup;
		Group menuGroup;
		private WMenu<Node> viewMenuWidget;
		private WToolBar<Node> viewToolbarWidget;

		@Override
		protected Pane createWidget() {
			Pane tmp = CustomContainerSupport.createContainerPane(this.logger, this.context);
			final Pane p = tmp == null ? new BorderPane() : tmp;

			p.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {
					MPart domElement = getDomElement();
					if (domElement != null) {
						PartImpl.this.service.activate(domElement, true);
						if (!checkFocusControl(getWidget()) && (domElement.getObject() != null)) {
							// ContextInjectionFactory.invoke(domElement.getObject(),
							// Focus.class, domElement.getContext(), null);
							// if (!checkFocusControl()) {
							// p.requestFocus();
							// }
							p.requestFocus();
						}
					}
				}
			});
			return p;
		}

		@Override
		protected AnchorPane getWidgetNode() {
			if (this.contentArea == null) {
				this.menuGroup = new Group();
				this.menuGroup.setVisible(false);
				this.menuGroup.setManaged(false);

				this.expandGroup = new StackPane();
				this.expandGroup.getStyleClass().add(CSS_CLASS_PART_EXPAND_GROUNP);
				this.expandGroup.setOpacity(0.5);
				Node handler = new HandleGroup();// new ImageView(new
													// Image(getClass().getClassLoader().getResourceAsStream("/icons/format-line-spacing-normal.png")));
				handler.setOnMousePressed(new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						PartImpl.this.toolbarGroup.getParent().setVisible(true);
					}
				});
				this.expandGroup.getChildren().add(handler);

				// expandView = new ImageView(new
				// Image(getClass().getClassLoader().getResourceAsStream("/icons/vcs-update-required.png")));
				// expandView.setManaged(false);
				// expandView.setVisible(false);

				this.contentArea = new AnchorPane() {
					@Override
					protected void layoutChildren() {
						super.layoutChildren();

						if (PartImpl.this.menuGroup.isVisible()) {
							PartImpl.this.menuGroup.relocate(PartImpl.this.contentArea.getWidth() - 20, 0);
						}
					}
				};
				this.dataArea = new BorderPane();

				AnchorPane.setTopAnchor(this.dataArea, Double.valueOf(0.0));
				AnchorPane.setLeftAnchor(this.dataArea, Double.valueOf(0.0));
				AnchorPane.setBottomAnchor(this.dataArea, Double.valueOf(0.0));
				AnchorPane.setRightAnchor(this.dataArea, Double.valueOf(0.0));

				// AnchorPane.setTopAnchor(expandGroup, 0.0);
				// AnchorPane.setLeftAnchor(expandGroup, 0.0);
				// AnchorPane.setRightAnchor(expandGroup, 1.0);

				this.contentArea.getChildren().addAll(this.dataArea, this.menuGroup);
				Node n = getWidget();
				n.getStyleClass().add(CSS_CLASS_PART_CONTENT);
				this.dataArea.setCenter(n);
			}
			return this.contentArea;
		}

		private void initToolbarMenu() {
			if (this.toolbarGroup == null) {
				// Ensure that everything is initialized!!!
				getStaticLayoutNode();

				this.toolbarGroup = new StackPane();
				MPart element = getDomElement();
				if (element != null && element.getTags().contains(TOOL_BAR_FULL_SPAN_TAG)) {
					final BorderPane p = new BorderPane();
					p.setCenter(this.toolbarGroup);
					p.getStyleClass().add(CSS_CLASS_VIEW_TOOLBAR_CONTAINER);
					if (element.getTags().contains(TOOLBAR_MENU_FLOAT_TAG)) {
						AnchorPane.setLeftAnchor(p, Double.valueOf(0.0));
						AnchorPane.setRightAnchor(p, Double.valueOf(0.0));
						AnchorPane.setTopAnchor(p, Double.valueOf(0.0));
						this.contentArea.getChildren().add(p);
						p.setVisible(false);
						this.dataArea.setTop(this.expandGroup);
						this.expandGroup.setVisible(true);
						p.setOnMousePressed(new EventHandler<MouseEvent>() {
							@Override
							public void handle(MouseEvent event) {
								p.setVisible(false);
							}
						});
					} else {
						if (element.getTags().contains(TOOLBAR_MENU_BOTTOM_TAG)) {
							this.dataArea.setBottom(p);
						} else {
							this.dataArea.setTop(p);
						}
					}
				} else {
					BorderPane p = new BorderPane();
					p.setRight(this.toolbarGroup);
					p.getStyleClass().add(CSS_CLASS_VIEW_TOOLBAR_CONTAINER);
					if (element != null && element.getTags().contains(TOOLBAR_MENU_BOTTOM_TAG)) {
						this.dataArea.setBottom(p);
					} else {
						this.dataArea.setTop(p);
					}
				}
			}
		}

		@Override
		public void setToolbar(WToolBar<Node> widget) {
			if (widget == null) {
				if (this.toolbarGroup != null) {
					this.toolbarGroup.getChildren().clear();
					this.dataArea.setTop(null);
					this.dataArea.setBottom(null);
					this.toolbarGroup = null;
				}
			} else {
				initToolbarMenu();
				Node n = (Node) widget.getWidget();
				n.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						MPart element = getDomElement();
						if (element != null && element.getTags().contains(TOOLBAR_MENU_FLOAT_TAG)) {
							PartImpl.this.toolbarGroup.getParent().setVisible(false);
						}
					}
				});

				n.getStyleClass().add(CSS_CLASS_VIEW_TOOLBAR);
				this.toolbarGroup.getChildren().setAll(n);
			}

			this.viewToolbarWidget = widget;
		}

		@Override
		public void setMenu(WMenu<Node> widget) {
			if (widget == null) {
				if (this.menuGroup != null) {
					this.menuGroup.setVisible(false);
					this.menuGroup.getChildren().clear();
				}
			} else {
				this.menuGroup.setVisible(true);
				this.menuGroup.getChildren().setAll((Node) widget.getWidget());
				this.contentArea.requestLayout();
			}

			this.viewMenuWidget = widget;
		}

		@Override
		public WMenu<Node> getMenu() {
			return this.viewMenuWidget;
		}

		@Override
		public @Nullable WToolBar<Node> getToolbar() {
			return this.viewToolbarWidget;
		}
	}

	static class HandleGroup extends Group {
		@Override
		public double minHeight(double width) {
			return 11;
		}

		@Override
		public double maxWidth(double height) {
			return 20;
		}

		public HandleGroup() {
			{
				Rectangle r = new Rectangle(16, 1);
				r.setFill(Color.WHITE);
				r.setStroke(Color.BLACK);
				r.setLayoutX(0);
				r.setLayoutY(1);
				r.setStrokeType(StrokeType.OUTSIDE);
				getChildren().add(r);
			}

			{
				Rectangle r = new Rectangle(16, 1);
				r.setFill(Color.WHITE);
				r.setStroke(Color.BLACK);
				r.setLayoutX(0);
				r.setLayoutY(4);
				r.setStrokeType(StrokeType.OUTSIDE);
				getChildren().add(r);
			}

			{
				Rectangle r = new Rectangle(16, 1);
				r.setFill(Color.WHITE);
				r.setStroke(Color.BLACK);
				r.setLayoutX(0);
				r.setLayoutY(7);
				r.setStrokeType(StrokeType.OUTSIDE);
				getChildren().add(r);
			}
		}
	}
}
