/*******************************************************************************
 * Copyright (c) 2017 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Martin Bluehweis <martin.bluehweis@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.annotation.PreDestroy;

import javafx.beans.binding.Binding;

/**
 * Collector for {@link Subscription} and {@link Binding}
 */
public class DisposableCollector {
	private final List<Subscription> subscriptions = new ArrayList<>();

	/**
	 * Add a {@link Subscription}
	 * 
	 * @param subscription
	 *            subscription
	 */
	public void add(Subscription subscription) {
		this.subscriptions.add(Objects.requireNonNull(subscription));
	}

	/**
	 * Add a {@link Binding}
	 * 
	 * @param binding
	 *            binding
	 */
	public void add(Binding<?> binding) {
		add(() -> binding.dispose());
	}

	/**
	 * dispose all collected subscriptions and bindings
	 */
	@PreDestroy
	public void dispose() {
		this.subscriptions.forEach(s -> s.dispose());
		this.subscriptions.clear();
	}
}
