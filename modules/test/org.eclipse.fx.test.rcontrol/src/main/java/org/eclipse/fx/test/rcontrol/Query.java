/*******************************************************************************
 * Copyright (c) 2019 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.test.rcontrol;

import java.util.Optional;
import java.util.stream.Stream;

import javafx.scene.Node;

public interface Query<T extends Node,P> {
	public RNode<T> first();
	public Optional<RNode<T>> firstOpt();
	public Stream<RNode<T>> all();
}
