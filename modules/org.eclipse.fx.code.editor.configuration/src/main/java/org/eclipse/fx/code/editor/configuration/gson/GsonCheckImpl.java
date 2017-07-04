package org.eclipse.fx.code.editor.configuration.gson;

import org.eclipse.fx.code.editor.configuration.*;
import com.google.gson.JsonObject;

public final class GsonCheckImpl implements GsonBase, Check {
	public GsonCheckImpl(JsonObject jsonObject) {
	}
	public GsonCheckImpl() {
	}

	public JsonObject toJSONObject() {
		JsonObject o = new JsonObject();
		o.addProperty( "$gtype", "Check" );
		return o;
	}

	public String toString() {
		return getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + " { "
					+" }";
	}


	public static class Builder implements Check.Builder {
		private final EditorGModel instance;

		public Builder(EditorGModel instance) {
			this.instance = instance;
		}

		public Check build() {
			return new GsonCheckImpl();
		}
	}
}
