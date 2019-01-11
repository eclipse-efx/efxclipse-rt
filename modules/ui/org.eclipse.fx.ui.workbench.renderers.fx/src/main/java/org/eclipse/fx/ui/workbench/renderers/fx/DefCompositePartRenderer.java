/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.workbench.renderers.fx;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.control.SplitPane.Divider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.basic.MCompositePart;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.model.application.ui.basic.MPartSashContainerElement;
import org.eclipse.e4.ui.workbench.UIEvents;
import org.eclipse.fx.ui.panes.GridData;
import org.eclipse.fx.ui.panes.GridData.Alignment;
import org.eclipse.fx.ui.panes.GridLayoutPane;
import org.eclipse.fx.ui.workbench.renderers.base.BaseCompositePartRenderer;
import org.eclipse.fx.ui.workbench.renderers.base.BaseRenderer;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WCompositePart;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WLayoutedWidget;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WMenu;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WSash;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WToolBar;
import org.eclipse.fx.ui.workbench.renderers.fx.DefPartRenderer.HandleGroup;
import org.eclipse.fx.ui.workbench.renderers.fx.internal.SortedBorderPane;
import org.eclipse.fx.ui.workbench.renderers.fx.widget.WLayoutedWidgetImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * Renderer for a composite part
 */
public class DefCompositePartRenderer extends BaseCompositePartRenderer<Node> {

	@Override
	protected Class<? extends WCompositePart<Node>> getWidgetClass(MCompositePart container) {
		if (container.getTags().contains(WCompositePart.TAG_FIXED_LAYOUT)) {
			return WFixedSashImpl.class;
		} else {
			return WResizableSashImpl.class;
		}
	}

	/**
	 * The {@link AbstractCompositePartImpl} provides a basic "template" for the {@link MCompositePart}.
	 * <p>
	 * A rendered {@link MCompositePart} can consist of a toolbar, menu and the main content (parts). The
	 * {@link AbstractCompositePartImpl} takes care of rendering the toolbar and the menu.
	 *
	 * @param <T>
	 *            the business control
	 */
	static abstract class AbstractCompositePartImpl<T extends Node> extends WLayoutedWidgetImpl<T, Node, MCompositePart> implements WCompositePart<Node> {

		AnchorPane contentArea;
		BorderPane dataArea;
		StackPane toolbarGroup;
		Group menuGroup;
		
		private final MCompositePart domElement;
		
		public AbstractCompositePartImpl(MCompositePart domElement) {
			this.domElement = domElement;
		}

		@Override
		public void setToolbar(WToolBar<Node> toolbar) {
			if (toolbar == null) {
				clearToolBar();
			} else {
				initToolbarMenu();
				Node n = (Node) toolbar.getWidget();
				n.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						MPart element = getDomElement();
						if (element != null && element.getTags().contains(RendererConstants.TOOLBAR_MENU_FLOAT_TAG)) {
							AbstractCompositePartImpl.this.toolbarGroup.getParent().setVisible(false);
						}
					}
				});

				n.getStyleClass().add(RendererConstants.CSS_CLASS_VIEW_TOOLBAR);
				this.toolbarGroup.getChildren().setAll(n);
			}

		}

		@Override
		public void setMenu(WMenu<Node> menu) {
			if (menu == null) {
				clearMenu();
			} else {
				this.menuGroup.setVisible(true);
				this.menuGroup.getChildren().setAll((Node) menu.getWidget());
				this.contentArea.requestLayout();
			}
		}

		@Override
		public AnchorPane getWidgetNode() {
			if (this.contentArea == null) {
				this.menuGroup = new Group();
				this.menuGroup.setVisible(false);
				this.menuGroup.setManaged(false);

				Node handler = new HandleGroup();
				handler.setOnMousePressed(new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						AbstractCompositePartImpl.this.toolbarGroup.getParent().setVisible(true);
					}
				});

				this.contentArea = new AnchorPane() {
					@Override
					protected void layoutChildren() {
						super.layoutChildren();

						if (AbstractCompositePartImpl.this.menuGroup.isVisible()) {
							AbstractCompositePartImpl.this.menuGroup.relocate(AbstractCompositePartImpl.this.contentArea.getWidth() - 20, 0);
						}
					}
				};
				this.dataArea = new SortedBorderPane();

				AnchorPane.setTopAnchor(this.dataArea, Double.valueOf(0.0));
				AnchorPane.setLeftAnchor(this.dataArea, Double.valueOf(0.0));
				AnchorPane.setBottomAnchor(this.dataArea, Double.valueOf(0.0));
				AnchorPane.setRightAnchor(this.dataArea, Double.valueOf(0.0));

				this.contentArea.getChildren().addAll(this.dataArea, this.menuGroup);
				Node n = getWidget();
				n.getStyleClass().add(RendererConstants.CSS_CLASS_PART_CONTENT);
				
				if( this.domElement.getTags().contains(BaseRenderer.SCROLLABLE) ) {
					ScrollPane scroll = new ScrollPane(n);
					scroll.setFitToHeight(true);
					scroll.setFitToWidth(true);
					n = scroll;
				}
				
				this.dataArea.setCenter(n);
			}
			return this.contentArea;

		}

		private void clearToolBar() {
			if (this.toolbarGroup != null) {
				this.toolbarGroup.getChildren().clear();
				this.dataArea.setTop(null);
				this.dataArea.setBottom(null);
				this.toolbarGroup = null;
			}
		}

		private void clearMenu() {
			if (this.menuGroup != null) {
				this.menuGroup.setVisible(false);
				this.menuGroup.getChildren().clear();
			}
		}

		private void initToolbarMenu() {
			if (this.toolbarGroup == null) {
				// Ensure that everything is initialized!!!
				getStaticLayoutNode();

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

	/**
	 * @noreference
	 */
	public static class WFixedSashImpl extends AbstractCompositePartImpl<GridLayoutPane> {
		private StackPane overlayContainer;
		
		@Inject
		public WFixedSashImpl(@NonNull @Named(BaseRenderer.CONTEXT_DOM_ELEMENT) MCompositePart domElement) {
			super(domElement);
		}

		@Override
		public void setDialog(Object dialogNode) {
			@NonNull
			Pane staticLayoutNode = (@NonNull Pane) getStaticLayoutNode();
			if (dialogNode == null) {
				if (this.overlayContainer != null) {
					((Pane) staticLayoutNode).getChildren().remove(this.overlayContainer);
					this.overlayContainer.getChildren().clear();
				}
			} else {
				if (this.overlayContainer == null) {
					this.overlayContainer = new StackPane();
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
				((Pane) staticLayoutNode).getChildren().add(this.overlayContainer);
			}
		}

		private static @NonNull GridData toGridData(Map<String, String> dataMap) {
			GridData gd = new GridData();
			if (dataMap.containsKey(WCompositePart.FIXED_LAYOUT_WIDTH)) {
				gd.widthHintProperty().set(Integer.parseInt(dataMap.get(WCompositePart.FIXED_LAYOUT_WIDTH)));
				if (!dataMap.containsKey(WCompositePart.FIXED_LAYOUT_HEIGHT)) {
					gd.grabExcessVerticalSpaceProperty().set(true);
					gd.verticalAlignmentProperty().set(Alignment.FILL);
				}
			} else {
				gd.horizontalAlignmentProperty().set(Alignment.FILL);
			}

			if (dataMap.containsKey(WCompositePart.FIXED_LAYOUT_HEIGHT)) {
				gd.heightHintProperty().set(Integer.parseInt(dataMap.get(WCompositePart.FIXED_LAYOUT_HEIGHT)));
				if (!dataMap.containsKey(WCompositePart.FIXED_LAYOUT_WIDTH)) {
					gd.grabExcessHorizontalSpaceProperty().set(true);
					gd.horizontalAlignmentProperty().set(Alignment.FILL);
				}
			} else {
				gd.verticalAlignmentProperty().set(Alignment.FILL);
			}

			if (dataMap.containsKey(WCompositePart.FIXED_LAYOUT_GRAB_HORIZONTAL)) {
				gd.grabExcessHorizontalSpaceProperty().set(Boolean.parseBoolean(dataMap.get(WCompositePart.FIXED_LAYOUT_GRAB_HORIZONTAL)));
				gd.horizontalAlignmentProperty().set(Alignment.FILL);
			}

			if (dataMap.containsKey(WCompositePart.FIXED_LAYOUT_GRAB_VERTICAL)) {
				gd.grabExcessVerticalSpaceProperty().set(Boolean.parseBoolean(dataMap.get(WCompositePart.FIXED_LAYOUT_GRAB_VERTICAL)));
				gd.verticalAlignmentProperty().set(Alignment.FILL);
			}

			return gd;
		}

		@Override
		public void addItem(WLayoutedWidget<MPartSashContainerElement> widget) {
			Node n = (Node) widget.getStaticLayoutNode();

			GridLayoutPane p = getWidget();
			MCompositePart element = getDomElement();
			if ( element != null && element.isHorizontal()) {
				p.setNumColumns(p.getNumColumns() + 1);
			}

			MPartSashContainerElement domElement2 = widget.getDomElement();
			if( domElement2 != null ) {
				GridData gd = toGridData(domElement2.getPersistedState());
				GridLayoutPane.setConstraint(n, gd);
			}
			p.getChildren().add(n);
		}

		@Override
		public int getItemCount() {
			return getWidget().getChildren().size();
		}

		@Override
		public void addItems(List<WLayoutedWidget<MPartSashContainerElement>> list) {
			List<Node> nodeList = new ArrayList<Node>();
			GridLayoutPane p = getWidget();

			for (WLayoutedWidget<MPartSashContainerElement> w : list) {
				Node n = (Node) w.getStaticLayoutNode();

				MPartSashContainerElement element = w.getDomElement();
				if( element != null ) {
					GridData gd = toGridData(element.getPersistedState());
					GridLayoutPane.setConstraint(n, gd);
				}
				nodeList.add(n);
			}

			MCompositePart element = getDomElement();
			if (element != null && element.isHorizontal()) {
				p.setNumColumns(p.getNumColumns() + nodeList.size());
			}

			p.getChildren().addAll(nodeList);
		}

		@Override
		public void addItems(int index, List<WLayoutedWidget<MPartSashContainerElement>> list) {
			List<Node> nodeList = new ArrayList<Node>();
			GridLayoutPane p = getWidget();

			for (WLayoutedWidget<MPartSashContainerElement> w : list) {
				Node n = (Node) w.getStaticLayoutNode();

				MPartSashContainerElement element = w.getDomElement();
				if( element != null ) {
					GridData gd = toGridData(element.getPersistedState());
					GridLayoutPane.setConstraint(n, gd);
				}
				nodeList.add(n);
			}

			MCompositePart element = getDomElement();
			if (element != null && element.isHorizontal()) {
				p.setNumColumns(p.getNumColumns() + nodeList.size());
			}

			p.getChildren().addAll(index, nodeList);
		}

		@Override
		public void removeItem(WLayoutedWidget<MPartSashContainerElement> widget) {
			Node n = (Node) widget.getStaticLayoutNode();
			GridLayoutPane p = getWidget();
			p.setNumColumns(p.getNumColumns() - 1);
			p.getChildren().remove(n);
		}

		@Override
		protected GridLayoutPane createWidget() {
			GridLayoutPane p = new GridLayoutPane();
			p.setMarginWidth(0);
			p.setMarginHeight(0);
			p.setHorizontalSpacing(0);
			p.setVerticalSpacing(0);
			p.setNumColumns(0);
			return p;
		}

		@Override
		public void updateLayout() {
			// TODO Auto-generated method stub

		}
	}

	/**
	 * @noreference
	 */
	public static class WResizableSashImpl extends AbstractCompositePartImpl<SplitPane> {
		private List<WLayoutedWidget<MPartSashContainerElement>> items = new ArrayList<WLayoutedWidget<MPartSashContainerElement>>();

		private StackPane overlayContainer;
		
		@Inject
		public WResizableSashImpl(@NonNull @Named(BaseRenderer.CONTEXT_DOM_ELEMENT) MCompositePart domElement) {
			super(domElement);
		}

		@Override
		public void setDialog(Object dialogNode) {
			@NonNull
			Pane staticLayoutNode = (@NonNull Pane) getStaticLayoutNode();
			if (dialogNode == null) {
				if (this.overlayContainer != null) {
					((Pane) staticLayoutNode).getChildren().remove(this.overlayContainer);
					this.overlayContainer.getChildren().clear();
				}
			} else {
				if (this.overlayContainer == null) {
					this.overlayContainer = new StackPane();
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
				((Pane) staticLayoutNode).getChildren().add(this.overlayContainer);
			}
		}

		ChangeListener<Number> listener = new ChangeListener<Number>() {
			boolean queueing;

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				if (!this.queueing) {
					this.queueing = true;
					Platform.runLater(new Runnable() {

						@SuppressWarnings("unqualified-field-access")
						@Override
						public void run() {
							recalcWeight();
							queueing = false;
						}
					});
				}
			}
		};

		@Override
		public void updateLayout() {
			updateDividers();
		}

		void recalcWeight() {
			@Nullable
			MCompositePart domElement = getDomElement();
			if( domElement != null ) {
				BaseRenderer<?, ?> r = (BaseRenderer<?, ?>) domElement.getRenderer();
				r.syncUIModifications(domElement, this::doRecalcWeight);
			} else {
				this.logger.error("The domain object should not be null at this point"); //$NON-NLS-1$
			}
		}

		void doRecalcWeight() {
			if (this.state != WidgetState.CREATED) {
				return;
			}

			// FIXME We should not do recalcs when we are in teardown of the
			// widget
			double prev = 0;
			int idx = 0;
			// No items nothing to recalculate
			if (this.items.isEmpty()) {
				return;
			}
			for (double d : getWidget().getDividerPositions()) {
				MPartSashContainerElement element = this.items.get(idx++).getDomElement();
				if( element != null ) {
					element.setContainerData((d - prev) * 10 + ""); //$NON-NLS-1$
				}
				prev = d;
			}
			MPartSashContainerElement element = this.items.get(this.items.size() - 1).getDomElement();
			if( element != null ) {
				element.setContainerData((1.0 - prev) * 10 + ""); //$NON-NLS-1$
			}
		}

		@Override
		protected void bindProperties(final SplitPane widget) {
			super.bindProperties(widget);
			widget.getDividers().addListener(new ListChangeListener<Divider>() {

				@Override
				public void onChanged(javafx.collections.ListChangeListener.Change<? extends Divider> c) {
					while (c.next()) {
						for (Divider d : c.getAddedSubList()) {
							if( d != null ) {
								d.positionProperty().addListener(WResizableSashImpl.this.listener);
							}
						}

						for (Divider d : c.getRemoved()) {
							if( d != null ) {
								d.positionProperty().removeListener(WResizableSashImpl.this.listener);
							}
						}
					}
				}
			});
			for (Divider d : widget.getDividers()) {
				d.positionProperty().addListener(this.listener);
			}
		}

		@Override
		protected SplitPane createWidget() {
			SplitPane p = new SplitPane();
			return p;
		}

		@Inject
		void setOrientation(@Named(UIEvents.GenericTile.HORIZONTAL) boolean horizontal) {
			getWidget().setOrientation(horizontal ? Orientation.HORIZONTAL : Orientation.VERTICAL);
		}

		private static void setResizableWithParent(WLayoutedWidget widget) {
			MUIElement domElement = widget.getDomElement();
			if( domElement != null ) {
				SplitPane.setResizableWithParent((Node)widget.getStaticLayoutNode(), ! domElement.getTags().contains(WSash.TAG_NO_AUTO_RESIZE));
			}
		}

		@Override
		public void addItem(WLayoutedWidget<MPartSashContainerElement> widget) {
			SplitPane p = getWidget();
			setResizableWithParent(widget);
			p.getItems().add((Node) widget.getStaticLayoutNode());
			this.items.add(widget);
			updateDividers();
		}

		@Override
		public void addItems(int index, List<WLayoutedWidget<MPartSashContainerElement>> list) {
			SplitPane p = getWidget();
			List<Node> l = new ArrayList<Node>();
			for (WLayoutedWidget<MPartSashContainerElement> i : list) {
				setResizableWithParent(i);
				l.add((Node) i.getStaticLayoutNode());
			}
			p.getItems().addAll(index, l);
			this.items.addAll(index, list);
			updateDividers();
		}

		@Override
		public void addItems(List<WLayoutedWidget<MPartSashContainerElement>> list) {
			SplitPane p = getWidget();
			List<Node> l = new ArrayList<Node>();
			for (WLayoutedWidget<MPartSashContainerElement> i : list) {
				setResizableWithParent(i);
				l.add((Node) i.getStaticLayoutNode());
			}
			p.getItems().addAll(l);
			this.items.addAll(list);
			updateDividers();
		}

		@Override
		public void setWidgetState(WidgetState state) {
			super.setWidgetState(state);
			if (state == WidgetState.CREATED) {
				updateDividers();
			}
		}

		@Override
		public void removeItem(WLayoutedWidget<MPartSashContainerElement> widget) {
			SplitPane p = getWidget();
			p.getItems().remove(widget.getStaticLayoutNode());
			this.items.remove(widget);
			updateDividers();
		}

		@Override
		protected void doCleanup() {
			super.doCleanup();
			this.items.clear();
		}

		private void updateDividers() {
			if (this.items.size() <= 1) {
				return;
			}

			if (this.state != WidgetState.CREATED) {
				return;
			}

			double total = 0;

			for (WLayoutedWidget<MPartSashContainerElement> w : this.items) {
				total += w.getWeight();
			}

			double[] deviders = new double[this.items.size() - 1];
			for (int i = 0; i < this.items.size() - 1; i++) {
				deviders[i] = (i == 0 ? 0 : deviders[i - 1]) + (this.items.get(i).getWeight() / total);
			}

			getWidget().setDividerPositions(deviders);
		}

		@Override
		public int getItemCount() {
			return getWidget().getItems().size();
		}
	}
}
