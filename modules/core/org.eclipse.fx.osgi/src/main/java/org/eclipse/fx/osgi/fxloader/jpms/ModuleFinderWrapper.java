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
import java.nio.file.Path;

@SuppressWarnings("javadoc")
public class ModuleFinderWrapper {

	private static Class<?> CLASS;
	private static Method of;

	public final Object self;

	public ModuleFinderWrapper(Object self) {
		this.self = self;
		init();
	}
	
	private static void init() {
		if( CLASS == null ) {
			try {
				CLASS = ModuleFinderWrapper.class.getClassLoader().loadClass("java.lang.module.ModuleFinder"); //$NON-NLS-1$
				of = CLASS.getMethod("of", Path[].class); //$NON-NLS-1$
			} catch (ClassNotFoundException | NoSuchMethodException | SecurityException e) {
				throw new RuntimeException(e);
			}	
		}
	}
	
	public static Class<?> CLASS() {
		init();
		return CLASS;
	}

	public static ModuleFinderWrapper of(Path... paths) {
		init();
		try {
			return new ModuleFinderWrapper(of.invoke(null, new Object[] { paths }));
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			throw new RuntimeException(e);
		}
	}

}
