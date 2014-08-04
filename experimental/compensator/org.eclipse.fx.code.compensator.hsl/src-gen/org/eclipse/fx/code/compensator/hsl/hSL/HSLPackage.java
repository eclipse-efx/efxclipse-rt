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
   * The feature id for the '<em><b>Damagers</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__DAMAGERS = 2;

  /**
   * The feature id for the '<em><b>Partitioner</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__PARTITIONER = 3;

  /**
   * The feature id for the '<em><b>Content Types</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__CONTENT_TYPES = 4;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 5;

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
   * The meta object id for the '{@link org.eclipse.fx.code.compensator.hsl.hSL.impl.JavaLikeParitionerImpl <em>Java Like Paritioner</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.JavaLikeParitionerImpl
   * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.HSLPackageImpl#getJavaLikeParitioner()
   * @generated
   */
  int JAVA_LIKE_PARITIONER = 3;

  /**
   * The feature id for the '<em><b>Single Line Doc Parition</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JAVA_LIKE_PARITIONER__SINGLE_LINE_DOC_PARITION = PARTITIONER_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Multi Line Doc Parition</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JAVA_LIKE_PARITIONER__MULTI_LINE_DOC_PARITION = PARTITIONER_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Java Doc Parition</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JAVA_LIKE_PARITIONER__JAVA_DOC_PARITION = PARTITIONER_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Character Parition</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JAVA_LIKE_PARITIONER__CHARACTER_PARITION = PARTITIONER_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>String Parition</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JAVA_LIKE_PARITIONER__STRING_PARITION = PARTITIONER_FEATURE_COUNT + 4;

  /**
   * The number of structural features of the '<em>Java Like Paritioner</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JAVA_LIKE_PARITIONER_FEATURE_COUNT = PARTITIONER_FEATURE_COUNT + 5;

  /**
   * The meta object id for the '{@link org.eclipse.fx.code.compensator.hsl.hSL.impl.RulePartitionerImpl <em>Rule Partitioner</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.RulePartitionerImpl
   * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.HSLPackageImpl#getRulePartitioner()
   * @generated
   */
  int RULE_PARTITIONER = 4;

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
  int JS_PARITIONER = 5;

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
   * The meta object id for the '{@link org.eclipse.fx.code.compensator.hsl.hSL.impl.DamagerImpl <em>Damager</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.DamagerImpl
   * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.HSLPackageImpl#getDamager()
   * @generated
   */
  int DAMAGER = 6;

  /**
   * The feature id for the '<em><b>Partition</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DAMAGER__PARTITION = 0;

  /**
   * The number of structural features of the '<em>Damager</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DAMAGER_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.fx.code.compensator.hsl.hSL.impl.JSDamagerImpl <em>JS Damager</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.JSDamagerImpl
   * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.HSLPackageImpl#getJSDamager()
   * @generated
   */
  int JS_DAMAGER = 7;

  /**
   * The feature id for the '<em><b>Partition</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JS_DAMAGER__PARTITION = DAMAGER__PARTITION;

  /**
   * The feature id for the '<em><b>File URI</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JS_DAMAGER__FILE_URI = DAMAGER_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>JS Damager</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JS_DAMAGER_FEATURE_COUNT = DAMAGER_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.fx.code.compensator.hsl.hSL.impl.RuleDamagerImpl <em>Rule Damager</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.RuleDamagerImpl
   * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.HSLPackageImpl#getRuleDamager()
   * @generated
   */
  int RULE_DAMAGER = 8;

  /**
   * The feature id for the '<em><b>Partition</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_DAMAGER__PARTITION = DAMAGER__PARTITION;

  /**
   * The feature id for the '<em><b>Tokens</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_DAMAGER__TOKENS = DAMAGER_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Keyword Groups</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_DAMAGER__KEYWORD_GROUPS = DAMAGER_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Rules</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_DAMAGER__RULES = DAMAGER_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Rule Damager</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_DAMAGER_FEATURE_COUNT = DAMAGER_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.eclipse.fx.code.compensator.hsl.hSL.impl.ScannerTokenImpl <em>Scanner Token</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.ScannerTokenImpl
   * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.HSLPackageImpl#getScannerToken()
   * @generated
   */
  int SCANNER_TOKEN = 9;

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
   * The number of structural features of the '<em>Scanner Token</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCANNER_TOKEN_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.fx.code.compensator.hsl.hSL.impl.KeywordGroupImpl <em>Keyword Group</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.KeywordGroupImpl
   * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.HSLPackageImpl#getKeywordGroup()
   * @generated
   */
  int KEYWORD_GROUP = 10;

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
  int KEYWORD = 11;

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
  int SCANNER_RULE = 12;

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
  int PARITION_RULE = 13;

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
  int SCANNER_SINGLE_LINE_RULE = 14;

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
  int PARTITION_SINGLE_LINE_RULE = 15;

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
  int SCANNER_MULTI_LINE_RULE = 16;

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
  int PARTITION_MULTI_LINE_RULE = 17;

  /**
   * The feature id for the '<em><b>Parition</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARTITION_MULTI_LINE_RULE__PARITION = PARITION_RULE_FEATURE_COUNT + 0;

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
  int SCANNER_CHARACTER_RULE = 18;

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
  int SCANNER_JS_RULE = 19;

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
  int PARTITION_JS_RULE = 20;

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
  int SCANNER_WHITESPACE_RULE = 21;

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
   * The feature id for the '<em><b>Javawhitespace</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCANNER_WHITESPACE_RULE__JAVAWHITESPACE = SCANNER_RULE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>File URI</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCANNER_WHITESPACE_RULE__FILE_URI = SCANNER_RULE_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Scanner Whitespace Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCANNER_WHITESPACE_RULE_FEATURE_COUNT = SCANNER_RULE_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.eclipse.fx.code.compensator.hsl.hSL.impl.ColorImpl <em>Color</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.ColorImpl
   * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.HSLPackageImpl#getColor()
   * @generated
   */
  int COLOR = 22;

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
  int RGB_COLOR = 23;

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
  int FONT = 24;

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
  int FONT_TYPE = 25;


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
   * Returns the meta object for the containment reference list '{@link org.eclipse.fx.code.compensator.hsl.hSL.Model#getDamagers <em>Damagers</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Damagers</em>'.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.Model#getDamagers()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Damagers();

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
   * Returns the meta object for the attribute list '{@link org.eclipse.fx.code.compensator.hsl.hSL.Model#getContentTypes <em>Content Types</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Content Types</em>'.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.Model#getContentTypes()
   * @see #getModel()
   * @generated
   */
  EAttribute getModel_ContentTypes();

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
   * Returns the meta object for class '{@link org.eclipse.fx.code.compensator.hsl.hSL.JavaLikeParitioner <em>Java Like Paritioner</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Java Like Paritioner</em>'.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.JavaLikeParitioner
   * @generated
   */
  EClass getJavaLikeParitioner();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.fx.code.compensator.hsl.hSL.JavaLikeParitioner#getSingleLineDocParition <em>Single Line Doc Parition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Single Line Doc Parition</em>'.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.JavaLikeParitioner#getSingleLineDocParition()
   * @see #getJavaLikeParitioner()
   * @generated
   */
  EReference getJavaLikeParitioner_SingleLineDocParition();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.fx.code.compensator.hsl.hSL.JavaLikeParitioner#getMultiLineDocParition <em>Multi Line Doc Parition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Multi Line Doc Parition</em>'.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.JavaLikeParitioner#getMultiLineDocParition()
   * @see #getJavaLikeParitioner()
   * @generated
   */
  EReference getJavaLikeParitioner_MultiLineDocParition();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.fx.code.compensator.hsl.hSL.JavaLikeParitioner#getJavaDocParition <em>Java Doc Parition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Java Doc Parition</em>'.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.JavaLikeParitioner#getJavaDocParition()
   * @see #getJavaLikeParitioner()
   * @generated
   */
  EReference getJavaLikeParitioner_JavaDocParition();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.fx.code.compensator.hsl.hSL.JavaLikeParitioner#getCharacterParition <em>Character Parition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Character Parition</em>'.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.JavaLikeParitioner#getCharacterParition()
   * @see #getJavaLikeParitioner()
   * @generated
   */
  EReference getJavaLikeParitioner_CharacterParition();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.fx.code.compensator.hsl.hSL.JavaLikeParitioner#getStringParition <em>String Parition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>String Parition</em>'.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.JavaLikeParitioner#getStringParition()
   * @see #getJavaLikeParitioner()
   * @generated
   */
  EReference getJavaLikeParitioner_StringParition();

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
   * Returns the meta object for class '{@link org.eclipse.fx.code.compensator.hsl.hSL.Damager <em>Damager</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Damager</em>'.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.Damager
   * @generated
   */
  EClass getDamager();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.fx.code.compensator.hsl.hSL.Damager#getPartition <em>Partition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Partition</em>'.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.Damager#getPartition()
   * @see #getDamager()
   * @generated
   */
  EReference getDamager_Partition();

  /**
   * Returns the meta object for class '{@link org.eclipse.fx.code.compensator.hsl.hSL.JSDamager <em>JS Damager</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>JS Damager</em>'.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.JSDamager
   * @generated
   */
  EClass getJSDamager();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.fx.code.compensator.hsl.hSL.JSDamager#getFileURI <em>File URI</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>File URI</em>'.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.JSDamager#getFileURI()
   * @see #getJSDamager()
   * @generated
   */
  EAttribute getJSDamager_FileURI();

  /**
   * Returns the meta object for class '{@link org.eclipse.fx.code.compensator.hsl.hSL.RuleDamager <em>Rule Damager</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Rule Damager</em>'.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.RuleDamager
   * @generated
   */
  EClass getRuleDamager();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.fx.code.compensator.hsl.hSL.RuleDamager#getTokens <em>Tokens</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Tokens</em>'.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.RuleDamager#getTokens()
   * @see #getRuleDamager()
   * @generated
   */
  EReference getRuleDamager_Tokens();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.fx.code.compensator.hsl.hSL.RuleDamager#getKeywordGroups <em>Keyword Groups</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Keyword Groups</em>'.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.RuleDamager#getKeywordGroups()
   * @see #getRuleDamager()
   * @generated
   */
  EReference getRuleDamager_KeywordGroups();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.fx.code.compensator.hsl.hSL.RuleDamager#getRules <em>Rules</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Rules</em>'.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.RuleDamager#getRules()
   * @see #getRuleDamager()
   * @generated
   */
  EReference getRuleDamager_Rules();

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
   * Returns the meta object for the reference '{@link org.eclipse.fx.code.compensator.hsl.hSL.PartitionMultiLineRule#getParition <em>Parition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Parition</em>'.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.PartitionMultiLineRule#getParition()
   * @see #getPartitionMultiLineRule()
   * @generated
   */
  EReference getPartitionMultiLineRule_Parition();

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
   * Returns the meta object for the attribute '{@link org.eclipse.fx.code.compensator.hsl.hSL.ScannerWhitespaceRule#isJavawhitespace <em>Javawhitespace</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Javawhitespace</em>'.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.ScannerWhitespaceRule#isJavawhitespace()
   * @see #getScannerWhitespaceRule()
   * @generated
   */
  EAttribute getScannerWhitespaceRule_Javawhitespace();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.fx.code.compensator.hsl.hSL.ScannerWhitespaceRule#getFileURI <em>File URI</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>File URI</em>'.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.ScannerWhitespaceRule#getFileURI()
   * @see #getScannerWhitespaceRule()
   * @generated
   */
  EAttribute getScannerWhitespaceRule_FileURI();

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
     * The meta object literal for the '<em><b>Damagers</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__DAMAGERS = eINSTANCE.getModel_Damagers();

    /**
     * The meta object literal for the '<em><b>Partitioner</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__PARTITIONER = eINSTANCE.getModel_Partitioner();

    /**
     * The meta object literal for the '<em><b>Content Types</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODEL__CONTENT_TYPES = eINSTANCE.getModel_ContentTypes();

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
     * The meta object literal for the '{@link org.eclipse.fx.code.compensator.hsl.hSL.impl.JavaLikeParitionerImpl <em>Java Like Paritioner</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.JavaLikeParitionerImpl
     * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.HSLPackageImpl#getJavaLikeParitioner()
     * @generated
     */
    EClass JAVA_LIKE_PARITIONER = eINSTANCE.getJavaLikeParitioner();

    /**
     * The meta object literal for the '<em><b>Single Line Doc Parition</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference JAVA_LIKE_PARITIONER__SINGLE_LINE_DOC_PARITION = eINSTANCE.getJavaLikeParitioner_SingleLineDocParition();

    /**
     * The meta object literal for the '<em><b>Multi Line Doc Parition</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference JAVA_LIKE_PARITIONER__MULTI_LINE_DOC_PARITION = eINSTANCE.getJavaLikeParitioner_MultiLineDocParition();

    /**
     * The meta object literal for the '<em><b>Java Doc Parition</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference JAVA_LIKE_PARITIONER__JAVA_DOC_PARITION = eINSTANCE.getJavaLikeParitioner_JavaDocParition();

    /**
     * The meta object literal for the '<em><b>Character Parition</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference JAVA_LIKE_PARITIONER__CHARACTER_PARITION = eINSTANCE.getJavaLikeParitioner_CharacterParition();

    /**
     * The meta object literal for the '<em><b>String Parition</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference JAVA_LIKE_PARITIONER__STRING_PARITION = eINSTANCE.getJavaLikeParitioner_StringParition();

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
     * The meta object literal for the '{@link org.eclipse.fx.code.compensator.hsl.hSL.impl.DamagerImpl <em>Damager</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.DamagerImpl
     * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.HSLPackageImpl#getDamager()
     * @generated
     */
    EClass DAMAGER = eINSTANCE.getDamager();

    /**
     * The meta object literal for the '<em><b>Partition</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DAMAGER__PARTITION = eINSTANCE.getDamager_Partition();

    /**
     * The meta object literal for the '{@link org.eclipse.fx.code.compensator.hsl.hSL.impl.JSDamagerImpl <em>JS Damager</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.JSDamagerImpl
     * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.HSLPackageImpl#getJSDamager()
     * @generated
     */
    EClass JS_DAMAGER = eINSTANCE.getJSDamager();

    /**
     * The meta object literal for the '<em><b>File URI</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute JS_DAMAGER__FILE_URI = eINSTANCE.getJSDamager_FileURI();

    /**
     * The meta object literal for the '{@link org.eclipse.fx.code.compensator.hsl.hSL.impl.RuleDamagerImpl <em>Rule Damager</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.RuleDamagerImpl
     * @see org.eclipse.fx.code.compensator.hsl.hSL.impl.HSLPackageImpl#getRuleDamager()
     * @generated
     */
    EClass RULE_DAMAGER = eINSTANCE.getRuleDamager();

    /**
     * The meta object literal for the '<em><b>Tokens</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RULE_DAMAGER__TOKENS = eINSTANCE.getRuleDamager_Tokens();

    /**
     * The meta object literal for the '<em><b>Keyword Groups</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RULE_DAMAGER__KEYWORD_GROUPS = eINSTANCE.getRuleDamager_KeywordGroups();

    /**
     * The meta object literal for the '<em><b>Rules</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RULE_DAMAGER__RULES = eINSTANCE.getRuleDamager_Rules();

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
     * The meta object literal for the '<em><b>Parition</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PARTITION_MULTI_LINE_RULE__PARITION = eINSTANCE.getPartitionMultiLineRule_Parition();

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
     * The meta object literal for the '<em><b>Javawhitespace</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SCANNER_WHITESPACE_RULE__JAVAWHITESPACE = eINSTANCE.getScannerWhitespaceRule_Javawhitespace();

    /**
     * The meta object literal for the '<em><b>File URI</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SCANNER_WHITESPACE_RULE__FILE_URI = eINSTANCE.getScannerWhitespaceRule_FileURI();

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
