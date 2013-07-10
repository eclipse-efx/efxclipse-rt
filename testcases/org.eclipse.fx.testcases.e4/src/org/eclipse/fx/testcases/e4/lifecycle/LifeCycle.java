package org.eclipse.fx.testcases.e4.lifecycle;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javafx.stage.Stage;

import javax.annotation.PostConstruct;

import org.eclipse.e4.core.services.contributions.IContributionFactory;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.MApplicationElement;
import org.eclipse.e4.ui.model.application.ui.basic.MWindow;
import org.eclipse.e4.ui.model.application.ui.menu.MMenu;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.fx.ui.dialogs.MessageDialog;
import org.eclipse.fx.ui.lifecycle.LifecycleAddon;
import org.eclipse.fx.ui.lifecycle.annotations.PreClose;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WWindow;

public class LifeCycle {
	
	@SuppressWarnings("rawtypes")
	@PreClose
	public boolean ph(MWindow win){
		MessageDialog.openErrorDialog((Stage)((WWindow)win.getWidget()).getWidget(), "Sorry", "Sorry, no close.");
		return false;
	}
	
	}