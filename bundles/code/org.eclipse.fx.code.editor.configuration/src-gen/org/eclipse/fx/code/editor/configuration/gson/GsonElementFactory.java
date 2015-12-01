package org.eclipse.fx.code.editor.configuration.gson;

import org.eclipse.fx.code.editor.configuration.*;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;

public final class GsonElementFactory implements EditorGModel {
	public static LanguageDef createLanguageDef(JsonObject o) {
		if( o.has("$gtype") ) {
			switch( o.get("$gtype").getAsString() ) {
				case "LanguageDef":
					return new GsonLanguageDefImpl(o);
				default:
					throw new IllegalStateException();
			}
		} else {
			return new GsonLanguageDefImpl(o);
		}
	}
	public LanguageDef.Builder LanguageDefBuilder() {
		return new GsonLanguageDefImpl.Builder(this);
	}

	public static Partition createPartition(JsonObject o) {
		if( o.has("$gtype") ) {
			switch( o.get("$gtype").getAsString() ) {
				case "Partition":
					return new GsonPartitionImpl(o);
				default:
					throw new IllegalStateException();
			}
		} else {
			return new GsonPartitionImpl(o);
		}
	}
	public Partition.Builder PartitionBuilder() {
		return new GsonPartitionImpl.Builder(this);
	}

	public static PartitionRule createPartitionRule(JsonObject o) {
		if( o.has("$gtype") ) {
			switch( o.get("$gtype").getAsString() ) {
				case "PartitionRule":
					return new GsonPartitionRuleImpl(o);
				case "PartitionRule_MultiLine":
					return new GsonPartitionRule_MultiLineImpl(o);
				case "PartitionRule_SingleLine":
					return new GsonPartitionRule_SingleLineImpl(o);
				default:
					throw new IllegalStateException();
			}
		} else {
			return new GsonPartitionRuleImpl(o);
		}
	}
	public PartitionRule.Builder PartitionRuleBuilder() {
		return new GsonPartitionRuleImpl.Builder(this);
	}

	public static PartitionRule_MultiLine createPartitionRule_MultiLine(JsonObject o) {
		if( o.has("$gtype") ) {
			switch( o.get("$gtype").getAsString() ) {
				case "PartitionRule_MultiLine":
					return new GsonPartitionRule_MultiLineImpl(o);
				default:
					throw new IllegalStateException();
			}
		} else {
			return new GsonPartitionRule_MultiLineImpl(o);
		}
	}
	public PartitionRule_MultiLine.Builder PartitionRule_MultiLineBuilder() {
		return new GsonPartitionRule_MultiLineImpl.Builder(this);
	}

	public static PartitionRule_SingleLine createPartitionRule_SingleLine(JsonObject o) {
		if( o.has("$gtype") ) {
			switch( o.get("$gtype").getAsString() ) {
				case "PartitionRule_SingleLine":
					return new GsonPartitionRule_SingleLineImpl(o);
				default:
					throw new IllegalStateException();
			}
		} else {
			return new GsonPartitionRule_SingleLineImpl(o);
		}
	}
	public PartitionRule_SingleLine.Builder PartitionRule_SingleLineBuilder() {
		return new GsonPartitionRule_SingleLineImpl.Builder(this);
	}

	public static PartitionWhiteSpace createPartitionWhiteSpace(JsonObject o) {
		if( o.has("$gtype") ) {
			switch( o.get("$gtype").getAsString() ) {
				case "PartitionWhiteSpace":
					return new GsonPartitionWhiteSpaceImpl(o);
				default:
					throw new IllegalStateException();
			}
		} else {
			return new GsonPartitionWhiteSpaceImpl(o);
		}
	}
	public PartitionWhiteSpace.Builder PartitionWhiteSpaceBuilder() {
		return new GsonPartitionWhiteSpaceImpl.Builder(this);
	}

	public static Token createToken(JsonObject o) {
		if( o.has("$gtype") ) {
			switch( o.get("$gtype").getAsString() ) {
				case "Token":
					return new GsonTokenImpl(o);
				default:
					throw new IllegalStateException();
			}
		} else {
			return new GsonTokenImpl(o);
		}
	}
	public Token.Builder TokenBuilder() {
		return new GsonTokenImpl.Builder(this);
	}

	public static TokenScanner createTokenScanner(JsonObject o) {
		if( o.has("$gtype") ) {
			switch( o.get("$gtype").getAsString() ) {
				case "TokenScanner":
					return new GsonTokenScannerImpl(o);
				case "TokenScanner_CharacterRule":
					return new GsonTokenScanner_CharacterRuleImpl(o);
				case "TokenScanner_Keyword":
					return new GsonTokenScanner_KeywordImpl(o);
				case "TokenScanner_PatternRule":
					return new GsonTokenScanner_PatternRuleImpl(o);
				case "TokenScanner_SingleLineRule":
					return new GsonTokenScanner_SingleLineRuleImpl(o);
				case "TokenScanner_MultiLineRule":
					return new GsonTokenScanner_MultiLineRuleImpl(o);
				default:
					throw new IllegalStateException();
			}
		} else {
			return new GsonTokenScannerImpl(o);
		}
	}
	public TokenScanner.Builder TokenScannerBuilder() {
		return new GsonTokenScannerImpl.Builder(this);
	}

	public static TokenScanner_CharacterRule createTokenScanner_CharacterRule(JsonObject o) {
		if( o.has("$gtype") ) {
			switch( o.get("$gtype").getAsString() ) {
				case "TokenScanner_CharacterRule":
					return new GsonTokenScanner_CharacterRuleImpl(o);
				default:
					throw new IllegalStateException();
			}
		} else {
			return new GsonTokenScanner_CharacterRuleImpl(o);
		}
	}
	public TokenScanner_CharacterRule.Builder TokenScanner_CharacterRuleBuilder() {
		return new GsonTokenScanner_CharacterRuleImpl.Builder(this);
	}

	public static TokenScanner_Keyword createTokenScanner_Keyword(JsonObject o) {
		if( o.has("$gtype") ) {
			switch( o.get("$gtype").getAsString() ) {
				case "TokenScanner_Keyword":
					return new GsonTokenScanner_KeywordImpl(o);
				default:
					throw new IllegalStateException();
			}
		} else {
			return new GsonTokenScanner_KeywordImpl(o);
		}
	}
	public TokenScanner_Keyword.Builder TokenScanner_KeywordBuilder() {
		return new GsonTokenScanner_KeywordImpl.Builder(this);
	}

	public static TokenScanner_PatternRule createTokenScanner_PatternRule(JsonObject o) {
		if( o.has("$gtype") ) {
			switch( o.get("$gtype").getAsString() ) {
				case "TokenScanner_PatternRule":
					return new GsonTokenScanner_PatternRuleImpl(o);
				default:
					throw new IllegalStateException();
			}
		} else {
			return new GsonTokenScanner_PatternRuleImpl(o);
		}
	}
	public TokenScanner_PatternRule.Builder TokenScanner_PatternRuleBuilder() {
		return new GsonTokenScanner_PatternRuleImpl.Builder(this);
	}

	public static TokenScanner_SingleLineRule createTokenScanner_SingleLineRule(JsonObject o) {
		if( o.has("$gtype") ) {
			switch( o.get("$gtype").getAsString() ) {
				case "TokenScanner_SingleLineRule":
					return new GsonTokenScanner_SingleLineRuleImpl(o);
				default:
					throw new IllegalStateException();
			}
		} else {
			return new GsonTokenScanner_SingleLineRuleImpl(o);
		}
	}
	public TokenScanner_SingleLineRule.Builder TokenScanner_SingleLineRuleBuilder() {
		return new GsonTokenScanner_SingleLineRuleImpl.Builder(this);
	}

	public static TokenScanner_MultiLineRule createTokenScanner_MultiLineRule(JsonObject o) {
		if( o.has("$gtype") ) {
			switch( o.get("$gtype").getAsString() ) {
				case "TokenScanner_MultiLineRule":
					return new GsonTokenScanner_MultiLineRuleImpl(o);
				default:
					throw new IllegalStateException();
			}
		} else {
			return new GsonTokenScanner_MultiLineRuleImpl(o);
		}
	}
	public TokenScanner_MultiLineRule.Builder TokenScanner_MultiLineRuleBuilder() {
		return new GsonTokenScanner_MultiLineRuleImpl.Builder(this);
	}

	public static Check createCheck(JsonObject o) {
		if( o.has("$gtype") ) {
			switch( o.get("$gtype").getAsString() ) {
				case "Check":
					return new GsonCheckImpl(o);
				case "Equals":
					return new GsonEqualsImpl(o);
				case "Range":
					return new GsonRangeImpl(o);
				default:
					throw new IllegalStateException();
			}
		} else {
			return new GsonCheckImpl(o);
		}
	}
	public Check.Builder CheckBuilder() {
		return new GsonCheckImpl.Builder(this);
	}

	public static Equals createEquals(JsonObject o) {
		if( o.has("$gtype") ) {
			switch( o.get("$gtype").getAsString() ) {
				case "Equals":
					return new GsonEqualsImpl(o);
				default:
					throw new IllegalStateException();
			}
		} else {
			return new GsonEqualsImpl(o);
		}
	}
	public Equals.Builder EqualsBuilder() {
		return new GsonEqualsImpl.Builder(this);
	}

	public static Range createRange(JsonObject o) {
		if( o.has("$gtype") ) {
			switch( o.get("$gtype").getAsString() ) {
				case "Range":
					return new GsonRangeImpl(o);
				default:
					throw new IllegalStateException();
			}
		} else {
			return new GsonRangeImpl(o);
		}
	}
	public Range.Builder RangeBuilder() {
		return new GsonRangeImpl.Builder(this);
	}



	public <T extends EditorBase> T createObject(java.io.Reader json) {
		JsonObject o = new com.google.gson.Gson().fromJson( json, JsonObject.class);
		return _createObject(o);
	}

	@SuppressWarnings("unchecked")
	private static <T extends EditorBase> T _createObject(JsonObject o) {
		if( o.has("$gtype") ) {
			switch( o.get("$gtype").getAsString() ) {
				case "LanguageDef":
					return (T) createLanguageDef(o);
				case "Partition":
					return (T) createPartition(o);
				case "PartitionRule":
					return (T) createPartitionRule(o);
				case "PartitionRule_MultiLine":
					return (T) createPartitionRule_MultiLine(o);
				case "PartitionRule_SingleLine":
					return (T) createPartitionRule_SingleLine(o);
				case "PartitionWhiteSpace":
					return (T) createPartitionWhiteSpace(o);
				case "Token":
					return (T) createToken(o);
				case "TokenScanner":
					return (T) createTokenScanner(o);
				case "TokenScanner_CharacterRule":
					return (T) createTokenScanner_CharacterRule(o);
				case "TokenScanner_Keyword":
					return (T) createTokenScanner_Keyword(o);
				case "TokenScanner_PatternRule":
					return (T) createTokenScanner_PatternRule(o);
				case "TokenScanner_SingleLineRule":
					return (T) createTokenScanner_SingleLineRule(o);
				case "TokenScanner_MultiLineRule":
					return (T) createTokenScanner_MultiLineRule(o);
				case "Check":
					return (T) createCheck(o);
				case "Equals":
					return (T) createEquals(o);
				case "Range":
					return (T) createRange(o);
			}
		}
		return (T) createLanguageDef(o);
	}

	public <T extends EditorBase> java.util.List<T> createList(java.io.Reader json) {
		JsonArray ar = new com.google.gson.Gson().fromJson( json, JsonArray.class);
		return java.util.stream.StreamSupport.stream(ar.spliterator(), false)
			.map( e -> (JsonObject)e)
			.map( GsonElementFactory::<T>_createObject)
			.collect(java.util.stream.Collectors.toList());
	}

	public String toString(EditorBase o) {
		return new com.google.gson.GsonBuilder().setPrettyPrinting().create().toJson( ((GsonBase)o).toJSONObject() );
	}

	public String toString(java.util.List<EditorBase> o) {
		return new com.google.gson.GsonBuilder().setPrettyPrinting().create().toJson( GsonBase.toDomainJsonArray(o) );
	}
}
