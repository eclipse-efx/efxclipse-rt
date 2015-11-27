package org.eclipse.fx.json.schema.gson;

import org.eclipse.fx.json.schema.*;
import com.google.gson.JsonObject;

public final class GsonJsonSchemaImpl implements GsonBase, JsonSchema {
	public GsonJsonSchemaImpl(JsonObject jsonObject) {
		this.definitions = jsonObject.has("definitions") ? GsonElementFactory.createJsonSchemaMap(jsonObject.getAsJsonObject("definitions")) : null;
		this.description = jsonObject.has("description") ? jsonObject.get("description").getAsString() : null;
		this.id = jsonObject.has("id") ? jsonObject.get("id").getAsString() : null;
		this.items = jsonObject.has("items") ? GsonElementFactory.createJsonSchema(jsonObject.getAsJsonObject("items")) : null;
		this.maximum = jsonObject.has("maximum") ? jsonObject.get("maximum").getAsDouble() : 0.0;
		this.minimum = jsonObject.has("minimum") ? jsonObject.get("minimum").getAsDouble() : 0.0;
		this.properties = jsonObject.has("properties") ? GsonElementFactory.createJsonSchemaMap(jsonObject.getAsJsonObject("properties")) : null;
		this.required = jsonObject.has("required") ? java.util.Collections.unmodifiableList(java.util.stream.StreamSupport.stream( jsonObject.getAsJsonArray("required").spliterator(), false )
								.map( e -> e.getAsString()).collect(java.util.stream.Collectors.toList())) : java.util.Collections.emptyList();
		this.schema = jsonObject.has("schema") ? jsonObject.get("schema").getAsString() : null;
		this.title = jsonObject.has("title") ? jsonObject.get("title").getAsString() : null;
		this.type = jsonObject.has("type") ? jsonObject.get("type").getAsString() : null;
	}
	public GsonJsonSchemaImpl(JsonSchemaMap definitions, String description, String id, JsonSchema items, double maximum, double minimum, JsonSchemaMap properties, java.util.List<String> required, String schema, String title, String type) {
		this.definitions = definitions;
		this.description = description;
		this.id = id;
		this.items = items;
		this.maximum = maximum;
		this.minimum = minimum;
		this.properties = properties;
		this.required = required;
		this.schema = schema;
		this.title = title;
		this.type = type;
	}

	public JsonObject toJSONObject() {
		JsonObject o = new JsonObject();
		o.addProperty( "$gtype", "JsonSchema" );
		o.add( "definitions", getDefinitions() == null ? null : ((GsonBase)getDefinitions()).toJSONObject() );
		o.addProperty( "description", getDescription() );
		o.addProperty( "id", getId() );
		o.add( "items", getItems() == null ? null : ((GsonBase)getItems()).toJSONObject() );
		o.addProperty( "maximum", getMaximum() );
		o.addProperty( "minimum", getMinimum() );
		o.add( "properties", getProperties() == null ? null : ((GsonBase)getProperties()).toJSONObject() );
		o.add( "required", GsonBase.toJsonArray(getRequired().stream().map(com.google.gson.JsonPrimitive::new).collect(java.util.stream.Collectors.toList())) );
		o.addProperty( "schema", getSchema() );
		o.addProperty( "title", getTitle() );
		o.addProperty( "type", getType() );
		return o;
	}

	public String toString() {
		return getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + " { "
					 + "definitions : " + (definitions == null ? null : definitions.getClass().getSimpleName() + "@" + Integer.toHexString(definitions.hashCode())) + ", "
					 + "description : " + description + ", "
					 + "id : " + id + ", "
					 + "items : " + (items == null ? null : items.getClass().getSimpleName() + "@" + Integer.toHexString(items.hashCode())) + ", "
					 + "maximum : " + maximum + ", "
					 + "minimum : " + minimum + ", "
					 + "properties : " + (properties == null ? null : properties.getClass().getSimpleName() + "@" + Integer.toHexString(properties.hashCode())) + ", "
					 + "required : " + required + ", "
					 + "schema : " + schema + ", "
					 + "title : " + title + ", "
					 + "type : " + type
					+" }";
	}

	private final JsonSchemaMap definitions;
	public JsonSchemaMap getDefinitions() {
		return this.definitions;
	}
	

	private final String description;
	public String getDescription() {
		return this.description;
	}
	

	private final String id;
	public String getId() {
		return this.id;
	}
	

	private final JsonSchema items;
	public JsonSchema getItems() {
		return this.items;
	}
	

	private final double maximum;
	public double getMaximum() {
		return this.maximum;
	}
	

	private final double minimum;
	public double getMinimum() {
		return this.minimum;
	}
	

	private final JsonSchemaMap properties;
	public JsonSchemaMap getProperties() {
		return this.properties;
	}
	

	private final java.util.List<String> required;
	public java.util.List<String> getRequired() {
		return this.required;
	}
	

	private final String schema;
	public String getSchema() {
		return this.schema;
	}
	

	private final String title;
	public String getTitle() {
		return this.title;
	}
	

	private final String type;
	public String getType() {
		return this.type;
	}
	


	public static class Builder implements JsonSchema.Builder {
		private final JsonSchemaGModel instance;

		public Builder(JsonSchemaGModel instance) {
			this.instance = instance;
		}
		private JsonSchemaMap definitions;
		public Builder definitions(JsonSchemaMap definitions) {
			this.definitions = definitions;
			return this;
		}
		private String description;
		public Builder description(String description) {
			this.description = description;
			return this;
		}
		private String id;
		public Builder id(String id) {
			this.id = id;
			return this;
		}
		private JsonSchema items;
		public Builder items(JsonSchema items) {
			this.items = items;
			return this;
		}
		private double maximum;
		public Builder maximum(double maximum) {
			this.maximum = maximum;
			return this;
		}
		private double minimum;
		public Builder minimum(double minimum) {
			this.minimum = minimum;
			return this;
		}
		private JsonSchemaMap properties;
		public Builder properties(JsonSchemaMap properties) {
			this.properties = properties;
			return this;
		}
		private final java.util.List<String> required = new java.util.ArrayList<>();
		public Builder required(java.util.List<String> required) {
			this.required.addAll(required);
			return this;
		}
		public Builder appendRequired(String required) {
			this.required.add(required);
			return this;
		}
		private String schema;
		public Builder schema(String schema) {
			this.schema = schema;
			return this;
		}
		private String title;
		public Builder title(String title) {
			this.title = title;
			return this;
		}
		private String type;
		public Builder type(String type) {
			this.type = type;
			return this;
		}

		public JsonSchema build() {
			return new GsonJsonSchemaImpl(definitions, description, id, items, maximum, minimum, properties, required, schema, title, type);
		}
	}
}
