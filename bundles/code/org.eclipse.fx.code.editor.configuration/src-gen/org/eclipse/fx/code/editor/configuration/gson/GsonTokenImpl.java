package org.eclipse.fx.code.editor.configuration.gson;

import org.eclipse.fx.code.editor.configuration.*;
import com.google.gson.JsonObject;

public final class GsonTokenImpl implements GsonBase, Token {
	public GsonTokenImpl(JsonObject jsonObject) {
		this.defaultToken = jsonObject.has("defaultToken") ? jsonObject.get("defaultToken").getAsBoolean() : false;
		this.name = jsonObject.has("name") ? jsonObject.get("name").getAsString() : null;
		this.tokenScannerList = java.util.Collections.unmodifiableList(java.util.stream.StreamSupport.stream( jsonObject.getAsJsonArray("tokenScannerList").spliterator(), false )
								.map( e -> GsonElementFactory.createTokenScanner(e.getAsJsonObject())).collect(java.util.stream.Collectors.toList()));
	}

	public GsonTokenImpl(boolean defaultToken, String name, java.util.List<TokenScanner> tokenScannerList) {
		this.defaultToken = defaultToken;
		this.name = name;
		this.tokenScannerList = tokenScannerList;
	}

	public JsonObject toJSONObject() {
		JsonObject o = new JsonObject();
		o.addProperty( "__type", "Token" );
		o.addProperty( "defaultToken", isDefaultToken() );
		o.addProperty( "name", getName() );
		o.add( "tokenScannerList", GsonBase.toDomainJsonArray(getTokenScannerList()) );
		return o;
	}

	public String toString() {
		return getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + " { "
					 + "defaultToken : " + defaultToken + ", "
					 + "name : " + name + ", "
					 + "tokenScannerList : " + tokenScannerList.stream().map( e -> e.getClass().getSimpleName() + "@" + Integer.toHexString(e.hashCode()) ).collect(java.util.stream.Collectors.toList())
					+" }";
	}

	private final boolean defaultToken;
	public boolean isDefaultToken() {
		return this.defaultToken;
	}
	

	private final String name;
	public String getName() {
		return this.name;
	}
	

	private final java.util.List<TokenScanner> tokenScannerList;
	public java.util.List<TokenScanner> getTokenScannerList() {
		return this.tokenScannerList;
	}
	

	public static class Builder implements Token.Builder {
		private final EditorGModel instance;

		public Builder(EditorGModel instance) {
			this.instance = instance;
		}

		private boolean defaultToken;
		public Builder defaultToken(boolean defaultToken) {
			this.defaultToken = defaultToken;
			return this;
		}
		private String name;
		public Builder name(String name) {
			this.name = name;
			return this;
		}
		private final java.util.List<TokenScanner> tokenScannerList = new java.util.ArrayList<>();
		public Builder tokenScannerList(java.util.List<TokenScanner> tokenScannerList) {
			this.tokenScannerList.addAll(tokenScannerList);
			return this;
		}
		public Builder appendTokenScannerList(TokenScanner tokenScannerList) {
			this.tokenScannerList.add(tokenScannerList);
			return this;
		}
		public Builder tokenScannerList(java.util.function.Function<EditorGModel,java.util.List<TokenScanner>> provider) {
			tokenScannerList( provider.apply( instance ) );
			return this;
		}

		public Builder appendTokenScannerList(java.util.function.Function<TokenScanner.Builder,TokenScanner> provider) {
			appendTokenScannerList( provider.apply( new GsonTokenScannerImpl.Builder(instance) ) );
			return this;
		}

		public Token build() {
			return new GsonTokenImpl(defaultToken, name, tokenScannerList);
		}
	}
}
