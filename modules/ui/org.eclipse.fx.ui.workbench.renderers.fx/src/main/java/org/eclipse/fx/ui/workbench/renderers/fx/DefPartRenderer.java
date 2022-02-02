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

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.workbench.UIEvents;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.fx.core.URI;
import org.eclipse.fx.ui.services.resources.GraphicsLoader;
import org.eclipse.fx.ui.workbench.renderers.base.BasePartRenderer;
import org.eclipse.fx.ui.workbench.renderers.base.BaseRenderer;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WMenu;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WPart;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WToolBar;
import org.eclipse.fx.ui.workbench.renderers.fx.internal.CustomContainerSupport;
import org.eclipse.fx.ui.workbench.renderers.fx.internal.SortedBorderPane;
import org.eclipse.fx.ui.workbench.renderers.fx.services.LightweightDialogTransitionService;
import org.eclipse.fx.ui.workbench.renderers.fx.widget.WLayoutedWidgetImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TitledPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;

/**
 * default renderer for {@link MPart}
 */
public class DefPartRenderer extends BasePartRenderer<Pane, Node, Node> {

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
			if (!checkFocusControl((Node) part.getStaticLayoutNode())) {
				Node node = (Node) part.getWidget();
				if (node instanceof Parent) {
					getFirstFocusableNode((Parent) node).ifPresent(Node::requestFocus);
				} else {
					node.requestFocus();
				}
			}
		}

	}

	static java.util.Optional<Node> getFirstFocusableNode(Parent parent) {
		if (parent.isVisible()) {
			for (Node node : parent.getChildrenUnmodifiable()) {
				if (node instanceof Parent) {
					java.util.Optional<Node> opt = getFirstFocusableNode((Parent) node);
					if (opt.isPresent()) {
						return opt;
					}
				}

				if (node.isFocusTraversable() && node.isVisible()) {
					return java.util.Optional.of(node);
				}
			}
		}
		return java.util.Optional.empty();
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
	
	/**
	 * @noreference
	 */
	public static class PartImpl extends WLayoutedWidgetImpl<Pane, AnchorPane, MPart> implements WPart<Pane, Node, Node> {

		@Inject
		@NonNull
		IEclipseContext context;

		@Inject
		private GraphicsLoader graphicsLoader;

		AnchorPane contentArea;
		private BorderPane dataArea;

		private StackPane expandGroup;
		StackPane toolbarGroup;
		Group menuGroup;
		private WMenu<Node> viewMenuWidget;
		private WToolBar<Node> viewToolbarWidget;

		private StackPane overlayContainer;
		private Label titleLabel;

		private MPart domElement;

		@Inject
		@Optional
		LightweightDialogTransitionService dialogTransitionService;

		private TitledPane titledPane;

		@Inject
		public PartImpl(@NonNull @Named(BaseRenderer.CONTEXT_DOM_ELEMENT) MPart domElement) {
			this.domElement = domElement;
		}

		@Override
		protected Pane createWidget() {
			Pane tmp = CustomContainerSupport.createContainerPane(this.logger, this.context);
			final Pane p = tmp == null ? new SortedBorderPane() : tmp;

			p.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {
					MPart domElement = getDomElement();
					if (domElement != null) {
						domElement.getContext().get(EPartService.class).activate(domElement, true);
						if (!checkFocusControl(getStaticLayoutNode()) && (domElement.getObject() != null)) {
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

		@SuppressWarnings({ "null", "boxing" })
		@Override
		public AnchorPane getWidgetNode() {
			if (this.contentArea == null) {
				this.menuGroup = new Group();
				this.menuGroup.setVisible(false);
				this.menuGroup.setManaged(false);

				this.expandGroup = new StackPane();
				this.expandGroup.getStyleClass().add(RendererConstants.CSS_CLASS_PART_EXPAND_GROUNP);
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
				this.dataArea = new SortedBorderPane();

				if( this.domElement != null && this.domElement.getTags().contains(WPart.SHOW_TOP_TRIM_AREA_TAG) ) {
					HBox box = new HBox();
					box.getStyleClass().add("tool-bar"); //$NON-NLS-1$
					this.titleLabel = new Label();
					box.getChildren().add(this.titleLabel);
					this.dataArea.setTop(box);
				}

				AnchorPane.setTopAnchor(this.dataArea, Double.valueOf(0.0));
				AnchorPane.setLeftAnchor(this.dataArea, Double.valueOf(0.0));
				AnchorPane.setBottomAnchor(this.dataArea, Double.valueOf(0.0));
				AnchorPane.setRightAnchor(this.dataArea, Double.valueOf(0.0));

				// AnchorPane.setTopAnchor(expandGroup, 0.0);
				// AnchorPane.setLeftAnchor(expandGroup, 0.0);
				// AnchorPane.setRightAnchor(expandGroup, 1.0);

				this.contentArea.getChildren().addAll(this.dataArea, this.menuGroup);
				Node n = getWidget();
				n.getStyleClass().add(RendererConstants.CSS_CLASS_PART_CONTENT);
				
				if( this.domElement.getTags().contains(BaseRenderer.SCROLLABLE) ) {
					ScrollPane scroll = new ScrollPane(n);
					scroll.setFitToHeight(true);
					scroll.setFitToWidth(true);
					n = scroll;
				}
				
				if( this.domElement.getTags().contains(WPart.WITH_COLLAPSIBLE_CONTENT) ) {
					BorderPane content = new BorderPane(n);
					content.setStyle("-fx-padding: 0px;"); //$NON-NLS-1$
					this.titledPane = new TitledPane("",content); //$NON-NLS-1$
					this.titledPane.expandedProperty().addListener((ob,ol,ne) -> {
						this.domElement.getPersistedState().put("efxSashFixed", !ne+""); //$NON-NLS-1$ //$NON-NLS-2$
					});
					
					if( Boolean.parseBoolean(this.domElement.getPersistedState().getOrDefault("efxSashFixed","false")) ) { //$NON-NLS-1$ //$NON-NLS-2$
						this.titledPane.setExpanded(false);
					}
					this.titledPane.getStyleClass().add("efx-expandable-title-pane"); //$NON-NLS-1$
					this.titledPane.setMaxHeight(Double.MAX_VALUE);
					n = this.titledPane;
				}
				
				this.dataArea.setCenter(n);
			}
			return this.contentArea;
		}

		private void initToolbarMenu() {
			if (this.toolbarGroup == null) {
				// Ensure that everything is initialized!!!
				getStaticLayoutNode();

				if( this.titledPane != null ) {
					this.toolbarGroup = new StackPane();
					((BorderPane)this.titledPane.getContent()).setTop(this.toolbarGroup);
				} else {
					this.toolbarGroup = new StackPane();
					MPart element = getDomElement();
					if (element != null && element.getTags().contains(RendererConstants.TOOL_BAR_FULL_SPAN_TAG)) {
						final BorderPane p = new BorderPane();
						p.setCenter(this.toolbarGroup);
						p.getStyleClass().add(RendererConstants.CSS_CLASS_VIEW_TOOLBAR_CONTAINER);
						if (element.getTags().contains(RendererConstants.TOOLBAR_MENU_FLOAT_TAG)) {
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
							if (element.getTags().contains(RendererConstants.TOOLBAR_MENU_BOTTOM_TAG)) {
								this.dataArea.setBottom(p);
							} else {
								this.dataArea.setTop(p);
							}
						}
					} else {
						BorderPane p = new BorderPane();
						p.setRight(this.toolbarGroup);
						p.getStyleClass().add(RendererConstants.CSS_CLASS_VIEW_TOOLBAR_CONTAINER);
						if (element != null && element.getTags().contains(RendererConstants.TOOLBAR_MENU_BOTTOM_TAG)) {
							this.dataArea.setBottom(p);
						} else {
							this.dataArea.setTop(p);
						}
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
						if (element != null && element.getTags().contains(RendererConstants.TOOLBAR_MENU_FLOAT_TAG)) {
							PartImpl.this.toolbarGroup.getParent().setVisible(false);
						}
					}
				});

				n.getStyleClass().add(RendererConstants.CSS_CLASS_VIEW_TOOLBAR);
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

		@Inject
		public void setLabel(@Named(UIEvents.UILabel.LOCALIZED_LABEL) String label) {
			// ensure init
			getWidget();
			if( this.titleLabel != null ) {
				this.titleLabel.setText(label);
			}
			if( this.titledPane != null ) {
				this.titledPane.setText(label);
			}
		}

		@SuppressWarnings("null")
		@Inject
		public void setGraphic(@Named(UIEvents.UILabel.ICONURI) String iconURI) {
			// ensure init
			getWidget();
			if( this.titleLabel != null ) {
				if( iconURI != null ) {
					this.titleLabel.setGraphic(this.graphicsLoader.getGraphicsNode(URI.create(iconURI)));
				} else {
					this.titleLabel.setGraphic(null);
				}
			}
			if( this.titledPane != null ) {
				if( iconURI != null ) {
					this.titledPane.setGraphic(this.graphicsLoader.getGraphicsNode(URI.create(iconURI)));
				} else {
					this.titledPane.setGraphic(null);
				}
			}
		}

		@Override
		public void setDialog(Object dialogNode) {
			@NonNull
			Pane staticLayoutNode = (@NonNull Pane) getStaticLayoutNode();
			if (dialogNode == null) {
				if (this.overlayContainer != null) {
					if( this.dialogTransitionService != null ) {
						this.dialogTransitionService.hideDialog(this.domElement, staticLayoutNode, this.overlayContainer, this.overlayContainer, this.overlayContainer.getChildren().size() == 1 ? this.overlayContainer.getChildren().get(0) : null, () -> {
							((Pane) staticLayoutNode).getChildren().remove(this.overlayContainer);
							this.overlayContainer.getChildren().clear();
						});
					} else {
						((Pane) staticLayoutNode).getChildren().remove(this.overlayContainer);
						this.overlayContainer.getChildren().clear();
					}
				}
			} else {
				if (this.overlayContainer == null) {
					this.overlayContainer = new StackPane() {
						@Override
						protected void layoutChildren() {
							Insets insets = getInsets();
					        final double w = getWidth() - insets.getLeft() - insets.getRight();
					        final double h = getHeight() - insets.getTop() - insets.getBottom();

					        for( Node n : getManagedChildren() ) {
					        	double x,y;
					        	n.autosize();
					        	if( n instanceof Region ) {
					        		x = (w / 2) - (Math.min(w,((Region) n).getWidth()) / 2);
					        		y = (h / 2) - (Math.min(h,((Region) n).getHeight()) / 2);
					        	} else {
					        		x = (w / 2) - (Math.min(w,n.prefWidth(-1)) / 2);
					        		y = (h / 2) - (Math.min(h,n.prefHeight(-1)) / 2);
					        	}
					        	n.relocate(x, y);
					        }
						}
					};
					this.overlayContainer.getStyleClass().add("overlay-container"); //$NON-NLS-1$
					this.overlayContainer.setManaged(false);
					this.overlayContainer.setMouseTransparent(false);
					staticLayoutNode.layoutBoundsProperty().addListener( o -> {
						staticLayoutNode.layoutBoundsProperty().get();
						this.overlayContainer.resize(staticLayoutNode.getWidth(), staticLayoutNode.getHeight());
					});
				}

				this.overlayContainer.resize(staticLayoutNode.getWidth(), staticLayoutNode.getHeight());
				this.overlayContainer.getChildren().setAll((Node)dialogNode);
				this.overlayContainer.layout();
				((Pane) staticLayoutNode).getChildren().add(this.overlayContainer);
				if( this.dialogTransitionService != null ) {
					this.dialogTransitionService.showDialog(this.domElement, staticLayoutNode, this.overlayContainer, this.overlayContainer, (Node)dialogNode, null);
				}
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
