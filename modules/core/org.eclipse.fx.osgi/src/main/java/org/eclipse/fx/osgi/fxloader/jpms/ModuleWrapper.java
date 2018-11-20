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

@SuppressWarnings("javadoc")
public class ModuleWrapper {
	private static Class<?> CLASS;
	
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
			} catch (ClassNotFoundException e) {
				throw new RuntimeException(e);
			}
		}
	}
}
