/*******************************************************************************
 * Copyright (c) 2017 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Martin Bluehweis <martin.bluehweis@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core.bindings.internal;

import java.lang.reflect.Type;

import org.eclipse.fx.core.TypeTypeProviderService;
import org.eclipse.fx.core.bindings.FXBindings;
import org.osgi.service.component.annotations.Component;

/**
 * Type provider for @Inject @LocalInstance FXBindings.Instance loader
 */
@Component
public class FxBindingsInstanceTypeProvider implements TypeTypeProviderService<FXBindings.Instance> {

	@Override
	public Class<? extends FXBindings.Instance> getType(Type s) {
		return FXBindings.Instance.class;
	}

	@Override
	public boolean test(Type t) {
		return FXBindings.Instance.class == t;
	}

}