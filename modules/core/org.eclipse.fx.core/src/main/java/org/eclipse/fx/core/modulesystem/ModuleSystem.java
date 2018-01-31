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
