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

import org.eclipse.core.runtime.preferences.IEclipsePreferences;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Value object for preferences data leaf nodes
 */
public class PreferenceEntry {

	public enum Fields {
		nodePath, key, oldValue, newValue;
	}

	private String nodePath;

	private String key;

	private String oldValue;

	private StringProperty newValue = new SimpleStringProperty();

	private IEclipsePreferences parentPreferences;

	public PreferenceEntry(String nodePath, String key, String oldValue, String newValue) {
		this.nodePath = nodePath;
		this.key = key;
		this.oldValue = oldValue;
		this.newValue.set( newValue );
	}

	public String getNodePath() {
		return nodePath;
	}

	public void setNodePath(String nodePath) {
		this.nodePath = nodePath;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getOldValue() {
		return oldValue;
	}

	public void setOldValue(String oldValue) {
		this.oldValue = oldValue;
	}

	public String getNewValue() {
		return newValue.get();
	}

	public void setNewValue(String newValue) {
		this.newValue.set( newValue );
	}

	public StringProperty newValueProperty() {
		return newValue;
	}
	
	public IEclipsePreferences getParentPreferences() {
		return parentPreferences;
	}

	public void setParentPreferences(IEclipsePreferences parentPreferences) {
		this.parentPreferences = parentPreferences;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		result = prime * result + ((newValue == null) ? 0 : newValue.hashCode());
		result = prime * result + ((nodePath == null) ? 0 : nodePath.hashCode());
		result = prime * result + ((oldValue == null) ? 0 : oldValue.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		PreferenceEntry other = (PreferenceEntry) obj;
		if (key == null) {
			if (other.key != null) {
				return false;
			}
		} else if (!key.equals(other.key)) {
			return false;
		}
		if (newValue == null) {
			if (other.newValue != null) {
				return false;
			}
		} else if (!newValue.equals(other.newValue)) {
			return false;
		}
		if (nodePath == null) {
			if (other.nodePath != null) {
				return false;
			}
		} else if (!nodePath.equals(other.nodePath)) {
			return false;
		}
		if (oldValue == null) {
			if (other.oldValue != null) {
				return false;
			}
		} else if (!oldValue.equals(other.oldValue)) {
			return false;
		}
		return true;
	}

}
