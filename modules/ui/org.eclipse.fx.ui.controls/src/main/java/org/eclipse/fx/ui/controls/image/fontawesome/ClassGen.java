/*******************************************************************************
 * Copyright (c) 2015 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.controls.image.fontawesome;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author tomschindl
 *
 */
public class ClassGen {
	/**
	 * @param args the cmd arguments
	 */
	public static void main(String[] args) {
		try {
			List<String> lines = Files.readAllLines(Paths.get("/Users/tomschindl/git/efxclipse/bundles/runtime/org.eclipse.fx.ui.controls/src/org/eclipse/fx/ui/controls/image/fontawesome/font-awesome.css")); //$NON-NLS-1$
			Iterator<String> iterator = lines.iterator();
			Map<String, String> nameToCharCode = new HashMap<String, String>();

			while( iterator.hasNext() ) {
				String next = iterator.next();
				if( next.contains(":before") ) { //$NON-NLS-1$
					Set<String> items = new HashSet<>();
					String charLine = ""; //$NON-NLS-1$
					do {
						items.add(next);
						if( next.trim().endsWith("{") ) { //$NON-NLS-1$
							charLine = iterator.next();
							break;
						}
						next = iterator.next();
					} while( iterator.hasNext() );
					String charVal = charLine.substring(charLine.indexOf('\\')+1, charLine.lastIndexOf('"'));
					nameToCharCode.putAll(items.stream().map( i -> i.substring(1,i.indexOf(":"))).collect(Collectors.toMap( i -> i, i -> charVal))); //$NON-NLS-1$
				}
			}

			nameToCharCode.entrySet().stream().sorted( (e1 , e2) -> Integer.valueOf(e1.getValue(),16).compareTo(Integer.valueOf(e2.getValue(),16))).forEach( e -> generateMethod(e.getKey(), e.getValue()));
			System.err.println("=================="); //$NON-NLS-1$
			nameToCharCode.entrySet().stream().sorted( (e1 , e2) -> Integer.valueOf(e1.getValue(),16).compareTo(Integer.valueOf(e2.getValue(),16))).forEach( e -> generateCharMap(e.getKey(), e.getValue()));
			System.err.println(nameToCharCode.size());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void generateCharMap(String name, String keyCode) {
		System.err.println("	NAME_TO_CHAR.put(\""+name+"\",Character.valueOf('\\u"+keyCode+"')); //$NON-NLS-1$"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}

	private static void generateMethod(String name, String keyCode) {
		System.err.println("	/**"); //$NON-NLS-1$
		System.err.println("	 * <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css\">"); //$NON-NLS-1$
		System.err.println("	 * <i class=\"fa "+name+"\"> "+name+"</i>"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		System.err.println("	 *"); //$NON-NLS-1$
		System.err.println("	 * @return the font icon instance"); //$NON-NLS-1$
		System.err.println("	 */"); //$NON-NLS-1$
		System.err.println("	public static FontIcon "+name.toUpperCase().replace('-', '_')+"() {"); //$NON-NLS-1$ //$NON-NLS-2$
		System.err.println("		return FontIcon.create(\""+name+"\").get(); //$NON-NLS-1$");  //$NON-NLS-1$//$NON-NLS-2$
		System.err.println("	}"); //$NON-NLS-1$

	}
}
