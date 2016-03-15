/**
 */
package org.eclipse.fx.code.editor.ldef.lDef.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.fx.code.editor.ldef.lDef.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.fx.code.editor.ldef.lDef.LDefPackage
 * @generated
 */
public class LDefSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static LDefPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LDefSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = LDefPackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case LDefPackage.ROOT:
      {
        Root root = (Root)theEObject;
        T result = caseRoot(root);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LDefPackage.IMPORT:
      {
        Import import_ = (Import)theEObject;
        T result = caseImport(import_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LDefPackage.LANGUAGE_DEF:
      {
        LanguageDef languageDef = (LanguageDef)theEObject;
        T result = caseLanguageDef(languageDef);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LDefPackage.INTEGRATION:
      {
        Integration integration = (Integration)theEObject;
        T result = caseIntegration(integration);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LDefPackage.CODE_INTEGRATION:
      {
        CodeIntegration codeIntegration = (CodeIntegration)theEObject;
        T result = caseCodeIntegration(codeIntegration);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LDefPackage.JAVA_FX_INTEGRATION:
      {
        JavaFXIntegration javaFXIntegration = (JavaFXIntegration)theEObject;
        T result = caseJavaFXIntegration(javaFXIntegration);
        if (result == null) result = caseCodeIntegration(javaFXIntegration);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LDefPackage.CODEGENERATION:
      {
        Codegeneration codegeneration = (Codegeneration)theEObject;
        T result = caseCodegeneration(codegeneration);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LDefPackage.JAVA_CODE_GENERATION:
      {
        JavaCodeGeneration javaCodeGeneration = (JavaCodeGeneration)theEObject;
        T result = caseJavaCodeGeneration(javaCodeGeneration);
        if (result == null) result = caseCodegeneration(javaCodeGeneration);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LDefPackage.E4_CODE_GENERATION:
      {
        E4CodeGeneration e4CodeGeneration = (E4CodeGeneration)theEObject;
        T result = caseE4CodeGeneration(e4CodeGeneration);
        if (result == null) result = caseCodegeneration(e4CodeGeneration);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LDefPackage.CONFIG_VALUE:
      {
        ConfigValue configValue = (ConfigValue)theEObject;
        T result = caseConfigValue(configValue);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LDefPackage.PARITIONING:
      {
        Paritioning paritioning = (Paritioning)theEObject;
        T result = caseParitioning(paritioning);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LDefPackage.PARTITION:
      {
        Partition partition = (Partition)theEObject;
        T result = casePartition(partition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LDefPackage.PARTITIONER:
      {
        Partitioner partitioner = (Partitioner)theEObject;
        T result = casePartitioner(partitioner);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LDefPackage.PARITIONER_JS:
      {
        Paritioner_JS paritioner_JS = (Paritioner_JS)theEObject;
        T result = caseParitioner_JS(paritioner_JS);
        if (result == null) result = casePartitioner(paritioner_JS);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LDefPackage.PARTITIONER_RULE:
      {
        Partitioner_Rule partitioner_Rule = (Partitioner_Rule)theEObject;
        T result = casePartitioner_Rule(partitioner_Rule);
        if (result == null) result = casePartitioner(partitioner_Rule);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LDefPackage.PARTITION_RULE:
      {
        Partition_Rule partition_Rule = (Partition_Rule)theEObject;
        T result = casePartition_Rule(partition_Rule);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LDefPackage.PARTITION_SINGLE_LINE_RULE:
      {
        Partition_SingleLineRule partition_SingleLineRule = (Partition_SingleLineRule)theEObject;
        T result = casePartition_SingleLineRule(partition_SingleLineRule);
        if (result == null) result = casePartition_Rule(partition_SingleLineRule);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LDefPackage.PARTITION_MULTI_LINE_RULE:
      {
        Partition_MultiLineRule partition_MultiLineRule = (Partition_MultiLineRule)theEObject;
        T result = casePartition_MultiLineRule(partition_MultiLineRule);
        if (result == null) result = casePartition_Rule(partition_MultiLineRule);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LDefPackage.LEXICAL_HIGHLIGHTING:
      {
        LexicalHighlighting lexicalHighlighting = (LexicalHighlighting)theEObject;
        T result = caseLexicalHighlighting(lexicalHighlighting);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LDefPackage.TOKEN_VISUALS:
      {
        TokenVisuals tokenVisuals = (TokenVisuals)theEObject;
        T result = caseTokenVisuals(tokenVisuals);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LDefPackage.TOKEN_VISUAL:
      {
        TokenVisual tokenVisual = (TokenVisual)theEObject;
        T result = caseTokenVisual(tokenVisual);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LDefPackage.LEXICAL_PARTITION_HIGHLIGHTING:
      {
        LexicalPartitionHighlighting lexicalPartitionHighlighting = (LexicalPartitionHighlighting)theEObject;
        T result = caseLexicalPartitionHighlighting(lexicalPartitionHighlighting);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LDefPackage.LEXICAL_PARTITION_HIGHLIGHTING_JS:
      {
        LexicalPartitionHighlighting_JS lexicalPartitionHighlighting_JS = (LexicalPartitionHighlighting_JS)theEObject;
        T result = caseLexicalPartitionHighlighting_JS(lexicalPartitionHighlighting_JS);
        if (result == null) result = caseLexicalPartitionHighlighting(lexicalPartitionHighlighting_JS);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LDefPackage.LEXICAL_PARTITION_HIGHLIGHTING_RULE:
      {
        LexicalPartitionHighlighting_Rule lexicalPartitionHighlighting_Rule = (LexicalPartitionHighlighting_Rule)theEObject;
        T result = caseLexicalPartitionHighlighting_Rule(lexicalPartitionHighlighting_Rule);
        if (result == null) result = caseLexicalPartitionHighlighting(lexicalPartitionHighlighting_Rule);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LDefPackage.TOKEN:
      {
        Token token = (Token)theEObject;
        T result = caseToken(token);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LDefPackage.SCANNER:
      {
        Scanner scanner = (Scanner)theEObject;
        T result = caseScanner(scanner);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LDefPackage.SCANNER_KEYWORD:
      {
        Scanner_Keyword scanner_Keyword = (Scanner_Keyword)theEObject;
        T result = caseScanner_Keyword(scanner_Keyword);
        if (result == null) result = caseScanner(scanner_Keyword);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LDefPackage.KEYWORD:
      {
        Keyword keyword = (Keyword)theEObject;
        T result = caseKeyword(keyword);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LDefPackage.SCANNER_RULE:
      {
        Scanner_Rule scanner_Rule = (Scanner_Rule)theEObject;
        T result = caseScanner_Rule(scanner_Rule);
        if (result == null) result = caseScanner(scanner_Rule);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LDefPackage.SCANNER_SINGLE_LINE_RULE:
      {
        Scanner_SingleLineRule scanner_SingleLineRule = (Scanner_SingleLineRule)theEObject;
        T result = caseScanner_SingleLineRule(scanner_SingleLineRule);
        if (result == null) result = caseScanner_Rule(scanner_SingleLineRule);
        if (result == null) result = caseScanner(scanner_SingleLineRule);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LDefPackage.SCANNER_MULTI_LINE_RULE:
      {
        Scanner_MultiLineRule scanner_MultiLineRule = (Scanner_MultiLineRule)theEObject;
        T result = caseScanner_MultiLineRule(scanner_MultiLineRule);
        if (result == null) result = caseScanner_Rule(scanner_MultiLineRule);
        if (result == null) result = caseScanner(scanner_MultiLineRule);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LDefPackage.SCANNER_PATTERN_RULE:
      {
        Scanner_PatternRule scanner_PatternRule = (Scanner_PatternRule)theEObject;
        T result = caseScanner_PatternRule(scanner_PatternRule);
        if (result == null) result = caseScanner_Rule(scanner_PatternRule);
        if (result == null) result = caseScanner(scanner_PatternRule);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LDefPackage.SCANNER_CHARACTER_RULE:
      {
        Scanner_CharacterRule scanner_CharacterRule = (Scanner_CharacterRule)theEObject;
        T result = caseScanner_CharacterRule(scanner_CharacterRule);
        if (result == null) result = caseScanner_Rule(scanner_CharacterRule);
        if (result == null) result = caseScanner(scanner_CharacterRule);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LDefPackage.SCANNER_JS_RULE:
      {
        Scanner_JSRule scanner_JSRule = (Scanner_JSRule)theEObject;
        T result = caseScanner_JSRule(scanner_JSRule);
        if (result == null) result = caseScanner_Rule(scanner_JSRule);
        if (result == null) result = caseScanner(scanner_JSRule);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LDefPackage.SCANNER_CONDITION:
      {
        ScannerCondition scannerCondition = (ScannerCondition)theEObject;
        T result = caseScannerCondition(scannerCondition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LDefPackage.SCANNER_CONDITION_COMPOSITE:
      {
        ScannerConditionComposite scannerConditionComposite = (ScannerConditionComposite)theEObject;
        T result = caseScannerConditionComposite(scannerConditionComposite);
        if (result == null) result = caseScannerCondition(scannerConditionComposite);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LDefPackage.SCANNER_CONDITION_EXISTS:
      {
        ScannerConditionExists scannerConditionExists = (ScannerConditionExists)theEObject;
        T result = caseScannerConditionExists(scannerConditionExists);
        if (result == null) result = caseScannerCondition(scannerConditionExists);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LDefPackage.SCANNER_CONDITION_EQUALS:
      {
        ScannerConditionEquals scannerConditionEquals = (ScannerConditionEquals)theEObject;
        T result = caseScannerConditionEquals(scannerConditionEquals);
        if (result == null) result = caseScannerCondition(scannerConditionEquals);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LDefPackage.SCANNER_CONDITION_JS:
      {
        ScannerConditionJs scannerConditionJs = (ScannerConditionJs)theEObject;
        T result = caseScannerConditionJs(scannerConditionJs);
        if (result == null) result = caseScannerCondition(scannerConditionJs);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LDefPackage.CHECK:
      {
        Check check = (Check)theEObject;
        T result = caseCheck(check);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LDefPackage.EQUALS:
      {
        Equals equals = (Equals)theEObject;
        T result = caseEquals(equals);
        if (result == null) result = caseCheck(equals);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LDefPackage.RANGE:
      {
        Range range = (Range)theEObject;
        T result = caseRange(range);
        if (result == null) result = caseCheck(range);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LDefPackage.WHITESPACE_RULE:
      {
        WhitespaceRule whitespaceRule = (WhitespaceRule)theEObject;
        T result = caseWhitespaceRule(whitespaceRule);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Root</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Root</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRoot(Root object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Import</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Import</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseImport(Import object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Language Def</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Language Def</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLanguageDef(LanguageDef object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Integration</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Integration</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIntegration(Integration object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Code Integration</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Code Integration</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCodeIntegration(CodeIntegration object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Java FX Integration</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Java FX Integration</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseJavaFXIntegration(JavaFXIntegration object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Codegeneration</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Codegeneration</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCodegeneration(Codegeneration object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Java Code Generation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Java Code Generation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseJavaCodeGeneration(JavaCodeGeneration object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>E4 Code Generation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>E4 Code Generation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseE4CodeGeneration(E4CodeGeneration object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Config Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Config Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseConfigValue(ConfigValue object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Paritioning</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Paritioning</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseParitioning(Paritioning object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Partition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Partition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePartition(Partition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Partitioner</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Partitioner</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePartitioner(Partitioner object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Paritioner JS</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Paritioner JS</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseParitioner_JS(Paritioner_JS object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Partitioner Rule</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Partitioner Rule</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePartitioner_Rule(Partitioner_Rule object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Partition Rule</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Partition Rule</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePartition_Rule(Partition_Rule object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Partition Single Line Rule</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Partition Single Line Rule</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePartition_SingleLineRule(Partition_SingleLineRule object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Partition Multi Line Rule</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Partition Multi Line Rule</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePartition_MultiLineRule(Partition_MultiLineRule object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Lexical Highlighting</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Lexical Highlighting</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLexicalHighlighting(LexicalHighlighting object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Token Visuals</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Token Visuals</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTokenVisuals(TokenVisuals object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Token Visual</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Token Visual</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTokenVisual(TokenVisual object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Lexical Partition Highlighting</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Lexical Partition Highlighting</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLexicalPartitionHighlighting(LexicalPartitionHighlighting object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Lexical Partition Highlighting JS</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Lexical Partition Highlighting JS</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLexicalPartitionHighlighting_JS(LexicalPartitionHighlighting_JS object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Lexical Partition Highlighting Rule</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Lexical Partition Highlighting Rule</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLexicalPartitionHighlighting_Rule(LexicalPartitionHighlighting_Rule object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Token</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Token</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseToken(Token object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Scanner</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Scanner</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseScanner(Scanner object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Scanner Keyword</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Scanner Keyword</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseScanner_Keyword(Scanner_Keyword object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Keyword</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Keyword</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseKeyword(Keyword object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Scanner Rule</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Scanner Rule</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseScanner_Rule(Scanner_Rule object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Scanner Single Line Rule</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Scanner Single Line Rule</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseScanner_SingleLineRule(Scanner_SingleLineRule object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Scanner Multi Line Rule</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Scanner Multi Line Rule</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseScanner_MultiLineRule(Scanner_MultiLineRule object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Scanner Pattern Rule</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Scanner Pattern Rule</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseScanner_PatternRule(Scanner_PatternRule object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Scanner Character Rule</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Scanner Character Rule</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseScanner_CharacterRule(Scanner_CharacterRule object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Scanner JS Rule</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Scanner JS Rule</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseScanner_JSRule(Scanner_JSRule object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Scanner Condition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Scanner Condition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseScannerCondition(ScannerCondition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Scanner Condition Composite</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Scanner Condition Composite</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseScannerConditionComposite(ScannerConditionComposite object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Scanner Condition Exists</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Scanner Condition Exists</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseScannerConditionExists(ScannerConditionExists object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Scanner Condition Equals</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Scanner Condition Equals</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseScannerConditionEquals(ScannerConditionEquals object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Scanner Condition Js</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Scanner Condition Js</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseScannerConditionJs(ScannerConditionJs object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Check</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Check</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCheck(Check object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Equals</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Equals</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEquals(Equals object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Range</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Range</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRange(Range object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Whitespace Rule</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Whitespace Rule</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseWhitespaceRule(WhitespaceRule object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object)
  {
    return null;
  }

} //LDefSwitch
