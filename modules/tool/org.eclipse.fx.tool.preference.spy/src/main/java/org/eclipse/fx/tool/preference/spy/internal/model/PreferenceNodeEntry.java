/*******************************************************************************
 * Copyright (c) Carl Zeiss Meditec AG
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Thomas Fahrmeyer (lauritziu_ii@yahoo.de) - initial API and implementation
*/
package org.eclipse.fx.tool.preference.spy.internal.model;

import java.util.Arrays;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Data object for preference data nodes
 */
public class PreferenceNodeEntry extends PreferenceEntry {

	private ObservableList<PreferenceEntry> preferenceEntries = FXCollections.observableArrayList();
	
	public PreferenceNodeEntry(String nodePath) {
		super(nodePath, "", "", "");
	}

	public boolean addChildren(PreferenceEntry... entry) {
		return getPreferenceEntries().addAll(Arrays.asList(entry));
	}

	public ObservableList<PreferenceEntry> getPreferenceEntries() {
		return preferenceEntries;
	}

}
