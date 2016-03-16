/*******************************************************************************
* Copyright (c) 2016 BestSolution.at and others.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
* 	Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
*******************************************************************************/
package org.eclipse.fx.code.editor.fx.handlers;

import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.fx.code.editor.Constants;
import org.eclipse.fx.core.adapter.Adapt;
import org.eclipse.fx.core.preferences.Preference;

import javafx.beans.property.Property;

/**
 * Handler to update the tab-advance for editors
 */
@SuppressWarnings("restriction")
public class SetTabAdvance {
	@Execute
	public void setTabAdvance(@Named("tabAdvance") @Adapt int newTabAdvance, @Preference(key=Constants.PREFERENCE_TAB_ADVANCE,nodePath=Constants.PREFERENCE_NODE_PATH) Property<Integer> tabAdvance) {
		if( newTabAdvance > 0 ) {
			tabAdvance.setValue(Integer.valueOf(newTabAdvance));
		}
	}
}
