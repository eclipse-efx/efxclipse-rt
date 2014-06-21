package org.eclipse.fx.code.compensator.hsl.serializer;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.fx.code.compensator.hsl.services.HSLGrammarAccess;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.GroupAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;

@SuppressWarnings("all")
public class HSLSyntacticSequencer extends AbstractSyntacticSequencer {

	protected HSLGrammarAccess grammarAccess;
	protected AbstractElementAlias match_ScannerToken___LeftCurlyBracketKeyword_3_0_RightCurlyBracketKeyword_3_4__q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (HSLGrammarAccess) access;
		match_ScannerToken___LeftCurlyBracketKeyword_3_0_RightCurlyBracketKeyword_3_4__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getScannerTokenAccess().getLeftCurlyBracketKeyword_3_0()), new TokenAlias(false, false, grammarAccess.getScannerTokenAccess().getRightCurlyBracketKeyword_3_4()));
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
			if(match_ScannerToken___LeftCurlyBracketKeyword_3_0_RightCurlyBracketKeyword_3_4__q.equals(syntax))
				emit_ScannerToken___LeftCurlyBracketKeyword_3_0_RightCurlyBracketKeyword_3_4__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Syntax:
	 *     ('{' '}')?
	 */
	protected void emit_ScannerToken___LeftCurlyBracketKeyword_3_0_RightCurlyBracketKeyword_3_4__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
