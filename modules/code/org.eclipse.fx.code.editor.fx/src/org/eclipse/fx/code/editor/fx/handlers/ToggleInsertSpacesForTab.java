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
package org.eclipse.fx.code.editor.fx.handlers;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.fx.code.editor.Constants;
import org.eclipse.fx.core.preferences.Preference;

import javafx.beans.property.Property;

@SuppressWarnings("restriction")
public class ToggleInsertSpacesForTab {
	@Execute
	public void toggle(@Preference(nodePath=Constants.PREFERENCE_NODE_PATH, key=Constants.PREFERENCE_SPACES_FOR_TAB) Property<Boolean> spacesForTab) {
		if( spacesForTab.getValue() == null ) {
			spacesForTab.setValue( Boolean.TRUE );
		} else {
			spacesForTab.setValue( ! spacesForTab.getValue().booleanValue() );
		}
	}
}
