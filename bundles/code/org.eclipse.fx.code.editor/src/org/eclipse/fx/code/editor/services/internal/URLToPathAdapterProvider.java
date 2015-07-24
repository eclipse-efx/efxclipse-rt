package org.eclipse.fx.code.editor.services.internal;

import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.eclipse.fx.core.adapter.AdapterProvider;
import org.eclipse.fx.core.adapter.AdapterService.ValueAccess;
import org.osgi.service.component.annotations.Component;

@Component
public class URLToPathAdapterProvider implements AdapterProvider<String, Path> {

	@Override
	public Class<String> getSourceType() {
		return String.class;
	}

	@Override
	public Class<Path> getTargetType() {
		return Path.class;
	}

	@Override
	public boolean canAdapt(String sourceObject, Class<Path> targetType) {
		try {
			URI uri = URI.create(sourceObject);
			Paths.get(uri);
			return true;
		} catch(Throwable t) {
		}
		return false;
	}

	@Override
	public Path adapt(String sourceObject, Class<Path> targetType, ValueAccess... valueAccess) {
		URI uri = URI.create(sourceObject);
		return Paths.get(uri);
	}

}
