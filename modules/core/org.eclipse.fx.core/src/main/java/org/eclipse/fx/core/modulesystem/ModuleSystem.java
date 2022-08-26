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

import org.eclipse.fx.core.SystemUtils;

public interface ModuleSystem {
	public static ModuleSystem get() {
		return SystemUtils.isOsgiEnv() ? OSGiModuleSystem.getInstance() : NoModuleSystem.getInstance();
	}
	public Module getModuleForClass(Class<?> clazz);
	public Optional<Module> getModuleById(String moduleId);
}
