package org.eclipse.fx.code.editor.ldef.generator;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.util.List;
import java.util.function.Function;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.fx.code.editor.configuration.EditorGModel;
import org.eclipse.fx.code.editor.configuration.Partition;
import org.eclipse.fx.code.editor.configuration.PartitionRule;
import org.eclipse.fx.code.editor.configuration.PartitionRule_MultiLine;
import org.eclipse.fx.code.editor.configuration.PartitionRule_SingleLine;
import org.eclipse.fx.code.editor.configuration.Token;
import org.eclipse.fx.code.editor.configuration.TokenScanner;
import org.eclipse.fx.code.editor.configuration.TokenScanner_CharacterRule;
import org.eclipse.fx.code.editor.configuration.TokenScanner_Keyword;
import org.eclipse.fx.code.editor.configuration.TokenScanner_MultiLineRule;
import org.eclipse.fx.code.editor.configuration.TokenScanner_PatternRule;
import org.eclipse.fx.code.editor.configuration.TokenScanner_SingleLineRule;
import org.eclipse.fx.code.editor.ldef.LDefStandaloneSetup;
import org.eclipse.fx.code.editor.ldef.lDef.Check;
import org.eclipse.fx.code.editor.ldef.lDef.Equals;
import org.eclipse.fx.code.editor.ldef.lDef.Keyword;
import org.eclipse.fx.code.editor.ldef.lDef.LanguageDef;
import org.eclipse.fx.code.editor.ldef.lDef.LexicalHighlighting;
import org.eclipse.fx.code.editor.ldef.lDef.LexicalPartitionHighlighting;
import org.eclipse.fx.code.editor.ldef.lDef.LexicalPartitionHighlighting_Rule;
import org.eclipse.fx.code.editor.ldef.lDef.Paritioning;
import org.eclipse.fx.code.editor.ldef.lDef.Partition_MultiLineRule;
import org.eclipse.fx.code.editor.ldef.lDef.Partition_Rule;
import org.eclipse.fx.code.editor.ldef.lDef.Partition_SingleLineRule;
import org.eclipse.fx.code.editor.ldef.lDef.Partitioner;
import org.eclipse.fx.code.editor.ldef.lDef.Partitioner_Rule;
import org.eclipse.fx.code.editor.ldef.lDef.Range;
import org.eclipse.fx.code.editor.ldef.lDef.Root;
import org.eclipse.fx.code.editor.ldef.lDef.Scanner;
import org.eclipse.fx.code.editor.ldef.lDef.Scanner_CharacterRule;
import org.eclipse.fx.code.editor.ldef.lDef.Scanner_Keyword;
import org.eclipse.fx.code.editor.ldef.lDef.Scanner_MultiLineRule;
import org.eclipse.fx.code.editor.ldef.lDef.Scanner_PatternRule;
import org.eclipse.fx.code.editor.ldef.lDef.Scanner_SingleLineRule;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("restriction")
public class JSONConfigurationConfigurator {
  public void generate(final LanguageDef model, final IFileSystemAccess access) {
    EObject _eContainer = model.eContainer();
    String _name = ((Root) _eContainer).getName();
    String _replace = _name.replace(".", "/");
    String _plus = (_replace + "/");
    String _name_1 = model.getName();
    String _plus_1 = (_plus + _name_1);
    String _plus_2 = (_plus_1 + ".json");
    String _jSONString = this.toJSONString(model);
    access.generateFile(_plus_2, _jSONString);
  }
  
  public String toJSONString(final LanguageDef model) {
    final EditorGModel m = EditorGModel.create();
    org.eclipse.fx.code.editor.configuration.LanguageDef.Builder _LanguageDefBuilder = m.LanguageDefBuilder();
    String _name = model.getName();
    org.eclipse.fx.code.editor.configuration.LanguageDef.Builder _fileSuffix = _LanguageDefBuilder.fileSuffix(_name);
    final Function<EditorGModel, List<Partition>> _function = (EditorGModel m1) -> {
      return this.partitionList(m1, model);
    };
    org.eclipse.fx.code.editor.configuration.LanguageDef.Builder _partitionList = _fileSuffix.partitionList(_function);
    final org.eclipse.fx.code.editor.configuration.LanguageDef d = _partitionList.build();
    return m.toString(d);
  }
  
  public List<Partition> partitionList(final EditorGModel m, final LanguageDef model) {
    Paritioning _paritioning = model.getParitioning();
    EList<org.eclipse.fx.code.editor.ldef.lDef.Partition> _partitions = _paritioning.getPartitions();
    final Function1<org.eclipse.fx.code.editor.ldef.lDef.Partition, Partition> _function = (org.eclipse.fx.code.editor.ldef.lDef.Partition pr) -> {
      Partition.Builder _PartitionBuilder = m.PartitionBuilder();
      String _name = pr.getName();
      Partition.Builder _name_1 = _PartitionBuilder.name(_name);
      final Function<EditorGModel, List<PartitionRule>> _function_1 = (EditorGModel m2) -> {
        return this.ruleList(m2, model, pr);
      };
      Partition.Builder _ruleList = _name_1.ruleList(_function_1);
      final Function<EditorGModel, List<Token>> _function_2 = (EditorGModel m2) -> {
        return this.tokenList(m2, model, pr);
      };
      Partition.Builder _kenList = _ruleList.tokenList(_function_2);
      return _kenList.build();
    };
    return ListExtensions.<org.eclipse.fx.code.editor.ldef.lDef.Partition, Partition>map(_partitions, _function);
  }
  
  public List<PartitionRule> ruleList(final EditorGModel m, final LanguageDef model, final org.eclipse.fx.code.editor.ldef.lDef.Partition pr) {
    Paritioning _paritioning = model.getParitioning();
    Partitioner _partitioner = _paritioning.getPartitioner();
    final Partitioner_Rule tmp = ((Partitioner_Rule) _partitioner);
    EList<Partition_Rule> _ruleList = tmp.getRuleList();
    final Function1<Partition_Rule, Boolean> _function = (Partition_Rule prl) -> {
      org.eclipse.fx.code.editor.ldef.lDef.Partition _parition = prl.getParition();
      return Boolean.valueOf(Objects.equal(_parition, pr));
    };
    Iterable<Partition_Rule> _filter = IterableExtensions.<Partition_Rule>filter(_ruleList, _function);
    final Function1<Partition_Rule, PartitionRule> _function_1 = (Partition_Rule prl) -> {
      if ((prl instanceof Partition_SingleLineRule)) {
        PartitionRule_SingleLine.Builder _PartitionRule_SingleLineBuilder = m.PartitionRule_SingleLineBuilder();
        String _startSeq = ((Partition_SingleLineRule)prl).getStartSeq();
        PartitionRule_SingleLine.Builder _startSeq_1 = _PartitionRule_SingleLineBuilder.startSeq(_startSeq);
        String _endSeq = ((Partition_SingleLineRule)prl).getEndSeq();
        PartitionRule_SingleLine.Builder _endSeq_1 = _startSeq_1.endSeq(_endSeq);
        String _escapeSeq = ((Partition_SingleLineRule)prl).getEscapeSeq();
        PartitionRule_SingleLine.Builder _escapedBy = _endSeq_1.escapedBy(_escapeSeq);
        return _escapedBy.build();
      } else {
        if ((prl instanceof Partition_MultiLineRule)) {
          PartitionRule_MultiLine.Builder _PartitionRule_MultiLineBuilder = m.PartitionRule_MultiLineBuilder();
          String _startSeq_2 = ((Partition_MultiLineRule)prl).getStartSeq();
          PartitionRule_MultiLine.Builder _startSeq_3 = _PartitionRule_MultiLineBuilder.startSeq(_startSeq_2);
          String _endSeq_2 = ((Partition_MultiLineRule)prl).getEndSeq();
          PartitionRule_MultiLine.Builder _endSeq_3 = _startSeq_3.endSeq(_endSeq_2);
          String _escapeSeq_1 = ((Partition_MultiLineRule)prl).getEscapeSeq();
          PartitionRule_MultiLine.Builder _escapedBy_1 = _endSeq_3.escapedBy(_escapeSeq_1);
          return _escapedBy_1.build();
        }
      }
      return null;
    };
    Iterable<PartitionRule> _map = IterableExtensions.<Partition_Rule, PartitionRule>map(_filter, _function_1);
    return IterableExtensions.<PartitionRule>toList(_map);
  }
  
  public List<Token> tokenList(final EditorGModel m, final LanguageDef model, final org.eclipse.fx.code.editor.ldef.lDef.Partition pr) {
    LexicalHighlighting _lexicalHighlighting = model.getLexicalHighlighting();
    EList<LexicalPartitionHighlighting> _list = _lexicalHighlighting.getList();
    Iterable<LexicalPartitionHighlighting_Rule> _filter = Iterables.<LexicalPartitionHighlighting_Rule>filter(_list, LexicalPartitionHighlighting_Rule.class);
    final Function1<LexicalPartitionHighlighting_Rule, Boolean> _function = (LexicalPartitionHighlighting_Rule lp) -> {
      org.eclipse.fx.code.editor.ldef.lDef.Partition _partition = lp.getPartition();
      return Boolean.valueOf(Objects.equal(_partition, pr));
    };
    Iterable<LexicalPartitionHighlighting_Rule> _filter_1 = IterableExtensions.<LexicalPartitionHighlighting_Rule>filter(_filter, _function);
    final Function1<LexicalPartitionHighlighting_Rule, List<Token>> _function_1 = (LexicalPartitionHighlighting_Rule lp) -> {
      EList<org.eclipse.fx.code.editor.ldef.lDef.Token> _tokenList = lp.getTokenList();
      final Function1<org.eclipse.fx.code.editor.ldef.lDef.Token, Token> _function_2 = (org.eclipse.fx.code.editor.ldef.lDef.Token t) -> {
        Token.Builder _TokenBuilder = m.TokenBuilder();
        String _name = t.getName();
        Token.Builder _name_1 = _TokenBuilder.name(_name);
        boolean _isDefault = t.isDefault();
        Token.Builder _defaultToken = _name_1.defaultToken(_isDefault);
        final Function<EditorGModel, List<TokenScanner>> _function_3 = (EditorGModel m2) -> {
          return this.tokenScannerList(m2, t);
        };
        Token.Builder _kenScannerList = _defaultToken.tokenScannerList(_function_3);
        return _kenScannerList.build();
      };
      return ListExtensions.<org.eclipse.fx.code.editor.ldef.lDef.Token, Token>map(_tokenList, _function_2);
    };
    Iterable<List<Token>> _map = IterableExtensions.<LexicalPartitionHighlighting_Rule, List<Token>>map(_filter_1, _function_1);
    return IterableExtensions.<List<Token>>head(_map);
  }
  
  public List<TokenScanner> tokenScannerList(final EditorGModel m, final org.eclipse.fx.code.editor.ldef.lDef.Token t) {
    EList<Scanner> _scannerList = t.getScannerList();
    final Function1<Scanner, TokenScanner> _function = (Scanner ts) -> {
      if ((ts instanceof Scanner_Keyword)) {
        final Scanner_Keyword sk = ((Scanner_Keyword) ts);
        TokenScanner_Keyword.Builder _TokenScanner_KeywordBuilder = m.TokenScanner_KeywordBuilder();
        EList<Keyword> _keywords = sk.getKeywords();
        final Function1<Keyword, String> _function_1 = (Keyword k) -> {
          return k.getName();
        };
        List<String> _map = ListExtensions.<Keyword, String>map(_keywords, _function_1);
        List<String> _list = IterableExtensions.<String>toList(_map);
        TokenScanner_Keyword.Builder _keywordList = _TokenScanner_KeywordBuilder.keywordList(_list);
        return _keywordList.build();
      } else {
        if ((ts instanceof Scanner_SingleLineRule)) {
          final Scanner_SingleLineRule sr = ((Scanner_SingleLineRule) ts);
          TokenScanner_SingleLineRule.Builder _TokenScanner_SingleLineRuleBuilder = m.TokenScanner_SingleLineRuleBuilder();
          Check _check = sr.getCheck();
          org.eclipse.fx.code.editor.configuration.Check _createCheck = this.createCheck(m, _check);
          TokenScanner_SingleLineRule.Builder _check_1 = _TokenScanner_SingleLineRuleBuilder.check(_createCheck);
          String _startSeq = sr.getStartSeq();
          TokenScanner_SingleLineRule.Builder _startSeq_1 = _check_1.startSeq(_startSeq);
          String _endSeq = sr.getEndSeq();
          TokenScanner_SingleLineRule.Builder _endSeq_1 = _startSeq_1.endSeq(_endSeq);
          String _escapeSeq = sr.getEscapeSeq();
          TokenScanner_SingleLineRule.Builder _escapedBy = _endSeq_1.escapedBy(_escapeSeq);
          return _escapedBy.build();
        } else {
          if ((ts instanceof Scanner_MultiLineRule)) {
            final Scanner_MultiLineRule mr = ((Scanner_MultiLineRule) ts);
            TokenScanner_MultiLineRule.Builder _TokenScanner_MultiLineRuleBuilder = m.TokenScanner_MultiLineRuleBuilder();
            Check _check_2 = mr.getCheck();
            org.eclipse.fx.code.editor.configuration.Check _createCheck_1 = this.createCheck(m, _check_2);
            TokenScanner_MultiLineRule.Builder _check_3 = _TokenScanner_MultiLineRuleBuilder.check(_createCheck_1);
            String _startSeq_2 = mr.getStartSeq();
            TokenScanner_MultiLineRule.Builder _startSeq_3 = _check_3.startSeq(_startSeq_2);
            String _endSeq_2 = mr.getEndSeq();
            TokenScanner_MultiLineRule.Builder _endSeq_3 = _startSeq_3.endSeq(_endSeq_2);
            String _escapeSeq_1 = mr.getEscapeSeq();
            TokenScanner_MultiLineRule.Builder _escapedBy_1 = _endSeq_3.escapedBy(_escapeSeq_1);
            return _escapedBy_1.build();
          } else {
            if ((ts instanceof Scanner_CharacterRule)) {
              final Scanner_CharacterRule sc = ((Scanner_CharacterRule) ts);
              TokenScanner_CharacterRule.Builder _TokenScanner_CharacterRuleBuilder = m.TokenScanner_CharacterRuleBuilder();
              Check _check_4 = sc.getCheck();
              org.eclipse.fx.code.editor.configuration.Check _createCheck_2 = this.createCheck(m, _check_4);
              TokenScanner_CharacterRule.Builder _check_5 = _TokenScanner_CharacterRuleBuilder.check(_createCheck_2);
              EList<String> _characters = sc.getCharacters();
              TokenScanner_CharacterRule.Builder _characterList = _check_5.characterList(_characters);
              return _characterList.build();
            } else {
              if ((ts instanceof Scanner_PatternRule)) {
                final Scanner_PatternRule sp = ((Scanner_PatternRule) ts);
                TokenScanner_PatternRule.Builder _TokenScanner_PatternRuleBuilder = m.TokenScanner_PatternRuleBuilder();
                Check _check_6 = sp.getCheck();
                org.eclipse.fx.code.editor.configuration.Check _createCheck_3 = this.createCheck(m, _check_6);
                TokenScanner_PatternRule.Builder _check_7 = _TokenScanner_PatternRuleBuilder.check(_createCheck_3);
                int _length = sp.getLength();
                TokenScanner_PatternRule.Builder _startLength = _check_7.startLength(_length);
                String _startPattern = sp.getStartPattern();
                TokenScanner_PatternRule.Builder _startPattern_1 = _startLength.startPattern(_startPattern);
                String _contentPattern = sp.getContentPattern();
                TokenScanner_PatternRule.Builder _containmentPattern = _startPattern_1.containmentPattern(_contentPattern);
                return _containmentPattern.build();
              }
            }
          }
        }
      }
      return null;
    };
    return ListExtensions.<Scanner, TokenScanner>map(_scannerList, _function);
  }
  
  public org.eclipse.fx.code.editor.configuration.Check createCheck(final EditorGModel m, final Check c) {
    boolean _equals = Objects.equal(c, null);
    if (_equals) {
      return null;
    }
    if ((c instanceof Equals)) {
      final Equals eq = ((Equals) c);
      org.eclipse.fx.code.editor.configuration.Equals.Builder _EqualsBuilder = m.EqualsBuilder();
      int _value = eq.getValue();
      org.eclipse.fx.code.editor.configuration.Equals.Builder _value_1 = _EqualsBuilder.value(_value);
      return _value_1.build();
    } else {
      final Range r = ((Range) c);
      org.eclipse.fx.code.editor.configuration.Range.Builder _RangeBuilder = m.RangeBuilder();
      EList<Integer> _minValue = r.getMinValue();
      Integer _get = _minValue.get(0);
      org.eclipse.fx.code.editor.configuration.Range.Builder _min = _RangeBuilder.min((_get).intValue());
      String _ltIncl = r.getLtIncl();
      boolean _notEquals = (!Objects.equal(_ltIncl, "("));
      org.eclipse.fx.code.editor.configuration.Range.Builder _minIncl = _min.minIncl(_notEquals);
      EList<Integer> _maxValue = r.getMaxValue();
      Integer _get_1 = _maxValue.get(0);
      org.eclipse.fx.code.editor.configuration.Range.Builder _max = _minIncl.max((_get_1).intValue());
      String _gtIncl = r.getGtIncl();
      boolean _notEquals_1 = (!Objects.equal(_gtIncl, ")"));
      org.eclipse.fx.code.editor.configuration.Range.Builder _maxIncl = _max.maxIncl(_notEquals_1);
      return _maxIncl.build();
    }
  }
  
  public static void main(final String[] args) {
    LDefStandaloneSetup.doSetup();
    final ResourceSetImpl rs = new ResourceSetImpl();
    URI _createURI = URI.createURI("file:/Users/tomschindl/git/efxclipse/bundles/code/org.eclipse.fx.code.editor.ldef.langs/src/org/eclipse/fx/code/editor/ldef/langs/dart/dart.ldef");
    final Resource r = rs.getResource(_createURI, true);
    JSONConfigurationConfigurator _jSONConfigurationConfigurator = new JSONConfigurationConfigurator();
    EList<EObject> _contents = r.getContents();
    EObject _head = IterableExtensions.<EObject>head(_contents);
    LanguageDef _languageDefinition = ((Root) _head).getLanguageDefinition();
    String _jSONString = _jSONConfigurationConfigurator.toJSONString(_languageDefinition);
    System.err.println(_jSONString);
  }
}
