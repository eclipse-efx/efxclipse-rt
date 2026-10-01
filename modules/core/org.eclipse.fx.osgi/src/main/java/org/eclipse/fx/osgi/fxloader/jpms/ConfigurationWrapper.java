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
package org.eclipse.fx.osgi.fxloader.jpms;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.eclipse.fx.osgi.fxloader.FXClassloaderConfigurator;

@SuppressWarnings("javadoc")
public class ConfigurationWrapper {
	private static Class<?> CLASS;
	private static Method resolve;
	private static Method findModule;

	public final Object self;

	public ConfigurationWrapper(Object self) {
		this.self = self;
		init();
	}

	private static void init() {
		if (CLASS == null) {
			try {
				CLASS = ConfigurationWrapper.class.getClassLoader().loadClass("java.lang.module.Configuration"); //$NON-NLS-1$
				resolve = CLASS.getMethod("resolve", ModuleFinderWrapper.CLASS(), ModuleFinderWrapper.CLASS(), //$NON-NLS-1$
						Collection.class);
				findModule = CLASS.getMethod("findModule", String.class); //$NON-NLS-1$
			} catch (ClassNotFoundException | NoSuchMethodException | SecurityException e) {
				throw new RuntimeException(e);
			}
		}
	}

	public static Class<?> CLASS() {
		init();
		return CLASS;
	}

	public ConfigurationWrapper resolve(ModuleFinderWrapper before, ModuleFinderWrapper after,
			Collection<String> roots) {
		init();

		// do not add already existing modules to avoid duplication
		Collection<String> rootsNotExisting = roots.stream().filter(module -> !moduleExists(module)).toList();

		try {
			return new ConfigurationWrapper(resolve.invoke(this.self, before.self, after.self, rootsNotExisting));
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			throw new RuntimeException(e);
		}
	}

	private boolean moduleExists(String name) {
		init();
		try {
			return  ((Optional<?>) findModule.invoke(this.self, name)).isPresent();
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			throw new RuntimeException(e);
		}
	}

	public List<FXProviderBundle> filterBundles(List<FXProviderBundle> bundles) {
		init();
		List<FXProviderBundle> bundlesFiltered = new ArrayList<>();
		for (FXProviderBundle bundle : bundles) {
			String name = bundle.module();
			if (moduleExists(name)) {
				if (FXClassloaderConfigurator.DEBUG) {
					System.err.println("ConfigurationWrapper#resolve - Module '%s' already exists and will be ignored" //$NON-NLS-1$
							.formatted(name));
				}
			} else {
				bundlesFiltered.add(bundle);
			}
		}
		return bundlesFiltered;
	}
}
