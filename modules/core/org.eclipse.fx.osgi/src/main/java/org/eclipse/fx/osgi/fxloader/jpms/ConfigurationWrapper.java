package org.eclipse.fx.osgi.fxloader.jpms;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;

@SuppressWarnings("javadoc")
public class ConfigurationWrapper {
	private static Class<?> CLASS;
	private static Method resolve;

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
		try {
			return new ConfigurationWrapper(resolve.invoke(this.self, before.self, after.self, roots));
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			throw new RuntimeException(e);
		}
	}
}
