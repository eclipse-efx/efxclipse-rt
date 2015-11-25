package org.eclipse.fx.code.editor.configuration.gson;

import org.eclipse.fx.code.editor.configuration.*;
import com.google.gson.JsonObject;

public final class GsonRangeImpl implements GsonBase, Range, Check {
	public GsonRangeImpl(JsonObject jsonObject) {
		this.max = jsonObject.has("max") ? jsonObject.get("max").getAsInt() : 1;
		this.maxIncl = jsonObject.has("maxIncl") ? jsonObject.get("maxIncl").getAsBoolean() : false;
		this.min = jsonObject.has("min") ? jsonObject.get("min").getAsInt() : 1;
		this.minIncl = jsonObject.has("minIncl") ? jsonObject.get("minIncl").getAsBoolean() : false;
	}

	public GsonRangeImpl(int max, boolean maxIncl, int min, boolean minIncl) {
		this.max = max;
		this.maxIncl = maxIncl;
		this.min = min;
		this.minIncl = minIncl;
	}

	public JsonObject toJSONObject() {
		JsonObject o = new JsonObject();
		o.addProperty( "__type", "Range" );
		o.addProperty( "max", getMax() );
		o.addProperty( "maxIncl", isMaxIncl() );
		o.addProperty( "min", getMin() );
		o.addProperty( "minIncl", isMinIncl() );
		return o;
	}

	public String toString() {
		return getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + " { "
					 + "max : " + max + ", "
					 + "maxIncl : " + maxIncl + ", "
					 + "min : " + min + ", "
					 + "minIncl : " + minIncl
					+" }";
	}

	private final int max;
	public int getMax() {
		return this.max;
	}
	

	private final boolean maxIncl;
	public boolean isMaxIncl() {
		return this.maxIncl;
	}
	

	private final int min;
	public int getMin() {
		return this.min;
	}
	

	private final boolean minIncl;
	public boolean isMinIncl() {
		return this.minIncl;
	}
	

	public static class Builder implements Range.Builder {
		private final EditorGModel instance;

		public Builder(EditorGModel instance) {
			this.instance = instance;
		}

		private int max;
		public Builder max(int max) {
			this.max = max;
			return this;
		}
		private boolean maxIncl;
		public Builder maxIncl(boolean maxIncl) {
			this.maxIncl = maxIncl;
			return this;
		}
		private int min;
		public Builder min(int min) {
			this.min = min;
			return this;
		}
		private boolean minIncl;
		public Builder minIncl(boolean minIncl) {
			this.minIncl = minIncl;
			return this;
		}

		public Range build() {
			return new GsonRangeImpl(max, maxIncl, min, minIncl);
		}
	}
}
