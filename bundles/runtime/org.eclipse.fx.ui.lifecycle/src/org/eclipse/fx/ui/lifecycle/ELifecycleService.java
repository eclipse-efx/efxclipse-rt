package org.eclipse.fx.ui.lifecycle;

import org.eclipse.e4.ui.model.application.ui.MUIElement;

public interface ELifecycleService {
	
	public void registerLifecycleURI(MUIElement element, String lifecycleURI);

	public void unregisterLifecycleContribution(MUIElement element, Object contribution);
	
	public boolean validateAnnotation(Class annotationClass, MUIElement element);

}