package org.eclipse.fx.json.schema;

public interface JsonSchemaGModel {
	public static JsonSchemaGModel create() {
		return new org.eclipse.fx.json.schema.gson.GsonElementFactory();
	}

	public <T extends JsonSchemaBase> T createObject(java.io.Reader json);
	public <T extends JsonSchemaBase> java.util.List<T> createList(java.io.Reader json);

	public String toString(JsonSchemaBase o);
	public String toString(java.util.List<JsonSchemaBase> o);

	public JsonSchema.Builder JsonSchemaBuilder();
	public JsonSchemaMap.Builder JsonSchemaMapBuilder();
}
