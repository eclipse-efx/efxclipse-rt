/*******************************************************************************
 * Copyright (c) 2014 IBM Corporation, BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
