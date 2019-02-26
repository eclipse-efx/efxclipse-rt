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
