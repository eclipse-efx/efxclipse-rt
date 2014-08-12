/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.viewer;

import java.util.function.Function;

public interface ColumnViewer<I, O, C extends ContentProvider<I, O>> extends Viewer<I, O, C> {
	public <T> ViewerColumn<O,T> createColumn(String id, Function<O, T> cellDataProvider);
}
