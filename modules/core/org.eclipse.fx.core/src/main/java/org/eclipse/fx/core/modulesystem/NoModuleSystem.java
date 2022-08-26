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

import java.nio.file.Path;
import java.util.Optional;

import org.eclipse.fx.core.Version;

class NoModuleSystem implements ModuleSystem {
	static class SystemModule implements Module {

		@Override
		public String getId() {
			return "system"; //$NON-NLS-1$
		}

		@Override
		public Optional<Version> getVersion() {
			return Optional.empty();
		}

		@Override
		public Optional<Path> getLocation() {
			return Optional.empty();
		}
	}

	private static NoModuleSystem INSTANCE;

	public static final NoModuleSystem getInstance() {
		if( INSTANCE == null ) {
			INSTANCE = new NoModuleSystem();
		}
		return INSTANCE;
	}

	private SystemModule module = new SystemModule();

	@Override
	public Module getModuleForClass(Class<?> clazz) {
		return this.module;
	}

	@Override
	public Optional<Module> getModuleById(String moduleId) {
		return Optional.of(this.module);
	}

}
