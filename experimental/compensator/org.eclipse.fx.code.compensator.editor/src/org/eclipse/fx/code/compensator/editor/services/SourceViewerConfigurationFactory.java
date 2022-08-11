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
	public List<ConfigurationType> getConfigurationData();
	public Class<? extends SourceViewerConfiguration> createConfiguration(Input<?> input);
}
