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

public final class GsonTokenScanner_JavaScriptImpl implements GsonBase, TokenScanner_JavaScript, TokenScanner {
	public GsonTokenScanner_JavaScriptImpl(JsonObject jsonObject) {
		this.check = jsonObject.has("check") ? GsonElementFactory.createCheck(jsonObject.getAsJsonObject("check")) : null;
		this.condition = jsonObject.has("condition") ? GsonElementFactory.createCondition(jsonObject.getAsJsonObject("condition")) : null;
		this.script = jsonObject.has("script") ? jsonObject.get("script").getAsString() : null;
	}
	public GsonTokenScanner_JavaScriptImpl(Check check, Condition condition, String script) {
		this.check = check;
		this.condition = condition;
		this.script = script;
	}

	public JsonObject toJSONObject() {
		JsonObject o = new JsonObject();
		o.addProperty( "$gtype", "TokenScanner_JavaScript" );
		o.add( "check", getCheck() == null ? null : ((GsonBase)getCheck()).toJSONObject() );
		o.add( "condition", getCondition() == null ? null : ((GsonBase)getCondition()).toJSONObject() );
		o.addProperty( "script", getScript() );
		return o;
	}

	public String toString() {
		return getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + " { "
					 + "check : " + (check == null ? null : check.getClass().getSimpleName() + "@" + Integer.toHexString(check.hashCode())) + ", "
					 + "condition : " + (condition == null ? null : condition.getClass().getSimpleName() + "@" + Integer.toHexString(condition.hashCode())) + ", "
					 + "script : " + script
					+" }";
	}

	private final Check check;
	public Check getCheck() {
		return this.check;
	}
	

	private final Condition condition;
	public Condition getCondition() {
		return this.condition;
	}
	

	private final String script;
	public String getScript() {
		return this.script;
	}
	


	public static class Builder implements TokenScanner_JavaScript.Builder {
		private final EditorGModel instance;

		public Builder(EditorGModel instance) {
			this.instance = instance;
		}
		private Check check;
		public Builder check(Check check) {
			this.check = check;
			return this;
		}
		private Condition condition;
		public Builder condition(Condition condition) {
			this.condition = condition;
			return this;
		}
		private String script;
		public Builder script(String script) {
			this.script = script;
			return this;
		}

		public TokenScanner_JavaScript build() {
			return new GsonTokenScanner_JavaScriptImpl(check, condition, script);
		}
	}
}
