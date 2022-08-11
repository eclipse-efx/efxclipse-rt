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
package org.eclipse.fx.code.editor.services.internal;

import org.eclipse.fx.code.editor.Input;
import org.eclipse.fx.code.editor.services.DelegatingEditingContext;
import org.eclipse.fx.code.editor.services.EditingContext;
import org.eclipse.fx.code.editor.services.EditingContextTypeProvider;
import org.osgi.service.component.annotations.Component;

@Component
public class DelegatingEditingContextTypeProvider implements EditingContextTypeProvider {

	@Override
	public Class<? extends EditingContext> getType(Input<?> s) {
		return DelegatingEditingContext.class;
	}

	@Override
	public boolean test(Input<?> t) {
		return true;
	}

}
