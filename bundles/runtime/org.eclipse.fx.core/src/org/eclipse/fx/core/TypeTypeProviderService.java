package org.eclipse.fx.core;

public interface TypeTypeProviderService<T> extends TypeProviderService<java.lang.reflect.Type, T> {
	/**
	 * If used with dependency injection and @LocalInstance
	 */
	public static final String DI_KEY = "localInstanceOwnerType"; //$NON-NLS-1$
}
