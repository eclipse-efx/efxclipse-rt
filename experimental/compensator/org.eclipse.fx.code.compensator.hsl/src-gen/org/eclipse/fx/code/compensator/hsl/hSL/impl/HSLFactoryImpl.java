/*******************************************************************************
 * Copyright (c) 2022 BestSolution.at and others.
 *  
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *  
 * SPDX-License-Identifier: EPL-2.0
 *  
 * Contributors:
 *     BestSolution.at - initial API and implementation
 *******************************************************************************/
/**
 */
package org.eclipse.fx.code.compensator.hsl.hSL.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.fx.code.compensator.hsl.hSL.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class HSLFactoryImpl extends EFactoryImpl implements HSLFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static HSLFactory init()
  {
    try
    {
      HSLFactory theHSLFactory = (HSLFactory)EPackage.Registry.INSTANCE.getEFactory(HSLPackage.eNS_URI);
      if (theHSLFactory != null)
      {
        return theHSLFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new HSLFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public HSLFactoryImpl()
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
      case HSLPackage.MODEL: return createModel();
      case HSLPackage.PARTITION: return createPartition();
      case HSLPackage.PARTITIONER: return createPartitioner();
      case HSLPackage.JAVA_LIKE_PARITIONER: return createJavaLikeParitioner();
      case HSLPackage.RULE_PARTITIONER: return createRulePartitioner();
      case HSLPackage.JS_PARITIONER: return createJSParitioner();
      case HSLPackage.DAMAGER: return createDamager();
      case HSLPackage.JS_DAMAGER: return createJSDamager();
      case HSLPackage.RULE_DAMAGER: return createRuleDamager();
      case HSLPackage.SCANNER_TOKEN: return createScannerToken();
      case HSLPackage.KEYWORD_GROUP: return createKeywordGroup();
      case HSLPackage.KEYWORD: return createKeyword();
      case HSLPackage.SCANNER_RULE: return createScannerRule();
      case HSLPackage.PARITION_RULE: return createParitionRule();
      case HSLPackage.SCANNER_SINGLE_LINE_RULE: return createScannerSingleLineRule();
      case HSLPackage.PARTITION_SINGLE_LINE_RULE: return createPartitionSingleLineRule();
      case HSLPackage.SCANNER_MULTI_LINE_RULE: return createScannerMultiLineRule();
      case HSLPackage.PARTITION_MULTI_LINE_RULE: return createPartitionMultiLineRule();
      case HSLPackage.SCANNER_CHARACTER_RULE: return createScannerCharacterRule();
      case HSLPackage.SCANNER_JS_RULE: return createScannerJSRule();
      case HSLPackage.PARTITION_JS_RULE: return createPartitionJSRule();
      case HSLPackage.SCANNER_WHITESPACE_RULE: return createScannerWhitespaceRule();
      case HSLPackage.COLOR: return createColor();
      case HSLPackage.RGB_COLOR: return createRGBColor();
      case HSLPackage.FONT: return createFont();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object createFromString(EDataType eDataType, String initialValue)
  {
    switch (eDataType.getClassifierID())
    {
      case HSLPackage.FONT_TYPE:
        return createFontTypeFromString(eDataType, initialValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String convertToString(EDataType eDataType, Object instanceValue)
  {
    switch (eDataType.getClassifierID())
    {
      case HSLPackage.FONT_TYPE:
        return convertFontTypeToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Model createModel()
  {
    ModelImpl model = new ModelImpl();
    return model;
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
  public JavaLikeParitioner createJavaLikeParitioner()
  {
    JavaLikeParitionerImpl javaLikeParitioner = new JavaLikeParitionerImpl();
    return javaLikeParitioner;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RulePartitioner createRulePartitioner()
  {
    RulePartitionerImpl rulePartitioner = new RulePartitionerImpl();
    return rulePartitioner;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JSParitioner createJSParitioner()
  {
    JSParitionerImpl jsParitioner = new JSParitionerImpl();
    return jsParitioner;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Damager createDamager()
  {
    DamagerImpl damager = new DamagerImpl();
    return damager;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JSDamager createJSDamager()
  {
    JSDamagerImpl jsDamager = new JSDamagerImpl();
    return jsDamager;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RuleDamager createRuleDamager()
  {
    RuleDamagerImpl ruleDamager = new RuleDamagerImpl();
    return ruleDamager;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ScannerToken createScannerToken()
  {
    ScannerTokenImpl scannerToken = new ScannerTokenImpl();
    return scannerToken;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public KeywordGroup createKeywordGroup()
  {
    KeywordGroupImpl keywordGroup = new KeywordGroupImpl();
    return keywordGroup;
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
  public ScannerRule createScannerRule()
  {
    ScannerRuleImpl scannerRule = new ScannerRuleImpl();
    return scannerRule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ParitionRule createParitionRule()
  {
    ParitionRuleImpl paritionRule = new ParitionRuleImpl();
    return paritionRule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ScannerSingleLineRule createScannerSingleLineRule()
  {
    ScannerSingleLineRuleImpl scannerSingleLineRule = new ScannerSingleLineRuleImpl();
    return scannerSingleLineRule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PartitionSingleLineRule createPartitionSingleLineRule()
  {
    PartitionSingleLineRuleImpl partitionSingleLineRule = new PartitionSingleLineRuleImpl();
    return partitionSingleLineRule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ScannerMultiLineRule createScannerMultiLineRule()
  {
    ScannerMultiLineRuleImpl scannerMultiLineRule = new ScannerMultiLineRuleImpl();
    return scannerMultiLineRule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PartitionMultiLineRule createPartitionMultiLineRule()
  {
    PartitionMultiLineRuleImpl partitionMultiLineRule = new PartitionMultiLineRuleImpl();
    return partitionMultiLineRule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ScannerCharacterRule createScannerCharacterRule()
  {
    ScannerCharacterRuleImpl scannerCharacterRule = new ScannerCharacterRuleImpl();
    return scannerCharacterRule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ScannerJSRule createScannerJSRule()
  {
    ScannerJSRuleImpl scannerJSRule = new ScannerJSRuleImpl();
    return scannerJSRule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PartitionJSRule createPartitionJSRule()
  {
    PartitionJSRuleImpl partitionJSRule = new PartitionJSRuleImpl();
    return partitionJSRule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ScannerWhitespaceRule createScannerWhitespaceRule()
  {
    ScannerWhitespaceRuleImpl scannerWhitespaceRule = new ScannerWhitespaceRuleImpl();
    return scannerWhitespaceRule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Color createColor()
  {
    ColorImpl color = new ColorImpl();
    return color;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RGBColor createRGBColor()
  {
    RGBColorImpl rgbColor = new RGBColorImpl();
    return rgbColor;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Font createFont()
  {
    FontImpl font = new FontImpl();
    return font;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FontType createFontTypeFromString(EDataType eDataType, String initialValue)
  {
    FontType result = FontType.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertFontTypeToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public HSLPackage getHSLPackage()
  {
    return (HSLPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static HSLPackage getPackage()
  {
    return HSLPackage.eINSTANCE;
  }

} //HSLFactoryImpl
