package org.eclipse.fx.testcases.e4.handlers;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.workbench.UIEvents;
import org.eclipse.fx.core.di.ScopedObjectFactory;

@SuppressWarnings("restriction")
public class Handler1 {
	@Execute
	public void execute(MApplication application, IEventBroker broker) {
		System.err.println("Executing H1");
		Integer v = (Integer) application.getContext().get("test_2");
		if( v == null ) {
			v = Integer.valueOf(0);
		} else {
			v = Integer.valueOf((v.intValue()+1)%2);
		}
		application.getContext().set("test_2", v);
		broker.send(UIEvents.REQUEST_ENABLEMENT_UPDATE_TOPIC, UIEvents.ALL_ELEMENT_ID);
	}

}
