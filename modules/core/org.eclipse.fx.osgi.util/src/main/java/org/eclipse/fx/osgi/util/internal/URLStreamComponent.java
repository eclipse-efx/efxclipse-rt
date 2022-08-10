/*******************************************************************************
 * Copyright (c) 2018 BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.osgi.util.internal;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Optional;

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
	private final Map<String, ServiceRegistration<URLStreamHandlerService>> serviceRegistrations = new HashMap<>();

	public URLStreamComponent() {
		this.context = FrameworkUtil.getBundle(URLStreamComponent.class).getBundleContext();
	}

	@Reference(cardinality = ReferenceCardinality.MULTIPLE, policy = ReferencePolicy.DYNAMIC, policyOption = ReferencePolicyOption.GREEDY)
	public void registerUrlStreamHandler(URLStreamHandler handler) {
		Hashtable<String, Object> t = new Hashtable<>();
		t.put(URLConstants.URL_HANDLER_PROTOCOL, new String[] { handler.getProtocol() });
		ServiceRegistration<URLStreamHandlerService> serviceRegistration = this.context
				.registerService(URLStreamHandlerService.class, new DelegatingURLStreamHandlerService(handler), t);
		this.serviceRegistrations.put(handler.getProtocol(), serviceRegistration);
	}

	public void unregisterUrlStreamHandler(URLStreamHandler handler) {
		Optional.ofNullable(this.serviceRegistrations.get(handler.getProtocol())).ifPresent(sr -> {
			sr.unregister();
			this.serviceRegistrations.remove(handler.getProtocol());
		});
	}
}
