/*******************************************************************************
* Copyright (c) 2016 BestSolution.at and others.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
* 	Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
*******************************************************************************/
package org.eclipse.fx.text.ui.source;

import java.util.Set;
import java.util.function.BiConsumer;

import org.eclipse.fx.core.Subscription;
import org.eclipse.jface.text.source.Annotation;

import javafx.beans.property.DoubleProperty;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;

/**
 * Presents annotation in a line ruler
 */
public interface ILineRulerAnnotationPresenter extends IAnnotationPresenter {

	/**
	 * Layout hint
	 */
	enum LayoutHint {
		ALIGN_LEFT, ALIGN_RIGHT, ALIGN_CENTER;
	}

	int getOrder();

	/**
	 * Update the node with the provided annotations
	 *
	 * @param node
	 *            the node
	 * @param annotation
	 *            the set of annotation to be presented by the node
	 */
	void updateNode(Node node, Set<Annotation> annotation);

	/**
	 * @return the layout hint
	 */
	LayoutHint getLayoutHint();

	/**
	 * @return the width of the ruler
	 */
	DoubleProperty getWidth();

	/**
	 * Line ruler instance
	 */
	public static interface LineRuler {
		/**
		 * Subscribe to mouse pressed
		 *
		 * @param callback
		 *            the callback
		 * @return the subscription
		 */
		Subscription subscribeMousePressed(BiConsumer<Integer, MouseEvent> callback);

		/**
		 * Subscribe to mouse released
		 *
		 * @param callback
		 *            the callback
		 * @return the subscription
		 */
		Subscription subscribeMouseReleased(BiConsumer<Integer, MouseEvent> callback);

		/**
		 * Subscribe to mouse clicked
		 *
		 * @param callback
		 *            the callback
		 * @return the subscription
		 */
		Subscription subscribeMouseClicked(BiConsumer<Integer, MouseEvent> callback);
	}

	/**
	 * Initialize the line ruler
	 *
	 * @param lineRuler
	 *            the ruler to initialize
	 */
	default void initialize(LineRuler lineRuler) {
		// empty by default
	}

}
