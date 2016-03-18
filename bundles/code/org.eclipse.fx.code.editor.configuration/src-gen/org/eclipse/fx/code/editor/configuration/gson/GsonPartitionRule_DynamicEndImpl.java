package org.eclipse.fx.code.editor.configuration.gson;

import org.eclipse.fx.code.editor.configuration.*;
import com.google.gson.JsonObject;

public final class GsonPartitionRule_DynamicEndImpl implements GsonBase, PartitionRule_DynamicEnd, PartitionRule {
	public GsonPartitionRule_DynamicEndImpl(JsonObject jsonObject) {
		this.beginMatch = jsonObject.has("beginMatch") ? jsonObject.get("beginMatch").getAsString() : null;
		this.beginPrefix = jsonObject.has("beginPrefix") ? jsonObject.get("beginPrefix").getAsString() : null;
		this.check = jsonObject.has("check") ? GsonElementFactory.createCheck(jsonObject.getAsJsonObject("check")) : null;
		this.condition = jsonObject.has("condition") ? GsonElementFactory.createCondition(jsonObject.getAsJsonObject("condition")) : null;
		this.endTemplate = jsonObject.has("endTemplate") ? jsonObject.get("endTemplate").getAsString() : null;
		this.singleLine = jsonObject.has("singleLine") ? jsonObject.get("singleLine").getAsBoolean() : false;
	}
	public GsonPartitionRule_DynamicEndImpl(String beginMatch, String beginPrefix, Check check, Condition condition, String endTemplate, boolean singleLine) {
		this.beginMatch = beginMatch;
		this.beginPrefix = beginPrefix;
		this.check = check;
		this.condition = condition;
		this.endTemplate = endTemplate;
		this.singleLine = singleLine;
	}

	public JsonObject toJSONObject() {
		JsonObject o = new JsonObject();
		o.addProperty( "$gtype", "PartitionRule_DynamicEnd" );
		o.addProperty( "beginMatch", getBeginMatch() );
		o.addProperty( "beginPrefix", getBeginPrefix() );
		o.add( "check", getCheck() == null ? null : ((GsonBase)getCheck()).toJSONObject() );
		o.add( "condition", getCondition() == null ? null : ((GsonBase)getCondition()).toJSONObject() );
		o.addProperty( "endTemplate", getEndTemplate() );
		o.addProperty( "singleLine", isSingleLine() );
		return o;
	}

	public String toString() {
		return getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + " { "
					 + "beginMatch : " + beginMatch + ", "
					 + "beginPrefix : " + beginPrefix + ", "
					 + "check : " + (check == null ? null : check.getClass().getSimpleName() + "@" + Integer.toHexString(check.hashCode())) + ", "
					 + "condition : " + (condition == null ? null : condition.getClass().getSimpleName() + "@" + Integer.toHexString(condition.hashCode())) + ", "
					 + "endTemplate : " + endTemplate + ", "
					 + "singleLine : " + singleLine
					+" }";
	}

	private final String beginMatch;
	public String getBeginMatch() {
		return this.beginMatch;
	}
	

	private final String beginPrefix;
	public String getBeginPrefix() {
		return this.beginPrefix;
	}
	

	private final Check check;
	public Check getCheck() {
		return this.check;
	}
	

	private final Condition condition;
	public Condition getCondition() {
		return this.condition;
	}
	

	private final String endTemplate;
	public String getEndTemplate() {
		return this.endTemplate;
	}
	

	private final boolean singleLine;
	public boolean isSingleLine() {
		return this.singleLine;
	}
	


	public static class Builder implements PartitionRule_DynamicEnd.Builder {
		private final EditorGModel instance;

		public Builder(EditorGModel instance) {
			this.instance = instance;
		}
		private String beginMatch;
		public Builder beginMatch(String beginMatch) {
			this.beginMatch = beginMatch;
			return this;
		}
		private String beginPrefix;
		public Builder beginPrefix(String beginPrefix) {
			this.beginPrefix = beginPrefix;
			return this;
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
		private String endTemplate;
		public Builder endTemplate(String endTemplate) {
			this.endTemplate = endTemplate;
			return this;
		}
		private boolean singleLine;
		public Builder singleLine(boolean singleLine) {
			this.singleLine = singleLine;
			return this;
		}

		public PartitionRule_DynamicEnd build() {
			return new GsonPartitionRule_DynamicEndImpl(beginMatch, beginPrefix, check, condition, endTemplate, singleLine);
		}
	}
}
