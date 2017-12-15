package org.eclipse.fx.core.di.context.tests;

import org.osgi.service.component.annotations.Component;

@Component(name = "DisabledServiceB", enabled = false, property = { "component=disabled", "service.ranking:Integer=5" })
public class DisabledServiceB implements TestService {

}
