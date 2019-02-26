package org.eclipse.fx.tool.spies;

import java.util.List;

import org.eclipse.e4.ui.di.AboutToShow;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.commands.MCommand;
import org.eclipse.e4.ui.model.application.commands.MParameter;
import org.eclipse.e4.ui.model.application.descriptor.basic.MPartDescriptor;
import org.eclipse.e4.ui.model.application.ui.menu.MHandledMenuItem;
import org.eclipse.e4.ui.model.application.ui.menu.MMenuElement;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import static org.eclipse.fx.tool.spies.Constants.*;

public class DynamicMenuContributionHandler {

    
    @AboutToShow
    public void fillE4SpyMenu(List<MMenuElement> items, MApplication application, EModelService modelService) {

        CommandCreator commandCreator = new CommandCreator(application, modelService);
        
        MCommand command = commandCreator.getOrCreateSpyCommand();
        for (MPartDescriptor mp : application.getDescriptors()) {
            if (mp.getTags().contains(SPY_TAG)) {
                MHandledMenuItem hi = modelService.createModelElement(MHandledMenuItem.class);
                hi.setCommand(command);
                hi.setLabel(mp.getLabel());
                hi.setContributorURI(mp.getContributorURI());
                hi.setIconURI(mp.getIconURI());
                hi.setTooltip(mp.getDescription());

                MParameter p = modelService.createModelElement(MParameter.class);
                p.setName(SPY_COMMAND_PARAM);
                p.setValue(mp.getElementId());
                hi.getParameters().add(p);
                items.add(hi);
            }
        }

    }
}
