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
