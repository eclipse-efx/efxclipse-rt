/**
 */
package org.eclipse.fx.code.compensator.hsl.hSL.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.fx.code.compensator.hsl.hSL.HSLPackage;
import org.eclipse.fx.code.compensator.hsl.hSL.JavaLikeParitioner;
import org.eclipse.fx.code.compensator.hsl.hSL.Partition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Java Like Paritioner</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.fx.code.compensator.hsl.hSL.impl.JavaLikeParitionerImpl#getSingleLineParition <em>Single Line Parition</em>}</li>
 *   <li>{@link org.eclipse.fx.code.compensator.hsl.hSL.impl.JavaLikeParitionerImpl#getMultiLineParition <em>Multi Line Parition</em>}</li>
 *   <li>{@link org.eclipse.fx.code.compensator.hsl.hSL.impl.JavaLikeParitionerImpl#getJavaDocParition <em>Java Doc Parition</em>}</li>
 *   <li>{@link org.eclipse.fx.code.compensator.hsl.hSL.impl.JavaLikeParitionerImpl#getCharacterParition <em>Character Parition</em>}</li>
 *   <li>{@link org.eclipse.fx.code.compensator.hsl.hSL.impl.JavaLikeParitionerImpl#getStringParition <em>String Parition</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class JavaLikeParitionerImpl extends PartitionerImpl implements JavaLikeParitioner
{
  /**
   * The cached value of the '{@link #getSingleLineParition() <em>Single Line Parition</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSingleLineParition()
   * @generated
   * @ordered
   */
  protected Partition singleLineParition;

  /**
   * The cached value of the '{@link #getMultiLineParition() <em>Multi Line Parition</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMultiLineParition()
   * @generated
   * @ordered
   */
  protected Partition multiLineParition;

  /**
   * The cached value of the '{@link #getJavaDocParition() <em>Java Doc Parition</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getJavaDocParition()
   * @generated
   * @ordered
   */
  protected Partition javaDocParition;

  /**
   * The cached value of the '{@link #getCharacterParition() <em>Character Parition</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCharacterParition()
   * @generated
   * @ordered
   */
  protected Partition characterParition;

  /**
   * The cached value of the '{@link #getStringParition() <em>String Parition</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStringParition()
   * @generated
   * @ordered
   */
  protected Partition stringParition;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected JavaLikeParitionerImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return HSLPackage.Literals.JAVA_LIKE_PARITIONER;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Partition getSingleLineParition()
  {
    if (singleLineParition != null && singleLineParition.eIsProxy())
    {
      InternalEObject oldSingleLineParition = (InternalEObject)singleLineParition;
      singleLineParition = (Partition)eResolveProxy(oldSingleLineParition);
      if (singleLineParition != oldSingleLineParition)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, HSLPackage.JAVA_LIKE_PARITIONER__SINGLE_LINE_PARITION, oldSingleLineParition, singleLineParition));
      }
    }
    return singleLineParition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Partition basicGetSingleLineParition()
  {
    return singleLineParition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSingleLineParition(Partition newSingleLineParition)
  {
    Partition oldSingleLineParition = singleLineParition;
    singleLineParition = newSingleLineParition;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, HSLPackage.JAVA_LIKE_PARITIONER__SINGLE_LINE_PARITION, oldSingleLineParition, singleLineParition));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Partition getMultiLineParition()
  {
    if (multiLineParition != null && multiLineParition.eIsProxy())
    {
      InternalEObject oldMultiLineParition = (InternalEObject)multiLineParition;
      multiLineParition = (Partition)eResolveProxy(oldMultiLineParition);
      if (multiLineParition != oldMultiLineParition)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, HSLPackage.JAVA_LIKE_PARITIONER__MULTI_LINE_PARITION, oldMultiLineParition, multiLineParition));
      }
    }
    return multiLineParition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Partition basicGetMultiLineParition()
  {
    return multiLineParition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMultiLineParition(Partition newMultiLineParition)
  {
    Partition oldMultiLineParition = multiLineParition;
    multiLineParition = newMultiLineParition;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, HSLPackage.JAVA_LIKE_PARITIONER__MULTI_LINE_PARITION, oldMultiLineParition, multiLineParition));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Partition getJavaDocParition()
  {
    if (javaDocParition != null && javaDocParition.eIsProxy())
    {
      InternalEObject oldJavaDocParition = (InternalEObject)javaDocParition;
      javaDocParition = (Partition)eResolveProxy(oldJavaDocParition);
      if (javaDocParition != oldJavaDocParition)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, HSLPackage.JAVA_LIKE_PARITIONER__JAVA_DOC_PARITION, oldJavaDocParition, javaDocParition));
      }
    }
    return javaDocParition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Partition basicGetJavaDocParition()
  {
    return javaDocParition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setJavaDocParition(Partition newJavaDocParition)
  {
    Partition oldJavaDocParition = javaDocParition;
    javaDocParition = newJavaDocParition;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, HSLPackage.JAVA_LIKE_PARITIONER__JAVA_DOC_PARITION, oldJavaDocParition, javaDocParition));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Partition getCharacterParition()
  {
    if (characterParition != null && characterParition.eIsProxy())
    {
      InternalEObject oldCharacterParition = (InternalEObject)characterParition;
      characterParition = (Partition)eResolveProxy(oldCharacterParition);
      if (characterParition != oldCharacterParition)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, HSLPackage.JAVA_LIKE_PARITIONER__CHARACTER_PARITION, oldCharacterParition, characterParition));
      }
    }
    return characterParition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Partition basicGetCharacterParition()
  {
    return characterParition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCharacterParition(Partition newCharacterParition)
  {
    Partition oldCharacterParition = characterParition;
    characterParition = newCharacterParition;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, HSLPackage.JAVA_LIKE_PARITIONER__CHARACTER_PARITION, oldCharacterParition, characterParition));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Partition getStringParition()
  {
    if (stringParition != null && stringParition.eIsProxy())
    {
      InternalEObject oldStringParition = (InternalEObject)stringParition;
      stringParition = (Partition)eResolveProxy(oldStringParition);
      if (stringParition != oldStringParition)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, HSLPackage.JAVA_LIKE_PARITIONER__STRING_PARITION, oldStringParition, stringParition));
      }
    }
    return stringParition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Partition basicGetStringParition()
  {
    return stringParition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStringParition(Partition newStringParition)
  {
    Partition oldStringParition = stringParition;
    stringParition = newStringParition;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, HSLPackage.JAVA_LIKE_PARITIONER__STRING_PARITION, oldStringParition, stringParition));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case HSLPackage.JAVA_LIKE_PARITIONER__SINGLE_LINE_PARITION:
        if (resolve) return getSingleLineParition();
        return basicGetSingleLineParition();
      case HSLPackage.JAVA_LIKE_PARITIONER__MULTI_LINE_PARITION:
        if (resolve) return getMultiLineParition();
        return basicGetMultiLineParition();
      case HSLPackage.JAVA_LIKE_PARITIONER__JAVA_DOC_PARITION:
        if (resolve) return getJavaDocParition();
        return basicGetJavaDocParition();
      case HSLPackage.JAVA_LIKE_PARITIONER__CHARACTER_PARITION:
        if (resolve) return getCharacterParition();
        return basicGetCharacterParition();
      case HSLPackage.JAVA_LIKE_PARITIONER__STRING_PARITION:
        if (resolve) return getStringParition();
        return basicGetStringParition();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case HSLPackage.JAVA_LIKE_PARITIONER__SINGLE_LINE_PARITION:
        setSingleLineParition((Partition)newValue);
        return;
      case HSLPackage.JAVA_LIKE_PARITIONER__MULTI_LINE_PARITION:
        setMultiLineParition((Partition)newValue);
        return;
      case HSLPackage.JAVA_LIKE_PARITIONER__JAVA_DOC_PARITION:
        setJavaDocParition((Partition)newValue);
        return;
      case HSLPackage.JAVA_LIKE_PARITIONER__CHARACTER_PARITION:
        setCharacterParition((Partition)newValue);
        return;
      case HSLPackage.JAVA_LIKE_PARITIONER__STRING_PARITION:
        setStringParition((Partition)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case HSLPackage.JAVA_LIKE_PARITIONER__SINGLE_LINE_PARITION:
        setSingleLineParition((Partition)null);
        return;
      case HSLPackage.JAVA_LIKE_PARITIONER__MULTI_LINE_PARITION:
        setMultiLineParition((Partition)null);
        return;
      case HSLPackage.JAVA_LIKE_PARITIONER__JAVA_DOC_PARITION:
        setJavaDocParition((Partition)null);
        return;
      case HSLPackage.JAVA_LIKE_PARITIONER__CHARACTER_PARITION:
        setCharacterParition((Partition)null);
        return;
      case HSLPackage.JAVA_LIKE_PARITIONER__STRING_PARITION:
        setStringParition((Partition)null);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case HSLPackage.JAVA_LIKE_PARITIONER__SINGLE_LINE_PARITION:
        return singleLineParition != null;
      case HSLPackage.JAVA_LIKE_PARITIONER__MULTI_LINE_PARITION:
        return multiLineParition != null;
      case HSLPackage.JAVA_LIKE_PARITIONER__JAVA_DOC_PARITION:
        return javaDocParition != null;
      case HSLPackage.JAVA_LIKE_PARITIONER__CHARACTER_PARITION:
        return characterParition != null;
      case HSLPackage.JAVA_LIKE_PARITIONER__STRING_PARITION:
        return stringParition != null;
    }
    return super.eIsSet(featureID);
  }

} //JavaLikeParitionerImpl
