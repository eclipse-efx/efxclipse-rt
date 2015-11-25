package org.eclipse.fx.code.editor.configuration.gson;

import org.eclipse.fx.code.editor.configuration.*;
import com.google.gson.JsonObject;

public final class GsonTokenScanner_CharacterRuleImpl implements GsonBase, TokenScanner_CharacterRule, TokenScanner {
	public GsonTokenScanner_CharacterRuleImpl(JsonObject jsonObject) {
		this.characterList = java.util.Collections.unmodifiableList(java.util.stream.StreamSupport.stream( jsonObject.getAsJsonArray("characterList").spliterator(), false )
								.map( e -> e.getAsString()).collect(java.util.stream.Collectors.toList()));
		this.check = jsonObject.has("check") ? GsonElementFactory.createCheck(jsonObject.getAsJsonObject("check")) : null;
	}

	public GsonTokenScanner_CharacterRuleImpl(java.util.List<String> characterList, Check check) {
		this.characterList = characterList;
		this.check = check;
	}

	public JsonObject toJSONObject() {
		JsonObject o = new JsonObject();
		o.addProperty( "__type", "TokenScanner_CharacterRule" );
		o.add( "characterList", GsonBase.toJsonArray(getCharacterList().stream().map(com.google.gson.JsonPrimitive::new).collect(java.util.stream.Collectors.toList())) );
		o.add( "check", getCheck() == null ? null : ((GsonBase)getCheck()).toJSONObject() );
		return o;
	}

	public String toString() {
		return getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + " { "
					 + "characterList : " + characterList + ", "
					 + "check : " + check == null ? null : check.getClass().getSimpleName() + "@" + Integer.toHexString(check.hashCode())
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

		public TokenScanner_CharacterRule build() {
			return new GsonTokenScanner_CharacterRuleImpl(characterList, check);
		}
	}
}
