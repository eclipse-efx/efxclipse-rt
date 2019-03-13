/*******************************************************************************
 * Copyright (c) 2018 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.osgi.fxloader.jpms;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;

@SuppressWarnings("javadoc")
public class ModuleWrapper {
	private static Class<?> CLASS;
	private static Method getName;
	private static Method getPackages;
	
	public final Object self;
	
	public ModuleWrapper(Object self) {
		this.self = self;
		init();
	}
	
	public static Class<?> CLASS() {
		init();
		return CLASS;
	}
	
	private static void init() {
		if( CLASS == null ) {
			try {
				CLASS = ModuleWrapper.class.getClassLoader().loadClass("java.lang.Module"); //$NON-NLS-1$
				getName = CLASS.getMethod("getName"); //$NON-NLS-1$
				getPackages = CLASS.getMethod("getPackages"); //$NON-NLS-1$
			} catch (ClassNotFoundException | NoSuchMethodException | SecurityException e) {
				throw new RuntimeException(e);
			}
		}
	}

	public String getName() {
		init();
		try {
			return (String) getName.invoke(this.self);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Set<String> getPackages() {
		init();
		try {
			return (Set<String>) getPackages.invoke(this.self);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			throw new RuntimeException(e);
		}
	}
}
