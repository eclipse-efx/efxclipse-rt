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
import org.eclipse.fx.code.editor.ldef.lDef.Scanner_MultiLineRule
import org.eclipse.fx.code.editor.ldef.lDef.Scanner_CharacterRule
import org.eclipse.fx.code.editor.ldef.lDef.WhitespaceRule

class JavaFXCodeGenerator {
	def generate(LanguageDef model, String basePackage, IFileSystemAccess access) {
		access.generateFile(basePackage.replace(".","/")+"/"+model.name.toFirstUpper+"PartitionScanner.java",generateRulePartitioner(model,basePackage))
		access.generateFile(basePackage.replace(".","/")+"/"+model.name.toFirstUpper+"Partitioner.java",generatePartitioner(model,basePackage))

		access.generateFile(basePackage.replace(".","/")+"/"+model.name.toFirstUpper+"PresentationReconciler.java",generatePresentationReconciler(model,basePackage))
		for( h : model.lexicalHighlighting.list ) {
			if( h instanceof LexicalPartitionHighlighting_Rule ) {
				access.generateFile(basePackage.replace(".","/")+"/"+model.name.toFirstUpper+h.partition.name+".java",generateScanner(model,h,basePackage))
			}
		}
	}

	def generatePartitioner(LanguageDef model, String basePackage) '''
	package «basePackage»;

	public class «model.name.toFirstUpper»Partitioner extends org.eclipse.jface.text.rules.FastPartitioner {
		public «model.name.toFirstUpper»Partitioner() {
			super(new «model.name.toFirstUpper»PartitionScanner(), new String[] {
				«model.paritioning.partitions.map[name].filter[! it.equals("__dftl_partition_content_type")].map['"'+it+'"'].join(",")»
			});
		}
	}
	'''

	def generateRulePartitioner(LanguageDef model, String basePackage) '''
	package «basePackage»;

	public class «model.name.toFirstUpper»PartitionScanner extends org.eclipse.jface.text.rules.RuleBasedPartitionScanner {
		public «model.name.toFirstUpper»PartitionScanner() {
			org.eclipse.jface.text.rules.IPredicateRule[] pr = new org.eclipse.jface.text.rules.IPredicateRule[«(model.paritioning.partitioner as Partitioner_Rule).ruleList.size»];
			«FOR r : (model.paritioning.partitioner as Partitioner_Rule).ruleList.indexed»
				pr[«r.key»] = «generatePartitionRule(r.value)»
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
					org.eclipse.jface.text.rules.DefaultDamagerRepairer «h.partition.name»DamageRepairer = new org.eclipse.jface.text.rules.DefaultDamagerRepairer(new «model.name.toFirstUpper»«h.partition.name»());
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
		public «model.name.toFirstUpper»«highlighter.partition.name»() {
			«FOR t : highlighter.tokenList»
				org.eclipse.jface.text.rules.Token «t.name»Token = new org.eclipse.jface.text.rules.Token(new org.eclipse.jface.text.TextAttribute("«model.name».«t.name»"));
				«IF t.isDefault»
					setDefaultReturnToken(«t.name»Token);
				«ENDIF»
			«ENDFOR»
			org.eclipse.jface.text.rules.IRule[] rules = new org.eclipse.jface.text.rules.IRule[«addWhitespaceRule(addKeywordGroup(countRules(highlighter), highlighter), highlighter.whitespace)»];
			«var count = 0»
			«FOR t : highlighter.tokenList»
				«FOR s : t.scannerList.filter[ s | s instanceof Scanner_Rule ]»
					rules[«count++»] = «generateScannerRule(t,s as Scanner_Rule)»
				«ENDFOR»
			«ENDFOR»
			«IF highlighter.whitespace != null»
			rules[«count++»] = «generateWhitespaceRule(highlighter.whitespace)»
			«ENDIF»

			«IF hasKeywordGroup(highlighter)»
			org.eclipse.jface.text.source.JavaLikeWordDetector wordDetector= new org.eclipse.jface.text.source.JavaLikeWordDetector();
			org.eclipse.jface.text.rules.CombinedWordRule combinedWordRule= new org.eclipse.jface.text.rules.CombinedWordRule(wordDetector, «highlighter.tokenList.findFirst[t|t.^default].name»Token);
			«FOR t : highlighter.tokenList»
				«FOR kw : t.scannerList.filter[s | s instanceof Scanner_Keyword]»
					org.eclipse.jface.text.rules.CombinedWordRule.WordMatcher «t.name»WordRule = new org.eclipse.jface.text.rules.CombinedWordRule.WordMatcher();
					«FOR w : (kw as Scanner_Keyword).keywords»
					«t.name»WordRule.addWord("«w.name»", «t.name»Token);
					«ENDFOR»
					combinedWordRule.addWordMatcher(«t.name»WordRule);
				«ENDFOR»
			«ENDFOR»
			rules[«count++»] = combinedWordRule;
			«ENDIF»
			setRules(rules);
		}
	}
	'''

	def static hasKeywordGroup(LexicalPartitionHighlighting_Rule highlighter) {
		for( t : highlighter.tokenList ) {
			if( t.scannerList.filter([ s | s instanceof Scanner_Keyword ]).head != null ) {
				return true;
			}
		}
		return false;
	}

	def static addKeywordGroup(int count, LexicalPartitionHighlighting_Rule highlighter) {
		for( t : highlighter.tokenList ) {
			if( t.scannerList.filter([ s | s instanceof Scanner_Keyword ]).head != null ) {
				return count + 1;
			}
		}
		return count;
	}

	def static addWhitespaceRule(int count, WhitespaceRule r) {
		if( r != null ) {
			return count + 1;
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
		  "«r.startSeq.escapeString»"
		, "«r.endSeq.escapeString»"
		, «t.name»Token
		«IF r.escapeSeq != null», '«r.escapeSeq.charAt(0)»'«ENDIF»);
	'''

	def dispatch generateScannerRule(Token t, Scanner_MultiLineRule r) '''
	new org.eclipse.jface.text.rules.MultiLineRule(
		  "«r.startSeq.escapeString»"
		, "«r.endSeq.escapeString»"
		, «t.name»Token
		«IF r.escapeSeq != null», '«r.escapeSeq.charAt(0)»'«ENDIF»);
	'''

	def generateWhitespaceRule(WhitespaceRule r) '''
	«IF r.isJavawhitespace»
	new org.eclipse.jface.text.rules.WhitespaceRule(Character::isWhitespace);
	«ELSE»
	new org.eclipse.jface.text.rules.WhitespaceRule(new org.eclipse.jface.text.rules.FixedCharacterWSDetector(new char[] {«r.characters.map["'"+it.escapeChar+"'"].join(",")»}));
	«ENDIF»
	'''

	def dispatch generateScannerRule(Token t, Scanner_CharacterRule r) '''
	new org.eclipse.jface.text.source.CharacterRule(«t.name»Token, new char[] {«r.characters.map["'"+it.escapeChar+"'"].join(",")»});
	'''

	def dispatch generatePartitionRule(Partition_SingleLineRule r) '''
	new org.eclipse.jface.text.rules.SingleLineRule(
		  "«r.startSeq.escapeString»"
		, "«r.endSeq.escapeString»"
		, new org.eclipse.jface.text.rules.Token("«r.parition.name»")
		«IF r.escapeSeq != null», '«r.escapeSeq.charAt(0)»'«ENDIF»);
	'''

	def dispatch generatePartitionRule(Partition_MultiLineRule r) '''
	new org.eclipse.jface.text.rules.MultiLineRule(
		  "«r.startSeq.escapeString»"
		, "«r.endSeq.escapeString»"
		, new org.eclipse.jface.text.rules.Token("«r.parition.name»")
		«IF r.escapeSeq != null», '«r.escapeSeq.charAt(0)»'«ENDIF»);
	'''

	def static escapeString(String data) {
		return data.replaceAll('"','\\\\"');
	}

	def static escapeChar(String data) {
		if( data == "\\" ) {
			return "\\\\"
		} else if( data == "'" ) {
			return "\\'"
		}
		return data
	}
}