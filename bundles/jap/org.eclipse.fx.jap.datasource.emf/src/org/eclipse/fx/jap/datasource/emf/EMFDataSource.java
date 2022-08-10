/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.jap.datasource.emf;

import org.eclipse.core.databinding.property.list.IListProperty;
import org.eclipse.core.databinding.property.value.IValueProperty;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.fx.jap.datasource.DataSource;

public interface EMFDataSource extends DataSource {
	public IValueProperty createObservableValue(EStructuralFeature... propertyPath);
	
	public IListProperty createObservableList(EStructuralFeature... propertyPath);
	
	public void setPropertyValue(Object owner, Object value, EStructuralFeature... propertyPath);
	
	public void addPropertyValue(Object owner, Object value, EStructuralFeature... propertyPath);
	
	public void removePropertyValue(Object owner, Object value, EStructuralFeature... propertyPath);
}
