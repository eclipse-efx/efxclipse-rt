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
package org.eclipse.fx.ui.preferences.page;

import org.eclipse.fx.core.Memento;
import org.eclipse.fx.ui.preferences.PreferencePage;

public abstract class BasePreferencePage implements PreferencePage {
	private final Memento memento;
	
	public BasePreferencePage(Memento memento) {
		this.memento = memento;
	}
}
