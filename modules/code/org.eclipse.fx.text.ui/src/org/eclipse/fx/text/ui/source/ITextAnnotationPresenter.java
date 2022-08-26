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
package org.eclipse.fx.text.ui.source;

import org.eclipse.jface.text.source.Annotation;

import javafx.scene.Node;

public interface ITextAnnotationPresenter extends IAnnotationPresenter {

	/**
	 * <p>Performance Hint:
	 *     try to prevent adding nodes here!
	 * </p>
	 * @param node
	 * @param annotation
	 */
	void updateNode(Node node, Annotation annotation);

}
