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
package org.eclipse.fx.code.editor.configuration.gson;

import org.eclipse.fx.code.editor.configuration.*;
import com.google.gson.JsonObject;

public final class GsonEqualsConditionImpl implements GsonBase, EqualsCondition, Condition {
	public GsonEqualsConditionImpl(JsonObject jsonObject) {
		this.name = jsonObject.has("name") ? jsonObject.get("name").getAsString() : null;
		this.value = jsonObject.has("value") ? jsonObject.get("value").getAsString() : null;
	}
	public GsonEqualsConditionImpl(String name, String value) {
		this.name = name;
		this.value = value;
	}

	public JsonObject toJSONObject() {
		JsonObject o = new JsonObject();
		o.addProperty( "$gtype", "EqualsCondition" );
		o.addProperty( "name", getName() );
		o.addProperty( "value", getValue() );
		return o;
	}

	public String toString() {
		return getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + " { "
					 + "name : " + name + ", "
					 + "value : " + value
					+" }";
	}

	private final String name;
	public String getName() {
		return this.name;
	}
	

	private final String value;
	public String getValue() {
		return this.value;
	}
	


	public static class Builder implements EqualsCondition.Builder {
		private final EditorGModel instance;

		public Builder(EditorGModel instance) {
			this.instance = instance;
		}
		private String name;
		public Builder name(String name) {
			this.name = name;
			return this;
		}
		private String value;
		public Builder value(String value) {
			this.value = value;
			return this;
		}

		public EqualsCondition build() {
			return new GsonEqualsConditionImpl(name, value);
		}
	}
}
