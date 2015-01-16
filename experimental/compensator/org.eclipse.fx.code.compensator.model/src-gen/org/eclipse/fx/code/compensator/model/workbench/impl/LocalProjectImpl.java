/**
 */
package org.eclipse.fx.code.compensator.model.workbench.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.fx.code.compensator.model.workbench.LocalProject;
import org.eclipse.fx.code.compensator.model.workbench.VCSRepository;
import org.eclipse.fx.code.compensator.model.workbench.WorkbenchPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Local Project</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.fx.code.compensator.model.workbench.impl.LocalProjectImpl#getVcsRepositoryList <em>Vcs Repository List</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LocalProjectImpl extends ProjectImpl implements LocalProject {
	/**
	 * The cached value of the '{@link #getVcsRepositoryList() <em>Vcs Repository List</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVcsRepositoryList()
	 * @generated
	 * @ordered
	 */
	protected EList<VCSRepository> vcsRepositoryList;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LocalProjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WorkbenchPackage.Literals.LOCAL_PROJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VCSRepository> getVcsRepositoryList() {
		if (vcsRepositoryList == null) {
			vcsRepositoryList = new EObjectContainmentEList<VCSRepository>(VCSRepository.class, this, WorkbenchPackage.LOCAL_PROJECT__VCS_REPOSITORY_LIST);
		}
		return vcsRepositoryList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WorkbenchPackage.LOCAL_PROJECT__VCS_REPOSITORY_LIST:
				return ((InternalEList<?>)getVcsRepositoryList()).basicRemove(otherEnd, msgs);
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
			case WorkbenchPackage.LOCAL_PROJECT__VCS_REPOSITORY_LIST:
				return getVcsRepositoryList();
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
			case WorkbenchPackage.LOCAL_PROJECT__VCS_REPOSITORY_LIST:
				getVcsRepositoryList().clear();
				getVcsRepositoryList().addAll((Collection<? extends VCSRepository>)newValue);
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
			case WorkbenchPackage.LOCAL_PROJECT__VCS_REPOSITORY_LIST:
				getVcsRepositoryList().clear();
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
			case WorkbenchPackage.LOCAL_PROJECT__VCS_REPOSITORY_LIST:
				return vcsRepositoryList != null && !vcsRepositoryList.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //LocalProjectImpl
