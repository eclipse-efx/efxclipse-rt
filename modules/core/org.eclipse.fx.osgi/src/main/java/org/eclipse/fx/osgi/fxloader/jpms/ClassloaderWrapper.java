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

@SuppressWarnings("javadoc")
public class ClassloaderWrapper {
	
	private static Method getUnnamedModule;
	
	public final ClassLoader self;
	
	public ClassloaderWrapper(ClassLoader loader) {
		this.self = loader;
		if( getUnnamedModule == null ) {
			try {
				getUnnamedModule = ClassLoader.class.getMethod("getUnnamedModule"); //$NON-NLS-1$
			} catch (NoSuchMethodException | SecurityException e) {
				throw new RuntimeException(e);
			}
		}
	}
	
	public ModuleWrapper getUnnamedModule() {
		try {
			return new ModuleWrapper(getUnnamedModule.invoke(this.self));
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			throw new RuntimeException(e);
		}
	}
}
