package org.eclipse.fx.core.di.context.tests;

import org.osgi.service.component.annotations.Component;

@Component(property="service.ranking=1")
public class SampleServiceA implements TestService {

}
