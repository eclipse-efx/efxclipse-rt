/**
 */
package org.eclipse.fx.code.editor.ldef.lDef;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.fx.code.editor.ldef.lDef.LDefFactory
 * @model kind="package"
 * @generated
 */
public interface LDefPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "lDef";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/fx/code/editor/ldef/LDef";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "lDef";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  LDefPackage eINSTANCE = org.eclipse.fx.code.editor.ldef.lDef.impl.LDefPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.fx.code.editor.ldef.lDef.impl.RootImpl <em>Root</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.fx.code.editor.ldef.lDef.impl.RootImpl
   * @see org.eclipse.fx.code.editor.ldef.lDef.impl.LDefPackageImpl#getRoot()
   * @generated
   */
  int ROOT = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROOT__NAME = 0;

  /**
   * The feature id for the '<em><b>Imports</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROOT__IMPORTS = 1;

  /**
   * The feature id for the '<em><b>Language Definition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROOT__LANGUAGE_DEFINITION = 2;

  /**
   * The number of structural features of the '<em>Root</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROOT_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.eclipse.fx.code.editor.ldef.lDef.impl.ImportImpl <em>Import</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.fx.code.editor.ldef.lDef.impl.ImportImpl
   * @see org.eclipse.fx.code.editor.ldef.lDef.impl.LDefPackageImpl#getImport()
   * @generated
   */
  int IMPORT = 1;

  /**
   * The feature id for the '<em><b>Imported Namespace</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPORT__IMPORTED_NAMESPACE = 0;

  /**
   * The number of structural features of the '<em>Import</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPORT_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.fx.code.editor.ldef.lDef.impl.LanguageDefImpl <em>Language Def</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.fx.code.editor.ldef.lDef.impl.LanguageDefImpl
   * @see org.eclipse.fx.code.editor.ldef.lDef.impl.LDefPackageImpl#getLanguageDef()
   * @generated
   */
  int LANGUAGE_DEF = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LANGUAGE_DEF__NAME = 0;

  /**
   * The feature id for the '<em><b>Paritioning</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LANGUAGE_DEF__PARITIONING = 1;

  /**
   * The feature id for the '<em><b>Lexical Highlighting</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LANGUAGE_DEF__LEXICAL_HIGHLIGHTING = 2;

  /**
   * The feature id for the '<em><b>Integration</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LANGUAGE_DEF__INTEGRATION = 3;

  /**
   * The number of structural features of the '<em>Language Def</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LANGUAGE_DEF_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link org.eclipse.fx.code.editor.ldef.lDef.impl.IntegrationImpl <em>Integration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.fx.code.editor.ldef.lDef.impl.IntegrationImpl
   * @see org.eclipse.fx.code.editor.ldef.lDef.impl.LDefPackageImpl#getIntegration()
   * @generated
   */
  int INTEGRATION = 3;

  /**
   * The feature id for the '<em><b>Code Integration List</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTEGRATION__CODE_INTEGRATION_LIST = 0;

  /**
   * The number of structural features of the '<em>Integration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTEGRATION_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.fx.code.editor.ldef.lDef.impl.CodeIntegrationImpl <em>Code Integration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.fx.code.editor.ldef.lDef.impl.CodeIntegrationImpl
   * @see org.eclipse.fx.code.editor.ldef.lDef.impl.LDefPackageImpl#getCodeIntegration()
   * @generated
   */
  int CODE_INTEGRATION = 4;

  /**
   * The number of structural features of the '<em>Code Integration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CODE_INTEGRATION_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipse.fx.code.editor.ldef.lDef.impl.JavaFXIntegrationImpl <em>Java FX Integration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.fx.code.editor.ldef.lDef.impl.JavaFXIntegrationImpl
   * @see org.eclipse.fx.code.editor.ldef.lDef.impl.LDefPackageImpl#getJavaFXIntegration()
   * @generated
   */
  int JAVA_FX_INTEGRATION = 5;

  /**
   * The feature id for the '<em><b>Codegeneration List</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JAVA_FX_INTEGRATION__CODEGENERATION_LIST = CODE_INTEGRATION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Java FX Integration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JAVA_FX_INTEGRATION_FEATURE_COUNT = CODE_INTEGRATION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.fx.code.editor.ldef.lDef.impl.CodegenerationImpl <em>Codegeneration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.fx.code.editor.ldef.lDef.impl.CodegenerationImpl
   * @see org.eclipse.fx.code.editor.ldef.lDef.impl.LDefPackageImpl#getCodegeneration()
   * @generated
   */
  int CODEGENERATION = 6;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CODEGENERATION__NAME = 0;

  /**
   * The feature id for the '<em><b>Config Value</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CODEGENERATION__CONFIG_VALUE = 1;

  /**
   * The number of structural features of the '<em>Codegeneration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CODEGENERATION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.fx.code.editor.ldef.lDef.impl.JavaCodeGenerationImpl <em>Java Code Generation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.fx.code.editor.ldef.lDef.impl.JavaCodeGenerationImpl
   * @see org.eclipse.fx.code.editor.ldef.lDef.impl.LDefPackageImpl#getJavaCodeGeneration()
   * @generated
   */
  int JAVA_CODE_GENERATION = 7;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JAVA_CODE_GENERATION__NAME = CODEGENERATION__NAME;

  /**
   * The feature id for the '<em><b>Config Value</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JAVA_CODE_GENERATION__CONFIG_VALUE = CODEGENERATION__CONFIG_VALUE;

  /**
   * The number of structural features of the '<em>Java Code Generation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JAVA_CODE_GENERATION_FEATURE_COUNT = CODEGENERATION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.fx.code.editor.ldef.lDef.impl.E4CodeGenerationImpl <em>E4 Code Generation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.fx.code.editor.ldef.lDef.impl.E4CodeGenerationImpl
   * @see org.eclipse.fx.code.editor.ldef.lDef.impl.LDefPackageImpl#getE4CodeGeneration()
   * @generated
   */
  int E4_CODE_GENERATION = 8;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int E4_CODE_GENERATION__NAME = CODEGENERATION__NAME;

  /**
   * The feature id for the '<em><b>Config Value</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int E4_CODE_GENERATION__CONFIG_VALUE = CODEGENERATION__CONFIG_VALUE;

  /**
   * The number of structural features of the '<em>E4 Code Generation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int E4_CODE_GENERATION_FEATURE_COUNT = CODEGENERATION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.fx.code.editor.ldef.lDef.impl.ConfigValueImpl <em>Config Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.fx.code.editor.ldef.lDef.impl.ConfigValueImpl
   * @see org.eclipse.fx.code.editor.ldef.lDef.impl.LDefPackageImpl#getConfigValue()
   * @generated
   */
  int CONFIG_VALUE = 9;

  /**
   * The feature id for the '<em><b>Key</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONFIG_VALUE__KEY = 0;

  /**
   * The feature id for the '<em><b>Simple Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONFIG_VALUE__SIMPLE_VALUE = 1;

  /**
   * The feature id for the '<em><b>Children</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONFIG_VALUE__CHILDREN = 2;

  /**
   * The number of structural features of the '<em>Config Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONFIG_VALUE_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.eclipse.fx.code.editor.ldef.lDef.impl.ParitioningImpl <em>Paritioning</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.fx.code.editor.ldef.lDef.impl.ParitioningImpl
   * @see org.eclipse.fx.code.editor.ldef.lDef.impl.LDefPackageImpl#getParitioning()
   * @generated
   */
  int PARITIONING = 10;

  /**
   * The feature id for the '<em><b>Partitions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARITIONING__PARTITIONS = 0;

  /**
   * The feature id for the '<em><b>Partitioner</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARITIONING__PARTITIONER = 1;

  /**
   * The number of structural features of the '<em>Paritioning</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARITIONING_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.fx.code.editor.ldef.lDef.impl.PartitionImpl <em>Partition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.fx.code.editor.ldef.lDef.impl.PartitionImpl
   * @see org.eclipse.fx.code.editor.ldef.lDef.impl.LDefPackageImpl#getPartition()
   * @generated
   */
  int PARTITION = 11;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARTITION__NAME = 0;

  /**
   * The number of structural features of the '<em>Partition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARTITION_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.fx.code.editor.ldef.lDef.impl.PartitionerImpl <em>Partitioner</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.fx.code.editor.ldef.lDef.impl.PartitionerImpl
   * @see org.eclipse.fx.code.editor.ldef.lDef.impl.LDefPackageImpl#getPartitioner()
   * @generated
   */
  int PARTITIONER = 12;

  /**
   * The number of structural features of the '<em>Partitioner</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARTITIONER_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipse.fx.code.editor.ldef.lDef.impl.Paritioner_JSImpl <em>Paritioner JS</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.fx.code.editor.ldef.lDef.impl.Paritioner_JSImpl
   * @see org.eclipse.fx.code.editor.ldef.lDef.impl.LDefPackageImpl#getParitioner_JS()
   * @generated
   */
  int PARITIONER_JS = 13;

  /**
   * The feature id for the '<em><b>Script URI</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARITIONER_JS__SCRIPT_URI = PARTITIONER_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Paritioner JS</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARITIONER_JS_FEATURE_COUNT = PARTITIONER_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.fx.code.editor.ldef.lDef.impl.Partitioner_RuleImpl <em>Partitioner Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.fx.code.editor.ldef.lDef.impl.Partitioner_RuleImpl
   * @see org.eclipse.fx.code.editor.ldef.lDef.impl.LDefPackageImpl#getPartitioner_Rule()
   * @generated
   */
  int PARTITIONER_RULE = 14;

  /**
   * The feature id for the '<em><b>Rule List</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARTITIONER_RULE__RULE_LIST = PARTITIONER_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Partitioner Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARTITIONER_RULE_FEATURE_COUNT = PARTITIONER_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.fx.code.editor.ldef.lDef.impl.Partition_RuleImpl <em>Partition Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.fx.code.editor.ldef.lDef.impl.Partition_RuleImpl
   * @see org.eclipse.fx.code.editor.ldef.lDef.impl.LDefPackageImpl#getPartition_Rule()
   * @generated
   */
  int PARTITION_RULE = 15;

  /**
   * The feature id for the '<em><b>Parition</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARTITION_RULE__PARITION = 0;

  /**
   * The feature id for the '<em><b>Start Seq</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARTITION_RULE__START_SEQ = 1;

  /**
   * The feature id for the '<em><b>Check</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARTITION_RULE__CHECK = 2;

  /**
   * The feature id for the '<em><b>End Seq</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARTITION_RULE__END_SEQ = 3;

  /**
   * The feature id for the '<em><b>Escape Seq</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARTITION_RULE__ESCAPE_SEQ = 4;

  /**
   * The number of structural features of the '<em>Partition Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARTITION_RULE_FEATURE_COUNT = 5;

  /**
   * The meta object id for the '{@link org.eclipse.fx.code.editor.ldef.lDef.impl.Partition_SingleLineRuleImpl <em>Partition Single Line Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.fx.code.editor.ldef.lDef.impl.Partition_SingleLineRuleImpl
   * @see org.eclipse.fx.code.editor.ldef.lDef.impl.LDefPackageImpl#getPartition_SingleLineRule()
   * @generated
   */
  int PARTITION_SINGLE_LINE_RULE = 16;

  /**
   * The feature id for the '<em><b>Parition</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARTITION_SINGLE_LINE_RULE__PARITION = PARTITION_RULE__PARITION;

  /**
   * The feature id for the '<em><b>Start Seq</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARTITION_SINGLE_LINE_RULE__START_SEQ = PARTITION_RULE__START_SEQ;

  /**
   * The feature id for the '<em><b>Check</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARTITION_SINGLE_LINE_RULE__CHECK = PARTITION_RULE__CHECK;

  /**
   * The feature id for the '<em><b>End Seq</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARTITION_SINGLE_LINE_RULE__END_SEQ = PARTITION_RULE__END_SEQ;

  /**
   * The feature id for the '<em><b>Escape Seq</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARTITION_SINGLE_LINE_RULE__ESCAPE_SEQ = PARTITION_RULE__ESCAPE_SEQ;

  /**
   * The number of structural features of the '<em>Partition Single Line Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARTITION_SINGLE_LINE_RULE_FEATURE_COUNT = PARTITION_RULE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.fx.code.editor.ldef.lDef.impl.Partition_MultiLineRuleImpl <em>Partition Multi Line Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.fx.code.editor.ldef.lDef.impl.Partition_MultiLineRuleImpl
   * @see org.eclipse.fx.code.editor.ldef.lDef.impl.LDefPackageImpl#getPartition_MultiLineRule()
   * @generated
   */
  int PARTITION_MULTI_LINE_RULE = 17;

  /**
   * The feature id for the '<em><b>Parition</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARTITION_MULTI_LINE_RULE__PARITION = PARTITION_RULE__PARITION;

  /**
   * The feature id for the '<em><b>Start Seq</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARTITION_MULTI_LINE_RULE__START_SEQ = PARTITION_RULE__START_SEQ;

  /**
   * The feature id for the '<em><b>Check</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARTITION_MULTI_LINE_RULE__CHECK = PARTITION_RULE__CHECK;

  /**
   * The feature id for the '<em><b>End Seq</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARTITION_MULTI_LINE_RULE__END_SEQ = PARTITION_RULE__END_SEQ;

  /**
   * The feature id for the '<em><b>Escape Seq</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARTITION_MULTI_LINE_RULE__ESCAPE_SEQ = PARTITION_RULE__ESCAPE_SEQ;

  /**
   * The number of structural features of the '<em>Partition Multi Line Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARTITION_MULTI_LINE_RULE_FEATURE_COUNT = PARTITION_RULE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.fx.code.editor.ldef.lDef.impl.LexicalHighlightingImpl <em>Lexical Highlighting</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.fx.code.editor.ldef.lDef.impl.LexicalHighlightingImpl
   * @see org.eclipse.fx.code.editor.ldef.lDef.impl.LDefPackageImpl#getLexicalHighlighting()
   * @generated
   */
  int LEXICAL_HIGHLIGHTING = 18;

  /**
   * The feature id for the '<em><b>List</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LEXICAL_HIGHLIGHTING__LIST = 0;

  /**
   * The number of structural features of the '<em>Lexical Highlighting</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LEXICAL_HIGHLIGHTING_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.fx.code.editor.ldef.lDef.impl.LexicalPartitionHighlightingImpl <em>Lexical Partition Highlighting</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.fx.code.editor.ldef.lDef.impl.LexicalPartitionHighlightingImpl
   * @see org.eclipse.fx.code.editor.ldef.lDef.impl.LDefPackageImpl#getLexicalPartitionHighlighting()
   * @generated
   */
  int LEXICAL_PARTITION_HIGHLIGHTING = 19;

  /**
   * The feature id for the '<em><b>Partition</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LEXICAL_PARTITION_HIGHLIGHTING__PARTITION = 0;

  /**
   * The number of structural features of the '<em>Lexical Partition Highlighting</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LEXICAL_PARTITION_HIGHLIGHTING_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.fx.code.editor.ldef.lDef.impl.LexicalPartitionHighlighting_JSImpl <em>Lexical Partition Highlighting JS</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.fx.code.editor.ldef.lDef.impl.LexicalPartitionHighlighting_JSImpl
   * @see org.eclipse.fx.code.editor.ldef.lDef.impl.LDefPackageImpl#getLexicalPartitionHighlighting_JS()
   * @generated
   */
  int LEXICAL_PARTITION_HIGHLIGHTING_JS = 20;

  /**
   * The feature id for the '<em><b>Partition</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LEXICAL_PARTITION_HIGHLIGHTING_JS__PARTITION = LEXICAL_PARTITION_HIGHLIGHTING__PARTITION;

  /**
   * The feature id for the '<em><b>Script URI</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LEXICAL_PARTITION_HIGHLIGHTING_JS__SCRIPT_URI = LEXICAL_PARTITION_HIGHLIGHTING_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Lexical Partition Highlighting JS</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LEXICAL_PARTITION_HIGHLIGHTING_JS_FEATURE_COUNT = LEXICAL_PARTITION_HIGHLIGHTING_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.fx.code.editor.ldef.lDef.impl.LexicalPartitionHighlighting_RuleImpl <em>Lexical Partition Highlighting Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.fx.code.editor.ldef.lDef.impl.LexicalPartitionHighlighting_RuleImpl
   * @see org.eclipse.fx.code.editor.ldef.lDef.impl.LDefPackageImpl#getLexicalPartitionHighlighting_Rule()
   * @generated
   */
  int LEXICAL_PARTITION_HIGHLIGHTING_RULE = 21;

  /**
   * The feature id for the '<em><b>Partition</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LEXICAL_PARTITION_HIGHLIGHTING_RULE__PARTITION = LEXICAL_PARTITION_HIGHLIGHTING__PARTITION;

  /**
   * The feature id for the '<em><b>Whitespace</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LEXICAL_PARTITION_HIGHLIGHTING_RULE__WHITESPACE = LEXICAL_PARTITION_HIGHLIGHTING_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Token List</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LEXICAL_PARTITION_HIGHLIGHTING_RULE__TOKEN_LIST = LEXICAL_PARTITION_HIGHLIGHTING_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Lexical Partition Highlighting Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LEXICAL_PARTITION_HIGHLIGHTING_RULE_FEATURE_COUNT = LEXICAL_PARTITION_HIGHLIGHTING_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.fx.code.editor.ldef.lDef.impl.TokenImpl <em>Token</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.fx.code.editor.ldef.lDef.impl.TokenImpl
   * @see org.eclipse.fx.code.editor.ldef.lDef.impl.LDefPackageImpl#getToken()
   * @generated
   */
  int TOKEN = 22;

  /**
   * The feature id for the '<em><b>Default</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TOKEN__DEFAULT = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TOKEN__NAME = 1;

  /**
   * The feature id for the '<em><b>Scanner List</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TOKEN__SCANNER_LIST = 2;

  /**
   * The number of structural features of the '<em>Token</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TOKEN_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.eclipse.fx.code.editor.ldef.lDef.impl.ScannerImpl <em>Scanner</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.fx.code.editor.ldef.lDef.impl.ScannerImpl
   * @see org.eclipse.fx.code.editor.ldef.lDef.impl.LDefPackageImpl#getScanner()
   * @generated
   */
  int SCANNER = 23;

  /**
   * The number of structural features of the '<em>Scanner</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCANNER_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipse.fx.code.editor.ldef.lDef.impl.Scanner_KeywordImpl <em>Scanner Keyword</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.fx.code.editor.ldef.lDef.impl.Scanner_KeywordImpl
   * @see org.eclipse.fx.code.editor.ldef.lDef.impl.LDefPackageImpl#getScanner_Keyword()
   * @generated
   */
  int SCANNER_KEYWORD = 24;

  /**
   * The feature id for the '<em><b>Keywords</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCANNER_KEYWORD__KEYWORDS = SCANNER_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Scanner Keyword</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCANNER_KEYWORD_FEATURE_COUNT = SCANNER_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.fx.code.editor.ldef.lDef.impl.KeywordImpl <em>Keyword</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.fx.code.editor.ldef.lDef.impl.KeywordImpl
   * @see org.eclipse.fx.code.editor.ldef.lDef.impl.LDefPackageImpl#getKeyword()
   * @generated
   */
  int KEYWORD = 25;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int KEYWORD__NAME = 0;

  /**
   * The feature id for the '<em><b>Version</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int KEYWORD__VERSION = 1;

  /**
   * The number of structural features of the '<em>Keyword</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int KEYWORD_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.fx.code.editor.ldef.lDef.impl.Scanner_RuleImpl <em>Scanner Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.fx.code.editor.ldef.lDef.impl.Scanner_RuleImpl
   * @see org.eclipse.fx.code.editor.ldef.lDef.impl.LDefPackageImpl#getScanner_Rule()
   * @generated
   */
  int SCANNER_RULE = 26;

  /**
   * The feature id for the '<em><b>Check</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCANNER_RULE__CHECK = SCANNER_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Scanner Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCANNER_RULE_FEATURE_COUNT = SCANNER_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.fx.code.editor.ldef.lDef.impl.Scanner_SingleLineRuleImpl <em>Scanner Single Line Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.fx.code.editor.ldef.lDef.impl.Scanner_SingleLineRuleImpl
   * @see org.eclipse.fx.code.editor.ldef.lDef.impl.LDefPackageImpl#getScanner_SingleLineRule()
   * @generated
   */
  int SCANNER_SINGLE_LINE_RULE = 27;

  /**
   * The feature id for the '<em><b>Check</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCANNER_SINGLE_LINE_RULE__CHECK = SCANNER_RULE__CHECK;

  /**
   * The feature id for the '<em><b>Start Seq</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCANNER_SINGLE_LINE_RULE__START_SEQ = SCANNER_RULE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>End Seq</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCANNER_SINGLE_LINE_RULE__END_SEQ = SCANNER_RULE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Escape Seq</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCANNER_SINGLE_LINE_RULE__ESCAPE_SEQ = SCANNER_RULE_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Scanner Single Line Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCANNER_SINGLE_LINE_RULE_FEATURE_COUNT = SCANNER_RULE_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.eclipse.fx.code.editor.ldef.lDef.impl.Scanner_MultiLineRuleImpl <em>Scanner Multi Line Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.fx.code.editor.ldef.lDef.impl.Scanner_MultiLineRuleImpl
   * @see org.eclipse.fx.code.editor.ldef.lDef.impl.LDefPackageImpl#getScanner_MultiLineRule()
   * @generated
   */
  int SCANNER_MULTI_LINE_RULE = 28;

  /**
   * The feature id for the '<em><b>Check</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCANNER_MULTI_LINE_RULE__CHECK = SCANNER_RULE__CHECK;

  /**
   * The feature id for the '<em><b>Start Seq</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCANNER_MULTI_LINE_RULE__START_SEQ = SCANNER_RULE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>End Seq</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCANNER_MULTI_LINE_RULE__END_SEQ = SCANNER_RULE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Escape Seq</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCANNER_MULTI_LINE_RULE__ESCAPE_SEQ = SCANNER_RULE_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Scanner Multi Line Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCANNER_MULTI_LINE_RULE_FEATURE_COUNT = SCANNER_RULE_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.eclipse.fx.code.editor.ldef.lDef.impl.Scanner_PatternRuleImpl <em>Scanner Pattern Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.fx.code.editor.ldef.lDef.impl.Scanner_PatternRuleImpl
   * @see org.eclipse.fx.code.editor.ldef.lDef.impl.LDefPackageImpl#getScanner_PatternRule()
   * @generated
   */
  int SCANNER_PATTERN_RULE = 29;

  /**
   * The feature id for the '<em><b>Check</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCANNER_PATTERN_RULE__CHECK = SCANNER_RULE__CHECK;

  /**
   * The feature id for the '<em><b>Start Pattern</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCANNER_PATTERN_RULE__START_PATTERN = SCANNER_RULE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Length</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCANNER_PATTERN_RULE__LENGTH = SCANNER_RULE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Content Pattern</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCANNER_PATTERN_RULE__CONTENT_PATTERN = SCANNER_RULE_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Scanner Pattern Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCANNER_PATTERN_RULE_FEATURE_COUNT = SCANNER_RULE_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.eclipse.fx.code.editor.ldef.lDef.impl.Scanner_CharacterRuleImpl <em>Scanner Character Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.fx.code.editor.ldef.lDef.impl.Scanner_CharacterRuleImpl
   * @see org.eclipse.fx.code.editor.ldef.lDef.impl.LDefPackageImpl#getScanner_CharacterRule()
   * @generated
   */
  int SCANNER_CHARACTER_RULE = 30;

  /**
   * The feature id for the '<em><b>Check</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCANNER_CHARACTER_RULE__CHECK = SCANNER_RULE__CHECK;

  /**
   * The feature id for the '<em><b>Characters</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCANNER_CHARACTER_RULE__CHARACTERS = SCANNER_RULE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Scanner Character Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCANNER_CHARACTER_RULE_FEATURE_COUNT = SCANNER_RULE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.fx.code.editor.ldef.lDef.impl.Scanner_JSRuleImpl <em>Scanner JS Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.fx.code.editor.ldef.lDef.impl.Scanner_JSRuleImpl
   * @see org.eclipse.fx.code.editor.ldef.lDef.impl.LDefPackageImpl#getScanner_JSRule()
   * @generated
   */
  int SCANNER_JS_RULE = 31;

  /**
   * The feature id for the '<em><b>Check</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCANNER_JS_RULE__CHECK = SCANNER_RULE__CHECK;

  /**
   * The feature id for the '<em><b>File URI</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCANNER_JS_RULE__FILE_URI = SCANNER_RULE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Scanner JS Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCANNER_JS_RULE_FEATURE_COUNT = SCANNER_RULE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.fx.code.editor.ldef.lDef.impl.CheckImpl <em>Check</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.fx.code.editor.ldef.lDef.impl.CheckImpl
   * @see org.eclipse.fx.code.editor.ldef.lDef.impl.LDefPackageImpl#getCheck()
   * @generated
   */
  int CHECK = 32;

  /**
   * The number of structural features of the '<em>Check</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHECK_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipse.fx.code.editor.ldef.lDef.impl.EqualsImpl <em>Equals</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.fx.code.editor.ldef.lDef.impl.EqualsImpl
   * @see org.eclipse.fx.code.editor.ldef.lDef.impl.LDefPackageImpl#getEquals()
   * @generated
   */
  int EQUALS = 33;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUALS__VALUE = CHECK_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Equals</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUALS_FEATURE_COUNT = CHECK_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.fx.code.editor.ldef.lDef.impl.RangeImpl <em>Range</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.fx.code.editor.ldef.lDef.impl.RangeImpl
   * @see org.eclipse.fx.code.editor.ldef.lDef.impl.LDefPackageImpl#getRange()
   * @generated
   */
  int RANGE = 34;

  /**
   * The feature id for the '<em><b>Lt Incl</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RANGE__LT_INCL = CHECK_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Min Value</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RANGE__MIN_VALUE = CHECK_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Max Value</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RANGE__MAX_VALUE = CHECK_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Gt Incl</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RANGE__GT_INCL = CHECK_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Range</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RANGE_FEATURE_COUNT = CHECK_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link org.eclipse.fx.code.editor.ldef.lDef.impl.WhitespaceRuleImpl <em>Whitespace Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.fx.code.editor.ldef.lDef.impl.WhitespaceRuleImpl
   * @see org.eclipse.fx.code.editor.ldef.lDef.impl.LDefPackageImpl#getWhitespaceRule()
   * @generated
   */
  int WHITESPACE_RULE = 35;

  /**
   * The feature id for the '<em><b>Characters</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WHITESPACE_RULE__CHARACTERS = 0;

  /**
   * The feature id for the '<em><b>Javawhitespace</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WHITESPACE_RULE__JAVAWHITESPACE = 1;

  /**
   * The feature id for the '<em><b>File URI</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WHITESPACE_RULE__FILE_URI = 2;

  /**
   * The number of structural features of the '<em>Whitespace Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WHITESPACE_RULE_FEATURE_COUNT = 3;


  /**
   * Returns the meta object for class '{@link org.eclipse.fx.code.editor.ldef.lDef.Root <em>Root</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Root</em>'.
   * @see org.eclipse.fx.code.editor.ldef.lDef.Root
   * @generated
   */
  EClass getRoot();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.fx.code.editor.ldef.lDef.Root#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.fx.code.editor.ldef.lDef.Root#getName()
   * @see #getRoot()
   * @generated
   */
  EAttribute getRoot_Name();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.fx.code.editor.ldef.lDef.Root#getImports <em>Imports</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Imports</em>'.
   * @see org.eclipse.fx.code.editor.ldef.lDef.Root#getImports()
   * @see #getRoot()
   * @generated
   */
  EReference getRoot_Imports();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.fx.code.editor.ldef.lDef.Root#getLanguageDefinition <em>Language Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Language Definition</em>'.
   * @see org.eclipse.fx.code.editor.ldef.lDef.Root#getLanguageDefinition()
   * @see #getRoot()
   * @generated
   */
  EReference getRoot_LanguageDefinition();

  /**
   * Returns the meta object for class '{@link org.eclipse.fx.code.editor.ldef.lDef.Import <em>Import</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Import</em>'.
   * @see org.eclipse.fx.code.editor.ldef.lDef.Import
   * @generated
   */
  EClass getImport();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.fx.code.editor.ldef.lDef.Import#getImportedNamespace <em>Imported Namespace</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Imported Namespace</em>'.
   * @see org.eclipse.fx.code.editor.ldef.lDef.Import#getImportedNamespace()
   * @see #getImport()
   * @generated
   */
  EAttribute getImport_ImportedNamespace();

  /**
   * Returns the meta object for class '{@link org.eclipse.fx.code.editor.ldef.lDef.LanguageDef <em>Language Def</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Language Def</em>'.
   * @see org.eclipse.fx.code.editor.ldef.lDef.LanguageDef
   * @generated
   */
  EClass getLanguageDef();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.fx.code.editor.ldef.lDef.LanguageDef#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.fx.code.editor.ldef.lDef.LanguageDef#getName()
   * @see #getLanguageDef()
   * @generated
   */
  EAttribute getLanguageDef_Name();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.fx.code.editor.ldef.lDef.LanguageDef#getParitioning <em>Paritioning</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Paritioning</em>'.
   * @see org.eclipse.fx.code.editor.ldef.lDef.LanguageDef#getParitioning()
   * @see #getLanguageDef()
   * @generated
   */
  EReference getLanguageDef_Paritioning();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.fx.code.editor.ldef.lDef.LanguageDef#getLexicalHighlighting <em>Lexical Highlighting</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Lexical Highlighting</em>'.
   * @see org.eclipse.fx.code.editor.ldef.lDef.LanguageDef#getLexicalHighlighting()
   * @see #getLanguageDef()
   * @generated
   */
  EReference getLanguageDef_LexicalHighlighting();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.fx.code.editor.ldef.lDef.LanguageDef#getIntegration <em>Integration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Integration</em>'.
   * @see org.eclipse.fx.code.editor.ldef.lDef.LanguageDef#getIntegration()
   * @see #getLanguageDef()
   * @generated
   */
  EReference getLanguageDef_Integration();

  /**
   * Returns the meta object for class '{@link org.eclipse.fx.code.editor.ldef.lDef.Integration <em>Integration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Integration</em>'.
   * @see org.eclipse.fx.code.editor.ldef.lDef.Integration
   * @generated
   */
  EClass getIntegration();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.fx.code.editor.ldef.lDef.Integration#getCodeIntegrationList <em>Code Integration List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Code Integration List</em>'.
   * @see org.eclipse.fx.code.editor.ldef.lDef.Integration#getCodeIntegrationList()
   * @see #getIntegration()
   * @generated
   */
  EReference getIntegration_CodeIntegrationList();

  /**
   * Returns the meta object for class '{@link org.eclipse.fx.code.editor.ldef.lDef.CodeIntegration <em>Code Integration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Code Integration</em>'.
   * @see org.eclipse.fx.code.editor.ldef.lDef.CodeIntegration
   * @generated
   */
  EClass getCodeIntegration();

  /**
   * Returns the meta object for class '{@link org.eclipse.fx.code.editor.ldef.lDef.JavaFXIntegration <em>Java FX Integration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Java FX Integration</em>'.
   * @see org.eclipse.fx.code.editor.ldef.lDef.JavaFXIntegration
   * @generated
   */
  EClass getJavaFXIntegration();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.fx.code.editor.ldef.lDef.JavaFXIntegration#getCodegenerationList <em>Codegeneration List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Codegeneration List</em>'.
   * @see org.eclipse.fx.code.editor.ldef.lDef.JavaFXIntegration#getCodegenerationList()
   * @see #getJavaFXIntegration()
   * @generated
   */
  EReference getJavaFXIntegration_CodegenerationList();

  /**
   * Returns the meta object for class '{@link org.eclipse.fx.code.editor.ldef.lDef.Codegeneration <em>Codegeneration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Codegeneration</em>'.
   * @see org.eclipse.fx.code.editor.ldef.lDef.Codegeneration
   * @generated
   */
  EClass getCodegeneration();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.fx.code.editor.ldef.lDef.Codegeneration#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.fx.code.editor.ldef.lDef.Codegeneration#getName()
   * @see #getCodegeneration()
   * @generated
   */
  EAttribute getCodegeneration_Name();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.fx.code.editor.ldef.lDef.Codegeneration#getConfigValue <em>Config Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Config Value</em>'.
   * @see org.eclipse.fx.code.editor.ldef.lDef.Codegeneration#getConfigValue()
   * @see #getCodegeneration()
   * @generated
   */
  EReference getCodegeneration_ConfigValue();

  /**
   * Returns the meta object for class '{@link org.eclipse.fx.code.editor.ldef.lDef.JavaCodeGeneration <em>Java Code Generation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Java Code Generation</em>'.
   * @see org.eclipse.fx.code.editor.ldef.lDef.JavaCodeGeneration
   * @generated
   */
  EClass getJavaCodeGeneration();

  /**
   * Returns the meta object for class '{@link org.eclipse.fx.code.editor.ldef.lDef.E4CodeGeneration <em>E4 Code Generation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>E4 Code Generation</em>'.
   * @see org.eclipse.fx.code.editor.ldef.lDef.E4CodeGeneration
   * @generated
   */
  EClass getE4CodeGeneration();

  /**
   * Returns the meta object for class '{@link org.eclipse.fx.code.editor.ldef.lDef.ConfigValue <em>Config Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Config Value</em>'.
   * @see org.eclipse.fx.code.editor.ldef.lDef.ConfigValue
   * @generated
   */
  EClass getConfigValue();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.fx.code.editor.ldef.lDef.ConfigValue#getKey <em>Key</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Key</em>'.
   * @see org.eclipse.fx.code.editor.ldef.lDef.ConfigValue#getKey()
   * @see #getConfigValue()
   * @generated
   */
  EAttribute getConfigValue_Key();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.fx.code.editor.ldef.lDef.ConfigValue#getSimpleValue <em>Simple Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Simple Value</em>'.
   * @see org.eclipse.fx.code.editor.ldef.lDef.ConfigValue#getSimpleValue()
   * @see #getConfigValue()
   * @generated
   */
  EAttribute getConfigValue_SimpleValue();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.fx.code.editor.ldef.lDef.ConfigValue#getChildren <em>Children</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Children</em>'.
   * @see org.eclipse.fx.code.editor.ldef.lDef.ConfigValue#getChildren()
   * @see #getConfigValue()
   * @generated
   */
  EReference getConfigValue_Children();

  /**
   * Returns the meta object for class '{@link org.eclipse.fx.code.editor.ldef.lDef.Paritioning <em>Paritioning</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Paritioning</em>'.
   * @see org.eclipse.fx.code.editor.ldef.lDef.Paritioning
   * @generated
   */
  EClass getParitioning();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.fx.code.editor.ldef.lDef.Paritioning#getPartitions <em>Partitions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Partitions</em>'.
   * @see org.eclipse.fx.code.editor.ldef.lDef.Paritioning#getPartitions()
   * @see #getParitioning()
   * @generated
   */
  EReference getParitioning_Partitions();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.fx.code.editor.ldef.lDef.Paritioning#getPartitioner <em>Partitioner</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Partitioner</em>'.
   * @see org.eclipse.fx.code.editor.ldef.lDef.Paritioning#getPartitioner()
   * @see #getParitioning()
   * @generated
   */
  EReference getParitioning_Partitioner();

  /**
   * Returns the meta object for class '{@link org.eclipse.fx.code.editor.ldef.lDef.Partition <em>Partition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Partition</em>'.
   * @see org.eclipse.fx.code.editor.ldef.lDef.Partition
   * @generated
   */
  EClass getPartition();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.fx.code.editor.ldef.lDef.Partition#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.fx.code.editor.ldef.lDef.Partition#getName()
   * @see #getPartition()
   * @generated
   */
  EAttribute getPartition_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.fx.code.editor.ldef.lDef.Partitioner <em>Partitioner</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Partitioner</em>'.
   * @see org.eclipse.fx.code.editor.ldef.lDef.Partitioner
   * @generated
   */
  EClass getPartitioner();

  /**
   * Returns the meta object for class '{@link org.eclipse.fx.code.editor.ldef.lDef.Paritioner_JS <em>Paritioner JS</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Paritioner JS</em>'.
   * @see org.eclipse.fx.code.editor.ldef.lDef.Paritioner_JS
   * @generated
   */
  EClass getParitioner_JS();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.fx.code.editor.ldef.lDef.Paritioner_JS#getScriptURI <em>Script URI</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Script URI</em>'.
   * @see org.eclipse.fx.code.editor.ldef.lDef.Paritioner_JS#getScriptURI()
   * @see #getParitioner_JS()
   * @generated
   */
  EAttribute getParitioner_JS_ScriptURI();

  /**
   * Returns the meta object for class '{@link org.eclipse.fx.code.editor.ldef.lDef.Partitioner_Rule <em>Partitioner Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Partitioner Rule</em>'.
   * @see org.eclipse.fx.code.editor.ldef.lDef.Partitioner_Rule
   * @generated
   */
  EClass getPartitioner_Rule();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.fx.code.editor.ldef.lDef.Partitioner_Rule#getRuleList <em>Rule List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Rule List</em>'.
   * @see org.eclipse.fx.code.editor.ldef.lDef.Partitioner_Rule#getRuleList()
   * @see #getPartitioner_Rule()
   * @generated
   */
  EReference getPartitioner_Rule_RuleList();

  /**
   * Returns the meta object for class '{@link org.eclipse.fx.code.editor.ldef.lDef.Partition_Rule <em>Partition Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Partition Rule</em>'.
   * @see org.eclipse.fx.code.editor.ldef.lDef.Partition_Rule
   * @generated
   */
  EClass getPartition_Rule();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.fx.code.editor.ldef.lDef.Partition_Rule#getParition <em>Parition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Parition</em>'.
   * @see org.eclipse.fx.code.editor.ldef.lDef.Partition_Rule#getParition()
   * @see #getPartition_Rule()
   * @generated
   */
  EReference getPartition_Rule_Parition();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.fx.code.editor.ldef.lDef.Partition_Rule#getStartSeq <em>Start Seq</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Start Seq</em>'.
   * @see org.eclipse.fx.code.editor.ldef.lDef.Partition_Rule#getStartSeq()
   * @see #getPartition_Rule()
   * @generated
   */
  EAttribute getPartition_Rule_StartSeq();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.fx.code.editor.ldef.lDef.Partition_Rule#getCheck <em>Check</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Check</em>'.
   * @see org.eclipse.fx.code.editor.ldef.lDef.Partition_Rule#getCheck()
   * @see #getPartition_Rule()
   * @generated
   */
  EReference getPartition_Rule_Check();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.fx.code.editor.ldef.lDef.Partition_Rule#getEndSeq <em>End Seq</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>End Seq</em>'.
   * @see org.eclipse.fx.code.editor.ldef.lDef.Partition_Rule#getEndSeq()
   * @see #getPartition_Rule()
   * @generated
   */
  EAttribute getPartition_Rule_EndSeq();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.fx.code.editor.ldef.lDef.Partition_Rule#getEscapeSeq <em>Escape Seq</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Escape Seq</em>'.
   * @see org.eclipse.fx.code.editor.ldef.lDef.Partition_Rule#getEscapeSeq()
   * @see #getPartition_Rule()
   * @generated
   */
  EAttribute getPartition_Rule_EscapeSeq();

  /**
   * Returns the meta object for class '{@link org.eclipse.fx.code.editor.ldef.lDef.Partition_SingleLineRule <em>Partition Single Line Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Partition Single Line Rule</em>'.
   * @see org.eclipse.fx.code.editor.ldef.lDef.Partition_SingleLineRule
   * @generated
   */
  EClass getPartition_SingleLineRule();

  /**
   * Returns the meta object for class '{@link org.eclipse.fx.code.editor.ldef.lDef.Partition_MultiLineRule <em>Partition Multi Line Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Partition Multi Line Rule</em>'.
   * @see org.eclipse.fx.code.editor.ldef.lDef.Partition_MultiLineRule
   * @generated
   */
  EClass getPartition_MultiLineRule();

  /**
   * Returns the meta object for class '{@link org.eclipse.fx.code.editor.ldef.lDef.LexicalHighlighting <em>Lexical Highlighting</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Lexical Highlighting</em>'.
   * @see org.eclipse.fx.code.editor.ldef.lDef.LexicalHighlighting
   * @generated
   */
  EClass getLexicalHighlighting();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.fx.code.editor.ldef.lDef.LexicalHighlighting#getList <em>List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>List</em>'.
   * @see org.eclipse.fx.code.editor.ldef.lDef.LexicalHighlighting#getList()
   * @see #getLexicalHighlighting()
   * @generated
   */
  EReference getLexicalHighlighting_List();

  /**
   * Returns the meta object for class '{@link org.eclipse.fx.code.editor.ldef.lDef.LexicalPartitionHighlighting <em>Lexical Partition Highlighting</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Lexical Partition Highlighting</em>'.
   * @see org.eclipse.fx.code.editor.ldef.lDef.LexicalPartitionHighlighting
   * @generated
   */
  EClass getLexicalPartitionHighlighting();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.fx.code.editor.ldef.lDef.LexicalPartitionHighlighting#getPartition <em>Partition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Partition</em>'.
   * @see org.eclipse.fx.code.editor.ldef.lDef.LexicalPartitionHighlighting#getPartition()
   * @see #getLexicalPartitionHighlighting()
   * @generated
   */
  EReference getLexicalPartitionHighlighting_Partition();

  /**
   * Returns the meta object for class '{@link org.eclipse.fx.code.editor.ldef.lDef.LexicalPartitionHighlighting_JS <em>Lexical Partition Highlighting JS</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Lexical Partition Highlighting JS</em>'.
   * @see org.eclipse.fx.code.editor.ldef.lDef.LexicalPartitionHighlighting_JS
   * @generated
   */
  EClass getLexicalPartitionHighlighting_JS();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.fx.code.editor.ldef.lDef.LexicalPartitionHighlighting_JS#getScriptURI <em>Script URI</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Script URI</em>'.
   * @see org.eclipse.fx.code.editor.ldef.lDef.LexicalPartitionHighlighting_JS#getScriptURI()
   * @see #getLexicalPartitionHighlighting_JS()
   * @generated
   */
  EAttribute getLexicalPartitionHighlighting_JS_ScriptURI();

  /**
   * Returns the meta object for class '{@link org.eclipse.fx.code.editor.ldef.lDef.LexicalPartitionHighlighting_Rule <em>Lexical Partition Highlighting Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Lexical Partition Highlighting Rule</em>'.
   * @see org.eclipse.fx.code.editor.ldef.lDef.LexicalPartitionHighlighting_Rule
   * @generated
   */
  EClass getLexicalPartitionHighlighting_Rule();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.fx.code.editor.ldef.lDef.LexicalPartitionHighlighting_Rule#getWhitespace <em>Whitespace</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Whitespace</em>'.
   * @see org.eclipse.fx.code.editor.ldef.lDef.LexicalPartitionHighlighting_Rule#getWhitespace()
   * @see #getLexicalPartitionHighlighting_Rule()
   * @generated
   */
  EReference getLexicalPartitionHighlighting_Rule_Whitespace();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.fx.code.editor.ldef.lDef.LexicalPartitionHighlighting_Rule#getTokenList <em>Token List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Token List</em>'.
   * @see org.eclipse.fx.code.editor.ldef.lDef.LexicalPartitionHighlighting_Rule#getTokenList()
   * @see #getLexicalPartitionHighlighting_Rule()
   * @generated
   */
  EReference getLexicalPartitionHighlighting_Rule_TokenList();

  /**
   * Returns the meta object for class '{@link org.eclipse.fx.code.editor.ldef.lDef.Token <em>Token</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Token</em>'.
   * @see org.eclipse.fx.code.editor.ldef.lDef.Token
   * @generated
   */
  EClass getToken();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.fx.code.editor.ldef.lDef.Token#isDefault <em>Default</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Default</em>'.
   * @see org.eclipse.fx.code.editor.ldef.lDef.Token#isDefault()
   * @see #getToken()
   * @generated
   */
  EAttribute getToken_Default();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.fx.code.editor.ldef.lDef.Token#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.fx.code.editor.ldef.lDef.Token#getName()
   * @see #getToken()
   * @generated
   */
  EAttribute getToken_Name();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.fx.code.editor.ldef.lDef.Token#getScannerList <em>Scanner List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Scanner List</em>'.
   * @see org.eclipse.fx.code.editor.ldef.lDef.Token#getScannerList()
   * @see #getToken()
   * @generated
   */
  EReference getToken_ScannerList();

  /**
   * Returns the meta object for class '{@link org.eclipse.fx.code.editor.ldef.lDef.Scanner <em>Scanner</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Scanner</em>'.
   * @see org.eclipse.fx.code.editor.ldef.lDef.Scanner
   * @generated
   */
  EClass getScanner();

  /**
   * Returns the meta object for class '{@link org.eclipse.fx.code.editor.ldef.lDef.Scanner_Keyword <em>Scanner Keyword</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Scanner Keyword</em>'.
   * @see org.eclipse.fx.code.editor.ldef.lDef.Scanner_Keyword
   * @generated
   */
  EClass getScanner_Keyword();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.fx.code.editor.ldef.lDef.Scanner_Keyword#getKeywords <em>Keywords</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Keywords</em>'.
   * @see org.eclipse.fx.code.editor.ldef.lDef.Scanner_Keyword#getKeywords()
   * @see #getScanner_Keyword()
   * @generated
   */
  EReference getScanner_Keyword_Keywords();

  /**
   * Returns the meta object for class '{@link org.eclipse.fx.code.editor.ldef.lDef.Keyword <em>Keyword</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Keyword</em>'.
   * @see org.eclipse.fx.code.editor.ldef.lDef.Keyword
   * @generated
   */
  EClass getKeyword();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.fx.code.editor.ldef.lDef.Keyword#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.fx.code.editor.ldef.lDef.Keyword#getName()
   * @see #getKeyword()
   * @generated
   */
  EAttribute getKeyword_Name();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.fx.code.editor.ldef.lDef.Keyword#getVersion <em>Version</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Version</em>'.
   * @see org.eclipse.fx.code.editor.ldef.lDef.Keyword#getVersion()
   * @see #getKeyword()
   * @generated
   */
  EAttribute getKeyword_Version();

  /**
   * Returns the meta object for class '{@link org.eclipse.fx.code.editor.ldef.lDef.Scanner_Rule <em>Scanner Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Scanner Rule</em>'.
   * @see org.eclipse.fx.code.editor.ldef.lDef.Scanner_Rule
   * @generated
   */
  EClass getScanner_Rule();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.fx.code.editor.ldef.lDef.Scanner_Rule#getCheck <em>Check</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Check</em>'.
   * @see org.eclipse.fx.code.editor.ldef.lDef.Scanner_Rule#getCheck()
   * @see #getScanner_Rule()
   * @generated
   */
  EReference getScanner_Rule_Check();

  /**
   * Returns the meta object for class '{@link org.eclipse.fx.code.editor.ldef.lDef.Scanner_SingleLineRule <em>Scanner Single Line Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Scanner Single Line Rule</em>'.
   * @see org.eclipse.fx.code.editor.ldef.lDef.Scanner_SingleLineRule
   * @generated
   */
  EClass getScanner_SingleLineRule();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.fx.code.editor.ldef.lDef.Scanner_SingleLineRule#getStartSeq <em>Start Seq</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Start Seq</em>'.
   * @see org.eclipse.fx.code.editor.ldef.lDef.Scanner_SingleLineRule#getStartSeq()
   * @see #getScanner_SingleLineRule()
   * @generated
   */
  EAttribute getScanner_SingleLineRule_StartSeq();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.fx.code.editor.ldef.lDef.Scanner_SingleLineRule#getEndSeq <em>End Seq</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>End Seq</em>'.
   * @see org.eclipse.fx.code.editor.ldef.lDef.Scanner_SingleLineRule#getEndSeq()
   * @see #getScanner_SingleLineRule()
   * @generated
   */
  EAttribute getScanner_SingleLineRule_EndSeq();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.fx.code.editor.ldef.lDef.Scanner_SingleLineRule#getEscapeSeq <em>Escape Seq</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Escape Seq</em>'.
   * @see org.eclipse.fx.code.editor.ldef.lDef.Scanner_SingleLineRule#getEscapeSeq()
   * @see #getScanner_SingleLineRule()
   * @generated
   */
  EAttribute getScanner_SingleLineRule_EscapeSeq();

  /**
   * Returns the meta object for class '{@link org.eclipse.fx.code.editor.ldef.lDef.Scanner_MultiLineRule <em>Scanner Multi Line Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Scanner Multi Line Rule</em>'.
   * @see org.eclipse.fx.code.editor.ldef.lDef.Scanner_MultiLineRule
   * @generated
   */
  EClass getScanner_MultiLineRule();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.fx.code.editor.ldef.lDef.Scanner_MultiLineRule#getStartSeq <em>Start Seq</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Start Seq</em>'.
   * @see org.eclipse.fx.code.editor.ldef.lDef.Scanner_MultiLineRule#getStartSeq()
   * @see #getScanner_MultiLineRule()
   * @generated
   */
  EAttribute getScanner_MultiLineRule_StartSeq();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.fx.code.editor.ldef.lDef.Scanner_MultiLineRule#getEndSeq <em>End Seq</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>End Seq</em>'.
   * @see org.eclipse.fx.code.editor.ldef.lDef.Scanner_MultiLineRule#getEndSeq()
   * @see #getScanner_MultiLineRule()
   * @generated
   */
  EAttribute getScanner_MultiLineRule_EndSeq();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.fx.code.editor.ldef.lDef.Scanner_MultiLineRule#getEscapeSeq <em>Escape Seq</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Escape Seq</em>'.
   * @see org.eclipse.fx.code.editor.ldef.lDef.Scanner_MultiLineRule#getEscapeSeq()
   * @see #getScanner_MultiLineRule()
   * @generated
   */
  EAttribute getScanner_MultiLineRule_EscapeSeq();

  /**
   * Returns the meta object for class '{@link org.eclipse.fx.code.editor.ldef.lDef.Scanner_PatternRule <em>Scanner Pattern Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Scanner Pattern Rule</em>'.
   * @see org.eclipse.fx.code.editor.ldef.lDef.Scanner_PatternRule
   * @generated
   */
  EClass getScanner_PatternRule();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.fx.code.editor.ldef.lDef.Scanner_PatternRule#getStartPattern <em>Start Pattern</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Start Pattern</em>'.
   * @see org.eclipse.fx.code.editor.ldef.lDef.Scanner_PatternRule#getStartPattern()
   * @see #getScanner_PatternRule()
   * @generated
   */
  EAttribute getScanner_PatternRule_StartPattern();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.fx.code.editor.ldef.lDef.Scanner_PatternRule#getLength <em>Length</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Length</em>'.
   * @see org.eclipse.fx.code.editor.ldef.lDef.Scanner_PatternRule#getLength()
   * @see #getScanner_PatternRule()
   * @generated
   */
  EAttribute getScanner_PatternRule_Length();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.fx.code.editor.ldef.lDef.Scanner_PatternRule#getContentPattern <em>Content Pattern</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Content Pattern</em>'.
   * @see org.eclipse.fx.code.editor.ldef.lDef.Scanner_PatternRule#getContentPattern()
   * @see #getScanner_PatternRule()
   * @generated
   */
  EAttribute getScanner_PatternRule_ContentPattern();

  /**
   * Returns the meta object for class '{@link org.eclipse.fx.code.editor.ldef.lDef.Scanner_CharacterRule <em>Scanner Character Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Scanner Character Rule</em>'.
   * @see org.eclipse.fx.code.editor.ldef.lDef.Scanner_CharacterRule
   * @generated
   */
  EClass getScanner_CharacterRule();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.fx.code.editor.ldef.lDef.Scanner_CharacterRule#getCharacters <em>Characters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Characters</em>'.
   * @see org.eclipse.fx.code.editor.ldef.lDef.Scanner_CharacterRule#getCharacters()
   * @see #getScanner_CharacterRule()
   * @generated
   */
  EAttribute getScanner_CharacterRule_Characters();

  /**
   * Returns the meta object for class '{@link org.eclipse.fx.code.editor.ldef.lDef.Scanner_JSRule <em>Scanner JS Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Scanner JS Rule</em>'.
   * @see org.eclipse.fx.code.editor.ldef.lDef.Scanner_JSRule
   * @generated
   */
  EClass getScanner_JSRule();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.fx.code.editor.ldef.lDef.Scanner_JSRule#getFileURI <em>File URI</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>File URI</em>'.
   * @see org.eclipse.fx.code.editor.ldef.lDef.Scanner_JSRule#getFileURI()
   * @see #getScanner_JSRule()
   * @generated
   */
  EAttribute getScanner_JSRule_FileURI();

  /**
   * Returns the meta object for class '{@link org.eclipse.fx.code.editor.ldef.lDef.Check <em>Check</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Check</em>'.
   * @see org.eclipse.fx.code.editor.ldef.lDef.Check
   * @generated
   */
  EClass getCheck();

  /**
   * Returns the meta object for class '{@link org.eclipse.fx.code.editor.ldef.lDef.Equals <em>Equals</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Equals</em>'.
   * @see org.eclipse.fx.code.editor.ldef.lDef.Equals
   * @generated
   */
  EClass getEquals();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.fx.code.editor.ldef.lDef.Equals#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.fx.code.editor.ldef.lDef.Equals#getValue()
   * @see #getEquals()
   * @generated
   */
  EAttribute getEquals_Value();

  /**
   * Returns the meta object for class '{@link org.eclipse.fx.code.editor.ldef.lDef.Range <em>Range</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Range</em>'.
   * @see org.eclipse.fx.code.editor.ldef.lDef.Range
   * @generated
   */
  EClass getRange();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.fx.code.editor.ldef.lDef.Range#getLtIncl <em>Lt Incl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Lt Incl</em>'.
   * @see org.eclipse.fx.code.editor.ldef.lDef.Range#getLtIncl()
   * @see #getRange()
   * @generated
   */
  EAttribute getRange_LtIncl();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.fx.code.editor.ldef.lDef.Range#getMinValue <em>Min Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Min Value</em>'.
   * @see org.eclipse.fx.code.editor.ldef.lDef.Range#getMinValue()
   * @see #getRange()
   * @generated
   */
  EAttribute getRange_MinValue();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.fx.code.editor.ldef.lDef.Range#getMaxValue <em>Max Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Max Value</em>'.
   * @see org.eclipse.fx.code.editor.ldef.lDef.Range#getMaxValue()
   * @see #getRange()
   * @generated
   */
  EAttribute getRange_MaxValue();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.fx.code.editor.ldef.lDef.Range#getGtIncl <em>Gt Incl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Gt Incl</em>'.
   * @see org.eclipse.fx.code.editor.ldef.lDef.Range#getGtIncl()
   * @see #getRange()
   * @generated
   */
  EAttribute getRange_GtIncl();

  /**
   * Returns the meta object for class '{@link org.eclipse.fx.code.editor.ldef.lDef.WhitespaceRule <em>Whitespace Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Whitespace Rule</em>'.
   * @see org.eclipse.fx.code.editor.ldef.lDef.WhitespaceRule
   * @generated
   */
  EClass getWhitespaceRule();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.fx.code.editor.ldef.lDef.WhitespaceRule#getCharacters <em>Characters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Characters</em>'.
   * @see org.eclipse.fx.code.editor.ldef.lDef.WhitespaceRule#getCharacters()
   * @see #getWhitespaceRule()
   * @generated
   */
  EAttribute getWhitespaceRule_Characters();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.fx.code.editor.ldef.lDef.WhitespaceRule#isJavawhitespace <em>Javawhitespace</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Javawhitespace</em>'.
   * @see org.eclipse.fx.code.editor.ldef.lDef.WhitespaceRule#isJavawhitespace()
   * @see #getWhitespaceRule()
   * @generated
   */
  EAttribute getWhitespaceRule_Javawhitespace();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.fx.code.editor.ldef.lDef.WhitespaceRule#getFileURI <em>File URI</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>File URI</em>'.
   * @see org.eclipse.fx.code.editor.ldef.lDef.WhitespaceRule#getFileURI()
   * @see #getWhitespaceRule()
   * @generated
   */
  EAttribute getWhitespaceRule_FileURI();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  LDefFactory getLDefFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link org.eclipse.fx.code.editor.ldef.lDef.impl.RootImpl <em>Root</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.fx.code.editor.ldef.lDef.impl.RootImpl
     * @see org.eclipse.fx.code.editor.ldef.lDef.impl.LDefPackageImpl#getRoot()
     * @generated
     */
    EClass ROOT = eINSTANCE.getRoot();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ROOT__NAME = eINSTANCE.getRoot_Name();

    /**
     * The meta object literal for the '<em><b>Imports</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ROOT__IMPORTS = eINSTANCE.getRoot_Imports();

    /**
     * The meta object literal for the '<em><b>Language Definition</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ROOT__LANGUAGE_DEFINITION = eINSTANCE.getRoot_LanguageDefinition();

    /**
     * The meta object literal for the '{@link org.eclipse.fx.code.editor.ldef.lDef.impl.ImportImpl <em>Import</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.fx.code.editor.ldef.lDef.impl.ImportImpl
     * @see org.eclipse.fx.code.editor.ldef.lDef.impl.LDefPackageImpl#getImport()
     * @generated
     */
    EClass IMPORT = eINSTANCE.getImport();

    /**
     * The meta object literal for the '<em><b>Imported Namespace</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute IMPORT__IMPORTED_NAMESPACE = eINSTANCE.getImport_ImportedNamespace();

    /**
     * The meta object literal for the '{@link org.eclipse.fx.code.editor.ldef.lDef.impl.LanguageDefImpl <em>Language Def</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.fx.code.editor.ldef.lDef.impl.LanguageDefImpl
     * @see org.eclipse.fx.code.editor.ldef.lDef.impl.LDefPackageImpl#getLanguageDef()
     * @generated
     */
    EClass LANGUAGE_DEF = eINSTANCE.getLanguageDef();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LANGUAGE_DEF__NAME = eINSTANCE.getLanguageDef_Name();

    /**
     * The meta object literal for the '<em><b>Paritioning</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LANGUAGE_DEF__PARITIONING = eINSTANCE.getLanguageDef_Paritioning();

    /**
     * The meta object literal for the '<em><b>Lexical Highlighting</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LANGUAGE_DEF__LEXICAL_HIGHLIGHTING = eINSTANCE.getLanguageDef_LexicalHighlighting();

    /**
     * The meta object literal for the '<em><b>Integration</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LANGUAGE_DEF__INTEGRATION = eINSTANCE.getLanguageDef_Integration();

    /**
     * The meta object literal for the '{@link org.eclipse.fx.code.editor.ldef.lDef.impl.IntegrationImpl <em>Integration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.fx.code.editor.ldef.lDef.impl.IntegrationImpl
     * @see org.eclipse.fx.code.editor.ldef.lDef.impl.LDefPackageImpl#getIntegration()
     * @generated
     */
    EClass INTEGRATION = eINSTANCE.getIntegration();

    /**
     * The meta object literal for the '<em><b>Code Integration List</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INTEGRATION__CODE_INTEGRATION_LIST = eINSTANCE.getIntegration_CodeIntegrationList();

    /**
     * The meta object literal for the '{@link org.eclipse.fx.code.editor.ldef.lDef.impl.CodeIntegrationImpl <em>Code Integration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.fx.code.editor.ldef.lDef.impl.CodeIntegrationImpl
     * @see org.eclipse.fx.code.editor.ldef.lDef.impl.LDefPackageImpl#getCodeIntegration()
     * @generated
     */
    EClass CODE_INTEGRATION = eINSTANCE.getCodeIntegration();

    /**
     * The meta object literal for the '{@link org.eclipse.fx.code.editor.ldef.lDef.impl.JavaFXIntegrationImpl <em>Java FX Integration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.fx.code.editor.ldef.lDef.impl.JavaFXIntegrationImpl
     * @see org.eclipse.fx.code.editor.ldef.lDef.impl.LDefPackageImpl#getJavaFXIntegration()
     * @generated
     */
    EClass JAVA_FX_INTEGRATION = eINSTANCE.getJavaFXIntegration();

    /**
     * The meta object literal for the '<em><b>Codegeneration List</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference JAVA_FX_INTEGRATION__CODEGENERATION_LIST = eINSTANCE.getJavaFXIntegration_CodegenerationList();

    /**
     * The meta object literal for the '{@link org.eclipse.fx.code.editor.ldef.lDef.impl.CodegenerationImpl <em>Codegeneration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.fx.code.editor.ldef.lDef.impl.CodegenerationImpl
     * @see org.eclipse.fx.code.editor.ldef.lDef.impl.LDefPackageImpl#getCodegeneration()
     * @generated
     */
    EClass CODEGENERATION = eINSTANCE.getCodegeneration();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CODEGENERATION__NAME = eINSTANCE.getCodegeneration_Name();

    /**
     * The meta object literal for the '<em><b>Config Value</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CODEGENERATION__CONFIG_VALUE = eINSTANCE.getCodegeneration_ConfigValue();

    /**
     * The meta object literal for the '{@link org.eclipse.fx.code.editor.ldef.lDef.impl.JavaCodeGenerationImpl <em>Java Code Generation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.fx.code.editor.ldef.lDef.impl.JavaCodeGenerationImpl
     * @see org.eclipse.fx.code.editor.ldef.lDef.impl.LDefPackageImpl#getJavaCodeGeneration()
     * @generated
     */
    EClass JAVA_CODE_GENERATION = eINSTANCE.getJavaCodeGeneration();

    /**
     * The meta object literal for the '{@link org.eclipse.fx.code.editor.ldef.lDef.impl.E4CodeGenerationImpl <em>E4 Code Generation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.fx.code.editor.ldef.lDef.impl.E4CodeGenerationImpl
     * @see org.eclipse.fx.code.editor.ldef.lDef.impl.LDefPackageImpl#getE4CodeGeneration()
     * @generated
     */
    EClass E4_CODE_GENERATION = eINSTANCE.getE4CodeGeneration();

    /**
     * The meta object literal for the '{@link org.eclipse.fx.code.editor.ldef.lDef.impl.ConfigValueImpl <em>Config Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.fx.code.editor.ldef.lDef.impl.ConfigValueImpl
     * @see org.eclipse.fx.code.editor.ldef.lDef.impl.LDefPackageImpl#getConfigValue()
     * @generated
     */
    EClass CONFIG_VALUE = eINSTANCE.getConfigValue();

    /**
     * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONFIG_VALUE__KEY = eINSTANCE.getConfigValue_Key();

    /**
     * The meta object literal for the '<em><b>Simple Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONFIG_VALUE__SIMPLE_VALUE = eINSTANCE.getConfigValue_SimpleValue();

    /**
     * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONFIG_VALUE__CHILDREN = eINSTANCE.getConfigValue_Children();

    /**
     * The meta object literal for the '{@link org.eclipse.fx.code.editor.ldef.lDef.impl.ParitioningImpl <em>Paritioning</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.fx.code.editor.ldef.lDef.impl.ParitioningImpl
     * @see org.eclipse.fx.code.editor.ldef.lDef.impl.LDefPackageImpl#getParitioning()
     * @generated
     */
    EClass PARITIONING = eINSTANCE.getParitioning();

    /**
     * The meta object literal for the '<em><b>Partitions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PARITIONING__PARTITIONS = eINSTANCE.getParitioning_Partitions();

    /**
     * The meta object literal for the '<em><b>Partitioner</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PARITIONING__PARTITIONER = eINSTANCE.getParitioning_Partitioner();

    /**
     * The meta object literal for the '{@link org.eclipse.fx.code.editor.ldef.lDef.impl.PartitionImpl <em>Partition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.fx.code.editor.ldef.lDef.impl.PartitionImpl
     * @see org.eclipse.fx.code.editor.ldef.lDef.impl.LDefPackageImpl#getPartition()
     * @generated
     */
    EClass PARTITION = eINSTANCE.getPartition();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PARTITION__NAME = eINSTANCE.getPartition_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.fx.code.editor.ldef.lDef.impl.PartitionerImpl <em>Partitioner</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.fx.code.editor.ldef.lDef.impl.PartitionerImpl
     * @see org.eclipse.fx.code.editor.ldef.lDef.impl.LDefPackageImpl#getPartitioner()
     * @generated
     */
    EClass PARTITIONER = eINSTANCE.getPartitioner();

    /**
     * The meta object literal for the '{@link org.eclipse.fx.code.editor.ldef.lDef.impl.Paritioner_JSImpl <em>Paritioner JS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.fx.code.editor.ldef.lDef.impl.Paritioner_JSImpl
     * @see org.eclipse.fx.code.editor.ldef.lDef.impl.LDefPackageImpl#getParitioner_JS()
     * @generated
     */
    EClass PARITIONER_JS = eINSTANCE.getParitioner_JS();

    /**
     * The meta object literal for the '<em><b>Script URI</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PARITIONER_JS__SCRIPT_URI = eINSTANCE.getParitioner_JS_ScriptURI();

    /**
     * The meta object literal for the '{@link org.eclipse.fx.code.editor.ldef.lDef.impl.Partitioner_RuleImpl <em>Partitioner Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.fx.code.editor.ldef.lDef.impl.Partitioner_RuleImpl
     * @see org.eclipse.fx.code.editor.ldef.lDef.impl.LDefPackageImpl#getPartitioner_Rule()
     * @generated
     */
    EClass PARTITIONER_RULE = eINSTANCE.getPartitioner_Rule();

    /**
     * The meta object literal for the '<em><b>Rule List</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PARTITIONER_RULE__RULE_LIST = eINSTANCE.getPartitioner_Rule_RuleList();

    /**
     * The meta object literal for the '{@link org.eclipse.fx.code.editor.ldef.lDef.impl.Partition_RuleImpl <em>Partition Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.fx.code.editor.ldef.lDef.impl.Partition_RuleImpl
     * @see org.eclipse.fx.code.editor.ldef.lDef.impl.LDefPackageImpl#getPartition_Rule()
     * @generated
     */
    EClass PARTITION_RULE = eINSTANCE.getPartition_Rule();

    /**
     * The meta object literal for the '<em><b>Parition</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PARTITION_RULE__PARITION = eINSTANCE.getPartition_Rule_Parition();

    /**
     * The meta object literal for the '<em><b>Start Seq</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PARTITION_RULE__START_SEQ = eINSTANCE.getPartition_Rule_StartSeq();

    /**
     * The meta object literal for the '<em><b>Check</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PARTITION_RULE__CHECK = eINSTANCE.getPartition_Rule_Check();

    /**
     * The meta object literal for the '<em><b>End Seq</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PARTITION_RULE__END_SEQ = eINSTANCE.getPartition_Rule_EndSeq();

    /**
     * The meta object literal for the '<em><b>Escape Seq</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PARTITION_RULE__ESCAPE_SEQ = eINSTANCE.getPartition_Rule_EscapeSeq();

    /**
     * The meta object literal for the '{@link org.eclipse.fx.code.editor.ldef.lDef.impl.Partition_SingleLineRuleImpl <em>Partition Single Line Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.fx.code.editor.ldef.lDef.impl.Partition_SingleLineRuleImpl
     * @see org.eclipse.fx.code.editor.ldef.lDef.impl.LDefPackageImpl#getPartition_SingleLineRule()
     * @generated
     */
    EClass PARTITION_SINGLE_LINE_RULE = eINSTANCE.getPartition_SingleLineRule();

    /**
     * The meta object literal for the '{@link org.eclipse.fx.code.editor.ldef.lDef.impl.Partition_MultiLineRuleImpl <em>Partition Multi Line Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.fx.code.editor.ldef.lDef.impl.Partition_MultiLineRuleImpl
     * @see org.eclipse.fx.code.editor.ldef.lDef.impl.LDefPackageImpl#getPartition_MultiLineRule()
     * @generated
     */
    EClass PARTITION_MULTI_LINE_RULE = eINSTANCE.getPartition_MultiLineRule();

    /**
     * The meta object literal for the '{@link org.eclipse.fx.code.editor.ldef.lDef.impl.LexicalHighlightingImpl <em>Lexical Highlighting</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.fx.code.editor.ldef.lDef.impl.LexicalHighlightingImpl
     * @see org.eclipse.fx.code.editor.ldef.lDef.impl.LDefPackageImpl#getLexicalHighlighting()
     * @generated
     */
    EClass LEXICAL_HIGHLIGHTING = eINSTANCE.getLexicalHighlighting();

    /**
     * The meta object literal for the '<em><b>List</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LEXICAL_HIGHLIGHTING__LIST = eINSTANCE.getLexicalHighlighting_List();

    /**
     * The meta object literal for the '{@link org.eclipse.fx.code.editor.ldef.lDef.impl.LexicalPartitionHighlightingImpl <em>Lexical Partition Highlighting</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.fx.code.editor.ldef.lDef.impl.LexicalPartitionHighlightingImpl
     * @see org.eclipse.fx.code.editor.ldef.lDef.impl.LDefPackageImpl#getLexicalPartitionHighlighting()
     * @generated
     */
    EClass LEXICAL_PARTITION_HIGHLIGHTING = eINSTANCE.getLexicalPartitionHighlighting();

    /**
     * The meta object literal for the '<em><b>Partition</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LEXICAL_PARTITION_HIGHLIGHTING__PARTITION = eINSTANCE.getLexicalPartitionHighlighting_Partition();

    /**
     * The meta object literal for the '{@link org.eclipse.fx.code.editor.ldef.lDef.impl.LexicalPartitionHighlighting_JSImpl <em>Lexical Partition Highlighting JS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.fx.code.editor.ldef.lDef.impl.LexicalPartitionHighlighting_JSImpl
     * @see org.eclipse.fx.code.editor.ldef.lDef.impl.LDefPackageImpl#getLexicalPartitionHighlighting_JS()
     * @generated
     */
    EClass LEXICAL_PARTITION_HIGHLIGHTING_JS = eINSTANCE.getLexicalPartitionHighlighting_JS();

    /**
     * The meta object literal for the '<em><b>Script URI</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LEXICAL_PARTITION_HIGHLIGHTING_JS__SCRIPT_URI = eINSTANCE.getLexicalPartitionHighlighting_JS_ScriptURI();

    /**
     * The meta object literal for the '{@link org.eclipse.fx.code.editor.ldef.lDef.impl.LexicalPartitionHighlighting_RuleImpl <em>Lexical Partition Highlighting Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.fx.code.editor.ldef.lDef.impl.LexicalPartitionHighlighting_RuleImpl
     * @see org.eclipse.fx.code.editor.ldef.lDef.impl.LDefPackageImpl#getLexicalPartitionHighlighting_Rule()
     * @generated
     */
    EClass LEXICAL_PARTITION_HIGHLIGHTING_RULE = eINSTANCE.getLexicalPartitionHighlighting_Rule();

    /**
     * The meta object literal for the '<em><b>Whitespace</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LEXICAL_PARTITION_HIGHLIGHTING_RULE__WHITESPACE = eINSTANCE.getLexicalPartitionHighlighting_Rule_Whitespace();

    /**
     * The meta object literal for the '<em><b>Token List</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LEXICAL_PARTITION_HIGHLIGHTING_RULE__TOKEN_LIST = eINSTANCE.getLexicalPartitionHighlighting_Rule_TokenList();

    /**
     * The meta object literal for the '{@link org.eclipse.fx.code.editor.ldef.lDef.impl.TokenImpl <em>Token</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.fx.code.editor.ldef.lDef.impl.TokenImpl
     * @see org.eclipse.fx.code.editor.ldef.lDef.impl.LDefPackageImpl#getToken()
     * @generated
     */
    EClass TOKEN = eINSTANCE.getToken();

    /**
     * The meta object literal for the '<em><b>Default</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TOKEN__DEFAULT = eINSTANCE.getToken_Default();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TOKEN__NAME = eINSTANCE.getToken_Name();

    /**
     * The meta object literal for the '<em><b>Scanner List</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TOKEN__SCANNER_LIST = eINSTANCE.getToken_ScannerList();

    /**
     * The meta object literal for the '{@link org.eclipse.fx.code.editor.ldef.lDef.impl.ScannerImpl <em>Scanner</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.fx.code.editor.ldef.lDef.impl.ScannerImpl
     * @see org.eclipse.fx.code.editor.ldef.lDef.impl.LDefPackageImpl#getScanner()
     * @generated
     */
    EClass SCANNER = eINSTANCE.getScanner();

    /**
     * The meta object literal for the '{@link org.eclipse.fx.code.editor.ldef.lDef.impl.Scanner_KeywordImpl <em>Scanner Keyword</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.fx.code.editor.ldef.lDef.impl.Scanner_KeywordImpl
     * @see org.eclipse.fx.code.editor.ldef.lDef.impl.LDefPackageImpl#getScanner_Keyword()
     * @generated
     */
    EClass SCANNER_KEYWORD = eINSTANCE.getScanner_Keyword();

    /**
     * The meta object literal for the '<em><b>Keywords</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SCANNER_KEYWORD__KEYWORDS = eINSTANCE.getScanner_Keyword_Keywords();

    /**
     * The meta object literal for the '{@link org.eclipse.fx.code.editor.ldef.lDef.impl.KeywordImpl <em>Keyword</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.fx.code.editor.ldef.lDef.impl.KeywordImpl
     * @see org.eclipse.fx.code.editor.ldef.lDef.impl.LDefPackageImpl#getKeyword()
     * @generated
     */
    EClass KEYWORD = eINSTANCE.getKeyword();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute KEYWORD__NAME = eINSTANCE.getKeyword_Name();

    /**
     * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute KEYWORD__VERSION = eINSTANCE.getKeyword_Version();

    /**
     * The meta object literal for the '{@link org.eclipse.fx.code.editor.ldef.lDef.impl.Scanner_RuleImpl <em>Scanner Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.fx.code.editor.ldef.lDef.impl.Scanner_RuleImpl
     * @see org.eclipse.fx.code.editor.ldef.lDef.impl.LDefPackageImpl#getScanner_Rule()
     * @generated
     */
    EClass SCANNER_RULE = eINSTANCE.getScanner_Rule();

    /**
     * The meta object literal for the '<em><b>Check</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SCANNER_RULE__CHECK = eINSTANCE.getScanner_Rule_Check();

    /**
     * The meta object literal for the '{@link org.eclipse.fx.code.editor.ldef.lDef.impl.Scanner_SingleLineRuleImpl <em>Scanner Single Line Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.fx.code.editor.ldef.lDef.impl.Scanner_SingleLineRuleImpl
     * @see org.eclipse.fx.code.editor.ldef.lDef.impl.LDefPackageImpl#getScanner_SingleLineRule()
     * @generated
     */
    EClass SCANNER_SINGLE_LINE_RULE = eINSTANCE.getScanner_SingleLineRule();

    /**
     * The meta object literal for the '<em><b>Start Seq</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SCANNER_SINGLE_LINE_RULE__START_SEQ = eINSTANCE.getScanner_SingleLineRule_StartSeq();

    /**
     * The meta object literal for the '<em><b>End Seq</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SCANNER_SINGLE_LINE_RULE__END_SEQ = eINSTANCE.getScanner_SingleLineRule_EndSeq();

    /**
     * The meta object literal for the '<em><b>Escape Seq</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SCANNER_SINGLE_LINE_RULE__ESCAPE_SEQ = eINSTANCE.getScanner_SingleLineRule_EscapeSeq();

    /**
     * The meta object literal for the '{@link org.eclipse.fx.code.editor.ldef.lDef.impl.Scanner_MultiLineRuleImpl <em>Scanner Multi Line Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.fx.code.editor.ldef.lDef.impl.Scanner_MultiLineRuleImpl
     * @see org.eclipse.fx.code.editor.ldef.lDef.impl.LDefPackageImpl#getScanner_MultiLineRule()
     * @generated
     */
    EClass SCANNER_MULTI_LINE_RULE = eINSTANCE.getScanner_MultiLineRule();

    /**
     * The meta object literal for the '<em><b>Start Seq</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SCANNER_MULTI_LINE_RULE__START_SEQ = eINSTANCE.getScanner_MultiLineRule_StartSeq();

    /**
     * The meta object literal for the '<em><b>End Seq</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SCANNER_MULTI_LINE_RULE__END_SEQ = eINSTANCE.getScanner_MultiLineRule_EndSeq();

    /**
     * The meta object literal for the '<em><b>Escape Seq</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SCANNER_MULTI_LINE_RULE__ESCAPE_SEQ = eINSTANCE.getScanner_MultiLineRule_EscapeSeq();

    /**
     * The meta object literal for the '{@link org.eclipse.fx.code.editor.ldef.lDef.impl.Scanner_PatternRuleImpl <em>Scanner Pattern Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.fx.code.editor.ldef.lDef.impl.Scanner_PatternRuleImpl
     * @see org.eclipse.fx.code.editor.ldef.lDef.impl.LDefPackageImpl#getScanner_PatternRule()
     * @generated
     */
    EClass SCANNER_PATTERN_RULE = eINSTANCE.getScanner_PatternRule();

    /**
     * The meta object literal for the '<em><b>Start Pattern</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SCANNER_PATTERN_RULE__START_PATTERN = eINSTANCE.getScanner_PatternRule_StartPattern();

    /**
     * The meta object literal for the '<em><b>Length</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SCANNER_PATTERN_RULE__LENGTH = eINSTANCE.getScanner_PatternRule_Length();

    /**
     * The meta object literal for the '<em><b>Content Pattern</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SCANNER_PATTERN_RULE__CONTENT_PATTERN = eINSTANCE.getScanner_PatternRule_ContentPattern();

    /**
     * The meta object literal for the '{@link org.eclipse.fx.code.editor.ldef.lDef.impl.Scanner_CharacterRuleImpl <em>Scanner Character Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.fx.code.editor.ldef.lDef.impl.Scanner_CharacterRuleImpl
     * @see org.eclipse.fx.code.editor.ldef.lDef.impl.LDefPackageImpl#getScanner_CharacterRule()
     * @generated
     */
    EClass SCANNER_CHARACTER_RULE = eINSTANCE.getScanner_CharacterRule();

    /**
     * The meta object literal for the '<em><b>Characters</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SCANNER_CHARACTER_RULE__CHARACTERS = eINSTANCE.getScanner_CharacterRule_Characters();

    /**
     * The meta object literal for the '{@link org.eclipse.fx.code.editor.ldef.lDef.impl.Scanner_JSRuleImpl <em>Scanner JS Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.fx.code.editor.ldef.lDef.impl.Scanner_JSRuleImpl
     * @see org.eclipse.fx.code.editor.ldef.lDef.impl.LDefPackageImpl#getScanner_JSRule()
     * @generated
     */
    EClass SCANNER_JS_RULE = eINSTANCE.getScanner_JSRule();

    /**
     * The meta object literal for the '<em><b>File URI</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SCANNER_JS_RULE__FILE_URI = eINSTANCE.getScanner_JSRule_FileURI();

    /**
     * The meta object literal for the '{@link org.eclipse.fx.code.editor.ldef.lDef.impl.CheckImpl <em>Check</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.fx.code.editor.ldef.lDef.impl.CheckImpl
     * @see org.eclipse.fx.code.editor.ldef.lDef.impl.LDefPackageImpl#getCheck()
     * @generated
     */
    EClass CHECK = eINSTANCE.getCheck();

    /**
     * The meta object literal for the '{@link org.eclipse.fx.code.editor.ldef.lDef.impl.EqualsImpl <em>Equals</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.fx.code.editor.ldef.lDef.impl.EqualsImpl
     * @see org.eclipse.fx.code.editor.ldef.lDef.impl.LDefPackageImpl#getEquals()
     * @generated
     */
    EClass EQUALS = eINSTANCE.getEquals();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EQUALS__VALUE = eINSTANCE.getEquals_Value();

    /**
     * The meta object literal for the '{@link org.eclipse.fx.code.editor.ldef.lDef.impl.RangeImpl <em>Range</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.fx.code.editor.ldef.lDef.impl.RangeImpl
     * @see org.eclipse.fx.code.editor.ldef.lDef.impl.LDefPackageImpl#getRange()
     * @generated
     */
    EClass RANGE = eINSTANCE.getRange();

    /**
     * The meta object literal for the '<em><b>Lt Incl</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RANGE__LT_INCL = eINSTANCE.getRange_LtIncl();

    /**
     * The meta object literal for the '<em><b>Min Value</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RANGE__MIN_VALUE = eINSTANCE.getRange_MinValue();

    /**
     * The meta object literal for the '<em><b>Max Value</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RANGE__MAX_VALUE = eINSTANCE.getRange_MaxValue();

    /**
     * The meta object literal for the '<em><b>Gt Incl</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RANGE__GT_INCL = eINSTANCE.getRange_GtIncl();

    /**
     * The meta object literal for the '{@link org.eclipse.fx.code.editor.ldef.lDef.impl.WhitespaceRuleImpl <em>Whitespace Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.fx.code.editor.ldef.lDef.impl.WhitespaceRuleImpl
     * @see org.eclipse.fx.code.editor.ldef.lDef.impl.LDefPackageImpl#getWhitespaceRule()
     * @generated
     */
    EClass WHITESPACE_RULE = eINSTANCE.getWhitespaceRule();

    /**
     * The meta object literal for the '<em><b>Characters</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute WHITESPACE_RULE__CHARACTERS = eINSTANCE.getWhitespaceRule_Characters();

    /**
     * The meta object literal for the '<em><b>Javawhitespace</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute WHITESPACE_RULE__JAVAWHITESPACE = eINSTANCE.getWhitespaceRule_Javawhitespace();

    /**
     * The meta object literal for the '<em><b>File URI</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute WHITESPACE_RULE__FILE_URI = eINSTANCE.getWhitespaceRule_FileURI();

  }

} //LDefPackage
