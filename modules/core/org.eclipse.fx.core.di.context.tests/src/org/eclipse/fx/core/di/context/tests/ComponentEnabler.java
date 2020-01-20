package org.eclipse.fx.core.di.context.tests;

import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

@SuppressWarnings("javadoc")
@Component(service = ComponentEnabler.class)
public class ComponentEnabler {

	ComponentContext context;

	@Activate
	void activate(ComponentContext context) {
		this.context = context;
	}

	public void enableDisabledServiceA() {
		this.context.enableComponent("DisabledServiceA"); //$NON-NLS-1$
	}

	public void disableDisabledServiceA() {
		this.context.disableComponent("DisabledServiceA"); //$NON-NLS-1$
	}

	public void enableDisabledServiceB() {
		this.context.enableComponent("DisabledServiceB"); //$NON-NLS-1$
	}

	public void disableDisabledServiceB() {
		this.context.disableComponent("DisabledServiceB"); //$NON-NLS-1$
	}
}
