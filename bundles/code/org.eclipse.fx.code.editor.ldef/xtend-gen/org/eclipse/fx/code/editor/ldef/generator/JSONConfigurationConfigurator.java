package org.eclipse.fx.code.editor.ldef.generator;

import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.fx.code.editor.ldef.LDefStandaloneSetup;
import org.eclipse.fx.code.editor.ldef.lDef.Check;
import org.eclipse.fx.code.editor.ldef.lDef.LanguageDef;
import org.eclipse.fx.code.editor.ldef.lDef.Partition;
import org.eclipse.fx.code.editor.ldef.lDef.Root;
import org.eclipse.fx.code.editor.ldef.lDef.Token;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

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
    Object _jSONString = this.toJSONString(model);
    access.generateFile(_plus_2, _jSONString);
  }
  
  public Object toJSONString(final LanguageDef model) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field EditorGModel is undefined"
      + "\nThere is no context to infer the closure\'s argument types from. Consider typing the arguments or put the closures into a typed context."
      + "\ncreate cannot be resolved"
      + "\nLanguageDefBuilder cannot be resolved"
      + "\nfileSuffix cannot be resolved"
      + "\npartitionList cannot be resolved"
      + "\nbuild cannot be resolved"
      + "\ntoString cannot be resolved");
  }
  
  public /* List<Object> */Object partitionList(final /* EditorGModel */Object m, final LanguageDef model) {
    throw new Error("Unresolved compilation problems:"
      + "\nThere is no context to infer the closure\'s argument types from. Consider typing the arguments or put the closures into a typed context."
      + "\nThere is no context to infer the closure\'s argument types from. Consider typing the arguments or put the closures into a typed context."
      + "\nPartitionBuilder cannot be resolved"
      + "\nname cannot be resolved"
      + "\nruleList cannot be resolved"
      + "\ntokenList cannot be resolved"
      + "\nbuild cannot be resolved");
  }
  
  public /* List<Object> */Object ruleList(final /* EditorGModel */Object m, final LanguageDef model, final Partition pr) {
    throw new Error("Unresolved compilation problems:"
      + "\nPartitionRule_SingleLineBuilder cannot be resolved"
      + "\nstartSeq cannot be resolved"
      + "\nendSeq cannot be resolved"
      + "\nescapedBy cannot be resolved"
      + "\nbuild cannot be resolved"
      + "\nPartitionRule_MultiLineBuilder cannot be resolved"
      + "\nstartSeq cannot be resolved"
      + "\nendSeq cannot be resolved"
      + "\nescapedBy cannot be resolved"
      + "\nbuild cannot be resolved");
  }
  
  public List<Object> tokenList(final /* EditorGModel */Object m, final LanguageDef model, final Partition pr) {
    throw new Error("Unresolved compilation problems:"
      + "\nThere is no context to infer the closure\'s argument types from. Consider typing the arguments or put the closures into a typed context."
      + "\nTokenBuilder cannot be resolved"
      + "\nname cannot be resolved"
      + "\ndefaultToken cannot be resolved"
      + "\ntokenScannerList cannot be resolved"
      + "\nbuild cannot be resolved");
  }
  
  public /* List<Object> */Object tokenScannerList(final /* EditorGModel */Object m, final Token t) {
    throw new Error("Unresolved compilation problems:"
      + "\nTokenScanner_KeywordBuilder cannot be resolved"
      + "\nkeywordList cannot be resolved"
      + "\nbuild cannot be resolved"
      + "\nTokenScanner_SingleLineRuleBuilder cannot be resolved"
      + "\ncheck cannot be resolved"
      + "\nstartSeq cannot be resolved"
      + "\nendSeq cannot be resolved"
      + "\nescapedBy cannot be resolved"
      + "\nbuild cannot be resolved"
      + "\nTokenScanner_MultiLineRuleBuilder cannot be resolved"
      + "\ncheck cannot be resolved"
      + "\nstartSeq cannot be resolved"
      + "\nendSeq cannot be resolved"
      + "\nescapedBy cannot be resolved"
      + "\nbuild cannot be resolved"
      + "\nTokenScanner_CharacterRuleBuilder cannot be resolved"
      + "\ncheck cannot be resolved"
      + "\ncharacterList cannot be resolved"
      + "\nbuild cannot be resolved"
      + "\nTokenScanner_PatternRuleBuilder cannot be resolved"
      + "\ncheck cannot be resolved"
      + "\nstartLength cannot be resolved"
      + "\nstartPattern cannot be resolved"
      + "\ncontainmentPattern cannot be resolved"
      + "\nbuild cannot be resolved");
  }
  
  public Object createCheck(final /* EditorGModel */Object m, final Check c) {
    throw new Error("Unresolved compilation problems:"
      + "\nEqualsBuilder cannot be resolved"
      + "\nvalue cannot be resolved"
      + "\nbuild cannot be resolved"
      + "\nRangeBuilder cannot be resolved"
      + "\nmin cannot be resolved"
      + "\nminIncl cannot be resolved"
      + "\nmax cannot be resolved"
      + "\nmaxIncl cannot be resolved"
      + "\nbuild cannot be resolved");
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
    Object _jSONString = _jSONConfigurationConfigurator.toJSONString(_languageDefinition);
    System.err.println((_jSONString).ObjectValue());
  }
}
