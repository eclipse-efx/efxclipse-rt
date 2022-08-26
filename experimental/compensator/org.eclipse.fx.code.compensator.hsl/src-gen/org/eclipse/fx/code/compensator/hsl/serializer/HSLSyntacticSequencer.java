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
package org.eclipse.fx.code.compensator.hsl.serializer;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.fx.code.compensator.hsl.services.HSLGrammarAccess;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AlternativeAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;

@SuppressWarnings("all")
public class HSLSyntacticSequencer extends AbstractSyntacticSequencer {

	protected HSLGrammarAccess grammarAccess;
	protected AbstractElementAlias match_JSDamager_JsDamagerKeyword_0_0_or_Js_damagerKeyword_0_1;
	protected AbstractElementAlias match_JSParitioner_JsPartitionerKeyword_0_0_or_Js_partitionerKeyword_0_1;
	protected AbstractElementAlias match_JavaLikeParitioner_JavaLikePartitionerKeyword_0_0_or_Java_like_partitionerKeyword_0_1;
	protected AbstractElementAlias match_PartitionJSRule_JavascriptRuleKeyword_0_0_or_Javascript_ruleKeyword_0_1;
	protected AbstractElementAlias match_PartitionMultiLineRule_MultiLineKeyword_0_0_or_Multi_lineKeyword_0_1;
	protected AbstractElementAlias match_PartitionSingleLineRule_SingleLineKeyword_0_0_or_Single_lineKeyword_0_1;
	protected AbstractElementAlias match_RuleDamager_RuleDamagerKeyword_0_0_or_Rule_damagerKeyword_0_1;
	protected AbstractElementAlias match_RulePartitioner_RulePartitionerKeyword_0_0_or_Rule_partitionerKeyword_0_1;
	protected AbstractElementAlias match_ScannerCharacterRule_CharacterRuleKeyword_0_0_or_Character_ruleKeyword_0_1;
	protected AbstractElementAlias match_ScannerJSRule_JavascriptRuleKeyword_0_0_or_Javascript_ruleKeyword_0_1;
	protected AbstractElementAlias match_ScannerMultiLineRule_MultiLineKeyword_0_0_or_Multi_lineKeyword_0_1;
	protected AbstractElementAlias match_ScannerSingleLineRule_SingleLineKeyword_0_0_or_Single_lineKeyword_0_1;
	protected AbstractElementAlias match_ScannerWhitespaceRule_WhitespaceRuleKeyword_0_0_or_Whitespace_ruleKeyword_0_1;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (HSLGrammarAccess) access;
		match_JSDamager_JsDamagerKeyword_0_0_or_Js_damagerKeyword_0_1 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getJSDamagerAccess().getJsDamagerKeyword_0_0()), new TokenAlias(false, false, grammarAccess.getJSDamagerAccess().getJs_damagerKeyword_0_1()));
		match_JSParitioner_JsPartitionerKeyword_0_0_or_Js_partitionerKeyword_0_1 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getJSParitionerAccess().getJsPartitionerKeyword_0_0()), new TokenAlias(false, false, grammarAccess.getJSParitionerAccess().getJs_partitionerKeyword_0_1()));
		match_JavaLikeParitioner_JavaLikePartitionerKeyword_0_0_or_Java_like_partitionerKeyword_0_1 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getJavaLikeParitionerAccess().getJavaLikePartitionerKeyword_0_0()), new TokenAlias(false, false, grammarAccess.getJavaLikeParitionerAccess().getJava_like_partitionerKeyword_0_1()));
		match_PartitionJSRule_JavascriptRuleKeyword_0_0_or_Javascript_ruleKeyword_0_1 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getPartitionJSRuleAccess().getJavascriptRuleKeyword_0_0()), new TokenAlias(false, false, grammarAccess.getPartitionJSRuleAccess().getJavascript_ruleKeyword_0_1()));
		match_PartitionMultiLineRule_MultiLineKeyword_0_0_or_Multi_lineKeyword_0_1 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getPartitionMultiLineRuleAccess().getMultiLineKeyword_0_0()), new TokenAlias(false, false, grammarAccess.getPartitionMultiLineRuleAccess().getMulti_lineKeyword_0_1()));
		match_PartitionSingleLineRule_SingleLineKeyword_0_0_or_Single_lineKeyword_0_1 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getPartitionSingleLineRuleAccess().getSingleLineKeyword_0_0()), new TokenAlias(false, false, grammarAccess.getPartitionSingleLineRuleAccess().getSingle_lineKeyword_0_1()));
		match_RuleDamager_RuleDamagerKeyword_0_0_or_Rule_damagerKeyword_0_1 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getRuleDamagerAccess().getRuleDamagerKeyword_0_0()), new TokenAlias(false, false, grammarAccess.getRuleDamagerAccess().getRule_damagerKeyword_0_1()));
		match_RulePartitioner_RulePartitionerKeyword_0_0_or_Rule_partitionerKeyword_0_1 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getRulePartitionerAccess().getRulePartitionerKeyword_0_0()), new TokenAlias(false, false, grammarAccess.getRulePartitionerAccess().getRule_partitionerKeyword_0_1()));
		match_ScannerCharacterRule_CharacterRuleKeyword_0_0_or_Character_ruleKeyword_0_1 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getScannerCharacterRuleAccess().getCharacterRuleKeyword_0_0()), new TokenAlias(false, false, grammarAccess.getScannerCharacterRuleAccess().getCharacter_ruleKeyword_0_1()));
		match_ScannerJSRule_JavascriptRuleKeyword_0_0_or_Javascript_ruleKeyword_0_1 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getScannerJSRuleAccess().getJavascriptRuleKeyword_0_0()), new TokenAlias(false, false, grammarAccess.getScannerJSRuleAccess().getJavascript_ruleKeyword_0_1()));
		match_ScannerMultiLineRule_MultiLineKeyword_0_0_or_Multi_lineKeyword_0_1 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getScannerMultiLineRuleAccess().getMultiLineKeyword_0_0()), new TokenAlias(false, false, grammarAccess.getScannerMultiLineRuleAccess().getMulti_lineKeyword_0_1()));
		match_ScannerSingleLineRule_SingleLineKeyword_0_0_or_Single_lineKeyword_0_1 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getScannerSingleLineRuleAccess().getSingleLineKeyword_0_0()), new TokenAlias(false, false, grammarAccess.getScannerSingleLineRuleAccess().getSingle_lineKeyword_0_1()));
		match_ScannerWhitespaceRule_WhitespaceRuleKeyword_0_0_or_Whitespace_ruleKeyword_0_1 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getScannerWhitespaceRuleAccess().getWhitespaceRuleKeyword_0_0()), new TokenAlias(false, false, grammarAccess.getScannerWhitespaceRuleAccess().getWhitespace_ruleKeyword_0_1()));
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		return "";
	}
	
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if(match_JSDamager_JsDamagerKeyword_0_0_or_Js_damagerKeyword_0_1.equals(syntax))
				emit_JSDamager_JsDamagerKeyword_0_0_or_Js_damagerKeyword_0_1(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_JSParitioner_JsPartitionerKeyword_0_0_or_Js_partitionerKeyword_0_1.equals(syntax))
				emit_JSParitioner_JsPartitionerKeyword_0_0_or_Js_partitionerKeyword_0_1(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_JavaLikeParitioner_JavaLikePartitionerKeyword_0_0_or_Java_like_partitionerKeyword_0_1.equals(syntax))
				emit_JavaLikeParitioner_JavaLikePartitionerKeyword_0_0_or_Java_like_partitionerKeyword_0_1(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_PartitionJSRule_JavascriptRuleKeyword_0_0_or_Javascript_ruleKeyword_0_1.equals(syntax))
				emit_PartitionJSRule_JavascriptRuleKeyword_0_0_or_Javascript_ruleKeyword_0_1(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_PartitionMultiLineRule_MultiLineKeyword_0_0_or_Multi_lineKeyword_0_1.equals(syntax))
				emit_PartitionMultiLineRule_MultiLineKeyword_0_0_or_Multi_lineKeyword_0_1(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_PartitionSingleLineRule_SingleLineKeyword_0_0_or_Single_lineKeyword_0_1.equals(syntax))
				emit_PartitionSingleLineRule_SingleLineKeyword_0_0_or_Single_lineKeyword_0_1(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_RuleDamager_RuleDamagerKeyword_0_0_or_Rule_damagerKeyword_0_1.equals(syntax))
				emit_RuleDamager_RuleDamagerKeyword_0_0_or_Rule_damagerKeyword_0_1(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_RulePartitioner_RulePartitionerKeyword_0_0_or_Rule_partitionerKeyword_0_1.equals(syntax))
				emit_RulePartitioner_RulePartitionerKeyword_0_0_or_Rule_partitionerKeyword_0_1(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ScannerCharacterRule_CharacterRuleKeyword_0_0_or_Character_ruleKeyword_0_1.equals(syntax))
				emit_ScannerCharacterRule_CharacterRuleKeyword_0_0_or_Character_ruleKeyword_0_1(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ScannerJSRule_JavascriptRuleKeyword_0_0_or_Javascript_ruleKeyword_0_1.equals(syntax))
				emit_ScannerJSRule_JavascriptRuleKeyword_0_0_or_Javascript_ruleKeyword_0_1(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ScannerMultiLineRule_MultiLineKeyword_0_0_or_Multi_lineKeyword_0_1.equals(syntax))
				emit_ScannerMultiLineRule_MultiLineKeyword_0_0_or_Multi_lineKeyword_0_1(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ScannerSingleLineRule_SingleLineKeyword_0_0_or_Single_lineKeyword_0_1.equals(syntax))
				emit_ScannerSingleLineRule_SingleLineKeyword_0_0_or_Single_lineKeyword_0_1(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ScannerWhitespaceRule_WhitespaceRuleKeyword_0_0_or_Whitespace_ruleKeyword_0_1.equals(syntax))
				emit_ScannerWhitespaceRule_WhitespaceRuleKeyword_0_0_or_Whitespace_ruleKeyword_0_1(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Syntax:
	 *     'js-damager' | 'js_damager'
	 */
	protected void emit_JSDamager_JsDamagerKeyword_0_0_or_Js_damagerKeyword_0_1(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'js-partitioner' | 'js_partitioner'
	 */
	protected void emit_JSParitioner_JsPartitionerKeyword_0_0_or_Js_partitionerKeyword_0_1(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'java-like-partitioner' | 'java_like_partitioner'
	 */
	protected void emit_JavaLikeParitioner_JavaLikePartitionerKeyword_0_0_or_Java_like_partitionerKeyword_0_1(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'javascript-rule' | 'javascript_rule'
	 */
	protected void emit_PartitionJSRule_JavascriptRuleKeyword_0_0_or_Javascript_ruleKeyword_0_1(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'multi-line' | 'multi_line'
	 */
	protected void emit_PartitionMultiLineRule_MultiLineKeyword_0_0_or_Multi_lineKeyword_0_1(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'single-line' | 'single_line'
	 */
	protected void emit_PartitionSingleLineRule_SingleLineKeyword_0_0_or_Single_lineKeyword_0_1(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'rule-damager' | 'rule_damager'
	 */
	protected void emit_RuleDamager_RuleDamagerKeyword_0_0_or_Rule_damagerKeyword_0_1(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'rule-partitioner' | 'rule_partitioner'
	 */
	protected void emit_RulePartitioner_RulePartitionerKeyword_0_0_or_Rule_partitionerKeyword_0_1(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'character-rule' | 'character_rule'
	 */
	protected void emit_ScannerCharacterRule_CharacterRuleKeyword_0_0_or_Character_ruleKeyword_0_1(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'javascript-rule' | 'javascript_rule'
	 */
	protected void emit_ScannerJSRule_JavascriptRuleKeyword_0_0_or_Javascript_ruleKeyword_0_1(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'multi-line' | 'multi_line'
	 */
	protected void emit_ScannerMultiLineRule_MultiLineKeyword_0_0_or_Multi_lineKeyword_0_1(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'single-line' | 'single_line'
	 */
	protected void emit_ScannerSingleLineRule_SingleLineKeyword_0_0_or_Single_lineKeyword_0_1(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'whitespace-rule' | 'whitespace_rule'
	 */
	protected void emit_ScannerWhitespaceRule_WhitespaceRuleKeyword_0_0_or_Whitespace_ruleKeyword_0_1(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
