package org.eclipse.fx.code.compensator.nashorn.internal;

import org.eclipse.fx.code.compensator.editor.ContentTypeProvider;
import org.eclipse.fx.code.compensator.editor.Input;
import org.eclipse.fx.code.compensator.editor.Outline;
import org.eclipse.fx.code.compensator.editor.services.OutlineFactory;
import org.eclipse.fx.code.compensator.nashorn.JSOutline;

public class JSOutlineFactory implements OutlineFactory {
	@Override
	public boolean applies(Input<?> input) {
		if( input instanceof ContentTypeProvider ) {
			return ((ContentTypeProvider) input).getContentType() == ContentTypeProvider.JAVASCRIPT;
		}
		return false;
	}

	@Override
	public Class<? extends Outline> createOutline(Input<?> input) {
		return JSOutline.class;
	}


}
