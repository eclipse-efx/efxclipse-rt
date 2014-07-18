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
package org.eclipse.fx.ui.workbench.renderers.fx.widget;

import java.util.List;

import javafx.scene.Node;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.model.application.ui.MElementContainer;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.workbench.UIEvents;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.fx.core.log.Log;
import org.eclipse.fx.core.log.Logger;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WCallback;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WLayoutedWidget;
import org.eclipse.fx.ui.workbench.renderers.fx.internal.DnDTabPane;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

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

	/**
	 * @return the widget node
	 */
	protected abstract NN getWidgetNode();

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
		staticLayoutGroup.addEventHandler(DragEvent.DRAG_OVER, this::handleDragOver);
		staticLayoutGroup.addEventHandler(DragEvent.DRAG_DROPPED, this::handleDragDropped);
		Node n = getWidgetNode();
		if (n != null) {
			staticLayoutGroup.getChildren().add(n);
		} else {
			this.logger.error("No widget node to attach"); //$NON-NLS-1$
		}
		return staticLayoutGroup;
	}

	/**
	 * Handling the drag over
	 * 
	 * @param e
	 *            the event
	 */
	protected void handleDragOver(DragEvent e) {
		if (this.dropCallback != null) {
			if (!e.getDragboard().hasContent(DnDTabPane.TAB_MOVE)) {
				return;
			}

			@Nullable
			M m = getDomElement();
			if (m instanceof MElementContainer<?>) {
				MElementContainer<?> c = (MElementContainer<?>) m;
				if (c.getChildren().isEmpty()) {
					e.acceptTransferModes(TransferMode.MOVE);
					e.consume();
				}
			}
		}
	}

	private MUIElement findElement(String objectId) {
		EObject eo = (EObject) getDomElement();
		EObject rv = null;
		if (eo != null) {
			rv = ((XMIResource) eo.eResource()).getEObject(objectId);
		}
		if (rv instanceof MUIElement) {
			return (MUIElement) rv;
		}
		return null;
	}

	/**
	 * Handle the drag
	 * 
	 * @param e
	 *            the event
	 */
	protected void handleDragDropped(DragEvent e) {
		if (this.dropCallback != null) {
			if (!e.getDragboard().hasContent(DnDTabPane.TAB_MOVE)) {
				return;
			}

			String objectId = (String) e.getDragboard().getContent(DnDTabPane.TAB_MOVE);

			MUIElement draggedElement = findElement(objectId);
			if (draggedElement == null) {
				return;
			}

			@Nullable
			M m = getDomElement();
			if (m instanceof MElementContainer<?>) {
				MElementContainer<?> c = (MElementContainer<?>) m;
				if (c.getChildren().isEmpty()) {
					@SuppressWarnings("null")
					DropData d = new DropData(getDomElement(), draggedElement, DropType.INSERT);
					this.dropCallback.call(d);
					e.consume();
					e.setDropCompleted(true);
				}
			}
		}
	}

	@Override
	public final void setDragDroppedCallback(@NonNull WCallback<@NonNull DropData, @Nullable Void> callback) {
		this.dropCallback = callback;
	}

	/**
	 * Allow access to the drop callback
	 * @return the callback
	 */
	protected @Nullable WCallback<@NonNull DropData, @Nullable Void> getDropCallback() {
		return this.dropCallback;
	}

	/**
	 * Create the static layout pane
	 * 
	 * @return the layout pane
	 */
	@SuppressWarnings("static-method")
	@NonNull
	protected Pane createStaticPane() {
		return new StackPane();
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
		if (data != null) {
			try {
				this.weight = Double.parseDouble(data);
				return;
			} catch (Throwable t) {
				this.logger.error(t.getMessage(), t);
			}
		}

		this.weight = 10;
	}
}