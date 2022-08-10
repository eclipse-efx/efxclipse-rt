/*******************************************************************************
 * Copyright (c) 2019 BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
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
