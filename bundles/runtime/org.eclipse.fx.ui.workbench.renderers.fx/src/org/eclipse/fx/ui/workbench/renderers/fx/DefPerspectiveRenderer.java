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

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.advanced.MPerspective;
import org.eclipse.e4.ui.model.application.ui.basic.MPartSashContainerElement;
import org.eclipse.fx.ui.panes.FillLayoutPane;
import org.eclipse.fx.ui.workbench.renderers.base.BasePerspectiveRenderer;
import org.eclipse.fx.ui.workbench.renderers.base.services.MaximizationTransitionService;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WLayoutedWidget;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WPerspective;
import org.eclipse.fx.ui.workbench.renderers.fx.widget.WLayoutedWidgetImpl;
import org.eclipse.jdt.annotation.NonNull;

/**
 * default renderer for {@link MPerspective}
 */
public class DefPerspectiveRenderer extends BasePerspectiveRenderer<FillLayoutPane> {

	@Override
	protected Class<? extends WPerspective<FillLayoutPane>> getWidgetClass(MPerspective perspective) {
		return PerspectiveWidgetImpl.class;
	}

	static class PerspectiveWidgetImpl extends WLayoutedWidgetImpl<FillLayoutPane, FillLayoutPane, MPerspective> implements WPerspective<FillLayoutPane> {
		private StackPane overlayContainer;
		/**
		 * Pane used to mask background while maximized content is displayed
		 */
		private FillLayoutPane greyPane;
		/**
		 * Pane hosting the maximized component
		 */
		private FillLayoutPane maximizationContainer;
		/**
		 * Reference to the currently maximized widget
		 */
		private WLayoutedWidget<? extends MUIElement> maximizedWidget;

		@Inject
		@Optional
		private MaximizationTransitionService<Pane, Region> maximizationTransition;

		@Override
		public FillLayoutPane getWidgetNode() {
			return getWidget();
		}

		@Override
		protected FillLayoutPane createWidget() {
			return new FillLayoutPane();
		}

		@Override
		public void addItems(List<WLayoutedWidget<MPartSashContainerElement>> list) {
			List<Node> l = new ArrayList<Node>(list.size());
			for (WLayoutedWidget<MPartSashContainerElement> w : list) {
				l.add((Node) w.getStaticLayoutNode());
			}
			getWidget().getChildren().addAll(l);
		}

		@Override
		public void addItem(int index, WLayoutedWidget<MPartSashContainerElement> widget) {
			getWidget().getChildren().add(index, (Node) widget.getStaticLayoutNode());
		}

		@Override
		public void removeItem(WLayoutedWidget<MUIElement> widget) {
			getWidget().getChildren().remove(widget.getStaticLayoutNode());
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

		@Override
		public void setMaximizedContent(WLayoutedWidget<? extends MUIElement> widget) {
			if (this.maximizedWidget != null) {
				return;
			}

			final WLayoutedWidget<? extends MUIElement> childWidget = widget;

			Pane staticLayoutNode = (@NonNull Pane) getStaticLayoutNode();
			this.maximizedWidget = widget;

			final FillLayoutPane maximizationContainer = new FillLayoutPane();
			final FillLayoutPane greyPane = new FillLayoutPane();
			greyPane.getStyleClass().add("maximization-container"); //$NON-NLS-1$
			greyPane.setOpacity(0.0);

			int size = staticLayoutNode.getChildren().size();
			if (this.overlayContainer == staticLayoutNode.getChildren().get(size - 1)) {
				// do not cover overlay container
				staticLayoutNode.getChildren().add(size - 1, greyPane);
				staticLayoutNode.getChildren().add(size, maximizationContainer);
			} else {
				staticLayoutNode.getChildren().add(greyPane);
				staticLayoutNode.getChildren().add(maximizationContainer);
			}

			Runnable finisher = () -> {
				staticLayoutNode.getChildren().stream().forEach( n -> n.setVisible(false));
				maximizationContainer.setVisible(true);
				maximizationContainer.getChildren().clear();
				maximizationContainer.getChildren().add((Region) childWidget.getWidgetNode());
				greyPane.setOpacity(1.0);
				this.maximizationContainer = maximizationContainer;
				this.greyPane = greyPane;
			};

			if(this.maximizationTransition != null) {
				this.maximizationTransition.maximize(getWidget(), greyPane, maximizationContainer, (Region) childWidget.getWidgetNode(), finisher);
			} else {
				finisher.run();
			}
		}

		@Override
		public void removeMaximizedContent() {
			if (this.maximizationContainer != null) {
				Pane staticLayoutNode = (@NonNull Pane) getStaticLayoutNode();

				Pane childStaticNode = (Pane) this.maximizedWidget.getStaticLayoutNode();
				Region childPane = (Region) this.maximizedWidget.getWidgetNode();

				FillLayoutPane maximizationContainer = this.maximizationContainer;
				FillLayoutPane greyPane = this.greyPane;
				this.maximizationContainer = null;
				this.maximizedWidget = null;

				Runnable finisher = () -> {
					staticLayoutNode.getChildren().remove(greyPane);
					staticLayoutNode.getChildren().remove(maximizationContainer);
					childStaticNode.getChildren().add(childPane);
					staticLayoutNode.getChildren().stream().forEach( n -> n.setVisible(true));
				};

				if(this.maximizationTransition != null) {
					this.maximizationTransition.restore(staticLayoutNode, greyPane, maximizationContainer, childStaticNode, childPane, finisher);
				} else {
					finisher.run();
				}
			}
		}
	}
}
