package org.eclipse.fx.core.di.context.tests;

import org.osgi.service.component.annotations.Component;

@Component(name = "DisabledServiceA", enabled = false, property = { "component=disabled" })
public class DisabledServiceA implements TestService {

}
