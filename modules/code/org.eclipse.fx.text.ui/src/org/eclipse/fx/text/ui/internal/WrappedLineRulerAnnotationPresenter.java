/*******************************************************************************
 * Copyright (c) 2022 BestSolution.at and others.
 *  
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *  
 * SPDX-License-Identifier: EPL-2.0
 *  
 * Contributors:
 *     BestSolution.at - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.text.ui.internal;

import java.util.Optional;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

import org.eclipse.fx.core.Subscription;
import org.eclipse.fx.text.ui.source.ILineRulerAnnotationPresenter;
import org.eclipse.fx.ui.controls.styledtext.model.Annotation;
import org.eclipse.fx.ui.controls.styledtext.model.LineRulerAnnotationPresenter;

import javafx.beans.property.DoubleProperty;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;

public class WrappedLineRulerAnnotationPresenter implements LineRulerAnnotationPresenter {

	private ILineRulerAnnotationPresenter wrapped;

	public WrappedLineRulerAnnotationPresenter(ILineRulerAnnotationPresenter wrapped) {
		this.wrapped = wrapped;
	}

	@Override
	public LayoutHint getLayoutHint() {
		return LayoutHint.valueOf(this.wrapped.getLayoutHint().toString());
	}

	@Override
	public int getOrder() {
		return this.wrapped.getOrder();
	}

	private org.eclipse.jface.text.source.Annotation unwrap(Annotation annotation) {
		return ((WrappedAnnotation) annotation).getAnnotation();
	}

	private Set<org.eclipse.jface.text.source.Annotation> unwrap(Set<Annotation> annotations) {
		return annotations.stream().map(this::unwrap).collect(Collectors.toSet());
	}

	@Override
	public boolean isApplicable(Annotation annotation) {
		if (annotation instanceof WrappedAnnotation) {
			return this.wrapped.isApplicable(unwrap(annotation));
		}
		return false;
	}

	@Override
	public Node createNode() {
		return this.wrapped.createNode();
	}

	@Override
	public DoubleProperty getWidth() {
		return this.wrapped.getWidth();
	}

	@Override
	public boolean isVisible(Set<Annotation> annotation) {
		return true;
	}

	@Override
	public void updateNode(Node node, Set<Annotation> annotation) {
		this.wrapped.updateNode(node, unwrap(annotation));
	}

	@Override
	public void initialize(LineRuler lineRuler) {
		this.wrapped.initialize(new org.eclipse.fx.text.ui.source.ILineRulerAnnotationPresenter.LineRuler() {
			@Override
			public Subscription subscribeMouseReleased(BiConsumer<Integer, MouseEvent> callback) {
				return lineRuler.subscribeMouseReleased(callback);
			}
			@Override
			public Subscription subscribeMousePressed(BiConsumer<Integer, MouseEvent> callback) {
				return lineRuler.subscribeMousePressed(callback);
			}
			@Override
			public Subscription subscribeMouseClicked(BiConsumer<Integer, MouseEvent> callback) {
				return lineRuler.subscribeMouseClicked(callback);
			}
		});
	}
	
	@Override
	public Optional<String> getStyleClass() {
		return this.wrapped.getStyleClass();
	}

	@Override
	public String toString() {
		return "WAP("+this.wrapped+")@" + hashCode(); //$NON-NLS-2$
	}

}
