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
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.runtime.fswt.noop.internal;

import org.eclipse.fx.runtime.fswt.FSWT;
import org.eclipse.fx.runtime.fswt.FSWTObject;

public class NSWTObject<T> implements FSWTObject<T> {
	private final T instance;
	private final FSWT fswt;

	public NSWTObject(T instance, FSWT fswt) {
		this.instance = instance;
		this.fswt = fswt;
	}

	public FSWT getFSWT() {
		return fswt;
	}

	@Override
	public T getNativeInstance() {
		return instance;
	}

}
