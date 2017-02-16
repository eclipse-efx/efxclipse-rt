package org.eclipse.fx.core.di.context.tests;

import org.osgi.service.component.annotations.Component;

@Component(property="service.ranking:Integer=40")
public class SampleServiceB implements TestService {

}
