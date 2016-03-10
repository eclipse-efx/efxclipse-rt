/**
 */
package org.eclipse.fx.code.editor.ldef.lDef.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.fx.code.editor.ldef.lDef.Check;
import org.eclipse.fx.code.editor.ldef.lDef.CodeIntegration;
import org.eclipse.fx.code.editor.ldef.lDef.Codegeneration;
import org.eclipse.fx.code.editor.ldef.lDef.ConfigValue;
import org.eclipse.fx.code.editor.ldef.lDef.E4CodeGeneration;
import org.eclipse.fx.code.editor.ldef.lDef.Equals;
import org.eclipse.fx.code.editor.ldef.lDef.Import;
import org.eclipse.fx.code.editor.ldef.lDef.Integration;
import org.eclipse.fx.code.editor.ldef.lDef.JavaCodeGeneration;
import org.eclipse.fx.code.editor.ldef.lDef.JavaFXIntegration;
import org.eclipse.fx.code.editor.ldef.lDef.Keyword;
import org.eclipse.fx.code.editor.ldef.lDef.LDefFactory;
import org.eclipse.fx.code.editor.ldef.lDef.LDefPackage;
import org.eclipse.fx.code.editor.ldef.lDef.LanguageDef;
import org.eclipse.fx.code.editor.ldef.lDef.LexicalHighlighting;
import org.eclipse.fx.code.editor.ldef.lDef.LexicalPartitionHighlighting;
import org.eclipse.fx.code.editor.ldef.lDef.LexicalPartitionHighlighting_JS;
import org.eclipse.fx.code.editor.ldef.lDef.LexicalPartitionHighlighting_Rule;
import org.eclipse.fx.code.editor.ldef.lDef.Paritioner_JS;
import org.eclipse.fx.code.editor.ldef.lDef.Paritioning;
import org.eclipse.fx.code.editor.ldef.lDef.Partition;
import org.eclipse.fx.code.editor.ldef.lDef.Partition_MultiLineRule;
import org.eclipse.fx.code.editor.ldef.lDef.Partition_Rule;
import org.eclipse.fx.code.editor.ldef.lDef.Partition_SingleLineRule;
import org.eclipse.fx.code.editor.ldef.lDef.Partitioner;
import org.eclipse.fx.code.editor.ldef.lDef.Partitioner_Rule;
import org.eclipse.fx.code.editor.ldef.lDef.Range;
import org.eclipse.fx.code.editor.ldef.lDef.Root;
import org.eclipse.fx.code.editor.ldef.lDef.Scanner;
import org.eclipse.fx.code.editor.ldef.lDef.ScannerCondition;
import org.eclipse.fx.code.editor.ldef.lDef.ScannerConditionComposite;
import org.eclipse.fx.code.editor.ldef.lDef.ScannerConditionCompositeElement;
import org.eclipse.fx.code.editor.ldef.lDef.ScannerConditionEquals;
import org.eclipse.fx.code.editor.ldef.lDef.ScannerConditionExits;
import org.eclipse.fx.code.editor.ldef.lDef.ScannerConditionJs;
import org.eclipse.fx.code.editor.ldef.lDef.Scanner_CharacterRule;
import org.eclipse.fx.code.editor.ldef.lDef.Scanner_JSRule;
import org.eclipse.fx.code.editor.ldef.lDef.Scanner_Keyword;
import org.eclipse.fx.code.editor.ldef.lDef.Scanner_MultiLineRule;
import org.eclipse.fx.code.editor.ldef.lDef.Scanner_PatternRule;
import org.eclipse.fx.code.editor.ldef.lDef.Scanner_Rule;
import org.eclipse.fx.code.editor.ldef.lDef.Scanner_SingleLineRule;
import org.eclipse.fx.code.editor.ldef.lDef.Token;
import org.eclipse.fx.code.editor.ldef.lDef.TokenVisual;
import org.eclipse.fx.code.editor.ldef.lDef.TokenVisuals;
import org.eclipse.fx.code.editor.ldef.lDef.WhitespaceRule;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class LDefPackageImpl extends EPackageImpl implements LDefPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass rootEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass importEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass languageDefEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass integrationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass codeIntegrationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass javaFXIntegrationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass codegenerationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass javaCodeGenerationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass e4CodeGenerationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass configValueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass paritioningEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass partitionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass partitionerEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass paritioner_JSEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass partitioner_RuleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass partition_RuleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass partition_SingleLineRuleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass partition_MultiLineRuleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass lexicalHighlightingEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass tokenVisualsEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass tokenVisualEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass lexicalPartitionHighlightingEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass lexicalPartitionHighlighting_JSEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass lexicalPartitionHighlighting_RuleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass tokenEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass scannerEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass scanner_KeywordEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass keywordEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass scanner_RuleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass scanner_SingleLineRuleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass scanner_MultiLineRuleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass scanner_PatternRuleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass scanner_CharacterRuleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass scanner_JSRuleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass scannerConditionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass scannerConditionCompositeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass scannerConditionCompositeElementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass scannerConditionExitsEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass scannerConditionEqualsEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass scannerConditionJsEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass checkEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass equalsEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass rangeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass whitespaceRuleEClass = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see org.eclipse.fx.code.editor.ldef.lDef.LDefPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private LDefPackageImpl()
  {
    super(eNS_URI, LDefFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link LDefPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static LDefPackage init()
  {
    if (isInited) return (LDefPackage)EPackage.Registry.INSTANCE.getEPackage(LDefPackage.eNS_URI);

    // Obtain or create and register package
    LDefPackageImpl theLDefPackage = (LDefPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof LDefPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new LDefPackageImpl());

    isInited = true;

    // Create package meta-data objects
    theLDefPackage.createPackageContents();

    // Initialize created meta-data
    theLDefPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theLDefPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(LDefPackage.eNS_URI, theLDefPackage);
    return theLDefPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRoot()
  {
    return rootEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRoot_Name()
  {
    return (EAttribute)rootEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRoot_Imports()
  {
    return (EReference)rootEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRoot_LanguageDefinition()
  {
    return (EReference)rootEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getImport()
  {
    return importEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getImport_ImportedNamespace()
  {
    return (EAttribute)importEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLanguageDef()
  {
    return languageDefEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLanguageDef_Name()
  {
    return (EAttribute)languageDefEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLanguageDef_Paritioning()
  {
    return (EReference)languageDefEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLanguageDef_LexicalHighlighting()
  {
    return (EReference)languageDefEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLanguageDef_Integration()
  {
    return (EReference)languageDefEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIntegration()
  {
    return integrationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIntegration_CodeIntegrationList()
  {
    return (EReference)integrationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCodeIntegration()
  {
    return codeIntegrationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getJavaFXIntegration()
  {
    return javaFXIntegrationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getJavaFXIntegration_CodegenerationList()
  {
    return (EReference)javaFXIntegrationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCodegeneration()
  {
    return codegenerationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCodegeneration_Name()
  {
    return (EAttribute)codegenerationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCodegeneration_ConfigValue()
  {
    return (EReference)codegenerationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getJavaCodeGeneration()
  {
    return javaCodeGenerationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getE4CodeGeneration()
  {
    return e4CodeGenerationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getConfigValue()
  {
    return configValueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getConfigValue_Key()
  {
    return (EAttribute)configValueEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getConfigValue_SimpleValue()
  {
    return (EAttribute)configValueEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConfigValue_Children()
  {
    return (EReference)configValueEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getParitioning()
  {
    return paritioningEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getParitioning_Partitions()
  {
    return (EReference)paritioningEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getParitioning_Partitioner()
  {
    return (EReference)paritioningEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPartition()
  {
    return partitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPartition_Name()
  {
    return (EAttribute)partitionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPartitioner()
  {
    return partitionerEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getParitioner_JS()
  {
    return paritioner_JSEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getParitioner_JS_ScriptURI()
  {
    return (EAttribute)paritioner_JSEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPartitioner_Rule()
  {
    return partitioner_RuleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPartitioner_Rule_RuleList()
  {
    return (EReference)partitioner_RuleEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPartition_Rule()
  {
    return partition_RuleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPartition_Rule_Parition()
  {
    return (EReference)partition_RuleEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPartition_Rule_StartSeq()
  {
    return (EAttribute)partition_RuleEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPartition_Rule_Check()
  {
    return (EReference)partition_RuleEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPartition_Rule_EndSeq()
  {
    return (EAttribute)partition_RuleEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPartition_Rule_EscapeSeq()
  {
    return (EAttribute)partition_RuleEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPartition_SingleLineRule()
  {
    return partition_SingleLineRuleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPartition_MultiLineRule()
  {
    return partition_MultiLineRuleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLexicalHighlighting()
  {
    return lexicalHighlightingEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLexicalHighlighting_List()
  {
    return (EReference)lexicalHighlightingEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLexicalHighlighting_Vistual()
  {
    return (EReference)lexicalHighlightingEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTokenVisuals()
  {
    return tokenVisualsEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTokenVisuals_TokenVisuals()
  {
    return (EReference)tokenVisualsEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTokenVisual()
  {
    return tokenVisualEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTokenVisual_Token()
  {
    return (EReference)tokenVisualEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTokenVisual_ColorSpec()
  {
    return (EAttribute)tokenVisualEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTokenVisual_Bold()
  {
    return (EAttribute)tokenVisualEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTokenVisual_Italic()
  {
    return (EAttribute)tokenVisualEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLexicalPartitionHighlighting()
  {
    return lexicalPartitionHighlightingEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLexicalPartitionHighlighting_Partition()
  {
    return (EReference)lexicalPartitionHighlightingEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLexicalPartitionHighlighting_JS()
  {
    return lexicalPartitionHighlighting_JSEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLexicalPartitionHighlighting_JS_ScriptURI()
  {
    return (EAttribute)lexicalPartitionHighlighting_JSEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLexicalPartitionHighlighting_Rule()
  {
    return lexicalPartitionHighlighting_RuleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLexicalPartitionHighlighting_Rule_Whitespace()
  {
    return (EReference)lexicalPartitionHighlighting_RuleEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLexicalPartitionHighlighting_Rule_TokenList()
  {
    return (EReference)lexicalPartitionHighlighting_RuleEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getToken()
  {
    return tokenEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getToken_Default()
  {
    return (EAttribute)tokenEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getToken_Name()
  {
    return (EAttribute)tokenEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getToken_ScannerList()
  {
    return (EReference)tokenEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getScanner()
  {
    return scannerEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getScanner_Keyword()
  {
    return scanner_KeywordEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getScanner_Keyword_Keywords()
  {
    return (EReference)scanner_KeywordEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getKeyword()
  {
    return keywordEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getKeyword_Name()
  {
    return (EAttribute)keywordEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getKeyword_Version()
  {
    return (EAttribute)keywordEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getScanner_Rule()
  {
    return scanner_RuleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getScanner_Rule_Check()
  {
    return (EReference)scanner_RuleEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getScanner_SingleLineRule()
  {
    return scanner_SingleLineRuleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getScanner_SingleLineRule_StartSeq()
  {
    return (EAttribute)scanner_SingleLineRuleEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getScanner_SingleLineRule_EndSeq()
  {
    return (EAttribute)scanner_SingleLineRuleEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getScanner_SingleLineRule_EscapeSeq()
  {
    return (EAttribute)scanner_SingleLineRuleEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getScanner_SingleLineRule_EnabledIf()
  {
    return (EReference)scanner_SingleLineRuleEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getScanner_MultiLineRule()
  {
    return scanner_MultiLineRuleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getScanner_MultiLineRule_StartSeq()
  {
    return (EAttribute)scanner_MultiLineRuleEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getScanner_MultiLineRule_EndSeq()
  {
    return (EAttribute)scanner_MultiLineRuleEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getScanner_MultiLineRule_EscapeSeq()
  {
    return (EAttribute)scanner_MultiLineRuleEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getScanner_MultiLineRule_EnabledIf()
  {
    return (EReference)scanner_MultiLineRuleEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getScanner_PatternRule()
  {
    return scanner_PatternRuleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getScanner_PatternRule_StartPattern()
  {
    return (EAttribute)scanner_PatternRuleEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getScanner_PatternRule_Length()
  {
    return (EAttribute)scanner_PatternRuleEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getScanner_PatternRule_ContentPattern()
  {
    return (EAttribute)scanner_PatternRuleEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getScanner_PatternRule_EnabledIf()
  {
    return (EReference)scanner_PatternRuleEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getScanner_CharacterRule()
  {
    return scanner_CharacterRuleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getScanner_CharacterRule_Characters()
  {
    return (EAttribute)scanner_CharacterRuleEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getScanner_CharacterRule_EnabledIf()
  {
    return (EReference)scanner_CharacterRuleEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getScanner_JSRule()
  {
    return scanner_JSRuleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getScanner_JSRule_FileURI()
  {
    return (EAttribute)scanner_JSRuleEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getScanner_JSRule_Condition()
  {
    return (EReference)scanner_JSRuleEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getScannerCondition()
  {
    return scannerConditionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getScannerConditionComposite()
  {
    return scannerConditionCompositeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getScannerConditionComposite_Prim()
  {
    return (EReference)scannerConditionCompositeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getScannerConditionComposite_Secondary()
  {
    return (EReference)scannerConditionCompositeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getScannerConditionCompositeElement()
  {
    return scannerConditionCompositeElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getScannerConditionCompositeElement_Op()
  {
    return (EAttribute)scannerConditionCompositeElementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getScannerConditionCompositeElement_Condition()
  {
    return (EReference)scannerConditionCompositeElementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getScannerConditionExits()
  {
    return scannerConditionExitsEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getScannerConditionExits_Key()
  {
    return (EAttribute)scannerConditionExitsEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getScannerConditionEquals()
  {
    return scannerConditionEqualsEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getScannerConditionEquals_Key()
  {
    return (EAttribute)scannerConditionEqualsEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getScannerConditionEquals_Value()
  {
    return (EAttribute)scannerConditionEqualsEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getScannerConditionJs()
  {
    return scannerConditionJsEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getScannerConditionJs_Value()
  {
    return (EAttribute)scannerConditionJsEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCheck()
  {
    return checkEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEquals()
  {
    return equalsEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getEquals_Value()
  {
    return (EAttribute)equalsEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRange()
  {
    return rangeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRange_LtIncl()
  {
    return (EAttribute)rangeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRange_MinValue()
  {
    return (EAttribute)rangeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRange_MaxValue()
  {
    return (EAttribute)rangeEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRange_GtIncl()
  {
    return (EAttribute)rangeEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getWhitespaceRule()
  {
    return whitespaceRuleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getWhitespaceRule_Characters()
  {
    return (EAttribute)whitespaceRuleEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getWhitespaceRule_Javawhitespace()
  {
    return (EAttribute)whitespaceRuleEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getWhitespaceRule_FileURI()
  {
    return (EAttribute)whitespaceRuleEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LDefFactory getLDefFactory()
  {
    return (LDefFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    rootEClass = createEClass(ROOT);
    createEAttribute(rootEClass, ROOT__NAME);
    createEReference(rootEClass, ROOT__IMPORTS);
    createEReference(rootEClass, ROOT__LANGUAGE_DEFINITION);

    importEClass = createEClass(IMPORT);
    createEAttribute(importEClass, IMPORT__IMPORTED_NAMESPACE);

    languageDefEClass = createEClass(LANGUAGE_DEF);
    createEAttribute(languageDefEClass, LANGUAGE_DEF__NAME);
    createEReference(languageDefEClass, LANGUAGE_DEF__PARITIONING);
    createEReference(languageDefEClass, LANGUAGE_DEF__LEXICAL_HIGHLIGHTING);
    createEReference(languageDefEClass, LANGUAGE_DEF__INTEGRATION);

    integrationEClass = createEClass(INTEGRATION);
    createEReference(integrationEClass, INTEGRATION__CODE_INTEGRATION_LIST);

    codeIntegrationEClass = createEClass(CODE_INTEGRATION);

    javaFXIntegrationEClass = createEClass(JAVA_FX_INTEGRATION);
    createEReference(javaFXIntegrationEClass, JAVA_FX_INTEGRATION__CODEGENERATION_LIST);

    codegenerationEClass = createEClass(CODEGENERATION);
    createEAttribute(codegenerationEClass, CODEGENERATION__NAME);
    createEReference(codegenerationEClass, CODEGENERATION__CONFIG_VALUE);

    javaCodeGenerationEClass = createEClass(JAVA_CODE_GENERATION);

    e4CodeGenerationEClass = createEClass(E4_CODE_GENERATION);

    configValueEClass = createEClass(CONFIG_VALUE);
    createEAttribute(configValueEClass, CONFIG_VALUE__KEY);
    createEAttribute(configValueEClass, CONFIG_VALUE__SIMPLE_VALUE);
    createEReference(configValueEClass, CONFIG_VALUE__CHILDREN);

    paritioningEClass = createEClass(PARITIONING);
    createEReference(paritioningEClass, PARITIONING__PARTITIONS);
    createEReference(paritioningEClass, PARITIONING__PARTITIONER);

    partitionEClass = createEClass(PARTITION);
    createEAttribute(partitionEClass, PARTITION__NAME);

    partitionerEClass = createEClass(PARTITIONER);

    paritioner_JSEClass = createEClass(PARITIONER_JS);
    createEAttribute(paritioner_JSEClass, PARITIONER_JS__SCRIPT_URI);

    partitioner_RuleEClass = createEClass(PARTITIONER_RULE);
    createEReference(partitioner_RuleEClass, PARTITIONER_RULE__RULE_LIST);

    partition_RuleEClass = createEClass(PARTITION_RULE);
    createEReference(partition_RuleEClass, PARTITION_RULE__PARITION);
    createEAttribute(partition_RuleEClass, PARTITION_RULE__START_SEQ);
    createEReference(partition_RuleEClass, PARTITION_RULE__CHECK);
    createEAttribute(partition_RuleEClass, PARTITION_RULE__END_SEQ);
    createEAttribute(partition_RuleEClass, PARTITION_RULE__ESCAPE_SEQ);

    partition_SingleLineRuleEClass = createEClass(PARTITION_SINGLE_LINE_RULE);

    partition_MultiLineRuleEClass = createEClass(PARTITION_MULTI_LINE_RULE);

    lexicalHighlightingEClass = createEClass(LEXICAL_HIGHLIGHTING);
    createEReference(lexicalHighlightingEClass, LEXICAL_HIGHLIGHTING__LIST);
    createEReference(lexicalHighlightingEClass, LEXICAL_HIGHLIGHTING__VISTUAL);

    tokenVisualsEClass = createEClass(TOKEN_VISUALS);
    createEReference(tokenVisualsEClass, TOKEN_VISUALS__TOKEN_VISUALS);

    tokenVisualEClass = createEClass(TOKEN_VISUAL);
    createEReference(tokenVisualEClass, TOKEN_VISUAL__TOKEN);
    createEAttribute(tokenVisualEClass, TOKEN_VISUAL__COLOR_SPEC);
    createEAttribute(tokenVisualEClass, TOKEN_VISUAL__BOLD);
    createEAttribute(tokenVisualEClass, TOKEN_VISUAL__ITALIC);

    lexicalPartitionHighlightingEClass = createEClass(LEXICAL_PARTITION_HIGHLIGHTING);
    createEReference(lexicalPartitionHighlightingEClass, LEXICAL_PARTITION_HIGHLIGHTING__PARTITION);

    lexicalPartitionHighlighting_JSEClass = createEClass(LEXICAL_PARTITION_HIGHLIGHTING_JS);
    createEAttribute(lexicalPartitionHighlighting_JSEClass, LEXICAL_PARTITION_HIGHLIGHTING_JS__SCRIPT_URI);

    lexicalPartitionHighlighting_RuleEClass = createEClass(LEXICAL_PARTITION_HIGHLIGHTING_RULE);
    createEReference(lexicalPartitionHighlighting_RuleEClass, LEXICAL_PARTITION_HIGHLIGHTING_RULE__WHITESPACE);
    createEReference(lexicalPartitionHighlighting_RuleEClass, LEXICAL_PARTITION_HIGHLIGHTING_RULE__TOKEN_LIST);

    tokenEClass = createEClass(TOKEN);
    createEAttribute(tokenEClass, TOKEN__DEFAULT);
    createEAttribute(tokenEClass, TOKEN__NAME);
    createEReference(tokenEClass, TOKEN__SCANNER_LIST);

    scannerEClass = createEClass(SCANNER);

    scanner_KeywordEClass = createEClass(SCANNER_KEYWORD);
    createEReference(scanner_KeywordEClass, SCANNER_KEYWORD__KEYWORDS);

    keywordEClass = createEClass(KEYWORD);
    createEAttribute(keywordEClass, KEYWORD__NAME);
    createEAttribute(keywordEClass, KEYWORD__VERSION);

    scanner_RuleEClass = createEClass(SCANNER_RULE);
    createEReference(scanner_RuleEClass, SCANNER_RULE__CHECK);

    scanner_SingleLineRuleEClass = createEClass(SCANNER_SINGLE_LINE_RULE);
    createEAttribute(scanner_SingleLineRuleEClass, SCANNER_SINGLE_LINE_RULE__START_SEQ);
    createEAttribute(scanner_SingleLineRuleEClass, SCANNER_SINGLE_LINE_RULE__END_SEQ);
    createEAttribute(scanner_SingleLineRuleEClass, SCANNER_SINGLE_LINE_RULE__ESCAPE_SEQ);
    createEReference(scanner_SingleLineRuleEClass, SCANNER_SINGLE_LINE_RULE__ENABLED_IF);

    scanner_MultiLineRuleEClass = createEClass(SCANNER_MULTI_LINE_RULE);
    createEAttribute(scanner_MultiLineRuleEClass, SCANNER_MULTI_LINE_RULE__START_SEQ);
    createEAttribute(scanner_MultiLineRuleEClass, SCANNER_MULTI_LINE_RULE__END_SEQ);
    createEAttribute(scanner_MultiLineRuleEClass, SCANNER_MULTI_LINE_RULE__ESCAPE_SEQ);
    createEReference(scanner_MultiLineRuleEClass, SCANNER_MULTI_LINE_RULE__ENABLED_IF);

    scanner_PatternRuleEClass = createEClass(SCANNER_PATTERN_RULE);
    createEAttribute(scanner_PatternRuleEClass, SCANNER_PATTERN_RULE__START_PATTERN);
    createEAttribute(scanner_PatternRuleEClass, SCANNER_PATTERN_RULE__LENGTH);
    createEAttribute(scanner_PatternRuleEClass, SCANNER_PATTERN_RULE__CONTENT_PATTERN);
    createEReference(scanner_PatternRuleEClass, SCANNER_PATTERN_RULE__ENABLED_IF);

    scanner_CharacterRuleEClass = createEClass(SCANNER_CHARACTER_RULE);
    createEAttribute(scanner_CharacterRuleEClass, SCANNER_CHARACTER_RULE__CHARACTERS);
    createEReference(scanner_CharacterRuleEClass, SCANNER_CHARACTER_RULE__ENABLED_IF);

    scanner_JSRuleEClass = createEClass(SCANNER_JS_RULE);
    createEAttribute(scanner_JSRuleEClass, SCANNER_JS_RULE__FILE_URI);
    createEReference(scanner_JSRuleEClass, SCANNER_JS_RULE__CONDITION);

    scannerConditionEClass = createEClass(SCANNER_CONDITION);

    scannerConditionCompositeEClass = createEClass(SCANNER_CONDITION_COMPOSITE);
    createEReference(scannerConditionCompositeEClass, SCANNER_CONDITION_COMPOSITE__PRIM);
    createEReference(scannerConditionCompositeEClass, SCANNER_CONDITION_COMPOSITE__SECONDARY);

    scannerConditionCompositeElementEClass = createEClass(SCANNER_CONDITION_COMPOSITE_ELEMENT);
    createEAttribute(scannerConditionCompositeElementEClass, SCANNER_CONDITION_COMPOSITE_ELEMENT__OP);
    createEReference(scannerConditionCompositeElementEClass, SCANNER_CONDITION_COMPOSITE_ELEMENT__CONDITION);

    scannerConditionExitsEClass = createEClass(SCANNER_CONDITION_EXITS);
    createEAttribute(scannerConditionExitsEClass, SCANNER_CONDITION_EXITS__KEY);

    scannerConditionEqualsEClass = createEClass(SCANNER_CONDITION_EQUALS);
    createEAttribute(scannerConditionEqualsEClass, SCANNER_CONDITION_EQUALS__KEY);
    createEAttribute(scannerConditionEqualsEClass, SCANNER_CONDITION_EQUALS__VALUE);

    scannerConditionJsEClass = createEClass(SCANNER_CONDITION_JS);
    createEAttribute(scannerConditionJsEClass, SCANNER_CONDITION_JS__VALUE);

    checkEClass = createEClass(CHECK);

    equalsEClass = createEClass(EQUALS);
    createEAttribute(equalsEClass, EQUALS__VALUE);

    rangeEClass = createEClass(RANGE);
    createEAttribute(rangeEClass, RANGE__LT_INCL);
    createEAttribute(rangeEClass, RANGE__MIN_VALUE);
    createEAttribute(rangeEClass, RANGE__MAX_VALUE);
    createEAttribute(rangeEClass, RANGE__GT_INCL);

    whitespaceRuleEClass = createEClass(WHITESPACE_RULE);
    createEAttribute(whitespaceRuleEClass, WHITESPACE_RULE__CHARACTERS);
    createEAttribute(whitespaceRuleEClass, WHITESPACE_RULE__JAVAWHITESPACE);
    createEAttribute(whitespaceRuleEClass, WHITESPACE_RULE__FILE_URI);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    javaFXIntegrationEClass.getESuperTypes().add(this.getCodeIntegration());
    javaCodeGenerationEClass.getESuperTypes().add(this.getCodegeneration());
    e4CodeGenerationEClass.getESuperTypes().add(this.getCodegeneration());
    paritioner_JSEClass.getESuperTypes().add(this.getPartitioner());
    partitioner_RuleEClass.getESuperTypes().add(this.getPartitioner());
    partition_SingleLineRuleEClass.getESuperTypes().add(this.getPartition_Rule());
    partition_MultiLineRuleEClass.getESuperTypes().add(this.getPartition_Rule());
    lexicalPartitionHighlighting_JSEClass.getESuperTypes().add(this.getLexicalPartitionHighlighting());
    lexicalPartitionHighlighting_RuleEClass.getESuperTypes().add(this.getLexicalPartitionHighlighting());
    scanner_KeywordEClass.getESuperTypes().add(this.getScanner());
    scanner_RuleEClass.getESuperTypes().add(this.getScanner());
    scanner_SingleLineRuleEClass.getESuperTypes().add(this.getScanner_Rule());
    scanner_MultiLineRuleEClass.getESuperTypes().add(this.getScanner_Rule());
    scanner_PatternRuleEClass.getESuperTypes().add(this.getScanner_Rule());
    scanner_CharacterRuleEClass.getESuperTypes().add(this.getScanner_Rule());
    scanner_JSRuleEClass.getESuperTypes().add(this.getScanner_Rule());
    scannerConditionCompositeEClass.getESuperTypes().add(this.getScannerCondition());
    scannerConditionExitsEClass.getESuperTypes().add(this.getScannerCondition());
    scannerConditionEqualsEClass.getESuperTypes().add(this.getScannerCondition());
    scannerConditionJsEClass.getESuperTypes().add(this.getScannerCondition());
    equalsEClass.getESuperTypes().add(this.getCheck());
    rangeEClass.getESuperTypes().add(this.getCheck());

    // Initialize classes and features; add operations and parameters
    initEClass(rootEClass, Root.class, "Root", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getRoot_Name(), ecorePackage.getEString(), "name", null, 0, 1, Root.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRoot_Imports(), this.getImport(), null, "imports", null, 0, -1, Root.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRoot_LanguageDefinition(), this.getLanguageDef(), null, "languageDefinition", null, 0, 1, Root.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(importEClass, Import.class, "Import", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getImport_ImportedNamespace(), ecorePackage.getEString(), "importedNamespace", null, 0, 1, Import.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(languageDefEClass, LanguageDef.class, "LanguageDef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getLanguageDef_Name(), ecorePackage.getEString(), "name", null, 0, 1, LanguageDef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLanguageDef_Paritioning(), this.getParitioning(), null, "paritioning", null, 0, 1, LanguageDef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLanguageDef_LexicalHighlighting(), this.getLexicalHighlighting(), null, "lexicalHighlighting", null, 0, 1, LanguageDef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLanguageDef_Integration(), this.getIntegration(), null, "integration", null, 0, 1, LanguageDef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(integrationEClass, Integration.class, "Integration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getIntegration_CodeIntegrationList(), this.getCodeIntegration(), null, "codeIntegrationList", null, 0, -1, Integration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(codeIntegrationEClass, CodeIntegration.class, "CodeIntegration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(javaFXIntegrationEClass, JavaFXIntegration.class, "JavaFXIntegration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getJavaFXIntegration_CodegenerationList(), this.getCodegeneration(), null, "codegenerationList", null, 0, -1, JavaFXIntegration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(codegenerationEClass, Codegeneration.class, "Codegeneration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getCodegeneration_Name(), ecorePackage.getEString(), "name", null, 0, 1, Codegeneration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCodegeneration_ConfigValue(), this.getConfigValue(), null, "configValue", null, 0, -1, Codegeneration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(javaCodeGenerationEClass, JavaCodeGeneration.class, "JavaCodeGeneration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(e4CodeGenerationEClass, E4CodeGeneration.class, "E4CodeGeneration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(configValueEClass, ConfigValue.class, "ConfigValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getConfigValue_Key(), ecorePackage.getEString(), "key", null, 0, 1, ConfigValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getConfigValue_SimpleValue(), ecorePackage.getEString(), "simpleValue", null, 0, 1, ConfigValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getConfigValue_Children(), this.getConfigValue(), null, "children", null, 0, -1, ConfigValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(paritioningEClass, Paritioning.class, "Paritioning", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getParitioning_Partitions(), this.getPartition(), null, "partitions", null, 0, -1, Paritioning.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getParitioning_Partitioner(), this.getPartitioner(), null, "partitioner", null, 0, 1, Paritioning.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(partitionEClass, Partition.class, "Partition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getPartition_Name(), ecorePackage.getEString(), "name", null, 0, 1, Partition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(partitionerEClass, Partitioner.class, "Partitioner", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(paritioner_JSEClass, Paritioner_JS.class, "Paritioner_JS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getParitioner_JS_ScriptURI(), ecorePackage.getEString(), "scriptURI", null, 0, 1, Paritioner_JS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(partitioner_RuleEClass, Partitioner_Rule.class, "Partitioner_Rule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getPartitioner_Rule_RuleList(), this.getPartition_Rule(), null, "ruleList", null, 0, -1, Partitioner_Rule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(partition_RuleEClass, Partition_Rule.class, "Partition_Rule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getPartition_Rule_Parition(), this.getPartition(), null, "parition", null, 0, 1, Partition_Rule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getPartition_Rule_StartSeq(), ecorePackage.getEString(), "startSeq", null, 0, 1, Partition_Rule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPartition_Rule_Check(), this.getCheck(), null, "check", null, 0, 1, Partition_Rule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getPartition_Rule_EndSeq(), ecorePackage.getEString(), "endSeq", null, 0, 1, Partition_Rule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getPartition_Rule_EscapeSeq(), ecorePackage.getEString(), "escapeSeq", null, 0, 1, Partition_Rule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(partition_SingleLineRuleEClass, Partition_SingleLineRule.class, "Partition_SingleLineRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(partition_MultiLineRuleEClass, Partition_MultiLineRule.class, "Partition_MultiLineRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(lexicalHighlightingEClass, LexicalHighlighting.class, "LexicalHighlighting", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getLexicalHighlighting_List(), this.getLexicalPartitionHighlighting(), null, "list", null, 0, -1, LexicalHighlighting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLexicalHighlighting_Vistual(), this.getTokenVisuals(), null, "vistual", null, 0, 1, LexicalHighlighting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(tokenVisualsEClass, TokenVisuals.class, "TokenVisuals", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTokenVisuals_TokenVisuals(), this.getTokenVisual(), null, "tokenVisuals", null, 0, -1, TokenVisuals.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(tokenVisualEClass, TokenVisual.class, "TokenVisual", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTokenVisual_Token(), this.getToken(), null, "token", null, 0, 1, TokenVisual.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTokenVisual_ColorSpec(), ecorePackage.getEString(), "colorSpec", null, 0, 1, TokenVisual.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTokenVisual_Bold(), ecorePackage.getEBoolean(), "bold", null, 0, 1, TokenVisual.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTokenVisual_Italic(), ecorePackage.getEBoolean(), "italic", null, 0, 1, TokenVisual.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(lexicalPartitionHighlightingEClass, LexicalPartitionHighlighting.class, "LexicalPartitionHighlighting", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getLexicalPartitionHighlighting_Partition(), this.getPartition(), null, "partition", null, 0, 1, LexicalPartitionHighlighting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(lexicalPartitionHighlighting_JSEClass, LexicalPartitionHighlighting_JS.class, "LexicalPartitionHighlighting_JS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getLexicalPartitionHighlighting_JS_ScriptURI(), ecorePackage.getEString(), "scriptURI", null, 0, 1, LexicalPartitionHighlighting_JS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(lexicalPartitionHighlighting_RuleEClass, LexicalPartitionHighlighting_Rule.class, "LexicalPartitionHighlighting_Rule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getLexicalPartitionHighlighting_Rule_Whitespace(), this.getWhitespaceRule(), null, "whitespace", null, 0, 1, LexicalPartitionHighlighting_Rule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLexicalPartitionHighlighting_Rule_TokenList(), this.getToken(), null, "tokenList", null, 0, -1, LexicalPartitionHighlighting_Rule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(tokenEClass, Token.class, "Token", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getToken_Default(), ecorePackage.getEBoolean(), "default", null, 0, 1, Token.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getToken_Name(), ecorePackage.getEString(), "name", null, 0, 1, Token.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getToken_ScannerList(), this.getScanner(), null, "scannerList", null, 0, -1, Token.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(scannerEClass, Scanner.class, "Scanner", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(scanner_KeywordEClass, Scanner_Keyword.class, "Scanner_Keyword", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getScanner_Keyword_Keywords(), this.getKeyword(), null, "keywords", null, 0, -1, Scanner_Keyword.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(keywordEClass, Keyword.class, "Keyword", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getKeyword_Name(), ecorePackage.getEString(), "name", null, 0, 1, Keyword.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getKeyword_Version(), ecorePackage.getEString(), "version", null, 0, 1, Keyword.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(scanner_RuleEClass, Scanner_Rule.class, "Scanner_Rule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getScanner_Rule_Check(), this.getCheck(), null, "check", null, 0, 1, Scanner_Rule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(scanner_SingleLineRuleEClass, Scanner_SingleLineRule.class, "Scanner_SingleLineRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getScanner_SingleLineRule_StartSeq(), ecorePackage.getEString(), "startSeq", null, 0, 1, Scanner_SingleLineRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getScanner_SingleLineRule_EndSeq(), ecorePackage.getEString(), "endSeq", null, 0, 1, Scanner_SingleLineRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getScanner_SingleLineRule_EscapeSeq(), ecorePackage.getEString(), "escapeSeq", null, 0, 1, Scanner_SingleLineRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getScanner_SingleLineRule_EnabledIf(), this.getScannerCondition(), null, "enabledIf", null, 0, 1, Scanner_SingleLineRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(scanner_MultiLineRuleEClass, Scanner_MultiLineRule.class, "Scanner_MultiLineRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getScanner_MultiLineRule_StartSeq(), ecorePackage.getEString(), "startSeq", null, 0, 1, Scanner_MultiLineRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getScanner_MultiLineRule_EndSeq(), ecorePackage.getEString(), "endSeq", null, 0, 1, Scanner_MultiLineRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getScanner_MultiLineRule_EscapeSeq(), ecorePackage.getEString(), "escapeSeq", null, 0, 1, Scanner_MultiLineRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getScanner_MultiLineRule_EnabledIf(), this.getScannerCondition(), null, "enabledIf", null, 0, 1, Scanner_MultiLineRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(scanner_PatternRuleEClass, Scanner_PatternRule.class, "Scanner_PatternRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getScanner_PatternRule_StartPattern(), ecorePackage.getEString(), "startPattern", null, 0, 1, Scanner_PatternRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getScanner_PatternRule_Length(), ecorePackage.getEInt(), "length", null, 0, 1, Scanner_PatternRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getScanner_PatternRule_ContentPattern(), ecorePackage.getEString(), "contentPattern", null, 0, 1, Scanner_PatternRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getScanner_PatternRule_EnabledIf(), this.getScannerCondition(), null, "enabledIf", null, 0, 1, Scanner_PatternRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(scanner_CharacterRuleEClass, Scanner_CharacterRule.class, "Scanner_CharacterRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getScanner_CharacterRule_Characters(), ecorePackage.getEString(), "characters", null, 0, -1, Scanner_CharacterRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getScanner_CharacterRule_EnabledIf(), this.getScannerCondition(), null, "enabledIf", null, 0, 1, Scanner_CharacterRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(scanner_JSRuleEClass, Scanner_JSRule.class, "Scanner_JSRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getScanner_JSRule_FileURI(), ecorePackage.getEString(), "fileURI", null, 0, 1, Scanner_JSRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getScanner_JSRule_Condition(), this.getScannerCondition(), null, "condition", null, 0, 1, Scanner_JSRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(scannerConditionEClass, ScannerCondition.class, "ScannerCondition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(scannerConditionCompositeEClass, ScannerConditionComposite.class, "ScannerConditionComposite", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getScannerConditionComposite_Prim(), this.getScannerConditionExits(), null, "prim", null, 0, 1, ScannerConditionComposite.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getScannerConditionComposite_Secondary(), this.getScannerConditionCompositeElement(), null, "secondary", null, 0, -1, ScannerConditionComposite.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(scannerConditionCompositeElementEClass, ScannerConditionCompositeElement.class, "ScannerConditionCompositeElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getScannerConditionCompositeElement_Op(), ecorePackage.getEString(), "op", null, 0, 1, ScannerConditionCompositeElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getScannerConditionCompositeElement_Condition(), this.getScannerCondition(), null, "condition", null, 0, 1, ScannerConditionCompositeElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(scannerConditionExitsEClass, ScannerConditionExits.class, "ScannerConditionExits", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getScannerConditionExits_Key(), ecorePackage.getEString(), "key", null, 0, 1, ScannerConditionExits.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(scannerConditionEqualsEClass, ScannerConditionEquals.class, "ScannerConditionEquals", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getScannerConditionEquals_Key(), ecorePackage.getEString(), "key", null, 0, 1, ScannerConditionEquals.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getScannerConditionEquals_Value(), ecorePackage.getEString(), "value", null, 0, 1, ScannerConditionEquals.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(scannerConditionJsEClass, ScannerConditionJs.class, "ScannerConditionJs", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getScannerConditionJs_Value(), ecorePackage.getEString(), "value", null, 0, 1, ScannerConditionJs.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(checkEClass, Check.class, "Check", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(equalsEClass, Equals.class, "Equals", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getEquals_Value(), ecorePackage.getEInt(), "value", null, 0, 1, Equals.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(rangeEClass, Range.class, "Range", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getRange_LtIncl(), ecorePackage.getEString(), "ltIncl", null, 0, 1, Range.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRange_MinValue(), ecorePackage.getEInt(), "minValue", null, 0, -1, Range.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRange_MaxValue(), ecorePackage.getEInt(), "maxValue", null, 0, -1, Range.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRange_GtIncl(), ecorePackage.getEString(), "gtIncl", null, 0, 1, Range.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(whitespaceRuleEClass, WhitespaceRule.class, "WhitespaceRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getWhitespaceRule_Characters(), ecorePackage.getEString(), "characters", null, 0, -1, WhitespaceRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getWhitespaceRule_Javawhitespace(), ecorePackage.getEBoolean(), "javawhitespace", null, 0, 1, WhitespaceRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getWhitespaceRule_FileURI(), ecorePackage.getEString(), "fileURI", null, 0, 1, WhitespaceRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //LDefPackageImpl
