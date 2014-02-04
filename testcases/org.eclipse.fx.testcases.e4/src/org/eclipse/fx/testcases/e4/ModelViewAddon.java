/*******************************************************************************
 * Copyright (c) 2013 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.testcases.e4;

import javax.annotation.PostConstruct;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.fx.ui.modelviewer.ModelProvider;

public class ModelViewAddon {
	@PostConstruct
	void init(final IEclipseContext ctx) {
		ctx.set(ModelProvider.class, new ModelProvider() {
			
			@Override
			public MApplication getApplication() {
				return ctx.get(MApplication.class);
			}
		});
	}
}
