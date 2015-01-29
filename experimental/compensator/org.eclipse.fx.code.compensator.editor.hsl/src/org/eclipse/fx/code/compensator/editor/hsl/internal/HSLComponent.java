/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.code.compensator.editor.hsl.internal;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.fx.code.compensator.editor.ContentTypeProvider;
import org.eclipse.fx.code.compensator.editor.Input;
import org.eclipse.fx.code.compensator.editor.URIProvider;
import org.eclipse.fx.code.compensator.editor.hsl.HSLConfiguration;
import org.eclipse.fx.code.compensator.editor.hsl.HSLRuleBasedPartitionScanner;
import org.eclipse.fx.code.compensator.editor.services.ContentTypeDetector;
import org.eclipse.fx.code.compensator.editor.services.PartitionerFactory;
import org.eclipse.fx.code.compensator.editor.services.SourceViewerConfigurationFactory;
import org.eclipse.fx.code.compensator.hsl.HSLStandaloneSetup;
import org.eclipse.fx.code.compensator.hsl.hSL.JavaLikeParitioner;
import org.eclipse.fx.code.compensator.hsl.hSL.Model;
import org.eclipse.fx.code.compensator.hsl.hSL.Partitioner;
import org.eclipse.fx.code.compensator.hsl.hSL.RulePartitioner;
import org.eclipse.fx.core.FilesystemService;
import org.eclipse.fx.core.FilesystemService.Kind;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentPartitioner;
import org.eclipse.jface.text.rules.FastPartitioner;
import org.eclipse.jface.text.rules.IPartitionTokenScanner;
import org.eclipse.jface.text.source.FastJavaLikePartitionScanner;
import org.eclipse.jface.text.source.SourceViewerConfiguration;

public class HSLComponent implements PartitionerFactory, SourceViewerConfigurationFactory, ContentTypeDetector {
	private Map<String, Model> contentTypeMappings = new HashMap<>();
	private Map<String, String> fileEndMappings = new HashMap<>();
	private ResourceSetImpl rs;
	private FilesystemService filesystemService;

	public HSLComponent() {
		HSLStandaloneSetup.doSetup();
		rs = new ResourceSetImpl();
//		registerHslConfig(".xml",URI.createPlatformPluginURI("/org.eclipse.fx.code.compensator.editor.hsl/xml/xml.hsl", true));
//		registerHslConfig(".groovy",URI.createPlatformPluginURI("/org.eclipse.fx.code.compensator.editor.hsl/groovy/groovy.hsl", true));
//		registerHslConfig(".hsl",URI.createPlatformPluginURI("/org.eclipse.fx.code.compensator.editor.hsl/hsl/hsl.hsl", true));
//		registerHslConfig(URI.createPlatformPluginURI("/org.eclipse.fx.code.compensator.editor.hsl/lego/lego.hsl", true));
	}

	public void activate() {
		loadExternalConfigurations();
	}

	public void registerFilesystemService(FilesystemService s) {
		this.filesystemService = s;
	}

	public void unregisterFilesystemService(FilesystemService s) {
		this.filesystemService = null;
	}

	@Override
	public String getContentType(Input<?> input) {
		if( input instanceof URIProvider ) {
			org.eclipse.fx.core.URI uri = ((URIProvider) input).getURI();
			int idx = uri.lastSegment().lastIndexOf('.');
			if( idx > -1 ) {
				String rv = fileEndMappings.get(uri.lastSegment().substring(idx));
				return rv;
			}

		}
		return null;
	}

	private void loadExternalConfigurations() {
		File folder = new File(System.getProperty("user.home")+"/.compensator/languages");
		if( folder.exists() ) {
			Path path = Paths.get(folder.toURI());
			try {
				Files.walk(path,1).filter((p) -> !p.equals(path)).forEach(this::handleLanguage);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		filesystemService.observePath(Paths.get(folder.toURI()), this::handleNewLanguage);
	}

	private void handleNewLanguage(Kind kind, Path path) {
		String name = path.getFileName().toString();
		if( name.endsWith(".comp") ) {
			java.io.File folder = new java.io.File(System.getProperty("user.home")+"/.compensator/languages/"+name.substring(0,name.length()-5));
			folder.mkdir();

			byte[] buffer = new byte[2048];
			InputStream newInputStream;
			try {
				newInputStream = Files.newInputStream(path);
				ZipInputStream zin = new ZipInputStream(newInputStream);
				ZipEntry entry;
				while( (entry = zin.getNextEntry()) != null ) {
					java.io.File f = new java.io.File(folder,entry.getName());
					FileOutputStream output = null;
		            try
		            {
		                output = new FileOutputStream(f);
		                int len = 0;
		                while ((len = zin.read(buffer)) > 0)
		                {
		                    output.write(buffer, 0, len);
		                }
		            }
		            finally
		            {
		                // we must always close the output file
		                if(output!=null) output.close();
		            }
				}

				zin.close();
				newInputStream.close();
				handleLanguage(Paths.get(folder.toURI()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void handleLanguage(Path directory) {
		Path propertyFile = directory.resolve("config.properties");
		if( Files.exists(propertyFile) ) {
			Properties p = new Properties();
			try( Reader r = Files.newBufferedReader(propertyFile) ) {
				p.load(r);

				Path dslfile = directory.resolve(p.getProperty("dslfile"));

				if( Files.exists(dslfile) ) {
					registerHslConfig(p.getProperty("fileextension"),URI.createURI(dslfile.toUri().toString()));
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//
//
//			p.load(inStream);
//			;
		}

	}

	@Override
	public Class<? extends SourceViewerConfiguration> createConfiguration(Input<?> input) {
//		Model m = getModelForInput(input);
//		if( m == null ) {
//			throw new IllegalArgumentException("Unsupported input '"+input+"'");
//		}
//
//		return new HSLConfiguration(getClass().getClassLoader(), m);
		return HSLConfiguration.class;
	}

	private void registerHslConfig(String fileEnding, URI uri) {
		System.err.println("REGISTERING: " + fileEnding + " => " + uri);
		Model m = loadModel(uri);
		for( String t : m.getContentTypes() ) {
			contentTypeMappings.put(t, m);
			fileEndMappings.put(fileEnding, t);
		}
	}

	private Model loadModel(URI uri) {
		Resource resource = rs.getResource(uri, true);
		return (Model) resource.getContents().get(0);
	}

	@Override
	public boolean applies(Input<?> input) {
		if( input instanceof ContentTypeProvider ) {
			return contentTypeMappings.containsKey(((ContentTypeProvider) input).getContentType());
		}
		return false;
	}

	public Model getModelForInput(Input<?> input) {
		if( input instanceof ContentTypeProvider ) {
			return contentTypeMappings.get(((ContentTypeProvider) input).getContentType());
		}
		return null;
	}

	private String[] getParitions(Model m) {
		return m.getPartitions().stream().filter((p) -> { return ! p.getName().equals(IDocument.DEFAULT_CONTENT_TYPE); })
				.map((p) -> p.getName())
				.toArray((size) -> new String[size]);
	}

	@Override
	public IDocumentPartitioner createPartitioner(Input<?> input) {
		Model m = getModelForInput(input);
		if( m == null ) {
			throw new IllegalArgumentException("Unsupported input '"+input+"'");
		}


		Partitioner partitioner = m.getPartitioner();
		IPartitionTokenScanner scanner = null;
		if( partitioner instanceof RulePartitioner ) {
			scanner = new HSLRuleBasedPartitionScanner(getClass().getClassLoader(), (RulePartitioner) m.getPartitioner());
		} else if( partitioner instanceof JavaLikeParitioner ) {
			JavaLikeParitioner jp = (JavaLikeParitioner) partitioner;
			scanner = new FastJavaLikePartitionScanner(
					jp.getSingleLineDocParition().getName(),
					jp.getMultiLineDocParition().getName(),
					jp.getJavaDocParition().getName(),
					jp.getCharacterParition().getName(),
					jp.getStringParition().getName());
		}

		if( scanner != null ) {
			return new FastPartitioner(scanner, getParitions(m));
		}

		throw new IllegalStateException("Unsupported partitioner '"+partitioner+"'");
	}

	@Override
	public List<ConfigurationType> getConfigurationData() {
		// TODO Auto-generated method stub
		return null;
	}
}
