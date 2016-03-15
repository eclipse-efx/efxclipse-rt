/**
 */
package org.eclipse.fx.code.editor.ldef.lDef;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.fx.code.editor.ldef.lDef.LDefPackage
 * @generated
 */
public interface LDefFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  LDefFactory eINSTANCE = org.eclipse.fx.code.editor.ldef.lDef.impl.LDefFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Root</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Root</em>'.
   * @generated
   */
  Root createRoot();

  /**
   * Returns a new object of class '<em>Import</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Import</em>'.
   * @generated
   */
  Import createImport();

  /**
   * Returns a new object of class '<em>Language Def</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Language Def</em>'.
   * @generated
   */
  LanguageDef createLanguageDef();

  /**
   * Returns a new object of class '<em>Integration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Integration</em>'.
   * @generated
   */
  Integration createIntegration();

  /**
   * Returns a new object of class '<em>Code Integration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Code Integration</em>'.
   * @generated
   */
  CodeIntegration createCodeIntegration();

  /**
   * Returns a new object of class '<em>Java FX Integration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Java FX Integration</em>'.
   * @generated
   */
  JavaFXIntegration createJavaFXIntegration();

  /**
   * Returns a new object of class '<em>Codegeneration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Codegeneration</em>'.
   * @generated
   */
  Codegeneration createCodegeneration();

  /**
   * Returns a new object of class '<em>Java Code Generation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Java Code Generation</em>'.
   * @generated
   */
  JavaCodeGeneration createJavaCodeGeneration();

  /**
   * Returns a new object of class '<em>E4 Code Generation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>E4 Code Generation</em>'.
   * @generated
   */
  E4CodeGeneration createE4CodeGeneration();

  /**
   * Returns a new object of class '<em>Config Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Config Value</em>'.
   * @generated
   */
  ConfigValue createConfigValue();

  /**
   * Returns a new object of class '<em>Paritioning</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Paritioning</em>'.
   * @generated
   */
  Paritioning createParitioning();

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
   * Returns a new object of class '<em>Paritioner JS</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Paritioner JS</em>'.
   * @generated
   */
  Paritioner_JS createParitioner_JS();

  /**
   * Returns a new object of class '<em>Partitioner Rule</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Partitioner Rule</em>'.
   * @generated
   */
  Partitioner_Rule createPartitioner_Rule();

  /**
   * Returns a new object of class '<em>Partition Rule</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Partition Rule</em>'.
   * @generated
   */
  Partition_Rule createPartition_Rule();

  /**
   * Returns a new object of class '<em>Partition Single Line Rule</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Partition Single Line Rule</em>'.
   * @generated
   */
  Partition_SingleLineRule createPartition_SingleLineRule();

  /**
   * Returns a new object of class '<em>Partition Multi Line Rule</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Partition Multi Line Rule</em>'.
   * @generated
   */
  Partition_MultiLineRule createPartition_MultiLineRule();

  /**
   * Returns a new object of class '<em>Lexical Highlighting</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Lexical Highlighting</em>'.
   * @generated
   */
  LexicalHighlighting createLexicalHighlighting();

  /**
   * Returns a new object of class '<em>Token Visuals</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Token Visuals</em>'.
   * @generated
   */
  TokenVisuals createTokenVisuals();

  /**
   * Returns a new object of class '<em>Token Visual</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Token Visual</em>'.
   * @generated
   */
  TokenVisual createTokenVisual();

  /**
   * Returns a new object of class '<em>Lexical Partition Highlighting</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Lexical Partition Highlighting</em>'.
   * @generated
   */
  LexicalPartitionHighlighting createLexicalPartitionHighlighting();

  /**
   * Returns a new object of class '<em>Lexical Partition Highlighting JS</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Lexical Partition Highlighting JS</em>'.
   * @generated
   */
  LexicalPartitionHighlighting_JS createLexicalPartitionHighlighting_JS();

  /**
   * Returns a new object of class '<em>Lexical Partition Highlighting Rule</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Lexical Partition Highlighting Rule</em>'.
   * @generated
   */
  LexicalPartitionHighlighting_Rule createLexicalPartitionHighlighting_Rule();

  /**
   * Returns a new object of class '<em>Token</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Token</em>'.
   * @generated
   */
  Token createToken();

  /**
   * Returns a new object of class '<em>Scanner</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Scanner</em>'.
   * @generated
   */
  Scanner createScanner();

  /**
   * Returns a new object of class '<em>Scanner Keyword</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Scanner Keyword</em>'.
   * @generated
   */
  Scanner_Keyword createScanner_Keyword();

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
  Scanner_Rule createScanner_Rule();

  /**
   * Returns a new object of class '<em>Scanner Single Line Rule</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Scanner Single Line Rule</em>'.
   * @generated
   */
  Scanner_SingleLineRule createScanner_SingleLineRule();

  /**
   * Returns a new object of class '<em>Scanner Multi Line Rule</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Scanner Multi Line Rule</em>'.
   * @generated
   */
  Scanner_MultiLineRule createScanner_MultiLineRule();

  /**
   * Returns a new object of class '<em>Scanner Pattern Rule</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Scanner Pattern Rule</em>'.
   * @generated
   */
  Scanner_PatternRule createScanner_PatternRule();

  /**
   * Returns a new object of class '<em>Scanner Character Rule</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Scanner Character Rule</em>'.
   * @generated
   */
  Scanner_CharacterRule createScanner_CharacterRule();

  /**
   * Returns a new object of class '<em>Scanner JS Rule</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Scanner JS Rule</em>'.
   * @generated
   */
  Scanner_JSRule createScanner_JSRule();

  /**
   * Returns a new object of class '<em>Scanner Condition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Scanner Condition</em>'.
   * @generated
   */
  ScannerCondition createScannerCondition();

  /**
   * Returns a new object of class '<em>Scanner Condition Composite</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Scanner Condition Composite</em>'.
   * @generated
   */
  ScannerConditionComposite createScannerConditionComposite();

  /**
   * Returns a new object of class '<em>Scanner Condition Exists</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Scanner Condition Exists</em>'.
   * @generated
   */
  ScannerConditionExists createScannerConditionExists();

  /**
   * Returns a new object of class '<em>Scanner Condition Equals</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Scanner Condition Equals</em>'.
   * @generated
   */
  ScannerConditionEquals createScannerConditionEquals();

  /**
   * Returns a new object of class '<em>Scanner Condition Js</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Scanner Condition Js</em>'.
   * @generated
   */
  ScannerConditionJs createScannerConditionJs();

  /**
   * Returns a new object of class '<em>Check</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Check</em>'.
   * @generated
   */
  Check createCheck();

  /**
   * Returns a new object of class '<em>Equals</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Equals</em>'.
   * @generated
   */
  Equals createEquals();

  /**
   * Returns a new object of class '<em>Range</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Range</em>'.
   * @generated
   */
  Range createRange();

  /**
   * Returns a new object of class '<em>Whitespace Rule</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Whitespace Rule</em>'.
   * @generated
   */
  WhitespaceRule createWhitespaceRule();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  LDefPackage getLDefPackage();

} //LDefFactory
