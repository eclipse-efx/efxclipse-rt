package org.eclipse.fx.ui.lifecycle;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;


//when we are ready to ditch the tag-based stuff we simply swap the addon
public class LifecycleAddon {
	
	@Inject
	MApplication app;
	
//	@Inject
//	EModelService modelService;
	
	@Inject
	ELifecycleService lifecycleService;

	public static final String LIFECYCLE_TRANSIENT_KEY="EFX_LIFECYCLE";

	public static final String LIFECYCLE_TAG_PREFIX = "EFX_LC:";
	
	@PostConstruct
	public void postConstruct(){
		TreeIterator<EObject> it = EcoreUtil.getAllContents((EObject)app, true);
		while( it.hasNext() ) {
			EObject e = it.next();
			if( e instanceof MUIElement ) {
				MUIElement element = (MUIElement) e;
				List<String> tags = element.getTags();
				for (String tag: tags) {
					if (tag.startsWith(LIFECYCLE_TAG_PREFIX)) {
						lifecycleService.registerLifecycleURI(element,tag.substring(LIFECYCLE_TAG_PREFIX.length()));
					}
				}
			}
		}		
	}
}