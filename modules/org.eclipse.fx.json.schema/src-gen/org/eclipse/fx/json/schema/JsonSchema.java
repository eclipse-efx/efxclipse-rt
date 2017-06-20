package org.eclipse.fx.json.schema;

public interface JsonSchema extends JsonSchemaBase {
	public String getId();
	public String getSchema();
	public String getTitle();
	public String getDescription();
	public double getMaximum();
	public double getMinimum();
	public JsonSchema getItems();
	public String getType();
	public java.util.List<String> getRequired();
	public JsonSchemaMap getProperties();
	public JsonSchemaMap getDefinitions();

	public interface Builder {
		public Builder id(String id);
		public Builder schema(String schema);
		public Builder title(String title);
		public Builder description(String description);
		public Builder maximum(double maximum);
		public Builder minimum(double minimum);
		public Builder items(JsonSchema items);
		public Builder type(String type);
		public Builder required(java.util.List<String> required);
		public Builder appendRequired(String required);
		public Builder properties(JsonSchemaMap properties);
		public Builder definitions(JsonSchemaMap definitions);
		public JsonSchema build();
	}
}
