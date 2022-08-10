/*******************************************************************************
* Copyright (c) 2016 BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
*
* Contributors:
* 	Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
*******************************************************************************/
package org.eclipse.fx.code.editor.fx.handlers;

import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.fx.code.editor.Constants;
import org.eclipse.fx.core.preferences.Preference;

import javafx.beans.property.Property;

/**
 * Handler to update the tab-advance for editors
 */
@SuppressWarnings("restriction")
public class SetTabAdvance {
	@Execute
	public void setTabAdvance(@Named("tabAdvance") String newTabAdvance, @Preference(key=Constants.PREFERENCE_TAB_ADVANCE,nodePath=Constants.PREFERENCE_NODE_PATH) Property<Integer> tabAdvance) {
		if( Integer.parseInt(newTabAdvance) > 0 ) {
			tabAdvance.setValue(Integer.valueOf(newTabAdvance));
		}
	}
}
