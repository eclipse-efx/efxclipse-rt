package org.eclipse.fx.code.editor.configuration.gson;

import org.eclipse.fx.code.editor.configuration.*;
import com.google.gson.JsonObject;

public final class GsonEqualsImpl implements GsonBase, Equals, Check {
	public GsonEqualsImpl(JsonObject jsonObject) {
		this.value = jsonObject.has("value") ? jsonObject.get("value").getAsInt() : 0;
	}

	public GsonEqualsImpl(int value) {
		this.value = value;
	}

	public JsonObject toJSONObject() {
		JsonObject o = new JsonObject();
		o.addProperty( "__type", "Equals" );
		o.addProperty( "value", getValue() );
		return o;
	}

	public String toString() {
		return getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + " { "
					 + "value : " + value
					+" }";
	}

	private final int value;
	public int getValue() {
		return this.value;
	}
	

	public static class Builder implements Equals.Builder {
		private final EditorGModel instance;

		public Builder(EditorGModel instance) {
			this.instance = instance;
		}

		private int value;
		public Builder value(int value) {
			this.value = value;
			return this;
		}

		public Equals build() {
			return new GsonEqualsImpl(value);
		}
	}
}
