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
package org.eclipse.fx.ui.controls.styledtext.model;

import java.util.Optional;
import java.util.Set;
import java.util.function.BiConsumer;

import org.eclipse.fx.core.Subscription;

import javafx.beans.property.DoubleProperty;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;

// TODO add some kind of layout hinting to position node for example on the right side
public interface LineRulerAnnotationPresenter extends AnnotationPresenter {

	enum LayoutHint {
		ALIGN_RIGHT,
		ALIGN_LEFT,
		ALIGN_CENTER;
	}

	LayoutHint getLayoutHint();

	DoubleProperty getWidth();

	int getOrder();

	// TODO use me or remove me
	boolean isVisible(Set<Annotation> annotation);


	void updateNode(Node node, Set<Annotation> annotation);



	public static interface LineRuler {
		Subscription subscribeMousePressed(BiConsumer<Integer, MouseEvent> callback);
		Subscription subscribeMouseReleased(BiConsumer<Integer, MouseEvent> callback);
		Subscription subscribeMouseClicked(BiConsumer<Integer, MouseEvent> callback);
	}

	default void initialize(LineRuler lineRuler) {}

	default Optional<String> getStyleClass() { return Optional.empty(); }
}
