/*******************************************************************************
 * Copyright (c) 2016 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core;

import org.eclipse.fx.core.Status.ValueStatus;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

class ValueStatusImpl<@Nullable O> extends StatusImpl implements ValueStatus<O> {
	private final @Nullable O value;

	public ValueStatusImpl(@Nullable O value, @NonNull State state, int code, @Nullable String message, @Nullable Throwable throwable) {
		super(state, code, message, throwable);
		this.value = value;
	}

	@Override
	public O getValue() {
		return this.value;
	}
}
