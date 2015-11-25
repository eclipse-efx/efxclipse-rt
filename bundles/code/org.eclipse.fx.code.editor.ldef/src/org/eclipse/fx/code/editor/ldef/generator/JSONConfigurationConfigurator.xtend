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
				.build
		]
	}

	def ruleList(EditorGModel m, LanguageDef model, org.eclipse.fx.code.editor.ldef.lDef.Partition pr) {
		val tmp = model.paritioning.partitioner as Partitioner_Rule
		return tmp.ruleList.filter[prl|prl.parition == pr].map[ prl |
			if( prl instanceof Partition_SingleLineRule ) {
				return m.PartitionRule_SingleLineBuilder
					.startSeq(prl.startSeq)
					.endSeq(prl.endSeq)
					.escapedBy(prl.escapeSeq)
					.build
			} else if( prl instanceof Partition_MultiLineRule ) {
				return m.PartitionRule_MultiLineBuilder
					.startSeq(prl.startSeq)
					.endSeq(prl.endSeq)
					.escapedBy(prl.escapeSeq)
					.build
			}
		].toList
	}

	def tokenList(EditorGModel m, LanguageDef model, org.eclipse.fx.code.editor.ldef.lDef.Partition pr) {
		return model.lexicalHighlighting.list.filter(typeof(LexicalPartitionHighlighting_Rule)).filter[ lp | lp.partition == pr].map[ lp |
			lp.tokenList.map[ t |
				m.TokenBuilder
					.name(t.name)
					.defaultToken(t.^default)
					.tokenScannerList( m2 | m2.tokenScannerList(t))
					.build
			]
		].head
	}

	def tokenScannerList(EditorGModel m, org.eclipse.fx.code.editor.ldef.lDef.Token t) {
		return t.scannerList.map[ ts |
			if( ts instanceof Scanner_Keyword ) {
				val sk = ts as Scanner_Keyword
				return m.TokenScanner_KeywordBuilder
					.keywordList( sk.keywords.map[ k | k.name ].toList )
					.build
			} else if( ts instanceof Scanner_SingleLineRule ) {
				val sr = ts as Scanner_SingleLineRule
				return m.TokenScanner_SingleLineRuleBuilder
					.check(createCheck(m,sr.check))
					.startSeq(sr.startSeq)
					.endSeq(sr.endSeq)
					.escapedBy(sr.escapeSeq)
					.build
			} else if( ts instanceof Scanner_MultiLineRule ) {
				val mr = ts as Scanner_MultiLineRule
				return m.TokenScanner_MultiLineRuleBuilder
					.check(createCheck(m,mr.check))
					.startSeq(mr.startSeq)
					.endSeq(mr.endSeq)
					.escapedBy(mr.escapeSeq)
					.build
			} else if( ts instanceof Scanner_CharacterRule ) {
				val sc = ts as Scanner_CharacterRule
				return m.TokenScanner_CharacterRuleBuilder
					.check(createCheck(m,sc.check))
					.characterList(sc.characters)
					.build
			} else if( ts instanceof Scanner_PatternRule ) {
				val sp = ts as Scanner_PatternRule
				return m.TokenScanner_PatternRuleBuilder
					.check(createCheck(m,sp.check))
					.startLength(sp.length)
					.startPattern(sp.startPattern)
					.containmentPattern(sp.contentPattern)
					.build
			}
		]
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
		val r = rs.getResource(URI.createURI("file:/Users/tomschindl/git/efxclipse/bundles/code/org.eclipse.fx.code.editor.ldef.langs/src/org/eclipse/fx/code/editor/ldef/langs/dart/dart.ldef"),true);
		System.err.println(new JSONConfigurationConfigurator().toJSONString((r.contents.head as Root).languageDefinition));
	}

}