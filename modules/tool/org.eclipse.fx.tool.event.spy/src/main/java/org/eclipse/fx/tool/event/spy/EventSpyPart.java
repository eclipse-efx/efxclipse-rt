package org.eclipse.fx.tool.event.spy;

import javax.annotation.PostConstruct;

import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.fx.tool.event.spy.internal.model.EventSpyModel;
import org.eclipse.fx.tool.event.spy.internal.view.EventSpyView;

import javafx.scene.Node;
import javafx.scene.layout.BorderPane;

/**
 * Model Part contribution for the event spy.
 */
public class EventSpyPart {

    /**
     * Create event spy part gui element and add it to the parent pane.
     * 
     * @param parentPane
     * @param cont
     */
    @PostConstruct
    public void createControl(BorderPane parentPane, final IEventBroker eventBroker) {

        EventSpyModel eventSpyModel = new EventSpyModel(eventBroker);

        EventSpyView eventSpyView = new EventSpyView(eventSpyModel);

        Node control = eventSpyView.getGui();
        parentPane.setCenter(control);
    }

}
