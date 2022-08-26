/*******************************************************************************
 * Copyright (c) 2022 BestSolution.at and others.
 *  
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *  
 * SPDX-License-Identifier: EPL-2.0
 *  
 * Contributors:
 *     BestSolution.at - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.code.editor.configuration.gson;

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
