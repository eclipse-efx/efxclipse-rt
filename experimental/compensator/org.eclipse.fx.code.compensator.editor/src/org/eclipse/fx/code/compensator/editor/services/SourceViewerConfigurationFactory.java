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
package org.eclipse.fx.code.compensator.editor.services;

import java.util.List;

import org.eclipse.fx.code.compensator.editor.Input;
import org.eclipse.fx.ui.services.resources.GraphicsLoader;
import org.eclipse.jface.text.source.SourceViewerConfiguration;

public interface SourceViewerConfigurationFactory {
	public static class ConfigurationData {
		public String name;
		public List<ConfigurationType> configurationTypes;
	}

	public static class ConfigurationType {
		public String name;
		public String contentType;
	}

	public boolean applies(Input<?> input);
	public Class<? extends SourceViewerConfiguration> createConfiguration(Input<?> input);
}
