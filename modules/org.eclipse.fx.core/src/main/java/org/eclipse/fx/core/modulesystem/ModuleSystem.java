package org.eclipse.fx.core.modulesystem;

import java.util.Optional;

import org.eclipse.fx.core.ServiceUtils;

public interface ModuleSystem {
	public static ModuleSystem get() {
		return ServiceUtils.getService(ModuleSystem.class).orElseGet(() -> NoModuleSystem.getInstance());
	}
	public Module getModuleForClass(Class<?> clazz);
	public Optional<Module> getModuleById(String moduleId);
}
