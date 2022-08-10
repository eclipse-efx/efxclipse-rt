/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.viewer;

import java.util.function.Consumer;

public interface ViewerFactory {
	public <I,O,C extends ContentProvider<I, O>, V extends TableViewer<I, O,C>,W> V createTableViewer(W ownerWidget, Consumer<V> setup);
	public <I,O,C extends ContentProvider<I, O>, V extends ListViewer<I, O,C>,W> V createListViewer(W ownerWidget, Consumer<V> setup);
}
