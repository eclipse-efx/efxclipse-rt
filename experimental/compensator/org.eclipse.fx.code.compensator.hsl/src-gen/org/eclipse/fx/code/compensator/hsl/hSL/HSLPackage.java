/**
 */
package org.eclipse.fx.code.compensator.hsl.hSL;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see org.eclipse.fx.code.compensator.hsl.hSL.HSLFactory
 * @model kind="package"
 * @generated
 */
public interface HSLPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "hSL";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/fx/code/compensator/hsl/HSL";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "hSL";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  HSLPackage eINSTANCE = org.eclipse.fx.code.compensator.hsl.hSL.impl.HSLPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.fx.code.compensator.hsl.hSL.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.ModelImpl
   * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.HSLPackageImpl#getModel()
   * @generated
   */
  int MODEL = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__NAME = 0;

  /**
   * The feature id for the '<em><b>Partitions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__PARTITIONS = 1;

  /**
   * The feature id for the '<em><b>Scanner</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__SCANNER = 2;

  /**
   * The feature id for the '<em><b>Partitioner</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__PARTITIONER = 3;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link org.eclipse.fx.code.compensator.hsl.hSL.impl.PartitionImpl <em>Partition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.PartitionImpl
   * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.HSLPackageImpl#getPartition()
   * @generated
   */
  int PARTITION = 1;

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
   * The meta object id for the '{@link org.eclipse.fx.code.compensator.hsl.hSL.impl.PartitionerImpl <em>Partitioner</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.PartitionerImpl
   * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.HSLPackageImpl#getPartitioner()
   * @generated
   */
  int PARTITIONER = 2;

  /**
   * The number of structural features of the '<em>Partitioner</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARTITIONER_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipse.fx.code.compensator.hsl.hSL.impl.RulePartitionerImpl <em>Rule Partitioner</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.RulePartitionerImpl
   * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.HSLPackageImpl#getRulePartitioner()
   * @generated
   */
  int RULE_PARTITIONER = 3;

  /**
   * The feature id for the '<em><b>Rules</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_PARTITIONER__RULES = PARTITIONER_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Rule Partitioner</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_PARTITIONER_FEATURE_COUNT = PARTITIONER_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.fx.code.compensator.hsl.hSL.impl.JSParitionerImpl <em>JS Paritioner</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.JSParitionerImpl
   * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.HSLPackageImpl#getJSParitioner()
   * @generated
   */
  int JS_PARITIONER = 4;

  /**
   * The feature id for the '<em><b>File URI</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JS_PARITIONER__FILE_URI = PARTITIONER_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>JS Paritioner</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JS_PARITIONER_FEATURE_COUNT = PARTITIONER_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.fx.code.compensator.hsl.hSL.impl.ScannerImpl <em>Scanner</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.ScannerImpl
   * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.HSLPackageImpl#getScanner()
   * @generated
   */
  int SCANNER = 5;

  /**
   * The feature id for the '<em><b>Partition</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCANNER__PARTITION = 0;

  /**
   * The feature id for the '<em><b>Tokens</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCANNER__TOKENS = 1;

  /**
   * The feature id for the '<em><b>Keyword Groups</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCANNER__KEYWORD_GROUPS = 2;

  /**
   * The feature id for the '<em><b>Rules</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCANNER__RULES = 3;

  /**
   * The number of structural features of the '<em>Scanner</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCANNER_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link org.eclipse.fx.code.compensator.hsl.hSL.impl.ScannerTokenImpl <em>Scanner Token</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.ScannerTokenImpl
   * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.HSLPackageImpl#getScannerToken()
   * @generated
   */
  int SCANNER_TOKEN = 6;

  /**
   * The feature id for the '<em><b>Default</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCANNER_TOKEN__DEFAULT = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCANNER_TOKEN__NAME = 1;

  /**
   * The feature id for the '<em><b>Fg Color</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCANNER_TOKEN__FG_COLOR = 2;

  /**
   * The feature id for the '<em><b>Bg Color</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCANNER_TOKEN__BG_COLOR = 3;

  /**
   * The feature id for the '<em><b>Font</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCANNER_TOKEN__FONT = 4;

  /**
   * The number of structural features of the '<em>Scanner Token</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCANNER_TOKEN_FEATURE_COUNT = 5;

  /**
   * The meta object id for the '{@link org.eclipse.fx.code.compensator.hsl.hSL.impl.KeywordGroupImpl <em>Keyword Group</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.KeywordGroupImpl
   * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.HSLPackageImpl#getKeywordGroup()
   * @generated
   */
  int KEYWORD_GROUP = 7;

  /**
   * The feature id for the '<em><b>Token</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int KEYWORD_GROUP__TOKEN = 0;

  /**
   * The feature id for the '<em><b>Keywords</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int KEYWORD_GROUP__KEYWORDS = 1;

  /**
   * The number of structural features of the '<em>Keyword Group</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int KEYWORD_GROUP_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.fx.code.compensator.hsl.hSL.impl.KeywordImpl <em>Keyword</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.KeywordImpl
   * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.HSLPackageImpl#getKeyword()
   * @generated
   */
  int KEYWORD = 8;

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
   * The meta object id for the '{@link org.eclipse.fx.code.compensator.hsl.hSL.impl.ScannerRuleImpl <em>Scanner Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.ScannerRuleImpl
   * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.HSLPackageImpl#getScannerRule()
   * @generated
   */
  int SCANNER_RULE = 9;

  /**
   * The feature id for the '<em><b>Token</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCANNER_RULE__TOKEN = 0;

  /**
   * The number of structural features of the '<em>Scanner Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCANNER_RULE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.fx.code.compensator.hsl.hSL.impl.ParitionRuleImpl <em>Parition Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.ParitionRuleImpl
   * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.HSLPackageImpl#getParitionRule()
   * @generated
   */
  int PARITION_RULE = 10;

  /**
   * The number of structural features of the '<em>Parition Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARITION_RULE_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipse.fx.code.compensator.hsl.hSL.impl.ScannerSingleLineRuleImpl <em>Scanner Single Line Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.ScannerSingleLineRuleImpl
   * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.HSLPackageImpl#getScannerSingleLineRule()
   * @generated
   */
  int SCANNER_SINGLE_LINE_RULE = 11;

  /**
   * The feature id for the '<em><b>Token</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCANNER_SINGLE_LINE_RULE__TOKEN = SCANNER_RULE__TOKEN;

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
   * The meta object id for the '{@link org.eclipse.fx.code.compensator.hsl.hSL.impl.PartitionSingleLineRuleImpl <em>Partition Single Line Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.PartitionSingleLineRuleImpl
   * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.HSLPackageImpl#getPartitionSingleLineRule()
   * @generated
   */
  int PARTITION_SINGLE_LINE_RULE = 12;

  /**
   * The feature id for the '<em><b>Parition</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARTITION_SINGLE_LINE_RULE__PARITION = PARITION_RULE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Start Seq</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARTITION_SINGLE_LINE_RULE__START_SEQ = PARITION_RULE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>End Seq</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARTITION_SINGLE_LINE_RULE__END_SEQ = PARITION_RULE_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Escape Seq</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARTITION_SINGLE_LINE_RULE__ESCAPE_SEQ = PARITION_RULE_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Partition Single Line Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARTITION_SINGLE_LINE_RULE_FEATURE_COUNT = PARITION_RULE_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link org.eclipse.fx.code.compensator.hsl.hSL.impl.ScannerMultiLineRuleImpl <em>Scanner Multi Line Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.ScannerMultiLineRuleImpl
   * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.HSLPackageImpl#getScannerMultiLineRule()
   * @generated
   */
  int SCANNER_MULTI_LINE_RULE = 13;

  /**
   * The feature id for the '<em><b>Token</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCANNER_MULTI_LINE_RULE__TOKEN = SCANNER_RULE__TOKEN;

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
   * The meta object id for the '{@link org.eclipse.fx.code.compensator.hsl.hSL.impl.PartitionMultiLineRuleImpl <em>Partition Multi Line Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.PartitionMultiLineRuleImpl
   * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.HSLPackageImpl#getPartitionMultiLineRule()
   * @generated
   */
  int PARTITION_MULTI_LINE_RULE = 14;

  /**
   * The feature id for the '<em><b>Token</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARTITION_MULTI_LINE_RULE__TOKEN = PARITION_RULE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Start Seq</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARTITION_MULTI_LINE_RULE__START_SEQ = PARITION_RULE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>End Seq</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARTITION_MULTI_LINE_RULE__END_SEQ = PARITION_RULE_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Escape Seq</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARTITION_MULTI_LINE_RULE__ESCAPE_SEQ = PARITION_RULE_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Partition Multi Line Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARTITION_MULTI_LINE_RULE_FEATURE_COUNT = PARITION_RULE_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link org.eclipse.fx.code.compensator.hsl.hSL.impl.ScannerCharacterRuleImpl <em>Scanner Character Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.ScannerCharacterRuleImpl
   * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.HSLPackageImpl#getScannerCharacterRule()
   * @generated
   */
  int SCANNER_CHARACTER_RULE = 15;

  /**
   * The feature id for the '<em><b>Token</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCANNER_CHARACTER_RULE__TOKEN = SCANNER_RULE__TOKEN;

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
   * The meta object id for the '{@link org.eclipse.fx.code.compensator.hsl.hSL.impl.ScannerJSRuleImpl <em>Scanner JS Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.ScannerJSRuleImpl
   * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.HSLPackageImpl#getScannerJSRule()
   * @generated
   */
  int SCANNER_JS_RULE = 16;

  /**
   * The feature id for the '<em><b>Token</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCANNER_JS_RULE__TOKEN = SCANNER_RULE__TOKEN;

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
   * The meta object id for the '{@link org.eclipse.fx.code.compensator.hsl.hSL.impl.PartitionJSRuleImpl <em>Partition JS Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.PartitionJSRuleImpl
   * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.HSLPackageImpl#getPartitionJSRule()
   * @generated
   */
  int PARTITION_JS_RULE = 17;

  /**
   * The feature id for the '<em><b>Token</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARTITION_JS_RULE__TOKEN = PARITION_RULE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>File URI</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARTITION_JS_RULE__FILE_URI = PARITION_RULE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Partition JS Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARTITION_JS_RULE_FEATURE_COUNT = PARITION_RULE_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.fx.code.compensator.hsl.hSL.impl.ScannerWhitespaceRuleImpl <em>Scanner Whitespace Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.ScannerWhitespaceRuleImpl
   * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.HSLPackageImpl#getScannerWhitespaceRule()
   * @generated
   */
  int SCANNER_WHITESPACE_RULE = 18;

  /**
   * The feature id for the '<em><b>Token</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCANNER_WHITESPACE_RULE__TOKEN = SCANNER_RULE__TOKEN;

  /**
   * The feature id for the '<em><b>Characters</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCANNER_WHITESPACE_RULE__CHARACTERS = SCANNER_RULE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Js Method</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCANNER_WHITESPACE_RULE__JS_METHOD = SCANNER_RULE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Scanner Whitespace Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCANNER_WHITESPACE_RULE_FEATURE_COUNT = SCANNER_RULE_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.fx.code.compensator.hsl.hSL.impl.ColorImpl <em>Color</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.ColorImpl
   * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.HSLPackageImpl#getColor()
   * @generated
   */
  int COLOR = 19;

  /**
   * The number of structural features of the '<em>Color</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COLOR_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipse.fx.code.compensator.hsl.hSL.impl.RGBColorImpl <em>RGB Color</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.RGBColorImpl
   * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.HSLPackageImpl#getRGBColor()
   * @generated
   */
  int RGB_COLOR = 20;

  /**
   * The feature id for the '<em><b>R</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RGB_COLOR__R = COLOR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>G</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RGB_COLOR__G = COLOR_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>B</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RGB_COLOR__B = COLOR_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>RGB Color</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RGB_COLOR_FEATURE_COUNT = COLOR_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.eclipse.fx.code.compensator.hsl.hSL.impl.FontImpl <em>Font</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.FontImpl
   * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.HSLPackageImpl#getFont()
   * @generated
   */
  int FONT = 21;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FONT__NAME = 0;

  /**
   * The feature id for the '<em><b>Size</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FONT__SIZE = 1;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FONT__ATTRIBUTES = 2;

  /**
   * The number of structural features of the '<em>Font</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FONT_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.eclipse.fx.code.compensator.hsl.hSL.FontType <em>Font Type</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.fx.code.compensator.hsl.hSL.FontType
   * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.HSLPackageImpl#getFontType()
   * @generated
   */
  int FONT_TYPE = 22;


  /**
   * Returns the meta object for class '{@link org.eclipse.fx.code.compensator.hsl.hSL.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.fx.code.compensator.hsl.hSL.Model#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.Model#getName()
   * @see #getModel()
   * @generated
   */
  EAttribute getModel_Name();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.fx.code.compensator.hsl.hSL.Model#getPartitions <em>Partitions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Partitions</em>'.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.Model#getPartitions()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Partitions();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.fx.code.compensator.hsl.hSL.Model#getScanner <em>Scanner</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Scanner</em>'.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.Model#getScanner()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Scanner();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.fx.code.compensator.hsl.hSL.Model#getPartitioner <em>Partitioner</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Partitioner</em>'.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.Model#getPartitioner()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Partitioner();

  /**
   * Returns the meta object for class '{@link org.eclipse.fx.code.compensator.hsl.hSL.Partition <em>Partition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Partition</em>'.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.Partition
   * @generated
   */
  EClass getPartition();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.fx.code.compensator.hsl.hSL.Partition#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.Partition#getName()
   * @see #getPartition()
   * @generated
   */
  EAttribute getPartition_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.fx.code.compensator.hsl.hSL.Partitioner <em>Partitioner</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Partitioner</em>'.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.Partitioner
   * @generated
   */
  EClass getPartitioner();

  /**
   * Returns the meta object for class '{@link org.eclipse.fx.code.compensator.hsl.hSL.RulePartitioner <em>Rule Partitioner</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Rule Partitioner</em>'.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.RulePartitioner
   * @generated
   */
  EClass getRulePartitioner();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.fx.code.compensator.hsl.hSL.RulePartitioner#getRules <em>Rules</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Rules</em>'.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.RulePartitioner#getRules()
   * @see #getRulePartitioner()
   * @generated
   */
  EReference getRulePartitioner_Rules();

  /**
   * Returns the meta object for class '{@link org.eclipse.fx.code.compensator.hsl.hSL.JSParitioner <em>JS Paritioner</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>JS Paritioner</em>'.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.JSParitioner
   * @generated
   */
  EClass getJSParitioner();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.fx.code.compensator.hsl.hSL.JSParitioner#getFileURI <em>File URI</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>File URI</em>'.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.JSParitioner#getFileURI()
   * @see #getJSParitioner()
   * @generated
   */
  EAttribute getJSParitioner_FileURI();

  /**
   * Returns the meta object for class '{@link org.eclipse.fx.code.compensator.hsl.hSL.Scanner <em>Scanner</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Scanner</em>'.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.Scanner
   * @generated
   */
  EClass getScanner();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.fx.code.compensator.hsl.hSL.Scanner#getPartition <em>Partition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Partition</em>'.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.Scanner#getPartition()
   * @see #getScanner()
   * @generated
   */
  EReference getScanner_Partition();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.fx.code.compensator.hsl.hSL.Scanner#getTokens <em>Tokens</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Tokens</em>'.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.Scanner#getTokens()
   * @see #getScanner()
   * @generated
   */
  EReference getScanner_Tokens();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.fx.code.compensator.hsl.hSL.Scanner#getKeywordGroups <em>Keyword Groups</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Keyword Groups</em>'.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.Scanner#getKeywordGroups()
   * @see #getScanner()
   * @generated
   */
  EReference getScanner_KeywordGroups();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.fx.code.compensator.hsl.hSL.Scanner#getRules <em>Rules</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Rules</em>'.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.Scanner#getRules()
   * @see #getScanner()
   * @generated
   */
  EReference getScanner_Rules();

  /**
   * Returns the meta object for class '{@link org.eclipse.fx.code.compensator.hsl.hSL.ScannerToken <em>Scanner Token</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Scanner Token</em>'.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.ScannerToken
   * @generated
   */
  EClass getScannerToken();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.fx.code.compensator.hsl.hSL.ScannerToken#isDefault <em>Default</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Default</em>'.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.ScannerToken#isDefault()
   * @see #getScannerToken()
   * @generated
   */
  EAttribute getScannerToken_Default();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.fx.code.compensator.hsl.hSL.ScannerToken#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.ScannerToken#getName()
   * @see #getScannerToken()
   * @generated
   */
  EAttribute getScannerToken_Name();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.fx.code.compensator.hsl.hSL.ScannerToken#getFgColor <em>Fg Color</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Fg Color</em>'.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.ScannerToken#getFgColor()
   * @see #getScannerToken()
   * @generated
   */
  EReference getScannerToken_FgColor();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.fx.code.compensator.hsl.hSL.ScannerToken#getBgColor <em>Bg Color</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Bg Color</em>'.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.ScannerToken#getBgColor()
   * @see #getScannerToken()
   * @generated
   */
  EReference getScannerToken_BgColor();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.fx.code.compensator.hsl.hSL.ScannerToken#getFont <em>Font</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Font</em>'.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.ScannerToken#getFont()
   * @see #getScannerToken()
   * @generated
   */
  EReference getScannerToken_Font();

  /**
   * Returns the meta object for class '{@link org.eclipse.fx.code.compensator.hsl.hSL.KeywordGroup <em>Keyword Group</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Keyword Group</em>'.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.KeywordGroup
   * @generated
   */
  EClass getKeywordGroup();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.fx.code.compensator.hsl.hSL.KeywordGroup#getToken <em>Token</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Token</em>'.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.KeywordGroup#getToken()
   * @see #getKeywordGroup()
   * @generated
   */
  EReference getKeywordGroup_Token();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.fx.code.compensator.hsl.hSL.KeywordGroup#getKeywords <em>Keywords</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Keywords</em>'.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.KeywordGroup#getKeywords()
   * @see #getKeywordGroup()
   * @generated
   */
  EReference getKeywordGroup_Keywords();

  /**
   * Returns the meta object for class '{@link org.eclipse.fx.code.compensator.hsl.hSL.Keyword <em>Keyword</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Keyword</em>'.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.Keyword
   * @generated
   */
  EClass getKeyword();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.fx.code.compensator.hsl.hSL.Keyword#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.Keyword#getName()
   * @see #getKeyword()
   * @generated
   */
  EAttribute getKeyword_Name();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.fx.code.compensator.hsl.hSL.Keyword#getVersion <em>Version</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Version</em>'.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.Keyword#getVersion()
   * @see #getKeyword()
   * @generated
   */
  EAttribute getKeyword_Version();

  /**
   * Returns the meta object for class '{@link org.eclipse.fx.code.compensator.hsl.hSL.ScannerRule <em>Scanner Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Scanner Rule</em>'.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.ScannerRule
   * @generated
   */
  EClass getScannerRule();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.fx.code.compensator.hsl.hSL.ScannerRule#getToken <em>Token</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Token</em>'.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.ScannerRule#getToken()
   * @see #getScannerRule()
   * @generated
   */
  EReference getScannerRule_Token();

  /**
   * Returns the meta object for class '{@link org.eclipse.fx.code.compensator.hsl.hSL.ParitionRule <em>Parition Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Parition Rule</em>'.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.ParitionRule
   * @generated
   */
  EClass getParitionRule();

  /**
   * Returns the meta object for class '{@link org.eclipse.fx.code.compensator.hsl.hSL.ScannerSingleLineRule <em>Scanner Single Line Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Scanner Single Line Rule</em>'.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.ScannerSingleLineRule
   * @generated
   */
  EClass getScannerSingleLineRule();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.fx.code.compensator.hsl.hSL.ScannerSingleLineRule#getStartSeq <em>Start Seq</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Start Seq</em>'.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.ScannerSingleLineRule#getStartSeq()
   * @see #getScannerSingleLineRule()
   * @generated
   */
  EAttribute getScannerSingleLineRule_StartSeq();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.fx.code.compensator.hsl.hSL.ScannerSingleLineRule#getEndSeq <em>End Seq</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>End Seq</em>'.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.ScannerSingleLineRule#getEndSeq()
   * @see #getScannerSingleLineRule()
   * @generated
   */
  EAttribute getScannerSingleLineRule_EndSeq();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.fx.code.compensator.hsl.hSL.ScannerSingleLineRule#getEscapeSeq <em>Escape Seq</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Escape Seq</em>'.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.ScannerSingleLineRule#getEscapeSeq()
   * @see #getScannerSingleLineRule()
   * @generated
   */
  EAttribute getScannerSingleLineRule_EscapeSeq();

  /**
   * Returns the meta object for class '{@link org.eclipse.fx.code.compensator.hsl.hSL.PartitionSingleLineRule <em>Partition Single Line Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Partition Single Line Rule</em>'.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.PartitionSingleLineRule
   * @generated
   */
  EClass getPartitionSingleLineRule();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.fx.code.compensator.hsl.hSL.PartitionSingleLineRule#getParition <em>Parition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Parition</em>'.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.PartitionSingleLineRule#getParition()
   * @see #getPartitionSingleLineRule()
   * @generated
   */
  EReference getPartitionSingleLineRule_Parition();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.fx.code.compensator.hsl.hSL.PartitionSingleLineRule#getStartSeq <em>Start Seq</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Start Seq</em>'.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.PartitionSingleLineRule#getStartSeq()
   * @see #getPartitionSingleLineRule()
   * @generated
   */
  EAttribute getPartitionSingleLineRule_StartSeq();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.fx.code.compensator.hsl.hSL.PartitionSingleLineRule#getEndSeq <em>End Seq</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>End Seq</em>'.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.PartitionSingleLineRule#getEndSeq()
   * @see #getPartitionSingleLineRule()
   * @generated
   */
  EAttribute getPartitionSingleLineRule_EndSeq();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.fx.code.compensator.hsl.hSL.PartitionSingleLineRule#getEscapeSeq <em>Escape Seq</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Escape Seq</em>'.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.PartitionSingleLineRule#getEscapeSeq()
   * @see #getPartitionSingleLineRule()
   * @generated
   */
  EAttribute getPartitionSingleLineRule_EscapeSeq();

  /**
   * Returns the meta object for class '{@link org.eclipse.fx.code.compensator.hsl.hSL.ScannerMultiLineRule <em>Scanner Multi Line Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Scanner Multi Line Rule</em>'.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.ScannerMultiLineRule
   * @generated
   */
  EClass getScannerMultiLineRule();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.fx.code.compensator.hsl.hSL.ScannerMultiLineRule#getStartSeq <em>Start Seq</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Start Seq</em>'.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.ScannerMultiLineRule#getStartSeq()
   * @see #getScannerMultiLineRule()
   * @generated
   */
  EAttribute getScannerMultiLineRule_StartSeq();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.fx.code.compensator.hsl.hSL.ScannerMultiLineRule#getEndSeq <em>End Seq</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>End Seq</em>'.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.ScannerMultiLineRule#getEndSeq()
   * @see #getScannerMultiLineRule()
   * @generated
   */
  EAttribute getScannerMultiLineRule_EndSeq();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.fx.code.compensator.hsl.hSL.ScannerMultiLineRule#getEscapeSeq <em>Escape Seq</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Escape Seq</em>'.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.ScannerMultiLineRule#getEscapeSeq()
   * @see #getScannerMultiLineRule()
   * @generated
   */
  EAttribute getScannerMultiLineRule_EscapeSeq();

  /**
   * Returns the meta object for class '{@link org.eclipse.fx.code.compensator.hsl.hSL.PartitionMultiLineRule <em>Partition Multi Line Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Partition Multi Line Rule</em>'.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.PartitionMultiLineRule
   * @generated
   */
  EClass getPartitionMultiLineRule();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.fx.code.compensator.hsl.hSL.PartitionMultiLineRule#getToken <em>Token</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Token</em>'.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.PartitionMultiLineRule#getToken()
   * @see #getPartitionMultiLineRule()
   * @generated
   */
  EReference getPartitionMultiLineRule_Token();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.fx.code.compensator.hsl.hSL.PartitionMultiLineRule#getStartSeq <em>Start Seq</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Start Seq</em>'.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.PartitionMultiLineRule#getStartSeq()
   * @see #getPartitionMultiLineRule()
   * @generated
   */
  EAttribute getPartitionMultiLineRule_StartSeq();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.fx.code.compensator.hsl.hSL.PartitionMultiLineRule#getEndSeq <em>End Seq</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>End Seq</em>'.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.PartitionMultiLineRule#getEndSeq()
   * @see #getPartitionMultiLineRule()
   * @generated
   */
  EAttribute getPartitionMultiLineRule_EndSeq();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.fx.code.compensator.hsl.hSL.PartitionMultiLineRule#getEscapeSeq <em>Escape Seq</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Escape Seq</em>'.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.PartitionMultiLineRule#getEscapeSeq()
   * @see #getPartitionMultiLineRule()
   * @generated
   */
  EAttribute getPartitionMultiLineRule_EscapeSeq();

  /**
   * Returns the meta object for class '{@link org.eclipse.fx.code.compensator.hsl.hSL.ScannerCharacterRule <em>Scanner Character Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Scanner Character Rule</em>'.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.ScannerCharacterRule
   * @generated
   */
  EClass getScannerCharacterRule();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.fx.code.compensator.hsl.hSL.ScannerCharacterRule#getCharacters <em>Characters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Characters</em>'.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.ScannerCharacterRule#getCharacters()
   * @see #getScannerCharacterRule()
   * @generated
   */
  EAttribute getScannerCharacterRule_Characters();

  /**
   * Returns the meta object for class '{@link org.eclipse.fx.code.compensator.hsl.hSL.ScannerJSRule <em>Scanner JS Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Scanner JS Rule</em>'.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.ScannerJSRule
   * @generated
   */
  EClass getScannerJSRule();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.fx.code.compensator.hsl.hSL.ScannerJSRule#getFileURI <em>File URI</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>File URI</em>'.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.ScannerJSRule#getFileURI()
   * @see #getScannerJSRule()
   * @generated
   */
  EAttribute getScannerJSRule_FileURI();

  /**
   * Returns the meta object for class '{@link org.eclipse.fx.code.compensator.hsl.hSL.PartitionJSRule <em>Partition JS Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Partition JS Rule</em>'.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.PartitionJSRule
   * @generated
   */
  EClass getPartitionJSRule();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.fx.code.compensator.hsl.hSL.PartitionJSRule#getToken <em>Token</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Token</em>'.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.PartitionJSRule#getToken()
   * @see #getPartitionJSRule()
   * @generated
   */
  EReference getPartitionJSRule_Token();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.fx.code.compensator.hsl.hSL.PartitionJSRule#getFileURI <em>File URI</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>File URI</em>'.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.PartitionJSRule#getFileURI()
   * @see #getPartitionJSRule()
   * @generated
   */
  EAttribute getPartitionJSRule_FileURI();

  /**
   * Returns the meta object for class '{@link org.eclipse.fx.code.compensator.hsl.hSL.ScannerWhitespaceRule <em>Scanner Whitespace Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Scanner Whitespace Rule</em>'.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.ScannerWhitespaceRule
   * @generated
   */
  EClass getScannerWhitespaceRule();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.fx.code.compensator.hsl.hSL.ScannerWhitespaceRule#getCharacters <em>Characters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Characters</em>'.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.ScannerWhitespaceRule#getCharacters()
   * @see #getScannerWhitespaceRule()
   * @generated
   */
  EAttribute getScannerWhitespaceRule_Characters();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.fx.code.compensator.hsl.hSL.ScannerWhitespaceRule#getJsMethod <em>Js Method</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Js Method</em>'.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.ScannerWhitespaceRule#getJsMethod()
   * @see #getScannerWhitespaceRule()
   * @generated
   */
  EAttribute getScannerWhitespaceRule_JsMethod();

  /**
   * Returns the meta object for class '{@link org.eclipse.fx.code.compensator.hsl.hSL.Color <em>Color</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Color</em>'.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.Color
   * @generated
   */
  EClass getColor();

  /**
   * Returns the meta object for class '{@link org.eclipse.fx.code.compensator.hsl.hSL.RGBColor <em>RGB Color</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>RGB Color</em>'.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.RGBColor
   * @generated
   */
  EClass getRGBColor();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.fx.code.compensator.hsl.hSL.RGBColor#getR <em>R</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>R</em>'.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.RGBColor#getR()
   * @see #getRGBColor()
   * @generated
   */
  EAttribute getRGBColor_R();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.fx.code.compensator.hsl.hSL.RGBColor#getG <em>G</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>G</em>'.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.RGBColor#getG()
   * @see #getRGBColor()
   * @generated
   */
  EAttribute getRGBColor_G();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.fx.code.compensator.hsl.hSL.RGBColor#getB <em>B</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>B</em>'.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.RGBColor#getB()
   * @see #getRGBColor()
   * @generated
   */
  EAttribute getRGBColor_B();

  /**
   * Returns the meta object for class '{@link org.eclipse.fx.code.compensator.hsl.hSL.Font <em>Font</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Font</em>'.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.Font
   * @generated
   */
  EClass getFont();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.fx.code.compensator.hsl.hSL.Font#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.Font#getName()
   * @see #getFont()
   * @generated
   */
  EAttribute getFont_Name();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.fx.code.compensator.hsl.hSL.Font#getSize <em>Size</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Size</em>'.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.Font#getSize()
   * @see #getFont()
   * @generated
   */
  EAttribute getFont_Size();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.fx.code.compensator.hsl.hSL.Font#getAttributes <em>Attributes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Attributes</em>'.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.Font#getAttributes()
   * @see #getFont()
   * @generated
   */
  EAttribute getFont_Attributes();

  /**
   * Returns the meta object for enum '{@link org.eclipse.fx.code.compensator.hsl.hSL.FontType <em>Font Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Font Type</em>'.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.FontType
   * @generated
   */
  EEnum getFontType();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  HSLFactory getHSLFactory();

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
     * The meta object literal for the '{@link org.eclipse.fx.code.compensator.hsl.hSL.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.ModelImpl
     * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.HSLPackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODEL__NAME = eINSTANCE.getModel_Name();

    /**
     * The meta object literal for the '<em><b>Partitions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__PARTITIONS = eINSTANCE.getModel_Partitions();

    /**
     * The meta object literal for the '<em><b>Scanner</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__SCANNER = eINSTANCE.getModel_Scanner();

    /**
     * The meta object literal for the '<em><b>Partitioner</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__PARTITIONER = eINSTANCE.getModel_Partitioner();

    /**
     * The meta object literal for the '{@link org.eclipse.fx.code.compensator.hsl.hSL.impl.PartitionImpl <em>Partition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.PartitionImpl
     * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.HSLPackageImpl#getPartition()
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
     * The meta object literal for the '{@link org.eclipse.fx.code.compensator.hsl.hSL.impl.PartitionerImpl <em>Partitioner</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.PartitionerImpl
     * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.HSLPackageImpl#getPartitioner()
     * @generated
     */
    EClass PARTITIONER = eINSTANCE.getPartitioner();

    /**
     * The meta object literal for the '{@link org.eclipse.fx.code.compensator.hsl.hSL.impl.RulePartitionerImpl <em>Rule Partitioner</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.RulePartitionerImpl
     * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.HSLPackageImpl#getRulePartitioner()
     * @generated
     */
    EClass RULE_PARTITIONER = eINSTANCE.getRulePartitioner();

    /**
     * The meta object literal for the '<em><b>Rules</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RULE_PARTITIONER__RULES = eINSTANCE.getRulePartitioner_Rules();

    /**
     * The meta object literal for the '{@link org.eclipse.fx.code.compensator.hsl.hSL.impl.JSParitionerImpl <em>JS Paritioner</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.JSParitionerImpl
     * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.HSLPackageImpl#getJSParitioner()
     * @generated
     */
    EClass JS_PARITIONER = eINSTANCE.getJSParitioner();

    /**
     * The meta object literal for the '<em><b>File URI</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute JS_PARITIONER__FILE_URI = eINSTANCE.getJSParitioner_FileURI();

    /**
     * The meta object literal for the '{@link org.eclipse.fx.code.compensator.hsl.hSL.impl.ScannerImpl <em>Scanner</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.ScannerImpl
     * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.HSLPackageImpl#getScanner()
     * @generated
     */
    EClass SCANNER = eINSTANCE.getScanner();

    /**
     * The meta object literal for the '<em><b>Partition</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SCANNER__PARTITION = eINSTANCE.getScanner_Partition();

    /**
     * The meta object literal for the '<em><b>Tokens</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SCANNER__TOKENS = eINSTANCE.getScanner_Tokens();

    /**
     * The meta object literal for the '<em><b>Keyword Groups</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SCANNER__KEYWORD_GROUPS = eINSTANCE.getScanner_KeywordGroups();

    /**
     * The meta object literal for the '<em><b>Rules</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SCANNER__RULES = eINSTANCE.getScanner_Rules();

    /**
     * The meta object literal for the '{@link org.eclipse.fx.code.compensator.hsl.hSL.impl.ScannerTokenImpl <em>Scanner Token</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.ScannerTokenImpl
     * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.HSLPackageImpl#getScannerToken()
     * @generated
     */
    EClass SCANNER_TOKEN = eINSTANCE.getScannerToken();

    /**
     * The meta object literal for the '<em><b>Default</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SCANNER_TOKEN__DEFAULT = eINSTANCE.getScannerToken_Default();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SCANNER_TOKEN__NAME = eINSTANCE.getScannerToken_Name();

    /**
     * The meta object literal for the '<em><b>Fg Color</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SCANNER_TOKEN__FG_COLOR = eINSTANCE.getScannerToken_FgColor();

    /**
     * The meta object literal for the '<em><b>Bg Color</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SCANNER_TOKEN__BG_COLOR = eINSTANCE.getScannerToken_BgColor();

    /**
     * The meta object literal for the '<em><b>Font</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SCANNER_TOKEN__FONT = eINSTANCE.getScannerToken_Font();

    /**
     * The meta object literal for the '{@link org.eclipse.fx.code.compensator.hsl.hSL.impl.KeywordGroupImpl <em>Keyword Group</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.KeywordGroupImpl
     * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.HSLPackageImpl#getKeywordGroup()
     * @generated
     */
    EClass KEYWORD_GROUP = eINSTANCE.getKeywordGroup();

    /**
     * The meta object literal for the '<em><b>Token</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference KEYWORD_GROUP__TOKEN = eINSTANCE.getKeywordGroup_Token();

    /**
     * The meta object literal for the '<em><b>Keywords</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference KEYWORD_GROUP__KEYWORDS = eINSTANCE.getKeywordGroup_Keywords();

    /**
     * The meta object literal for the '{@link org.eclipse.fx.code.compensator.hsl.hSL.impl.KeywordImpl <em>Keyword</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.KeywordImpl
     * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.HSLPackageImpl#getKeyword()
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
     * The meta object literal for the '{@link org.eclipse.fx.code.compensator.hsl.hSL.impl.ScannerRuleImpl <em>Scanner Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.ScannerRuleImpl
     * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.HSLPackageImpl#getScannerRule()
     * @generated
     */
    EClass SCANNER_RULE = eINSTANCE.getScannerRule();

    /**
     * The meta object literal for the '<em><b>Token</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SCANNER_RULE__TOKEN = eINSTANCE.getScannerRule_Token();

    /**
     * The meta object literal for the '{@link org.eclipse.fx.code.compensator.hsl.hSL.impl.ParitionRuleImpl <em>Parition Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.ParitionRuleImpl
     * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.HSLPackageImpl#getParitionRule()
     * @generated
     */
    EClass PARITION_RULE = eINSTANCE.getParitionRule();

    /**
     * The meta object literal for the '{@link org.eclipse.fx.code.compensator.hsl.hSL.impl.ScannerSingleLineRuleImpl <em>Scanner Single Line Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.ScannerSingleLineRuleImpl
     * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.HSLPackageImpl#getScannerSingleLineRule()
     * @generated
     */
    EClass SCANNER_SINGLE_LINE_RULE = eINSTANCE.getScannerSingleLineRule();

    /**
     * The meta object literal for the '<em><b>Start Seq</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SCANNER_SINGLE_LINE_RULE__START_SEQ = eINSTANCE.getScannerSingleLineRule_StartSeq();

    /**
     * The meta object literal for the '<em><b>End Seq</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SCANNER_SINGLE_LINE_RULE__END_SEQ = eINSTANCE.getScannerSingleLineRule_EndSeq();

    /**
     * The meta object literal for the '<em><b>Escape Seq</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SCANNER_SINGLE_LINE_RULE__ESCAPE_SEQ = eINSTANCE.getScannerSingleLineRule_EscapeSeq();

    /**
     * The meta object literal for the '{@link org.eclipse.fx.code.compensator.hsl.hSL.impl.PartitionSingleLineRuleImpl <em>Partition Single Line Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.PartitionSingleLineRuleImpl
     * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.HSLPackageImpl#getPartitionSingleLineRule()
     * @generated
     */
    EClass PARTITION_SINGLE_LINE_RULE = eINSTANCE.getPartitionSingleLineRule();

    /**
     * The meta object literal for the '<em><b>Parition</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PARTITION_SINGLE_LINE_RULE__PARITION = eINSTANCE.getPartitionSingleLineRule_Parition();

    /**
     * The meta object literal for the '<em><b>Start Seq</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PARTITION_SINGLE_LINE_RULE__START_SEQ = eINSTANCE.getPartitionSingleLineRule_StartSeq();

    /**
     * The meta object literal for the '<em><b>End Seq</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PARTITION_SINGLE_LINE_RULE__END_SEQ = eINSTANCE.getPartitionSingleLineRule_EndSeq();

    /**
     * The meta object literal for the '<em><b>Escape Seq</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PARTITION_SINGLE_LINE_RULE__ESCAPE_SEQ = eINSTANCE.getPartitionSingleLineRule_EscapeSeq();

    /**
     * The meta object literal for the '{@link org.eclipse.fx.code.compensator.hsl.hSL.impl.ScannerMultiLineRuleImpl <em>Scanner Multi Line Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.ScannerMultiLineRuleImpl
     * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.HSLPackageImpl#getScannerMultiLineRule()
     * @generated
     */
    EClass SCANNER_MULTI_LINE_RULE = eINSTANCE.getScannerMultiLineRule();

    /**
     * The meta object literal for the '<em><b>Start Seq</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SCANNER_MULTI_LINE_RULE__START_SEQ = eINSTANCE.getScannerMultiLineRule_StartSeq();

    /**
     * The meta object literal for the '<em><b>End Seq</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SCANNER_MULTI_LINE_RULE__END_SEQ = eINSTANCE.getScannerMultiLineRule_EndSeq();

    /**
     * The meta object literal for the '<em><b>Escape Seq</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SCANNER_MULTI_LINE_RULE__ESCAPE_SEQ = eINSTANCE.getScannerMultiLineRule_EscapeSeq();

    /**
     * The meta object literal for the '{@link org.eclipse.fx.code.compensator.hsl.hSL.impl.PartitionMultiLineRuleImpl <em>Partition Multi Line Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.PartitionMultiLineRuleImpl
     * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.HSLPackageImpl#getPartitionMultiLineRule()
     * @generated
     */
    EClass PARTITION_MULTI_LINE_RULE = eINSTANCE.getPartitionMultiLineRule();

    /**
     * The meta object literal for the '<em><b>Token</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PARTITION_MULTI_LINE_RULE__TOKEN = eINSTANCE.getPartitionMultiLineRule_Token();

    /**
     * The meta object literal for the '<em><b>Start Seq</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PARTITION_MULTI_LINE_RULE__START_SEQ = eINSTANCE.getPartitionMultiLineRule_StartSeq();

    /**
     * The meta object literal for the '<em><b>End Seq</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PARTITION_MULTI_LINE_RULE__END_SEQ = eINSTANCE.getPartitionMultiLineRule_EndSeq();

    /**
     * The meta object literal for the '<em><b>Escape Seq</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PARTITION_MULTI_LINE_RULE__ESCAPE_SEQ = eINSTANCE.getPartitionMultiLineRule_EscapeSeq();

    /**
     * The meta object literal for the '{@link org.eclipse.fx.code.compensator.hsl.hSL.impl.ScannerCharacterRuleImpl <em>Scanner Character Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.ScannerCharacterRuleImpl
     * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.HSLPackageImpl#getScannerCharacterRule()
     * @generated
     */
    EClass SCANNER_CHARACTER_RULE = eINSTANCE.getScannerCharacterRule();

    /**
     * The meta object literal for the '<em><b>Characters</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SCANNER_CHARACTER_RULE__CHARACTERS = eINSTANCE.getScannerCharacterRule_Characters();

    /**
     * The meta object literal for the '{@link org.eclipse.fx.code.compensator.hsl.hSL.impl.ScannerJSRuleImpl <em>Scanner JS Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.ScannerJSRuleImpl
     * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.HSLPackageImpl#getScannerJSRule()
     * @generated
     */
    EClass SCANNER_JS_RULE = eINSTANCE.getScannerJSRule();

    /**
     * The meta object literal for the '<em><b>File URI</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SCANNER_JS_RULE__FILE_URI = eINSTANCE.getScannerJSRule_FileURI();

    /**
     * The meta object literal for the '{@link org.eclipse.fx.code.compensator.hsl.hSL.impl.PartitionJSRuleImpl <em>Partition JS Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.PartitionJSRuleImpl
     * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.HSLPackageImpl#getPartitionJSRule()
     * @generated
     */
    EClass PARTITION_JS_RULE = eINSTANCE.getPartitionJSRule();

    /**
     * The meta object literal for the '<em><b>Token</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PARTITION_JS_RULE__TOKEN = eINSTANCE.getPartitionJSRule_Token();

    /**
     * The meta object literal for the '<em><b>File URI</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PARTITION_JS_RULE__FILE_URI = eINSTANCE.getPartitionJSRule_FileURI();

    /**
     * The meta object literal for the '{@link org.eclipse.fx.code.compensator.hsl.hSL.impl.ScannerWhitespaceRuleImpl <em>Scanner Whitespace Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.ScannerWhitespaceRuleImpl
     * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.HSLPackageImpl#getScannerWhitespaceRule()
     * @generated
     */
    EClass SCANNER_WHITESPACE_RULE = eINSTANCE.getScannerWhitespaceRule();

    /**
     * The meta object literal for the '<em><b>Characters</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SCANNER_WHITESPACE_RULE__CHARACTERS = eINSTANCE.getScannerWhitespaceRule_Characters();

    /**
     * The meta object literal for the '<em><b>Js Method</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SCANNER_WHITESPACE_RULE__JS_METHOD = eINSTANCE.getScannerWhitespaceRule_JsMethod();

    /**
     * The meta object literal for the '{@link org.eclipse.fx.code.compensator.hsl.hSL.impl.ColorImpl <em>Color</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.ColorImpl
     * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.HSLPackageImpl#getColor()
     * @generated
     */
    EClass COLOR = eINSTANCE.getColor();

    /**
     * The meta object literal for the '{@link org.eclipse.fx.code.compensator.hsl.hSL.impl.RGBColorImpl <em>RGB Color</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.RGBColorImpl
     * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.HSLPackageImpl#getRGBColor()
     * @generated
     */
    EClass RGB_COLOR = eINSTANCE.getRGBColor();

    /**
     * The meta object literal for the '<em><b>R</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RGB_COLOR__R = eINSTANCE.getRGBColor_R();

    /**
     * The meta object literal for the '<em><b>G</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RGB_COLOR__G = eINSTANCE.getRGBColor_G();

    /**
     * The meta object literal for the '<em><b>B</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RGB_COLOR__B = eINSTANCE.getRGBColor_B();

    /**
     * The meta object literal for the '{@link org.eclipse.fx.code.compensator.hsl.hSL.impl.FontImpl <em>Font</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.FontImpl
     * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.HSLPackageImpl#getFont()
     * @generated
     */
    EClass FONT = eINSTANCE.getFont();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FONT__NAME = eINSTANCE.getFont_Name();

    /**
     * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FONT__SIZE = eINSTANCE.getFont_Size();

    /**
     * The meta object literal for the '<em><b>Attributes</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FONT__ATTRIBUTES = eINSTANCE.getFont_Attributes();

    /**
     * The meta object literal for the '{@link org.eclipse.fx.code.compensator.hsl.hSL.FontType <em>Font Type</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.fx.code.compensator.hsl.hSL.FontType
     * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.HSLPackageImpl#getFontType()
     * @generated
     */
    EEnum FONT_TYPE = eINSTANCE.getFontType();

  }

} //HSLPackage
