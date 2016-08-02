package org.eclipse.fx.json.schema.gson;

import org.eclipse.fx.json.schema.*;
import com.google.gson.JsonObject;

public final class GsonJsonSchemaMapImpl implements GsonBase, JsonSchemaMap {
	public GsonJsonSchemaMapImpl(JsonObject jsonObject) {
		this.propertyMap = toMap(jsonObject);
	}
	public GsonJsonSchemaMapImpl(java.util.Map<String,JsonSchema> propertyMap) {
		this.propertyMap = propertyMap;
	}

	public JsonObject toJSONObject() {
		JsonObject o = new JsonObject();
		o.addProperty( "$gtype", "JsonSchemaMap" );
		for( java.util.Map.Entry<String,JsonSchema> e : this.propertyMap ) {
			o.add( e.getKey(), ((GsonBase)e.getValue()).toJSONObject() );
		}
		return o;
	}

	public String toString() {
		return getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + " { "
					+ "propertyMap : " + propertyMap
				+" }";
	}

	private static java.util.Map<String,JsonSchema> toMap(JsonObject o) {
		java.util.Map<String,JsonSchema> rv = new java.util.HashMap<>();
		for( java.util.Map.Entry<String,com.google.gson.JsonElement> e : o.entrySet() ) {
			if( e.getKey().startsWith("$") ) {
				continue;
			}
			rv.put( e.getKey(), GsonElementFactory.createJsonSchema(e.getValue().getAsJsonObject()) );
		}
		return rv;
	}

	private java.util.Map<String,JsonSchema> propertyMap;
	public java.util.Map<String,JsonSchema> getPropertyMap() {
		return this.propertyMap;
	}

	public static class Builder implements JsonSchemaMap.Builder {
		private final JsonSchemaGModel instance;

		public Builder(JsonSchemaGModel instance) {
			this.instance = instance;
		}
		java.util.Map<String,JsonSchema> propertyMap = new java.util.HashMap<>();

		public Builder propertyMap(java.util.Map<String,JsonSchema> propertyMap) {
			this.propertyMap.putAll(propertyMap);
			return this;
		}

		public Builder propertyMap(String key, JsonSchema value) {
			this.propertyMap.put(key,value);
			return this;
		}

		public Builder propertyMap(String key, java.util.function.Function<JsonSchema.Builder,JsonSchema> provider) {
			this.propertyMap.put(key,provider.apply( new GsonJsonSchemaImpl.Builder(instance) ) );
			return this;
		}

		public Builder propertyMap(java.util.function.Function<JsonSchemaGModel,java.util.Map<String,JsonSchema>> provider) {
			this.propertyMap.putAll(provider.apply( instance ) );
			return this;
		}

		public JsonSchemaMap build() {
			return new GsonJsonSchemaMapImpl(propertyMap);
		}
	}
}
