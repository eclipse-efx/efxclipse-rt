package org.eclipse.fx.code.compensator.hsl.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.fx.code.compensator.hsl.hSL.Font;
import org.eclipse.fx.code.compensator.hsl.hSL.HSLPackage;
import org.eclipse.fx.code.compensator.hsl.hSL.JSDamager;
import org.eclipse.fx.code.compensator.hsl.hSL.JSParitioner;
import org.eclipse.fx.code.compensator.hsl.hSL.JavaLikeParitioner;
import org.eclipse.fx.code.compensator.hsl.hSL.Keyword;
import org.eclipse.fx.code.compensator.hsl.hSL.KeywordGroup;
import org.eclipse.fx.code.compensator.hsl.hSL.Model;
import org.eclipse.fx.code.compensator.hsl.hSL.Partition;
import org.eclipse.fx.code.compensator.hsl.hSL.PartitionJSRule;
import org.eclipse.fx.code.compensator.hsl.hSL.PartitionMultiLineRule;
import org.eclipse.fx.code.compensator.hsl.hSL.PartitionSingleLineRule;
import org.eclipse.fx.code.compensator.hsl.hSL.RGBColor;
import org.eclipse.fx.code.compensator.hsl.hSL.RuleDamager;
import org.eclipse.fx.code.compensator.hsl.hSL.RulePartitioner;
import org.eclipse.fx.code.compensator.hsl.hSL.ScannerCharacterRule;
import org.eclipse.fx.code.compensator.hsl.hSL.ScannerJSRule;
import org.eclipse.fx.code.compensator.hsl.hSL.ScannerMultiLineRule;
import org.eclipse.fx.code.compensator.hsl.hSL.ScannerSingleLineRule;
import org.eclipse.fx.code.compensator.hsl.hSL.ScannerToken;
import org.eclipse.fx.code.compensator.hsl.hSL.ScannerWhitespaceRule;
import org.eclipse.fx.code.compensator.hsl.services.HSLGrammarAccess;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public class HSLSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private HSLGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == HSLPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case HSLPackage.FONT:
				if(context == grammarAccess.getFontRule()) {
					sequence_Font(context, (Font) semanticObject); 
					return; 
				}
				else break;
			case HSLPackage.JS_DAMAGER:
				if(context == grammarAccess.getDamagerRule() ||
				   context == grammarAccess.getJSDamagerRule()) {
					sequence_JSDamager(context, (JSDamager) semanticObject); 
					return; 
				}
				else break;
			case HSLPackage.JS_PARITIONER:
				if(context == grammarAccess.getJSParitionerRule() ||
				   context == grammarAccess.getPartitionerRule()) {
					sequence_JSParitioner(context, (JSParitioner) semanticObject); 
					return; 
				}
				else break;
			case HSLPackage.JAVA_LIKE_PARITIONER:
				if(context == grammarAccess.getJavaLikeParitionerRule() ||
				   context == grammarAccess.getPartitionerRule()) {
					sequence_JavaLikeParitioner(context, (JavaLikeParitioner) semanticObject); 
					return; 
				}
				else break;
			case HSLPackage.KEYWORD:
				if(context == grammarAccess.getKeywordRule()) {
					sequence_Keyword(context, (Keyword) semanticObject); 
					return; 
				}
				else break;
			case HSLPackage.KEYWORD_GROUP:
				if(context == grammarAccess.getKeywordGroupRule()) {
					sequence_KeywordGroup(context, (KeywordGroup) semanticObject); 
					return; 
				}
				else break;
			case HSLPackage.MODEL:
				if(context == grammarAccess.getModelRule()) {
					sequence_Model(context, (Model) semanticObject); 
					return; 
				}
				else break;
			case HSLPackage.PARTITION:
				if(context == grammarAccess.getPartitionRule()) {
					sequence_Partition(context, (Partition) semanticObject); 
					return; 
				}
				else break;
			case HSLPackage.PARTITION_JS_RULE:
				if(context == grammarAccess.getParitionRuleRule() ||
				   context == grammarAccess.getPartitionJSRuleRule()) {
					sequence_PartitionJSRule(context, (PartitionJSRule) semanticObject); 
					return; 
				}
				else break;
			case HSLPackage.PARTITION_MULTI_LINE_RULE:
				if(context == grammarAccess.getParitionRuleRule() ||
				   context == grammarAccess.getPartitionMultiLineRuleRule()) {
					sequence_PartitionMultiLineRule(context, (PartitionMultiLineRule) semanticObject); 
					return; 
				}
				else break;
			case HSLPackage.PARTITION_SINGLE_LINE_RULE:
				if(context == grammarAccess.getParitionRuleRule() ||
				   context == grammarAccess.getPartitionSingleLineRuleRule()) {
					sequence_PartitionSingleLineRule(context, (PartitionSingleLineRule) semanticObject); 
					return; 
				}
				else break;
			case HSLPackage.RGB_COLOR:
				if(context == grammarAccess.getColorRule() ||
				   context == grammarAccess.getRGBColorRule()) {
					sequence_RGBColor(context, (RGBColor) semanticObject); 
					return; 
				}
				else break;
			case HSLPackage.RULE_DAMAGER:
				if(context == grammarAccess.getDamagerRule() ||
				   context == grammarAccess.getRuleDamagerRule()) {
					sequence_RuleDamager(context, (RuleDamager) semanticObject); 
					return; 
				}
				else break;
			case HSLPackage.RULE_PARTITIONER:
				if(context == grammarAccess.getPartitionerRule() ||
				   context == grammarAccess.getRulePartitionerRule()) {
					sequence_RulePartitioner(context, (RulePartitioner) semanticObject); 
					return; 
				}
				else break;
			case HSLPackage.SCANNER_CHARACTER_RULE:
				if(context == grammarAccess.getScannerCharacterRuleRule() ||
				   context == grammarAccess.getScannerRuleRule()) {
					sequence_ScannerCharacterRule(context, (ScannerCharacterRule) semanticObject); 
					return; 
				}
				else break;
			case HSLPackage.SCANNER_JS_RULE:
				if(context == grammarAccess.getScannerJSRuleRule() ||
				   context == grammarAccess.getScannerRuleRule()) {
					sequence_ScannerJSRule(context, (ScannerJSRule) semanticObject); 
					return; 
				}
				else break;
			case HSLPackage.SCANNER_MULTI_LINE_RULE:
				if(context == grammarAccess.getScannerMultiLineRuleRule() ||
				   context == grammarAccess.getScannerRuleRule()) {
					sequence_ScannerMultiLineRule(context, (ScannerMultiLineRule) semanticObject); 
					return; 
				}
				else break;
			case HSLPackage.SCANNER_SINGLE_LINE_RULE:
				if(context == grammarAccess.getScannerRuleRule() ||
				   context == grammarAccess.getScannerSingleLineRuleRule()) {
					sequence_ScannerSingleLineRule(context, (ScannerSingleLineRule) semanticObject); 
					return; 
				}
				else break;
			case HSLPackage.SCANNER_TOKEN:
				if(context == grammarAccess.getScannerTokenRule()) {
					sequence_ScannerToken(context, (ScannerToken) semanticObject); 
					return; 
				}
				else break;
			case HSLPackage.SCANNER_WHITESPACE_RULE:
				if(context == grammarAccess.getScannerRuleRule() ||
				   context == grammarAccess.getScannerWhitespaceRuleRule()) {
					sequence_ScannerWhitespaceRule(context, (ScannerWhitespaceRule) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (name=ID size=INT attributes+=FontType*)
	 */
	protected void sequence_Font(EObject context, Font semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (partition=[Partition|ID] fileURI=STRING)
	 */
	protected void sequence_JSDamager(EObject context, JSDamager semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, HSLPackage.Literals.DAMAGER__PARTITION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, HSLPackage.Literals.DAMAGER__PARTITION));
			if(transientValues.isValueTransient(semanticObject, HSLPackage.Literals.JS_DAMAGER__FILE_URI) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, HSLPackage.Literals.JS_DAMAGER__FILE_URI));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getJSDamagerAccess().getPartitionPartitionIDTerminalRuleCall_1_0_1(), semanticObject.getPartition());
		feeder.accept(grammarAccess.getJSDamagerAccess().getFileURISTRINGTerminalRuleCall_2_0(), semanticObject.getFileURI());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     fileURI=STRING
	 */
	protected void sequence_JSParitioner(EObject context, JSParitioner semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, HSLPackage.Literals.JS_PARITIONER__FILE_URI) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, HSLPackage.Literals.JS_PARITIONER__FILE_URI));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getJSParitionerAccess().getFileURISTRINGTerminalRuleCall_1_0(), semanticObject.getFileURI());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         singleLineParition=[Partition|ID] 
	 *         multiLineParition=[Partition|ID] 
	 *         javaDocParition=[Partition|ID] 
	 *         characterParition=[Partition|ID] 
	 *         stringParition=[Partition|ID]
	 *     )
	 */
	protected void sequence_JavaLikeParitioner(EObject context, JavaLikeParitioner semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, HSLPackage.Literals.JAVA_LIKE_PARITIONER__SINGLE_LINE_PARITION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, HSLPackage.Literals.JAVA_LIKE_PARITIONER__SINGLE_LINE_PARITION));
			if(transientValues.isValueTransient(semanticObject, HSLPackage.Literals.JAVA_LIKE_PARITIONER__MULTI_LINE_PARITION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, HSLPackage.Literals.JAVA_LIKE_PARITIONER__MULTI_LINE_PARITION));
			if(transientValues.isValueTransient(semanticObject, HSLPackage.Literals.JAVA_LIKE_PARITIONER__JAVA_DOC_PARITION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, HSLPackage.Literals.JAVA_LIKE_PARITIONER__JAVA_DOC_PARITION));
			if(transientValues.isValueTransient(semanticObject, HSLPackage.Literals.JAVA_LIKE_PARITIONER__CHARACTER_PARITION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, HSLPackage.Literals.JAVA_LIKE_PARITIONER__CHARACTER_PARITION));
			if(transientValues.isValueTransient(semanticObject, HSLPackage.Literals.JAVA_LIKE_PARITIONER__STRING_PARITION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, HSLPackage.Literals.JAVA_LIKE_PARITIONER__STRING_PARITION));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getJavaLikeParitionerAccess().getSingleLineParitionPartitionIDTerminalRuleCall_2_0_1(), semanticObject.getSingleLineParition());
		feeder.accept(grammarAccess.getJavaLikeParitionerAccess().getMultiLineParitionPartitionIDTerminalRuleCall_3_0_1(), semanticObject.getMultiLineParition());
		feeder.accept(grammarAccess.getJavaLikeParitionerAccess().getJavaDocParitionPartitionIDTerminalRuleCall_4_0_1(), semanticObject.getJavaDocParition());
		feeder.accept(grammarAccess.getJavaLikeParitionerAccess().getCharacterParitionPartitionIDTerminalRuleCall_5_0_1(), semanticObject.getCharacterParition());
		feeder.accept(grammarAccess.getJavaLikeParitionerAccess().getStringParitionPartitionIDTerminalRuleCall_6_0_1(), semanticObject.getStringParition());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (token=[ScannerToken|ID] keywords+=Keyword keywords+=Keyword*)
	 */
	protected void sequence_KeywordGroup(EObject context, KeywordGroup semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=STRING version=STRING?)
	 */
	protected void sequence_Keyword(EObject context, Keyword semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID partitions+=Partition+ damagers+=Damager+ partitioner=Partitioner contentTypes+=STRING+)
	 */
	protected void sequence_Model(EObject context, Model semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (token=[Partition|ID] fileURI=STRING)
	 */
	protected void sequence_PartitionJSRule(EObject context, PartitionJSRule semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, HSLPackage.Literals.PARTITION_JS_RULE__TOKEN) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, HSLPackage.Literals.PARTITION_JS_RULE__TOKEN));
			if(transientValues.isValueTransient(semanticObject, HSLPackage.Literals.PARTITION_JS_RULE__FILE_URI) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, HSLPackage.Literals.PARTITION_JS_RULE__FILE_URI));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getPartitionJSRuleAccess().getTokenPartitionIDTerminalRuleCall_1_0_1(), semanticObject.getToken());
		feeder.accept(grammarAccess.getPartitionJSRuleAccess().getFileURISTRINGTerminalRuleCall_2_0(), semanticObject.getFileURI());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (parition=[Partition|ID] startSeq=STRING endSeq=STRING escapeSeq=STRING?)
	 */
	protected void sequence_PartitionMultiLineRule(EObject context, PartitionMultiLineRule semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (parition=[Partition|ID] startSeq=STRING endSeq=STRING escapeSeq=STRING?)
	 */
	protected void sequence_PartitionSingleLineRule(EObject context, PartitionSingleLineRule semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_Partition(EObject context, Partition semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, HSLPackage.Literals.PARTITION__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, HSLPackage.Literals.PARTITION__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getPartitionAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (r=INT g=INT b=INT)
	 */
	protected void sequence_RGBColor(EObject context, RGBColor semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, HSLPackage.Literals.RGB_COLOR__R) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, HSLPackage.Literals.RGB_COLOR__R));
			if(transientValues.isValueTransient(semanticObject, HSLPackage.Literals.RGB_COLOR__G) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, HSLPackage.Literals.RGB_COLOR__G));
			if(transientValues.isValueTransient(semanticObject, HSLPackage.Literals.RGB_COLOR__B) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, HSLPackage.Literals.RGB_COLOR__B));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getRGBColorAccess().getRINTTerminalRuleCall_2_0(), semanticObject.getR());
		feeder.accept(grammarAccess.getRGBColorAccess().getGINTTerminalRuleCall_4_0(), semanticObject.getG());
		feeder.accept(grammarAccess.getRGBColorAccess().getBINTTerminalRuleCall_6_0(), semanticObject.getB());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (partition=[Partition|ID] tokens+=ScannerToken* keywordGroups+=KeywordGroup* rules+=ScannerRule+)
	 */
	protected void sequence_RuleDamager(EObject context, RuleDamager semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     rules+=ParitionRule+
	 */
	protected void sequence_RulePartitioner(EObject context, RulePartitioner semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (token=[ScannerToken|ID] characters+=STRING characters+=STRING)
	 */
	protected void sequence_ScannerCharacterRule(EObject context, ScannerCharacterRule semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (token=[ScannerToken|ID] fileURI=STRING)
	 */
	protected void sequence_ScannerJSRule(EObject context, ScannerJSRule semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, HSLPackage.Literals.SCANNER_RULE__TOKEN) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, HSLPackage.Literals.SCANNER_RULE__TOKEN));
			if(transientValues.isValueTransient(semanticObject, HSLPackage.Literals.SCANNER_JS_RULE__FILE_URI) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, HSLPackage.Literals.SCANNER_JS_RULE__FILE_URI));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getScannerJSRuleAccess().getTokenScannerTokenIDTerminalRuleCall_1_0_1(), semanticObject.getToken());
		feeder.accept(grammarAccess.getScannerJSRuleAccess().getFileURISTRINGTerminalRuleCall_2_0(), semanticObject.getFileURI());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (token=[ScannerToken|ID] startSeq=STRING endSeq=STRING escapeSeq=STRING?)
	 */
	protected void sequence_ScannerMultiLineRule(EObject context, ScannerMultiLineRule semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (token=[ScannerToken|ID] startSeq=STRING endSeq=STRING escapeSeq=STRING?)
	 */
	protected void sequence_ScannerSingleLineRule(EObject context, ScannerSingleLineRule semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (default?='default'? name=ID (fgColor=Color? bgColor=Color? font=Font?)?)
	 */
	protected void sequence_ScannerToken(EObject context, ScannerToken semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((token=[ScannerToken|ID]? characters+=STRING characters+=STRING*) | jsDetector=ANY_OTHER)
	 */
	protected void sequence_ScannerWhitespaceRule(EObject context, ScannerWhitespaceRule semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
