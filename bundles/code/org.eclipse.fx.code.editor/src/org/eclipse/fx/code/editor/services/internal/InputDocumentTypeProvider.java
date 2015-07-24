package org.eclipse.fx.code.editor.services.internal;

import org.eclipse.fx.code.editor.Input;
import org.eclipse.fx.code.editor.services.DocumentTypeProvider;
import org.eclipse.fx.code.editor.services.InputDocument;
import org.eclipse.jface.text.IDocument;
import org.osgi.service.component.annotations.Component;

@Component
public class InputDocumentTypeProvider implements DocumentTypeProvider {

	@Override
	public Class<? extends IDocument> getType(Input<?> s) {
		return InputDocument.class;
	}

	@Override
	public boolean test(Input<?> t) {
		return true;
	}

}