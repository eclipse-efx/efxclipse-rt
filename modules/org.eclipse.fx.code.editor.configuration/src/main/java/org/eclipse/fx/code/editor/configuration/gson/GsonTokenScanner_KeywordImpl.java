package org.eclipse.fx.code.editor.configuration.gson;

import org.eclipse.fx.code.editor.configuration.*;
import com.google.gson.JsonObject;

public final class GsonTokenScanner_KeywordImpl implements GsonBase, TokenScanner_Keyword, TokenScanner {
	public GsonTokenScanner_KeywordImpl(JsonObject jsonObject) {
		this.check = jsonObject.has("check") ? GsonElementFactory.createCheck(jsonObject.getAsJsonObject("check")) : null;
		this.condition = jsonObject.has("condition") ? GsonElementFactory.createCondition(jsonObject.getAsJsonObject("condition")) : null;
		this.keywordList = jsonObject.has("keywordList") ? java.util.Collections.unmodifiableList(java.util.stream.StreamSupport.stream( jsonObject.getAsJsonArray("keywordList").spliterator(), false )
								.map( e -> e.getAsString()).collect(java.util.stream.Collectors.toList())) : java.util.Collections.emptyList();
	}
	public GsonTokenScanner_KeywordImpl(Check check, Condition condition, java.util.List<String> keywordList) {
		this.check = check;
		this.condition = condition;
		this.keywordList = keywordList;
	}

	public JsonObject toJSONObject() {
		JsonObject o = new JsonObject();
		o.addProperty( "$gtype", "TokenScanner_Keyword" );
		o.add( "check", getCheck() == null ? null : ((GsonBase)getCheck()).toJSONObject() );
		o.add( "condition", getCondition() == null ? null : ((GsonBase)getCondition()).toJSONObject() );
		o.add( "keywordList", GsonBase.toJsonArray(getKeywordList().stream().map(com.google.gson.JsonPrimitive::new).collect(java.util.stream.Collectors.toList())) );
		return o;
	}

	public String toString() {
		return getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + " { "
					 + "check : " + (check == null ? null : check.getClass().getSimpleName() + "@" + Integer.toHexString(check.hashCode())) + ", "
					 + "condition : " + (condition == null ? null : condition.getClass().getSimpleName() + "@" + Integer.toHexString(condition.hashCode())) + ", "
					 + "keywordList : " + keywordList
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
	

	private final java.util.List<String> keywordList;
	public java.util.List<String> getKeywordList() {
		return this.keywordList;
	}
	


	public static class Builder implements TokenScanner_Keyword.Builder {
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
		private final java.util.List<String> keywordList = new java.util.ArrayList<>();
		public Builder keywordList(java.util.List<String> keywordList) {
			this.keywordList.addAll(keywordList);
			return this;
		}
		public Builder appendKeywordList(String keywordList) {
			this.keywordList.add(keywordList);
			return this;
		}

		public TokenScanner_Keyword build() {
			return new GsonTokenScanner_KeywordImpl(check, condition, keywordList);
		}
	}
}
