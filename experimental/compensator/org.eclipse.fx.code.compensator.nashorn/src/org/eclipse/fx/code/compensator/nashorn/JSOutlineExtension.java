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
package org.eclipse.fx.code.compensator.nashorn;

import jdk.nashorn.internal.ir.FunctionNode;

import org.eclipse.fx.code.compensator.editor.Input;
import org.eclipse.fx.code.compensator.editor.Outline.OutlineItem;
import org.eclipse.fx.ui.services.resources.GraphicsLoader;

public interface JSOutlineExtension {
	public boolean applies(Input<?> input);
	public OutlineItem createOutline(FunctionNode node, Input<?> input, GraphicsLoader loader);
}
