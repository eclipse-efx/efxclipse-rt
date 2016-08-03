/*******************************************************************************
 * Copyright (c) 2016 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.emf.databinding;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;

/**
 * Base interface for an adapted eobject
 *
 * @param <O>
 *            the owner type
 */
public interface EFXObject<O extends EObject> {
	/**
	 * Get an {@link ObjectProperty}
	 *
	 * @param type
	 *            the type
	 *
	 * @param feature
	 *            the feature
	 * @return the property
	 * @throws IllegalArgumentException
	 *             if the feature describes a primitive value like int.class,
	 *             boolean.class
	 */
	public <T> ObjectProperty<T> getObjectProperty(Class<T> type, EStructuralFeature feature);

	/**
	 * Get an integer property
	 *
	 * @param feature
	 *            the feature
	 * @return the integer property
	 * @throws IllegalArgumentException
	 *             if the feature does not describe an int.class type
	 */
	public IntegerProperty getIntegerProperty(EStructuralFeature feature);

	/**
	 * Get a double property
	 *
	 * @param feature
	 *            the feature
	 * @return the double property
	 * @throws IllegalArgumentException
	 *             if the feature does not describe an double.class type
	 */
	public DoubleProperty getDoubleProperty(EStructuralFeature feature);

	/**
	 * Get a string property
	 *
	 * @param feature
	 *            the feature
	 * @return the string property
	 * @throws IllegalArgumentException
	 *             if the feature does not describe an String.class type
	 */
	public StringProperty getStringProperty(EStructuralFeature feature);

	/**
	 * Get a float property
	 *
	 * @param feature
	 *            the feature
	 * @return the float property
	 * @throws IllegalArgumentException
	 *             if the feature does not describe an float.class type
	 */
	public FloatProperty getFloatProperty(EStructuralFeature feature);

	/**
	 * Get a boolean property
	 *
	 * @param feature
	 *            the feature
	 * @return the boolean property
	 * @throws IllegalArgumentException
	 *             if the feature does not describe an boolean.class type
	 */
	public BooleanProperty getBooleanProperty(EStructuralFeature feature);

	/**
	 * Get a long property
	 *
	 * @param feature
	 *            the feature
	 * @return the long property
	 * @throws IllegalArgumentException
	 *             if the feature does not describe an long.class type
	 */
	public LongProperty getLongProperty(EStructuralFeature feature);
}
