package org.eclipse.fx.ui.lifecycle;

import java.lang.annotation.Annotation;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.model.application.ui.MUIElement;

public interface ELifecycleService {
	
	public void registerLifecycleURI(MUIElement element, String lifecycleURI);

	public void unregisterLifecycleContribution(MUIElement element, Object contribution);
	
	public boolean validateAnnotation(Class<? extends Annotation> annotationClass, MUIElement element, IEclipseContext context);

}