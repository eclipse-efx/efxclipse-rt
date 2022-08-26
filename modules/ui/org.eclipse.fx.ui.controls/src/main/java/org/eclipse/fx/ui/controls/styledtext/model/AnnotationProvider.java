/*******************************************************************************
 * Copyright (c) 2016 BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 * 	Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.controls.styledtext.model;

import java.util.Set;
import java.util.function.Consumer;

import org.eclipse.fx.core.Subscription;

import com.google.common.collect.RangeSet;

public interface AnnotationProvider {

	Set<? extends Annotation> computeAnnotations(int index);

	Subscription registerChangeListener(Consumer<RangeSet<Integer>> onChange);
}
