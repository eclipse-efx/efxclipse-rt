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
package org.eclipse.fx.code.editor.e4;

import org.eclipse.fx.code.editor.Input;
import org.eclipse.fx.core.TypeProviderService;
import org.eclipse.fx.core.di.context.TypeProviderContextFunction;

@SuppressWarnings("restriction")
public abstract class InputBasedContextFunction<T,P extends TypeProviderService<Input<?>,T>> extends TypeProviderContextFunction<Input<?>, T, P> {

	public InputBasedContextFunction() {
		super(Input.class.getName());
	}

}
