/*******************************************************************************
 * Copyright (c) 2022 BestSolution.at and others.
 *  
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *  
 * SPDX-License-Identifier: EPL-2.0
 *  
 * Contributors:
 *     BestSolution.at - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.xtext.sample.editor;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Util {
	public static String getFileContent(URI uri) {
		StringBuilder b = new StringBuilder();
		try {
			BufferedReader reader = Files.newBufferedReader(Paths.get(uri));
			String l;
			while( (l = reader.readLine()) != null ) {
				b.append(l + "\n");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return b.toString();
	}
}
