package org.eclipse.fx.code.editor.ldef.generator;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.fx.code.editor.configuration.Check;
import org.eclipse.fx.code.editor.configuration.Condition;
import org.eclipse.fx.code.editor.configuration.EditorGModel;
import org.eclipse.fx.code.editor.configuration.Partition;
import org.eclipse.fx.code.editor.configuration.PartitionRule;
import org.eclipse.fx.code.editor.configuration.PartitionWhiteSpace;
import org.eclipse.fx.code.editor.configuration.Token;
import org.eclipse.fx.code.editor.configuration.TokenScanner;
import org.eclipse.fx.code.editor.ldef.LDefStandaloneSetup;
import org.eclipse.fx.code.editor.ldef.lDef.Equals;
import org.eclipse.fx.code.editor.ldef.lDef.LanguageDef;
import org.eclipse.fx.code.editor.ldef.lDef.LexicalHighlighting;
import org.eclipse.fx.code.editor.ldef.lDef.LexicalPartitionHighlighting;
import org.eclipse.fx.code.editor.ldef.lDef.LexicalPartitionHighlighting_Rule;
import org.eclipse.fx.code.editor.ldef.lDef.Paritioning;
import org.eclipse.fx.code.editor.ldef.lDef.Range;
import org.eclipse.fx.code.editor.ldef.lDef.Root;
import org.eclipse.fx.code.editor.ldef.lDef.WhitespaceRule;
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
      PartitionWhiteSpace _whitespaceRule = this.whitespaceRule(m, model, pr);
      Partition.Builder _whitespace = _kenList.whitespace(_whitespaceRule);
      return _whitespace.build();
    };
    return ListExtensions.<org.eclipse.fx.code.editor.ldef.lDef.Partition, Partition>map(_partitions, _function);
  }
  
  public PartitionWhiteSpace whitespaceRule(final EditorGModel m, final LanguageDef model, final org.eclipse.fx.code.editor.ldef.lDef.Partition pr) {
    LexicalHighlighting _lexicalHighlighting = model.getLexicalHighlighting();
    EList<LexicalPartitionHighlighting> _list = _lexicalHighlighting.getList();
    Iterable<LexicalPartitionHighlighting_Rule> _filter = Iterables.<LexicalPartitionHighlighting_Rule>filter(_list, LexicalPartitionHighlighting_Rule.class);
    final Function1<LexicalPartitionHighlighting_Rule, Boolean> _function = (LexicalPartitionHighlighting_Rule lp) -> {
      org.eclipse.fx.code.editor.ldef.lDef.Partition _partition = lp.getPartition();
      return Boolean.valueOf(Objects.equal(_partition, pr));
    };
    final LexicalPartitionHighlighting_Rule rv = IterableExtensions.<LexicalPartitionHighlighting_Rule>findFirst(_filter, _function);
    boolean _and = false;
    boolean _notEquals = (!Objects.equal(rv, null));
    if (!_notEquals) {
      _and = false;
    } else {
      WhitespaceRule _whitespace = rv.getWhitespace();
      boolean _notEquals_1 = (!Objects.equal(_whitespace, null));
      _and = _notEquals_1;
    }
    if (_and) {
      PartitionWhiteSpace.Builder _PartitionWhiteSpaceBuilder = m.PartitionWhiteSpaceBuilder();
      WhitespaceRule _whitespace_1 = rv.getWhitespace();
      boolean _isJavawhitespace = _whitespace_1.isJavawhitespace();
      PartitionWhiteSpace.Builder _javawhiteSpace = _PartitionWhiteSpaceBuilder.javawhiteSpace(_isJavawhitespace);
      WhitespaceRule _whitespace_2 = rv.getWhitespace();
      EList<String> _characters = _whitespace_2.getCharacters();
      PartitionWhiteSpace.Builder _characterList = _javawhiteSpace.characterList(_characters);
      return _characterList.build();
    }
    return null;
  }
  
  public List<PartitionRule> ruleList(final EditorGModel m, final LanguageDef model, final org.eclipse.fx.code.editor.ldef.lDef.Partition pr) {
    throw new Error("Unresolved compilation problems:"
      + "\nPartition_JSRule cannot be resolved to a type."
      + "\nUnreachable code: The if condition can never match. It is already handled by a previous condition.");
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
    final List<Token> rv = IterableExtensions.<List<Token>>head(_map);
    boolean _equals = Objects.equal(rv, null);
    if (_equals) {
      return Collections.<Token>emptyList();
    } else {
      return rv;
    }
  }
  
  public List<TokenScanner> tokenScannerList(final EditorGModel m, final org.eclipse.fx.code.editor.ldef.lDef.Token t) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field enabledIf is undefined for the type Scanner_Keyword"
      + "\nThe method or field enabledIf is undefined for the type Scanner_SingleLineRule"
      + "\nThe method or field enabledIf is undefined for the type Scanner_MultiLineRule"
      + "\nThe method or field enabledIf is undefined for the type Scanner_CharacterRule"
      + "\nThe method or field enabledIf is undefined for the type Scanner_PatternRule"
      + "\nThe method createCondition(EditorGModel, ScannerCondition) from the type JSONConfigurationConfigurator refers to the missing type ScannerCondition"
      + "\nThe method createCondition(EditorGModel, ScannerCondition) from the type JSONConfigurationConfigurator refers to the missing type ScannerCondition"
      + "\nThe method createCondition(EditorGModel, ScannerCondition) from the type JSONConfigurationConfigurator refers to the missing type ScannerCondition"
      + "\nThe method createCondition(EditorGModel, ScannerCondition) from the type JSONConfigurationConfigurator refers to the missing type ScannerCondition"
      + "\nThe method createCondition(EditorGModel, ScannerCondition) from the type JSONConfigurationConfigurator refers to the missing type ScannerCondition");
  }
  
  public Condition createCondition(final EditorGModel m, final /* ScannerCondition */Object c) {
    throw new Error("Unresolved compilation problems:"
      + "\nScannerConditionExists cannot be resolved to a type."
      + "\nScannerConditionEquals cannot be resolved to a type."
      + "\nScannerConditionJs cannot be resolved to a type."
      + "\nScannerConditionComposite cannot be resolved to a type."
      + "\nAmbiguous feature call.\nThe methods\n\tappendElementList(Condition) in Builder and\n\tappendElementList(Function<Builder, Condition>) in Builder\nboth match."
      + "\nUnreachable code: The if condition can never match. It is already handled by a previous condition."
      + "\nUnreachable code: The if condition can never match. It is already handled by a previous condition."
      + "\nUnreachable code: The if condition can never match. It is already handled by a previous condition."
      + "\nThere is no context to infer the closure\'s argument types from. Consider typing the arguments or put the closures into a typed context."
      + "\nThe method createCondition(EditorGModel, ScannerCondition) from the type JSONConfigurationConfigurator refers to the missing type ScannerCondition"
      + "\nThere is no context to infer the closure\'s argument types from. Consider typing the arguments or put the closures into a typed context."
      + "\n== cannot be resolved"
      + "\nkey cannot be resolved"
      + "\nkey cannot be resolved"
      + "\nvalue cannot be resolved"
      + "\nop cannot be resolved"
      + "\n== cannot be resolved"
      + "\nelements cannot be resolved"
      + "\nmap cannot be resolved"
      + "\nforEach cannot be resolved");
  }
  
  public Check createCheck(final EditorGModel m, final org.eclipse.fx.code.editor.ldef.lDef.Check c) {
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
    URI _createURI = URI.createURI("file:/Users/tomschindl/git/efxclipse/bundles/code/org.eclipse.fx.code.editor.langs/src/org/eclipse/fx/code/editor/ldef/langs/asciidoc/asciidoc.ldef");
    final Resource r = rs.getResource(_createURI, true);
    JSONConfigurationConfigurator _jSONConfigurationConfigurator = new JSONConfigurationConfigurator();
    EList<EObject> _contents = r.getContents();
    EObject _head = IterableExtensions.<EObject>head(_contents);
    LanguageDef _languageDefinition = ((Root) _head).getLanguageDefinition();
    String _jSONString = _jSONConfigurationConfigurator.toJSONString(_languageDefinition);
    System.err.println(_jSONString);
  }
}
