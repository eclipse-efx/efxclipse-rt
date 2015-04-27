package org.eclipse.fx.testcases.e4;

import javax.inject.Inject;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.fx.ui.workbench.renderers.fx.DefWorkbenchRendererFactory;
import org.eclipse.jdt.annotation.NonNull;

public class CustomRendererFactory extends DefWorkbenchRendererFactory {
	@Inject
	public CustomRendererFactory(@NonNull IEclipseContext context) {
		super(context);
	}

//	@Override
//	protected Class<? extends BaseMenuRenderer<?>> getMenuRendererClass() {
//		return MyDefMenuRenderer.class;
//	}
}
