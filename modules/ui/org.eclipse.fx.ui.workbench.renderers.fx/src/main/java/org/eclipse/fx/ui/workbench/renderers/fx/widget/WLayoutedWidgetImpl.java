/*******************************************************************************
 * Copyright (c) 2012 BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.workbench.renderers.fx.widget;

import java.util.List;
import java.util.function.Predicate;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.model.application.ui.basic.MPartStack;
import org.eclipse.e4.ui.workbench.UIEvents;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.fx.core.log.Log;
import org.eclipse.fx.core.log.Logger;
import org.eclipse.fx.ui.controls.dnd.EFXDragEvent;
import org.eclipse.fx.ui.panes.LazyStackPane;
import org.eclipse.fx.ui.panes.SashPane.FixedSashItem;
import org.eclipse.fx.ui.workbench.renderers.base.services.DnDFeedbackService;
import org.eclipse.fx.ui.workbench.renderers.base.services.DnDService;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WCallback;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WLayoutedWidget;
import org.eclipse.fx.ui.workbench.renderers.fx.internal.DnDSupport;
import org.eclipse.fx.ui.workbench.renderers.fx.internal.SplitDnDSupport;
import org.eclipse.fx.ui.workbench.services.ModelService;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableBooleanValue;
import javafx.scene.Node;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.layout.Pane;

/**
 * Base implementation for all {@link WLayoutedWidget} implementations
 *
 * @param <N>
 *            the business control
 * @param <NN>
 *            the container type
 * @param <M>
 *            the model element
 */
// FIXME Why do we need N & NN
public abstract class WLayoutedWidgetImpl<N, NN extends Node, M extends MUIElement> extends WWidgetImpl<N, M> implements WLayoutedWidget<M> {
	private Node staticLayoutGroup;
	private double weight = 10;
	private WCallback<@NonNull DropData, @Nullable Void> dropCallback;
	private boolean isFixed;

	public static final boolean OPTIMIZED_STACK_LAYOUT = Boolean.getBoolean("efxclipse.experimental.optstack"); //$NON-NLS-1$

	@Inject
	@NonNull
	DnDFeedbackService feedbackService;

	@Inject
	@NonNull
	EModelService modelService;

	@Inject
	@Optional
	@Nullable
	DnDService constraintService;

	@Inject
	@NonNull
	ModelService efxModelService;

	/**
	 * @return the widget node
	 */
	@Override
	public abstract NN getWidgetNode();

	/**
	 * the logger to use
	 */
	@Inject
	@Log
	@NonNull
	protected Logger logger;

	@Override
	@NonNull
	public Node getStaticLayoutNode() {
		Node staticLayoutGroup = this.staticLayoutGroup;
		if (staticLayoutGroup == null) {
			staticLayoutGroup = createStaticLayoutNode();
			this.staticLayoutGroup = staticLayoutGroup;
		}
		return staticLayoutGroup;
	}

	/**
	 * Create the static layout node
	 *
	 * @return the layout node
	 */
	@NonNull
	protected Node createStaticLayoutNode() {
		Pane staticLayoutGroup = createStaticPane();
		Node n = getWidgetNode();
		if (n != null) {
			staticLayoutGroup.getChildren().add(n);
		} else {
			this.logger.error("No widget node to attach"); //$NON-NLS-1$
		}
		initDnd(staticLayoutGroup);
		return staticLayoutGroup;
	}

	/**
	 * Initialize drag and drop
	 *
	 * @param staticLayoutGroup
	 *            the static group we attach the DnD to
	 */
	protected void initDnd(Pane staticLayoutGroup) {
		SplitDnDSupport<M> dndSupport = new SplitDnDSupport<>(this.efxModelService, this.modelService, this.constraintService, this.feedbackService, this);
		staticLayoutGroup.addEventHandler(DragEvent.DRAG_OVER, dndSupport::handleDragOver);
		staticLayoutGroup.addEventHandler(DragEvent.DRAG_EXITED, dndSupport::handleDragExit);
		staticLayoutGroup.addEventHandler(DragEvent.DRAG_DROPPED, dndSupport::handleDragDropped);

		staticLayoutGroup.addEventHandler(EFXDragEvent.DRAG_OVER, dndSupport::handleDragOver);
		// staticLayoutGroup.addEventHandler(EFXDragEvent.DRAG_EXITED,
		// dndSupport::handleDragExit);
		staticLayoutGroup.addEventHandler(EFXDragEvent.DRAG_DROPPED, dndSupport::handleDragDropped);
		if (DnDSupport.DETACHABLE_DRAG) {
			staticLayoutGroup.addEventHandler(MouseDragEvent.MOUSE_DRAG_EXITED, dndSupport::handleDragExit);
		}
	}

	@Override
	public final void setDragDroppedCallback(@Nullable WCallback<@NonNull DropData, @Nullable Void> callback) {
		this.dropCallback = callback;
	}

	@Override
	public @Nullable WCallback<@NonNull DropData, @Nullable Void> getDropDroppedCallback() {
		return this.dropCallback;
	}

	private boolean stateCheck(LazyStackPane.CheckType type) {
		if (!OPTIMIZED_STACK_LAYOUT) {
			return true;
		}

		if (getDomElement() instanceof MPart) {
			MPart p = (MPart) getDomElement();
			if (p != null && ((MUIElement) p.getParent()) instanceof MPartStack) {
				if (p.getParent().getSelectedElement() == p) {
					return true;
				} else {
					return false;
				}
			} else {
				return true;
			}
		} else {
			return true;
		}
	}

	/**
	 * Create the static layout pane
	 *
	 * @return the layout pane
	 */
	@NonNull
	protected Pane createStaticPane() {
		return new InternalFixableLazyStackPane(this::stateCheck, this.isFixed);
	}

	@Override
	public void addStyleClasses(List<String> classnames) {
		getWidgetNode().getStyleClass().addAll(classnames);
		getWidgetNode().applyCss();
	}

	@Override
	public void addStyleClasses(String... classnames) {
		getWidgetNode().getStyleClass().addAll(classnames);
		getWidgetNode().applyCss();
	}

	@Override
	public void removeStyleClasses(List<String> classnames) {
		getWidgetNode().getStyleClass().removeAll(classnames);
		getWidgetNode().applyCss();
	}

	@Override
	public void removeStyleClasses(String... classnames) {
		getWidgetNode().getStyleClass().removeAll(classnames);
		getWidgetNode().applyCss();
	}

	@Override
	public void setStyleId(String id) {
		getWidgetNode().setId(id);
		getWidgetNode().applyCss();
	}

	@Override
	protected void setUserData(WWidgetImpl<N, M> widget) {
		getWidgetNode().setUserData(widget);
	}

	@Override
	public double getWeight() {
		return this.weight;
	}

	@SuppressWarnings("null")
	@Inject
	void setContainerData(@Named(UIEvents.UIElement.CONTAINERDATA) @Optional String data) {
		if (data != null && !data.isEmpty()) {
			try {
				this.weight = Double.parseDouble(data);
				return;
			} catch (Throwable t) {
				this.logger.error(t.getMessage(), t);
			}
		}

		this.weight = 10;
	}
	
	@Inject
	void setFixed(@Optional @Named("persistedState_efxSashFixed") String value) {
		this.isFixed = value != null && Boolean.parseBoolean(value);
		if( this.staticLayoutGroup != null && this.staticLayoutGroup instanceof InternalFixableLazyStackPane ) {
			((InternalFixableLazyStackPane)this.staticLayoutGroup).fixed.set(this.isFixed);
		}
	}

	@Override
	public void setHidden(boolean hidden) {
		getStaticLayoutNode().setVisible(!hidden);
	}

	@Override
	public boolean isHidden() {
		return !getStaticLayoutNode().isVisible();
	}

	static class InternalFixableLazyStackPane extends LazyStackPane implements FixedSashItem {
		public BooleanProperty fixed = new SimpleBooleanProperty(this, "fixed", false); //$NON-NLS-1$

		public InternalFixableLazyStackPane(Predicate<CheckType> checkSupplier, boolean fixed) {
			super(checkSupplier);
			this.fixed.set(fixed);
		}

		@Override
		public ObservableBooleanValue fixed() {
			return this.fixed;
		}
		
		// Force children to not exceed the stack
		@Override
		protected void layoutChildren() {
			getManagedChildren().forEach( c -> c.resizeRelocate(0, 0, getWidth(), getHeight()));
		}
	}
}