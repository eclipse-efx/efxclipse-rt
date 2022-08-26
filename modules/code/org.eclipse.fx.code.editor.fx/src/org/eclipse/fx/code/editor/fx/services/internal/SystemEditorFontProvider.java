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
package org.eclipse.fx.code.editor.fx.services.internal;

import org.eclipse.fx.code.editor.fx.services.EditorFontProvider;
import org.osgi.service.component.annotations.Component;

@Component
public class SystemEditorFontProvider implements EditorFontProvider {

	@Override
	public String getLabel() {
		return "Default";
	}

	@Override
	public String getName() {
		return "Courier";
	}
}
