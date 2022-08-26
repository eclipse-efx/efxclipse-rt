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
package org.eclipse.fx.code.editor.configuration;

public interface Partition extends EditorBase {
	public String getName();
	public java.util.List<PartitionRule> getRuleList();
	public java.util.List<Token> getTokenList();
	public PartitionWhiteSpace getWhitespace();

	public interface Builder {
		public Builder name(String name);
		public Builder ruleList(java.util.List<PartitionRule> ruleList);
		public Builder appendRuleList(PartitionRule ruleList);
		public Builder ruleList(java.util.function.Function<EditorGModel,java.util.List<PartitionRule>> provider);
		public Builder appendRuleList(java.util.function.Function<PartitionRule.Builder,PartitionRule> provider);
		public Builder tokenList(java.util.List<Token> tokenList);
		public Builder appendTokenList(Token tokenList);
		public Builder tokenList(java.util.function.Function<EditorGModel,java.util.List<Token>> provider);
		public Builder appendTokenList(java.util.function.Function<Token.Builder,Token> provider);
		public Builder whitespace(PartitionWhiteSpace whitespace);
		public Partition build();
	}
}
