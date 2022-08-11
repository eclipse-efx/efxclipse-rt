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
package org.eclipse.fx.code.compensator.model.workbench.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.fx.code.compensator.model.workbench.Module;
import org.eclipse.fx.code.compensator.model.workbench.ModuleContainer;
import org.eclipse.fx.code.compensator.model.workbench.WorkbenchPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Module Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.fx.code.compensator.model.workbench.impl.ModuleContainerImpl#getModuleList <em>Module List</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ModuleContainerImpl extends MinimalEObjectImpl.Container implements ModuleContainer {
	/**
	 * The cached value of the '{@link #getModuleList() <em>Module List</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModuleList()
	 * @generated
	 * @ordered
	 */
	protected EList<Module> moduleList;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModuleContainerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WorkbenchPackage.Literals.MODULE_CONTAINER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Module> getModuleList() {
		if (moduleList == null) {
			moduleList = new EObjectContainmentEList<Module>(Module.class, this, WorkbenchPackage.MODULE_CONTAINER__MODULE_LIST);
		}
		return moduleList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WorkbenchPackage.MODULE_CONTAINER__MODULE_LIST:
				return ((InternalEList<?>)getModuleList()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WorkbenchPackage.MODULE_CONTAINER__MODULE_LIST:
				return getModuleList();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case WorkbenchPackage.MODULE_CONTAINER__MODULE_LIST:
				getModuleList().clear();
				getModuleList().addAll((Collection<? extends Module>)newValue);
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
	public void eUnset(int featureID) {
		switch (featureID) {
			case WorkbenchPackage.MODULE_CONTAINER__MODULE_LIST:
				getModuleList().clear();
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
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case WorkbenchPackage.MODULE_CONTAINER__MODULE_LIST:
				return moduleList != null && !moduleList.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ModuleContainerImpl
