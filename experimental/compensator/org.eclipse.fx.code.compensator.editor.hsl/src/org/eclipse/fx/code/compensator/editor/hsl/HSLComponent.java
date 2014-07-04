package org.eclipse.fx.code.compensator.editor.hsl;

import org.eclipse.fx.code.compensator.editor.Input;
import org.eclipse.fx.code.compensator.editor.services.PartitionerFactory;
import org.eclipse.fx.code.compensator.editor.services.SourceViewerConfigurationFactory;
import org.eclipse.jface.text.IDocumentPartitioner;
import org.eclipse.jface.text.source.SourceViewerConfiguration;

public class HSLComponent implements PartitionerFactory, SourceViewerConfigurationFactory {

	@Override
	public SourceViewerConfiguration createConfiguration(Input<?> input) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean applies(Input<?> input) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public IDocumentPartitioner createPartitioner(Input<?> input) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
