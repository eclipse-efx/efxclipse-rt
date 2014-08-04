/**
 */
package org.eclipse.fx.code.compensator.hsl.hSL.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.fx.code.compensator.hsl.hSL.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.fx.code.compensator.hsl.hSL.HSLPackage
 * @generated
 */
public class HSLAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static HSLPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public HSLAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = HSLPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected HSLSwitch<Adapter> modelSwitch =
    new HSLSwitch<Adapter>()
    {
      @Override
      public Adapter caseModel(Model object)
      {
        return createModelAdapter();
      }
      @Override
      public Adapter casePartition(Partition object)
      {
        return createPartitionAdapter();
      }
      @Override
      public Adapter casePartitioner(Partitioner object)
      {
        return createPartitionerAdapter();
      }
      @Override
      public Adapter caseJavaLikeParitioner(JavaLikeParitioner object)
      {
        return createJavaLikeParitionerAdapter();
      }
      @Override
      public Adapter caseRulePartitioner(RulePartitioner object)
      {
        return createRulePartitionerAdapter();
      }
      @Override
      public Adapter caseJSParitioner(JSParitioner object)
      {
        return createJSParitionerAdapter();
      }
      @Override
      public Adapter caseDamager(Damager object)
      {
        return createDamagerAdapter();
      }
      @Override
      public Adapter caseJSDamager(JSDamager object)
      {
        return createJSDamagerAdapter();
      }
      @Override
      public Adapter caseRuleDamager(RuleDamager object)
      {
        return createRuleDamagerAdapter();
      }
      @Override
      public Adapter caseScannerToken(ScannerToken object)
      {
        return createScannerTokenAdapter();
      }
      @Override
      public Adapter caseKeywordGroup(KeywordGroup object)
      {
        return createKeywordGroupAdapter();
      }
      @Override
      public Adapter caseKeyword(Keyword object)
      {
        return createKeywordAdapter();
      }
      @Override
      public Adapter caseScannerRule(ScannerRule object)
      {
        return createScannerRuleAdapter();
      }
      @Override
      public Adapter caseParitionRule(ParitionRule object)
      {
        return createParitionRuleAdapter();
      }
      @Override
      public Adapter caseScannerSingleLineRule(ScannerSingleLineRule object)
      {
        return createScannerSingleLineRuleAdapter();
      }
      @Override
      public Adapter casePartitionSingleLineRule(PartitionSingleLineRule object)
      {
        return createPartitionSingleLineRuleAdapter();
      }
      @Override
      public Adapter caseScannerMultiLineRule(ScannerMultiLineRule object)
      {
        return createScannerMultiLineRuleAdapter();
      }
      @Override
      public Adapter casePartitionMultiLineRule(PartitionMultiLineRule object)
      {
        return createPartitionMultiLineRuleAdapter();
      }
      @Override
      public Adapter caseScannerCharacterRule(ScannerCharacterRule object)
      {
        return createScannerCharacterRuleAdapter();
      }
      @Override
      public Adapter caseScannerJSRule(ScannerJSRule object)
      {
        return createScannerJSRuleAdapter();
      }
      @Override
      public Adapter casePartitionJSRule(PartitionJSRule object)
      {
        return createPartitionJSRuleAdapter();
      }
      @Override
      public Adapter caseScannerWhitespaceRule(ScannerWhitespaceRule object)
      {
        return createScannerWhitespaceRuleAdapter();
      }
      @Override
      public Adapter caseColor(Color object)
      {
        return createColorAdapter();
      }
      @Override
      public Adapter caseRGBColor(RGBColor object)
      {
        return createRGBColorAdapter();
      }
      @Override
      public Adapter caseFont(Font object)
      {
        return createFontAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fx.code.compensator.hsl.hSL.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.Model
   * @generated
   */
  public Adapter createModelAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fx.code.compensator.hsl.hSL.Partition <em>Partition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.Partition
   * @generated
   */
  public Adapter createPartitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fx.code.compensator.hsl.hSL.Partitioner <em>Partitioner</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.Partitioner
   * @generated
   */
  public Adapter createPartitionerAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fx.code.compensator.hsl.hSL.JavaLikeParitioner <em>Java Like Paritioner</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.JavaLikeParitioner
   * @generated
   */
  public Adapter createJavaLikeParitionerAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fx.code.compensator.hsl.hSL.RulePartitioner <em>Rule Partitioner</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.RulePartitioner
   * @generated
   */
  public Adapter createRulePartitionerAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fx.code.compensator.hsl.hSL.JSParitioner <em>JS Paritioner</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.JSParitioner
   * @generated
   */
  public Adapter createJSParitionerAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fx.code.compensator.hsl.hSL.Damager <em>Damager</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.Damager
   * @generated
   */
  public Adapter createDamagerAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fx.code.compensator.hsl.hSL.JSDamager <em>JS Damager</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.JSDamager
   * @generated
   */
  public Adapter createJSDamagerAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fx.code.compensator.hsl.hSL.RuleDamager <em>Rule Damager</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.RuleDamager
   * @generated
   */
  public Adapter createRuleDamagerAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fx.code.compensator.hsl.hSL.ScannerToken <em>Scanner Token</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.ScannerToken
   * @generated
   */
  public Adapter createScannerTokenAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fx.code.compensator.hsl.hSL.KeywordGroup <em>Keyword Group</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.KeywordGroup
   * @generated
   */
  public Adapter createKeywordGroupAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fx.code.compensator.hsl.hSL.Keyword <em>Keyword</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.Keyword
   * @generated
   */
  public Adapter createKeywordAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fx.code.compensator.hsl.hSL.ScannerRule <em>Scanner Rule</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.ScannerRule
   * @generated
   */
  public Adapter createScannerRuleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fx.code.compensator.hsl.hSL.ParitionRule <em>Parition Rule</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.ParitionRule
   * @generated
   */
  public Adapter createParitionRuleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fx.code.compensator.hsl.hSL.ScannerSingleLineRule <em>Scanner Single Line Rule</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.ScannerSingleLineRule
   * @generated
   */
  public Adapter createScannerSingleLineRuleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fx.code.compensator.hsl.hSL.PartitionSingleLineRule <em>Partition Single Line Rule</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.PartitionSingleLineRule
   * @generated
   */
  public Adapter createPartitionSingleLineRuleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fx.code.compensator.hsl.hSL.ScannerMultiLineRule <em>Scanner Multi Line Rule</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.ScannerMultiLineRule
   * @generated
   */
  public Adapter createScannerMultiLineRuleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fx.code.compensator.hsl.hSL.PartitionMultiLineRule <em>Partition Multi Line Rule</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.PartitionMultiLineRule
   * @generated
   */
  public Adapter createPartitionMultiLineRuleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fx.code.compensator.hsl.hSL.ScannerCharacterRule <em>Scanner Character Rule</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.ScannerCharacterRule
   * @generated
   */
  public Adapter createScannerCharacterRuleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fx.code.compensator.hsl.hSL.ScannerJSRule <em>Scanner JS Rule</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.ScannerJSRule
   * @generated
   */
  public Adapter createScannerJSRuleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fx.code.compensator.hsl.hSL.PartitionJSRule <em>Partition JS Rule</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.PartitionJSRule
   * @generated
   */
  public Adapter createPartitionJSRuleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fx.code.compensator.hsl.hSL.ScannerWhitespaceRule <em>Scanner Whitespace Rule</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.ScannerWhitespaceRule
   * @generated
   */
  public Adapter createScannerWhitespaceRuleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fx.code.compensator.hsl.hSL.Color <em>Color</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.Color
   * @generated
   */
  public Adapter createColorAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fx.code.compensator.hsl.hSL.RGBColor <em>RGB Color</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.RGBColor
   * @generated
   */
  public Adapter createRGBColorAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fx.code.compensator.hsl.hSL.Font <em>Font</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.Font
   * @generated
   */
  public Adapter createFontAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //HSLAdapterFactory
