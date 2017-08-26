package org.eclipse.fx.core.di.context.tests;

import org.osgi.service.component.annotations.Component;

@Component(property={"filtervalue=Test","service.ranking:Integer=1"})
public class FilterServiceA implements TestService {

}
