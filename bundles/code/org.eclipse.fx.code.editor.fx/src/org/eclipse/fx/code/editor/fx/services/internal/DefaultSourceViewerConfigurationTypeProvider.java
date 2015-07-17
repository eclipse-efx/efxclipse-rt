package org.eclipse.fx.code.editor.fx.services.internal;

import org.eclipse.fx.code.editor.Input;
import org.eclipse.fx.code.editor.fx.services.SourceViewerConfigurationTypeProvider;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.osgi.service.component.annotations.Component;

@Component
public class DefaultSourceViewerConfigurationTypeProvider implements SourceViewerConfigurationTypeProvider {

	@Override
	public boolean test(Input<?> input) {
		return true;
	}

	@Override
	public Class<? extends SourceViewerConfiguration> getType(Input<?> input) {
		return DefaultSourceViewerConfiguration.class;
	}

}
