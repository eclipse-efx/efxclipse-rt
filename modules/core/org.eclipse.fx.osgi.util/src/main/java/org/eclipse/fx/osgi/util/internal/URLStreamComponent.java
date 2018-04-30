/*******************************************************************************
 * Copyright (c) 2018 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.osgi.util.internal;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.eclipse.fx.core.URLStreamHandler;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;
import org.osgi.service.url.URLConstants;
import org.osgi.service.url.URLStreamHandlerService;

@SuppressWarnings("javadoc")
@Component(immediate = true)
public class URLStreamComponent {
	private final BundleContext context;
	private final List<ServiceRegistration<URLStreamHandlerService>> l = new ArrayList<>();

	public URLStreamComponent() {
		this.context = FrameworkUtil.getBundle(URLStreamComponent.class).getBundleContext();
	}

	@Reference(cardinality = ReferenceCardinality.MULTIPLE, policy = ReferencePolicy.DYNAMIC, policyOption = ReferencePolicyOption.GREEDY)
	public void registerUrlStreamHandler(URLStreamHandler handler) {
		Hashtable<String, Object> t = new Hashtable<>();
		t.put(URLConstants.URL_HANDLER_PROTOCOL, new String[] { handler.getProtocol() });
		this.l.add(this.context.registerService(URLStreamHandlerService.class, new DelegatingURLStreamHandlerService(handler), t));
	}
	
	public void unregisterUrlStreamHandler(URLStreamHandler handler) {
		this.l.stream()
			.filter( s -> ((String[])s.getReference().getProperty(URLConstants.URL_HANDLER_PROTOCOL))[0].equals(handler.getProtocol()))
			.findFirst()
			.ifPresent( ServiceRegistration::unregister);
	}
}
