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

public final class GsonConditionImpl implements GsonBase, Condition {
	public GsonConditionImpl(JsonObject jsonObject) {
		this.name = jsonObject.has("name") ? jsonObject.get("name").getAsString() : null;
	}
	public GsonConditionImpl(String name) {
		this.name = name;
	}

	public JsonObject toJSONObject() {
		JsonObject o = new JsonObject();
		o.addProperty( "$gtype", "Condition" );
		o.addProperty( "name", getName() );
		return o;
	}

	public String toString() {
		return getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + " { "
					 + "name : " + name
					+" }";
	}

	private final String name;
	public String getName() {
		return this.name;
	}
	


	public static class Builder implements Condition.Builder {
		private final EditorGModel instance;

		public Builder(EditorGModel instance) {
			this.instance = instance;
		}
		private String name;
		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public Condition build() {
			return new GsonConditionImpl(name);
		}
	}
}
