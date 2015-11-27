package org.eclipse.fx.json.schema.gson;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.List;

public interface GsonBase {
	public static JsonArray toJsonArray(List<JsonElement> list) {
		JsonArray ar = new JsonArray();
		list.stream().forEach(ar::add);
		return ar;
	}

	public static JsonArray toDomainJsonArray(List<?> list) {
		JsonArray ar = new JsonArray();
		list.stream().map( e -> (GsonBase)e ).map(GsonBase::toJSONObject).forEach(ar::add);
		return ar;
	}

	public JsonObject toJSONObject();
}
