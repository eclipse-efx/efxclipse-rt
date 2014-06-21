/**
 */
package org.eclipse.fx.code.compensator.hsl.hSL;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.fx.code.compensator.hsl.hSL.HSLPackage
 * @generated
 */
public interface HSLFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  HSLFactory eINSTANCE = org.eclipse.fx.code.compensator.hsl.hSL.impl.HSLFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Model</em>'.
   * @generated
   */
  Model createModel();

  /**
   * Returns a new object of class '<em>Partition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Partition</em>'.
   * @generated
   */
  Partition createPartition();

  /**
   * Returns a new object of class '<em>Partitioner</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Partitioner</em>'.
   * @generated
   */
  Partitioner createPartitioner();

  /**
   * Returns a new object of class '<em>Rule Partitioner</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Rule Partitioner</em>'.
   * @generated
   */
  RulePartitioner createRulePartitioner();

  /**
   * Returns a new object of class '<em>JS Paritioner</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>JS Paritioner</em>'.
   * @generated
   */
  JSParitioner createJSParitioner();

  /**
   * Returns a new object of class '<em>Scanner</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Scanner</em>'.
   * @generated
   */
  Scanner createScanner();

  /**
   * Returns a new object of class '<em>Scanner Token</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Scanner Token</em>'.
   * @generated
   */
  ScannerToken createScannerToken();

  /**
   * Returns a new object of class '<em>Keyword Group</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Keyword Group</em>'.
   * @generated
   */
  KeywordGroup createKeywordGroup();

  /**
   * Returns a new object of class '<em>Keyword</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Keyword</em>'.
   * @generated
   */
  Keyword createKeyword();

  /**
   * Returns a new object of class '<em>Scanner Rule</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Scanner Rule</em>'.
   * @generated
   */
  ScannerRule createScannerRule();

  /**
   * Returns a new object of class '<em>Parition Rule</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Parition Rule</em>'.
   * @generated
   */
  ParitionRule createParitionRule();

  /**
   * Returns a new object of class '<em>Scanner Single Line Rule</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Scanner Single Line Rule</em>'.
   * @generated
   */
  ScannerSingleLineRule createScannerSingleLineRule();

  /**
   * Returns a new object of class '<em>Partition Single Line Rule</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Partition Single Line Rule</em>'.
   * @generated
   */
  PartitionSingleLineRule createPartitionSingleLineRule();

  /**
   * Returns a new object of class '<em>Scanner Multi Line Rule</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Scanner Multi Line Rule</em>'.
   * @generated
   */
  ScannerMultiLineRule createScannerMultiLineRule();

  /**
   * Returns a new object of class '<em>Partition Multi Line Rule</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Partition Multi Line Rule</em>'.
   * @generated
   */
  PartitionMultiLineRule createPartitionMultiLineRule();

  /**
   * Returns a new object of class '<em>Scanner Character Rule</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Scanner Character Rule</em>'.
   * @generated
   */
  ScannerCharacterRule createScannerCharacterRule();

  /**
   * Returns a new object of class '<em>Scanner JS Rule</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Scanner JS Rule</em>'.
   * @generated
   */
  ScannerJSRule createScannerJSRule();

  /**
   * Returns a new object of class '<em>Partition JS Rule</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Partition JS Rule</em>'.
   * @generated
   */
  PartitionJSRule createPartitionJSRule();

  /**
   * Returns a new object of class '<em>Scanner Whitespace Rule</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Scanner Whitespace Rule</em>'.
   * @generated
   */
  ScannerWhitespaceRule createScannerWhitespaceRule();

  /**
   * Returns a new object of class '<em>Color</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Color</em>'.
   * @generated
   */
  Color createColor();

  /**
   * Returns a new object of class '<em>RGB Color</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>RGB Color</em>'.
   * @generated
   */
  RGBColor createRGBColor();

  /**
   * Returns a new object of class '<em>Font</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Font</em>'.
   * @generated
   */
  Font createFont();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  HSLPackage getHSLPackage();

} //HSLFactory
