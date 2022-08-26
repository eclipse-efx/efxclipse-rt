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

import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.fx.text.ui.source.ITextAnnotationPresenter;
import org.eclipse.fx.ui.controls.styledtext.model.Annotation;
import org.eclipse.fx.ui.controls.styledtext.model.TextAnnotationPresenter;

import javafx.scene.Node;

public class WrappedTextAnnotationPresenter implements TextAnnotationPresenter {

	private ITextAnnotationPresenter wrapped;

	public WrappedTextAnnotationPresenter(ITextAnnotationPresenter wrapped) {
		this.wrapped = wrapped;
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
			return wrapped.isApplicable(unwrap(annotation));
		}
		return false;
	}

	@Override
	public Node createNode() {
		return wrapped.createNode();
	}

	@Override
	public boolean isVisible(Annotation annotation) {
		return true;
	}

	@Override
	public void updateNode(Node node, Annotation annotation) {
		wrapped.updateNode(node, unwrap(annotation));
	}

	@Override
	public String toString() {
		return "WAP("+wrapped+")@" + hashCode();
	}

}
