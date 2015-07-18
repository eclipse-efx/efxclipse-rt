package org.eclipse.fx.code.editor.ldef.generator

import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.fx.code.editor.ldef.lDef.Partitioner_Rule
import org.eclipse.fx.code.editor.ldef.lDef.Partition_SingleLineRule
import org.eclipse.fx.code.editor.ldef.lDef.Partition_MultiLineRule
import org.eclipse.fx.code.editor.ldef.lDef.LexicalPartitionHighlighting_Rule
import org.eclipse.fx.code.editor.ldef.lDef.Scanner_Rule
import org.eclipse.fx.code.editor.ldef.lDef.Scanner_Keyword
import org.eclipse.fx.code.editor.ldef.lDef.Scanner_SingleLineRule
import org.eclipse.fx.code.editor.ldef.lDef.Token
import org.eclipse.fx.code.editor.ldef.lDef.LanguageDef

class JavaFXCodeGenerator {
	def generate(LanguageDef model, String basePackage, IFileSystemAccess access) {

	}

	def generateRulePartitioner(LanguageDef model, String basePackage) '''
	package «basePackage»;

	public class «model.name.toFirstUpper»PartitionScanner() extends org.eclipse.jface.text.rules.RuleBasedPartitionScanner {
		public «model.name.toFirstUpper»PartitionScanner() {
			org.eclipse.jface.text.rules.IPredicateRule[] pr = new org.eclipse.jface.text.rules.IPredicateRule[«(model.paritioning.partitioner as Partitioner_Rule).ruleList.size»];
			«FOR r : (model.paritioning.partitioner as Partitioner_Rule).ruleList.indexed»
				pr[«r.key»] = «generatePartitionRule(r.value)»;
			«ENDFOR»
			setPredicateRules(pr);
		}
	}
	'''

	def generatePresentationReconciler(LanguageDef model, String basePackage) '''
	package «basePackage»;

	public class «model.name.toFirstUpper»PresentationReconciler extends org.eclipse.jface.text.presentation.PresentationReconciler {
		public «model.name.toFirstUpper»PresentationReconciler() {
			«FOR h : model.lexicalHighlighting.list»
				«IF h instanceof LexicalPartitionHighlighting_Rule»
					DefaultDamagerRepairer «h.partition.name»DamageRepairer = new DefaultDamagerRepairer(new «model.name.toFirstUpper»«h.partition.name»());
				«ELSE»
					//FIXME Need to generate JS-Damager
				«ENDIF»
				setDamager(«h.partition.name»DamageRepairer, "«h.partition.name»");
				setRepairer(«h.partition.name»DamageRepairer, "«h.partition.name»");
			«ENDFOR»
		}
	}
	'''

	def generateScanner(LanguageDef model, LexicalPartitionHighlighting_Rule highlighter, String basePackage) '''
	package «basePackage»;

	public class «model.name.toFirstUpper»«highlighter.partition.name» extends org.eclipse.jface.text.rules.RuleBasedScanner {
		«FOR t : highlighter.tokenList»
			org.eclipse.jface.text.rules.Token «t.name»Token = new org.eclipse.jface.text.rules.Token(new org.eclipse.jface.text.TextAttribute("«t.name»"));
			«IF t.isDefault»
				setDefaultReturnToken(«t.name»Token);
			«ENDIF»
		«ENDFOR»
		org.eclipse.jface.text.rules.IRule[] rules = new org.eclipse.jface.text.rules.IRule[«addKeywordGroup(countRules(highlighter), highlighter)»];
		«FOR t : highlighter.tokenList.filter[ s | s instanceof Scanner_Rule ].indexed»
			rules[«t.key»] =
		«ENDFOR»
	}
	'''

	def static addKeywordGroup(int count, LexicalPartitionHighlighting_Rule highlighter) {
		for( t : highlighter.tokenList ) {
			if( t.scannerList.filter([ s | s instanceof Scanner_Keyword ]).head != null ) {
				return count + 1;
			}
		}
		return count;
	}

	def static countRules(LexicalPartitionHighlighting_Rule highlighter) {
		var c = 0
		for( t : highlighter.tokenList ) {
			c += t.scannerList.filter([ s | s instanceof Scanner_Rule ]).length
		}
		return c
	}

	def dispatch generateScannerRule(Token t, Scanner_SingleLineRule r) '''
	new org.eclipse.jface.text.rules.SingleLineRule(
		"«r.startSeq»"
		, "«r.endSeq»"
		, «t.name»Token
		«IF r.escapeSeq != null», '«r.escapeSeq.charAt(0)»'«ENDIF»)
	'''

	def dispatch generatePartitionRule(Partition_SingleLineRule r) '''
	new org.eclipse.jface.text.rules.SingleLineRule(
		"«r.startSeq»"
		, "«r.endSeq»"
		, new org.eclipse.jface.text.rules.Token("«r.parition.name»")
		«IF r.escapeSeq != null», '«r.escapeSeq.charAt(0)»'«ENDIF»)
	'''

	def dispatch generatePartitionRule(Partition_MultiLineRule r) '''
	new org.eclipse.jface.text.rules.MultiLineRule(
		"«r.startSeq»"
		, "«r.endSeq»"
		, new org.eclipse.jface.text.rules.Token("«r.parition.name»")
		«IF r.escapeSeq != null», '«r.escapeSeq.charAt(0)»'«ENDIF»)
	'''
}