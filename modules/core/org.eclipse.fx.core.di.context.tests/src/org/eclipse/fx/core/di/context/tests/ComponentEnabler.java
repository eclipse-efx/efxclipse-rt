package org.eclipse.fx.core.di.context.tests;

import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

@Component(service = ComponentEnabler.class)
public class ComponentEnabler {

	ComponentContext context;

	@Activate
	void activate(ComponentContext context) {
		this.context = context;
	}

	public void enableDisabledServiceA() {
		this.context.enableComponent("DisabledServiceA");
	}

	public void disableDisabledServiceA() {
		this.context.disableComponent("DisabledServiceA");
	}

	public void enableDisabledServiceB() {
		this.context.enableComponent("DisabledServiceB");
	}

	public void disableDisabledServiceB() {
		this.context.disableComponent("DisabledServiceB");
	}
}
