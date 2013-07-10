package org.eclipse.fx.ui.internal.lifecycle;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.services.contributions.IContributionFactory;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.MContext;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.fx.ui.lifecycle.ELifecycleService;
import org.eclipse.fx.ui.lifecycle.LifecycleAddon;

public class LifecycleServiceImpl implements ELifecycleService{

	@Inject
	private EModelService modelService;
	
	@Inject
	private MApplication app;

	@Inject
	private IContributionFactory factory;

	public void registerLifecycleURI(MUIElement element, String lifecycleURI) {
		Set<Object> contributions = (Set<Object>) element.getTransientData().get(LifecycleAddon.LIFECYCLE_TRANSIENT_KEY);
		if (contributions == null) {
			contributions = new HashSet<Object>();
			element.getTransientData().put(LifecycleAddon.LIFECYCLE_TRANSIENT_KEY, contributions);
		}
		
		Object object = factory.create(lifecycleURI, app.getContext());
		contributions.add(object);
		
	}

	public boolean validateAnnotation(Class annotationClass, MUIElement element) {
		return validateLifecycleAnnotation(annotationClass, getContextForParent(element), getModelContext(element), element);
	}
	
	private boolean validateLifecycleAnnotation(Class clazz, IEclipseContext parentContext,
			IEclipseContext partContext, MUIElement part) {
				Set<Object> set = (Set<Object>) part.getTransientData().get(LifecycleAddon.LIFECYCLE_TRANSIENT_KEY);
				if (set!=null){
					for (Object object : set) {
						Object invokeResult = ContextInjectionFactory.invoke(object, clazz, parentContext, partContext,true);
						if (invokeResult!=null){//supports void methods
							return (boolean)invokeResult;
						}
						else return true;
					}
				}
			return true;
		}
	private IEclipseContext getContextForParent(MUIElement element) {
		return modelService.getContainingContext(element);
	}

	private IEclipseContext getModelContext(MUIElement part) { 
		if (part instanceof MContext) {
			return ((MContext) part).getContext();
		}
		return getContextForParent(part);
	}

	@Override
	public void unregisterLifecycleContribution(MUIElement element,
			Object contribution) {
		Set<Object> objects = (Set<Object>) element.getTransientData().get(LifecycleAddon.LIFECYCLE_TRANSIENT_KEY);
		if (objects!=null) objects.remove(contribution);
	}

}