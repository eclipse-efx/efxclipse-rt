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
package org.eclipse.fx.test.rcontrol.impl;

import java.util.Optional;
import java.util.stream.Stream;

import org.eclipse.fx.test.rcontrol.Query;
import org.eclipse.fx.test.rcontrol.RController;
import org.eclipse.fx.test.rcontrol.RNode;

import javafx.scene.Node;

public class CSSQuery<T extends Node> implements Query<T, String> {
	private final Node context;
	private final String selector;
	private final RController controller;
	
	public CSSQuery(RController controller, Node context, String selector) {
		this.controller = controller;
		this.context = context;
		this.selector = selector;
	}
	
	@Override
	public RNode<T> first() {
		return firstOpt().get();
	}

	@Override
	public Optional<RNode<T>> firstOpt() {
		return all().findFirst();
	}

	@Override
	public Stream<RNode<T>> all() {
		if (context != null) {
			return context.lookupAll(selector).stream().map(v -> new RNodeImpl<>((T) v, controller));
		}
		return Stream.empty();
	}
}
