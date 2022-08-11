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

public final class GsonPartitionImpl implements GsonBase, Partition {
	public GsonPartitionImpl(JsonObject jsonObject) {
		this.name = jsonObject.has("name") ? jsonObject.get("name").getAsString() : null;
		this.ruleList = jsonObject.has("ruleList") ? java.util.Collections.unmodifiableList(java.util.stream.StreamSupport.stream( jsonObject.getAsJsonArray("ruleList").spliterator(), false )
								.map( e -> GsonElementFactory.createPartitionRule(e.getAsJsonObject())).collect(java.util.stream.Collectors.toList())) : java.util.Collections.emptyList();
		this.tokenList = jsonObject.has("tokenList") ? java.util.Collections.unmodifiableList(java.util.stream.StreamSupport.stream( jsonObject.getAsJsonArray("tokenList").spliterator(), false )
								.map( e -> GsonElementFactory.createToken(e.getAsJsonObject())).collect(java.util.stream.Collectors.toList())) : java.util.Collections.emptyList();
		this.whitespace = jsonObject.has("whitespace") ? GsonElementFactory.createPartitionWhiteSpace(jsonObject.getAsJsonObject("whitespace")) : null;
	}
	public GsonPartitionImpl(String name, java.util.List<PartitionRule> ruleList, java.util.List<Token> tokenList, PartitionWhiteSpace whitespace) {
		this.name = name;
		this.ruleList = ruleList;
		this.tokenList = tokenList;
		this.whitespace = whitespace;
	}

	public JsonObject toJSONObject() {
		JsonObject o = new JsonObject();
		o.addProperty( "$gtype", "Partition" );
		o.addProperty( "name", getName() );
		o.add( "ruleList", GsonBase.toDomainJsonArray(getRuleList()) );
		o.add( "tokenList", GsonBase.toDomainJsonArray(getTokenList()) );
		o.add( "whitespace", getWhitespace() == null ? null : ((GsonBase)getWhitespace()).toJSONObject() );
		return o;
	}

	public String toString() {
		return getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + " { "
					 + "name : " + name + ", "
					 + "ruleList : " + ruleList.stream().map( e -> e.getClass().getSimpleName() + "@" + Integer.toHexString(e.hashCode()) ).collect(java.util.stream.Collectors.toList()) + ", "
					 + "tokenList : " + tokenList.stream().map( e -> e.getClass().getSimpleName() + "@" + Integer.toHexString(e.hashCode()) ).collect(java.util.stream.Collectors.toList()) + ", "
					 + "whitespace : " + (whitespace == null ? null : whitespace.getClass().getSimpleName() + "@" + Integer.toHexString(whitespace.hashCode()))
					+" }";
	}

	private final String name;
	public String getName() {
		return this.name;
	}
	

	private final java.util.List<PartitionRule> ruleList;
	public java.util.List<PartitionRule> getRuleList() {
		return this.ruleList;
	}
	

	private final java.util.List<Token> tokenList;
	public java.util.List<Token> getTokenList() {
		return this.tokenList;
	}
	

	private final PartitionWhiteSpace whitespace;
	public PartitionWhiteSpace getWhitespace() {
		return this.whitespace;
	}
	


	public static class Builder implements Partition.Builder {
		private final EditorGModel instance;

		public Builder(EditorGModel instance) {
			this.instance = instance;
		}
		private String name;
		public Builder name(String name) {
			this.name = name;
			return this;
		}
		private final java.util.List<PartitionRule> ruleList = new java.util.ArrayList<>();
		public Builder ruleList(java.util.List<PartitionRule> ruleList) {
			this.ruleList.addAll(ruleList);
			return this;
		}
		public Builder appendRuleList(PartitionRule ruleList) {
			this.ruleList.add(ruleList);
			return this;
		}
		public Builder ruleList(java.util.function.Function<EditorGModel,java.util.List<PartitionRule>> provider) {
			ruleList( provider.apply( instance ) );
			return this;
		}

		public Builder appendRuleList(java.util.function.Function<PartitionRule.Builder,PartitionRule> provider) {
			appendRuleList( provider.apply( new GsonPartitionRuleImpl.Builder(instance) ) );
			return this;
		}
		private final java.util.List<Token> tokenList = new java.util.ArrayList<>();
		public Builder tokenList(java.util.List<Token> tokenList) {
			this.tokenList.addAll(tokenList);
			return this;
		}
		public Builder appendTokenList(Token tokenList) {
			this.tokenList.add(tokenList);
			return this;
		}
		public Builder tokenList(java.util.function.Function<EditorGModel,java.util.List<Token>> provider) {
			tokenList( provider.apply( instance ) );
			return this;
		}

		public Builder appendTokenList(java.util.function.Function<Token.Builder,Token> provider) {
			appendTokenList( provider.apply( new GsonTokenImpl.Builder(instance) ) );
			return this;
		}
		private PartitionWhiteSpace whitespace;
		public Builder whitespace(PartitionWhiteSpace whitespace) {
			this.whitespace = whitespace;
			return this;
		}

		public Partition build() {
			return new GsonPartitionImpl(name, ruleList, tokenList, whitespace);
		}
	}
}
