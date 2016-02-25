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

import java.util.Set;
import java.util.function.Consumer;

import org.eclipse.fx.core.Subscription;

import com.google.common.collect.RangeSet;

public interface AnnotationProvider {

	Set<? extends Annotation> computeAnnotations(int index);

	Subscription registerChangeListener(Consumer<RangeSet<Integer>> onChange);
}
