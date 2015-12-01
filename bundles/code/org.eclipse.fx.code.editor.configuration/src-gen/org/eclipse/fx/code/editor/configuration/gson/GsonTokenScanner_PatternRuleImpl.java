package org.eclipse.fx.code.editor.configuration.gson;

import org.eclipse.fx.code.editor.configuration.*;
import com.google.gson.JsonObject;

public final class GsonTokenScanner_PatternRuleImpl implements GsonBase, TokenScanner_PatternRule, TokenScanner {
	public GsonTokenScanner_PatternRuleImpl(JsonObject jsonObject) {
		this.check = jsonObject.has("check") ? GsonElementFactory.createCheck(jsonObject.getAsJsonObject("check")) : null;
		this.containmentPattern = jsonObject.has("containmentPattern") ? jsonObject.get("containmentPattern").getAsString() : null;
		this.startLength = jsonObject.has("startLength") ? jsonObject.get("startLength").getAsInt() : 1;
		this.startPattern = jsonObject.has("startPattern") ? jsonObject.get("startPattern").getAsString() : null;
	}
	public GsonTokenScanner_PatternRuleImpl(Check check, String containmentPattern, int startLength, String startPattern) {
		this.check = check;
		this.containmentPattern = containmentPattern;
		this.startLength = startLength;
		this.startPattern = startPattern;
	}

	public JsonObject toJSONObject() {
		JsonObject o = new JsonObject();
		o.addProperty( "$gtype", "TokenScanner_PatternRule" );
		o.add( "check", getCheck() == null ? null : ((GsonBase)getCheck()).toJSONObject() );
		o.addProperty( "containmentPattern", getContainmentPattern() );
		o.addProperty( "startLength", getStartLength() );
		o.addProperty( "startPattern", getStartPattern() );
		return o;
	}

	public String toString() {
		return getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + " { "
					 + "check : " + (check == null ? null : check.getClass().getSimpleName() + "@" + Integer.toHexString(check.hashCode())) + ", "
					 + "containmentPattern : " + containmentPattern + ", "
					 + "startLength : " + startLength + ", "
					 + "startPattern : " + startPattern
					+" }";
	}

	private final Check check;
	public Check getCheck() {
		return this.check;
	}
	

	private final String containmentPattern;
	public String getContainmentPattern() {
		return this.containmentPattern;
	}
	

	private final int startLength;
	public int getStartLength() {
		return this.startLength;
	}
	

	private final String startPattern;
	public String getStartPattern() {
		return this.startPattern;
	}
	


	public static class Builder implements TokenScanner_PatternRule.Builder {
		private final EditorGModel instance;

		public Builder(EditorGModel instance) {
			this.instance = instance;
		}
		private Check check;
		public Builder check(Check check) {
			this.check = check;
			return this;
		}
		private String containmentPattern;
		public Builder containmentPattern(String containmentPattern) {
			this.containmentPattern = containmentPattern;
			return this;
		}
		private int startLength;
		public Builder startLength(int startLength) {
			this.startLength = startLength;
			return this;
		}
		private String startPattern;
		public Builder startPattern(String startPattern) {
			this.startPattern = startPattern;
			return this;
		}

		public TokenScanner_PatternRule build() {
			return new GsonTokenScanner_PatternRuleImpl(check, containmentPattern, startLength, startPattern);
		}
	}
}
