package org.eclipse.fx.json.schema;

public interface JsonSchemaMap extends JsonSchemaBase {
	public java.util.Map<String,JsonSchema> getPropertyMap();

	public interface Builder {
		public JsonSchemaMap build();
	}
}
