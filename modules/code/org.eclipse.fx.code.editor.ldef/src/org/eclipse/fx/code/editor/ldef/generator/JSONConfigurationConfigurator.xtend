package org.eclipse.fx.code.editor.ldef.generator

import org.eclipse.fx.code.editor.ldef.lDef.LanguageDef
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.fx.code.editor.ldef.LDefStandaloneSetup
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.common.util.URI
import org.eclipse.fx.code.editor.configuration.EditorGModel
import java.util.List
import org.eclipse.fx.code.editor.configuration.Partition
import java.util.ArrayList
import org.eclipse.fx.code.editor.ldef.lDef.LexicalPartitionHighlighting_Rule
import org.eclipse.fx.code.editor.configuration.PartitionRule
import org.eclipse.fx.code.editor.ldef.lDef.Root
import org.eclipse.fx.code.editor.ldef.lDef.Partitioner_Rule
import org.eclipse.fx.code.editor.ldef.lDef.Partition_Rule
import java.util.Set
import org.eclipse.fx.code.editor.ldef.lDef.Partition_SingleLineRule
import org.eclipse.fx.code.editor.ldef.lDef.Partition_MultiLineRule
import org.eclipse.fx.code.editor.configuration.PartitionRule_SingleLine
import org.eclipse.fx.code.editor.configuration.Token
import org.eclipse.fx.code.editor.configuration.TokenScanner
import org.eclipse.fx.code.editor.ldef.lDef.Scanner_Keyword
import org.eclipse.fx.code.editor.ldef.lDef.Scanner_SingleLineRule
import org.eclipse.fx.code.editor.ldef.lDef.Scanner_MultiLineRule
import org.eclipse.fx.code.editor.ldef.lDef.Scanner_CharacterRule
import org.eclipse.fx.code.editor.ldef.lDef.Scanner_PatternRule
import org.eclipse.fx.code.editor.ldef.lDef.Check
import org.eclipse.fx.code.editor.ldef.lDef.Equals
import org.eclipse.fx.code.editor.ldef.lDef.Range
import java.util.Collections
import org.eclipse.fx.code.editor.ldef.lDef.ScannerCondition
import org.eclipse.fx.code.editor.ldef.lDef.ScannerConditionExists
import org.eclipse.fx.code.editor.ldef.lDef.ScannerConditionEquals
import org.eclipse.fx.code.editor.ldef.lDef.ScannerConditionJs
import org.eclipse.fx.code.editor.ldef.lDef.ScannerConditionComposite
import org.eclipse.fx.code.editor.configuration.Condition
import org.eclipse.fx.code.editor.ldef.lDef.Partition_JSRule
import org.eclipse.fx.code.editor.configuration.PartitionWhiteSpace

@SuppressWarnings("restriction")
class JSONConfigurationConfigurator {
	def generate(LanguageDef model, IFileSystemAccess access) {
		access.generateFile( (model.eContainer as Root).name.replace(".","/") + "/" + model.name + ".json", model.toJSONString );
	}

	def toJSONString(LanguageDef model) {
		val m = EditorGModel.create
		val d = m.LanguageDefBuilder
			.fileSuffix(model.name)
			.partitionList( m1 | m1.partitionList(model) )
			.build;
		return m.toString(d)
	}

	def partitionList(EditorGModel m, LanguageDef model) {
		return model.paritioning.partitions.map[ pr |
			m.PartitionBuilder
				.name(pr.name)
				.ruleList( m2 |
					m2.ruleList(model, pr)
				)
				.tokenList( m2 |
					m2.tokenList(model,pr)
				)
				.whitespace( m.whitespaceRule(model,pr) )
				.build
		]
	}

	def whitespaceRule(EditorGModel m, LanguageDef model, org.eclipse.fx.code.editor.ldef.lDef.Partition pr) {
		val rv = model.lexicalHighlighting.list.filter(typeof(LexicalPartitionHighlighting_Rule)).findFirst[lp | lp.partition == pr]
		if( rv != null && rv.whitespace != null ) {
			return m.PartitionWhiteSpaceBuilder
			.javawhiteSpace(rv.whitespace.isJavawhitespace)
			.characterList( rv.whitespace.characters )
			.build;
		}
	}

	def ruleList(EditorGModel m, LanguageDef model, org.eclipse.fx.code.editor.ldef.lDef.Partition pr) {
		val tmp = model.paritioning.partitioner as Partitioner_Rule
		return tmp.ruleList.filter[prl|prl.parition == pr].map[ prl |
			if( prl instanceof Partition_SingleLineRule ) {
				if( prl.startPattern != null ) {
					return m.PartitionRule_DynamicEndBuilder
						.beginPrefix(prl.startSeq)
						.beginMatch(prl.startPattern)
						.beginSuffix(prl.startSuffix)
						.endTemplate(prl.endSeq)
						.singleLine(true)
						.build
				} else {
					return m.PartitionRule_SingleLineBuilder
						.startSeq(prl.startSeq)
						.endSeq(prl.endSeq)
						.escapedBy(prl.escapeSeq)
						.build
				}
			} else if( prl instanceof Partition_MultiLineRule ) {
				if( prl.startPattern != null ) {
					return m.PartitionRule_DynamicEndBuilder
						.beginPrefix(prl.startSeq)
						.beginMatch(prl.startPattern)
						.beginSuffix(prl.startSuffix)
						.endTemplate(prl.endSeq)
						.singleLine(false)
						.build
				} else {
					return m.PartitionRule_MultiLineBuilder
						.startSeq(prl.startSeq)
						.endSeq(prl.endSeq)
						.escapedBy(prl.escapeSeq)
						.build
				}
			} else if( prl instanceof Partition_JSRule ) {
				// TODO Handle it
			} else {
				throw new IllegalStateException("Unknown rule '"+prl+"'")
			}
		].toList
	}

	def tokenList(EditorGModel m, LanguageDef model, org.eclipse.fx.code.editor.ldef.lDef.Partition pr) {
		val rv = model.lexicalHighlighting.list.filter(typeof(LexicalPartitionHighlighting_Rule)).filter[ lp | lp.partition == pr].map[ lp |
			lp.tokenList.map[ t |
				m.TokenBuilder
					.name(t.name)
					.defaultToken(t.^default)
					.tokenScannerList( m2 | m2.tokenScannerList(t))
					.build
			]
		].head

		if( rv == null ) {
			return Collections.emptyList
		} else {
			return rv;
		}
	}

	def tokenScannerList(EditorGModel m, org.eclipse.fx.code.editor.ldef.lDef.Token t) {
		return t.scannerList.map[ ts |
			if( ts instanceof Scanner_Keyword ) {
				val sk = ts as Scanner_Keyword
				return m.TokenScanner_KeywordBuilder
					.condition(createCondition(m,ts.enabledIf))
					.keywordList( sk.keywords.map[ k | k.name ].toList )
					.build
			} else if( ts instanceof Scanner_SingleLineRule ) {
				if( ts.startPattern != null ) {
					return m.TokenScanner_DynamicEndBuilder
						.beginPrefix(ts.startSeq)
						.beginMatch(ts.startPattern)
						.endTemplate(ts.endSeq)
						.singleLine(true)
						.build
				} else {
					val sr = ts as Scanner_SingleLineRule
					return m.TokenScanner_SingleLineRuleBuilder
						.check(createCheck(m,sr.check))
						.condition(createCondition(m,ts.enabledIf))
						.startSeq(sr.startSeq)
						.endSeq(sr.endSeq)
						.escapedBy(sr.escapeSeq)
						.build
				}
			} else if( ts instanceof Scanner_MultiLineRule ) {
				if( ts.startPattern != null ) {
					return m.TokenScanner_DynamicEndBuilder
						.beginPrefix(ts.startSeq)
						.beginMatch(ts.startPattern)
						.endTemplate(ts.endSeq)
						.build
				} else {
					val mr = ts as Scanner_MultiLineRule
					return m.TokenScanner_MultiLineRuleBuilder
						.check(createCheck(m,mr.check))
						.condition(createCondition(m,ts.enabledIf))
						.startSeq(mr.startSeq)
						.endSeq(mr.endSeq)
						.escapedBy(mr.escapeSeq)
						.build
				}
			} else if( ts instanceof Scanner_CharacterRule ) {
				val sc = ts as Scanner_CharacterRule
				return m.TokenScanner_CharacterRuleBuilder
					.condition(createCondition(m,ts.enabledIf))
					.check(createCheck(m,sc.check))
					.characterList(sc.characters)
					.build
			} else if( ts instanceof Scanner_PatternRule ) {
				val sp = ts as Scanner_PatternRule
				return m.TokenScanner_PatternRuleBuilder
					.check(createCheck(m,sp.check))
					.condition(createCondition(m,ts.enabledIf))
					.startLength(sp.length)
					.startPattern(sp.startPattern)
					.containmentPattern(sp.contentPattern)
					.build
			}
		]
	}

	def Condition createCondition(EditorGModel m, ScannerCondition c) {
		if( c == null ) {
			return null;
		}

		if( c instanceof ScannerConditionExists ) {
			return m.ExistsConditionBuilder.name(c.key).build
		} else if( c instanceof ScannerConditionEquals ) {
			m.EqualsConditionBuilder.name(c.key).value(c.value).build
		} else if( c instanceof ScannerConditionJs ) {
			return null;
		} else if( c instanceof ScannerConditionComposite ) {
			val b = m.CompositeConditionBuilder.and(c.op == "and");
			c.elements.map[ e | createCondition(m,e)].forEach[ c1 | b.appendElementList(c1)]
			return b.build
		}
	}

	def createCheck(EditorGModel m, Check c) {
		if( c == null ) {
			return null;
		}
		if( c instanceof Equals ) {
			val eq = c as Equals
			return m.EqualsBuilder
				.value(eq.value)
				.build
		} else {
			val r = c as Range
			return m.RangeBuilder
				.min(r.minValue.get(0))
				.minIncl(r.ltIncl != "(")
				.max(r.maxValue.get(0))
				.maxIncl(r.gtIncl != ")")
				.build
		}
	}

	def static void main(String[] args) {
		LDefStandaloneSetup.doSetup();

		val rs = new ResourceSetImpl;
		val r = rs.getResource(URI.createURI("file:/Users/tomschindl/git/efxclipse/bundles/code/org.eclipse.fx.code.editor.langs/src/org/eclipse/fx/code/editor/ldef/langs/asciidoc/asciidoc.ldef"),true);
		System.err.println(new JSONConfigurationConfigurator().toJSONString((r.contents.head as Root).languageDefinition));
	}

}