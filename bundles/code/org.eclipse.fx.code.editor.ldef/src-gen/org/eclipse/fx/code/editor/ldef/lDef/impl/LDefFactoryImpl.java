/**
 */
package org.eclipse.fx.code.editor.ldef.lDef.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.fx.code.editor.ldef.lDef.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class LDefFactoryImpl extends EFactoryImpl implements LDefFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static LDefFactory init()
  {
    try
    {
      LDefFactory theLDefFactory = (LDefFactory)EPackage.Registry.INSTANCE.getEFactory(LDefPackage.eNS_URI);
      if (theLDefFactory != null)
      {
        return theLDefFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new LDefFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LDefFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case LDefPackage.ROOT: return createRoot();
      case LDefPackage.IMPORT: return createImport();
      case LDefPackage.LANGUAGE_DEF: return createLanguageDef();
      case LDefPackage.INTEGRATION: return createIntegration();
      case LDefPackage.CODE_INTEGRATION: return createCodeIntegration();
      case LDefPackage.JAVA_FX_INTEGRATION: return createJavaFXIntegration();
      case LDefPackage.CODEGENERATION: return createCodegeneration();
      case LDefPackage.JAVA_CODE_GENERATION: return createJavaCodeGeneration();
      case LDefPackage.E4_CODE_GENERATION: return createE4CodeGeneration();
      case LDefPackage.CONFIG_VALUE: return createConfigValue();
      case LDefPackage.PARITIONING: return createParitioning();
      case LDefPackage.PARTITION: return createPartition();
      case LDefPackage.PARTITIONER: return createPartitioner();
      case LDefPackage.PARITIONER_JS: return createParitioner_JS();
      case LDefPackage.PARTITIONER_RULE: return createPartitioner_Rule();
      case LDefPackage.PARTITION_RULE: return createPartition_Rule();
      case LDefPackage.PARTITION_SINGLE_LINE_RULE: return createPartition_SingleLineRule();
      case LDefPackage.PARTITION_MULTI_LINE_RULE: return createPartition_MultiLineRule();
      case LDefPackage.LEXICAL_HIGHLIGHTING: return createLexicalHighlighting();
      case LDefPackage.TOKEN_VISUALS: return createTokenVisuals();
      case LDefPackage.TOKEN_VISUAL: return createTokenVisual();
      case LDefPackage.LEXICAL_PARTITION_HIGHLIGHTING: return createLexicalPartitionHighlighting();
      case LDefPackage.LEXICAL_PARTITION_HIGHLIGHTING_JS: return createLexicalPartitionHighlighting_JS();
      case LDefPackage.LEXICAL_PARTITION_HIGHLIGHTING_RULE: return createLexicalPartitionHighlighting_Rule();
      case LDefPackage.TOKEN: return createToken();
      case LDefPackage.SCANNER: return createScanner();
      case LDefPackage.SCANNER_KEYWORD: return createScanner_Keyword();
      case LDefPackage.KEYWORD: return createKeyword();
      case LDefPackage.SCANNER_RULE: return createScanner_Rule();
      case LDefPackage.SCANNER_SINGLE_LINE_RULE: return createScanner_SingleLineRule();
      case LDefPackage.SCANNER_MULTI_LINE_RULE: return createScanner_MultiLineRule();
      case LDefPackage.SCANNER_PATTERN_RULE: return createScanner_PatternRule();
      case LDefPackage.SCANNER_CHARACTER_RULE: return createScanner_CharacterRule();
      case LDefPackage.SCANNER_JS_RULE: return createScanner_JSRule();
      case LDefPackage.CHECK: return createCheck();
      case LDefPackage.EQUALS: return createEquals();
      case LDefPackage.RANGE: return createRange();
      case LDefPackage.WHITESPACE_RULE: return createWhitespaceRule();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Root createRoot()
  {
    RootImpl root = new RootImpl();
    return root;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Import createImport()
  {
    ImportImpl import_ = new ImportImpl();
    return import_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LanguageDef createLanguageDef()
  {
    LanguageDefImpl languageDef = new LanguageDefImpl();
    return languageDef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Integration createIntegration()
  {
    IntegrationImpl integration = new IntegrationImpl();
    return integration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CodeIntegration createCodeIntegration()
  {
    CodeIntegrationImpl codeIntegration = new CodeIntegrationImpl();
    return codeIntegration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JavaFXIntegration createJavaFXIntegration()
  {
    JavaFXIntegrationImpl javaFXIntegration = new JavaFXIntegrationImpl();
    return javaFXIntegration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Codegeneration createCodegeneration()
  {
    CodegenerationImpl codegeneration = new CodegenerationImpl();
    return codegeneration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JavaCodeGeneration createJavaCodeGeneration()
  {
    JavaCodeGenerationImpl javaCodeGeneration = new JavaCodeGenerationImpl();
    return javaCodeGeneration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public E4CodeGeneration createE4CodeGeneration()
  {
    E4CodeGenerationImpl e4CodeGeneration = new E4CodeGenerationImpl();
    return e4CodeGeneration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConfigValue createConfigValue()
  {
    ConfigValueImpl configValue = new ConfigValueImpl();
    return configValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Paritioning createParitioning()
  {
    ParitioningImpl paritioning = new ParitioningImpl();
    return paritioning;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Partition createPartition()
  {
    PartitionImpl partition = new PartitionImpl();
    return partition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Partitioner createPartitioner()
  {
    PartitionerImpl partitioner = new PartitionerImpl();
    return partitioner;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Paritioner_JS createParitioner_JS()
  {
    Paritioner_JSImpl paritioner_JS = new Paritioner_JSImpl();
    return paritioner_JS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Partitioner_Rule createPartitioner_Rule()
  {
    Partitioner_RuleImpl partitioner_Rule = new Partitioner_RuleImpl();
    return partitioner_Rule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Partition_Rule createPartition_Rule()
  {
    Partition_RuleImpl partition_Rule = new Partition_RuleImpl();
    return partition_Rule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Partition_SingleLineRule createPartition_SingleLineRule()
  {
    Partition_SingleLineRuleImpl partition_SingleLineRule = new Partition_SingleLineRuleImpl();
    return partition_SingleLineRule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Partition_MultiLineRule createPartition_MultiLineRule()
  {
    Partition_MultiLineRuleImpl partition_MultiLineRule = new Partition_MultiLineRuleImpl();
    return partition_MultiLineRule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LexicalHighlighting createLexicalHighlighting()
  {
    LexicalHighlightingImpl lexicalHighlighting = new LexicalHighlightingImpl();
    return lexicalHighlighting;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TokenVisuals createTokenVisuals()
  {
    TokenVisualsImpl tokenVisuals = new TokenVisualsImpl();
    return tokenVisuals;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TokenVisual createTokenVisual()
  {
    TokenVisualImpl tokenVisual = new TokenVisualImpl();
    return tokenVisual;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LexicalPartitionHighlighting createLexicalPartitionHighlighting()
  {
    LexicalPartitionHighlightingImpl lexicalPartitionHighlighting = new LexicalPartitionHighlightingImpl();
    return lexicalPartitionHighlighting;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LexicalPartitionHighlighting_JS createLexicalPartitionHighlighting_JS()
  {
    LexicalPartitionHighlighting_JSImpl lexicalPartitionHighlighting_JS = new LexicalPartitionHighlighting_JSImpl();
    return lexicalPartitionHighlighting_JS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LexicalPartitionHighlighting_Rule createLexicalPartitionHighlighting_Rule()
  {
    LexicalPartitionHighlighting_RuleImpl lexicalPartitionHighlighting_Rule = new LexicalPartitionHighlighting_RuleImpl();
    return lexicalPartitionHighlighting_Rule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Token createToken()
  {
    TokenImpl token = new TokenImpl();
    return token;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Scanner createScanner()
  {
    ScannerImpl scanner = new ScannerImpl();
    return scanner;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Scanner_Keyword createScanner_Keyword()
  {
    Scanner_KeywordImpl scanner_Keyword = new Scanner_KeywordImpl();
    return scanner_Keyword;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Keyword createKeyword()
  {
    KeywordImpl keyword = new KeywordImpl();
    return keyword;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Scanner_Rule createScanner_Rule()
  {
    Scanner_RuleImpl scanner_Rule = new Scanner_RuleImpl();
    return scanner_Rule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Scanner_SingleLineRule createScanner_SingleLineRule()
  {
    Scanner_SingleLineRuleImpl scanner_SingleLineRule = new Scanner_SingleLineRuleImpl();
    return scanner_SingleLineRule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Scanner_MultiLineRule createScanner_MultiLineRule()
  {
    Scanner_MultiLineRuleImpl scanner_MultiLineRule = new Scanner_MultiLineRuleImpl();
    return scanner_MultiLineRule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Scanner_PatternRule createScanner_PatternRule()
  {
    Scanner_PatternRuleImpl scanner_PatternRule = new Scanner_PatternRuleImpl();
    return scanner_PatternRule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Scanner_CharacterRule createScanner_CharacterRule()
  {
    Scanner_CharacterRuleImpl scanner_CharacterRule = new Scanner_CharacterRuleImpl();
    return scanner_CharacterRule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Scanner_JSRule createScanner_JSRule()
  {
    Scanner_JSRuleImpl scanner_JSRule = new Scanner_JSRuleImpl();
    return scanner_JSRule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Check createCheck()
  {
    CheckImpl check = new CheckImpl();
    return check;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Equals createEquals()
  {
    EqualsImpl equals = new EqualsImpl();
    return equals;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Range createRange()
  {
    RangeImpl range = new RangeImpl();
    return range;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public WhitespaceRule createWhitespaceRule()
  {
    WhitespaceRuleImpl whitespaceRule = new WhitespaceRuleImpl();
    return whitespaceRule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LDefPackage getLDefPackage()
  {
    return (LDefPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static LDefPackage getPackage()
  {
    return LDefPackage.eINSTANCE;
  }

} //LDefFactoryImpl
