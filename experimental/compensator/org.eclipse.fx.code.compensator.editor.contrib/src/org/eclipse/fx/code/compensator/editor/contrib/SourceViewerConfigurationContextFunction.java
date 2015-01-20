/*******************************************************************************
* Copyright (c) 2014 BestSolution.at and others.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
* 	Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
*******************************************************************************/
package org.eclipse.fx.code.compensator.editor.contrib;

import org.eclipse.e4.core.contexts.ContextFunction;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.fx.code.compensator.editor.Input;
import org.eclipse.fx.ui.services.resources.GraphicsLoader;
import org.eclipse.jface.text.source.SourceViewerConfiguration;

public class SourceViewerConfigurationContextFunction extends ContextFunction {
	@Override
	public Object compute(IEclipseContext context) {
		SourceViewerConfiguration config = (SourceViewerConfiguration) context.get("localSourceConfig");
		if( config == null ) {
			config = context.get(ServiceCollector.class).createConfiguration(context.get(Input.class),context.get(GraphicsLoader.class));
			context.set("localSourceConfig", config);
		}
		return config;
	}
}
