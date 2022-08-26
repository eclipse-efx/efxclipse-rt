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
* 	Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
*******************************************************************************/
package org.eclipse.fx.code.compensator.editor.services;

import org.eclipse.fx.code.compensator.editor.Input;
import org.eclipse.jface.text.IDocumentPartitioner;

public interface PartitionerFactory {
	public boolean applies(Input<?> input);
	public IDocumentPartitioner createPartitioner(Input<?> input);
}
