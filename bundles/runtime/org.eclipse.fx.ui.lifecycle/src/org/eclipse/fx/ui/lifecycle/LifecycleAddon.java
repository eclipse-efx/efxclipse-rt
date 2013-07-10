package org.eclipse.fx.ui.lifecycle;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.MApplicationElement;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.advanced.MPerspective;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.model.application.ui.basic.MWindow;
import org.eclipse.e4.ui.workbench.modeling.EModelService;


//when we are ready to ditch the tag-based stuff we simply swap the addon
public class LifecycleAddon {
	
	@Inject
	MApplication app;
	
	@Inject
	EModelService modelService;
	
	@Inject
	ELifecycleService lifecycleService;

	public static final String LIFECYCLE_TRANSIENT_KEY="EFX_LIFECYCLE";

	public static final String LIFECYCLE_TAG_PREFIX = "EFX_LC:";
	
	@PostConstruct
	public void postConstruct(){
		//initial processing
		process(MPart.class, app);
		process(MWindow.class,app);
		process(MPerspective.class,app);
		//TODO - register an EH to watch for addition/removal of tags
		
	}

	private void process(Class<? extends MUIElement> clazz, MUIElement root) {
		List<? extends MUIElement> elements = modelService.findElements(root, null, clazz, null);
		for (MUIElement element : elements) {
			//build lifecycle uris set (because no duplicates allowed)
			List<String> tags = element.getTags();
			for (String tag: tags) {
				if (tag.startsWith(LIFECYCLE_TAG_PREFIX)) {
					lifecycleService.registerLifecycleURI(element,tag.substring(LIFECYCLE_TAG_PREFIX.length()));
				}
			}
			
		}
	}

}