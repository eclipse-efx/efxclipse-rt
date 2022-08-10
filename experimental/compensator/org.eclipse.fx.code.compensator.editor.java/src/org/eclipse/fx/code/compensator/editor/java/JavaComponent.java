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
package org.eclipse.fx.code.compensator.editor.java;

import java.util.List;

import org.eclipse.fx.code.compensator.editor.ContentTypeProvider;
import org.eclipse.fx.code.compensator.editor.Input;
import org.eclipse.fx.code.compensator.editor.java.scanner.FastJavaPartitionScanner;
import org.eclipse.fx.code.compensator.editor.java.scanner.IJavaPartitions;
import org.eclipse.fx.code.compensator.editor.services.FileIconProvider;
import org.eclipse.fx.code.compensator.editor.services.PartitionerFactory;
import org.eclipse.fx.code.compensator.editor.services.SourceViewerConfigurationFactory;
import org.eclipse.fx.core.URI;
import org.eclipse.jface.text.IDocumentPartitioner;
import org.eclipse.jface.text.rules.FastPartitioner;
import org.eclipse.jface.text.source.SourceViewerConfiguration;

public class JavaComponent implements PartitionerFactory, SourceViewerConfigurationFactory, FileIconProvider {
	private final static String[] LEGAL_CONTENT_TYPES= new String[] {
		IJavaPartitions.JAVA_DOC,
		IJavaPartitions.JAVA_MULTI_LINE_COMMENT,
		IJavaPartitions.JAVA_SINGLE_LINE_COMMENT,
		IJavaPartitions.JAVA_STRING,
		IJavaPartitions.JAVA_CHARACTER
	};

	@Override
	public Class<? extends SourceViewerConfiguration> createConfiguration(Input<?> input) {
//		return new JavaSourceConfiguration(input, createProposalComputer(input,graphicsLoader));
		return JavaSourceConfiguration.class;
	}

	@Override
	public boolean applies(Input<?> input) {
		if( input instanceof ContentTypeProvider ) {
			String contentType = ((ContentTypeProvider) input).getContentType();
			return ContentTypeProvider.JAVA.equals(contentType);
		}
		return false;
	}

	@Override
	public IDocumentPartitioner createPartitioner(Input<?> input) {
		return new FastPartitioner(
				new FastJavaPartitionScanner(),
				LEGAL_CONTENT_TYPES);
	}

	@Override
	public boolean applies(String uri) {
		return uri.endsWith(".java");
	}

	@Override
	public URI getIcon(String uri) {
		return URI.createPlatformPluginURI("org.eclipse.fx.code.compensator.editor.java","icons/16/java-file.png");
	}

	@Override
	public List<ConfigurationType> getConfigurationData() {
		// TODO Auto-generated method stub
		return null;
	}
}