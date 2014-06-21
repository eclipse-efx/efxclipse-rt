/**
 */
package org.eclipse.fx.code.compensator.hsl.hSL.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.fx.code.compensator.hsl.hSL.*;

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
 * @see org.eclipse.fx.code.compensator.hsl.hSL.HSLPackage
 * @generated
 */
public class HSLSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static HSLPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public HSLSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = HSLPackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @parameter ePackage the package in question.
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
      case HSLPackage.MODEL:
      {
        Model model = (Model)theEObject;
        T result = caseModel(model);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HSLPackage.PARTITION:
      {
        Partition partition = (Partition)theEObject;
        T result = casePartition(partition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HSLPackage.PARTITIONER:
      {
        Partitioner partitioner = (Partitioner)theEObject;
        T result = casePartitioner(partitioner);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HSLPackage.RULE_PARTITIONER:
      {
        RulePartitioner rulePartitioner = (RulePartitioner)theEObject;
        T result = caseRulePartitioner(rulePartitioner);
        if (result == null) result = casePartitioner(rulePartitioner);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HSLPackage.JS_PARITIONER:
      {
        JSParitioner jsParitioner = (JSParitioner)theEObject;
        T result = caseJSParitioner(jsParitioner);
        if (result == null) result = casePartitioner(jsParitioner);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HSLPackage.SCANNER:
      {
        Scanner scanner = (Scanner)theEObject;
        T result = caseScanner(scanner);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HSLPackage.SCANNER_TOKEN:
      {
        ScannerToken scannerToken = (ScannerToken)theEObject;
        T result = caseScannerToken(scannerToken);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HSLPackage.KEYWORD_GROUP:
      {
        KeywordGroup keywordGroup = (KeywordGroup)theEObject;
        T result = caseKeywordGroup(keywordGroup);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HSLPackage.KEYWORD:
      {
        Keyword keyword = (Keyword)theEObject;
        T result = caseKeyword(keyword);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HSLPackage.SCANNER_RULE:
      {
        ScannerRule scannerRule = (ScannerRule)theEObject;
        T result = caseScannerRule(scannerRule);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HSLPackage.PARITION_RULE:
      {
        ParitionRule paritionRule = (ParitionRule)theEObject;
        T result = caseParitionRule(paritionRule);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HSLPackage.SCANNER_SINGLE_LINE_RULE:
      {
        ScannerSingleLineRule scannerSingleLineRule = (ScannerSingleLineRule)theEObject;
        T result = caseScannerSingleLineRule(scannerSingleLineRule);
        if (result == null) result = caseScannerRule(scannerSingleLineRule);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HSLPackage.PARTITION_SINGLE_LINE_RULE:
      {
        PartitionSingleLineRule partitionSingleLineRule = (PartitionSingleLineRule)theEObject;
        T result = casePartitionSingleLineRule(partitionSingleLineRule);
        if (result == null) result = caseParitionRule(partitionSingleLineRule);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HSLPackage.SCANNER_MULTI_LINE_RULE:
      {
        ScannerMultiLineRule scannerMultiLineRule = (ScannerMultiLineRule)theEObject;
        T result = caseScannerMultiLineRule(scannerMultiLineRule);
        if (result == null) result = caseScannerRule(scannerMultiLineRule);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HSLPackage.PARTITION_MULTI_LINE_RULE:
      {
        PartitionMultiLineRule partitionMultiLineRule = (PartitionMultiLineRule)theEObject;
        T result = casePartitionMultiLineRule(partitionMultiLineRule);
        if (result == null) result = caseParitionRule(partitionMultiLineRule);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HSLPackage.SCANNER_CHARACTER_RULE:
      {
        ScannerCharacterRule scannerCharacterRule = (ScannerCharacterRule)theEObject;
        T result = caseScannerCharacterRule(scannerCharacterRule);
        if (result == null) result = caseScannerRule(scannerCharacterRule);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HSLPackage.SCANNER_JS_RULE:
      {
        ScannerJSRule scannerJSRule = (ScannerJSRule)theEObject;
        T result = caseScannerJSRule(scannerJSRule);
        if (result == null) result = caseScannerRule(scannerJSRule);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HSLPackage.PARTITION_JS_RULE:
      {
        PartitionJSRule partitionJSRule = (PartitionJSRule)theEObject;
        T result = casePartitionJSRule(partitionJSRule);
        if (result == null) result = caseParitionRule(partitionJSRule);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HSLPackage.SCANNER_WHITESPACE_RULE:
      {
        ScannerWhitespaceRule scannerWhitespaceRule = (ScannerWhitespaceRule)theEObject;
        T result = caseScannerWhitespaceRule(scannerWhitespaceRule);
        if (result == null) result = caseScannerRule(scannerWhitespaceRule);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HSLPackage.COLOR:
      {
        Color color = (Color)theEObject;
        T result = caseColor(color);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HSLPackage.RGB_COLOR:
      {
        RGBColor rgbColor = (RGBColor)theEObject;
        T result = caseRGBColor(rgbColor);
        if (result == null) result = caseColor(rgbColor);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HSLPackage.FONT:
      {
        Font font = (Font)theEObject;
        T result = caseFont(font);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Model</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Model</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseModel(Model object)
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
   * Returns the result of interpreting the object as an instance of '<em>Rule Partitioner</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule Partitioner</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRulePartitioner(RulePartitioner object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>JS Paritioner</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>JS Paritioner</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseJSParitioner(JSParitioner object)
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
   * Returns the result of interpreting the object as an instance of '<em>Scanner Token</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Scanner Token</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseScannerToken(ScannerToken object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Keyword Group</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Keyword Group</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseKeywordGroup(KeywordGroup object)
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
  public T caseScannerRule(ScannerRule object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Parition Rule</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Parition Rule</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseParitionRule(ParitionRule object)
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
  public T caseScannerSingleLineRule(ScannerSingleLineRule object)
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
  public T casePartitionSingleLineRule(PartitionSingleLineRule object)
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
  public T caseScannerMultiLineRule(ScannerMultiLineRule object)
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
  public T casePartitionMultiLineRule(PartitionMultiLineRule object)
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
  public T caseScannerCharacterRule(ScannerCharacterRule object)
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
  public T caseScannerJSRule(ScannerJSRule object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Partition JS Rule</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Partition JS Rule</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePartitionJSRule(PartitionJSRule object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Scanner Whitespace Rule</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Scanner Whitespace Rule</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseScannerWhitespaceRule(ScannerWhitespaceRule object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Color</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Color</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseColor(Color object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>RGB Color</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>RGB Color</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRGBColor(RGBColor object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Font</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Font</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFont(Font object)
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

} //HSLSwitch
