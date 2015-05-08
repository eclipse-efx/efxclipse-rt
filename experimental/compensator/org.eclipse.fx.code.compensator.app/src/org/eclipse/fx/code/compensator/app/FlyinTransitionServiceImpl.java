package org.eclipse.fx.code.compensator.app;

import org.eclipse.fx.ui.workbench.renderers.fx.services.FlyInTransitionService;
import org.eclipse.fx.ui.workbench.renderers.fx.services.LightweightDialogTransitionService;
import org.osgi.service.component.annotations.Component;

@Component(property={"service.ranking:Integer=1"})
public class FlyinTransitionServiceImpl extends FlyInTransitionService implements LightweightDialogTransitionService {

}
