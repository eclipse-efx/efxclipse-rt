/*******************************************************************************
 * Copyright (c) 2014 IBM Corporation, BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 * 	   IBM Corporation - initial API
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.swt.program;

import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.internal.Util;

public class Program {

	public static Program findProgram(String string) {
		Util.logNotImplemented();
		return null;
	}

	public boolean execute(String string) {
		Util.logNotImplemented();
		return false;
	}

//	public static String [] getExtensions () {
//		
//	}
//	
//	public static Program [] getPrograms () {
//		
//	}
	public static boolean launch (String fileName) {
		Util.logNotImplemented();
		return true;
	}
//	public static boolean launch (String fileName, String workingDir) {
//		
//	}
//	public boolean execute (String fileName) {
//		
//	}
	public ImageData getImageData () {
		Util.logNotImplemented();
		return null;
	}
	public String getName () {
		Util.logNotImplemented();
		return null;
	}

	public static Program[] getPrograms() {
		Util.logNotImplemented();
		return new Program[0];
	}
}
