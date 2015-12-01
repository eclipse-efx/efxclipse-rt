package org.eclipse.fx.code.editor.configuration.gson;

import org.eclipse.fx.code.editor.configuration.*;
import com.google.gson.JsonObject;

public final class GsonTokenScannerImpl implements GsonBase, TokenScanner {
	public GsonTokenScannerImpl(JsonObject jsonObject) {
		this.check = jsonObject.has("check") ? GsonElementFactory.createCheck(jsonObject.getAsJsonObject("check")) : null;
	}
	public GsonTokenScannerImpl(Check check) {
		this.check = check;
	}

	public JsonObject toJSONObject() {
		JsonObject o = new JsonObject();
		o.addProperty( "$gtype", "TokenScanner" );
		o.add( "check", getCheck() == null ? null : ((GsonBase)getCheck()).toJSONObject() );
		return o;
	}

	public String toString() {
		return getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + " { "
					 + "check : " + (check == null ? null : check.getClass().getSimpleName() + "@" + Integer.toHexString(check.hashCode()))
					+" }";
	}

	private final Check check;
	public Check getCheck() {
		return this.check;
	}
	


	public static class Builder implements TokenScanner.Builder {
		private final EditorGModel instance;

		public Builder(EditorGModel instance) {
			this.instance = instance;
		}
		private Check check;
		public Builder check(Check check) {
			this.check = check;
			return this;
		}

		public TokenScanner build() {
			return new GsonTokenScannerImpl(check);
		}
	}
}
