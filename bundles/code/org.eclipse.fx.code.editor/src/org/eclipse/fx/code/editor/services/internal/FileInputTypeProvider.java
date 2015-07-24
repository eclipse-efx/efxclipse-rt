package org.eclipse.fx.code.editor.services.internal;

import java.net.URI;

import org.eclipse.fx.code.editor.Input;
import org.eclipse.fx.code.editor.SourceFileInput;
import org.eclipse.fx.code.editor.services.InputTypeProvider;
import org.osgi.service.component.annotations.Component;

@Component
public class FileInputTypeProvider implements InputTypeProvider {

	@Override
	public Class<? extends Input<?>> getType(String s) {
		return SourceFileInput.class;
	}

	@Override
	public boolean test(String t) {
		try {
			URI.create(t);
			return true;
		} catch(Throwable th) {
		}
		return false;
	}

}
