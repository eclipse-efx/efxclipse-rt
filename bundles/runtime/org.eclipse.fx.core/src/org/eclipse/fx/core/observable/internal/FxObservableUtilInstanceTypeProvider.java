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
package org.eclipse.fx.core.observable.internal;

import java.lang.reflect.Type;

import org.eclipse.fx.core.TypeTypeProviderService;
import org.eclipse.fx.core.observable.FXObservableUtil;
import org.osgi.service.component.annotations.Component;

/**
 * Type provider for @Inject @LocalInstance FXObservableUtil.Instance loader
 */
@Component
public class FxObservableUtilInstanceTypeProvider implements TypeTypeProviderService<FXObservableUtil.Instance> {

	@Override
	public Class<? extends FXObservableUtil.Instance> getType(Type s) {
		return FXObservableUtil.Instance.class;
	}

	@Override
	public boolean test(Type t) {
		return FXObservableUtil.Instance.class == t;
	}

}