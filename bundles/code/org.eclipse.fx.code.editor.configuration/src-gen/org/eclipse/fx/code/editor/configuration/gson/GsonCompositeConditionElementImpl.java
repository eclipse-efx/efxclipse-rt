package org.eclipse.fx.code.editor.configuration.gson;

import org.eclipse.fx.code.editor.configuration.*;
import com.google.gson.JsonObject;

public final class GsonCompositeConditionElementImpl implements GsonBase, CompositeConditionElement, Condition {
	public GsonCompositeConditionElementImpl(JsonObject jsonObject) {
		this.condition = jsonObject.has("condition") ? GsonElementFactory.createCompositeConditionElement(jsonObject.getAsJsonObject("condition")) : null;
		this.name = jsonObject.has("name") ? jsonObject.get("name").getAsString() : null;
	}
	public GsonCompositeConditionElementImpl(CompositeConditionElement condition, String name) {
		this.condition = condition;
		this.name = name;
	}

	public JsonObject toJSONObject() {
		JsonObject o = new JsonObject();
		o.addProperty( "$gtype", "CompositeConditionElement" );
		o.add( "condition", getCondition() == null ? null : ((GsonBase)getCondition()).toJSONObject() );
		o.addProperty( "name", getName() );
		return o;
	}

	public String toString() {
		return getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + " { "
					 + "condition : " + (condition == null ? null : condition.getClass().getSimpleName() + "@" + Integer.toHexString(condition.hashCode())) + ", "
					 + "name : " + name
					+" }";
	}

	private final CompositeConditionElement condition;
	public CompositeConditionElement getCondition() {
		return this.condition;
	}
	

	private final String name;
	public String getName() {
		return this.name;
	}
	


	public static class Builder implements CompositeConditionElement.Builder {
		private final EditorGModel instance;

		public Builder(EditorGModel instance) {
			this.instance = instance;
		}
		private CompositeConditionElement condition;
		public Builder condition(CompositeConditionElement condition) {
			this.condition = condition;
			return this;
		}
		private String name;
		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public CompositeConditionElement build() {
			return new GsonCompositeConditionElementImpl(condition, name);
		}
	}
}
