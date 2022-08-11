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
package org.eclipse.fx.code.compensator.project.jdt.internal;

import org.eclipse.fx.code.compensator.editor.Input;
import org.eclipse.fx.code.compensator.editor.services.AnnotationModelFactory;
import org.eclipse.jface.text.source.IAnnotationModel;

public class JDTAnnotationModelFactory implements AnnotationModelFactory {

	@Override
	public boolean applies(Input<?> input) {
		return input instanceof JDTServerInput;
	}

	@Override
	public Class<? extends IAnnotationModel> getAnnotationModelType() {
		return JDTAnnotationModel.class;
	}

}
