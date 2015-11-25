package org.eclipse.fx.code.editor.configuration.gson;

import org.eclipse.fx.code.editor.configuration.*;
import com.google.gson.JsonObject;

public final class GsonPartitionRuleImpl implements GsonBase, PartitionRule {
	public GsonPartitionRuleImpl(JsonObject jsonObject) {
		this.check = jsonObject.has("check") ? GsonElementFactory.createCheck(jsonObject.getAsJsonObject("check")) : null;
	}

	public GsonPartitionRuleImpl(Check check) {
		this.check = check;
	}

	public JsonObject toJSONObject() {
		JsonObject o = new JsonObject();
		o.addProperty( "__type", "PartitionRule" );
		o.add( "check", getCheck() == null ? null : ((GsonBase)getCheck()).toJSONObject() );
		return o;
	}

	public String toString() {
		return getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + " { "
					 + "check : " + check == null ? null : check.getClass().getSimpleName() + "@" + Integer.toHexString(check.hashCode())
					+" }";
	}

	private final Check check;
	public Check getCheck() {
		return this.check;
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

		public PartitionRule build() {
			return new GsonPartitionRuleImpl(check);
		}
	}
}
