package org.eclipse.fx.code.editor.configuration.gson;

import org.eclipse.fx.code.editor.configuration.*;
import com.google.gson.JsonObject;

public final class GsonPartitionRuleImpl implements GsonBase, PartitionRule {
	public GsonPartitionRuleImpl(JsonObject jsonObject) {
		this.check = jsonObject.has("check") ? GsonElementFactory.createCheck(jsonObject.getAsJsonObject("check")) : null;
		this.condition = jsonObject.has("condition") ? GsonElementFactory.createCondition(jsonObject.getAsJsonObject("condition")) : null;
	}
	public GsonPartitionRuleImpl(Check check, Condition condition) {
		this.check = check;
		this.condition = condition;
	}

	public JsonObject toJSONObject() {
		JsonObject o = new JsonObject();
		o.addProperty( "$gtype", "PartitionRule" );
		o.add( "check", getCheck() == null ? null : ((GsonBase)getCheck()).toJSONObject() );
		o.add( "condition", getCondition() == null ? null : ((GsonBase)getCondition()).toJSONObject() );
		return o;
	}

	public String toString() {
		return getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + " { "
					 + "check : " + (check == null ? null : check.getClass().getSimpleName() + "@" + Integer.toHexString(check.hashCode())) + ", "
					 + "condition : " + (condition == null ? null : condition.getClass().getSimpleName() + "@" + Integer.toHexString(condition.hashCode()))
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
	


	public static class Builder implements PartitionRule.Builder {
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

		public PartitionRule build() {
			return new GsonPartitionRuleImpl(check, condition);
		}
	}
}
