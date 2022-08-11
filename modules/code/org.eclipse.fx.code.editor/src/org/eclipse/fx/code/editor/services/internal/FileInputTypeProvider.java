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

import java.net.URI;

import org.eclipse.fx.code.editor.Input;
import org.eclipse.fx.code.editor.LocalSourceFileInput;
import org.eclipse.fx.code.editor.services.InputTypeProvider;
import org.osgi.service.component.annotations.Component;

@Component
public class FileInputTypeProvider implements InputTypeProvider {

	@Override
	public Class<? extends Input<?>> getType(String s) {
		return LocalSourceFileInput.class;
	}

	@Override
	public boolean test(String t) {
		try {
			URI.create(t);
			return true;
		} catch(Throwable th) {
		}
		return false;
	}

}
