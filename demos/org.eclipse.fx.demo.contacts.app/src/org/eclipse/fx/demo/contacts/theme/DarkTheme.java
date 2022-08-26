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
package org.eclipse.fx.demo.contacts.theme;

import org.eclipse.fx.ui.theme.AbstractTheme;

public class DarkTheme extends AbstractTheme {
	public DarkTheme() {
        super("dark", "Dark Theme", DarkTheme.class.getClassLoader().getResource("css/dark.css"));
    }
}
