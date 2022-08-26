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

import org.eclipse.fx.code.editor.configuration.*;
import com.google.gson.JsonObject;

public final class GsonPartitionWhiteSpaceImpl implements GsonBase, PartitionWhiteSpace {
	public GsonPartitionWhiteSpaceImpl(JsonObject jsonObject) {
		this.characterList = jsonObject.has("characterList") ? java.util.Collections.unmodifiableList(java.util.stream.StreamSupport.stream( jsonObject.getAsJsonArray("characterList").spliterator(), false )
								.map( e -> e.getAsString()).collect(java.util.stream.Collectors.toList())) : java.util.Collections.emptyList();
		this.javawhiteSpace = jsonObject.has("javawhiteSpace") ? jsonObject.get("javawhiteSpace").getAsBoolean() : false;
	}
	public GsonPartitionWhiteSpaceImpl(java.util.List<String> characterList, boolean javawhiteSpace) {
		this.characterList = characterList;
		this.javawhiteSpace = javawhiteSpace;
	}

	public JsonObject toJSONObject() {
		JsonObject o = new JsonObject();
		o.addProperty( "$gtype", "PartitionWhiteSpace" );
		o.add( "characterList", GsonBase.toJsonArray(getCharacterList().stream().map(com.google.gson.JsonPrimitive::new).collect(java.util.stream.Collectors.toList())) );
		o.addProperty( "javawhiteSpace", isJavawhiteSpace() );
		return o;
	}

	public String toString() {
		return getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + " { "
					 + "characterList : " + characterList + ", "
					 + "javawhiteSpace : " + javawhiteSpace
					+" }";
	}

	private final java.util.List<String> characterList;
	public java.util.List<String> getCharacterList() {
		return this.characterList;
	}
	

	private final boolean javawhiteSpace;
	public boolean isJavawhiteSpace() {
		return this.javawhiteSpace;
	}
	


	public static class Builder implements PartitionWhiteSpace.Builder {
		private final EditorGModel instance;

		public Builder(EditorGModel instance) {
			this.instance = instance;
		}
		private final java.util.List<String> characterList = new java.util.ArrayList<>();
		public Builder characterList(java.util.List<String> characterList) {
			this.characterList.addAll(characterList);
			return this;
		}
		public Builder appendCharacterList(String characterList) {
			this.characterList.add(characterList);
			return this;
		}
		private boolean javawhiteSpace;
		public Builder javawhiteSpace(boolean javawhiteSpace) {
			this.javawhiteSpace = javawhiteSpace;
			return this;
		}

		public PartitionWhiteSpace build() {
			return new GsonPartitionWhiteSpaceImpl(characterList, javawhiteSpace);
		}
	}
}
