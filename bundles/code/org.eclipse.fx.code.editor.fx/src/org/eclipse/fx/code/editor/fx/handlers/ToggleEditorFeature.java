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

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.fx.code.editor.Constants;
import org.eclipse.fx.core.preferences.Preference;
import org.eclipse.fx.text.ui.Feature;

import javafx.beans.property.Property;

/**
 * Handler to toggle a feature of the editor
 */
@SuppressWarnings("restriction")
public class ToggleEditorFeature {

	@Execute
	public void execute(@Named("feature") String featureName, @Preference(key=Constants.PREFERENCE_KEY_EDITOR_FEATURE,nodePath=Constants.PREFERENCE_NODE_PATH) Property<Set<Feature>> featureSet) {
		Feature f = Feature.valueOf(featureName);

		Set<Feature> copy = new HashSet<Feature>(featureSet.getValue() == null ? Collections.singleton(Feature.SHOW_LINE_NUMBERS) : featureSet.getValue());
		if( copy.contains(f) ) {
			copy.remove(f);
		} else {
			copy.add(f);
		}
		System.err.println(" ===========> " + copy);
		featureSet.setValue(copy);
	}
}