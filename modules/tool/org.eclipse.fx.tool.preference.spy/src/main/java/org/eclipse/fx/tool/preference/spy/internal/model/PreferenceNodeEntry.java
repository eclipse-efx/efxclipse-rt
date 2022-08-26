/*******************************************************************************
 * Copyright (c) Carl Zeiss Meditec AG
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
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
