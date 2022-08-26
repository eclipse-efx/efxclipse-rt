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
package org.eclipse.fx.core.modulesystem;

import java.util.Optional;
import java.util.WeakHashMap;
import java.util.stream.Stream;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

public class OSGiModuleSystem implements ModuleSystem {
	private static OSGiModuleSystem INSTANCE;
	private WeakHashMap<Bundle, Module> bundleCache = new WeakHashMap<>();

	public static final OSGiModuleSystem getInstance() {
		if( INSTANCE == null ) {
			INSTANCE = new OSGiModuleSystem();
		}
		return INSTANCE;
	}

	@Override
	public Module getModuleForClass(Class<?> clazz) {
		return new OSGiModule(FrameworkUtil.getBundle(clazz));
	}

	@Override
	public Optional<Module> getModuleById(String moduleId) {
		return Stream.of(FrameworkUtil.getBundle(getClass()).getBundleContext().getBundles())
			.filter( b -> b.getSymbolicName().equals(moduleId))
			.findFirst()
			.map( this::getModule);
	}

	private Module getModule(Bundle bundle) {
		return this.bundleCache.computeIfAbsent(bundle, OSGiModule::new);
	}
}
