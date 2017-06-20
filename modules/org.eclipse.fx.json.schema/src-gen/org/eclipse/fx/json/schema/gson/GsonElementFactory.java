package org.eclipse.fx.json.schema.gson;

import org.eclipse.fx.json.schema.*;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;

public final class GsonElementFactory implements JsonSchemaGModel {
	public static JsonSchema createJsonSchema(JsonObject o) {
		if( o.has("$gtype") ) {
			switch( o.get("$gtype").getAsString() ) {
				case "JsonSchema":
					return new GsonJsonSchemaImpl(o);
				default:
					throw new IllegalStateException();
			}
		} else {
			return new GsonJsonSchemaImpl(o);
		}
	}
	public JsonSchema.Builder JsonSchemaBuilder() {
		return new GsonJsonSchemaImpl.Builder(this);
	}

	public static JsonSchemaMap createJsonSchemaMap(JsonObject o) {
		if( o.has("$gtype") ) {
			switch( o.get("$gtype").getAsString() ) {
				case "JsonSchemaMap":
					return new GsonJsonSchemaMapImpl(o);
				default:
					throw new IllegalStateException();
			}
		} else {
			return new GsonJsonSchemaMapImpl(o);
		}
	}
	public JsonSchemaMap.Builder JsonSchemaMapBuilder() {
		return new GsonJsonSchemaMapImpl.Builder(this);
	}



	public <T extends JsonSchemaBase> T createObject(java.io.Reader json) {
		JsonObject o = new com.google.gson.Gson().fromJson( json, JsonObject.class);
		return _createObject(o);
	}

	@SuppressWarnings("unchecked")
	private static <T extends JsonSchemaBase> T _createObject(JsonObject o) {
		if( o.has("$gtype") ) {
			switch( o.get("$gtype").getAsString() ) {
				case "JsonSchema":
					return (T) createJsonSchema(o);
				case "JsonSchemaMap":
					return (T) createJsonSchemaMap(o);
			}
		}
		return (T) createJsonSchema(o);
	}

	public <T extends JsonSchemaBase> java.util.List<T> createList(java.io.Reader json) {
		JsonArray ar = new com.google.gson.Gson().fromJson( json, JsonArray.class);
		return java.util.stream.StreamSupport.stream(ar.spliterator(), false)
			.map( e -> (JsonObject)e)
			.map( GsonElementFactory::<T>_createObject)
			.collect(java.util.stream.Collectors.toList());
	}

	public String toString(JsonSchemaBase o) {
		return new com.google.gson.GsonBuilder().setPrettyPrinting().create().toJson( ((GsonBase)o).toJSONObject() );
	}

	public String toString(java.util.List<JsonSchemaBase> o) {
		return new com.google.gson.GsonBuilder().setPrettyPrinting().create().toJson( GsonBase.toDomainJsonArray(o) );
	}
}
