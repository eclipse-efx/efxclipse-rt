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
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;

import javax.inject.Inject;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.fx.core.log.Logger.Level;
import org.eclipse.fx.ui.workbench.renderers.base.BasePartRenderer;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WMenu;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WPart;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WToolBar;
import org.eclipse.fx.ui.workbench.renderers.fx.widget.WLayoutedWidgetImpl;


public class DefPartRenderer extends BasePartRenderer<BorderPane, Node, Node> {
	private static final String TOOLBAR_MENU_FLOAT_TAG = "Part-ToolBarMenu-Floating";
	private static final String TOOLBAR_MENU_COLLAPSIBLE_TAG = "Part-ToolBarMenu-Collapsible";
	private static final String TOOLBAR_MENU_BOTTOM_TAG = "Part-ToolBarMenu-Bottom";

	private static final String TOOL_BAR_FULL_SPAN_TAG = "Part-Toolbar-FullSpan";

	@Override
	protected Class<? extends WPart<BorderPane, Node, Node>> getWidgetClass(MPart part) {
		return PartImpl.class;
	}

	@Override
	protected boolean requiresFocus(WPart<BorderPane, Node, Node> widget) {
		Node n = (Node) widget.getWidget();

		do {
			if (n.getUserData() == widget) {
				return false;
			}
		} while ((n = n.getParent()) != null);

		return true;
	}
	
	@Override
	public void focus(MUIElement element) {
		super.focus(element);
		if (element.getWidget() instanceof WPart)
		{
			@SuppressWarnings("unchecked")
			WPart<BorderPane, Node, Node> part = ((WPart<BorderPane, Node, Node>) element.getWidget());
			if (part==null) return;
			Node node = (Node) part.getWidget();
			node.requestFocus();
		}
		
	}

	public static class PartImpl extends WLayoutedWidgetImpl<BorderPane, AnchorPane, MPart> implements WPart<BorderPane, Node, Node> {
		@Inject
		EPartService service;

		private AnchorPane contentArea;
		private BorderPane dataArea;

		private StackPane expandGroup;
		private StackPane toolbarGroup;
		private Group menuGroup;
		
		@Override
		protected BorderPane createWidget() {
			final BorderPane p = new BorderPane();
			p.setOnMousePressed(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {
					event.consume();
					MPart domElement = getDomElement();
					service.activate(domElement, true);
					if (!checkFocusControl() && (domElement.getObject()!=null)) {
						ContextInjectionFactory.invoke(domElement.getObject(), Focus.class, domElement.getContext(), null);
						if (!checkFocusControl()) {
							p.requestFocus();
						}
					}
				}
			});
			return p;
		}
		
		

		private boolean checkFocusControl() {
			BorderPane check = getWidget();
			if (check == null || check.getScene() == null) {
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

		@Override
		protected AnchorPane getWidgetNode() {
			if (contentArea == null) {
				menuGroup = new Group();
				menuGroup.setVisible(false);
				menuGroup.setManaged(false);
				
				expandGroup = new StackPane();
				expandGroup.setStyle("-fx-background-color: gray");
				expandGroup.setOpacity(0.5);
				Node handler = new HandleGroup();//new ImageView(new Image(getClass().getClassLoader().getResourceAsStream("/icons/format-line-spacing-normal.png")));
				handler.setOnMousePressed(new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						toolbarGroup.getParent().setVisible(true);
					}
				});
				expandGroup.getChildren().add(handler);
				
//				expandView = new ImageView(new Image(getClass().getClassLoader().getResourceAsStream("/icons/vcs-update-required.png")));
//				expandView.setManaged(false);
//				expandView.setVisible(false);
				
				contentArea = new AnchorPane() {
					@Override
					protected void layoutChildren() {
						super.layoutChildren();
						
						if( menuGroup.isVisible() ) {
							menuGroup.relocate(contentArea.getWidth()-20,0);
						}
					}
				};
				dataArea = new BorderPane();

				AnchorPane.setTopAnchor(dataArea, 0.0);
				AnchorPane.setLeftAnchor(dataArea, 0.0);
				AnchorPane.setBottomAnchor(dataArea, 1.0);
				AnchorPane.setRightAnchor(dataArea, 1.0);
				
//				AnchorPane.setTopAnchor(expandGroup, 0.0);
//				AnchorPane.setLeftAnchor(expandGroup, 0.0);
//				AnchorPane.setRightAnchor(expandGroup, 1.0);
				
				contentArea.getChildren().addAll(dataArea, menuGroup);
				Node n = getWidget();
				if (n != null) {
					n.getStyleClass().add("part-content");
					dataArea.setCenter(n);
				} else {
					logger.log(Level.ERROR, "No widget node to attach");
				}
			}
			return contentArea;
		}

		private void initToolbarMenu() {
			if (toolbarGroup == null) {
				// Ensure that everything is initialized!!!
				getStaticLayoutNode();
				
				toolbarGroup = new StackPane();
				
				if (getDomElement().getTags().contains(TOOL_BAR_FULL_SPAN_TAG)) {
					final BorderPane p = new BorderPane();
					p.setCenter(toolbarGroup);
					p.getStyleClass().add("view-toolbar-container");
					if( getDomElement().getTags().contains(TOOLBAR_MENU_FLOAT_TAG) ) {
						AnchorPane.setLeftAnchor(p, 0.0);
						AnchorPane.setRightAnchor(p, 1.0);
						AnchorPane.setTopAnchor(p, 0.0);
						contentArea.getChildren().add(p);
						p.setVisible(false);
						dataArea.setTop(expandGroup);
						expandGroup.setVisible(true);
						p.setOnMousePressed(new EventHandler<MouseEvent>() {
							@Override
							public void handle(MouseEvent event) {
								p.setVisible(false);
							}
						});
					} else {
						if (getDomElement().getTags().contains(TOOLBAR_MENU_BOTTOM_TAG)) {
							dataArea.setBottom(p);
						} else {
							dataArea.setTop(p);	
						}	
					}
				} else {
					BorderPane p = new BorderPane();
					p.setRight(toolbarGroup);
					p.getStyleClass().add("view-toolbar-container");
					if (getDomElement().getTags().contains(TOOLBAR_MENU_BOTTOM_TAG)) {
						dataArea.setBottom(p);
					} else {
						dataArea.setTop(p);	
					}
				}
			}
		}

		@Override
		public void setToolbar(WToolBar<Node> widget) {
			if (widget == null) {
				if (toolbarGroup != null) {
					toolbarGroup.getChildren().clear();
					dataArea.setTop(null);
					dataArea.setBottom(null);
				}
			} else {
				initToolbarMenu();
				Node n = (Node) widget.getWidget();
				n.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						if( getDomElement().getTags().contains(TOOLBAR_MENU_FLOAT_TAG) ) {
							toolbarGroup.getParent().setVisible(false);
						}
					}
				});
				
				n.getStyleClass().add("view-toolbar");
				toolbarGroup.getChildren().setAll(n);
			}
		}

		@Override
		public void setMenu(WMenu<Node> widget) {
			if (widget == null) {
				if (menuGroup != null) {
					menuGroup.setVisible(false);
					menuGroup.getChildren().clear();
				}
			} else {
				menuGroup.setVisible(true);
				menuGroup.getChildren().setAll((Node) widget.getWidget());
			}
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
				Rectangle r = new Rectangle(16,1);
				r.setFill(Color.WHITE);
				r.setStroke(Color.BLACK);
				r.setLayoutX(0);
				r.setLayoutY(1);
				r.setStrokeType(StrokeType.OUTSIDE);
				getChildren().add(r);
			}
			
			{
				Rectangle r = new Rectangle(16,1);
				r.setFill(Color.WHITE);
				r.setStroke(Color.BLACK);
				r.setLayoutX(0);
				r.setLayoutY(4);
				r.setStrokeType(StrokeType.OUTSIDE);
				getChildren().add(r);
			}
			
			{
				Rectangle r = new Rectangle(16,1);
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
