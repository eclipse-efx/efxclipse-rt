/**
 */
package org.eclipse.fx.code.compensator.hsl.hSL.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.fx.code.compensator.hsl.hSL.Color;
import org.eclipse.fx.code.compensator.hsl.hSL.Damager;
import org.eclipse.fx.code.compensator.hsl.hSL.Font;
import org.eclipse.fx.code.compensator.hsl.hSL.FontType;
import org.eclipse.fx.code.compensator.hsl.hSL.HSLFactory;
import org.eclipse.fx.code.compensator.hsl.hSL.HSLPackage;
import org.eclipse.fx.code.compensator.hsl.hSL.JSDamager;
import org.eclipse.fx.code.compensator.hsl.hSL.JSParitioner;
import org.eclipse.fx.code.compensator.hsl.hSL.JavaLikeParitioner;
import org.eclipse.fx.code.compensator.hsl.hSL.Keyword;
import org.eclipse.fx.code.compensator.hsl.hSL.KeywordGroup;
import org.eclipse.fx.code.compensator.hsl.hSL.Model;
import org.eclipse.fx.code.compensator.hsl.hSL.ParitionRule;
import org.eclipse.fx.code.compensator.hsl.hSL.Partition;
import org.eclipse.fx.code.compensator.hsl.hSL.PartitionJSRule;
import org.eclipse.fx.code.compensator.hsl.hSL.PartitionMultiLineRule;
import org.eclipse.fx.code.compensator.hsl.hSL.PartitionSingleLineRule;
import org.eclipse.fx.code.compensator.hsl.hSL.Partitioner;
import org.eclipse.fx.code.compensator.hsl.hSL.RGBColor;
import org.eclipse.fx.code.compensator.hsl.hSL.RuleDamager;
import org.eclipse.fx.code.compensator.hsl.hSL.RulePartitioner;
import org.eclipse.fx.code.compensator.hsl.hSL.ScannerCharacterRule;
import org.eclipse.fx.code.compensator.hsl.hSL.ScannerJSRule;
import org.eclipse.fx.code.compensator.hsl.hSL.ScannerMultiLineRule;
import org.eclipse.fx.code.compensator.hsl.hSL.ScannerRule;
import org.eclipse.fx.code.compensator.hsl.hSL.ScannerSingleLineRule;
import org.eclipse.fx.code.compensator.hsl.hSL.ScannerToken;
import org.eclipse.fx.code.compensator.hsl.hSL.ScannerWhitespaceRule;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class HSLPackageImpl extends EPackageImpl implements HSLPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass modelEClass = null;

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
  private EClass javaLikeParitionerEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass rulePartitionerEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass jsParitionerEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass damagerEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass jsDamagerEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass ruleDamagerEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass scannerTokenEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass keywordGroupEClass = null;

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
  private EClass scannerRuleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass paritionRuleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass scannerSingleLineRuleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass partitionSingleLineRuleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass scannerMultiLineRuleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass partitionMultiLineRuleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass scannerCharacterRuleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass scannerJSRuleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass partitionJSRuleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass scannerWhitespaceRuleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass colorEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass rgbColorEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass fontEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum fontTypeEEnum = null;

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
   * @see org.eclipse.fx.code.compensator.hsl.hSL.HSLPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private HSLPackageImpl()
  {
    super(eNS_URI, HSLFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link HSLPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static HSLPackage init()
  {
    if (isInited) return (HSLPackage)EPackage.Registry.INSTANCE.getEPackage(HSLPackage.eNS_URI);

    // Obtain or create and register package
    HSLPackageImpl theHSLPackage = (HSLPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof HSLPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new HSLPackageImpl());

    isInited = true;

    // Create package meta-data objects
    theHSLPackage.createPackageContents();

    // Initialize created meta-data
    theHSLPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theHSLPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(HSLPackage.eNS_URI, theHSLPackage);
    return theHSLPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getModel()
  {
    return modelEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getModel_Name()
  {
    return (EAttribute)modelEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModel_Partitions()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModel_Damagers()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModel_Partitioner()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getModel_ContentTypes()
  {
    return (EAttribute)modelEClass.getEStructuralFeatures().get(4);
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
  public EClass getJavaLikeParitioner()
  {
    return javaLikeParitionerEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getJavaLikeParitioner_SingleLineDocParition()
  {
    return (EReference)javaLikeParitionerEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getJavaLikeParitioner_MultiLineDocParition()
  {
    return (EReference)javaLikeParitionerEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getJavaLikeParitioner_JavaDocParition()
  {
    return (EReference)javaLikeParitionerEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getJavaLikeParitioner_CharacterParition()
  {
    return (EReference)javaLikeParitionerEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getJavaLikeParitioner_StringParition()
  {
    return (EReference)javaLikeParitionerEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRulePartitioner()
  {
    return rulePartitionerEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRulePartitioner_Rules()
  {
    return (EReference)rulePartitionerEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getJSParitioner()
  {
    return jsParitionerEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getJSParitioner_FileURI()
  {
    return (EAttribute)jsParitionerEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDamager()
  {
    return damagerEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDamager_Partition()
  {
    return (EReference)damagerEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getJSDamager()
  {
    return jsDamagerEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getJSDamager_FileURI()
  {
    return (EAttribute)jsDamagerEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRuleDamager()
  {
    return ruleDamagerEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRuleDamager_Tokens()
  {
    return (EReference)ruleDamagerEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRuleDamager_KeywordGroups()
  {
    return (EReference)ruleDamagerEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRuleDamager_Rules()
  {
    return (EReference)ruleDamagerEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getScannerToken()
  {
    return scannerTokenEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getScannerToken_Default()
  {
    return (EAttribute)scannerTokenEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getScannerToken_Name()
  {
    return (EAttribute)scannerTokenEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getScannerToken_FgColor()
  {
    return (EReference)scannerTokenEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getScannerToken_BgColor()
  {
    return (EReference)scannerTokenEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getScannerToken_Font()
  {
    return (EReference)scannerTokenEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getKeywordGroup()
  {
    return keywordGroupEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getKeywordGroup_Token()
  {
    return (EReference)keywordGroupEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getKeywordGroup_Keywords()
  {
    return (EReference)keywordGroupEClass.getEStructuralFeatures().get(1);
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
  public EClass getScannerRule()
  {
    return scannerRuleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getScannerRule_Token()
  {
    return (EReference)scannerRuleEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getParitionRule()
  {
    return paritionRuleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getScannerSingleLineRule()
  {
    return scannerSingleLineRuleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getScannerSingleLineRule_StartSeq()
  {
    return (EAttribute)scannerSingleLineRuleEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getScannerSingleLineRule_EndSeq()
  {
    return (EAttribute)scannerSingleLineRuleEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getScannerSingleLineRule_EscapeSeq()
  {
    return (EAttribute)scannerSingleLineRuleEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPartitionSingleLineRule()
  {
    return partitionSingleLineRuleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPartitionSingleLineRule_Parition()
  {
    return (EReference)partitionSingleLineRuleEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPartitionSingleLineRule_StartSeq()
  {
    return (EAttribute)partitionSingleLineRuleEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPartitionSingleLineRule_EndSeq()
  {
    return (EAttribute)partitionSingleLineRuleEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPartitionSingleLineRule_EscapeSeq()
  {
    return (EAttribute)partitionSingleLineRuleEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getScannerMultiLineRule()
  {
    return scannerMultiLineRuleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getScannerMultiLineRule_StartSeq()
  {
    return (EAttribute)scannerMultiLineRuleEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getScannerMultiLineRule_EndSeq()
  {
    return (EAttribute)scannerMultiLineRuleEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getScannerMultiLineRule_EscapeSeq()
  {
    return (EAttribute)scannerMultiLineRuleEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPartitionMultiLineRule()
  {
    return partitionMultiLineRuleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPartitionMultiLineRule_Parition()
  {
    return (EReference)partitionMultiLineRuleEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPartitionMultiLineRule_StartSeq()
  {
    return (EAttribute)partitionMultiLineRuleEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPartitionMultiLineRule_EndSeq()
  {
    return (EAttribute)partitionMultiLineRuleEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPartitionMultiLineRule_EscapeSeq()
  {
    return (EAttribute)partitionMultiLineRuleEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getScannerCharacterRule()
  {
    return scannerCharacterRuleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getScannerCharacterRule_Characters()
  {
    return (EAttribute)scannerCharacterRuleEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getScannerJSRule()
  {
    return scannerJSRuleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getScannerJSRule_FileURI()
  {
    return (EAttribute)scannerJSRuleEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPartitionJSRule()
  {
    return partitionJSRuleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPartitionJSRule_Token()
  {
    return (EReference)partitionJSRuleEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPartitionJSRule_FileURI()
  {
    return (EAttribute)partitionJSRuleEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getScannerWhitespaceRule()
  {
    return scannerWhitespaceRuleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getScannerWhitespaceRule_Characters()
  {
    return (EAttribute)scannerWhitespaceRuleEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getScannerWhitespaceRule_Javawhitespace()
  {
    return (EAttribute)scannerWhitespaceRuleEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getScannerWhitespaceRule_FileURI()
  {
    return (EAttribute)scannerWhitespaceRuleEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getColor()
  {
    return colorEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRGBColor()
  {
    return rgbColorEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRGBColor_R()
  {
    return (EAttribute)rgbColorEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRGBColor_G()
  {
    return (EAttribute)rgbColorEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRGBColor_B()
  {
    return (EAttribute)rgbColorEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFont()
  {
    return fontEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFont_Name()
  {
    return (EAttribute)fontEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFont_Size()
  {
    return (EAttribute)fontEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFont_Attributes()
  {
    return (EAttribute)fontEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getFontType()
  {
    return fontTypeEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public HSLFactory getHSLFactory()
  {
    return (HSLFactory)getEFactoryInstance();
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
    modelEClass = createEClass(MODEL);
    createEAttribute(modelEClass, MODEL__NAME);
    createEReference(modelEClass, MODEL__PARTITIONS);
    createEReference(modelEClass, MODEL__DAMAGERS);
    createEReference(modelEClass, MODEL__PARTITIONER);
    createEAttribute(modelEClass, MODEL__CONTENT_TYPES);

    partitionEClass = createEClass(PARTITION);
    createEAttribute(partitionEClass, PARTITION__NAME);

    partitionerEClass = createEClass(PARTITIONER);

    javaLikeParitionerEClass = createEClass(JAVA_LIKE_PARITIONER);
    createEReference(javaLikeParitionerEClass, JAVA_LIKE_PARITIONER__SINGLE_LINE_DOC_PARITION);
    createEReference(javaLikeParitionerEClass, JAVA_LIKE_PARITIONER__MULTI_LINE_DOC_PARITION);
    createEReference(javaLikeParitionerEClass, JAVA_LIKE_PARITIONER__JAVA_DOC_PARITION);
    createEReference(javaLikeParitionerEClass, JAVA_LIKE_PARITIONER__CHARACTER_PARITION);
    createEReference(javaLikeParitionerEClass, JAVA_LIKE_PARITIONER__STRING_PARITION);

    rulePartitionerEClass = createEClass(RULE_PARTITIONER);
    createEReference(rulePartitionerEClass, RULE_PARTITIONER__RULES);

    jsParitionerEClass = createEClass(JS_PARITIONER);
    createEAttribute(jsParitionerEClass, JS_PARITIONER__FILE_URI);

    damagerEClass = createEClass(DAMAGER);
    createEReference(damagerEClass, DAMAGER__PARTITION);

    jsDamagerEClass = createEClass(JS_DAMAGER);
    createEAttribute(jsDamagerEClass, JS_DAMAGER__FILE_URI);

    ruleDamagerEClass = createEClass(RULE_DAMAGER);
    createEReference(ruleDamagerEClass, RULE_DAMAGER__TOKENS);
    createEReference(ruleDamagerEClass, RULE_DAMAGER__KEYWORD_GROUPS);
    createEReference(ruleDamagerEClass, RULE_DAMAGER__RULES);

    scannerTokenEClass = createEClass(SCANNER_TOKEN);
    createEAttribute(scannerTokenEClass, SCANNER_TOKEN__DEFAULT);
    createEAttribute(scannerTokenEClass, SCANNER_TOKEN__NAME);
    createEReference(scannerTokenEClass, SCANNER_TOKEN__FG_COLOR);
    createEReference(scannerTokenEClass, SCANNER_TOKEN__BG_COLOR);
    createEReference(scannerTokenEClass, SCANNER_TOKEN__FONT);

    keywordGroupEClass = createEClass(KEYWORD_GROUP);
    createEReference(keywordGroupEClass, KEYWORD_GROUP__TOKEN);
    createEReference(keywordGroupEClass, KEYWORD_GROUP__KEYWORDS);

    keywordEClass = createEClass(KEYWORD);
    createEAttribute(keywordEClass, KEYWORD__NAME);
    createEAttribute(keywordEClass, KEYWORD__VERSION);

    scannerRuleEClass = createEClass(SCANNER_RULE);
    createEReference(scannerRuleEClass, SCANNER_RULE__TOKEN);

    paritionRuleEClass = createEClass(PARITION_RULE);

    scannerSingleLineRuleEClass = createEClass(SCANNER_SINGLE_LINE_RULE);
    createEAttribute(scannerSingleLineRuleEClass, SCANNER_SINGLE_LINE_RULE__START_SEQ);
    createEAttribute(scannerSingleLineRuleEClass, SCANNER_SINGLE_LINE_RULE__END_SEQ);
    createEAttribute(scannerSingleLineRuleEClass, SCANNER_SINGLE_LINE_RULE__ESCAPE_SEQ);

    partitionSingleLineRuleEClass = createEClass(PARTITION_SINGLE_LINE_RULE);
    createEReference(partitionSingleLineRuleEClass, PARTITION_SINGLE_LINE_RULE__PARITION);
    createEAttribute(partitionSingleLineRuleEClass, PARTITION_SINGLE_LINE_RULE__START_SEQ);
    createEAttribute(partitionSingleLineRuleEClass, PARTITION_SINGLE_LINE_RULE__END_SEQ);
    createEAttribute(partitionSingleLineRuleEClass, PARTITION_SINGLE_LINE_RULE__ESCAPE_SEQ);

    scannerMultiLineRuleEClass = createEClass(SCANNER_MULTI_LINE_RULE);
    createEAttribute(scannerMultiLineRuleEClass, SCANNER_MULTI_LINE_RULE__START_SEQ);
    createEAttribute(scannerMultiLineRuleEClass, SCANNER_MULTI_LINE_RULE__END_SEQ);
    createEAttribute(scannerMultiLineRuleEClass, SCANNER_MULTI_LINE_RULE__ESCAPE_SEQ);

    partitionMultiLineRuleEClass = createEClass(PARTITION_MULTI_LINE_RULE);
    createEReference(partitionMultiLineRuleEClass, PARTITION_MULTI_LINE_RULE__PARITION);
    createEAttribute(partitionMultiLineRuleEClass, PARTITION_MULTI_LINE_RULE__START_SEQ);
    createEAttribute(partitionMultiLineRuleEClass, PARTITION_MULTI_LINE_RULE__END_SEQ);
    createEAttribute(partitionMultiLineRuleEClass, PARTITION_MULTI_LINE_RULE__ESCAPE_SEQ);

    scannerCharacterRuleEClass = createEClass(SCANNER_CHARACTER_RULE);
    createEAttribute(scannerCharacterRuleEClass, SCANNER_CHARACTER_RULE__CHARACTERS);

    scannerJSRuleEClass = createEClass(SCANNER_JS_RULE);
    createEAttribute(scannerJSRuleEClass, SCANNER_JS_RULE__FILE_URI);

    partitionJSRuleEClass = createEClass(PARTITION_JS_RULE);
    createEReference(partitionJSRuleEClass, PARTITION_JS_RULE__TOKEN);
    createEAttribute(partitionJSRuleEClass, PARTITION_JS_RULE__FILE_URI);

    scannerWhitespaceRuleEClass = createEClass(SCANNER_WHITESPACE_RULE);
    createEAttribute(scannerWhitespaceRuleEClass, SCANNER_WHITESPACE_RULE__CHARACTERS);
    createEAttribute(scannerWhitespaceRuleEClass, SCANNER_WHITESPACE_RULE__JAVAWHITESPACE);
    createEAttribute(scannerWhitespaceRuleEClass, SCANNER_WHITESPACE_RULE__FILE_URI);

    colorEClass = createEClass(COLOR);

    rgbColorEClass = createEClass(RGB_COLOR);
    createEAttribute(rgbColorEClass, RGB_COLOR__R);
    createEAttribute(rgbColorEClass, RGB_COLOR__G);
    createEAttribute(rgbColorEClass, RGB_COLOR__B);

    fontEClass = createEClass(FONT);
    createEAttribute(fontEClass, FONT__NAME);
    createEAttribute(fontEClass, FONT__SIZE);
    createEAttribute(fontEClass, FONT__ATTRIBUTES);

    // Create enums
    fontTypeEEnum = createEEnum(FONT_TYPE);
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
    javaLikeParitionerEClass.getESuperTypes().add(this.getPartitioner());
    rulePartitionerEClass.getESuperTypes().add(this.getPartitioner());
    jsParitionerEClass.getESuperTypes().add(this.getPartitioner());
    jsDamagerEClass.getESuperTypes().add(this.getDamager());
    ruleDamagerEClass.getESuperTypes().add(this.getDamager());
    scannerSingleLineRuleEClass.getESuperTypes().add(this.getScannerRule());
    partitionSingleLineRuleEClass.getESuperTypes().add(this.getParitionRule());
    scannerMultiLineRuleEClass.getESuperTypes().add(this.getScannerRule());
    partitionMultiLineRuleEClass.getESuperTypes().add(this.getParitionRule());
    scannerCharacterRuleEClass.getESuperTypes().add(this.getScannerRule());
    scannerJSRuleEClass.getESuperTypes().add(this.getScannerRule());
    partitionJSRuleEClass.getESuperTypes().add(this.getParitionRule());
    scannerWhitespaceRuleEClass.getESuperTypes().add(this.getScannerRule());
    rgbColorEClass.getESuperTypes().add(this.getColor());

    // Initialize classes and features; add operations and parameters
    initEClass(modelEClass, Model.class, "Model", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getModel_Name(), ecorePackage.getEString(), "name", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModel_Partitions(), this.getPartition(), null, "partitions", null, 0, -1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModel_Damagers(), this.getDamager(), null, "damagers", null, 0, -1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModel_Partitioner(), this.getPartitioner(), null, "partitioner", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getModel_ContentTypes(), ecorePackage.getEString(), "contentTypes", null, 0, -1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(partitionEClass, Partition.class, "Partition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getPartition_Name(), ecorePackage.getEString(), "name", null, 0, 1, Partition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(partitionerEClass, Partitioner.class, "Partitioner", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(javaLikeParitionerEClass, JavaLikeParitioner.class, "JavaLikeParitioner", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getJavaLikeParitioner_SingleLineDocParition(), this.getPartition(), null, "singleLineDocParition", null, 0, 1, JavaLikeParitioner.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getJavaLikeParitioner_MultiLineDocParition(), this.getPartition(), null, "multiLineDocParition", null, 0, 1, JavaLikeParitioner.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getJavaLikeParitioner_JavaDocParition(), this.getPartition(), null, "javaDocParition", null, 0, 1, JavaLikeParitioner.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getJavaLikeParitioner_CharacterParition(), this.getPartition(), null, "characterParition", null, 0, 1, JavaLikeParitioner.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getJavaLikeParitioner_StringParition(), this.getPartition(), null, "stringParition", null, 0, 1, JavaLikeParitioner.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(rulePartitionerEClass, RulePartitioner.class, "RulePartitioner", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRulePartitioner_Rules(), this.getParitionRule(), null, "rules", null, 0, -1, RulePartitioner.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(jsParitionerEClass, JSParitioner.class, "JSParitioner", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getJSParitioner_FileURI(), ecorePackage.getEString(), "fileURI", null, 0, 1, JSParitioner.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(damagerEClass, Damager.class, "Damager", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getDamager_Partition(), this.getPartition(), null, "partition", null, 0, 1, Damager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(jsDamagerEClass, JSDamager.class, "JSDamager", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getJSDamager_FileURI(), ecorePackage.getEString(), "fileURI", null, 0, 1, JSDamager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(ruleDamagerEClass, RuleDamager.class, "RuleDamager", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRuleDamager_Tokens(), this.getScannerToken(), null, "tokens", null, 0, -1, RuleDamager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRuleDamager_KeywordGroups(), this.getKeywordGroup(), null, "keywordGroups", null, 0, -1, RuleDamager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRuleDamager_Rules(), this.getScannerRule(), null, "rules", null, 0, -1, RuleDamager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(scannerTokenEClass, ScannerToken.class, "ScannerToken", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getScannerToken_Default(), ecorePackage.getEBoolean(), "default", null, 0, 1, ScannerToken.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getScannerToken_Name(), ecorePackage.getEString(), "name", null, 0, 1, ScannerToken.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getScannerToken_FgColor(), this.getColor(), null, "fgColor", null, 0, 1, ScannerToken.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getScannerToken_BgColor(), this.getColor(), null, "bgColor", null, 0, 1, ScannerToken.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getScannerToken_Font(), this.getFont(), null, "font", null, 0, 1, ScannerToken.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(keywordGroupEClass, KeywordGroup.class, "KeywordGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getKeywordGroup_Token(), this.getScannerToken(), null, "token", null, 0, 1, KeywordGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getKeywordGroup_Keywords(), this.getKeyword(), null, "keywords", null, 0, -1, KeywordGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(keywordEClass, Keyword.class, "Keyword", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getKeyword_Name(), ecorePackage.getEString(), "name", null, 0, 1, Keyword.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getKeyword_Version(), ecorePackage.getEString(), "version", null, 0, 1, Keyword.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(scannerRuleEClass, ScannerRule.class, "ScannerRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getScannerRule_Token(), this.getScannerToken(), null, "token", null, 0, 1, ScannerRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(paritionRuleEClass, ParitionRule.class, "ParitionRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(scannerSingleLineRuleEClass, ScannerSingleLineRule.class, "ScannerSingleLineRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getScannerSingleLineRule_StartSeq(), ecorePackage.getEString(), "startSeq", null, 0, 1, ScannerSingleLineRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getScannerSingleLineRule_EndSeq(), ecorePackage.getEString(), "endSeq", null, 0, 1, ScannerSingleLineRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getScannerSingleLineRule_EscapeSeq(), ecorePackage.getEString(), "escapeSeq", null, 0, 1, ScannerSingleLineRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(partitionSingleLineRuleEClass, PartitionSingleLineRule.class, "PartitionSingleLineRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getPartitionSingleLineRule_Parition(), this.getPartition(), null, "parition", null, 0, 1, PartitionSingleLineRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getPartitionSingleLineRule_StartSeq(), ecorePackage.getEString(), "startSeq", null, 0, 1, PartitionSingleLineRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getPartitionSingleLineRule_EndSeq(), ecorePackage.getEString(), "endSeq", null, 0, 1, PartitionSingleLineRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getPartitionSingleLineRule_EscapeSeq(), ecorePackage.getEString(), "escapeSeq", null, 0, 1, PartitionSingleLineRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(scannerMultiLineRuleEClass, ScannerMultiLineRule.class, "ScannerMultiLineRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getScannerMultiLineRule_StartSeq(), ecorePackage.getEString(), "startSeq", null, 0, 1, ScannerMultiLineRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getScannerMultiLineRule_EndSeq(), ecorePackage.getEString(), "endSeq", null, 0, 1, ScannerMultiLineRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getScannerMultiLineRule_EscapeSeq(), ecorePackage.getEString(), "escapeSeq", null, 0, 1, ScannerMultiLineRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(partitionMultiLineRuleEClass, PartitionMultiLineRule.class, "PartitionMultiLineRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getPartitionMultiLineRule_Parition(), this.getPartition(), null, "parition", null, 0, 1, PartitionMultiLineRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getPartitionMultiLineRule_StartSeq(), ecorePackage.getEString(), "startSeq", null, 0, 1, PartitionMultiLineRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getPartitionMultiLineRule_EndSeq(), ecorePackage.getEString(), "endSeq", null, 0, 1, PartitionMultiLineRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getPartitionMultiLineRule_EscapeSeq(), ecorePackage.getEString(), "escapeSeq", null, 0, 1, PartitionMultiLineRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(scannerCharacterRuleEClass, ScannerCharacterRule.class, "ScannerCharacterRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getScannerCharacterRule_Characters(), ecorePackage.getEString(), "characters", null, 0, -1, ScannerCharacterRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(scannerJSRuleEClass, ScannerJSRule.class, "ScannerJSRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getScannerJSRule_FileURI(), ecorePackage.getEString(), "fileURI", null, 0, 1, ScannerJSRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(partitionJSRuleEClass, PartitionJSRule.class, "PartitionJSRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getPartitionJSRule_Token(), this.getPartition(), null, "token", null, 0, 1, PartitionJSRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getPartitionJSRule_FileURI(), ecorePackage.getEString(), "fileURI", null, 0, 1, PartitionJSRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(scannerWhitespaceRuleEClass, ScannerWhitespaceRule.class, "ScannerWhitespaceRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getScannerWhitespaceRule_Characters(), ecorePackage.getEString(), "characters", null, 0, -1, ScannerWhitespaceRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getScannerWhitespaceRule_Javawhitespace(), ecorePackage.getEBoolean(), "javawhitespace", null, 0, 1, ScannerWhitespaceRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getScannerWhitespaceRule_FileURI(), ecorePackage.getEString(), "fileURI", null, 0, 1, ScannerWhitespaceRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(colorEClass, Color.class, "Color", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(rgbColorEClass, RGBColor.class, "RGBColor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getRGBColor_R(), ecorePackage.getEInt(), "r", null, 0, 1, RGBColor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRGBColor_G(), ecorePackage.getEInt(), "g", null, 0, 1, RGBColor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRGBColor_B(), ecorePackage.getEInt(), "b", null, 0, 1, RGBColor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(fontEClass, Font.class, "Font", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getFont_Name(), ecorePackage.getEString(), "name", null, 0, 1, Font.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getFont_Size(), ecorePackage.getEInt(), "size", null, 0, 1, Font.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getFont_Attributes(), this.getFontType(), "attributes", null, 0, -1, Font.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Initialize enums and add enum literals
    initEEnum(fontTypeEEnum, FontType.class, "FontType");
    addEEnumLiteral(fontTypeEEnum, FontType.BOLD);
    addEEnumLiteral(fontTypeEEnum, FontType.ITALIC);
    addEEnumLiteral(fontTypeEEnum, FontType.UNDERLINE);
    addEEnumLiteral(fontTypeEEnum, FontType.STRIKE_THROUGH);

    // Create resource
    createResource(eNS_URI);
  }

} //HSLPackageImpl
