package org.eclipse.fx.code.editor.configuration.gson;

import org.eclipse.fx.code.editor.configuration.*;
import com.google.gson.JsonObject;

public final class GsonTokenScanner_CharacterRuleImpl implements GsonBase, TokenScanner_CharacterRule, TokenScanner {
	public GsonTokenScanner_CharacterRuleImpl(JsonObject jsonObject) {
		this.characterList = jsonObject.has("characterList") ? java.util.Collections.unmodifiableList(java.util.stream.StreamSupport.stream( jsonObject.getAsJsonArray("characterList").spliterator(), false )
								.map( e -> e.getAsString()).collect(java.util.stream.Collectors.toList())) : java.util.Collections.emptyList();
		this.check = jsonObject.has("check") ? GsonElementFactory.createCheck(jsonObject.getAsJsonObject("check")) : null;
		this.condition = jsonObject.has("condition") ? GsonElementFactory.createCondition(jsonObject.getAsJsonObject("condition")) : null;
	}
	public GsonTokenScanner_CharacterRuleImpl(java.util.List<String> characterList, Check check, Condition condition) {
		this.characterList = characterList;
		this.check = check;
		this.condition = condition;
	}

	public JsonObject toJSONObject() {
		JsonObject o = new JsonObject();
		o.addProperty( "$gtype", "TokenScanner_CharacterRule" );
		o.add( "characterList", GsonBase.toJsonArray(getCharacterList().stream().map(com.google.gson.JsonPrimitive::new).collect(java.util.stream.Collectors.toList())) );
		o.add( "check", getCheck() == null ? null : ((GsonBase)getCheck()).toJSONObject() );
		o.add( "condition", getCondition() == null ? null : ((GsonBase)getCondition()).toJSONObject() );
		return o;
	}

	public String toString() {
		return getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + " { "
					 + "characterList : " + characterList + ", "
					 + "check : " + (check == null ? null : check.getClass().getSimpleName() + "@" + Integer.toHexString(check.hashCode())) + ", "
					 + "condition : " + (condition == null ? null : condition.getClass().getSimpleName() + "@" + Integer.toHexString(condition.hashCode()))
					+" }";
	}

	private final java.util.List<String> characterList;
	public java.util.List<String> getCharacterList() {
		return this.characterList;
	}
	

	private final Check check;
	public Check getCheck() {
		return this.check;
	}
	

	private final Condition condition;
	public Condition getCondition() {
		return this.condition;
	}
	


	public static class Builder implements TokenScanner_CharacterRule.Builder {
		private final EditorGModel instance;

		public Builder(EditorGModel instance) {
			this.instance = instance;
		}
		private final java.util.List<String> characterList = new java.util.ArrayList<>();
		public Builder characterList(java.util.List<String> characterList) {
			this.characterList.addAll(characterList);
			return this;
		}
		public Builder appendCharacterList(String characterList) {
			this.characterList.add(characterList);
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

		public TokenScanner_CharacterRule build() {
			return new GsonTokenScanner_CharacterRuleImpl(characterList, check, condition);
		}
	}
}
