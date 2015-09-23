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
import org.eclipse.fx.code.editor.ldef.lDef.JavaFXIntegration
import org.eclipse.fx.code.editor.ldef.lDef.JavaCodeGeneration
import org.eclipse.fx.code.editor.ldef.lDef.E4CodeGeneration
import org.eclipse.fx.code.editor.ldef.lDef.Scanner_PatternRule
import org.eclipse.fx.code.editor.ldef.lDef.Codegeneration
import org.eclipse.fx.code.editor.ldef.lDef.Range
import org.eclipse.fx.code.editor.ldef.lDef.Equals

class JavaFXCodeGenerator {
	def generate(LanguageDef model, IFileSystemAccess access) {
		val javaFXIntegration = model.integration.codeIntegrationList.filter(typeof(JavaFXIntegration)).head
		if( javaFXIntegration != null ) {
			val javaCodeGen = javaFXIntegration.codegenerationList.filter(typeof(JavaCodeGeneration)).head
			if( javaCodeGen != null ) {
				val project = javaCodeGen.findProjectResource()
				val prefix = if( project == null ) "" else "/"+project+"/src/";
				val basePackage = javaCodeGen.name;
				access.generateFile(prefix + basePackage.replace(".","/")+"/"+model.name.toFirstUpper+"PartitionScanner.java",generateRulePartitioner(model,basePackage))
				access.generateFile(prefix + basePackage.replace(".","/")+"/"+model.name.toFirstUpper+"Partitioner.java",generatePartitioner(model,basePackage))

				access.generateFile(prefix + basePackage.replace(".","/")+"/"+model.name.toFirstUpper+"PresentationReconciler.java",generatePresentationReconciler(model,basePackage))
				for( h : model.lexicalHighlighting.list ) {
					if( h instanceof LexicalPartitionHighlighting_Rule ) {
						access.generateFile(prefix + basePackage.replace(".","/")+"/"+model.name.toFirstUpper+h.partition.name+".java",generateScanner(model,h,basePackage))
					}
				}
			}

			val e4CodeGen = javaFXIntegration.codegenerationList.filter(typeof(E4CodeGeneration)).head
			if( e4CodeGen != null ) {
				if( javaCodeGen != null ) {
					val basePackage = e4CodeGen.name
					val javaBasePackage = javaCodeGen.name
					val project = e4CodeGen.findProjectResource()
					val prefix = if( project == null ) "" else "/"+project+"/src/";

					access.generateFile(prefix + basePackage.replace(".","/")+"/"+model.name.toFirstUpper+"DocumentPartitionerTypeProvider.java",generateDocumentPartitionerTypeProvider(model,basePackage,javaBasePackage))
					access.generateFile(prefix + basePackage.replace(".","/")+"/"+model.name.toFirstUpper+"PresentationReconcilerTypeProvider.java",generatePresentationReconcilerTypeProvider(model,basePackage,javaBasePackage))
				} else {
					// TODO need to generate LDef model integration
				}
			}
		}
	}

	def findProjectResource(Codegeneration codeGen) {
		return codeGen.configValue.findFirst[key == "project"]?.simpleValue
	}

	def generateDocumentPartitionerTypeProvider(LanguageDef model, String basePackage, String javaBasePackage) '''
	package «basePackage»;

	@org.osgi.service.component.annotations.Component
	public class «model.name.toFirstUpper»DocumentPartitionerTypeProvider implements org.eclipse.fx.code.editor.services.DocumentPartitionerTypeProvider {
		@Override
		public Class<? extends org.eclipse.jface.text.IDocumentPartitioner> getType(org.eclipse.fx.code.editor.Input<?> s) {
			return «javaBasePackage».«model.name.toFirstUpper»Partitioner.class;
		}

		public boolean test(org.eclipse.fx.code.editor.Input<?> t) {
			return (t instanceof org.eclipse.fx.code.editor.services.URIProvider) && ((org.eclipse.fx.code.editor.services.URIProvider)t).getURI().lastSegment().endsWith(".«model.name»");
		}
	}
	'''

	def generatePresentationReconcilerTypeProvider(LanguageDef model, String basePackage, String javaBasePackage) '''
	package «basePackage»;

	@org.osgi.service.component.annotations.Component
	public class «model.name.toFirstUpper»PresentationReconcilerTypeProvider implements org.eclipse.fx.code.editor.fx.services.PresentationReconcilerTypeProvider {

		@Override
		public Class<? extends org.eclipse.jface.text.presentation.PresentationReconciler> getType(org.eclipse.fx.code.editor.Input<?> s) {
			return «javaBasePackage».«model.name.toFirstUpper»PresentationReconciler.class;
		}

		@Override
		public boolean test(org.eclipse.fx.code.editor.Input<?> t) {
			return (t instanceof org.eclipse.fx.code.editor.services.URIProvider) && ((org.eclipse.fx.code.editor.services.URIProvider)t).getURI().lastSegment().endsWith(".dart");
		}
	}
	'''

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
				{
					org.eclipse.jface.text.rules.CombinedWordRule.WordMatcher «t.name»WordRule = new org.eclipse.jface.text.rules.CombinedWordRule.WordMatcher();
					«FOR w : (kw as Scanner_Keyword).keywords»
					«t.name»WordRule.addWord("«w.name»", «t.name»Token);
					«ENDFOR»
					combinedWordRule.addWordMatcher(«t.name»WordRule);
				}
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
	«IF r.check != null»new org.eclipse.fx.text.PredicateColumnStartRule(«ENDIF»new org.eclipse.jface.text.rules.SingleLineRule(
		  "«r.startSeq.escapeString»"
		, «IF r.endSeq != null»"«r.endSeq.escapeString»"«ELSE»null«ENDIF»
		, «t.name»Token
		, «IF r.escapeSeq != null»'«r.escapeSeq.escapeChar»'«ELSE»(char)0«ENDIF»
		, «IF r.endSeq == null || r.endSeq.isEmpty»true«ELSE»false«ENDIF»)«IF r.check != null»,«r.check.toPredicate»)«ENDIF»;
	'''

	def dispatch generateScannerRule(Token t, Scanner_MultiLineRule r) '''
	«IF r.check != null»new org.eclipse.fx.text.PredicateColumnStartRule(«ENDIF»new org.eclipse.jface.text.rules.MultiLineRule(
		  "«r.startSeq.escapeString»"
		, "«r.endSeq.escapeString»"
		, «t.name»Token
		, «IF r.escapeSeq != null»'«r.escapeSeq.escapeChar»'«ELSE»(char)0«ENDIF»
		, «IF r.endSeq == null || r.endSeq.isEmpty»true«ELSE»false«ENDIF»)«IF r.check != null»,«r.check.toPredicate»)«ENDIF»;
	'''

	def generateWhitespaceRule(WhitespaceRule r) '''
	«IF r.isJavawhitespace»
	new org.eclipse.jface.text.rules.WhitespaceRule(Character::isWhitespace);
	«ELSE»
	new org.eclipse.jface.text.rules.WhitespaceRule(new org.eclipse.jface.text.rules.FixedCharacterWSDetector(new char[] {«r.characters.map["'"+it.escapeChar+"'"].join(",")»}));
	«ENDIF»
	'''

	def dispatch generateScannerRule(Token t, Scanner_CharacterRule r) '''
	«IF r.check != null»new org.eclipse.fx.text.PredicateColumnStartRule(«ENDIF»new org.eclipse.jface.text.source.CharacterRule(«t.name»Token, new char[] {«r.characters.map["'"+it.escapeChar+"'"].join(",")»})«IF r.check != null»,«r.check.toPredicate»)«ENDIF»;
	'''

	def dispatch generateScannerRule(Token t, Scanner_PatternRule r) '''
	«IF r.check != null»new org.eclipse.fx.text.PredicateColumnStartRule(«ENDIF»new org.eclipse.fx.text.RegexRule(«t.name»Token, java.util.regex.Pattern.compile("«r.startPattern.replace('\\','\\\\')»"),«Math.max(1,r.length)»,java.util.regex.Pattern.compile("«r.contentPattern.replace('\\','\\\\')»"))«IF r.check != null»,«r.check.toPredicate»)«ENDIF»;
	'''

	def dispatch generatePartitionRule(Partition_SingleLineRule r) '''
	«IF r.check != null»new org.eclipse.fx.text.PredicateColumnStartRule(«ENDIF»new org.eclipse.jface.text.rules.SingleLineRule(
		  "«r.startSeq.escapeString»"
		, «IF r.endSeq != null»"«r.endSeq.escapeString»"«ELSE»null«ENDIF»
		, new org.eclipse.jface.text.rules.Token("«r.parition.name»")
		, «IF r.escapeSeq != null»'«r.escapeSeq.escapeChar»'«ELSE»(char)0«ENDIF»
		, «IF r.endSeq == null || r.endSeq.isEmpty»true«ELSE»false«ENDIF»)«IF r.check != null»,«r.check.toPredicate»)«ENDIF»;
	'''

	def dispatch generatePartitionRule(Partition_MultiLineRule r) '''
	«IF r.check != null»new org.eclipse.fx.text.PredicateColumnStartRule(«ENDIF»new org.eclipse.jface.text.rules.MultiLineRule(
		  "«r.startSeq.escapeString»"
		, "«r.endSeq.escapeString»"
		, new org.eclipse.jface.text.rules.Token("«r.parition.name»")
		, «IF r.escapeSeq != null»'«r.escapeSeq.escapeChar»'«ELSE»(char)0«ENDIF»
		, «IF r.endSeq == null || r.endSeq.isEmpty»true«ELSE»false«ENDIF»)«IF r.check != null»,«r.check.toPredicate»)«ENDIF»;
	'''

	def dispatch static toPredicate(Equals range) '''
	v -> v == «range.value»
	'''

	def dispatch static toPredicate(Range range) '''
	«IF range.minValue.size == 1 && range.maxValue.size == 1»
	v -> «range.minValue.head» «range.ltIncl.toLtOperator» v && v «range.gtIncl.toLtOperator» «range.maxValue.head»
	«ELSEIF range.minValue.size == 1»
	v -> «range.minValue.head» «range.ltIncl.toLtOperator» v
	«ELSEIF range.maxValue.size == 1»
	v -> v «range.gtIncl.toLtOperator» «range.maxValue.head»
	«ENDIF»
	'''

	def static toLtOperator(String b) {
		if( b == "(" || b == ")" ) {
			return "<"
		} else {
			return "<="
		}
	}

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