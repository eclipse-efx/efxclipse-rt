
package org.eclipse.fx.code.compensator.project.internal;

import java.util.List;

import javax.inject.Named;

import org.eclipse.e4.ui.di.AboutToShow;
import org.eclipse.e4.ui.model.application.ui.menu.MDirectMenuItem;
import org.eclipse.e4.ui.model.application.ui.menu.MMenuElement;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.fx.code.compensator.project.ProjectNavigatorItem;
import org.eclipse.fx.code.compensator.project.ProjectService;
import org.eclipse.fx.code.compensator.project.ProjectService.ContextMenuGroup;
import org.eclipse.fx.code.compensator.project.ProjectService.MenuElement;

public class DynamicContextMenu {

	@AboutToShow
	public void aboutToShow(List<MMenuElement> items, @Named("navigatorSelection") ProjectNavigatorItem item, ProjectService projectService, EModelService modelService) {
		for( ContextMenuGroup g : projectService.getProjectNavigatorContextMenuGroups() ) {
			if( g.applies(item) ) {
				for( MenuElement e : g.getElements() ) {
					MDirectMenuItem m = modelService.createModelElement(MDirectMenuItem.class);
					m.setLabel(e.label);
					m.setContributionURI("bundleclass://org.eclipse.fx.code.compensator.project/org.eclipse.fx.code.compensator.project.internal.MenuItemDelegate");
					m.getTransientData().put("delegate", e);
					items.add(m);
				}
			}
		}
	}

}