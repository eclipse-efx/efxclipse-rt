/**
 */
package org.eclipse.fx.code.editor.ldef.lDef.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.fx.code.editor.ldef.lDef.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.fx.code.editor.ldef.lDef.LDefPackage
 * @generated
 */
public class LDefAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static LDefPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LDefAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = LDefPackage.eINSTANCE;
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
  protected LDefSwitch<Adapter> modelSwitch =
    new LDefSwitch<Adapter>()
    {
      @Override
      public Adapter caseRoot(Root object)
      {
        return createRootAdapter();
      }
      @Override
      public Adapter caseImport(Import object)
      {
        return createImportAdapter();
      }
      @Override
      public Adapter caseLanguageDef(LanguageDef object)
      {
        return createLanguageDefAdapter();
      }
      @Override
      public Adapter caseIntegration(Integration object)
      {
        return createIntegrationAdapter();
      }
      @Override
      public Adapter caseCodeIntegration(CodeIntegration object)
      {
        return createCodeIntegrationAdapter();
      }
      @Override
      public Adapter caseJavaFXIntegration(JavaFXIntegration object)
      {
        return createJavaFXIntegrationAdapter();
      }
      @Override
      public Adapter caseCodegeneration(Codegeneration object)
      {
        return createCodegenerationAdapter();
      }
      @Override
      public Adapter caseJavaCodeGeneration(JavaCodeGeneration object)
      {
        return createJavaCodeGenerationAdapter();
      }
      @Override
      public Adapter caseE4CodeGeneration(E4CodeGeneration object)
      {
        return createE4CodeGenerationAdapter();
      }
      @Override
      public Adapter caseConfigValue(ConfigValue object)
      {
        return createConfigValueAdapter();
      }
      @Override
      public Adapter caseParitioning(Paritioning object)
      {
        return createParitioningAdapter();
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
      public Adapter caseParitioner_JS(Paritioner_JS object)
      {
        return createParitioner_JSAdapter();
      }
      @Override
      public Adapter casePartitioner_Rule(Partitioner_Rule object)
      {
        return createPartitioner_RuleAdapter();
      }
      @Override
      public Adapter casePartition_Rule(Partition_Rule object)
      {
        return createPartition_RuleAdapter();
      }
      @Override
      public Adapter casePartition_SingleLineRule(Partition_SingleLineRule object)
      {
        return createPartition_SingleLineRuleAdapter();
      }
      @Override
      public Adapter casePartition_MultiLineRule(Partition_MultiLineRule object)
      {
        return createPartition_MultiLineRuleAdapter();
      }
      @Override
      public Adapter caseLexicalHighlighting(LexicalHighlighting object)
      {
        return createLexicalHighlightingAdapter();
      }
      @Override
      public Adapter caseLexicalPartitionHighlighting(LexicalPartitionHighlighting object)
      {
        return createLexicalPartitionHighlightingAdapter();
      }
      @Override
      public Adapter caseLexicalPartitionHighlighting_JS(LexicalPartitionHighlighting_JS object)
      {
        return createLexicalPartitionHighlighting_JSAdapter();
      }
      @Override
      public Adapter caseLexicalPartitionHighlighting_Rule(LexicalPartitionHighlighting_Rule object)
      {
        return createLexicalPartitionHighlighting_RuleAdapter();
      }
      @Override
      public Adapter caseToken(Token object)
      {
        return createTokenAdapter();
      }
      @Override
      public Adapter caseScanner(Scanner object)
      {
        return createScannerAdapter();
      }
      @Override
      public Adapter caseScanner_Keyword(Scanner_Keyword object)
      {
        return createScanner_KeywordAdapter();
      }
      @Override
      public Adapter caseKeyword(Keyword object)
      {
        return createKeywordAdapter();
      }
      @Override
      public Adapter caseScanner_Rule(Scanner_Rule object)
      {
        return createScanner_RuleAdapter();
      }
      @Override
      public Adapter caseScanner_SingleLineRule(Scanner_SingleLineRule object)
      {
        return createScanner_SingleLineRuleAdapter();
      }
      @Override
      public Adapter caseScanner_MultiLineRule(Scanner_MultiLineRule object)
      {
        return createScanner_MultiLineRuleAdapter();
      }
      @Override
      public Adapter caseScanner_PatternRule(Scanner_PatternRule object)
      {
        return createScanner_PatternRuleAdapter();
      }
      @Override
      public Adapter caseScanner_CharacterRule(Scanner_CharacterRule object)
      {
        return createScanner_CharacterRuleAdapter();
      }
      @Override
      public Adapter caseScanner_JSRule(Scanner_JSRule object)
      {
        return createScanner_JSRuleAdapter();
      }
      @Override
      public Adapter caseWhitespaceRule(WhitespaceRule object)
      {
        return createWhitespaceRuleAdapter();
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
   * Creates a new adapter for an object of class '{@link org.eclipse.fx.code.editor.ldef.lDef.Root <em>Root</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fx.code.editor.ldef.lDef.Root
   * @generated
   */
  public Adapter createRootAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fx.code.editor.ldef.lDef.Import <em>Import</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fx.code.editor.ldef.lDef.Import
   * @generated
   */
  public Adapter createImportAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fx.code.editor.ldef.lDef.LanguageDef <em>Language Def</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fx.code.editor.ldef.lDef.LanguageDef
   * @generated
   */
  public Adapter createLanguageDefAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fx.code.editor.ldef.lDef.Integration <em>Integration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fx.code.editor.ldef.lDef.Integration
   * @generated
   */
  public Adapter createIntegrationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fx.code.editor.ldef.lDef.CodeIntegration <em>Code Integration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fx.code.editor.ldef.lDef.CodeIntegration
   * @generated
   */
  public Adapter createCodeIntegrationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fx.code.editor.ldef.lDef.JavaFXIntegration <em>Java FX Integration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fx.code.editor.ldef.lDef.JavaFXIntegration
   * @generated
   */
  public Adapter createJavaFXIntegrationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fx.code.editor.ldef.lDef.Codegeneration <em>Codegeneration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fx.code.editor.ldef.lDef.Codegeneration
   * @generated
   */
  public Adapter createCodegenerationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fx.code.editor.ldef.lDef.JavaCodeGeneration <em>Java Code Generation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fx.code.editor.ldef.lDef.JavaCodeGeneration
   * @generated
   */
  public Adapter createJavaCodeGenerationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fx.code.editor.ldef.lDef.E4CodeGeneration <em>E4 Code Generation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fx.code.editor.ldef.lDef.E4CodeGeneration
   * @generated
   */
  public Adapter createE4CodeGenerationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fx.code.editor.ldef.lDef.ConfigValue <em>Config Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fx.code.editor.ldef.lDef.ConfigValue
   * @generated
   */
  public Adapter createConfigValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fx.code.editor.ldef.lDef.Paritioning <em>Paritioning</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fx.code.editor.ldef.lDef.Paritioning
   * @generated
   */
  public Adapter createParitioningAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fx.code.editor.ldef.lDef.Partition <em>Partition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fx.code.editor.ldef.lDef.Partition
   * @generated
   */
  public Adapter createPartitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fx.code.editor.ldef.lDef.Partitioner <em>Partitioner</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fx.code.editor.ldef.lDef.Partitioner
   * @generated
   */
  public Adapter createPartitionerAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fx.code.editor.ldef.lDef.Paritioner_JS <em>Paritioner JS</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fx.code.editor.ldef.lDef.Paritioner_JS
   * @generated
   */
  public Adapter createParitioner_JSAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fx.code.editor.ldef.lDef.Partitioner_Rule <em>Partitioner Rule</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fx.code.editor.ldef.lDef.Partitioner_Rule
   * @generated
   */
  public Adapter createPartitioner_RuleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fx.code.editor.ldef.lDef.Partition_Rule <em>Partition Rule</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fx.code.editor.ldef.lDef.Partition_Rule
   * @generated
   */
  public Adapter createPartition_RuleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fx.code.editor.ldef.lDef.Partition_SingleLineRule <em>Partition Single Line Rule</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fx.code.editor.ldef.lDef.Partition_SingleLineRule
   * @generated
   */
  public Adapter createPartition_SingleLineRuleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fx.code.editor.ldef.lDef.Partition_MultiLineRule <em>Partition Multi Line Rule</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fx.code.editor.ldef.lDef.Partition_MultiLineRule
   * @generated
   */
  public Adapter createPartition_MultiLineRuleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fx.code.editor.ldef.lDef.LexicalHighlighting <em>Lexical Highlighting</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fx.code.editor.ldef.lDef.LexicalHighlighting
   * @generated
   */
  public Adapter createLexicalHighlightingAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fx.code.editor.ldef.lDef.LexicalPartitionHighlighting <em>Lexical Partition Highlighting</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fx.code.editor.ldef.lDef.LexicalPartitionHighlighting
   * @generated
   */
  public Adapter createLexicalPartitionHighlightingAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fx.code.editor.ldef.lDef.LexicalPartitionHighlighting_JS <em>Lexical Partition Highlighting JS</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fx.code.editor.ldef.lDef.LexicalPartitionHighlighting_JS
   * @generated
   */
  public Adapter createLexicalPartitionHighlighting_JSAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fx.code.editor.ldef.lDef.LexicalPartitionHighlighting_Rule <em>Lexical Partition Highlighting Rule</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fx.code.editor.ldef.lDef.LexicalPartitionHighlighting_Rule
   * @generated
   */
  public Adapter createLexicalPartitionHighlighting_RuleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fx.code.editor.ldef.lDef.Token <em>Token</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fx.code.editor.ldef.lDef.Token
   * @generated
   */
  public Adapter createTokenAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fx.code.editor.ldef.lDef.Scanner <em>Scanner</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fx.code.editor.ldef.lDef.Scanner
   * @generated
   */
  public Adapter createScannerAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fx.code.editor.ldef.lDef.Scanner_Keyword <em>Scanner Keyword</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fx.code.editor.ldef.lDef.Scanner_Keyword
   * @generated
   */
  public Adapter createScanner_KeywordAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fx.code.editor.ldef.lDef.Keyword <em>Keyword</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fx.code.editor.ldef.lDef.Keyword
   * @generated
   */
  public Adapter createKeywordAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fx.code.editor.ldef.lDef.Scanner_Rule <em>Scanner Rule</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fx.code.editor.ldef.lDef.Scanner_Rule
   * @generated
   */
  public Adapter createScanner_RuleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fx.code.editor.ldef.lDef.Scanner_SingleLineRule <em>Scanner Single Line Rule</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fx.code.editor.ldef.lDef.Scanner_SingleLineRule
   * @generated
   */
  public Adapter createScanner_SingleLineRuleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fx.code.editor.ldef.lDef.Scanner_MultiLineRule <em>Scanner Multi Line Rule</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fx.code.editor.ldef.lDef.Scanner_MultiLineRule
   * @generated
   */
  public Adapter createScanner_MultiLineRuleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fx.code.editor.ldef.lDef.Scanner_PatternRule <em>Scanner Pattern Rule</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fx.code.editor.ldef.lDef.Scanner_PatternRule
   * @generated
   */
  public Adapter createScanner_PatternRuleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fx.code.editor.ldef.lDef.Scanner_CharacterRule <em>Scanner Character Rule</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fx.code.editor.ldef.lDef.Scanner_CharacterRule
   * @generated
   */
  public Adapter createScanner_CharacterRuleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fx.code.editor.ldef.lDef.Scanner_JSRule <em>Scanner JS Rule</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fx.code.editor.ldef.lDef.Scanner_JSRule
   * @generated
   */
  public Adapter createScanner_JSRuleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fx.code.editor.ldef.lDef.WhitespaceRule <em>Whitespace Rule</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fx.code.editor.ldef.lDef.WhitespaceRule
   * @generated
   */
  public Adapter createWhitespaceRuleAdapter()
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

} //LDefAdapterFactory
