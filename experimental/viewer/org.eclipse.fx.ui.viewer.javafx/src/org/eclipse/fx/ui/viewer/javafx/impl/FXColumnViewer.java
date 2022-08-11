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
package org.eclipse.fx.ui.viewer.javafx.impl;

import org.eclipse.fx.ui.viewer.ColumnViewer;
import org.eclipse.fx.ui.viewer.ContentProvider;

public abstract class FXColumnViewer<I, O, C extends ContentProvider<I, O>> extends FXViewer<I, O, C> implements ColumnViewer<I, O, C> {

}
