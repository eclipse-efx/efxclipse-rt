package org.eclipse.fx.code.editor.configuration.gson;

import org.eclipse.fx.code.editor.configuration.*;
import com.google.gson.JsonObject;

public final class GsonExitsConditionImpl implements GsonBase, ExitsCondition, Condition {
	public GsonExitsConditionImpl(JsonObject jsonObject) {
		this.name = jsonObject.has("name") ? jsonObject.get("name").getAsString() : null;
	}
	public GsonExitsConditionImpl(String name) {
		this.name = name;
	}

	public JsonObject toJSONObject() {
		JsonObject o = new JsonObject();
		o.addProperty( "$gtype", "ExitsCondition" );
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
	


	public static class Builder implements ExitsCondition.Builder {
		private final EditorGModel instance;

		public Builder(EditorGModel instance) {
			this.instance = instance;
		}
		private String name;
		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public ExitsCondition build() {
			return new GsonExitsConditionImpl(name);
		}
	}
}
