/*******************************************************************************
 * Copyright (c) 2022 BestSolution.at and others.
 *  
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *  
 * SPDX-License-Identifier: EPL-2.0
 *  
 * Contributors:
 *     BestSolution.at - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.code.editor.services.internal;

import java.util.Map;

import org.eclipse.fx.code.editor.Input;
import org.eclipse.fx.code.editor.InputContext;
import org.eclipse.fx.code.editor.services.InputContextLookup;
import org.eclipse.fx.code.editor.services.InputContextProvider;
import org.eclipse.fx.core.RankedObjectRegistry;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicyOption;

@Component
public class DefaultInputContextLookup implements InputContextLookup {
	private static final String CONTEXT_KEY = DefaultInputContextLookup.class.getName() + ".inputContext";
	private RankedObjectRegistry<InputContextProvider> providerList = new RankedObjectRegistry<>();

	@Reference(cardinality=ReferenceCardinality.MULTIPLE,policyOption=ReferencePolicyOption.GREEDY)
	public synchronized void registerInputContextProvider(InputContextProvider provider, Map<String, Object> properties) {
		providerList.registerObject(RankedObjectRegistry.getOSGiServiceRank(properties),provider);
	}

	public synchronized void unregisterInputContextProvider(InputContextProvider provider) {
		providerList.unregisterObject(provider);
	}

	@Override
	public synchronized InputContext getContext(Input<?> input) {
		return (InputContext)input.getTransientData().computeIfAbsent(CONTEXT_KEY, k -> providerList.unsynchronizedStream()
				.filter( p -> p.test(input))
				.findFirst()
				.map( p -> p.getContext(input))
				.orElse(DEFAULT));
	}
}
